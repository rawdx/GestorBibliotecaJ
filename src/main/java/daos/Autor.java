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
	private long idAutor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;
	
	@JoinTable(name="Rel_Autores_Libros",
			joinColumns = @JoinColumn(name = "autor_id"),
			inverseJoinColumns = @JoinColumn(name = "libro_id"))
	@ManyToMany
	List<Libro> libros;
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
}
