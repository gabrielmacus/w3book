package w3b.Entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Producto extends Oferta {
	@Column(length = 20)
	private String marca;
	@Column(length = 30, nullable = false)
	private String modelo;

	public Producto(long costo, String descripcion, String marca, String modelo) {
		super(costo, descripcion);
		this.marca = marca;
		this.modelo = modelo;
	}

	public Producto(long costo, String descripcion, String modelo) {
		super(costo, descripcion);
		this.modelo = modelo;
	}

	public Producto(long costo, String descripcion) {
		super(costo, descripcion);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
