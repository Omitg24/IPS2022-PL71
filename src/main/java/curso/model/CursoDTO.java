package curso.model;

public class CursoDTO {

	private String titulo;
	private String fechaInicio;
	private double precio;

	public CursoDTO(String titulo, String fechaInicio, double precio) {
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
