package com.java.fightarena.abstractions;
import com.java.fightarena.exceptions.*;

/**
 * The kind of weapon that shoots. Not all deteriorate and some shoot two bullets per shot.  
 * @author caroline.oliveira
 *
 */

//abstract Class will not allow a generic object instantiation (in "FightArena.java")
public abstract class Gun extends Weapon{  
	protected int bulletsAvailable; //protected attributes are available only to children
	protected int cartridgesAvailable;
	protected int magazineSize;
	
	public Gun(int bullets, int cartridges) { //Constructor
		this.bulletsAvailable = bullets;
		this.cartridgesAvailable = cartridges;
	}
	
	// Even though all classes implement so, it is not possible to refer to either 'this' or 'super' while explicitly invoking a constructor
	// public Gun() {this(this.magazineSize,0);}    
	
	public abstract void sound();
	
	// REQUIRED by Superclass Weapon
	@Override
	public boolean action() {
		if (this.durability <= 0.1) {
			System.out.println("Weapon is broke. No damage inflicted.\n");
			return false;
			}
		if (this.bulletsAvailable > 0) {
			sound();
			this.bulletsAvailable--;			
			return true;
		} else {
			System.out.println("\nNo bullets left in this gun. Shooting not available.\n");
			return false;
		}		
	}
	
	public void reload() throws CartridgesNotAvailable { // method reloads 1 cartridge
		if (this.cartridgesAvailable > 0) {
			System.out.println("Reloading... " + this.magazineSize + " bullets reloaded.\n");
			this.cartridgesAvailable--;
			this.bulletsAvailable = this.magazineSize;					
		} else {
			throw new CartridgesNotAvailable("No cartridges left in this gun. Reloading not available.\n");
		}
	}
	
	public void reload(int numberOfBullets) { // bullets not loaded into magazine are stored in cartridges
		reload();
		int bulletsToReload = numberOfBullets - this.magazineSize;
		while (bulletsToReload >= this.magazineSize) {
			this.cartridgesAvailable++;
			bulletsToReload -= this.magazineSize;
		}	
	}
}




