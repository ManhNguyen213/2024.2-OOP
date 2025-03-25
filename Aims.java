package MyPackage;

public class Aims {

	public static void main(String[] args) {
		
		//Create a new cart
		Cart anOrder = new Cart();
		
		//Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVidedeoDDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVidedeoDDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		anOrder.addDigitalVidedeoDDisc(dvd3);
		
		anOrder.displayCart();
		
		//print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.getTotalCost());
		
		System.out.println("\nRemove Science Fiction DVD");
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.displayCart();

	}
}
