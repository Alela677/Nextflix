package models;

public class Show {
	
	/**
	 * Atributos clase show 
	 */
	private String show_id;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String date_added;
	private String release_year;
	private String rating;
	private String duration;
	private String listed_in;
	private String description;
	
	/**
	 * Cosnstructor clase Show
	 * @param show_id
	 * @param type
	 * @param title
	 * @param director
	 * @param cast
	 * @param country
	 * @param date_added
	 * @param release_year
	 * @param rating
	 * @param duration
	 * @param listed_in
	 * @param description
	 */
	public Show(String show_id, String type, String title, String director, String cast, String country,
			String date_added, String release_year, String rating, String duration, String listed_in,
			String description) {
		super();
		this.show_id = show_id;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date_added = date_added;
		this.release_year = release_year;
		this.rating = rating;
		this.duration = duration;
		this.listed_in = listed_in;
		this.description = description;
	}
	
	/**
	 * Getter y setter clase show
	 * @return
	 */
	public String getShow_id() {
		return show_id;
	}

	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getListed_in() {
		return listed_in;
	}

	public void setListed_in(String listed_in) {
		this.listed_in = listed_in;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * toString que imprime el objeto de tipo show con sus atributos
	 */
	@Override
	public String toString() {
		return String.format(
				"Show [show_id=%s, type=%s, title=%s, director=%s, cast=%s, country=%s, date_added=%s, release_year=%s, rating=%s, duration=%s, listed_in=%s, description=%s]",
				show_id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in,
				description);
	}
	
	/**
	 * toString que imprime solo los valores de los atributos de los objeto tipo Show
	 * @return
	 */
	public String toStringFich() {
		return String.format(
				show_id + "," + type + "," + title + "," + director + "," + cast + "," + country + "," + date_added
						+ "," + release_year + "," + rating + "," + duration + "," + listed_in + "," + description);
	}

	/**
	 * toString que imprime los objetos tipo show con un delimitador especifico
	 * @param Parametro de entrada un delimitador 
	 * @return Nos devuelve el objeto con el delimitador nuevo
	 */
	public String toStringDelimitador(String delimitador) {
		return String.format(show_id + delimitador + type + delimitador + title + delimitador + director + delimitador
				+ cast + delimitador + country + delimitador + date_added + delimitador + release_year + delimitador
				+ rating + delimitador + duration + delimitador + listed_in + delimitador + description);
	}
}
