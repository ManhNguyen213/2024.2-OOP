package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost, length, director);
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
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
