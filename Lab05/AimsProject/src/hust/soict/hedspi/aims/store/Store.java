package hust.soict.hedspi.aims.store;

import java.util.*;
import hust.soict.hedspi.aims.media.*;

public class Store {
    private List<Media> items = new ArrayList<>();
    
    public void addMedia(Media m) { 
    	if (!items.contains(m)) 
    		items.add(m); 
    }
    
    public void removeMedia(Media m) { 
    	items.remove(m); 
    }
    
    public Media findByTitle(String title) {
        for (Media m : items) 
        	if (m.isMatch(title)) return m;
        return null;
    }
    
    public void printStore() {
        System.out.println("Store items:");
        int i=1; 
        for (Media m : items) 
        	System.out.println(i++ + ". " + m.toString());
    }
    
    public List<Media> getItemsInStore(){
    	return items;
    }
}
