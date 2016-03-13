package w3b.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Publicacion {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Column(length = 20)
	private String titulo;
	@Lob
	private String descripcion;
	private byte calificacion = 0;
	@ManyToOne
	private UsuarioGenerico usuario;
	@OneToMany(mappedBy = "publicacion")
	private List<Oferta> listaOfertas = new ArrayList<>();
	@OneToMany(mappedBy = "publicacion")
	private List<Telefono> listaTelefonos = new ArrayList<>();
	@OneToMany(mappedBy = "publicacion")
	private List<Horario> listaHorarios = new ArrayList<>();
	@OneToMany(mappedBy = "publicacion")
	private List<Direccion> listaDirecciones = new ArrayList<>();

	@OneToMany(mappedBy = "publicacion")
	private List<Imagen> listaImagenes = new ArrayList<>();

	public Publicacion(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Publicacion(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Publicacion() {

	}

	public List<Imagen> getListaImagenes() {
		return listaImagenes;
	}

	public void setListaImagenes(List<Imagen> listaImagenes) {
		this.listaImagenes = listaImagenes;
	}

	public List<Oferta> getListaOfertas() {
		return listaOfertas;
	}

	public void setListaOfertas(List<Oferta> listaOfertas) {
		this.listaOfertas = listaOfertas;
	}

	public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	public List<Horario> getListaHorarios() {
		return listaHorarios;
	}

	public void setListaHorarios(List<Horario> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}

	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(byte calificacion) {
		this.calificacion = calificacion;
	}

	public UsuarioGenerico getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioGenerico usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Publicacion) {
			return this.id == ((Publicacion) obj).id;
		} else {
			return false;
		}
	}

}
