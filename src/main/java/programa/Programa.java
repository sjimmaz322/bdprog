package programa;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controladores.ControladorJugador;
import controladores.ControladorPartida;
import controladores.ControladorUsuario;
import entidades.Usuario;
import entidades.Jugador;
import entidades.Partida;

public class Programa {
	
	private static ControladorUsuario cu = new ControladorUsuario();
	private static ControladorJugador cj = new ControladorJugador();
	private static ControladorPartida cp = new ControladorPartida();

	public static void main(String[] args) {
		
		
		
		int opcion = 0;
		boolean salir = true;
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println("\nBienvenid@ a su SGBD\n"
				+ "¿Qué desea hacer?\nIntroduzca la opción que desee\n"
				+ "1 - Crear\n"
				+ "2 - Modificar\n"
				+ "3 - Borrar\n"
				+ "4 - Consultar\n"
				+ "0 - Salir");
		
				opcion = comprobarOpcion(0,4);
				
				if(opcion == 0) {salir= true;}
				
		switch(opcion) {
		
		case 1:
			
			menu("crear");
			opcion = comprobarOpcion(0, 4);
			
				switch(opcion) {
				case 1:
					//cu.createUsuario(crearUsuario());
					salir = continuarOperando();
					break;
				case 2:
					//cj.createJugador(crearJugador());
					salir = continuarOperando();
					break;
				case 3:
					//cp.createPartida(crearPartida());
					salir = continuarOperando();
					break;
				case 4:
					System.out.println("\nVolviendo al menú");
					salir = false;
					break;
				case 0:
					System.out.println("\nSaliendo");
					salir = true;
					break;
				}
			break;
			
		case 2:
			menu("modificar");
			opcion = comprobarOpcion(0, 4);
			
			switch(opcion) {
			case 1:
				//modificarUsuario();
				salir = continuarOperando();
				break;
			case 2:
				//modificarJugador();
				salir = continuarOperando();
				break;
			case 3:	
				//modificarPartida();
				salir = continuarOperando();
				break;
			case 4:
				System.out.println("\nVolviendo al menú");
				salir = false;
				break;
			case 0:
				System.out.println("\nSaliendo");
				salir = true;
				break;
			}
			break;
			
		case 3:
			
			menu("borrar");
			opcion = comprobarOpcion(0, 4);
			
			switch(opcion) {
			case 1:
				//borradorUsuario();
				salir = continuarOperando();
				break;
			case 2:
				//borradorJugador();
				salir = continuarOperando();
				break;
			case 3:		
				//borradorPartida();
				salir = continuarOperando();
				break;
			case 4:
				System.out.println("\nVolviendo al menú");
				salir = false;
				break;
			case 0:
				System.out.println("\nSaliendo");
				salir = true;
				break;
			}
			break;
			
		case 4:
			menu("consultar");
			opcion = comprobarOpcion(0, 4);
			
			switch(opcion) {
			case 1:
				System.out.println("Introduza la opción que desee\n"
						+ "1 - Consultar todos los usuarios\n"
						+ "2 - Consultar un usuario concreto\n"
						+ "0 - Cancelar");
				opcion = comprobarOpcion(0, 2);
				switch(opcion) {
					case 1:
						consultarUsuarios();
						break;
					case 2:
						//imprimirUsuario();
						break;
					case 0:
						break;
				}
				salir = continuarOperando();
				break;
			case 2:
				System.out.println("Introduza la opción que desee\n"
						+ "1 - Consultar todos los jugadores\n"
						+ "2 - Consultar un jugador concreto\n"
						+ "0 - Cancelar");
				opcion = comprobarOpcion(0, 2);
				switch(opcion) {
					case 1:
						//consultarJugadores();
						break;
					case 2:
						//imprimirJugador();
						break;
					case 0:
						break;
				}
				salir = continuarOperando();
				break;
			case 3:
				System.out.println("Introduza la opción que desee\n"
						+ "1 - Consultar todas las partidas\n"
						+ "2 - Consultar una partida concreta\n"
						+ "0 - Cancelar");
				opcion = comprobarOpcion(0, 2);
				switch(opcion) {
					case 1:
						//consultarPartidas();
						break;
					case 2:
						//imprimirPartida();
						break;
					case 0:
						break;
				}
				salir = continuarOperando();
				break;
			case 4:
				System.out.println("\nVolviendo al menú");
				salir = false;
				break;
			case 0:
				System.out.println("\nSaliendo");
				salir = true;
				break;
			}
			break;
			
		case 0:
			
			break;
		}
		}while(!salir);
		System.out.println("\nGracias con confiar en nosotros.\nHasta la próxima.");
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
						seguir = true;
						
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
		int edad = 0;
		boolean repetir = true;
		
		System.out.println("Introduza el nombre");
		nombre = sc.nextLine();
		u.setNombre(nombre);
		System.out.println("Introduza la contraseña");
		contrasenia = sc.nextLine();
		u.setContrasenia(contrasenia);
		System.out.println("Introduza el correo sin dominio");
		email = sc.nextLine();
		u.setEmail(email+"@gmail.com");
		do {
		System.out.println("Introduza la edad del usuario");
		try {
		edad = sc.nextInt();
		if (edad >= 13) {
			repetir = false;
		}else {
			System.out.println("La edad es inferior a la mínima permitida (13)");
		}
		}catch (InputMismatchException ime) {
			System.out.println("Introduzca un número");
		}
		}while (repetir);
		u.setEdad(edad);
		return u;
	}
	public static Jugador crearJugador() {
		Scanner sc = new Scanner(System.in);
		Jugador j = new Jugador();
		String apodo, sistema;
		int anio = 0, nPartidas = 0;
		boolean repetir = true;
		
		System.out.println("Introduza el apodo");
		apodo = sc.nextLine();
		j.setApodo(apodo);
		System.out.println("Introduza el sistema predilecto");
		sistema = sc.nextLine();
		j.setSistemapreferido(sistema);
		System.out.println("Introduza el año del inicio en el rol");

		do {
			System.out.println("Introduza la edad del usuario");
			try {
			anio = sc.nextInt();
			if (anio >= LocalDate.now().getYear()) {
				repetir = false;
			}else {
				System.out.println("No se admiten viajeros temporales");
			}
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		j.setIniciorol(anio);
		System.out.println("Introduza el número de partidas en las que ha participado");
		
		do {
			System.out.println("Introduza la edad del usuario");
			try {
			nPartidas = sc.nextInt();
			if (nPartidas >= 0) {
				repetir = false;
			}else {
				System.out.println("Mínimo nunca has jugado al rol");
			}
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		j.setNumpartidas(nPartidas);
		return j;
	}
	
	public static Partida crearPartida() {
		Scanner sc = new Scanner(System.in);
		Partida p = new Partida();
		String titulo, trasfondo, sistema;
		int nSesiones = 1;
		boolean repetir = true;
		
		System.out.println("Introduza el titulo de la partida");
		titulo = sc.nextLine();
		p.setTitulo(titulo);
		System.out.println("Introduza el trasfondo de la partida");
		trasfondo = sc.nextLine();
		p.setTitulo(trasfondo);
		System.out.println("Introduza el sistema de la partida");
		sistema = sc.nextLine();
		p.setTitulo(sistema);
		System.out.println("Introduza el número de sesiones de la partida");
		
		do {
			System.out.println("Introduza la edad del usuario");
			try {
			nSesiones = sc.nextInt();
			if (nSesiones >= 1) {
				repetir = false;
			}else {
				System.out.println("La duración mínima de una partida es de una sesión (One Shot)");
			}
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		p.setNumsesiones(nSesiones);
		
		return p;
	}

	public static boolean continuarOperando(){
		Scanner sc = new Scanner(System.in);
		String opcion;
		System.out.println("¿Desea realizar otra operación?\n"
				+ "1 - Si \\ Otro valor - No");
		opcion = sc.nextLine();
		if (opcion.equalsIgnoreCase("1")){
			return false;
		}else {
			return true;
		}
	}
	
		
	public static void modificarUsuario() {
		
		Scanner sc = new Scanner(System.in);
		int cod, opcion;
		
		System.out.println("Introduzca el código del usuario a modificar");
		cod = sc.nextInt();
		
		Usuario u2 = cu.findBycodigo(cod);
		
		System.out.println("Seleccione la opción a modificar\n"
				+ "1 - Nombre\n"
				+ "2 - Contraseña\n"
				+ "3 - Email\n"
				+ "4 - Edad\n"
				+ "0 - Cancelar");
		opcion = comprobarOpcion(0, 5);
		
		switch(opcion) {
			case 1:
				System.out.println("Introduzca el nuevo nombre");
				String nNombre = sc.nextLine();
				u2.setNombre(nNombre);
				break;
			case 2:
				System.out.println("Introduzca la nueva contraseña");
				String nContrasenia = sc.nextLine();
				u2.setContrasenia(nContrasenia);
				break;
			case 3:
				System.out.println("Introduza el nuevo correo");
				String nCorreo = sc.nextLine();
				u2.setEmail(nCorreo);
				break;
			case 4:
				System.out.println("Introduzca la nueva edad");
				int nEdad = sc.nextInt();
				u2.setEdad(nEdad);
				break;
			case 0:
				System.out.println("Se mantendrá el usuario actual");
				cu.modifyUsuario(u2);
				break;
		}
		cu.modifyUsuario(u2);
	}
	public static void modificarJugador() {
		
		Scanner sc = new Scanner(System.in);
		int cod, opcion;
		
		System.out.println("Introduzca el código del jugador a modificar");
		cod = sc.nextInt();
		
		Jugador j2 = cj.findBycodigo(cod);
		
		System.out.println("Seleccione la opción a modificar\n"
				+ "1 - Apodo\n"
				+ "2 - Sistema preferido\n"
				+ "3 - Año de inicio en el rol\n"
				+ "4 - Partida jugadas\n"
				+ "0 - Cancelar");
		opcion = comprobarOpcion(0, 5);
		
		switch(opcion) {
			case 1:
				System.out.println("Introduzca el nuevo Apodo");
				String nApodo = sc.nextLine();
				j2.setApodo(nApodo);
				break;
			case 2:
				System.out.println("Introduzca el nuevo sistema preferido");
				String nSistema = sc.nextLine();
				j2.setSistemapreferido(nSistema);
				break;
			case 3:
				System.out.println("Introduza el nuevo año de inicio en el rol");
				int nAnio = sc.nextInt();
				j2.setIniciorol(nAnio);
				break;
			case 4:
				System.out.println("Introduzca el nuevo número de partidas jugadas");
				int nNumPartidas = sc.nextInt();
				j2.setNumpartidas(nNumPartidas);
				break;
			case 0:
				System.out.println("Se mantendrá el jugador actual");
				cj.modifyJugador(j2);
				break;
		}
		cj.modifyJugador(j2);
	}
	public static void modificarPartida() {
		
		Scanner sc = new Scanner(System.in);
		int cod, opcion;
		
		System.out.println("Introduza el código de la partida a modificar");
		cod = sc.nextInt();
		
		Partida p2 = cp.findBycodigo(cod);
		
		System.out.println("Seleccione la opción a modificar\n"
				+ "1 - Título\n"
				+ "2 - Sistema\n"
				+ "3 - Número de sesiones\n"
				+ "4 - Trasfondo\n"
				+ "0 - Cancelar");
		opcion = comprobarOpcion(0, 5);
		
		switch(opcion) {
			case 1:
				System.out.println("Introduzca el nuevo título");
				String nTitulo = sc.nextLine();
				p2.setTitulo(nTitulo);
				break;
			case 2:
				System.out.println("Introduzca el nuevo sistema");
				String nSistema = sc.nextLine();
				p2.setSistema(nSistema);
				break;
			case 3:
				System.out.println("Introduza el nuevo numero de sesiones");
				int nSesiones = sc.nextInt();
				p2.setNumsesiones(nSesiones);;
				break;
			case 4:
				System.out.println("Introduzca el nuevo trasfondo");
				String nTrasfondo = sc.nextLine();
				p2.setTrasfondo(nTrasfondo);
				break;
			case 0:
				System.out.println("Se mantendrá la partida como está actualmente");
				cp.modifyPartida(p2);
				break;
		}
		cp.modifyPartida(p2);
	}

	
	public static void borradorUsuario() {
		
		Scanner sc = new Scanner(System.in);
		int cod;	
		
		System.out.println("Introduzca el código del usuario a borrar");
		cod = sc.nextInt();
		
		Usuario u2 = cu.findBycodigo(cod);
		cu.borrarUsuario(u2);
	}
	public static void borradorJugador() {
		Scanner sc = new Scanner(System.in);
		int cod;	
		
		System.out.println("Introduzca el código del jugador a borrar");
		cod = sc.nextInt();
		
		Jugador j2 = cj.findBycodigo(cod);
		cj.borrarJugador(j2);
	}
	public static void borradorPartida() {
		Scanner sc = new Scanner(System.in);
		int cod;	
		
		System.out.println("Introduzca el código del jugador a borrar");
		cod = sc.nextInt();
		
		Partida p2 = cp.findBycodigo(cod);
		cp.borrarPartida(p2);
	}


	public static void imprimirUsuario() {
		Scanner sc = new Scanner(System.in);
		int cod = 0;	
		boolean repetir = true;
		System.out.println("Introduzca el código del usuario buscado");
		
		do {
			try {
				cod = sc.nextInt();
				repetir = false;
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		
		Usuario u = cu.findBycodigo(cod);
		
		System.out.println(u.toString());
	}
	public static void imprimirJugador() {
		Scanner sc = new Scanner(System.in);
		int cod = 0;	
		boolean repetir = true;
		System.out.println("Introduzca el código del jugador buscado");
		
		do {
			try {
				cod = sc.nextInt();
				repetir = false;
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		
		Jugador j = cj.findBycodigo(cod);
		
		System.out.println(j.toString());
	}
	public static void imprimirPartida() {
		Scanner sc = new Scanner(System.in);
		int cod = 0;	
		boolean repetir = true;
		System.out.println("Introduzca el código del usuario buscado");
		
		do {
			try {
				cod = sc.nextInt();
				repetir = false;
			}catch (InputMismatchException ime) {
				System.out.println("Introduzca un número");
			}
			}while (repetir);
		
		Partida p = cp.findBycodigo(cod);
		
		System.out.println(p.toString());
	}
	
	
	public static void consultarUsuarios() {
		List<Usuario> lista = cu.findAll();
		
		System.out.println("----- Imprimiendo Usuarios -----");
		for (Usuario u : lista) {
			System.out.println(u);
		}
	}
	public static void consultarJugadores() {
		List<Jugador> lista = cj.findAll();
		
		System.out.println("----- Imprimiendo Jugadores -----");
		for (Jugador j : lista) {
			System.out.println(j);
		}
	}
	public static void consultarPartidas() {
		List<Partida> lista = cp.findAll();
		
		System.out.println("----- Imprimiendo Jugadores -----");
		for (Partida p : lista) {
			System.out.println(p);
		}
	}
	
	
	public static void menu(String var) {
		System.out.println("\nEligió "+ var.toUpperCase()+"\n"
				+ "Por favor seleccione que desea "+ var.toUpperCase() +"\n"
				+ "1 - "+var.toUpperCase()+" un Usuario\n"
				+ "2 - "+var.toUpperCase()+" un Jugador\n"
				+ "3 - "+var.toUpperCase()+" una Partida\n"
				+ "4 - Volver al menú\n"
				+ "0 - Cancelar.");
	}
}
