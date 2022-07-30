
public class Pistol extends Gun {  
	//TODO Pistols do not deteriorate (not using ItemStatus here), but deal less damage. To be implemented later on.

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
	public void sound() {
		System.out.print("pew! ");		
	}

}