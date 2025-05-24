package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		this.authors = new ArrayList<>();
	}
	
	public Book(int id, String title, String category, float cost, List<String> authors) {
	    super(id, title, category, cost);
	    this.authors = new ArrayList<>(authors);
	}


	public void addAuthor(String authorName) throws IllegalArgumentException {
	    if (authorName == null || authorName.trim().isEmpty()) {
	        throw new IllegalArgumentException("Author name cannot be null or empty.");
	    }

	    if (!authors.contains(authorName)) {
	        authors.add(authorName);
	        System.out.println("Added author: " + authorName);
	    } else {
	        throw new IllegalArgumentException("Author already exists: " + authorName);
	    }
	}

	
	public void removeAuthor(String authorName) throws IllegalArgumentException {
	    if (authorName == null || authorName.trim().isEmpty()) {
	        throw new IllegalArgumentException("Author name cannot be null or empty.");
	    }

	    if (authors.contains(authorName)) {
	        authors.remove(authorName);
	        System.out.println("Removed author: " + authorName);
	    } else {
	        throw new IllegalArgumentException("Author not found: " + authorName);
	    }
	}

	
	public void printAuthors() {
		System.out.println("Authors of \"" + getTitle() + "\": " + authors);
	}
	
    public String toString() {
        return "Book: " + getTitle() + " - " + getCategory() + " - " + getCost() + " $";
    }
}
