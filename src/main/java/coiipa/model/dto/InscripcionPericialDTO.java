package coiipa.model.dto;

public class InscripcionPericialDTO {
	
    private String dniColegiado ;
    public String fechaInscripcion;
    private int posicionLista;
    private int posicionListaVisado;
    private String estadoInscripcion ;
    private String estadoAsignacionPericial;
    private String estadoAsignacionVisado;
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
	
	public InscripcionPericialDTO(String dniColegiado, String fechaInscripcion, int posicionLista, int posicionListaVisado,
			String estadoInscripcion,String estadoAsignacionPericial,String estadoAsignacionVisado,String fecha) {
		this.dniColegiado = dniColegiado;
		this.fechaInscripcion = fechaInscripcion;
		this.posicionLista = posicionLista;
		this.posicionListaVisado= posicionListaVisado;
		this.estadoInscripcion = estadoInscripcion;
		this.estadoAsignacionPericial=estadoAsignacionPericial;
		this.estadoAsignacionVisado= estadoAsignacionVisado;
		this.fecha=fecha;
	}	

	
	public int getPosicionListaVisado() {
		return posicionListaVisado;
	}

	public void setPosicionListaVisado(int posicionListaVisado) {
		this.posicionListaVisado = posicionListaVisado;
	}

	public String getEstadoAsignacionVisado() {
		return estadoAsignacionVisado;
	}

	public void setEstadoAsignacionVisado(String estadoAsignacionVisado) {
		this.estadoAsignacionVisado = estadoAsignacionVisado;
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

	@Override
	public String toString() {
		return "InscripcionPericialDTO [dniColegiado=" + dniColegiado + ", fechaInscripcion=" + fechaInscripcion
				+ ", posicionLista=" + posicionLista + ", estadoInscripcion=" + estadoInscripcion
				+ ", estadoAsignacionPericial=" + estadoAsignacionPericial + ", fecha=" + fecha + "]";
	}
}
