package Views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAOS.usuarioDAO;
import models.usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import models.Emailing;
import javax.swing.JSlider;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewLogin {
	
	/**
	 * Atributos de la clse viewLogin
	 */
	private JFrame frame;
	private JTextField txtEmail;
	private static JTextField txtContraseña;
	private static JButton btnNewButton;
	private JLabel lblTitul;

	/**
	 * Create the application.
	 */
	public viewLogin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param <pelisView>
	 */
	private <pelisView> void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(viewLogin.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 484, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setBounds(125, 131, 211, 20);
		txtEmail.setText("Email");
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(125, 162, 211, 20);
		txtContraseña.setText("Contraseña");
		frame.getContentPane().add(txtContraseña);
		txtContraseña.setColumns(10);

		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.setBounds(125, 193, 112, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registrate");
		btnNewButton_1.setBounds(236, 193, 100, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new viewRegistro();
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Recuperar contraseña");
		btnNewButton_2.setBounds(125, 227, 211, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new viewCambiarContraseña();
			}
		});
		frame.getContentPane().add(btnNewButton_2);

		lblTitul = new JLabel("New label");
		lblTitul.setIcon(new ImageIcon(viewLogin.class.getResource("/imagenes/titulo.jpg")));
		lblTitul.setBounds(0, 0, 481, 127);
		frame.getContentPane().add(lblTitul);

	}

	/**
	 * Metodo que conprueba que el usuario que va a iniciar sesion, la contraseña introducida sea correcta y la verificacion sea 1
	 */
	public void iniciarSesion() {

		String email = txtEmail.getText();
		usuario iniciar = usuarioDAO.passwordVerificacion(email);
		String contraseña = Emailing.hashIt(txtContraseña.getText());
		System.out.println();
		System.out.println(iniciar);
		if (iniciar.getPassword().equals(contraseña) && iniciar.getVerificacion() == 1) {
			System.out.println("Estas dentro");
			JOptionPane.showMessageDialog(btnNewButton, "Contraseña correcta");
			frame.dispose();
			new pelisViews();
		} else {
			System.out.println("No estas dentro");
			JOptionPane.showMessageDialog(btnNewButton, "Contraseña incorrecta");
		}

	}
}
