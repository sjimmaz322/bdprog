package prueba;

import java.util.List;

import controladores.ControladorUsuario;
import entidades.Usuario;

public class PruebaControladorUsuario {
	
	public static void main(String[] args) {
		
		ControladorUsuario cu = new ControladorUsuario();
		
		List<Usuario> lista = cu.findAll();
		
		System.out.println("----- Imprimiendo Usuarios -----");
		for (Usuario u : lista) {
			System.out.println(u);
		}
		
		System.out.println("Encontrando al usuario con código 1: "+ cu.findBycodigo(1));
		
		Usuario u1 = new Usuario();
		
		u1.setNombre("Rosa");
		u1.setContrasenia("boudoir123");
		u1.setEmail("rosa@gmail.com");
		u1.setEdad(25);
		cu.createUsuario(u1);
		lista.add(u1);
		
		System.out.println("----- Imprimiendo Usuarios tras añadir uno-----");
		for (Usuario u : lista) {
			System.out.println(u);
		}
		
		Usuario u2 = cu.findBycodigo(2);
		u2.setContrasenia("basket321");
		cu.modifyUsuario(u2);
		
		System.out.println("----- Imprimiendo Usuarios tras el cambio-----");
		for (Usuario u : lista) {
			System.out.println(u);
		}
		
		/*
		u2 = cu.findBycodigo(2);
		cu.borrarUsuario(u2);
		
		System.out.println("----- Imprimiendo Usuarios tras borrar uno-----");
		for (Usuario u : lista) {
			System.out.println(u);
		}
		*/

	}
	
}
