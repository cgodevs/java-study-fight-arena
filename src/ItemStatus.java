
public abstract interface ItemStatus { 
	public abstract void deteriorate(); 
	//Deterioration changes durability, some items will deteriorate faster; 
	// NOT all items deteriorate. This concept help implementing the correct use of Interfaces
}
