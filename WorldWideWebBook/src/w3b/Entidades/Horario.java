package w3b.Entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Horario {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date desde;
	@Temporal(TemporalType.DATE)
	private Date hasta;

	@ManyToOne
	private Publicacion publicacion;

	public Horario(Date desde, Date hasta) {
		super();
		this.desde = desde;
		this.hasta = hasta;
	}

	public Horario(Date desde) {
		super();
		this.desde = desde;
	}

	public Horario() {
		super();
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Horario) {
			return ((Horario) obj).id == this.id;
		} else {
			return false;
		}
	}
}
