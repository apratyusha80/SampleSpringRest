package co.movies.rest.test;


import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Film  {

	private int film_Id;
	private String title;
	private String description;
	private String release_year;
	private int language_Id;
	private int original_language_Id;
	private int rental_duration;
	private float rental_rate;
	private int length;
	private float replacement_cost;
	private String rating;
	private Set<String> special_features;
	private Date last_update;
	
	public Set<String> getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(Set<String> special_features) {
		this.special_features = special_features;
	}
	
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
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
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public int getLanguage_Id() {
		return language_Id;
	}
	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}
	public int getOriginal_language_Id() {
		return original_language_Id;
	}
	public void setOriginal_language_Id(int original_language_Id) {
		this.original_language_Id = original_language_Id;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public float getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(float rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(float replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Film [film_Id=" + film_Id + ", title=" + title + ", description=" + description + ", release_year="
				+ release_year + ", language_Id=" + language_Id + ", original_language_Id=" + original_language_Id
				+ ", rental_duration=" + rental_duration + ", rental_rate=" + rental_rate + ", length=" + length
				+ ", replacement_cost=" + replacement_cost + ", rating=" + rating + ", special_features="
				+ special_features + ", last_update=" + last_update + "]";
	}

	
}
