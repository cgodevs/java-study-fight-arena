package com.java.fightarena.play;

import com.java.fightarena.characters.*;
import com.java.fightarena.enums.GunSpecs;
import com.java.fightarena.weapons.*;
import com.java.fightarena.exceptions.*;
import com.java.fightarena.interfaces.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.java.fightarena.abstractions.*;

public class FightArena {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Player player = new Player();
		
		try { 			
			player = player.loadPlayer("save.bin"); //Load saved player from file
			
		} catch(FileNotFoundException e) { 			
			player = player.createPlayer();			//Create from console
			player.pickUpWeapon(new Pistol()); 		// Default weapon for game start
			player.savePlayer("save.bin");
		}		
		System.out.println(player); 				// check player from saved file
		
		player.pickUpWeapon(new Shotgun());			// load lots of weapons
		player.pickUpWeapon(new Axe());
		player.pickUpWeapon(new MarksmanRifle());		
		System.out.println(player);							
		player.savePlayer("save.bin");				// and test saving them after printing current stats
													// comment everything and rerun try/catch!
													// keep running to increment cartridges!

	}
	
}
