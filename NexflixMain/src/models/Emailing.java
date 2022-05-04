package models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailing {
	
	static String username = "ratatasalvaje1dam";
	static String password = "Pollofrit0!";

	public static void main(String[] args) {
		try {
			System.out.println(hashIt("hola"));
			// Mail("ignacio.lorenzo@iespablopicasso.es","000000");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Metodod para enviar un email a un direccion de email especificada con su codigo correspondiente de verificacion 
	 */
	
	public static void Mail(String email, int codigo) {

//Leer fichero para credenciales.

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email)); // Quiï¿½n soy yo
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // Destinatario

			message.setSubject("Tu codigo");
			message.setText("Tu codigo es: " + codigo);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para hashear la contraseña 
	 * @param Parametro de entrada la contraseña 
	 * @return Nos devuelve la contraseña encriptada
	 */
	public static String hashIt(String passwordToHash) {
		String salt = "1234567890";
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt.getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
