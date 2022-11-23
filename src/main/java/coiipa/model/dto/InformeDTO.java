package coiipa.model.dto;

public class InformeDTO {
	
    private String id;
    private String nombre;
    private String dni ;
    private String correo;
    private String telefono;
    private String descripcion;
    private String urgencia ;
    
    public InformeDTO() {}
    
    
	public InformeDTO(String id, String nombre, String dni, String correo, String telefono, String descripcion,
			String urgencia) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.correo = correo;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.urgencia = urgencia;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}


	@Override
	public String toString() {
		return "InformeDTO [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", correo=" + correo + ", telefono="
				+ telefono + ", descripcion=" + descripcion + ", urgencia=" + urgencia + "]";
	}
    
    
    

}
