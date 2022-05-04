package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import DAOS.usuarioDAO;
import models.usuario;
import models.Emailing;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewRegistro {
	
	/**
	 * Atributos de la clase viewRegistro
	 */
	private JFrame frame;
	public static JTextField txtEmail;
	private JTextField txtContrasea;
	private JButton btnNewButton_1;
	public static String email;
	private JLabel lblNewLabel;

	/**
	 * Create the application.
	 */
	public viewRegistro() {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewRegistro.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 484, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(126, 131, 211, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtContrasea = new JTextField();
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setBounds(126, 162, 211, 20);
		frame.getContentPane().add(txtContrasea);
		txtContrasea.setColumns(10);

		JButton btnNewButton = new JButton("Guardar usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUsuarios();
			}
		});
		btnNewButton.setBounds(126, 193, 211, 23);
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewLogin();
			}
		});
		btnNewButton_1.setBounds(126, 227, 211, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(viewRegistro.class.getResource("/imagenes/titulo.jpg")));
		lblNewLabel.setBounds(0, 0, 468, 105);
		frame.getContentPane().add(lblNewLabel);

	}
	
	/**
	 * Metodo para crear usuarios, una vez registrados pasa a la vista para la confirmacion de la cuenta
	 */
	public void crearUsuarios() {

		email = txtEmail.getText();
		int verificacion = 0;
		int codigo = (int) (10000 * Math.random() * 10);
		usuario creado = new usuario(email, Emailing.hashIt(txtContrasea.getText()), codigo, verificacion);
		usuarioDAO.insertaruUsuario(creado);
		Emailing.Mail(creado.getEmail(), codigo);
		frame.dispose();
		new viewVerificacion();
	}

}
