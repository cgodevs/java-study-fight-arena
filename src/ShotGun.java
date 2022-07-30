
public class ShotGun extends Gun {

	public ShotGun(int bullets, int cartridges) {
		super.gunType = "shotgun";
		super.numberOfBulletsAvailable = bullets;
		super.numberOfCartridgesAvailable = cartridges;
		super.ammoCapacity = 10;
	}
	
	public ShotGun() {
		this(10, 2);
	}

	@Override
	public void sound() {
		System.out.print("PEW! ");		
	}


}