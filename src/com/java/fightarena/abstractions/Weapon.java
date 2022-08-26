package com.java.fightarena.abstractions;

import java.io.Serializable;

/**
 * Super class to all sort of weapons
 * @author caroline.oliveira
 * 
 */

public abstract class Weapon implements Serializable{
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
	
	@Override
	public boolean equals(Object obj) {
		if (((Weapon) obj).getType().compareTo(this.getType()) == 0) {
			return true;
		}
		return false;
		
	}
}
