
public class MarksmanRifle extends Rifle {  // extends Rifle and Gun

	public MarksmanRifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "marksman rifle";		
	}

	public MarksmanRifle() {
		this(30,1);
	}

}
