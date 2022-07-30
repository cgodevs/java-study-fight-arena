
public abstract class Weapon {
	protected String type;
	public double durability = 100;	
	public abstract boolean action();
	
	public void restore() {
		this.durability = 100;
	}
}
