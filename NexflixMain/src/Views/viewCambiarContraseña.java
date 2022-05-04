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

public class viewCambiarContrase�a {
	
	/**
	 * Atributos de la calse viewCambiarContrase�a
	 */
	private JFrame frame;
	private JTextField textEmail;
	private JTextField textNuevaContrase�a;
	private JTextField textConfirmarContrase�a;
	private JLabel lblBanner;
	private  static JButton btnAceptar;
	/**
	 * Create the application.
	 */
	public viewCambiarContrase�a() {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewCambiarContrase�a.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 477, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setBounds(135, 129, 171, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		textNuevaContrase�a = new JTextField();
		textNuevaContrase�a.setText("Nueva contrase�a");
		frame.getContentPane().add(textNuevaContrase�a);
		textNuevaContrase�a.setColumns(10);

		textConfirmarContrase�a = new JTextField();
		textConfirmarContrase�a.setText("Confirmar contrase�a");
		textConfirmarContrase�a.setBounds(135, 191, 171, 20);
		frame.getContentPane().add(textConfirmarContrase�a);
		textConfirmarContrase�a.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarNuevaContrase�a();
			}
		});
		btnAceptar.setBounds(135, 227, 171, 23);
		frame.getContentPane().add(btnAceptar);
		
		lblBanner = new JLabel("New label");
		lblBanner.setIcon(new ImageIcon(viewCambiarContrase�a.class.getResource("/imagenes/titulo.jpg")));
		lblBanner.setBounds(0, 0, 461, 118);
		frame.getContentPane().add(lblBanner);

	}
	
	/**
	 * Metodo que comprueba que las contras�ea nuevas coinciden y si es asi las actualiza en la base de datos
	 */
	public void insertarNuevaContrase�a() {
		String email = textEmail.getText();
		String password = Emailing.hashIt(textNuevaContrase�a.getText());
		if (textNuevaContrase�a.getText().equals(textConfirmarContrase�a.getText())) {
			usuarioDAO.atualizarPassword(email, password);
			frame.dispose();
			new viewLogin();
		}else {
			JOptionPane.showMessageDialog(btnAceptar, "Las contraseñas no coinciden");
		}
	}

}
