public class Human {
	private int numberOfWeapons = 0;
	Gun currentGun;  // Pistol or ShotGun
	
	public int getNumberOfWeapons() {
		return this.numberOfWeapons;
	}

	// TAKES POLIMORFISM!! 
	  public void pickUpGun(Gun gun) {
		  this.currentGun = gun; 
		  this.numberOfWeapons++; 
	  }
	 

	public void switchGun() {
		if (this.numberOfWeapons == 0) {
			System.out.println("No weapons left.");
		}
	}

	public void shoot(Zombie zombie, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			boolean strike = currentGun.shoot();
			if (strike) {
				zombie.shotsTaken++;
			} else { // Out of bullets!
				this.numberOfWeapons--;
				break; // remove to force human to use other gun(s) left
				/*
					if (this.numberOfWeapons > 0) {						
						this.switchGun();
						this.shoot(zombie, numberOfTimes - i); 
					} else {
						System.out.println("No Weapons left!");
					}		
					*/	
				}
		}
	}
}