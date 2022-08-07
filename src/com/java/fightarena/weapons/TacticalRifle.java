package com.java.fightarena.weapons;
import com.java.fightarena.abstractions.*;
import com.java.fightarena.enums.*;

public class TacticalRifle extends Rifle { // extends Rifle and Gun

	public TacticalRifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "tactical rifle";
		super.magazineSize = 50;
		super.magazineSize = GunSpecs.TACTICAL.getMagazineCap();
	}

	public TacticalRifle() {
		this(GunSpecs.TACTICAL.getMagazineCap(),GunSpecs.TACTICAL.getCartridges());
	}

}
