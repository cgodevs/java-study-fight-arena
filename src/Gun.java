
public abstract class Gun {		//abstract Class will not allow a generic object instantiation 
	String gunType;
	public int numberOfBulletsAvailable;
	public int numberOfCartridgesAvailable;
	public int ammoCapacity;
	
	public boolean shoot() {
		if (this.numberOfBulletsAvailable > 0) {
			System.out.print("PEW! ");
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
			System.out.println("No cartridges left in this gun.");
			return false;
		}
	}
}