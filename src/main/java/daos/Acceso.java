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
@Table(name = "Accesos", schema = "Biblioteca")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acceso", nullable = false)
	private long idAcceso;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "acceso")
	List<Usuario> usuarios;

	
	public Acceso() {
		super();
	}

	public Acceso(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
}
