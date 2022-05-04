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

public class viewInsertarNuevoCodigo {
	/**
	 * Atributos de la clase viewInsertarNuevoCodigo
	 */
	private JFrame frame;
	private JTextField textEmail;
	private JTextField textNuevoCodigo;
	private JLabel lblNewLabel;

	/**
	 * Create the application.
	 */
	public viewInsertarNuevoCodigo() {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewInsertarNuevoCodigo.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 481, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setBounds(119, 125, 220, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		textNuevoCodigo = new JTextField();
		textNuevoCodigo.setText("Confirma nuevo codigo");
		textNuevoCodigo.setBounds(119, 156, 220, 20);
		frame.getContentPane().add(textNuevoCodigo);
		textNuevoCodigo.setColumns(10);

		JButton btnAceptar = new JButton("Comprobar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarNuevoCodigo();
			}
		});
		btnAceptar.setBounds(119, 187, 220, 23);
		frame.getContentPane().add(btnAceptar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(viewInsertarNuevoCodigo.class.getResource("/imagenes/titulo.jpg")));
		lblNewLabel.setBounds(0, 0, 479, 98);
		frame.getContentPane().add(lblNewLabel);
	}
	
	/**
	 * Metodo para comprobar el nuevo codigo generado enviado para cambiar la contraseña 
	 */
	public void comprobarNuevoCodigo() {
		String email = textEmail.getText();
		usuario nuevoCodigo = usuarioDAO.soloCodigo(email);
		int nuevo = nuevoCodigo.toStringCodigo();

		if (textNuevoCodigo.getText().equals(String.valueOf(nuevo))) {
			System.out.println("Codigo correcto");
			frame.dispose();
			new viewCambiarContraseña();
		} else {
			JOptionPane.showMessageDialog(frame, "Codigo incorrecto");
		}
	}

}
