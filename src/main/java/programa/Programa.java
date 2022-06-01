package programa;

import java.util.InputMismatchException;
import java.util.Scanner;

import controladores.ControladorJugador;
import controladores.ControladorPartida;
import controladores.ControladorUsuario;
import entidades.Usuario;
import entidades.Jugador;
import entidades.Partida;

public class Programa {

	public static void main(String[] args) {
		
		ControladorUsuario cu = new ControladorUsuario();
		ControladorJugador cj = new ControladorJugador();
		ControladorPartida cp = new ControladorPartida();
		
		int opcion = 0;
		boolean seguir = true;
		boolean salir = true;
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println("Bienvenid@ a su SGBD\n"
				+ "¿Qué desea hacer?\n"
				+ "Introduzca la opción que desee\n"
				+ "1 - Crear\n"
				+ "2- Modificar\n"
				+ "3 - Borrar\n"
				+ "4 - Consultar\n"
				+ "0 - Salir");
				opcion = comprobarOpcion(0,4);

		switch(opcion) {
		case 1:
			System.out.println("Eligió Crear\n"
					+ "Por favor seleccione que desea crear\n"
					+ "1 - Crear un Usuario\n"
					+ "2 - Crear un Jugador\n"
					+ "3 - Crear una Partida\n"
					+ "4 - Volver al Menú\n"
					+ "0 - Cancelar.");
			opcion = comprobarOpcion(0, 3);
				switch(opcion) {
				case 1:
					cu.createUsuario(crearUsuario());
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					salir = false;
					break;
				case 0:
					salir = true;
					break;
				}
			break;
		case 2:
			System.out.println("Eligió Modificar");
			break;
		case 3:
			System.out.println("Eligió Borrar");
			break;
		case 4:
			System.out.println("Eligió Consultar");
			break;
		case 0:
			System.out.println("Gracias con confiar en nosotros.\nHasta la próxima.");
			break;
		}
		}while(!salir);
		
	}
	public static int comprobarOpcion(int min, int max) {
		boolean seguir = true;
		Scanner sc= new Scanner(System.in);
		int opcion = 0;
		do {
			seguir = true;
				try {
					opcion = sc.nextInt();
					if(opcion >=min && opcion <=max) {
						
					}else {
						System.out.println("Por favor, elija una de las opciones propuestas");
						seguir = false;
						
					}
				}catch (InputMismatchException ime){
					System.out.println("Introduzca un caracter numérico por favor");
					seguir = false;
					sc.next();
					
				}
				}while (!seguir);
		return opcion;
	}
	
	public static Usuario crearUsuario() {
		Scanner sc = new Scanner(System.in);
		Usuario u = new Usuario();
		String nombre, contrasenia, email;
		int edad;
		
		System.out.println("Introduza el nombre");
		nombre = sc.nextLine();
		u.setNombre(nombre);
		System.out.println("Introduza la contraseña");
		contrasenia = sc.nextLine();
		u.setContrasenia(contrasenia);
		System.out.println("Introduza el correo sin dominio");
		email = sc.nextLine();
		u.setEmail(email+"@gmail.com");
		System.out.println("Introduza la edad del usuario");
		edad = sc.nextInt();
		u.setEdad(edad);
		return u;
	}

}
