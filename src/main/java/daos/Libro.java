package daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libros", schema = "Biblioteca")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private long id_libro;

	@Column(name = "isbn_libro", nullable = false)
	private String isbn_libro;
	
	@Column(name = "titulo_libro", nullable = false)
	private String titulo_libro;
	
	@Column(name = "edicion_libro", nullable = false)
	private String edicion_libro;
	
	@ManyToMany (mappedBy = "listaLibros")
	List<Autor> listaAutores;

	public Libro() {
		super();
	}
	
	public Libro(String isbn_libro, String titulo_libro, String edicion_libro) {
		super();
		this.isbn_libro = isbn_libro;
		this.titulo_libro = titulo_libro;
		this.edicion_libro = edicion_libro;
	}
}
