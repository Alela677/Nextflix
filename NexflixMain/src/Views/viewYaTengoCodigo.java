package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAOS.usuarioDAO;
import models.usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewYaTengoCodigo {
	/**
	 * Atributos de la clase viewYaTengoCodigo
	 */
	private JFrame frame;
	private JTextField textEmail;
	private JTextField textCodigo;
	private JButton btnAceptar;
	private JLabel lblBanner;

	/**
	 * Create the application.
	 */
	public viewYaTengoCodigo() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewYaTengoCodigo.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 485, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textEmail = new JTextField();
		textEmail.setText("alejandrolealastorga@gmail.com");
		textEmail.setBounds(126, 145, 210, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		textCodigo = new JTextField();
		textCodigo.setBounds(126, 176, 210, 20);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yaTengoCodigo();
			}
		});
		btnAceptar.setBounds(240, 207, 96, 23);
		frame.getContentPane().add(btnAceptar);

		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new viewRecuperarContraseña();
			}
		});
		btnAtras.setBounds(134, 207, 96, 23);
		frame.getContentPane().add(btnAtras);
		
		lblBanner = new JLabel("New label");
		lblBanner.setIcon(new ImageIcon(viewYaTengoCodigo.class.getResource("/imagenes/titulo.jpg")));
		lblBanner.setBounds(0, 0, 469, 105);
		frame.getContentPane().add(lblBanner);
	}
	
	/**
	 * En el caso de que al recuperar la contraseña ya tengas codigo lanze uan vista para poner tu email y el codigo al comprobar que el codigo sea correcto pase a la vista donde cambiamos la contraseña
	 */
	public void yaTengoCodigo() {
		String email = textEmail.getText();
		usuario user = usuarioDAO.soloCodigo(email);
		int miCodigo = user.toStringCodigo();

		if (textCodigo.getText().equals(String.valueOf(miCodigo))) {
			JOptionPane.showMessageDialog(btnAceptar, "Codigo incorrecto");
			frame.dispose();
			new viewCambiarContraseña();
		} else {
			JOptionPane.showMessageDialog(btnAceptar, "Codigo incorrecto");
		}
	}
}
