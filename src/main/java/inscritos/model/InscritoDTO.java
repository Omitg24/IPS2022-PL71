package inscritos.model;

/**
 * 
 * Título: Clase InscritoDTO
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritoDTO {
	private String apellidosSol;
	private String nombreSol;
	private String fecha;
	private String estadoS;
	private double abonado;
	
	public InscritoDTO() {}
	
	public InscritoDTO(String apellidosSol, String nombreSol,
			String fecha, String estadoS, double abonado) {
		this.apellidosSol = apellidosSol;
		this.nombreSol = nombreSol;
		this.fecha = fecha;
		this.estadoS = estadoS;
		this.abonado = abonado;
	}

	public String getApellidosSol() {
		return apellidosSol;
	}

	public void setApellidosSol(String apellidosSol) {
		this.apellidosSol = apellidosSol;
	}

	public String getNombreSol() {
		return nombreSol;
	}

	public void setNombreSol(String nombreSol) {
		this.nombreSol = nombreSol;
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
