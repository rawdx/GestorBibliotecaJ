package daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Autores", schema = "Biblioteca")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor", nullable = false)
	private long id_autor;

	@Column(name = "nombre_autor")
	private String nombre_autor;

	@Column(name = "apellidos_autor")
	private String apellidos_autor;
	
	@JoinTable(name="Rel_Autores_Libros",
			joinColumns = @JoinColumn(name = "autor_id"),
			inverseJoinColumns = @JoinColumn(name = "libro_id"))
	@ManyToMany
	List<Libro> listaLibros;
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre_autor, String apellidos_autor) {
		super();
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
	}
}
