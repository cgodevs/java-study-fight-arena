
public class FightArena {

	public static void main(String[] args) {
		Zombie zombie1 = new Zombie();
		Zombie zombie2 = new Zombie();
		Zombie zombie3 = new Zombie();
		//System.out.println(zombie1.motto); // Talk
		//zombie1.eat(5);  //Hold down Ctrl and hover on the name of a method to open its declaration!
		//System.out.println(Zombie.totalZombies); //Test static attribute
		
		Human charlie = new Human();
		charlie.pickUpGun(new Pistol());					
		
		charlie.shoot(zombie1, 10);		
		System.out.println(charlie.currentGun.numberOfBulletsAvailable + " bullets left.\n");
		
		charlie.shoot(zombie1, 20);		
		System.out.println(charlie.currentGun.numberOfBulletsAvailable + " bullets left.\n");		
		
		charlie.currentGun.reload();		
		System.out.println(charlie.currentGun.numberOfBulletsAvailable + " bullets left.\n");
		
		//System.out.println(zombie1.shotsTaken);		
		//System.out.println(Zombie.getTotalZombies());		

	}

}
