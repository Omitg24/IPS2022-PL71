package coiipa.model.dto;

/**
 * Título: Clase InscritoDTO
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira Gonzalez, UO281847
 * @version 23 nov 2022
 */
public class InscritoDTO {
	/**
	 * Atributo dniColegiado
	 */
	private String dniColegiado;
	/**
	 * Atributo tituloCurso
	 */
	private String tituloCurso;
	/**
	 * Atributo apellidosColegiado
	 */
	private String apellidosColegiado;
	/**
	 * Atributo nombreColegiado
	 */
	private String nombreColegiado;
	/**
	 * Atributo fechaCurso
	 */
	private String fechaCurso;
	/**
	 * Atributo fecha
	 */
	private String fecha;
	/**
	 * Atributo estadoS
	 */
	private String estadoS;
	/**
	 * Atributo abonado
	 */
	private double abonado;
	/**
	 * Atributo enEspera
	 */
	private boolean enEspera;
	/**
	 * Atributo posicionEspera
	 */
	private int posicionEspera;
	
	/**
	 * Constructor sin parámetro
	 */
	public InscritoDTO() {}
	
	/**
	 * Constructor con parámetros
	 * @param dniColegiado
	 * @param apellidosColegiado
	 * @param nombreColegiado
	 * @param fecha
	 * @param estadoS
	 * @param abonado
	 */
	public InscritoDTO(String dniColegiado, String apellidosColegiado, String nombreColegiado,
			String fecha, String estadoS, double abonado) {
		this.dniColegiado = dniColegiado;
		this.apellidosColegiado = apellidosColegiado;
		this.nombreColegiado = nombreColegiado;
		this.fecha = fecha;
		this.estadoS = estadoS;
		this.abonado = abonado;
	}	
	
	/**
	 * Constructor con parámetros
	 * @param dniColegiado
	 * @param tituloCurso
	 * @param apellidosColegiado
	 * @param nombreColegiado
	 * @param fechaCurso
	 * @param fecha
	 * @param estadoS
	 * @param abonado
	 */
	public InscritoDTO(String dniColegiado, String tituloCurso, String apellidosColegiado, String nombreColegiado,
			String fechaCurso, String fecha, String estadoS, double abonado) {
		this(dniColegiado, apellidosColegiado, nombreColegiado, fecha, estadoS, abonado);
		this.tituloCurso = tituloCurso;
		this.fechaCurso = fechaCurso;
	}	
	
	/**
	 * Constructor con parámetros
	 * @param dniColegiado
	 * @param tituloCurso
	 * @param apellidosColegiado
	 * @param nombreColegiado
	 * @param fechaCurso
	 * @param fecha
	 * @param estadoS
	 * @param abonado
	 * @param enEspera
	 * @param posicionEspera
	 */
	public InscritoDTO(String dniColegiado, String tituloCurso, String apellidosColegiado, String nombreColegiado,
			String fechaCurso, String fecha, String estadoS, double abonado, boolean enEspera, int posicionEspera) {
		this(dniColegiado, tituloCurso, apellidosColegiado, nombreColegiado, fechaCurso, fecha, estadoS, abonado);
		this.enEspera = enEspera;
		this.posicionEspera = posicionEspera;
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
	 * @param dni
	 */
	public void setDniColegiado(String dni) {
		this.dniColegiado = dni;
	}	

	/**
	 * Método getTituloCurso
	 * @return tituloCurso
	 */
	public String getTituloCurso() {
		return tituloCurso;
	}

	/**
	 * Método setTituloCurso
	 * @param tituloCurso
	 */
	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	/**
	 * Método getApellidosColegiado
	 * @return apellidosColegiadow
	 */
	public String getApellidosColegiado() {
		return apellidosColegiado;
	}

	/**
	 * Método setApellidos
	 * @param apellidosColegiado
	 */
	public void setApellidosColegiado(String apellidosColegiado) {
		this.apellidosColegiado = apellidosColegiado;
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
	 * Método getFechaCurso
	 * @return fechaCurso
	 */
	public String getFechaCurso() {
		return fechaCurso;
	}

	/**
	 * Método setFechaCurso
	 * @param fechaCurso
	 */
	public void setFechaCurso(String fechaCurso) {
		this.fechaCurso = fechaCurso;
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
	 * Método getEstadoS
	 * @return estadoS
	 */
	public String getEstadoS() {
		return estadoS;
	}
	
	/**
	 * Método setEstadoS
	 * @param estadoS
	 */
	public void setEstadoS(String estadoS) {
		this.estadoS = estadoS;
	}

	/**
	 * Método abonado
	 * @return abonado
	 */
	public double getAbonado() {
		return abonado;
	}

	/**
	 * Método setAbonado
	 * @param abonado
	 */
	public void setAbonado(double abonado) {
		this.abonado = abonado;
	}

	/**
	 * Método isEnEspera
	 * @return enEspera
	 */
	public boolean isEnEspera() {
		return enEspera;
	}

	/**
	 * Método setEnEspera
	 * @param enEspera
	 */
	public void setEnEspera(boolean enEspera) {
		this.enEspera = enEspera;
	}

	/**
	 * Método getPosicionEspera
	 * @return posicionEspera
	 */
	public int getPosicionEspera() {
		return posicionEspera;
	}

	/**
	 * Método setPosicionEspera
	 * @param posicionEspera
	 */
	public void setPosicionEspera(int posicionEspera) {
		this.posicionEspera = posicionEspera;
	}	
}
