package w3b.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Telefono {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Column(length = 20)
	private String numero;
	@ManyToOne
	private Publicacion publicacion;

	public Telefono(String numero) {
		super();
		this.numero = numero;
	}

	public Telefono() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
		if (obj instanceof Telefono) {
			return ((Telefono) obj).id == this.id;
		} else {
			return false;
		}
	}

}
