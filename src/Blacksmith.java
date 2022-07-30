
public class Blacksmith {
	
	public void repair(Deteriorable brokenItem) {
		brokenItem.restore();	
		System.out.println("Item restored");
	}
}
