package w3b.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import w3b.PersistenceManager;

public  class GenericDAO<T>{

	public void addObject(Object object)
	{
	
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
	em.getTransaction().begin();
		em.persist((T)object);
		em.getTransaction().commit();
	    em.close();
	  
	}
/*	public List<T> getObjectList()
	{

	      /*
	T obj;
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
    String a = obj.toString().substring(obj.toString().lastIndexOf(".")).replace(".", "");
	
		List<T> lista = 	em.createQuery("select o from "+a+" o").getResultList();
		
		return lista;*/
		
	//}
}
