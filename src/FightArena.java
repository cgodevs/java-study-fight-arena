
public class FightArena {

	public static void main(String[] args) {
		Zombie zombie1 = new Zombie();
		//Zombie zombie2 = new Zombie();
		//Zombie zombie3 = new Zombie();
		//System.out.println(zombie1.motto); // Talk
		//zombie1.eat(5);  //Hold down Ctrl and hover on the name of a method to open its declaration!
		//System.out.println(Zombie.totalZombies); //Test static attribute
		
		Human charlie = new Human();
		charlie.pickUpWeapon(new MarksmanRifle());					
		
		charlie.attack(zombie1, 16); //tries to use 32 bullets, can only use available magazine with capacity of 30 rounds
		((Gun) charlie.currentWeapon).reload();
		charlie.attack(zombie1, 7); // Wears up durability before using all bullets available
		
		//System.out.println("\nDurability is " + charlie.currentWeapon.durability); //SHOW DURABILITY		
		//System.out.println((Gun) charlie.currentWeapon.bulletsAvailable + " bullets left.\n"); //SHOW BULLETS LEFT	
		
				
		//System.out.println(zombie1.shotsTaken);		
		//System.out.println(Zombie.getTotalZombies());		

	}

}
