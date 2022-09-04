import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.java.fightarena.abstractions.Weapon;
import com.java.fightarena.characters.Player;
import com.java.fightarena.characters.Zombie;
import com.java.fightarena.weapons.Pistol;
import com.java.fightarena.weapons.Shotgun;

public class fightarenatest {

	@Test
	public void switchWeaponsWhenOutofBulletsForCurrentGun() throws ClassNotFoundException, IOException {
		Player player = new Player();
		Zombie zombie = new Zombie();

		try {
			player = player.loadPlayer("save.bin"); // Load saved player from file

		} catch (FileNotFoundException e) {
			player = player.createPlayer(); // Create from console
			player.pickUpWeapon(new Pistol()); // Default weapon for game start
			player.savePlayer("save.bin");
		}
		
		player.setCurrentWeapon(new Shotgun());  // sets current weapon to shotgun, to be unloaded
		Weapon weaponToUnload = player.getCurrentWeapon();
		
		player.attack(zombie, 70); //unload weapon
		assertFalse(player.getCurrentWeapon() == weaponToUnload);
		
	}

}
;