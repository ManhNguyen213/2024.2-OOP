package hust.soict.hedspi.aims.Cart;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
import java.util.Collections;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("Cart is full. Cannot add more items.");
		} else {
			itemsOrdered.add(media);
			System.out.println("Added: " + media.getTitle());
		}
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.remove(media)) {
			System.out.println("Removed: " + media.getTitle());
		} else {
			System.out.println("Item is not in cart.");
		}
	}
	
	public float getTotalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	
	public void displayCart() {
		System.out.println("\nCART:");
		int index = 1;
	    for (Media media : itemsOrdered) {
	        System.out.println(index + ". " + media.getTitle() + " - $" + media.getCost());
	        index++;
	    }
	}
	
	public void printCart() {
		System.out.println("--------------------CART--------------------");
		System.out.println("Ordered Items: ");
		int index = 1;
		for (Media media : itemsOrdered) {
			System.out.println(index + ". " + media.toString());
			index++;
		}
		System.out.println("Total cost: " + getTotalCost());
		System.out.println("--------------------------------------------");
	}
	
	public void searchByID(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if(media.getId() == id) {
				System.out.println("Found: " + media.toString());
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("No DVD have ID " + id);
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if(media.isMatch(title)) {
				System.out.println("Found: " + media.toString());
				found = true;
			}
		}
		if(!found) {
			System.out.println("No DVD have title: " + title);
		}
	}
	
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		System.out.println("Cart sorted by title then cost.");
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		System.out.println("Cart sorted by cost then title.");
	}
	
	public void clear() {
	    itemsOrdered.clear();
	    System.out.println("Cart has been cleared.");
	}
	
	public Media findByTitle(String title) {
	    for (Media media : itemsOrdered) {
	        if (media.isMatch(title)) {
	            return media;
	        }
	    }
	    return null;
	}
}