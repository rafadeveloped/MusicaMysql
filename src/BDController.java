import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {

	private Connection conexion;

	BDController() {
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica20", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Error en el construtor vacio de BDControler.");
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Artista> artistas() {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("SELECT * FROM artista");
			while (rs.next() == true) {
				Artista opo = new Artista(rs.getString("dni"), rs.getString("nombre"));
				artistas.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return artistas;
	}

	public ArrayList<Artista> artistasLetra(String letra) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("SELECT * FROM artista where nombre like '" + letra + "%';");
			while (rs.next() == true) {
				Artista opo = new Artista(rs.getString("dni"), rs.getString("nombre"));
				artistas.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return artistas;
	}

	public ArrayList<Artista> artistasAlta(String dnialta, String nombrealta) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			String insercion = ("insert into artista (dni, nombre) values ('" + dnialta + "', '" + nombrealta + "');");
			miStatement.executeUpdate(insercion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return artistas;
	}

	public ArrayList<Artista> artistasBaja(String dnibaja) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			String eliminacion = "delete from artista where dni = '" + dnibaja + "';";
			miStatement.executeUpdate(eliminacion);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return artistas;
	}

	public ArrayList<Artista> artistasDniletra(String ndni) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select * from artista where dni like '%" + ndni + "';");
			while (rs.next() == true) {
				Artista opo = new Artista(rs.getString("dni"), rs.getString("nombre"));
				artistas.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return artistas;
	}

	public ArrayList<Cancion> listaCanciones() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select * from cancion;");
			while (rs.next() == true) {
				Cancion opo = new Cancion(rs.getInt("cod"), rs.getString("titulo"), rs.getInt("duracion"));
				canciones.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> cancionLarga() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select max(duracion) from cancion;");
			while (rs.next() == true) {
				Cancion opo = new Cancion(rs.getInt("cod"), rs.getString("titulo"), rs.getInt("duracion"));
				canciones.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> noLarga(String duracion) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select * from cancion  where not duracion = '" + duracion + "';");
			while (rs.next() == true) {
				Cancion opo = new Cancion(rs.getInt("cod"), rs.getString("titulo"), rs.getInt("duracion"));
				canciones.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> cancionesDisco(String nombre) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("SELECT * FROM CANCION, ESTA, DISCO WHERE DISCO.nombre LIKE '"
					+ nombre + "' AND CANCION.cod = ESTA.can AND ESTA.cod = DISCO.cod ORDER BY CANCION.titulo DESC");
			while (rs.next() == true) {
				Cancion opo = new Cancion(rs.getInt("cod"), rs.getString("titulo"), rs.getInt("duracion"));
				canciones.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> cancionesAlta(int cod, String titulo, int duracioncancion) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			String insercion = ("insert into cancion (cod, titulo, duracion) values ('" + cod + "', '" + titulo + "','"
					+ duracioncancion + "');");
			miStatement.executeUpdate(insercion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return canciones;
	}

	public boolean cancionesExistentes(int cod) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Select * from cancion where cod = ";
			ResultSet rs = miStatement.executeQuery(cadena + cod + ";");
			while (rs.next()) {
				existe = true;
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en método existe cancion: " + e.getMessage());
		}
		return existe;
	}

	public ArrayList<Cancion> cancionesBaja(int cod) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			String eliminacion = "delete from cancion where cod = " + cod + ";";
			miStatement.executeUpdate(eliminacion);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}

		return canciones;
	}

	public ArrayList<Grupo> listaGrupos() {
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select * from grupo;");
			while (rs.next() == true) {
				Grupo opo = new Grupo(rs.getInt("cod"), rs.getString("nombre"), rs.getString("fecha"),
						rs.getString("Pais"));
				grupos.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return grupos;
	}

	public ArrayList<Disco> listaDiscos() {
		ArrayList<Disco> discos = new ArrayList<Disco>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("select * from disco;");
			while (rs.next() == true) {
				Disco opo = new Disco(rs.getInt("cod"), rs.getString("nombre"), rs.getString("fecha"),
						rs.getInt("cod_comp"), rs.getInt("cod_gru"));
				discos.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return discos;
	}

	public ArrayList<Artista> listaArtistasporgrupo(String nombreGrupo) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("SELECT * FROM artista WHERE grupo.nombre LIKE '" + nombreGrupo
					+ "' AND artista.cod = pertenece.cod and pertece.cod = grupo.cod;");
			while (rs.next() == true) {
				Artista opo = new Artista(rs.getString("dni"), rs.getString("nombre"));
				artistas.add(opo);
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en metodo artistas");
			e.printStackTrace();
		}
		return artistas;
	}
}
