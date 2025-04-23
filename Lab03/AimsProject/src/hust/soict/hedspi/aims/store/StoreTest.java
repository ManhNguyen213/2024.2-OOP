package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		//Create new dvd objects and add them to the store 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc (1, "The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc (2, "Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc (3, "Aladin", 
				"Animation", "Guy Ritchie", 90, 18.99f);
		store.addMedia(dvd3);
		
		
		//Test the remove method
		store.removeMedia(dvd2);
		
	}
}
