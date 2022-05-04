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
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewRecuperarContraseña {
	/**
	 * Atibutos de la clase viewRecuperarContraseña
	 */
	private JFrame frame;
	private JTextField txtEmail;

	/**
	 * Create the application.
	 */
	public viewRecuperarContraseña() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewRecuperarContraseña.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(146, 147, 190, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnEnviarNuevoCodigo = new JButton("Enviar codigo");
		btnEnviarNuevoCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarNuevoCodigo();
			}
		});
		btnEnviarNuevoCodigo.setBounds(146, 178, 190, 23);
		frame.getContentPane().add(btnEnviarNuevoCodigo);

		JButton btnTengoCodigo = new JButton("Ya tengo codigo");
		btnTengoCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new viewYaTengoCodigo();
			}
		});
		btnTengoCodigo.setBounds(146, 212, 190, 23);
		frame.getContentPane().add(btnTengoCodigo);
		
		JLabel lblBanner = new JLabel("New label");
		lblBanner.setIcon(new ImageIcon(viewRecuperarContraseña.class.getResource("/imagenes/titulo.jpg")));
		lblBanner.setBounds(0, 0, 484, 109);
		frame.getContentPane().add(lblBanner);
	}
	
	/**
	 * Metod que envia un nuevo codigo y lo envia por email en caso de que quieras recuperar la contraseña
	 */
	public void enviarNuevoCodigo() {
		String email = txtEmail.getText();
		int nuevoCodigo = (int) (10000 * Math.random() * 10);
		usuario actualizar = usuarioDAO.usuario(email);
//		System.out.println(actualizar);
		Emailing.Mail(email, nuevoCodigo);
		usuarioDAO.atualizarCodigo(email, nuevoCodigo);
//		System.out.println(usuarioDAO.usuario(email));
		frame.dispose();
		new viewInsertarNuevoCodigo();
	}

}
