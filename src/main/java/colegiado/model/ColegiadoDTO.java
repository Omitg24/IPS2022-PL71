package colegiado.model;

/**
 * Título: Clase SolicitanteDTO
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ColegiadoDTO {
	/**
	 * Atributo dniSol
	 */
	private String dniSol;
	/**
	 * Atributo nombreSol
	 */
	private String nombreSol;
	/**
	 * Atributo apellidosSol
	 */
	private String apellidosSol;
	/**
	 * Atributo localidadSol
	 */
	private String localidadSol;
	/**
	 * Atributo telefonoSol
	 */
	private String telefonoSol;
	/**
	 * Atributo titulacionSol
	 */
	private String titulacionSol;
	/**
	 * Atributo centroSol
	 */
	private String centroSol;
	/**
	 * Atributo añoSol
	 */
	private String anioSol;
	/**
	 * Atributo ibanSol
	 */
	private String ibanSol;
	private String numeroColegiado;
	
	
	public ColegiadoDTO() { }
	/**
	 * Constructor ApplicantDTO 
	 * @param dniSol
	 * @param nombreSol
	 * @param apellidosSol
	 * @param localidadSol
	 * @param telefonoSol
	 * @param titulacionSol
	 * @param centroSol
	 * @param añoSol
	 * @param ibanSol
	 */
	public ColegiadoDTO(String dniSol, String nombreSol, String apellidosSol, 
			String localidadSol, String telefonoSol, String titulacionSol, 
			String centroSol, String añoSol, String ibanSol, String numeroColegiado) {		
		this.dniSol = dniSol;
		this.nombreSol = nombreSol;
		this.apellidosSol = apellidosSol;
		this.localidadSol = localidadSol;
		this.telefonoSol = telefonoSol;
		this.titulacionSol = titulacionSol;
		this.centroSol = centroSol;
		this.anioSol = añoSol;
		this.ibanSol = ibanSol;
		this.numeroColegiado = numeroColegiado;
	}

	/**
	 * Método getDniSol
	 * @return dniSol
	 */
	public String getDniSol() {
		return dniSol;
	}

	/**
	 * Método setDniSol
	 * @param dniSol
	 */
	public void setDniSol(String dniSol) {
		this.dniSol = dniSol;
	}

	/**
	 * Método getNombreSOl
	 * @return nombreSol
	 */
	public String getNombreSol() {
		return nombreSol;
	}

	/**
	 * Método setNombreSol
	 * @param nombreSol
	 */
	public void setNombreSol(String nombreSol) {
		this.nombreSol = nombreSol;
	}

	/**
	 * Método getApellidoSol
	 * @return apellidosSol
	 */
	public String getApellidoSol() {
		return apellidosSol;
	}

	/**
	 * Método setApellidoSol
	 * @param apellidosSol
	 */
	public void setApellidosSol(String apellidosSol) {
		this.apellidosSol = apellidosSol;
	}

	/**
	 * Método getLocalidadSol
	 * @return localidadSol
	 */
	public String getLocalidadSol() {
		return localidadSol;
	}

	/**
	 * Método setLocalidadSol
	 * @param localidadSol
	 */
	public void setLocalidadSol(String localidadSol) {
		this.localidadSol = localidadSol;
	}

	/**
	 * Método getTelefonoSol
	 * @return telefonoSol
	 */
	public String getTelefonoSol() {
		return telefonoSol;
	}

	/**
	 * Método setTelefonoSol
	 * @param telefonoSol
	 */
	public void setTelefonoSol(String telefonoSol) {
		this.telefonoSol = telefonoSol;
	}

	/**
	 * Método getTitulacionSol
	 * @return titulacionSol
	 */
	public String getTitulacionSol() {
		return titulacionSol;
	}

	/**
	 * Método setTitulacionSol
	 * @param titulacionSol
	 */
	public void setTitulacionSol(String titulacionSol) {
		this.titulacionSol = titulacionSol;
	}

	/**
	 * Método getCentroSol
	 * @return centroSol
	 */
	public String getCentroSol() {
		return centroSol;
	}

	/**
	 * Método setCentroSol
	 * @param centroSol
	 */
	public void setCentroSol(String centroSol) {
		this.centroSol = centroSol;
	}

	/**
	 * Método getAñoSol
	 * @return añoSol
	 */
	public String getAnioSol() {
		return anioSol;
	}

	/**
	 * Método setAñoSol
	 * @param añoSol
	 */
	public void setAnioSol(String añoSol) {
		this.anioSol = añoSol;
	}

	/**
	 * Método getIbanSol
	 * @return ibanSol
	 */
	public String getIbanSol() {
		return ibanSol;
	}

	/**
	 * Método setIbanSol
	 * @param ibanSol
	 */
	public void setIbanSol(String ibanSol) {
		this.ibanSol = ibanSol;
	}

	public String getNumeroColegiado() {
		return numeroColegiado;
	}
	
	public void setNumeroColegiado(String numeroCol) {
		this.numeroColegiado = numeroCol;
	}
	
	public String getApellidosSol() {
		return apellidosSol;
	}
	
	/**
	 * Método toString
	 * @return string
	 */
	@Override
	public String toString() {
		return "Solicitante [dniSol=" + dniSol + ", nombreSol=" + nombreSol + ", apellidosSol=" + apellidosSol
				+ ", localidadSol=" + localidadSol + ", telefonoSol=" + telefonoSol + ", titulacionSol=" + titulacionSol
				+ ", centroSol=" + centroSol + ", añoSol=" + anioSol + ", ibanSol=" + ibanSol + "]";
	}
	
	
}