package coiipa.model.dto;

/**
 * Título: Clase SolicitudPericialDTO
 *
 * @author David Warzynski Abril, UO278968
 * @version 18 nov 2022
 */
public class SolicitudPericialDTO {

	private String dni;
	private String id;
	private String estado;
	private String fecha;

	public SolicitudPericialDTO() {
	}

	public SolicitudPericialDTO(String dni, String id, String estado, String fecha) {
		this.dni = dni;
		this.id = id;
		this.estado = estado;
		this.fecha = fecha;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "SolicitudPericialDTO [dni=" + dni + ", id=" + id + ", estado=" + estado + ", fecha=" + fecha + "]";
	}		
}
