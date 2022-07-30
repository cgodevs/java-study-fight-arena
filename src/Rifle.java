
public class Rifle extends Gun {

	public Rifle(int bullets, int cartridges) {
		super.gunType = "rifle";
		super.numberOfBulletsAvailable = bullets;
		super.numberOfCartridgesAvailable = cartridges;
		super.ammoCapacity = 30;
	}
	
	public Rifle() {
		this(30,1);
	}

	@Override
	public void sound() {
		System.out.print("pewpew! ");
	}
	
	@Override
	public boolean shoot() {
		if (this.numberOfBulletsAvailable > 0) {
			sound();
			this.numberOfBulletsAvailable -= 2;
			return true;
		} else {
			System.out.println("No bullets left in this gun.");
			return false;
		}
	}
}
