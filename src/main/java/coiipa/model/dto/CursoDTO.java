package coiipa.model.dto;

public class CursoDTO {
	
	private String tituloCurso;
	private String fechaCurso;
	private double precio;
	private String fechaInicioIns;
	private String fechaFinIns;
	private String estadoc;
	private int nplazas;
	private int ninscritos;
	private String fecha;
	
	public CursoDTO() {}
	
	public CursoDTO(String titulocurso, String fechaCurso, double precio, String fechaInicioIns, 
			String fechaFinIns, String estadoc, int nplazas) {
		this.tituloCurso = titulocurso;
		this.fechaInicioIns = fechaInicioIns;
		this.fechaFinIns = fechaFinIns;
		this.fechaCurso = fechaCurso;
		this.precio = precio;
		this.estadoc = estadoc;
		this.nplazas = nplazas;		
	}
	
	public CursoDTO(String titulocurso, String fechaCurso, double precio, String fechaInicioIns, 
			String fechaFinIns, String estadoc, int nplazas,String fecha) {
		this(titulocurso, fechaCurso, precio, fechaInicioIns, fechaFinIns, estadoc, nplazas);
		this.fecha=fecha;
	}
	
	public CursoDTO(String titulocurso, String fechaCurso, double precio, String fechaInicioIns, 
			String fechaFinIns, String estadoc, int nplazas, int ninscritos, String fecha) {
		this(titulocurso, fechaCurso, precio, fechaInicioIns, fechaFinIns, estadoc, nplazas, fecha);
		this.ninscritos=ninscritos;
	}
	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFechaInicioIns() {
		return fechaInicioIns;
	}

	public void setFechaInicioIns(String fechaInicioIns) {
		this.fechaInicioIns = fechaInicioIns;
	}

	public String getFechaFinIns() {
		return fechaFinIns;
	}

	public void setFechaFinIns(String fechaFinIns) {
		this.fechaFinIns = fechaFinIns;
	}

	public String getEstadoc() {
		return estadoc;
	}

	public void setEstadoc(String estadoc) {
		this.estadoc = estadoc;
	}

	public int getNplazas() {
		return nplazas;
	}

	public void setNplazas(int nplazas) {
		this.nplazas = nplazas;
	}	

	public int getNinscritos() {
		return ninscritos;
	}

	public void setNinscritos(int ninscritos) {
		this.ninscritos = ninscritos;
	}

	public String toString() {
		return tituloCurso + " " + " " + fechaCurso + " " + fechaInicioIns + " " + fechaFinIns
				+ " " + precio + " " + estadoc + " " + nplazas;
	}
}
