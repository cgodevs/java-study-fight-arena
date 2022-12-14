package com.java.fightarena.abstractions;
import com.java.fightarena.interfaces.*;

/**
 * 
 * The kind of weapons to hit or slash with, all make sound and deteriorate.
 * @author caroline.oliveira
 *
 */
public abstract class MeleeWeapon extends Weapon implements Deteriorable {	
	
	public abstract void sound();
	
	// REQUIRED by ItemStatus Interface
	@Override
	public void deteriorate() { 
		this.durability -= this.durability * 0.3; // melee weapons deteriorate a lot faster!
	}
	
	@Override
	public void restore() {
		this.durability = 100;
	}
	
	// REQUIRED by Superclass Weapon
	@Override
	public boolean action() {
		if (this.durability > 0.1) {
			sound();
			deteriorate();
			return true;
		} else {
			System.out.println("Weapon is broken, no damage inflicted.");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "[" + this.type + " | " + this.getDurability() + "%]";
	}
}
