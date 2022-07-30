
public class Shotgun extends Gun implements ItemStatus{

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

	// REQUIRED by ItemStatus Interface
	@Override
	public void deteriorate() {
		super.durability -= super.durability * 0.1; 		
	}

	@Override  // Got to override so deteriorate() can be used
	public boolean action(){
		if (super.action()) {
			deteriorate();
			return true;
		}
		return false;
	}

}