package co.movies.rest.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/sakila?useSSL=false", "sakila",
				"sakila");
		return con;
	}
	
	public List<Film_List> getByTitle(String title) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film_List film_List = null;
		List<Film_List> filmList = new ArrayList<Film_List>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from film_list where upper(title) like upper(?)");
			ps.setString(1, title + "%");
			rs = ps.executeQuery();
			buildFilmObject(rs, filmList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return filmList;
	}
	
	public List<Film_List> getByTitleRatingAndCategory(String title, String rating, String category) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film_List film_List = null;
		List<Film_List> filmList = new ArrayList<Film_List>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from film_list where upper(title) like upper(?) and rating=? and category=?");
			ps.setString(1, title + "%");
			ps.setString(2, rating);
			ps.setString(3, category);
			rs = ps.executeQuery();
			buildFilmObject(rs, filmList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return filmList;		
	}

	private void buildFilmObject(ResultSet rs, List<Film_List> filmList) throws SQLException {
		Film_List film_List;
		while (rs.next()) {
			film_List = new Film_List();
			film_List.setFilm_Id(rs.getInt(1));
			film_List.setTitle(rs.getString(2));
			film_List.setDescription(rs.getString(3));
			film_List.setCategory(rs.getString(4));
			film_List.setPrice(rs.getFloat(5));
			film_List.setLength(rs.getInt(6));
			film_List.setRating(rs.getString(7));
			String[] actorArra = rs.getString(8).split(",");
			film_List.setActors(Arrays.asList(actorArra));
			filmList.add(film_List);
		}
	}

	
	public List<Film_List> getByTitleAndCategory(String title, String category) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film_List film_List = null;
		List<Film_List> filmList = new ArrayList<Film_List>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from film_list where upper(title) like upper(?) and category=?");
			ps.setString(1, title + "%");
			ps.setString(2, category);
			rs = ps.executeQuery();
			buildFilmObject(rs, filmList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return filmList;		
	}
		
	

	
	public List<Film_List> getByTitleAndRating(String title, String rating) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film_List film_List = null;
		List<Film_List> filmList = new ArrayList<Film_List>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from film_list where upper(title) like upper(?) and rating=?");
			ps.setString(1, title + "%");
			ps.setString(2, rating);
			rs = ps.executeQuery();
			buildFilmObject(rs, filmList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return filmList;		
	}
	




	public List<Film> getByFilmDetails(String title) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film film = null;
		List<Film> film_details = new ArrayList<Film>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from film where title like ?");
			ps.setString(1,  title + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setFilm_Id(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setRelease_year(rs.getString(4));
				film.setLanguage_Id(rs.getInt(5));
				film.setOriginal_language_Id(rs.getInt(6));
				film.setRental_duration(rs.getInt(7));
				film.setRental_rate(rs.getFloat(8));
				film.setLength(rs.getInt(9));
				film.setReplacement_cost(rs.getFloat(10));
				film.setRating(rs.getString(11));
				// String[] specialFeatureArr = rs.getString("8").split(",");
				// film.setSpecial_features(Arrays.asList(specialFeatureArr));
				Set<String> valueSet = new HashSet<String>();
				Collections.addAll(valueSet, rs.getString(12).split(","));

				film.setLast_update(rs.getDate(13));
				film_details.add(film);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return film_details;

	}

	public List<Film_List> getActors(String title) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Film_List actors = null;
		List<Film_List> actors_list = new ArrayList<Film_List>();
		try {
			con = getConnection();
			ps = con.prepareStatement("select fid, length, actors from film_list where title like ?");
			ps.setString(1,  title + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				actors = new Film_List();
				actors.setFilm_Id(rs.getInt(1));
				actors.setLength(rs.getInt(2));
				String[] actorArra = rs.getString(3).split(",");
				actors.setActors(Arrays.asList(actorArra));
				actors_list.add(actors);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return actors_list;

	}

}
