package com.java.fightarena.characters;

import java.util.ArrayList;
import java.util.Scanner;
import com.java.fightarena.abstractions.*;
import com.java.fightarena.exceptions.FullSlotsException;

public class Human { 
	private String name;
	private Weapon currentWeapon; // Either a Gun or Melee Weapon
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>(4); // Only 4 weapons may be carried at a time
	
	public Human(String name){
		this.name = name;
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
		ArrayList<String> weaponTypes = new ArrayList<String>();
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
		
		for(Weapon weapon: this.weapons) {
			allWeapons.append("\n\t" + weapon); 
		}
		return "***************" + this.name + "*************\n" + 
				"Number of weapons: " + this.weapons.size() + "\n" +
				"Currently holding: "	+ this.getCurrentWeapon().getType() + "\n" +
				"Weapons available: " + allWeapons +				
				"\n****************************\n";
	}
 
}