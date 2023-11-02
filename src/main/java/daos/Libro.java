package daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libros", schema = "Biblioteca")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private long idLibro;

	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "edicion", nullable = false)
	private String edicion;
	
	@ManyToMany (mappedBy = "libros")
	List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(name = "editorial_id")
	Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name = "genero_id")
	Genero genero;
	
	@ManyToOne
	@JoinColumn(name = "coleccion_id")
	Coleccion coleccion;
	
	@OneToMany(mappedBy = "libro")
	List<Prestamo> prestamos;
	
	
	public Libro() {
		super();
	}
	
	public Libro(String isbn, String titulo, String edicion, Editorial editorial, Genero genero, Coleccion coleccion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.edicion = edicion;
		this.editorial = editorial;
		this.genero = genero;
		this.coleccion = coleccion;
	}
}
