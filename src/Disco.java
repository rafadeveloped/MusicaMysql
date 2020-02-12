
public class Disco {
	
	private int cod;
	private String nombre;
	private String fecha;
	private int cod_comp;
	private int cod_gru;
	
	public Disco() {
		super();
	}

	public Disco(int cod, String nombre, String fecha, int cod_comp, int cod_gru) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.fecha = fecha;
		this.cod_comp = cod_comp;
		this.cod_gru = cod_gru;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCod_comp() {
		return cod_comp;
	}

	public void setCod_comp(int cod_comp) {
		this.cod_comp = cod_comp;
	}

	public int getCod_gru() {
		return cod_gru;
	}

	public void setCod_gru(int cod_gru) {
		this.cod_gru = cod_gru;
	}

	@Override
	public String toString() {
		return "Disco [cod=" + cod + ", nombre=" + nombre + ", fecha=" + fecha + ", cod_comp=" + cod_comp + ", cod_gru="
				+ cod_gru + "]";
	}
}
