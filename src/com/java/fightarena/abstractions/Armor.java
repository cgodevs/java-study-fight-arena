package com.java.fightarena.abstractions;
import java.io.Serializable;

import com.java.fightarena.interfaces.*;

public abstract class Armor implements Deteriorable, Serializable {
	public double durability = 100;

	@Override
	public void deteriorate() {
		this.durability -= this.durability * 0.05;
	}

	public void restore() {
		this.durability = 100;
	}
}
