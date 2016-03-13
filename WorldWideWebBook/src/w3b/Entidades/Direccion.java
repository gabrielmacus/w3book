package w3b.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Direccion {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Column(length = 20, nullable = false)
	private String calle;
	private int numero;
	@Lob
	private String observaciones;
	@Column(length = 30)
	private String lat;
	@Column(length = 30)
	private String lot;
	@Column(length = 30)
	private String pais;
	@Column(length = 30)
	private String provincia;
	@Column(length = 30)
	private String localidad;
	@ManyToOne
	private Publicacion publicacion;

	public Direccion(String pais) {
		super();
		this.pais = pais;
	}

	public Direccion() {
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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Direccion) {
			return ((Direccion) obj).id == this.id;
		} else {
			return false;
		}
	}

}
