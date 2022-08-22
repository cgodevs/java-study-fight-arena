package com.java.fightarena.abstractions;
/**
 * Super class to all sort of weapons
 * @author caroline.oliveira
 * 
 */

public abstract class Weapon {
	protected String type;
	protected double durability = 100;	
	
	public void setDurability(double durability) {
		this.durability = durability;
	}

	public double getDurability() {
		return durability;
	}

	public abstract boolean action();
	
	public void restore() {
		this.durability = 100;
	}

	public String getType() {
		return type;
	}
}
