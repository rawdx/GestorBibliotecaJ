package daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Colecciones", schema = "Biblioteca")
public class Coleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coleccion", nullable = false)
	private long idColeccion;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "coleccion")
	List<Libro> libros;
	
	
	public Coleccion() {
		super();
	}
	
	public Coleccion(String nombre) {
		super();
		this.nombre = nombre;
	}
}
