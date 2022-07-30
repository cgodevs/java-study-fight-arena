
public abstract class Rifle extends Gun implements ItemStatus{

	public Rifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "rifle";
		super.magazineSize = 30;
	}
	
	public Rifle() {
		this(30,1);
	}

	// REQUIRED by Superclass Gun	
	@Override
	public void sound() {
		System.out.print("pewpew! ");
	}
	
	// REQUIRED by ItemStatus Interface
	public void deteriorate() {  // fastest deteriorating type of gun!
		super.durability -= super.durability * 0.3; 
	}
	
	@Override  // Got to override so deteriorate() can be used
	public boolean action() {
		if (super.action()) {
			this.bulletsAvailable--; // Rifles shoot twice (for some reason)
			deteriorate();
			return true;
		}
		return false;
	}
		
}
