
public class ShotGun extends Gun {

	public ShotGun(int bullets, int cartridges) {
		this.gunType = "shotgun";
		this.numberOfBulletsAvailable = bullets;
		this.numberOfCartridgesAvailable = cartridges;
		this.ammoCapacity = 10;
	}
	
	public ShotGun() {
		this(10, 2);
	}


}