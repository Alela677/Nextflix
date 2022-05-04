package MainApp;

import java.awt.LinearGradientPaint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.UnderlineAction;


import DAOS.peliculasDAO;
import Views.pelisViews;
import Views.viewLogin;
import models.Show;

public class mainApp {
	
	/**
	 * Atributos clase mainApp para leer ficheros
	 */
	private static Show nuevo;
	private static peliculasDAO peliculas = new peliculasDAO();
	public static ArrayList<Show> shows = new ArrayList<Show>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/**
			 * Metodo para leer el fichero shows.csv, hacemos split para separarlos en parte y añadir cada parte a un objeto
			 */
		try {

			BufferedReader br = new BufferedReader(new FileReader("shows.csv"));
			br.readLine();
			String linea = br.readLine();

			while (linea != null) {

				String[] comillas = linea.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				String titulo = null;
				if (comillas[2].startsWith("\"")) {
					titulo = comillas[2].substring(1, comillas[2].length() - 1).replaceAll(",", ";");
				} else {
					titulo = comillas[2];
				}
				String cast = comillas[4].substring(1, comillas[4].length() - 1).replaceAll(",", ";");
				String date = comillas[6].substring(1, comillas[6].length() - 1).replaceAll(",", ";");
				;
				String listed = comillas[10].substring(1, comillas[10].length() - 1).replaceAll(",", ";");
				;
				String descri = comillas[11].substring(1, comillas[11].length() - 1).replaceAll(",", ";");
				nuevo = new Show(comillas[0], comillas[1], titulo, comillas[3], cast, comillas[5], date, comillas[7],
						comillas[8], comillas[9], listed, descri);

				linea = br.readLine();
				peliculas.insertarPeliculas(nuevo);
//				System.out.println(linea);
				shows.add(nuevo);
				for (Show s : shows) {
//					System.out.println(s);
				}

			}

			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		new viewLogin();

	}

}
