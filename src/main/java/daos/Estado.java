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
@Table(name = "Estados", schema = "Biblioteca")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", nullable = false)
	private long idEstado;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy = "estado")
	List<Prestamo> prestamos;
	
	public Estado() {
		super();
	}

	public Estado(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
}
