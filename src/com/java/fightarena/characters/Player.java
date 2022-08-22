package com.java.fightarena.characters;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.java.fightarena.abstractions.Gun;
import com.java.fightarena.abstractions.MeleeWeapon;
import com.java.fightarena.abstractions.Weapon;
import com.java.fightarena.exceptions.FullSlotsException;
import com.java.fightarena.weapons.Axe;
import com.java.fightarena.weapons.MarksmanRifle;
import com.java.fightarena.weapons.Pistol;
import com.java.fightarena.weapons.Shotgun;
import com.java.fightarena.weapons.TacticalRifle;

public class Player {
	private String name;
	private int level;
	private Weapon currentWeapon; // Either a Gun or Melee Weapon
	private ArrayList<Weapon> weapons = new ArrayList<>(4); // Only 4 weapons may be carried at a time

	public Player() throws IOException { // tries to load or create player from console
		InputStream in = null;
		BufferedReader reader = null;
		try {
			in = new FileInputStream("gamestats.txt"); //format: <Name> <Level> <Current Weapon> <List Of Weapons>
			reader = new BufferedReader(new InputStreamReader(in));
			String[] playerStats = reader.readLine().split(",");
			String[] currentWeaponStats = reader.readLine().split(",");

			//GET PLAYER INFO
			this.name = playerStats[0];
			this.level = Integer.parseInt(playerStats[1]);

			//GET CURRENT WEAPON INFO
			if (currentWeaponStats[0].compareTo("Gun") == 0) {
				int currentWeaponBullets = Integer.parseInt(currentWeaponStats[3]);
				int currentWeaponCartridges = Integer.parseInt(currentWeaponStats[4]);
				switch(currentWeaponStats[1]) {
					case("Pistol"):
						this.currentWeapon = new Pistol(currentWeaponBullets, currentWeaponCartridges);
						break;
					case("MarksMan Rifle"):
						this.currentWeapon = new MarksmanRifle(currentWeaponBullets, currentWeaponCartridges);
						break;
					case("Shotgun"):
						this.currentWeapon = new Shotgun(currentWeaponBullets, currentWeaponCartridges);
						break;
					case("Tactical Rifle"):
						this.currentWeapon = new TacticalRifle(currentWeaponBullets, currentWeaponCartridges);
						break;
				}
			} else {
				switch(currentWeaponStats[1]) {
					case("Axe"):
						this.currentWeapon = new Axe();
						break;
				}
			}
			this.currentWeapon.setDurability(Double.parseDouble(currentWeaponStats[2]));

		} catch(FileNotFoundException fnfex) {
			in = System.in;
			reader = new BufferedReader(new InputStreamReader(in));
			this.name = reader.readLine();
			this.level = 1;
		} finally {
			this.pickUpWeapon(new Shotgun()); //TODO move to catch block when weapons are loaded from stats
			writeStatsToFile(); //TODO move this too along with line above
			in.close();
			reader.close();
		}
	}

	private void writeStatsToFile() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("gamestats.txt");
			pw.write(this.name + "," + this.level);
			pw.println();
			pw.write(this.currentWeapon.getClass().getSuperclass().getSimpleName() + "," +
				     this.currentWeapon.getType() + "," +
					 this.currentWeapon.getDurability());
			if (this.currentWeapon.getClass().getSuperclass().getSimpleName().compareTo("Gun") == 0) {
				pw.write("," + ((Gun)this.currentWeapon).getBulletsAvailable() + "," +
						((Gun)this.currentWeapon).getCartridgesAvailable());
			}
		} catch (IOException e) {
			//System.out.println(e.getMessage());
		} finally {
			pw.close();
		}
	}

	public Weapon getCurrentWeapon() {
		return this.currentWeapon;
	}

	public void setCurrentWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}

	// POLIMORFISM taken
	public void pickUpWeapon(Weapon weapon) throws FullSlotsException {
		int numberOfWeapons = this.weapons.size();
		ArrayList<String> weaponTypes = new ArrayList<>();
		for (Weapon w: this.weapons) {
			weaponTypes.add(w.getType());
		}
		if (numberOfWeapons == 0) {
			System.out.println("Picked up a " + weapon.getType());
			this.setCurrentWeapon(weapon);
			this.weapons.add(weapon);
		} else if (weaponTypes.contains(weapon.getType())) {
			try {
				for (int i = 0; i <= this.weapons.size(); i++) {
					if (this.weapons.get(i).getType() == weapon.getType()) {
						Gun gun = (Gun) this.weapons.get(i);
						gun.reload(gun.getMagazineSize());
						break;
					}
				}
			} catch (ClassCastException ex) { // Tried to reload Melee weapon before
				((MeleeWeapon) this.getCurrentWeapon()).restore();
			}
		} else if (numberOfWeapons == 4) {
			throw new FullSlotsException("You can't pick up a new weapon. Empty 1 or more slots.");
		} else {
			System.out.println("Picked up a " + weapon.getType());
			this.weapons.add(weapon);
		}
	}

	public void attack(Zombie zombie, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			boolean strike = getCurrentWeapon().action();
			if (strike) {
				zombie.shotsTaken++;
			} else { // Out of bullets!
				System.out.println("You are out of bullets, do you you wish to change weapons?");
				// Scanner sc = System.in... //TODO implement user input
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder allWeapons = new StringBuilder();
		this.weapons.forEach((w) -> allWeapons.append("\n\t" + w));

		return "***************" + this.name + "*************\n" +
				"Current Level: " + this.level + "\n" +
				"Number of weapons: " + this.weapons.size() + "\n" +
				"Currently holding: "	+ this.getCurrentWeapon().getType() + "\n" +
				"Weapons available: " + allWeapons +
				"\n****************************\n";
	}

}