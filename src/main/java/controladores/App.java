package controladores;

import daos.Acceso;
import daos.Autor;
import daos.Coleccion;
import daos.Editorial;
import daos.Estado;
import daos.Genero;
import daos.Libro;
import daos.Prestamo;
import daos.Usuario;
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
		Usuario usuario1 = new Usuario("333333D", "Juan", "Chirivella", "59595959", "holajuan@gmail.com", "1234", true, acceso);
		Autor autor1 = new Autor("Pepito", "Grillo");
		Editorial editorial1 = new Editorial("Agustino");
		Genero genero1 = new Genero("Miedo", "Da mucho miedo");
		Coleccion coleccion1 = new Coleccion("Col666");
		Libro libro1 = new Libro("1213213", "El Conde", "primera", editorial1, genero1, coleccion1);
		Libro libro2 = new Libro("112222333", "El Conde2", "a",editorial1, genero1, coleccion1);
		Estado estado1 = new Estado("1111", "deprimente");
		Prestamo prestamo1 = new Prestamo(libro1, usuario1, estado1);
		
		em.persist(acceso);
		em.persist(acceso2);
		em.persist(usuario1);
		em.persist(autor1);
		em.persist(editorial1);
		em.persist(genero1);
		em.persist(coleccion1);
		em.persist(libro1);
		em.persist(libro2);
		em.persist(estado1);
		em.persist(prestamo1);
		
		em.getTransaction().commit();
		em.close();
    }
}
