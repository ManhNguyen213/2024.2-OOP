package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.Cart.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {	
		//Create a new cart
		Cart cart = new Cart();

		//Create new dvd objects and add them to the cart 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc (1, "The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia (dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc (2, "Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia (dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc (3, "Aladin", 
				"Animation", "Guy Ritchie", 90, 18.99f);
		cart.addMedia (dvd3);
		
		//Test the print method 
		cart.printCart();
		
		//Test the search methods
		System.out.println("\n Search by ID: ");
		cart.searchByID(2);
		cart.searchByID(5);
		
		System.out.println("\n Search by Title: ");
		cart.searchByTitle("Lion");
		cart.searchByTitle("Matrix");
	}
}