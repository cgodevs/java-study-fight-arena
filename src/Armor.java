
public class Armor implements ItemStatus {
	private double durability = 100;

	@Override
	public void deteriorate() {
		this.durability -= this.durability * 0.05;
	}

}
