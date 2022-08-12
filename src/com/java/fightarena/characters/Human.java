package com.java.fightarena.characters;
import com.java.fightarena.abstractions.*;

public class Human {
	private int numberOfWeapons = 0;
	public Weapon currentWeapon;  // Guns or Melee Weapons	
	public int getNumberOfWeapons() {
		return this.numberOfWeapons;
	}

	// POLIMORFISM taken
	  public void pickUpWeapon(Weapon weapon) {
		  this.currentWeapon = weapon; 
		  System.out.println("Picked up a " + weapon.getType());
		  this.numberOfWeapons++; 
	  }	 

	public void switchGun(Weapon weapon) {
		this.currentWeapon = weapon;
	}		
	
	public void attack(Zombie zombie, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			boolean strike = currentWeapon.action();
			if (strike) {
				zombie.shotsTaken++;
			} else { // Out of bullets!
				if (this.numberOfWeapons != 0) {
					this.numberOfWeapons--;
				}
				break; // remove to force human to use other gun(s) left
				/*
					if (this.numberOfWeapons > 0) {						
						this.switchGun();
						this.shoot(zombie, numberOfTimes - i); 
					} else {
						System.out.println("No Weapons left!");
					}		
					*/	
				}
		}
	}
	
	@Override
	public String toString() {
		return "**********************\n" +
				"Number of Guns: " + this.numberOfWeapons + "\n" +
				"Holding: " + this.currentWeapon.getType() +
				"\n**********************\n";
	}
}