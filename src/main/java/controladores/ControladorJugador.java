package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Jugador;

public class ControladorJugador {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bdprog");
	private EntityManager em;
	private Query consulta;
	
	public void borrarJugador(Jugador j) {
		this.em = entityManagerFactory.createEntityManager();
		Jugador aux = null;
		this.em.getTransaction().begin();
		// Si v no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(j)) {
			// Carga v en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(j);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyJugador(Jugador j) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto v no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(j);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public void createJugador(Jugador j) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// v es una entidad conectada
		this.em.persist(j);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public Jugador findBycodigo(int codjug) {
		this.em = entityManagerFactory.createEntityManager();
		Jugador aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from Jugador where codjugador = ?", Jugador.class);
		this.consulta.setParameter(1, codjug);
		aux = (Jugador) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public Jugador findByMatricula(String email) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Vehiculo.findEmail");
		this.consulta.setParameter("email", email);
		Jugador j = (Jugador) consulta.getSingleResult();
		this.em.close();
		return j;
	}

	public List<Jugador> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Jugador.findAll");
		List<Jugador> listaJugadors = (List<Jugador>) consulta.getResultList();
		this.em.close();
		return listaJugadors;
	}

	public List<Jugador> findBySistema(String sistema) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNativeQuery("Select * from Jugador where sistemapreferido=?", Jugador.class);
		this.consulta.setParameter(1, sistema);
		List<Jugador> listaJugadors = (List<Jugador>) consulta.getResultList();
		this.em.close();
		return listaJugadors;
	}
	

	

}
