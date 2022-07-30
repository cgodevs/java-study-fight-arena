
public class Pistol extends Gun {

	public Pistol(int bullets, int cartridges) {
		super.gunType = "pistol";
		super.numberOfBulletsAvailable = bullets;
		super.numberOfCartridgesAvailable = cartridges;
		super.ammoCapacity = 17;
	}
	
	public Pistol() {
		this(17, 2);
	}

	@Override
	public void sound() {
		System.out.print("pew! ");
		
	}

}