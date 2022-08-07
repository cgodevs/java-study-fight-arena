package com.java.fightarena.interfaces;

/**
 * Deterioration changes durability, some items will deteriorate faster;
 * Because NOT all items deteriorate, this concept helps implementing the correct use of Interfaces.
 * @author caroline.oliveira
 **/
//interfaces seem to work better when understood as abilities or capacities

public abstract interface Deteriorable { 
	public abstract void deteriorate(); 
	public abstract void restore();
}
