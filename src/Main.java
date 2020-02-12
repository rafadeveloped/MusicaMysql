import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("P7-Github, estoy modificando");
		int opc = 0;
		String opc1 = "";
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		BDController controladorBD = new BDController();
		do {
			Main.mostrarMenu();
			opc = sn.nextInt();
			switch (opc) {
			case 1:
				for (int i = 0; i < controladorBD.artistas().size(); i++) {
					System.out.println("| Nombre: " + controladorBD.artistas().get(i).getNombre() + " | DNI: "
							+ controladorBD.artistas().get(i).getDni() + " |");
				}

				break;
			case 2:
				System.out.println("Introduce la letra: ");
				String letra = sc.nextLine();
				for (int i = 0; i < controladorBD.artistasLetra(letra).size(); i++) {
					System.out.println("| Nombre: " + controladorBD.artistasLetra(letra).get(i).getNombre() + " | DNI: "
							+ controladorBD.artistas().get(i).getDni() + " |");
				}
				break;
			case 3:
				boolean ok = false;
				do {
					System.out.println("escribe 'alta para dar de alta o ''baja' para dar de baja: ");
					opc1 = sc.nextLine();
					if (opc1.equalsIgnoreCase("alta")) {
						ok = true;
					} else if (opc1.equalsIgnoreCase("baja")) {
						ok = true;
					} else {
						System.out.println("error vuelve a introducir la opcion.");
					}
				} while (ok != true);
				switch (opc1) {
				case "alta":
					System.out.println("Introduce el dni: ");
					String dnialta = sc.nextLine();
					System.out.println("Introduce el dni: ");
					String nombrealta = sc.nextLine();
					Artista artistasalta = new Artista(dnialta, nombrealta);
					controladorBD.artistasAlta(dnialta, nombrealta);
					break;

				case "baja":
					System.out.println("Introduce el dni: ");
					String dnibaja = sc.nextLine();
					Artista artistasBaja = new Artista(dnibaja);
					controladorBD.artistasBaja(dnibaja);
					break;
				}
				break;
			case 4:
				System.out.println("Introduce letra del DNI");
				String ndni = sc.nextLine();
				for (int i = 0; i < controladorBD.artistasDniletra(ndni).size(); i++) {
					System.out.println("| Nombre: " + controladorBD.artistasDniletra(ndni).get(i).getNombre()
							+ " | DNI: " + controladorBD.artistasDniletra(ndni).get(i).getDni() + " |");
				}
				break;
			case 5:
				for (int i = 0; i < controladorBD.listaCanciones().size(); i++) {
					System.out.println("| Codigo: " + controladorBD.listaCanciones().get(i).getCod() + " | Titulo: "
							+ controladorBD.listaCanciones().get(i).getTitulo() + " | Duracion: "
							+ controladorBD.listaCanciones().get(i).getDuracion() + " |");
				}
				break;

			case 6:
				for (int i = 0; i < controladorBD.cancionLarga().size(); i++) {
					System.out.println("| Codigo: " + controladorBD.cancionLarga().get(i).getCod() + " | Titulo: "
							+ controladorBD.cancionLarga().get(i).getTitulo() + " | Duracion: "
							+ controladorBD.cancionLarga().get(i).getDuracion() + " |");
				}
				break;

			case 7:
				System.out.println("Introduce duracion no deseada: ");
				String duracion = sc.nextLine();
				for (int i = 0; i < controladorBD.noLarga(duracion).size(); i++) {
					System.out.println("| Codigo: " + controladorBD.noLarga(duracion).get(i).getCod() + " | Titulo: "
							+ controladorBD.noLarga(duracion).get(i).getTitulo() + " | Duracion: "
							+ controladorBD.noLarga(duracion).get(i).getDuracion() + " |");
				}
				break;
			case 8:
				System.out.println("Introduce nombre del disco: ");
				String nombre = sc.nextLine();
				for (int i = 0; i < controladorBD.cancionesDisco(nombre).size(); i++) {
					System.out.println(controladorBD.cancionesDisco(nombre).get(i).toString());
				}
				break;
			case 9:
				System.out.println("Introduce codigo de cancion: ");
				int cod = sn.nextInt();
				System.out.println("Introduce nombre de titulo: ");
				String titulo = sc.nextLine();
				System.out.println("Introduce duracion de disco: ");
				int duracioncancion = sn.nextInt();
				Cancion cancionessalta = new Cancion();
				controladorBD.cancionesExistentes(cod);
				if (controladorBD.cancionesExistentes(cod) == false) {
					controladorBD.cancionesAlta(cod, titulo, duracioncancion);
				} else {
					System.out.println("Error la cancion ya existe.");
				}
				break;
			case 10:
				System.out.println("Introduce codigo de cancion: ");
				cod = sn.nextInt();
				Cancion canciones = new Cancion();
				controladorBD.cancionesExistentes(cod);
				if (controladorBD.cancionesExistentes(cod) == true) {
					controladorBD.cancionesBaja(cod);
				} else {
					System.out.println("Error la cancion no existe.");
				}
				break;
			case 11:
				for (int i = 0; i < controladorBD.listaGrupos().size(); i++) {
					System.out.println("| Codigo: " + controladorBD.listaGrupos().get(i).getCod() + " | Nombre: "
							+ controladorBD.listaGrupos().get(i).getNombre() + " | Fecha: "
							+ controladorBD.listaGrupos().get(i).getFecha() + " | Pais: "+controladorBD.listaGrupos().get(i).getPais()+" |");
				}
				break;
			case 12:
				for (int i = 0; i < controladorBD.listaDiscos().size(); i++) {
					System.out.println("| Codigo: " + controladorBD.listaDiscos().get(i).getCod() + " | Nombre: "
							+ controladorBD.listaDiscos().get(i).getNombre() + " | Fecha: "
							+ controladorBD.listaDiscos().get(i).getFecha() + " | Codigo de compañia: "+controladorBD.listaDiscos().get(i).getCod_comp()+" | Codigo de Grupo: "+controladorBD.listaDiscos().get(i).getCod_gru()+" |");
				}
				break;
			case 13:
				System.out.println("Introduce nombre del grupo: ");
				String nombreGrupo = sc.nextLine();
				for (int i = 0; i < controladorBD.listaArtistasporgrupo(nombreGrupo).size(); i++) {
					System.out.println("| DNI: "+controladorBD.listaArtistasporgrupo(nombreGrupo).get(i).getDni()+" | Nombre: "+controladorBD.listaArtistasporgrupo(nombreGrupo).get(i).getNombre());
				}
				break;
			case 14:

				break;
			case 15:

				break;
			case 16:

				break;
			case 17:

				break;
			case 18:

				break;
			case 19:

				break;
			case 20:
				
				break;
			}
		} while (opc != 21);
		System.out.println("Hasta pronto.");

	}

	public static void mostrarMenu() {
		System.out.println("************ Selecciona una opcion *************");
		System.out.println("1. Listado de artistas\n\r" + "2. Listados de artistas que empiece por una letra.\n\r"
				+ "3. Alta o baja de Artistas.\n\r" + "4. Listado de Artistas con DNI que acabe en una letra.\n\r"
				+ "5. Listado de canciones.\n\r" + "6. Canción más larga.\n\r"
				+ "7. Listado de canciones con duración menos a una duración pedida al usuario.\n\r"
				+ "8. Listado de canciones de un disco.\n\r" + "9. Alta de canción.\n\r" + "10. Baja de canción.\n\r"
				+ "11. Listado de Grupos.\n\r" + "12. Listado de Discos.\n\r"
				+ "13. Listado de Artistas de un grupo pedido al usuario.\n\r"
				+ "14. Meter Canción en Disco. (Deberás dar de alta un registro en la tabla que relaciona las\r\n"
				+ "tablas)\n\r"
				+ "15. Meter Artista en Grupo. (Deberás dar de alta un registro en la tabla que relaciona las\r\n"
				+ "tablas)\n\r"
				+ "16. Modificar Compañía de Disco. (Se pedirá al usuario el nombre del disco y se modificará\r\n"
				+ "su compañía por la que elija el usuario)\n\r"
				+ "17. Mostrar los datos del Grupo que toca en un Club. (Se pedirá al usuario el nombre del\r\n"
				+ "Club)\n\r" + "18. Listado de Artistas que no tienen grupo.\n\r"
				+ "19. Listado de canciones sin disco.\n\r"
				+ "20. Mostrar el título de todos los discos que tienen más de 6 canciones.\n\r" + "21. Salir");
	}

}
