package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAOS.peliculasDAO;
import MainApp.mainApp;
import models.Show;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import java.awt.Color;

public class viewFavoritos {
	
	/**
	 * Atributos de la clase viewFavoritos
	 */
	private JFrame frame;
	private static JTextField textID;
	private static JTextField textTipo;
	private static JTextField textTitulo;
	private static JTextField textDirector;
	private static JTextField textReparto;
	private static JTextField textPais;
	private static JTextField textFecha;
	private static JTextField textA�o;
	private static JTextField textClasificacion;
	private static JTextField textDuracion;
	private static JTextField textListado;
	private static JTextField textDescripcion;
	private static JLabel lblNewLabel;
	private static JLabel lblID;
	private static JLabel lblTipo;
	private static int indice;
	private JButton btnAtras;
	private static JButton btneliminarFavoritos;
	private static JButton btnvolcarFichero;

	/**
	 * Create the application.
	 */
	public viewFavoritos() {
		initialize();
		frame.setVisible(true);
		indice = 0;
		pintarFavoritos();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(viewFavoritos.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 659, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Favoritos");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(249, 11, 126, 52);
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
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(10, 377, 46, 14);
		frame.getContentPane().add(lblFecha);

		JLabel lblA�o = new JLabel("A�o");
		lblA�o.setForeground(Color.WHITE);
		lblA�o.setBounds(195, 224, 46, 14);
		frame.getContentPane().add(lblA�o);

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

		textA�o = new JTextField();
		textA�o.setEditable(false);
		textA�o.setBounds(265, 221, 86, 20);
		frame.getContentPane().add(textA�o);
		textA�o.setColumns(10);

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

		JButton btnNewButton = new JButton("<");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atras();
			}
		});
		btnNewButton.setBounds(53, 17, 89, 52);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delante();
			}
		});
		btnNewButton_1.setBounds(482, 11, 89, 58);
		frame.getContentPane().add(btnNewButton_1);

		btnAtras = new JButton("Atras");
		btnAtras.setBackground(Color.YELLOW);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new pelisViews();

			}
		});
		btnAtras.setBounds(527, 373, 89, 23);
		frame.getContentPane().add(btnAtras);

		JButton btnvolcarFichero = new JButton("Imprimir favoritos");
		btnvolcarFichero.setBackground(Color.YELLOW);
		btnvolcarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirFich();
			}
		});
		btnvolcarFichero.setBounds(391, 373, 126, 23);
		frame.getContentPane().add(btnvolcarFichero);

	}
	
	/**
	 * Metodo para imprimir los objetos favoritos
	 */
	public static void pintarFavoritos() {
		Show pintar = pelisViews.pintarFavoritos.get(indice);
		textID.setText(pintar.getShow_id());
		textTipo.setText(pintar.getType());
		textTitulo.setText(pintar.getTitle());
		textDirector.setText(pintar.getDirector());
		textReparto.setText(pintar.getCast());
		textPais.setText(pintar.getCountry());
		textFecha.setText(pintar.getDate_added());
		textA�o.setText(pintar.getRelease_year());
		textClasificacion.setText(pintar.getRating());
		textDuracion.setText(pintar.getDuration());
		textListado.setText(pintar.getListed_in());
		textDescripcion.setText(pintar.getDescription());
	}
	
	/**
	 * Metodo para avanzar una posicion en el ArrayList
	 */
	public void Delante() {
		indice++;

		if (indice == mainApp.shows.size()) {

			indice = 0;
		}

		pintarFavoritos();
	}
	
	/**
	 * Metodo para retroceder una posicion en el ArrayList
	 */
	public void Atras() {
		indice--;

		if (indice == mainApp.shows.size() - 1) {

			indice = 0;
		}

		pintarFavoritos();
	}
	
	/**
	 * Metodo para imprimir los objetos que este en el fichero favoritos sobre un fichero nuevo con el nombre que ponga el usuario y el delimitador por cada linea que ponga el usuario
	 */
	public static void imprimirFich() {

		try {
			String nombreFich = JOptionPane.showInputDialog("Escribe un nombre para el fichero con formato.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFich + ".csv"));

			int contador = 0;
			for (Show favorito : pelisViews.pintarFavoritos) {
				contador++;
				String delimitador = JOptionPane
						.showInputDialog("Elige un delimitador para el fichero para la linea: " + contador);
				String lineas = favorito.toStringDelimitador(delimitador);
				bw.append(lineas.replaceAll(";", ",") + "\n");
				JOptionPane.showMessageDialog(btnvolcarFichero, "Fichero creado con éxitoo");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
