package com.java.fightarena.abstractions;
/**
 * Super class to all sort of weapons
 * @author caroline.oliveira
 * 
 */

public abstract class Weapon {
	protected String type;
	public double durability = 100;	
	public abstract boolean action();
	
	public void restore() {
		this.durability = 100;
	}

	public String getType() {
		return type;
	}
}
