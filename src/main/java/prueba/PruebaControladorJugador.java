package prueba;


import java.util.List;
import controladores.ControladorJugador;
import entidades.Jugador;

public class PruebaControladorJugador {
	
public static void main(String[] args) {
		
		ControladorJugador cj = new ControladorJugador();
		
		List<Jugador> lista = cj.findAll();
		
		System.out.println("----- Imprimiendo Jugadores -----");
		for (Jugador j : lista) {
			System.out.println(j);
		}
		
		System.out.println("Encontrando al jugador con código 1: "+ cj.findBycodigo(1));
		
		Jugador j1 = new Jugador();
		j1.setCodusuario(3);
		j1.setApodo("LadyFrisk");
		j1.setSistemapreferido("D&D 3.5");
		j1.setIniciorol(2022);		
		j1.setNumpartidas(3);
		
		cj.createJugador(j1);
		lista.add(j1);
		
		System.out.println("----- Imprimiendo jugadores tras añadir uno-----");
		for (Jugador j : lista) {
			System.out.println(j);
		}
		
		Jugador j2 = cj.findBycodigo(2);
		j2.setApodo("Elros Feiks");
		cj.modifyJugador(j2);
		
		System.out.println("----- Imprimiendo Usuarios tras el cambio-----");
		for (Jugador j : lista) {
			System.out.println(j);
		}
		
		/*
		j2 = cj.findBycodigo(2);
		cj.borrarJugador(j2);
		
		System.out.println("----- Imprimiendo jugadores tras borrar uno-----");
		for (Jugador j : lista) {
			System.out.println(j);
		}
		*/
		
	}
}
