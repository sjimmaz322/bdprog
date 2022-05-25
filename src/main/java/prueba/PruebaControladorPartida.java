package prueba;

import java.util.List;

import controladores.ControladorPartida;
import entidades.Partida;

public class PruebaControladorPartida {

	public static void main(String[] args) {
		ControladorPartida cp = new ControladorPartida();
		
		List<Partida> lista = cp.findAll();
		
		System.out.println("----- Imprimiendo Partidas -----");
		for (Partida p : lista) {
			System.out.println(p);
		}
		
		System.out.println("Encontrando al jugador con c�digo 1: "+ cp.findBycodigo(1));
		
		Partida p1 = new Partida();
		
		p1.setTitulo("Cordaria");
		p1.setNumsesiones(4);
		p1.setTrasfondo("");		
		p1.setCodjugador(3);
		
		cp.createPartida(p1);
		lista.add(p1);
		
		System.out.println("----- Imprimiendo Partidas tras añadir uno-----");
		for (Partida p : lista) {
			System.out.println(p);
		}
		
		Partida p2 = cp.findByNombre("La dama");
		p2.setTitulo("La dama enmascarada");
		cp.modifyPartida(p2);
		
		System.out.println("----- Imprimiendo Usuarios tras el cambio-----");
		for (Partida p : lista) {
			System.out.println(p);
		}
		
		/*
		p2 = cp.findBycodigo(2);
		cp.borrarPartida(p2);
		
		System.out.println("----- Imprimiendo Partidas tras borrar uno-----");
		for (Partida p : lista) {
			System.out.println(p);
		}
		*/
	}

}
