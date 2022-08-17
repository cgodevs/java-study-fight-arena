package com.java.fightarena.play;
import com.java.fightarena.characters.*;
import com.java.fightarena.weapons.*;
import com.java.fightarena.exceptions.*;
import com.java.fightarena.interfaces.*;

import java.util.ArrayList;
import java.util.Collections;

import com.java.fightarena.abstractions.*;

public class FightArena {

	public static void main(String[] args) {
		Zombie zombie1 = new Zombie();
		Human charlie = new Human("Charlie");
		
		//pick up several weapons to test FullSlotsException
		/*
		 * try { charlie.pickUpWeapon(new MarksmanRifle()); System.out.println(charlie);
		 * 
		 * charlie.pickUpWeapon(new Pistol()); System.out.println(charlie);
		 * 
		 * charlie.pickUpWeapon(new Axe()); System.out.println(charlie);
		 * 
		 * charlie.pickUpWeapon(new Shotgun()); System.out.println(charlie);
		 * 
		 * charlie.pickUpWeapon(new Shotgun()); // used to add a new cartridge
		 * System.out.println(charlie);
		 * 
		 * charlie.pickUpWeapon(new TacticalRifle()); // can't pick up a new type
		 * System.out.println(charlie);
		 * 
		 * } catch(FullSlotsException ex) { System.out.println(ex.getMessage());
		 * System.out.println(charlie); }
		 */
		
		//test natural order comparison
		ArrayList<Gun> guns = new ArrayList<Gun>();
		guns.add(new Pistol());
		guns.add(new Shotgun());
		guns.add(new Pistol());
		guns.add(new MarksmanRifle());
		guns.add(new TacticalRifle());
		guns.add(new Shotgun());
		
		guns.forEach(gun -> System.out.println(gun));		
		System.out.println("------------");
		
		Collections.sort(guns);
		guns.forEach(gun -> System.out.println(gun));

	}

}
