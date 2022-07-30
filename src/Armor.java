
public abstract class Armor implements Deteriorable {
	public double durability = 100;

	@Override
	public void deteriorate() {
		this.durability -= this.durability * 0.05;
	}

	public void restore() {
		this.durability = 100;
	}
}
