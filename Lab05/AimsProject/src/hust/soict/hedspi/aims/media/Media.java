package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {
		
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean isMatch(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Media)) return false;
		
		Media other = (Media) obj;

		// So sánh title (ko phân biệt hoa thường) và cost
		if (this.title == null) {
			if (other.title != null) return false;
		} else if (!this.title.equalsIgnoreCase(other.title)) {
			return false;
		}
		
		return this.cost == other.cost;
	}

	@Override
	public int compareTo(Media other) {
		if (other == null) {
			throw new NullPointerException("Cannot compare to null");
		}
		
		// So sánh title không phân biệt hoa thường
		int titleCompare = 0;
		if (this.title == null && other.title == null) {
			titleCompare = 0;
		} else if (this.title == null) {
			titleCompare = -1;
		} else if (other.title == null) {
			titleCompare = 1;
		} else {
			titleCompare = this.title.compareToIgnoreCase(other.title);
		}

		if (titleCompare != 0) {
			return titleCompare;
		}
		
		// Nếu title bằng nhau, so sánh cost
		return Float.compare(this.cost, other.cost);
	}
	
	// Gợi ý nên override hashCode nếu override equals
	@Override
	public int hashCode() {
		int result = (title == null) ? 0 : title.toLowerCase().hashCode();
		result = 31 * result + Float.hashCode(cost);
		return result;
	}

	public abstract String toString();
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
