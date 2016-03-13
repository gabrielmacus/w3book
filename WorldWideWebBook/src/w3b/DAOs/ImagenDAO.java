package w3b.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import w3b.PersistenceManager;
import w3b.Entidades.Imagen;

public class ImagenDAO {

	public List<Imagen> getLista() {
		EntityManager em = PersistenceManager.getInstance().getEntityManager();

		List<Imagen> imagenes = em.createQuery("select i from Imagen i", Imagen.class).getResultList();
		em.close();
		return imagenes;

	}

	public void addImagen(Imagen imagen) {

		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.persist(imagen);
		em.getTransaction().commit();
		em.close();
	}
}
