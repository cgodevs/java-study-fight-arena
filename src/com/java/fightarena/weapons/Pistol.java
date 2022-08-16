package com.java.fightarena.weapons;
import com.java.fightarena.abstractions.*;
import com.java.fightarena.enums.*;

public class Pistol extends Gun {  
	//TODO Pistols do not deteriorate (not using ItemStatus here), but deal less damage. To be implemented later on.

	public Pistol(int bullets, int cartridges) {
		super(bullets, cartridges); // The Parent Constructor is not inherited by default, so it's mandatory to recreate it in the Child Class		
		//super.numberOfBulletsAvailable = bullets; // Attributes are implicitly stated by the line above
		//super.numberOfCartridgesAvailable = cartridges; // Attributes are implicitly stated by the line above		
		super.type = "Pistol";
		super.magazineSize = GunSpecs.PISTOL.getMagazineCap();
	}
	
	public Pistol() {
		this(GunSpecs.PISTOL.getMagazineCap(), GunSpecs.PISTOL.getCartridges());
	}
	
	@Override
	public void sound() {
		System.out.print("pew! ");		
	}

}