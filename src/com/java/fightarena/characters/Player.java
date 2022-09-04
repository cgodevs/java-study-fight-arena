package com.java.fightarena.characters;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.java.fightarena.abstractions.*;
import com.java.fightarena.exceptions.CartridgesNotAvailable;
import com.java.fightarena.exceptions.FullSlotsException;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int level;
	private Weapon currentWeapon; // Either a Gun or Melee Weapon
	private Set<Weapon> weapons = new HashSet<Weapon>(4); // Only 4 weapons may be carried at a time

	public Weapon getCurrentWeapon() {
		return this.currentWeapon;
	}

	public void setCurrentWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}


	public void pickUpWeapon(Weapon weapon) {
		if (this.weapons.add(weapon)){
			setCurrentWeapon(weapon);
			System.out.println(this.name + " picked up a " + weapon.getType());	
		} else {
			for (Weapon w: this.weapons) {
				if (w.equals(weapon)) {
					try {
						((Gun) w).reload(((Gun) w).getMagazineSize());
					} catch(ClassCastException e) {
						((MeleeWeapon) w).restore();
					}			
					break;
				}
			}
		}
	}

	public void attack(Zombie zombie, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			boolean strike = getCurrentWeapon().action();
			if (strike) {
				zombie.shotsTaken++;
			} else { 						// Out of bullets!
				try {
					((Gun) currentWeapon).reload();
				} catch (CartridgesNotAvailable e) {
					if(weapons.size() > 1)
						switchWeapons();
				}				
			}
		}
	}

	public void switchWeapons() {
		System.out.print("What weapon do you choose? Other weapons available are: ");
		weapons.stream()
			.filter(w -> w.getDurability() > 0 && !w.equals(this.currentWeapon))
			.forEach(w -> System.out.print("[" + w.getType() + "] "));		 // lambda
		
		Scanner sc = new Scanner(System.in);
		String weaponChoice = sc.nextLine();
		boolean weaponChosen = false;
		
		for(Weapon weapon: weapons) {
			if(weapon.getType().compareTo(weaponChoice) == 0) {
				setCurrentWeapon(weapon);
				weaponChosen = true;
			}				
		}		
		if(!weaponChosen) {
			System.out.println("Choice not recognized, did you type in exactly one of the types presented? Let's try again\n");
			switchWeapons();
		}
	}

	public Player createPlayer() throws IOException {
		System.out.print("What's your name? -> ");
		Scanner scanner = new Scanner(System.in);
		this.name = scanner.nextLine();
		this.level = 1;
		scanner.close();
		return this;
	}
	public void savePlayer(String fileName) throws IOException{
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileName));
		Player playerToSave = new Player();
		playerToSave = this;
		ous.writeObject(playerToSave);
		ous.close();
	}
	
	public Player loadPlayer(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Player player = (Player) ois.readObject();
		ois.close();
		return player;
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
							this.level,	this.weapons.size(), this.getCurrentWeapon(), allWeapons);
	}

}