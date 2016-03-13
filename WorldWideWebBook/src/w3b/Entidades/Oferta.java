package w3b.Entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("O")
public class Oferta {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Column(columnDefinition = "numeric(10,2)", nullable = false)
	private long costo;
	@Lob
	@Column(nullable = false)
	private String descripcion;
	@ManyToOne
	private Publicacion publicacion;

	public Oferta(long costo, String descripcion) {
		super();
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public Oferta() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCosto() {
		return costo;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Oferta) {
			return ((Oferta) obj).id == this.id;
		} else {
			return false;
		}
	}
}
