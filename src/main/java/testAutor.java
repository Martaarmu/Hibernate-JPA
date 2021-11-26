
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Autor;
import model.Libro;

public class testAutor {
	
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		
		
		emf=Persistence.createEntityManagerFactory("aplicacionH2");
		em=emf.createEntityManager();
		
		/*
		
		em.getTransaction().begin();
		Autor a1 = new Autor("Marta",LocalDate.parse("1980-06-01"));
		Libro b1 = new Libro("El Quijote");
		b1.setAutor(a1);
		Set<Libro> ls=a1.getLibros();
		ls.add(b1);
		em.persist(a1);
		*/
		//em.persist(b1);
		
		
		//primero se ha traido el autor y luego solo cuando hacer el get libros consulta los libros (hace 2 consultas) 
		/*em.getTransaction().begin();
		Autor ax = em.find(Autor.class, 1L);
		System.out.println(ax);
		Set<Libro> libros=ax.getLibros();
		for(Libro l:libros) {
			System.out.println(l);
		}*/
		
		
		
		
		em.getTransaction().begin();
		Libro lx = em.find(Libro.class, 1L);
		System.out.println(lx);
		Autor aa=lx.getAutor();
		System.out.println(aa);
		
		
		
		em.getTransaction().commit();
		
		/*
		List<Autor> r = em.createQuery("FROM Autor").getResultList();
					 // em.createNativeQuery("SELECT * FROM Autor").getResultList(); -> inyecta SQL
		
		for(Autor a:r) {
			System.out.println(a);
		}
		*/
	}

}
