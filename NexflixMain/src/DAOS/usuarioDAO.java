package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import models.usuario;

public class usuarioDAO extends abstracDAO {
	private static usuario login;
	private static usuario favorito;
	private static usuario code;
	
	private static ArrayList<usuario> usuarios = new ArrayList<usuario>();
	
	/**
	 * Metodo para insertar usuarios en la base de datos cuando se regitran
	 * @param Como parametro introducimos un objeto tipo usuario que se almacenara en la base de datos
	 */
	public static void insertaruUsuario(usuario nuevo) {

		final String INSERT = "INSERT INTO usuarios (email, password,codigo,verificacion)" + "values  ('"
				+ nuevo.getEmail() + "','" + nuevo.getPassword() + "','" + nuevo.getCodigo() + "' , '"
				+ nuevo.getVerificacion() + "')";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Metodo que nos devuelve un objeto especifico con la condicion email que introducimos como parametro
	 * @param Introducimos como parameto un email
	 * @return Nos devuelve el objeto que contiene ese email
	 */
	public static usuario usuario(String emailcom) {

		final String QUERY = "SELECT * FROM usuarios WHERE email = '" + emailcom + "'";

		try {

			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {

				String email = rs.getString("email");
				String password = rs.getString("password");
				int codigo = rs.getInt("codigo");
				int verificacion = rs.getInt("verificacion");

				favorito = new usuario(email, password, codigo, verificacion);
				usuarios.add(favorito);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return favorito;

	}
	
	/**
	 * Metodo que nos devulve el codigo de un objeto especifico 
	 * @param Como aprametro instrucimos el email del objeto
	 * @return Nos devuelve el codigo del objeto que contenga dicho email
	 */
	public static usuario soloCodigo(String emailcom) {

		final String QUERY = "SELECT codigo FROM usuarios WHERE email = '" + emailcom + "'";

		try {

			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {

				int codigo = rs.getInt("codigo");

				code = new usuario(codigo);
				usuarios.add(favorito);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return code;

	}
	
	/**
	 * Metodo que al verificarse el ususario pasa de 0 (false) a  1(true)
	 * @param Parametro de entrada utilizamos el email de dicho objeto
	 */
	public static void atualizVerificacion(String email) {

		final String UPDATE = "UPDATE usuarios SET verificacion = '" + 1 + "' WHERE email = '" + email + "'";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que utilizamos para autorizar el login del usuario pedimos a la base de datos el campo password y verificacion para la comprobacion si la contraseña coincide y la verificacino es 1 da permiso para entrar a la aplicacion
	 * @param Como parametro de entradad utilizamos el email de dicho objeto
	 * @return Nos devuelve un obejeto con la verficacion y la contraseña
	 */
	public static usuario passwordVerificacion(String email) {

		final String QUERY = "SELECT password,verificacion FROM usuarios WHERE email = '" + email + "'";

		try {

			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) {

				String password = rs.getString("password");
				int verificacion = rs.getInt("verificacion");

				login = new usuario(password, verificacion);
				usuarios.add(favorito);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	/**
	 * Metodo para actualizar el codigo del usuario en la base de datos
	 * @param Parametro de entrada email de dicho usuario
	 * @param Parametro de entrada codigo de dicho usuario
	 */
	public static void atualizarCodigo(String email, int codigo) {

		final String UPDATE = "UPDATE usuarios SET codigo = '" + codigo + "' WHERE email = '" + email + "'";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para actualizar la contraseña de un usuario que quiere recuperar su contraseña
	 * @param Parametro de entrada email de dicho usuario
	 * @param Parametro de entrada contraseña de dicho usuario
	 */
	public static void atualizarPassword(String email, String password) {

		final String UPDATE = "UPDATE usuarios SET password = '" + password + "' WHERE email = '" + email + "'";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
