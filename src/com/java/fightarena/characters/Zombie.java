package com.java.fightarena.characters;

public class Zombie {
	int shotsTaken = 0;
	int brainsEaten = 0;
	int stamina = 1000;
	String motto = "Aaaarghh";
	String strength = "break through walls";
	private static int totalZombies = 0;
	
	public Zombie() { // Constructor, may receive parameters
		totalZombies++;
	}

	public static int getTotalZombies() {
		return totalZombies;
	}

	public void eat(int numberOfBrains) {
		this.brainsEaten += numberOfBrains;
		System.out.println(numberOfBrains + " brains eaten!");
	}
	
	@Override
	public String toString() {
		return  "**********************\n" +
				"Shots Taken: " + this.shotsTaken + "\n" +
				"Brains Eaten: " + this.brainsEaten + "\n" +
				"Stamina: " + this.stamina + "\n" +
				"Total Zombies: " + Zombie.totalZombies +
				"\n**********************\n";
		//TODO return creation order of the object
	}
}


