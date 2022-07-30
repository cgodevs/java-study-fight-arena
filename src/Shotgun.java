
public class Shotgun extends Gun {

	public Shotgun(int bullets, int cartridges) {		
		super(bullets, cartridges);
		super.type = "shotgun";
		super.magazineSize = 12;
	}
	
	public Shotgun() {
		this(12, 2);
	}

	@Override
	public void sound() {
		System.out.print("PEW! ");		
	}


}