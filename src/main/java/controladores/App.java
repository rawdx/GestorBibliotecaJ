package controladores;

import daos.Acceso;
import daos.Autor;
import daos.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Acceso acceso = new Acceso("Usu","Acceso usuarios biblioteca");
		Acceso acceso2 = new Acceso("Emp","Empleados biblioteca");
		Autor autor1 = new Autor("Pepito", "Grillo");
		Libro libro1 = new Libro("1213213", "El Conde", "primera");
		em.persist(acceso);
		em.persist(acceso2);
		em.persist(autor1);
		em.persist(libro1);
		em.getTransaction().commit();
		em.close();
    }
}
