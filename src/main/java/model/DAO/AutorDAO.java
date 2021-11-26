package model.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Utils.PersistenceUnit;
import model.Autor;
import model.Libro;

public class AutorDAO {
	public static EntityManager createEM() {
		EntityManagerFactory emf=PersistenceUnit.getInstance();
		return emf.createEntityManager();
	}
	
	public static void save(Autor a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
	}
	
	public static void delete (Autor a) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public static Autor selectById (Long id) {
		Autor result = null;
		EntityManager em = createEM();
		em.getTransaction().begin();
		result = em.find(Autor.class, id);
		em.getTransaction().commit();
		return result;
	}
	
	public static List<Autor> selectByName(String name){
		List<Autor> autores=new ArrayList<Autor>();
		EntityManager em=createEM();
		em.getTransaction().begin();
		TypedQuery<Autor> q=em.createNamedQuery("findByName", Autor.class);
		q.setParameter("name", name);
		autores=q.getResultList();
		em.getTransaction().commit();
		return autores;
	}
	
	public static void addLibro(Autor a, Libro l) {
		EntityManager em = createEM();
		em.getTransaction().begin();
		Autor ax =em.merge(a);
		l.setAutor(ax);
		
		Set<Libro> ls = a.getLibros();
		ls.add(l);
		ax.setLibros(ls);
		em.getTransaction().commit();
	}
	
	
}
