
//interfaces seem to work better when understood as abilities or capacities

public abstract interface Deteriorable { 
	public abstract void deteriorate(); 
	public abstract void restore();
	//Deterioration changes durability, some items will deteriorate faster; 
	// NOT all items deteriorate. This concept help implementing the correct use of Interfaces
}
