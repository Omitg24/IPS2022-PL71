package coiipa.model.dto;

import java.util.Objects;

/**
 * Titulo: Clase AsignacionPericialDTO
 *
 * @author Omar Teixeira González, UO281847
 * @version 24 nov 2022
 */
public class AsignacionPericialDTO {
	/**
	 * Atributo id
	 */
	private String id;
	/**
	 * Atributo dni
	 */
	private String dni;
	/**
	 * Atributo nombre
	 */
	private String nombre;
	/**
	 * Atributo dniColegiado
	 */
	private String dniColegiado;
	/**
	 * Atributo nombreColegiado
	 */
	private String nombreColegiado;
	/**
	 * Atributo fecha
	 */
	private String fecha;
	/**
	 * Atributo estado
	 */
	private String estado;
	
	/**
	 * Constructor sin parámetros
	 */
	public AsignacionPericialDTO() {}
	
	/**
	 * Constructor con parámetros
	 * @param id
	 * @param dni
	 * @param nombre
	 * @param dniColegiado
	 * @param nombreColegiado
	 * @param fecha
	 * @param estado
	 */
	public AsignacionPericialDTO(String id, String dni, String nombre, String dniColegiado, String nombreColegiado,
			String fecha, String estado) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.dniColegiado = dniColegiado;
		this.nombreColegiado = nombreColegiado;
		this.fecha = fecha;
		this.estado = estado;
	}

	/**
	 * Método getId
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Método setId
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Método getDni
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Métod setDni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método getNombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setNombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getDniColegiado
	 * @return dniColegiado
	 */
	public String getDniColegiado() {
		return dniColegiado;
	}

	/**
	 * Método setDniColegiado
	 * @param dniColegiado
	 */
	public void setDniColegiado(String dniColegiado) {
		this.dniColegiado = dniColegiado;
	}

	/**
	 * Método getNombreColegiado
	 * @return nombreColegiado
	 */
	public String getNombreColegiado() {
		return nombreColegiado;
	}

	/**
	 * Método setNombreColegiado
	 * @param nombreColegiado
	 */
	public void setNombreColegiado(String nombreColegiado) {
		this.nombreColegiado = nombreColegiado;
	}
	
	/**
	 * Método getFecha
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Método setFecha
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método getEstado
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Método setEstado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "AsignacionPericialDTO [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", dniColegiado="
				+ dniColegiado + ", nombreColegiado=" + nombreColegiado + ", fecha=" + fecha + ", estado=" + estado
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, dniColegiado, estado, fecha, nombre, nombreColegiado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionPericialDTO other = (AsignacionPericialDTO) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(dniColegiado, other.dniColegiado)
				&& Objects.equals(estado, other.estado) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(nombreColegiado, other.nombreColegiado);
	}
}
