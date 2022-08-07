package com.java.fightarena.weapons;
import com.java.fightarena.abstractions.*;

public class Axe extends MeleeWeapon{
	
	public Axe() {
		super.type = "Axe";
	}

	public void sound() {
		System.out.println("Swoosh!");		
	}
	
}
