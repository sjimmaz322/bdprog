package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 * The persistent class for the partida database table.
 * 
 */
@Entity
@NamedQuery(name="Partida.findAll", query="SELECT p FROM Partida p")
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codpartida;

	private int codjugador;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	private int numsesiones;

	private String titulo;

	private String trasfondo;

	//bi-directional many-to-one association to Jugador
	@ManyToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="codpartida", referencedColumnName = "codjugador")
	private Jugador jugador;

	public Partida() {
	}

	public int getCodpartida() {
		return this.codpartida;
	}

	public void setCodpartida(int codpartida) {
		this.codpartida = codpartida;
	}

	public int getCodjugador() {
		return this.codjugador;
	}

	public void setCodjugador(int codjugador) {
		this.codjugador = codjugador;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public int getNumsesiones() {
		return this.numsesiones;
	}

	public void setNumsesiones(int numsesiones) {
		this.numsesiones = numsesiones;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTrasfondo() {
		return this.trasfondo;
	}

	public void setTrasfondo(String trasfondo) {
		this.trasfondo = trasfondo;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}