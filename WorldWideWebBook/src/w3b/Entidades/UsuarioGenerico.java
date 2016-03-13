package w3b.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UsuarioGenerico {
	@SequenceGenerator(name = "standard_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(generator = "standard_seq")
	private long id;
	@Column(length = 20, nullable = false, unique = true)
	private String username;
	@Column(length = 30, nullable = false)
	private String contraseña;
	@Column(length = 40, nullable = false, unique = true)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@Temporal(TemporalType.DATE)
	private Date fechaModificacion;
	@Column(nullable = false)
	private boolean isActive = false;
	@OneToMany(mappedBy = "usuario")
	private List<Publicacion> listaPublicaciones = new ArrayList<>();

	public UsuarioGenerico(String username, String contraseña, String email) {
		super();
		this.username = username;
		this.contraseña = contraseña;
		this.email = email;
		fechaCreacion = new Date();
		fechaModificacion = new Date();
	}

	public UsuarioGenerico() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Publicacion> getListaPublicaciones() {
		return listaPublicaciones;
	}

	public void setListaPublicaciones(List<Publicacion> listaPublicaciones) {
		this.listaPublicaciones = listaPublicaciones;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof UsuarioGenerico) {
			return this.id == ((UsuarioGenerico) obj).id;
		} else {
			return false;
		}
	}

}
