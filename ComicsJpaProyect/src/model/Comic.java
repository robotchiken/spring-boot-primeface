package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import org.eclipse.persistence.annotations.ExistenceChecking;
import static org.eclipse.persistence.annotations.ExistenceType.CHECK_CACHE;
import static org.eclipse.persistence.annotations.ExistenceType.CHECK_DATABASE;


/**
 * The persistent class for the COMIC database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Comic.findAll", query="SELECT c FROM Comic c"),
	@NamedQuery(name="Comic.findById", query="SELECT c FROM Comic c WHERE c.idComic=:idComic"),
	@NamedQuery(name="Comic.findByTitulo", query="SELECT c FROM Comic c WHERE c.titulo=:titulo"),
	@NamedQuery(name="Comic.findByMultipleId", query="SELECT c FROM Comic c WHERE c.idComic IN :titulos")
})

@ExistenceChecking(CHECK_DATABASE)
public class Comic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMIC")
	private int idComic;

	@Column(name="EN_PUBLICACION")
	private short enPublicacion;

	private BigDecimal precio;

	private String titulo;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="comics")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Calendario
	@OneToMany(mappedBy="comic")
	private List<Calendario> calendarios;

	//bi-directional many-to-one association to Carritocompra
	@OneToMany(mappedBy="comic")
	private List<Carritocompra> carritocompras;

	//bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name="ID_EDITORIAL")
	private Editorial editorial;

	//bi-directional many-to-one association to Periodicidad
	@ManyToOne
	@JoinColumn(name="ID_PERIODICIDAD")
	private Periodicidad periodicidad;
	
	@Column(name="NUMERO_INICIAL")
	private int numeroInicial;
	
	@Column(name="NUMERO_FINAL")
	private int numeroFinal;

	public Comic() {
	}

	public int getIdComic() {
		return this.idComic;
	}

	public void setIdComic(int idComic) {
		this.idComic = idComic;
	}

	public short getEnPublicacion() {
		return this.enPublicacion;
	}

	public void setEnPublicacion(short enPublicacion) {
		this.enPublicacion = enPublicacion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Calendario> getCalendarios() {
		return this.calendarios;
	}

	public void setCalendarios(List<Calendario> calendarios) {
		this.calendarios = calendarios;
	}

	public Calendario addCalendario(Calendario calendario) {
		getCalendarios().add(calendario);
		calendario.setComic(this);

		return calendario;
	}

	public Calendario removeCalendario(Calendario calendario) {
		getCalendarios().remove(calendario);
		calendario.setComic(null);

		return calendario;
	}

	public List<Carritocompra> getCarritocompras() {
		return this.carritocompras;
	}

	public void setCarritocompras(List<Carritocompra> carritocompras) {
		this.carritocompras = carritocompras;
	}

	public Carritocompra addCarritocompra(Carritocompra carritocompra) {
		getCarritocompras().add(carritocompra);
		carritocompra.setComic(this);

		return carritocompra;
	}

	public Carritocompra removeCarritocompra(Carritocompra carritocompra) {
		getCarritocompras().remove(carritocompra);
		carritocompra.setComic(null);

		return carritocompra;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Periodicidad getPeriodicidad() {
		return this.periodicidad;
	}

	public void setPeriodicidad(Periodicidad periodicidad) {
		this.periodicidad = periodicidad;
	}

	public int getNumeroInicial() {
		return numeroInicial;
	}

	public void setNumeroInicial(int numeroInicial) {
		this.numeroInicial = numeroInicial;
	}

	public int getNumeroFinal() {
		return numeroFinal;
	}

	public void setNumeroFinal(int numeroFinal) {
		this.numeroFinal = numeroFinal;
	}

	@Override
	public String toString() {
		return "Comic [idComic=" + idComic + ", enPublicacion=" + enPublicacion + ", precio=" + precio + ", titulo="
				+ titulo + ", usuarios=" + usuarios + ", calendarios=" + calendarios + ", carritocompras="
				+ carritocompras + ", editorial=" + editorial + ", periodicidad=" + periodicidad + "]";
	}

}