package com.java.fightarena.characters;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import com.java.fightarena.abstractions.*;
import com.java.fightarena.exceptions.FullSlotsException;
import com.java.fightarena.weapons.*;

public class Player {
	private String name;
	private int level;
	private Weapon currentWeapon; // Either a Gun or Melee Weapon
	private ArrayList<Weapon> weapons = new ArrayList<>(4); // Only 4 weapons may be carried at a time

	public Player() throws IOException { // tries to load or create player from console
		try {
			Scanner scanner = new Scanner(new File("gamestats.txt")); //format: <Name> <Level> <Current Weapon> <List Of Weapons>

			//GET PLAYER INFO
			Scanner playerStats = new Scanner(scanner.nextLine());
			playerStats.useDelimiter(",");
			this.name = playerStats.next();
			this.level = playerStats.nextInt();
			playerStats.close();
			
			//GET CURRENT WEAPON INFO
			while(scanner.hasNext()) {
				Scanner oneWeaponStats = new Scanner(scanner.nextLine());
				oneWeaponStats.useLocale(Locale.US); // JVM is forced to use dots as decimals separators 
				oneWeaponStats.useDelimiter(",");
				String weaponType = oneWeaponStats.next();
				String weaponName = oneWeaponStats.next();
				double durability = oneWeaponStats.nextDouble();
				Weapon w = null;
				
				if (weaponType.compareTo("MeleeWeapon") != 0) {
					int bullets = oneWeaponStats.nextInt();
					int cartridges = oneWeaponStats.nextInt();
					switch(weaponName) {
						case("Pistol"):
							w = new Pistol(bullets, cartridges);
							break;
						case("Marksman Rifle"):
							w = new MarksmanRifle(bullets, cartridges);
							break;
						case("Shotgun"):
							w = new Shotgun(bullets, cartridges);
							break;
						case("Tactical Rifle"):
							w = new TacticalRifle(bullets, cartridges);
							break;
					}
				} else { //Load Melee Weapon
					switch(weaponName) {
						case("Axe"):
							w = new Axe();
							break;
					}
				}
				w.setDurability(durability);
				this.weapons.add(w);
				oneWeaponStats.close();
			}
			setCurrentWeapon(weapons.get(0));						
			scanner.close();

		} catch(FileNotFoundException fnfex) {
			Scanner scanner = new Scanner(System.in);
			this.name = scanner.nextLine();
			this.level = 1;
			scanner.close();
			pickUpWeapon(new Pistol()); // Default weapon for game start
			saveGame(); 
		}
	}

	public void saveGame() throws IOException{
		PrintWriter pw = new PrintWriter("gamestats.txt");
		pw.write(this.name + "," + this.level);
		pw.println();
		for(Weapon w: this.weapons) {
			pw.write(w.getClass().getSuperclass().getSimpleName() + "," + w.getType() + "," + w.getDurability());
			try {
				pw.write("," + ((Gun)w).getBulletsAvailable() + "," + ((Gun)w).getCartridgesAvailable());
			} catch (ClassCastException e) { }
			pw.println();				
		}
		pw.close();
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

		return String.format("***************" + this.name + "*************\n" +
							"Current Level: %d\n" +
							"Number of weapons: %d\n" +
							"Currently holding: %s\n" +
							"Weapons available: %s" +
							"\n****************************\n", 
							this.level,	this.weapons.size(), this.getCurrentWeapon().getType(), allWeapons);
	}

}