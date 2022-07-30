
public class TacticalRifle extends Rifle { // extends Rifle and Gun

	public TacticalRifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "tactical rifle";
		super.magazineSize = 50;
	}

	public TacticalRifle() {
		this(50,1);
	}

}
