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
@Table(name = "Editoriales", schema = "Biblioteca")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editorial", nullable = false)
	private long idEditorial;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "editorial")
	List<Libro> libros;
	
	
	public Editorial() {
		super();
	}
	
	public Editorial(String nombre) {
		super();
		this.nombre = nombre;
	}
}
