package co.movies.rest.test;

import java.util.List;

public class Film_List {

	private int film_Id;
	private String title;
	private String description;
	private String category;
	private Float price;
	private int length;
	private String rating;
	private List<String> actors;
	public int getFilm_Id() {
		return film_Id;
	}
	public void setFilm_Id(int film_Id) {
		this.film_Id = film_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	@Override
	public String toString() {
		return "Film_List [film_Id=" + film_Id + ", title=" + title + ", description=" + description + ", category="
				+ category + ", price=" + price + ", length=" + length + ", rating=" + rating + ", actors=" + actors
				+ "]";
	}
	
	
}
