package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codjugador;

	private String apodo;

	private int codusuario;

	
	private int iniciorol;

	private int numpartidas;

	private String sistemapreferido;

	//bi-directional many-to-one association to Partida
	@OneToMany(mappedBy="jugador")
	private List<Partida> partidasJugador;

	//bi-directional one-to-one association to Usuario
	@OneToOne(mappedBy="jugador", fetch=FetchType.LAZY)
	@JoinColumn(name="codusuario")
	private Usuario usuario;

	public Jugador() {
	}

	public int getCodjugador() {
		return this.codjugador;
	}

	public void setCodjugador(int codjugador) {
		this.codjugador = codjugador;
	}

	public String getApodo() {
		return this.apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public int getCodusuario() {
		return this.codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

	public int getIniciorol() {
		return this.iniciorol;
	}

	public void setIniciorol(int iniciorol) {
		this.iniciorol = iniciorol;
	}

	public int getNumpartidas() {
		return this.numpartidas;
	}

	public void setNumpartidas(int numpartidas) {
		this.numpartidas = numpartidas;
	}

	public String getSistemapreferido() {
		return this.sistemapreferido;
	}

	public void setSistemapreferido(String sistemapreferido) {
		this.sistemapreferido = sistemapreferido;
	}

	public List<Partida> getPartidasJugador() {
		return this.partidasJugador;
	}

	public void setPartidasJugador(List<Partida> partidasJugador) {
		this.partidasJugador = partidasJugador;
	}

	public Partida addPartidasJugador(Partida partidasJugador) {
		getPartidasJugador().add(partidasJugador);
		partidasJugador.setJugador(this);

		return partidasJugador;
	}

	public Partida removePartidasJugador(Partida partidasJugador) {
		getPartidasJugador().remove(partidasJugador);
		partidasJugador.setJugador(null);

		return partidasJugador;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Jugador [codjugador: ");
	builder.append(codjugador);
	builder.append(", apodo: ");
	builder.append(apodo);
	builder.append(", sistema preferido: ");
	builder.append(sistemapreferido);
	builder.append(", año inicio en el rol: ");
	builder.append(iniciorol);
	builder.append(", número de partidas jugadas: ");
	builder.append(numpartidas);
	builder.append("]");
	return builder.toString();
	}

}