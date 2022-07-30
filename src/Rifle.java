
public abstract class Rifle extends Gun {

	public Rifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "rifle";
		super.magazineSize = 30;
	}
	
	public Rifle() {
		this(30,1);
	}

	@Override
	public void sound() {
		System.out.print("pewpew! ");
	}
	
	@Override
	public void deteriorate() {  // deteriorates faster!
		super.durability -= super.durability * 0.3; 
	}
	
	@Override
	public boolean action() {
		super.action();
		if (this.bulletsAvailable > 0) {
			this.bulletsAvailable--; // Rifles shoot twice (for some reason)
			return true;
		} 
		return false;
	}
}
