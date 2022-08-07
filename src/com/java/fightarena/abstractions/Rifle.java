package com.java.fightarena.abstractions;
import com.java.fightarena.interfaces.*;
import com.java.fightarena.enums.*;

public abstract class Rifle extends Gun implements Deteriorable{

	public Rifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "rifle";
		super.magazineSize = GunSpecs.RIFLE.getMagazineCap();
	}
	
	public Rifle() {
		this(GunSpecs.RIFLE.getMagazineCap(), GunSpecs.RIFLE.getCartridges());
	}

	// REQUIRED by Superclass Gun	
	@Override
	public void sound() {
		System.out.print("pewpew! ");
	}
	
	// REQUIRED by ItemStatus Interface
	public void deteriorate() {  // fastest deteriorating type of gun!
		super.durability -= super.durability * 0.3; 
	}
	
	public void restore() {
		this.durability = 100;
	}
	
	@Override  // Got to override so deteriorate() can be used
	public boolean action() {
		if (super.action()) {
			this.bulletsAvailable--; // Rifles shoot twice (for some reason)
			deteriorate();
			return true;
		}
		return false;
	}
		
}
