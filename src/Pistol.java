
public class Pistol extends Gun {

	public Pistol(int bullets, int cartridges) {
		this.gunType = "pistol";
		this.numberOfBulletsAvailable = bullets;
		this.numberOfCartridgesAvailable = cartridges;
		this.ammoCapacity = 17;
	}
	
	public Pistol() {
		this(17, 2);
	}

}