package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import DAOS.usuarioDAO;
import models.usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewVerificacion {
	
	/**
	 * Atributos de la clase viewVerificacion
	 */
	private JFrame frame;
	private JTextField textComprobar;
	private JLabel lblBanner;

	/**
	 * Create the application.
	 */
	public viewVerificacion() {
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(viewVerificacion.class.getResource("/imagenes/Netflix_icon.svg.png")));
		frame.setBounds(100, 100, 474, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textComprobar = new JTextField();
		textComprobar.setText("Codigo");
		textComprobar.setBounds(143, 152, 169, 20);
		frame.getContentPane().add(textComprobar);
		textComprobar.setColumns(10);

		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarCodigo();
			}
		});
		btnComprobar.setBounds(143, 182, 169, 23);
		frame.getContentPane().add(btnComprobar);
		
		lblBanner = new JLabel("New label");
		lblBanner.setIcon(new ImageIcon(viewVerificacion.class.getResource("/imagenes/titulo.jpg")));
		lblBanner.setBounds(0, 0, 458, 114);
		frame.getContentPane().add(lblBanner);

	}
	
	/**
	 * Metodo para comprobar el codigo de verificacion en el caso de que sea correcto verificacion pasa a ser 1(true)
	 */
	public void comprobarCodigo() {
		String email = viewRegistro.email;
		usuario comprobar = usuarioDAO.usuario(email);
		usuario codigo = usuarioDAO.soloCodigo(email);
		System.out.println(comprobar);
		System.out.println("Codigo: " + codigo.toStringCodigo());

		if (textComprobar.getText().equals(String.valueOf(codigo.toStringCodigo()))) {
			System.out.println("correcto");
			usuarioDAO.atualizVerificacion(email);
			frame.dispose();
			new viewLogin();
		} else
			JOptionPane.showMessageDialog(frame, "Codigo erroneo");
	}

}
