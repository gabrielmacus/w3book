package w3b.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
public class Imagen {

	private String nombre;
	@Type(type = "org.hibernate.type.BinaryType")
	private byte imagen[];
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;

	@ManyToOne
	private Publicacion publicacion;

	public Imagen(byte imagen[],String nombre) {
		super();
		this.imagen = imagen;
		this.nombre =nombre;
	}

	public Imagen() {

	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}
