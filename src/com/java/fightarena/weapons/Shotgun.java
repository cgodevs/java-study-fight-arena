package com.java.fightarena.weapons;
import com.java.fightarena.abstractions.*;
import com.java.fightarena.enums.*;
import com.java.fightarena.interfaces.*;

public class Shotgun extends Gun implements Deteriorable{

	public Shotgun(int bullets, int cartridges) {		
		super(bullets, cartridges);
		super.type = "shotgun";
		super.magazineSize = GunSpecs.SHOTGUN.getMagazineCap();
	}
	
	public Shotgun() {
		this(GunSpecs.SHOTGUN.getMagazineCap(), GunSpecs.SHOTGUN.getCartridges());
	}

	@Override
	public void sound() {
		System.out.print("PEW! ");		
	}

	// REQUIRED by ItemStatus Interface
	@Override
	public void deteriorate() {
		super.durability -= super.durability * 0.1; 		
	}
	
	@Override
	public void restore() {
		this.durability = 100;
	}

	@Override  // Got to override so deteriorate() can be used
	public boolean action(){
		if (super.action()) {
			deteriorate();
			return true;
		}
		return false;
	}

}