package inscritos.model;

/**
 * 
 * Título: Clase InscritoDTO
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritoDTO {
	private String dni;
	private String apellidosColegiado;
	private String nombreColegiado;
	private String fecha;
	private String estadoS;
	private double abonado;
	
	public InscritoDTO() {}
	
	public InscritoDTO(String dni, String apellidosColegiado, String nombreColegiado,
			String fecha, String estadoS, double abonado) {
		this.dni = dni;
		this.apellidosColegiado = apellidosColegiado;
		this.nombreColegiado = nombreColegiado;
		this.fecha = fecha;
		this.estadoS = estadoS;
		this.abonado = abonado;
	}	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
