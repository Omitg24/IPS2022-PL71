package inscritos.model;

/**
 * 
 * Título: Clase InscritoDTO
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritoDTO {
	private String dniColegiado;
	private String tituloCurso;
	private String apellidosColegiado;
	private String nombreColegiado;
	private String fechaCurso;
	private String fecha;
	private String estadoS;
	private double abonado;
	
	public InscritoDTO() {}
	
	public InscritoDTO(String dniColegiado, String apellidosColegiado, String nombreColegiado,
			String fecha, String estadoS, double abonado) {
		this.dniColegiado = dniColegiado;
		this.apellidosColegiado = apellidosColegiado;
		this.nombreColegiado = nombreColegiado;
		this.fecha = fecha;
		this.estadoS = estadoS;
		this.abonado = abonado;
	}	
	
	public InscritoDTO(String dniColegiado, String tituloCurso, String apellidosColegiado, String nombreColegiado,
			String fechaCurso, String fecha, String estadoS, double abonado) {
		this(dniColegiado, apellidosColegiado, nombreColegiado, fecha, estadoS, abonado);
		this.tituloCurso = tituloCurso;
		this.fechaCurso = fechaCurso;
	}	
	
	public String getDniColegiado() {
		return dniColegiado;
	}

	public void setDniColegiado(String dni) {
		this.dniColegiado = dni;
	}	

	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	public String getApellidosColegiado() {
		return apellidosColegiado;
	}

	public void setApellidosColegiado(String apellidosColegiado) {
		this.apellidosColegiado = apellidosColegiado;
	}

	public String getNombreColegiado() {
		return nombreColegiado;
	}

	public void setNombreColegiado(String nombreColegiado) {
		this.nombreColegiado = nombreColegiado;
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
}
