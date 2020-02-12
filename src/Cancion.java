
public class Cancion {
	
	private int cod;
	private String titulo;
	private int duracion;
	
	public Cancion() {
		super();
	}

	public Cancion(int cod, String titulo, int duracion) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Cancion [cod=" + cod + ", titulo=" + titulo + ", duracion=" + duracion + "]";
	}

	
	
}
