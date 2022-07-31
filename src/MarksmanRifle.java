
public class MarksmanRifle extends Rifle {  // extends Rifle and Gun

	public MarksmanRifle(int bullets, int cartridges) {
		super(bullets, cartridges);
		super.type = "marksman rifle";	
		super.magazineSize = GunSpecs.MARKSMAN.getMagazineCap();
	}

	public MarksmanRifle() {
		this(GunSpecs.MARKSMAN.getMagazineCap(),GunSpecs.MARKSMAN.getCartridges());
	}

}
