package com.java.fightarena.abstractions;

import java.io.Serializable;

/**
 * Super class to all sort of weapons
 * @author caroline.oliveira
 * 
 */

public abstract class Weapon implements Serializable{
	private static final long serialVersionUID = 1L;
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
		return ((Weapon) obj).getType().equals(this.getType());
	}
	
	@Override
		public int hashCode() {
			return this.getType().hashCode();
		}
}
