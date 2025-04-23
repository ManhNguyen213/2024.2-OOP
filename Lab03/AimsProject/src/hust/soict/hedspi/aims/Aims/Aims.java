package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.Cart.Cart;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleStore();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt();
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initSampleStore() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book(3, "Java Programming", "Education", 49.99f));
        // sample CD with tracks
        CompactDisc cd = new CompactDisc(4, "Greatest Hits", "Pop", 15.99f, 60, "Various");
        cd.addTrack(new Track("Track A", 4));
        cd.addTrack(new Track("Track B", 5));
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static void storeMenu() {
        System.out.println("\nSTORE MENU:");
        System.out.println("1. See media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    public static void cartMenu() {
        System.out.println("\nCART MENU:");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    private static void viewStore() {
        boolean inMenu = true;
        while (inMenu) {
            store.printStore();
            storeMenu();
            switch (readInt()) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMediaFromStore();
                case 4 -> cart.printCart();
                case 0 -> inMenu = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        Media m = store.findByTitle(readLine());
        if (m != null) {
            System.out.println(m);
            mediaDetailsMenu();
            switch (readInt()) {
                case 1 -> {
                    cart.addMedia(m);
                    System.out.println("Added to cart.");
                }
                case 2 -> {
                    if (m instanceof Playable) ((Playable) m).play();
                    else System.out.println("Not playable.");
                }
                case 0 -> {}
                default -> System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title to add: ");
        Media m = store.findByTitle(readLine());
        if (m != null) {
            cart.addMedia(m);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMediaFromStore() {
        System.out.print("Enter media title to play: ");
        Media m = store.findByTitle(readLine());
        if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void updateStore() {
        System.out.println("\nUPDATE STORE:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
        switch (readInt()) {
            case 1 -> addMediaToStore();
            case 2 -> {
                System.out.print("Enter title to remove: ");
                Media m = store.findByTitle(readLine());
                if (m != null) store.removeMedia(m);
                else System.out.println("Media not found.");
            }
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void addMediaToStore() {
        System.out.println("Choose type: 1.DVD 2.CD 3.Book 0.Back");
        switch (readInt()) {
            case 1 -> {
                System.out.print("id: "); int id = readInt();
                System.out.print("title: "); String title = readLine();
                System.out.print("category: "); String cat = readLine();
                System.out.print("director: "); String dir = readLine();
                System.out.print("length: "); int len = readInt();
                System.out.print("cost: "); float cost = readFloat();
                store.addMedia(new DigitalVideoDisc(id, title, cat, dir, len, cost));
            }
            case 2 -> {
                System.out.print("id: "); int id = readInt();
                System.out.print("title: "); String t = readLine();
                System.out.print("category: "); String c = readLine();
                System.out.print("director: "); String d = readLine();
                System.out.print("length: "); int l = readInt();
                System.out.print("cost: "); float co = readFloat();
                System.out.print("artist: "); String art = readLine();
                store.addMedia(new CompactDisc(id, t, c, co, l, art));
            }
            case 3 -> {
                System.out.print("id: "); int id = readInt();
                System.out.print("title: "); String t2 = readLine();
                System.out.print("category: "); String c2 = readLine();
                System.out.print("cost: "); float co2 = readFloat();
                store.addMedia(new Book(id, t2, c2, co2));
            }
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }
    
    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media m = cart.findByTitle(title);
        if (m != null && m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void seeCurrentCart() {
        boolean inCart = true;
        while (inCart) {
            cart.printCart();
            cartMenu();
            switch (readInt()) {
                case 1 -> {
                    System.out.println("Filter by: 1.ID 2.Title");
                    if (readInt() == 1) {
                    	System.out.print("Enter ID: ");
                    	int id = scanner.nextInt();
                    	scanner.nextLine(); // clear newline
                    	cart.searchByID(id);
                    } else {
                    	System.out.print("Enter title: ");
                    	String title = scanner.nextLine();
                    	cart.searchByTitle(title);
                    }
                }
                case 2 -> {
                    System.out.println("Sort by: 1.Title 2.Cost");
                    if (readInt() == 1) cart.sortByTitleCost(); else cart.sortByCostTitle();
                }
                case 3 -> {
                    System.out.print("Enter title to remove: ");
                    Media m = cart.findByTitle(readLine());
                    if (m != null) cart.removeMedia(m);
                }
                case 4 -> playMedia();
                case 5 -> {
                    System.out.println("Order placed."); cart.clear(); inCart = false;
                }
                case 0 -> inCart = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // Utility input methods
    private static int readInt() {
        int x = Integer.parseInt(scanner.nextLine());
        return x;
    }
    private static float readFloat() {
        float f = Float.parseFloat(scanner.nextLine());
        return f;
    }
    private static String readLine() {
        return scanner.nextLine();
    }
}
