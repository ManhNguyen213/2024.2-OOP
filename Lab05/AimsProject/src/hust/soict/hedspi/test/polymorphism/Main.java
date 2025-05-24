package hust.soict.hedspi.test.polymorphism;

import java.util.*;
import hust.soict.hedspi.aims.media.*;

public class Main {
	public static void main(String[] args) {
		 List<Media> mediae = new ArrayList<Media>();
		 
		 DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Inception", "Sci-fi", "Christopher Nolan", 148, 19.99f);
		 Book book = new Book(2, "1984", "Dystopia", 12.99f, Arrays.asList("George Orwell"));
		 CompactDisc cd = new CompactDisc(3, "Thriller", "Pop", "Quincy Jones", 42, 15.99f, "Michael Jackson", new ArrayList<>());

		 mediae.add(dvd);
		 mediae.add(book);
		 mediae.add(cd);
		 
		 for (Media m : mediae) {
	    	 System.out.println(m.toString());
		 }
	}
}
