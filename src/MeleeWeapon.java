
public abstract class MeleeWeapon extends Weapon implements ItemStatus {	
	
	public abstract void sound();
	
	// REQUIRED by ItemStatus Interface
	@Override
	public void deteriorate() { 
		this.durability -= this.durability * 0.3; // melee weapons deteriorate a lot faster!
	}
	
	// REQUIRED by Superclass Weapon
	@Override
	public boolean action() {
		if (this.durability > 0.1) {
			sound();
			deteriorate();
			return true;
		} else {
			System.out.println("Weapon is broken, no damage inflicted.");
			return false;
		}
	}
}
