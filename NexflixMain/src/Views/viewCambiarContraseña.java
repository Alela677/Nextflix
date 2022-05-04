package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DAOS.usuarioDAO;
import models.Emailing;
import models.usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewCambiarContraseña {
	
	/**
	 * Atributos de la calse viewCambiarContraseña
	 */
	private JFrame frame;
	private JTextField textEmail;
	private JTextField textNuevaContraseña;
	private JTextField textConfirmarContraseña;
	private JLabel lblBanner;
	private  static JButton btnAceptar;
	/**
	 * Create the application.
	 */
	public viewCambiarContraseña() {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewCambiarContraseña.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 477, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setBounds(135, 129, 171, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		textNuevaContraseña = new JTextField();
		textNuevaContraseña.setText("Nueva contraseña");
		frame.getContentPane().add(textNuevaContraseña);
		textNuevaContraseña.setColumns(10);

		textConfirmarContraseña = new JTextField();
		textConfirmarContraseña.setText("Confirmar contraseña");
		textConfirmarContraseña.setBounds(135, 191, 171, 20);
		frame.getContentPane().add(textConfirmarContraseña);
		textConfirmarContraseña.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNuevaContraseña();
			}
		});
		btnAceptar.setBounds(135, 227, 171, 23);
		frame.getContentPane().add(btnAceptar);
		
		lblBanner = new JLabel("New label");
		lblBanner.setIcon(new ImageIcon(viewCambiarContraseña.class.getResource("/imagenes/titulo.jpg")));
		lblBanner.setBounds(0, 0, 461, 118);
		frame.getContentPane().add(lblBanner);

	}
	
	/**
	 * Metodo que comprueba que las contrasñea nuevas coinciden y si es asi las actualiza en la base de datos
	 */
	public void insertarNuevaContraseña() {
		String email = textEmail.getText();
		String password = Emailing.hashIt(textNuevaContraseña.getText());
		if (textNuevaContraseña.getText().equals(textConfirmarContraseña.getText())) {
			usuarioDAO.atualizarPassword(email, password);
			frame.dispose();
			new viewLogin();
		}else {
			JOptionPane.showMessageDialog(btnAceptar, "Las contraseÃ±as no coinciden");
		}
	}

}
