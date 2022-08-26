package com.java.fightarena.characters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import com.java.fightarena.abstractions.*;
import com.java.fightarena.exceptions.FullSlotsException;
import com.java.fightarena.weapons.*;

public class Player implements Serializable{
	public String name;
	private int level;
	private Weapon currentWeapon; // Either a Gun or Melee Weapon
	private ArrayList<Weapon> weapons = new ArrayList<>(4); // Only 4 weapons may be carried at a time

	public Weapon getCurrentWeapon() {
		return this.currentWeapon;
	}

	public void setCurrentWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}


	public void pickUpWeapon(Weapon weapon) throws FullSlotsException {
		
		if (this.weapons.size() == 0) {
			System.out.println(this.name + " picked up a " + weapon.getType());
			this.setCurrentWeapon(weapon);
			this.weapons.add(weapon);
			
		} else if (this.weapons.contains(weapon)) {
			for (Weapon w: this.weapons) {
				if (w.getType().compareTo(weapon.getType()) == 0) {
					try {
						((Gun) w).reload(((Gun) w).getMagazineSize());						
					} catch(ClassCastException e) {
						((MeleeWeapon) weapon).restore();
					}			
					break;
				}
			}			
		} else if (this.weapons.size() == 4) {
			throw new FullSlotsException("You can't pick up a new weapon. Empty 1 or more slots.");
		
		} else {
			System.out.println(this.name + " picked up a " + weapon.getType());
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

	public Player createPlayer() throws IOException {
		System.out.println("What's your name? -> ");
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
							this.level,	this.weapons.size(), this.getCurrentWeapon().getType(), allWeapons);
	}

}