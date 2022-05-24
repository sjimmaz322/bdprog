package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;

public class ControladorUsuario {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bdprog");
	private EntityManager em;
	private Query consulta;
	
	public void borrarUsuario(Usuario u) {
		this.em = entityManagerFactory.createEntityManager();
		Usuario aux = null;
		this.em.getTransaction().begin();
		// Si v no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(u)) {
			// Carga v en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(u);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public void modifyUsuario(Usuario u) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto v no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad desconectada
		this.em.merge(u);
		this.em.getTransaction().commit();
		this.em.close();

	}
	
	public void createUsuario(Usuario u) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// u es una entidad conectada
		this.em.persist(u);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}
	
	public Usuario findBycodigo(int coduser) {
		this.em = entityManagerFactory.createEntityManager();
		Usuario aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from usuario where codusuario = ?", Usuario.class);
		this.consulta.setParameter(1, coduser);
		aux = (Usuario) consulta.getSingleResult();
		this.em.close();
		return aux;

	}
	
	public Usuario findByEmail(String email) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Usuario.findEmail");
		this.consulta.setParameter("email", email);
		Usuario u = (Usuario) consulta.getSingleResult();
		this.em.close();
		return u;
	}

	public List<Usuario> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Usuario.findAll");
		List<Usuario> listaUsuarios = (List<Usuario>) consulta.getResultList();
		this.em.close();
		return listaUsuarios;
	}

	public List<Usuario> findByEdad(int edad) {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNativeQuery("Select * from usuario where edad=?", Usuario.class);
		this.consulta.setParameter(1, edad);
		List<Usuario> listaUsuarios = (List<Usuario>) consulta.getResultList();
		this.em.close();
		return listaUsuarios;
	}
	

}
