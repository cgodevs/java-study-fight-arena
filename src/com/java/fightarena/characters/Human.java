package com.java.fightarena.characters;
import java.util.ArrayList;
import java.util.Scanner;
import com.java.fightarena.abstractions.*;


public class Human {
	private Weapon currentWeapon;  // Guns or Melee Weapons	
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>(4); //4 slots mean only 4 weapons may be carried at a time
	
	public int getNumberOfWeapons() {
		return this.weapons.size();
	}

	// POLIMORFISM taken
	  public void pickUpWeapon(Weapon weapon) { //TODO throw exception for full slots
		  if (this.weapons.size() == 0) {
			  this.switchWeapon(weapon);
		  } else if(weapon.getType() == this.currentWeapon.getType()) {
			  try {
				((Gun) this.currentWeapon).reload();
			  } catch (ClassCastException ex) { // Tried to reload Melee weapon before
				((MeleeWeapon) this.currentWeapon).restore();  
			  }
		  } else {
			  System.out.println("Picked up a " + weapon.getType());
			  this.weapons.add(weapon);
		  } 
	  }	 

	public void switchWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}		
	
	public void attack(Zombie zombie, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			boolean strike = currentWeapon.action();
			if (strike) {
				zombie.shotsTaken++;
			} else { // Out of bullets!
				System.out.println("You are out of bullets, do you you wish to change weapons?");
				//Scanner sc = System.in... //TODO implement user input
			}
		}
	}
	
	@Override
	public String toString() {
		return "**********************\n" +
				"Number of Guns: " + this.weapons.size() + "\n" +
				"Holding: " + this.currentWeapon.getType() +
				"\n**********************\n";
	}
}