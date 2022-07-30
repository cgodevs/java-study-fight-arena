
public abstract class Weapon {
	protected String type;
	protected double durability = 100;
	protected abstract void deteriorate();
	public abstract boolean action();
}
