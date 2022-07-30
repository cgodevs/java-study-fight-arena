
public abstract class Gun {		//abstract Class will not allow a generic object instantiation (in "FightArena.java") 
	String gunType;
	protected int numberOfBulletsAvailable; //protected attributes are available only to children
	protected int numberOfCartridgesAvailable;
	protected int ammoCapacity;
	
	public abstract void sound();
	
	public boolean shoot() {
		if (this.numberOfBulletsAvailable > 0) {
			sound();
			this.numberOfBulletsAvailable--;
			return true;
		} else {
			System.out.println("No bullets left in this gun.");
			return false;
		}
	}
	
	public boolean reload() {
		if (this.numberOfCartridgesAvailable > 0) {
			System.out.println("Reloading...");
			this.numberOfCartridgesAvailable--;
			this.numberOfBulletsAvailable = this.ammoCapacity;
			return true;
		} else {
			System.out.println("No cartridges left in this gun. Reloading not available.");
			return false;
		}
	}
}