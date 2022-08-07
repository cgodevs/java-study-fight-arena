package com.java.fightarena.weapons;
import com.java.fightarena.abstractions.*;
import com.java.fightarena.enums.*;

public class MarksmanRifle extends Rifle {  // extends Rifle and Gun

	public MarksmanRifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "marksman rifle";	
		super.magazineSize = GunSpecs.MARKSMAN.getMagazineCap();
	}

	public MarksmanRifle() {
		this(GunSpecs.MARKSMAN.getMagazineCap(),GunSpecs.MARKSMAN.getCartridges());
	}

}
