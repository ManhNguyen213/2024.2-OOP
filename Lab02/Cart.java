package MyPackage;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVidedeoDDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added.");
		} else {
			System.out.println("The cart is almost full.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... DVDs) {
		for (DigitalVideoDisc disc: DVDs) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc " + disc.getTitle() + " has been added.");
			} else {
				System.out.println("The cart is almost full. Cannot add " + disc.getTitle());
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				found = true;
				for (int j = 1; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				qtyOrdered--;
				System.out.println("The disc has been removed.");
				break;
			}
		}
		if(!found) {
			System.out.println("The disc was not found in the cart.");
		}
	}
	
	public float getTotalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void displayCart() {
		System.out.println("\nCART:");
	    for (int i = 0; i < qtyOrdered; i++) {
	        System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
	    }
	}
}