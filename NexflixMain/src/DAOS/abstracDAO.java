package DAOS;

import java.util.ArrayList;

import models.Show;

public abstract class abstracDAO {
	/**
	 * Utilizamo esta clase abstracta para agregar la conexion a la base de datos y no repertirla en cada clase DAO
	 */
	static final String DB_URL = "jdbc:mysql://localhost/peliculas";
	static final String USER = "root";
	static final String PASS = "";
	public static ArrayList<Show> show = new ArrayList<Show>();
}
