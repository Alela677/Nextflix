package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Show;

public class peliculasDAO extends abstracDAO {
	
	/**
	 * Metodo para insertar las peliculas en la base de datos
	 * @param Introducimos como parametro un objeto tipo Show
	 */
	public static void insertarPeliculas(Show nuevo) {

		final String INSERT = "INSERT INTO  peliculas (id,type,tittle,director,cast,country,date,release_year,rating,duration,listed_in,description )"
				+ "values  ('" + nuevo.getShow_id() + "','" + nuevo.getType() + "','" + nuevo.getTitle() + "','"
				+ nuevo.getDirector() + "','" + nuevo.getCast() + "','" + nuevo.getCountry() + "','"
				+ nuevo.getDate_added() + "','" + nuevo.getRelease_year() + "','" + nuevo.getRating() + "','"
				+ nuevo.getDuration() + "','" + nuevo.getListed_in() + "','" + nuevo.getDescription() + "')";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
//			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para hacer una select a la base de datos, crea objetos tipo Show con los campos registrados en la base de datos y nos añade dicho objetos a un ArrayList
	 */
	public static void verPeliculas() {
		final String QUERY = "SELECT id,type,tittle,director,cast,country,date,release_year,rating,duration,listed_in,description FROM peliculas";

		try {

			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {
				String ID = rs.getString("id");
				String Tipo = rs.getString("type");
				String titulo = rs.getString("tittle");
				String director = rs.getString("director");
				String cast = rs.getString("cast");
				String country = rs.getString("country");
				String date = rs.getString("date");
				String release = rs.getString("release_year");
				String raiting = rs.getString("rating");
				String duration = rs.getString("duration");
				String listed = rs.getString("listed_in");
				String description = rs.getString("description");
				Show nuevo = new Show(ID, Tipo, titulo, director, cast, country, date, release, raiting, duration,
						listed, description);
				show.add(nuevo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
