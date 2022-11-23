package coiipa.model.dto;

/**
 * 
 * Título: Clase SolicitudVisadoDTO
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class SolicitudVisadoDTO {
	
	private String id ;
	private String dni;
	private String nombre;
	private String apellidos;
	private String descripcion;
	
	public SolicitudVisadoDTO(){}
	


	public SolicitudVisadoDTO(String id, String dni, String nombre, String apellidos, String descripcion) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
