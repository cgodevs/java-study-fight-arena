package com.java.fightarena.play;
import com.java.fightarena.characters.*;
import com.java.fightarena.weapons.*;
import com.java.fightarena.exceptions.*;
import com.java.fightarena.interfaces.*;
import com.java.fightarena.abstractions.*;

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
		System.out.println(charlie.toString());
		
		charlie.attack(zombie1, 16); //tries to use 32 bullets, can only use available magazine with capacity of 30 rounds
		try {
			((Gun) charlie.currentWeapon).reload(100);
		} catch (CartridgesNotAvailable ex) {
			System.out.println(ex.getMessage());
		}
		
		charlie.attack(zombie1, 7); // Wears up durability before using all bullets available
		
		Blacksmith bm = new Blacksmith();
		bm.repair((Deteriorable)charlie.currentWeapon);
		
		
		System.out.println(charlie.toString());
		System.out.println(zombie1.toString());	
		
		
		charlie.attack(zombie1, 16);
		
				
		
		//System.out.println("\nDurability is " + charlie.currentWeapon.durability); //SHOW DURABILITY		
		//System.out.println((Gun) charlie.currentWeapon.bulletsAvailable + " bullets left.\n"); //SHOW BULLETS LEFT	
		
				
		//System.out.println(zombie1.shotsTaken);		
		//System.out.println(Zombie.getTotalZombies());		

	}

}
