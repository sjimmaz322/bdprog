package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Partida;

public class ControladorPartida {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bdprog");
	private EntityManager em;
	private Query consulta;
	
	public void borrarPartida(Partida p) {
		this.em = entityManagerFactory.createEntityManager();
		Partida aux = null;
		this.em.getTransaction().begin();
		// Si v no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(p)) {
			// Carga v en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(p);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// cach�
		this.em.remove(aux);
		// Se vuelca la informaci�n del contexto (cach� intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyPartida(Partida p) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacci�n en la base de datos
		// porque vamos a persistir informaci�n en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
		// contexto de persistencia (cach�), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto v no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(p);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public void createPartida(Partida p) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacci�n en la base de datos
		// porque vamos a persistir informaci�n en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (cach� intermedia)
		// v es una entidad conectada
		this.em.persist(p);
		// Se vuelca la informaci�n del contexto (cach� intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public Partida findBycodigo(int codpart) {
		this.em = entityManagerFactory.createEntityManager();
		Partida aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from partida where codpartida = ?", Partida.class);
		this.consulta.setParameter(1, codpart);
		aux = (Partida) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public Partida findByNombre(String nombre) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Partida.findNombre");
		this.consulta.setParameter("nombre", nombre);
		Partida p = (Partida) consulta.getSingleResult();
		this.em.close();
		return p;
	}

	public List<Partida> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Partida.findAll");
		List<Partida> listaPartidas = (List<Partida>) consulta.getResultList();
		this.em.close();
		return listaPartidas;
	}

	public List<Partida> findBySesiones(int sesiones) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNativeQuery("Select * from partida where numsesiones=?", Partida.class);
		this.consulta.setParameter(1, sesiones);
		List<Partida> listaPartidas = (List<Partida>) consulta.getResultList();
		this.em.close();
		return listaPartidas;
	}
	

	

}
