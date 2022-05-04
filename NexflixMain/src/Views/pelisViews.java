package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;

import DAOS.peliculasDAO;
import MainApp.mainApp;
import models.Show;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class pelisViews {

	/**
	 * Atributos de la vista pelisViews
	 */
	private JFrame frame;
	private static JTextField textID;
	private static JTextField textTipo;
	private static JTextField textTitulo;
	private static JTextField textDirector;
	private static JTextField textReparto;
	private static JTextField textPais;
	private static JTextField textFecha;
	private static JTextField textAño;
	private static JTextField textClasificacion;
	private static JTextField textDuracion;
	private static JTextField textListado;
	private static JTextField textDescripcion;
	private static JLabel lblNewLabel;
	private static JLabel lblID;
	private static JLabel lblTipo;
	private static peliculasDAO peliculasDAO;
	private static int indice;
	private mainApp main;
	private static ArrayList<Show> añadidos = new ArrayList<Show>();
	private JButton btnBuscar;
	private static JTextField textBuscar;
	private JButton btnviewFavoritos;
	public static ArrayList<Show> busqueda = new ArrayList<Show>();
	public static ArrayList<Show> pintarFavoritos = new ArrayList<Show>();

	/**
	 * Create the application.
	 */
	public pelisViews() {
		main = new mainApp();
		initialize();
		frame.setVisible(true);
		indice = 0;
//		insertarPeliculas();
		viewPeliculas();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(pelisViews.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 654, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Peliculas");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(241, 21, 128, 59);
		frame.getContentPane().add(lblNewLabel);

		lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(10, 103, 69, 14);
		frame.getContentPane().add(lblID);

		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(81, 100, 86, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);

		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(10, 144, 46, 14);
		frame.getContentPane().add(lblTipo);

		textTipo = new JTextField();
		textTipo.setEditable(false);
		textTipo.setBounds(81, 141, 86, 20);
		frame.getContentPane().add(textTipo);
		textTipo.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 181, 46, 14);
		frame.getContentPane().add(lblTitulo);

		textTitulo = new JTextField();
		textTitulo.setEditable(false);
		textTitulo.setBounds(81, 178, 86, 20);
		frame.getContentPane().add(textTitulo);
		textTitulo.setColumns(10);

		JLabel lblDirector = new JLabel("Director");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setBounds(10, 224, 46, 14);
		frame.getContentPane().add(lblDirector);

		JLabel lblReparto = new JLabel("Reparto");
		lblReparto.setForeground(Color.WHITE);
		lblReparto.setBounds(10, 307, 46, 14);
		frame.getContentPane().add(lblReparto);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setForeground(Color.WHITE);
		lblPais.setBounds(195, 181, 46, 14);
		frame.getContentPane().add(lblPais);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 377, 46, 14);
		frame.getContentPane().add(lblFecha);

		JLabel lblAño = new JLabel("Año");
		lblAño.setForeground(Color.WHITE);
		lblAño.setBounds(195, 224, 46, 14);
		frame.getContentPane().add(lblAño);

		JLabel lblClasificacion = new JLabel("Calsificacion");
		lblClasificacion.setForeground(Color.WHITE);
		lblClasificacion.setBounds(194, 103, 75, 14);
		frame.getContentPane().add(lblClasificacion);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setBounds(194, 144, 62, 14);
		frame.getContentPane().add(lblDuracion);

		JLabel lblListado = new JLabel("Listado en: ");
		lblListado.setForeground(Color.WHITE);
		lblListado.setBounds(10, 346, 69, 14);
		frame.getContentPane().add(lblListado);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(10, 272, 73, 14);
		frame.getContentPane().add(lblDescripcion);

		textDirector = new JTextField();
		textDirector.setEditable(false);
		textDirector.setBounds(81, 221, 86, 20);
		frame.getContentPane().add(textDirector);
		textDirector.setColumns(10);

		textReparto = new JTextField();
		textReparto.setEditable(false);
		textReparto.setBounds(81, 304, 547, 20);
		frame.getContentPane().add(textReparto);
		textReparto.setColumns(10);

		textPais = new JTextField();
		textPais.setEditable(false);
		textPais.setBounds(265, 178, 86, 20);
		frame.getContentPane().add(textPais);
		textPais.setColumns(10);

		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(81, 374, 188, 20);
		frame.getContentPane().add(textFecha);
		textFecha.setColumns(10);

		textAño = new JTextField();
		textAño.setEditable(false);
		textAño.setBounds(265, 221, 86, 20);
		frame.getContentPane().add(textAño);
		textAño.setColumns(10);

		textClasificacion = new JTextField();
		textClasificacion.setEditable(false);
		textClasificacion.setBounds(265, 100, 86, 20);
		frame.getContentPane().add(textClasificacion);
		textClasificacion.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setEditable(false);
		textDuracion.setBounds(265, 141, 86, 20);
		frame.getContentPane().add(textDuracion);
		textDuracion.setColumns(10);

		textListado = new JTextField();
		textListado.setEditable(false);
		textListado.setBounds(79, 343, 350, 20);
		frame.getContentPane().add(textListado);
		textListado.setColumns(10);

		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(81, 269, 547, 20);
		frame.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);

		textBuscar = new JTextField();
		textBuscar.setBounds(493, 100, 135, 20);
		frame.getContentPane().add(textBuscar);
		textBuscar.setColumns(10);

		JButton btnNewButton = new JButton("<");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atras();
			}
		});
		btnNewButton.setBounds(52, 20, 89, 66);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delante();
			}
		});
		btnNewButton_1.setBounds(482, 20, 89, 59);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnañadirFavoritos = new JButton("Añadir Favoritos");
		btnañadirFavoritos.setBackground(Color.YELLOW);
		btnañadirFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				añadirFavoritoFichero();

			}
		});
		btnañadirFavoritos.setBounds(372, 140, 111, 23);
		frame.getContentPane().add(btnañadirFavoritos);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.YELLOW);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar(textBuscar.getText());
				frame.dispose();
				new viewBusqueda();
			}
		});
		btnBuscar.setBounds(372, 99, 111, 23);
		frame.getContentPane().add(btnBuscar);

		btnviewFavoritos = new JButton("Ver Favoritos");
		btnviewFavoritos.setBackground(Color.YELLOW);
		btnviewFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFavoritoFich();
				frame.dispose();
				new viewFavoritos();
			}
		});
		btnviewFavoritos.setBounds(372, 177, 111, 23);
		frame.getContentPane().add(btnviewFavoritos);

	}
	
	/**
	 * Metodo para imprimir cada atributo del objeto Show en cada campo de texto correspondiente
	 */
	public static void viewPeliculas() {
		Show pintar = mainApp.shows.get(indice);
		textID.setText(pintar.getShow_id());
		textTipo.setText(pintar.getType());
		textTitulo.setText(pintar.getTitle());
		textDirector.setText(pintar.getDirector());
		textReparto.setText(pintar.getCast());
		textPais.setText(pintar.getCountry());
		textFecha.setText(pintar.getDate_added());
		textAño.setText(pintar.getRelease_year());
		textClasificacion.setText(pintar.getRating());
		textDuracion.setText(pintar.getDuration());
		textListado.setText(pintar.getListed_in());
		textDescripcion.setText(pintar.getDescription());
	}
	
	/**
	 * Metodo que avanza una posicion en el ArrayList
	 */
	public void Delante() {
		indice++;

		if (indice == mainApp.shows.size()) {

			indice = 0;
		}

		viewPeliculas();
	}
	/**
	 *	Metodo que retrocede una posicion en el ArrayList 
	 */
	public void Atras() {
		indice--;

		if (indice == mainApp.shows.size()) {

			indice = 0;
		}

		viewPeliculas();
	}
	
	/**
	 * Metodo para buscar una pelicula del archivo shows.csv
	 * @param Parametro de entra un texto que buscar tiene que ser un año, titulo,ciudad o director
	 * @return Nos devuelve un objeto que contenga en alguna de sus partes señaladas el texto introducido 
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static Show buscar(String string) {
		Show buscado = null;
		for (Show show : mainApp.shows) {
			if (string.equals(show.getRelease_year()) || string.equals(show.getTitle())
					|| string.equals(show.getCountry()) || string.equals(show.getDirector())) {
//				System.out.println(show);
				buscado = show;
				busqueda.add(buscado);
			}
		}
		return buscado;
	}
	
	/**
	 * Metodo para añadir un objeto favorito a al fichero de favoritos
	 */
	public static void añadirFavoritoFichero() {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("fichFvoritos.csv"));
			Show añadir = mainApp.shows.get(indice);
			añadidos.add(añadir);
			for (Show show : añadidos) {
				String linea = show.toStringFich();
				bw.append(linea + "\n");
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo para imprimir en una vista los objetos favoritos seleccionadors anteriormente
	 */
	public void viewFavoritoFich() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("fichFvoritos.csv"));
			String linea = br.readLine();

			while (linea != null) {
				System.out.println(linea);
				String[] partes = linea.split(",");
				Show vista = new Show(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5], partes[6],
						partes[7], partes[8], partes[9], partes[10], partes[11]);
				pintarFavoritos.add(vista);
				linea = br.readLine();
			}
			br.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
