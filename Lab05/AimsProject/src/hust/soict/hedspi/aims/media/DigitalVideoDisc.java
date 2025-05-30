package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
	    super(id, title, category, cost, length, director);

	    if (title == null || title.trim().isEmpty()) {
	        throw new IllegalArgumentException("Title cannot be null or empty.");
	    }

	    if (cost < 0) {
	        throw new IllegalArgumentException("Cost cannot be negative.");
	    }

	    if (length < 0) {
	        throw new IllegalArgumentException("Length cannot be negative.");
	    }

	    nbDigitalVideoDiscs++;
	}
	
	public static int getnbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
	public String toString() {
		return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "m: " + getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return getTitle().toLowerCase().contains(title.toLowerCase());
	}
	
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        System.err.println("ERROR: DVD length is non-positive!");
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}
}
