package colegiado.model;

import java.util.Date;

/**
 * Título: Clase SolicitanteDTO
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ColegiadoDTO {
	/**
	 * Atributo dniColegiado
	 */
	private String dniColegiado;
	/**
	 * Atributo nombreColegiado
	 */
	private String nombreColegiado;
	/**
	 * Atributo apellidosColegiado
	 */
	private String apellidosColegiado;
	/**
	 * Atributo numeroColegiado
	 */
	private String numeroColegiado;
	/**
	 * Atributo localidadColegiado
	 */
	private String localidadColegiado;
	/**
	 * Atributo telefonoColegiado
	 */
	private String telefonoColegiado;
	/**
	 * Atributo titulacionColegiado
	 */
	private String titulacionColegiado;
	/**
	 * Atributo centroColegiado
	 */
	private String centroColegiado;
	/**
	 * Atributo anioColegiado
	 */
	private String anioColegiado;
	/**
	 * Atributo ibanColegiado
	 */
	private String ibanColegiado;
	/**
	 * Atributo tipoColegiado
	 */
	private String tipoColegiado;
	/**
	 * Atributo estadoColegiado
	 */
	private String estadoColegiado;
	/**
	 * Atributo estadoCuota
	 */
	private String estadoCuota;
	/**
	 * Atributo estadoAsignacionPericial
	 */
	private String estadoAsignacionPericial;
	/**
	 * Atributo fechaColegiacion
	 */
	private Date fechaColegiacion;
	
	/**
	 * Constructor ColegiadoDTO
	 */
	public ColegiadoDTO() {}
	
	/**
	 * Constructor ApplicantDTO 
	 */
	public ColegiadoDTO(String dniColegiado, String nombreColegiado, String apellidosColegiado, String numeroColegiado,
			String localidadColegiado, String telefonoColegiado, String titulacionColegiado, String centroColegiado,
			String anioColegiado, String ibanColegiado, String tipoColegiado, String estadoColegiado,
			String estadoCuota, String estadoAsignacionPericial, Date fechaColegiacion) {
		this.dniColegiado = dniColegiado;
		this.nombreColegiado = nombreColegiado;
		this.apellidosColegiado = apellidosColegiado;
		this.numeroColegiado = numeroColegiado;
		this.localidadColegiado = localidadColegiado;
		this.telefonoColegiado = telefonoColegiado;
		this.titulacionColegiado = titulacionColegiado;
		this.centroColegiado = centroColegiado;
		this.anioColegiado = anioColegiado;
		this.ibanColegiado = ibanColegiado;
		this.tipoColegiado = tipoColegiado;
		this.estadoColegiado = estadoColegiado;
		this.estadoCuota = estadoCuota;
		this.estadoAsignacionPericial = estadoAsignacionPericial;
		this.fechaColegiacion = fechaColegiacion;
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
	 * @param dniColegiado
	 */
	public void setDniColegiado(String dniColegiado) {
		this.dniColegiado = dniColegiado;
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
	 * Método getApellidosColegiado
	 * @return apellidosColegiado
	 */
	public String getApellidosColegiado() {
		return apellidosColegiado;
	}

	/**
	 * Método setApellidosColegiado
	 * @param apellidosColegiado
	 */
	public void setApellidosColegiado(String apellidosColegiado) {
		this.apellidosColegiado = apellidosColegiado;
	}
	
	/**
	 * Método getNumeroColegiado
	 * @return numeroColegiado
	 */
	public String getNumeroColegiado() {
		return numeroColegiado;
	}
	
	/**
	 * Método setNumeroColegiado
	 * @param numeroCol
	 */
	public void setNumeroColegiado(String numeroCol) {
		this.numeroColegiado = numeroCol;
	}

	/**
	 * Método getLocalidadColegiado
	 * @return localidadColegiado
	 */
	public String getLocalidadColegiado() {
		return localidadColegiado;
	}

	/**
	 * Método setLocalidadColegiado
	 * @param localidadColegiado
	 */
	public void setLocalidadColegiado(String localidadColegiado) {
		this.localidadColegiado = localidadColegiado;
	}

	/**
	 * Método getTelefonoColegiado
	 * @return telefonoColegiado
	 */
	public String getTelefonoColegiado() {
		return telefonoColegiado;
	}

	/**
	 * Método setTelefonoColegiado
	 * @param telefonoColegiado
	 */
	public void setTelefonoColegiado(String telefonoColegiado) {
		this.telefonoColegiado = telefonoColegiado;
	}

	/**
	 * Método getTitulacionColegiado
	 * @return titulacionColegiado
	 */
	public String getTitulacionColegiado() {
		return titulacionColegiado;
	}

	/**
	 * Método setTitulacionColegiado
	 * @param titulacionColegiado
	 */
	public void setTitulacionColegiado(String titulacionColegiado) {
		this.titulacionColegiado = titulacionColegiado;
	}

	/**
	 * Método getCentroColegiado
	 * @return centroColegiado
	 */
	public String getCentroColegiado() {
		return centroColegiado;
	}

	/**
	 * Método setCentroColegiado
	 * @param centroColegiado
	 */
	public void setCentroColegiado(String centroColegiado) {
		this.centroColegiado = centroColegiado;
	}

	/**
	 * Método getAnioColegiado
	 * @return anioColegiado
	 */
	public String getAnioColegiado() {
		return anioColegiado;
	}

	/**
	 * Método setAnioColegiado
	 * @param anioColegiado
	 */
	public void setAnioColegiado(String anioColegiado) {
		this.anioColegiado = anioColegiado;
	}

	/**
	 * Método getIbanColegiado
	 * @return ibanColegiado
	 */
	public String getIbanColegiado() {
		return ibanColegiado;
	}

	/**
	 * Método setIbanColegiado
	 * @param ibanColegiado
	 */
	public void setIbanColegiado(String ibanColegiado) {
		this.ibanColegiado = ibanColegiado;
	}	
	
	/**
	 * Método getTipoColegiado
	 * @return tipoColegiado
	 */
	public String getTipoColegiado() {
		return tipoColegiado;
	}
	
	/**
	 * Método setTipoColegiado
	 * @param tipoColegiado
	 */
	public void setTipoColegiado(String tipoColegiado) {
		this.tipoColegiado = tipoColegiado;
	}
	
	/**
	 * Método getEstadoColegiado
	 * @return estadoColegiado
	 */
	public String getEstadoColegiado() {
		return estadoColegiado;
	}
	
	/**
	 * Método setEstadoColegiado
	 * @param estadoColegiado
	 */
	public void setEstadoColegiado(String estadoColegiado) {
		this.estadoColegiado = estadoColegiado;
	}
	
	/**
	 * Método getEstadoCuota
	 * @return estadoCuota
	 */
	public String getEstadoCuota() {
		return estadoCuota;
	}
	
	/**
	 * Método setEstadoCuota
	 * @param estadoCuota
	 */
	public void setEstadoCuota(String estadoCuota) {
		this.estadoCuota = estadoCuota;
	}
	
	/**
	 * Método getEstadoAsignacionPericial
	 * @return estadoAsignacionPericial
	 */
	public String getEstadoAsignacionPericial() {
		return estadoAsignacionPericial;
	}
	
	/**
	 * Método setEstadoAsignacionPericial
	 * @param estadoAsignacionPericial
	 */
	public void setEstadoAsignacionPericial(String estadoAsignacionPericial) {
		this.estadoAsignacionPericial = estadoAsignacionPericial;
	}
	
	/**
	 * Método getFechaColegiacion
	 * @return fechaColegiacion
	 */
	public Date getFechaColegiacion() {
		return fechaColegiacion;
	}
	
	/**
	 * Método setFechaColegiacion
	 * @param fechaColegiacion
	 */
	public void setFechaColegiacion(Date fechaColegiacion) {
		this.fechaColegiacion = fechaColegiacion;
	}
	
	/**
	 * Método toString
	 * @return string
	 */
	@Override
	public String toString() {
		return "ColegiadoDTO [dniColegiado=" + dniColegiado + ", nombreColegiado=" + nombreColegiado
				+ ", apellidosColegiado=" + apellidosColegiado + ", numeroColegiado=" + numeroColegiado
				+ ", localidadColegiado=" + localidadColegiado + ", telefonoColegiado=" + telefonoColegiado
				+ ", titulacionColegiado=" + titulacionColegiado + ", centroColegiado=" + centroColegiado
				+ ", anioColegiado=" + anioColegiado + ", ibanColegiado=" + ibanColegiado + ", tipoColegiado="
				+ tipoColegiado + ", estadoColegiado=" + estadoColegiado + ", estadoCuota=" + estadoCuota
				+ ", estadoAsignacionPericial=" + estadoAsignacionPericial + ", fechaColegiacion=" + fechaColegiacion
				+ "]";
	}	
	
	
	
}