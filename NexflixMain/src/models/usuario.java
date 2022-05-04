package models;

public class usuario {
	// Atributos
	private String email;
	private String password;
	private int codigo;
	private int verificacion;

	// Contructor
	public usuario(String usuario, String password, int codigo, int verificacion) {
		super();
		this.email = usuario;
		this.password = password;
		this.codigo = codigo;
		this.verificacion = verificacion;
	}

	public usuario(int codigo) {
		super();
		this.codigo = codigo;
	}

	public usuario(String password, int verificacion) {
		super();
		this.password = password;
		this.verificacion = verificacion;
	}

	// Getter y setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String usuario) {
		this.email = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(int verificacion) {
		this.verificacion = verificacion;
	}

	// toString
	@Override
	public String toString() {
		return String.format("email [email=%s, password=%s, codigo=%s, verificacion=%s]", email, password, codigo,
				verificacion);
	}
	
	/**
	 * toString que nos devuelve solo el valor de atributo codigo
	 * @return Valor de atributo
	 */
	public int toStringCodigo() {
		return (codigo);
	}

}
