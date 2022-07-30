
public class Pistol extends Gun {

	public Pistol(int bullets, int cartridges) {
		super(bullets, cartridges); // The Parent Constructor is not inherited by default, so it's mandatory to recreate it in the Child Class		
		//super.numberOfBulletsAvailable = bullets; // Attributes are implicitly stated by the line above
		//super.numberOfCartridgesAvailable = cartridges; // Attributes are implicitly stated by the line above		
		super.type = "pistol";
		super.magazineSize = 17;
	}
	
	public Pistol() {
		this(17, 2);
	}

	@Override
	public void deteriorate() {  // deteriorates slower!
		super.durability -= super.durability * 0.05; 
	}
	
	@Override
	public void sound() {
		System.out.print("pew! ");
		
	}

}