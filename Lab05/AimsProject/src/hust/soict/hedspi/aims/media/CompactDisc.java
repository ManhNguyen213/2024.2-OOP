package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.exception.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(int id, String title, String category, float cost, int length, String artist) {
		super(id, title, category, cost, length, null);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}
	
	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
	    super(id, title, category, cost, length, director);
	    this.artist = artist;
	    this.tracks = new ArrayList<>(tracks);
	}

	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Track \"" + track.getTitle() + "\" is already in the list.");
		} else {
			tracks.add(track);
			System.out.println("Added track: " + track.getTitle());
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Removed track: " + track.getTitle());
		} else {
			System.out.println("Track \"" + track.getTitle() + "\" is not found.");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public String toString() {
		return "CD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "m: " + getCost() + " $";
	}
	
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing CD: " + this.getTitle());
	        System.out.println("CD Artist: " + this.artist);

	        java.util.Iterator<Track> iter = tracks.iterator();
	        Track nextTrack;

	        while (iter.hasNext()) {
	            nextTrack = iter.next();
	            try {
	                nextTrack.play();
	            } catch (PlayerException e) {
	                System.err.println("Error while playing track: " + e.getMessage());
	                throw e;
	            }
	        }
	    } else {
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}


}
