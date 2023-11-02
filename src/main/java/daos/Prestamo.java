package daos;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Prestamos", schema = "Biblioteca")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo", nullable = false)
	private long idPrestamo;
	
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaInicio;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaFin;
	
	@Column(name = "fecha_entrega")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name = "libro_id")
	Libro libro;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	Estado estado;

	
	public Prestamo() {
		super();
	}
	
	public Prestamo(Calendar fechaInicio, Calendar fechaFin, Calendar fechaEntrega, Libro libro,
			Usuario usuario, Estado estado) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaEntrega = fechaEntrega;
		this.libro = libro;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Prestamo(Libro libro, Usuario usuario, Estado estado) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.estado = estado;
	}
}
