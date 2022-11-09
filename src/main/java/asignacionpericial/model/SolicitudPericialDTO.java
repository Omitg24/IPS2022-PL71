package asignacionpericial.model;

public class SolicitudPericialDTO {
	
    private String dni ;
    private String id ;
    private String estado;
    
    
    public SolicitudPericialDTO() {}
    
    
    
	public SolicitudPericialDTO(String dni, String id, String estado) {
		this.dni = dni;
		this.id = id;
		this.estado = estado;
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
    
    

}
