package coiipa.model.dto;

public class InscribeDTO {
	
    private String dniColegiado;
    private String tituloCurso;
    private String fechaCurso;
    private String fecha;
    private String estadoS;
    private double abonado;
    private String incidencia;
    
    public InscribeDTO() {}
    
	public InscribeDTO(String dniColegiado, String tituloCurso, String fechaCurso, String fecha, String estadoS,
			double abonado, String incidencia) {
		this.dniColegiado = dniColegiado;
		this.tituloCurso = tituloCurso;
		this.fechaCurso = fechaCurso;
		this.fecha = fecha;
		this.estadoS = estadoS;
		this.abonado = abonado;
		this.incidencia = incidencia;
	}

	public String getDniColegiado() {
		return dniColegiado;
	}

	public void setDniColegiado(String dniColegiado) {
		this.dniColegiado = dniColegiado;
	}

	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	public String getFechaCurso() {
		return fechaCurso;
	}

	public void setFechaCurso(String fechaCurso) {
		this.fechaCurso = fechaCurso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstadoS() {
		return estadoS;
	}

	public void setEstadoS(String estadoS) {
		this.estadoS = estadoS;
	}

	public double getAbonado() {
		return abonado;
	}

	public void setAbonado(double abonado) {
		this.abonado = abonado;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	@Override
	public String toString() {
		return "InscribeDTO [dniColegiado=" + dniColegiado + ", tituloCurso=" + tituloCurso + ", fechaCurso="
				+ fechaCurso + ", fecha=" + fecha + ", estadoS=" + estadoS + ", abonado=" + abonado + ", incidencia="
				+ incidencia + "]";
	}
}
