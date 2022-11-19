package coiipa.model.dto;

public class InscripcionPericialDTO {
	
    private String dniColegiado ;
    public String fechaInscripcion;
    private int posicionLista;
    private String estadoInscripcion ;
    private String estadoAsignacionPericial;
    private String fecha;
    
    public InscripcionPericialDTO() {}
    
	public InscripcionPericialDTO(String dniColegiado, String fechaInscripcion, int posicionLista,
			String estadoInscripcion) {
		this.dniColegiado = dniColegiado;
		this.fechaInscripcion = fechaInscripcion;
		this.posicionLista = posicionLista;
		this.estadoInscripcion = estadoInscripcion;
	}
	
	public InscripcionPericialDTO(String dniColegiado, String fechaInscripcion, int posicionLista,
			String estadoInscripcion,String estadoAsignacionPericial) {
		this.dniColegiado = dniColegiado;
		this.fechaInscripcion = fechaInscripcion;
		this.posicionLista = posicionLista;
		this.estadoInscripcion = estadoInscripcion;
		this.estadoAsignacionPericial=estadoAsignacionPericial;
	}
	
	public InscripcionPericialDTO(String dniColegiado, String fechaInscripcion, int posicionLista,
			String estadoInscripcion,String estadoAsignacionPericial,String fecha) {
		this.dniColegiado = dniColegiado;
		this.fechaInscripcion = fechaInscripcion;
		this.posicionLista = posicionLista;
		this.estadoInscripcion = estadoInscripcion;
		this.estadoAsignacionPericial=estadoAsignacionPericial;
		this.fecha=fecha;
	}
	
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstadoAsignacionPericial() {
		return estadoAsignacionPericial;
	}

	public void setEstadoAsignacionPericial(String estadoAsignacionPericial) {
		this.estadoAsignacionPericial = estadoAsignacionPericial;
	}

	public String getDniColegiado() {
		return dniColegiado;
	}

	public void setDniColegiado(String dniColegiado) {
		this.dniColegiado = dniColegiado;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public int getPosicionLista() {
		return posicionLista;
	}

	public void setPosicionLista(int posicionLista) {
		this.posicionLista = posicionLista;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}
    
    
    

}
