package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codusuario;

	private String contrasenia;

	private int edad;

	private String email;

	private String nombre;

	//bi-directional one-to-one association to Jugador
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="codusuario")
	private Jugador jugador;

	public Usuario() {
	}

	public int getCodusuario() {
		return this.codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	@Override
	public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Usuario [codusuario: ");
	builder.append(codusuario);
	builder.append(", nombre: ");
	builder.append(nombre);
	builder.append(", contraseña: ");
	builder.append(contrasenia);
	builder.append(", email: ");
	builder.append(email);
	builder.append(", edad: ");
	builder.append(edad);
	builder.append("]");
	return builder.toString();
	}

}