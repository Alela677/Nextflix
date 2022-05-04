package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MainApp.mainApp;
import models.Show;
import java.awt.Toolkit;
import java.awt.Color;

public class viewBusqueda {
	
	/**
	 * Atributos de la clase viewBusqueda
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
	private static JLabel lblBusqueda;
	private static JLabel lblID;
	private static JLabel lblTipo;
	private static int indice;
	private static ArrayList<Show> favoritos = new ArrayList<Show>();
	private JButton btnBuscar;
	private JButton btnVolver;

	/**
	 * Create the application.
	 */
	public viewBusqueda() {
		initialize();
		frame.setVisible(true);
		viewBusqueda();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewBusqueda.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 663, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setForeground(Color.RED);
		lblBusqueda.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblBusqueda.setBounds(243, 29, 128, 26);
		frame.getContentPane().add(lblBusqueda);

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

		JLabel lblAño = new JLabel("AÃ±o");
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

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnBuscar.setBounds(627, 427, 135, 26);
		frame.getContentPane().add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.YELLOW);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pelisViews.busqueda.remove(indice);
				frame.dispose();
				new pelisViews();
			}
		});
		btnVolver.setBounds(548, 342, 89, 23);
		frame.getContentPane().add(btnVolver);

	}
	
	/**
	 * Metodo para imprimir lso objetos de archivo de favoritos es su vista
	 */
	public static void viewBusqueda() {
		Show pintar = pelisViews.busqueda.get(indice);
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

}
