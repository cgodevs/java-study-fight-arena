package com.java.fightarena.enums;

//holds magazineCapacity and initial number of cartridges available //Usage: GunSpecs.NAME.getMagazineCap()
public enum GunSpecs { 
	MARKSMAN(30, 1),PISTOL(17,2), SHOTGUN(12, 2), TACTICAL(50, 1), RIFLE(30, 1);

	public int magazineCapacity;
	public int numberOfCartridgesAvailable;
	
	GunSpecs(int i, int j) {
		this.magazineCapacity = i;
		this.numberOfCartridgesAvailable = j;
	}
	
	public int getMagazineCap() {
		return this.magazineCapacity;
	}
	
	public int getCartridges() {
		return this.numberOfCartridgesAvailable;
	}	
}
