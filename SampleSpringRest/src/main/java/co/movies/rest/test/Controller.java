package co.movies.rest.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/movies")
public class Controller {

	


	@RequestMapping(value = "/getByTitle", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getByTitle(@RequestParam("title") String title,
			@RequestParam(value="rating", required = false) String rating,
			@RequestParam(value="category", required = false) String category) {
		FilmDAO dao = new FilmDAO();
		Gson gson = new Gson();
		String jsonData = null;
		List<Film_List> filmList = new ArrayList<Film_List>();

		if(rating !=null && !rating.isEmpty() && category != null && !category.isEmpty()) {
			filmList = dao.getByTitleRatingAndCategory(title, rating, category);
			jsonData = gson.toJson(filmList);
			return ResponseEntity.ok(jsonData);
		}else if (rating !=null && !rating.isEmpty()) {
			
			filmList = dao.getByTitleAndRating(title, rating);
			jsonData = gson.toJson(filmList);
			return ResponseEntity.ok(jsonData);			
		}else if(category != null && !category.isEmpty()) {
			
			filmList = dao.getByTitleAndCategory(title, category);
			jsonData = gson.toJson(filmList);
			return ResponseEntity.ok(jsonData);			
		}else {
			filmList = dao.getByTitle(title);
			jsonData = gson.toJson(filmList);
			return ResponseEntity.ok(jsonData);			
		}
	}	

	

	@RequestMapping(value = "/getByFilmDetails", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getByFilmDetails(@RequestParam("title") String title) {
		FilmDAO dao = new FilmDAO();
		List<Film> film_details = dao.getByFilmDetails(title);
		Gson gson = new Gson();
		String jsonData = gson.toJson(film_details);
		return ResponseEntity.ok(jsonData);
	}

	@RequestMapping(value = "/getActors", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getActors(@RequestParam("title") String title) {
		FilmDAO dao = new FilmDAO();
		List<Film_List> actors_list = dao.getActors(title);
		Gson gson = new Gson();
		String jsonData = gson.toJson(actors_list);
		return ResponseEntity.ok(jsonData);
	}

}
