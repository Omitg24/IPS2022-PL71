package inscripcionpericial.model;

import java.sql.Date;

public class InscripcionPericialDTO {
	
    private String dniColegiado ;
    public Date fechaInscripcion;
    private int posicionLista;
    private String estadoInscripcion ;
    
    public InscripcionPericialDTO() {}
    
	public InscripcionPericialDTO(String dniColegiado, Date fechaInscripcion, int posicionLista,
			String estadoInscripcion) {
		this.dniColegiado = dniColegiado;
		this.fechaInscripcion = fechaInscripcion;
		this.posicionLista = posicionLista;
		this.estadoInscripcion = estadoInscripcion;
	}

	public String getDniColegiado() {
		return dniColegiado;
	}

	public void setDniColegiado(String dniColegiado) {
		this.dniColegiado = dniColegiado;
	}


	public Date getFechaInscripcion() {
		return fechaInscripcion;
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
