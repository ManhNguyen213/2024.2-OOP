package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.screen.manager.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.SwingUtilities;

public class StoreManagerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Store store = new Store();
            
            store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
            store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
            store.addMedia(new Book(3, "Effective Java", "Programming", 35.50f));
            store.addMedia(new CompactDisc(4, "Greatest Hits", "Music", 12.99f, 60, "Various Artists"));
            
            new StoreManagerScreen(store);
        });
    }
}
