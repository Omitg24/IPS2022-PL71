package coiipa.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.ColegiadoDTO;
import coiipa.model.dto.CursoDTO;
import coiipa.model.dto.InscribeDTO;
import coiipa.model.dto.InscritoDTO;
import coiipa.model.model.InscripcionModel;
import coiipa.view.InscripcionView;
import coiipa.view.inscripcion.AvisoEsperaView;
import coiipa.view.inscripcion.EmisionInscripcionView;
import coiipa.view.inscripcion.IdentificadorView;
import coiipa.view.inscripcion.JustificanteCancelarInscripcion;
import coiipa.view.inscripcion.TarjetaView;
import ui_events.ChangeColor;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase InscripcionController
 *
 * @author Adrián Alves Morales, UO284288 y Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class InscripcionController {
	/**
	 * Atributo model
	 */
	private InscripcionModel model;
	/**
	 * Atributo viewId
	 */
	private IdentificadorView viewId;
	/**
	 * Atributo view
	 */
	private InscripcionView view;
	/**
	 * Atributo emision
	 */
	private EmisionInscripcionView emision;
	/**
	 * Atributo tarjetaView
	 */
	private TarjetaView tarjetaView;
	/**
	 * Atributo avisoEsperaView
	 */
	private AvisoEsperaView avisoEsperaView;	
	/**
	 * Atributo colegiado
	 */
	private ColegiadoDTO colegiado;
	/**
	 * Atributo curso
	 */
	private CursoDTO curso;
	/**
	 * Atributo preinscritos
	 */
	private List<CursoDTO> preinscritos;
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
	 * Atributo tituloCurso
	 */
	private String tituloCurso;
	/**
	 * Atributo fechaCurso
	 */
	private String fechaCurso;	
	/**
	 * Atributo posicion
	 */
	private int posicion;
	/**
	 * Atributo enEspera
	 */
	private boolean enEspera;

	/**
	 * Constructor InscripcionController
	 * @param m
	 * @param v
	 */
	public InscripcionController(InscripcionModel m, IdentificadorView v) {
		this.model = m;
		this.viewId = v;
		this.view = (InscripcionView) viewId.getInscripcion();
		this.emision = view.getEmision();

		this.initView();
	}
	
	/**
	 * Método initView
	 */
	public void initView() {
		viewId.getFrame().setVisible(true);
	}

	/**
	 * Método initController
	 */
	public void initController() {
		viewId.getTextId().addFocusListener(new ChangeColor());
		viewId.getBtnEntrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> entrar()));
		view.getBtInscribirse().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirse()));
		emision.getBtnConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarEmision()));
		view.getButtonTarjeta().addActionListener(e -> SwingUtil.exceptionWrapper(() -> abrirPagoTarjeta()));
		view.getButtonTransferencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> confirmarPago("Transferencia")));
		view.getTbDisponibles().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> activarBotonInscribirse()));
		view.getTbSolicitados().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> gestionDeSolicitados()));
		view.getTbEspera().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> gestionDeEspera()));
		view.getButtonCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(()->cancelarInscripcion()));
	}
	
	/**
	 * Método actualizarTablas
	 */
	private void actualizarTablas() {
		getTablaCursosDisponibles();
		getTablaCursosSolicitados();
		getTablaCursosEnEspera();
	}
	
	/**
	 * Método activarBotonInscribirse
	 */
	private void activarBotonInscribirse() {
		view.getButtonInscribirse().setEnabled(true);
	}
	
	/**
	 * Método gestionDeSolicitados
	 */
	private void gestionDeSolicitados() {
		view.getButtonCancelar().setEnabled(true);
		view.getButtonTarjeta().setEnabled(true);
		view.getButtonTransferencia().setEnabled(true);
		view.getTbEspera().getSelectionModel().clearSelection();		
        this.enEspera = false;		
	}

	/**
	 * Método gestionDeEspera
	 */
	private void gestionDeEspera() {		
		view.getButtonCancelar().setEnabled(true);		
		view.getTbSolicitados().getSelectionModel().clearSelection();		
        this.enEspera = true;		
	}
	
	/**
	 * Método entrar
	 */
	public void entrar() {		
		if (comprobarId(viewId.getTextId().getText())) {
			this.dniColegiado = viewId.getTextId().getText();
			this.nombreColegiado = model.getColegiado(dniColegiado).getNombreColegiado();
			this.apellidosColegiado = model.getColegiado(dniColegiado).getApellidosColegiado();
			this.colegiado = model.getColegiado(dniColegiado);
			actualizarTablas();
			viewId.getFrame().setVisible(false);			
			view.getFrame().setVisible(true);
			view.getTextDni().setText(dniColegiado);
			view.getTextNombre().setText(nombreColegiado);
			view.getTextApellidos().setText(apellidosColegiado);
		} else {
			SwingUtil.showErrorDialog("El identificador introducido no es válido");
			viewId.getTextId().setText("");
		}
	}
	
	/**
	 * Método comprobarId
	 * @param s
	 * @return true o false
	 */
	public boolean comprobarId(String s) {
		return model.getColegiado(s) != null;
	}
	
	/**
	 * Método getTablaCursosDisponibles
	 */
	public void getTablaCursosDisponibles() {
		List<CursoDTO> cursos = model.getCursosDisponibles();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos, new String[] {"tituloCurso", "fechaCurso", 
				"fechaInicioIns", "fechaFinIns", 
				"precio", "estadoc", "nplazas"});
		view.getTbDisponibles().setModel(tmodel);
		String[] titles = new String[] {"Titulo", "Fecha", 
				"Fecha de inicio de inscripción", 
				"Fecha de fin de inscripción",
				"Precio", "Estado del curso", "Nº de plazas restantes"};
		for (int i = 0; i < titles.length; i++) {
			view.getTbDisponibles().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTbDisponibles());
		view.getTbDisponibles().getTableHeader().setReorderingAllowed(false);
		view.getTbDisponibles().getTableHeader().setResizingAllowed(false);
	}

	/**
	 * Método getTablaCursoSolicitados
	 */
	private void getTablaCursosSolicitados() {
		this.preinscritos = model.getCursosSolicitados(colegiado.getDniColegiado());
		TableModel tmodel = SwingUtil.getTableModelFromPojos(preinscritos, 
				new String[] {"tituloCurso", "fechaCurso", 
						"fecha", "estadoc", "precio", "cancelable"});
		view.getTbSolicitados().setModel(tmodel);
		String[] titles = new String[] { "Título del curso", "Fecha del curso", "Fecha de inscripción", "Estado del curso", "Precio del curso","Cancelable"};
		for (int i = 0; i < titles.length; i++) {
			view.getTbSolicitados().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTbSolicitados());
		view.getTbSolicitados().getTableHeader().setReorderingAllowed(false);
		view.getTbSolicitados().getTableHeader().setResizingAllowed(false);		
	}
	
	/**
	 * Método getTablaCursosEnEspera
	 */
	private void getTablaCursosEnEspera() {
		List<InscritoDTO> listaEspera = model.getListaDeEspera(dniColegiado);		
		TableModel tmodel = SwingUtil.getTableModelFromPojos(listaEspera, 
				new String[] {"tituloCurso", "fechaCurso", 
						"fecha", "estadoS", "posicionEspera"});
		view.getTbEspera().setModel(tmodel);
		String[] titles = new String[] { "Título del curso", "Fecha del curso", "Fecha de inscripción", "Estado de la solicitud", "Posicion en la lista de espera"};
		for (int i = 0; i < titles.length; i++) {
			view.getTbEspera().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTbEspera());
		view.getTbEspera().getTableHeader().setReorderingAllowed(false);
		view.getTbEspera().getTableHeader().setResizingAllowed(false);
	}

	/**
	 * Método inscribirse
	 */
	public void inscribirse() {
		this.tituloCurso = view.getTbDisponibles().getModel().getValueAt(view.getTbDisponibles().getSelectedRow(), 0).toString();
		this.fechaCurso = view.getTbDisponibles().getModel().getValueAt(view.getTbDisponibles().getSelectedRow(), 1).toString();		
		CursoDTO aux = model.getCursoInscrito(tituloCurso, fechaCurso, dniColegiado);
		
		if (!preinscritos.contains(aux) || aux == null) {
			curso = model.getCursoTituloFecha(tituloCurso, fechaCurso);
			if (curso.getNplazas() > 0) {
				model.inscribir(curso, colegiado);
				crearEmision();
				actualizarTablas();
			} else {
	            notificarEspera();
			}
		} else {
			SwingUtil.showErrorDialog("Ya ha solicitado plaza en el siguiente curso:\n\nTítulo: " + tituloCurso + "\nFecha: "+ fechaCurso);
		}		
	}	
	
	/**
	 * Método cerrarEmision
	 */
	public void cerrarEmision() {
		emision.getFrame().dispose();
	}	

	/**
	 * Método crearEmision
	 */
	public void crearEmision() {
		String nombre = colegiado.getNombreColegiado().substring(0, 1).toUpperCase()
				+ colegiado.getNombreColegiado().substring(1);
		String apellido = colegiado.getApellidosColegiado();
		String apellido1 = apellido.split(" ")[0];
		String apellido2 = apellido.split(" ")[1];
		String apellidoMayus = apellido1.substring(0, 1).toUpperCase()
				+ apellido1.substring(1)  + " "
				+ apellido2.substring(0, 1).toUpperCase()
				+ apellido2.substring(1);
		String num = colegiado.getNumeroColegiado();
		String fecha = LocalDateTime.now().toLocalDate().toString();
		String precio = curso.getPrecio() + "";
		emision.setNombre(nombre);
		emision.setApellido(apellidoMayus);
		emision.setNumero(num);
		emision.setFecha(fecha);
		emision.setCantidad(precio);
		emision.getFrame().setVisible(true);
	}

	/**
	 * Método notificarEspera
	 */
	private void notificarEspera() {
		this.posicion = model.getPosicionEnEspera(tituloCurso, fechaCurso) + 1;
		
		avisoEsperaView = new AvisoEsperaView(this);
		avisoEsperaView.getTextTituloCurso().setText(tituloCurso);
		avisoEsperaView.getTextFechaCurso().setText(fechaCurso);
		avisoEsperaView.getTextFechaInscripcionCurso().setText(LocalDate.now().toString());
		avisoEsperaView.getTextNombreColegiado().setText(nombreColegiado);
		avisoEsperaView.getTextApellidosColegiado().setText(apellidosColegiado);
		avisoEsperaView.getTextDniColegiado().setText(dniColegiado);
		avisoEsperaView.getTextPosicion().setText(String.valueOf(posicion));
		
		avisoEsperaView.setLocationRelativeTo(null);
		avisoEsperaView.setVisible(true);		
	}
	
	/**
	 * Método insertarEnEspera
	 */
	public void insertarEnEspera() {
		model.insertarEnEspera(dniColegiado, tituloCurso, fechaCurso, LocalDate.now().toString(), posicion);
		SwingUtil.showInformationDialog("Se la ha añadido a la lista de espera del siguiente curso:\n\nTítulo: " + tituloCurso + "\nFecha: "+ fechaCurso);
		avisoEsperaView.dispose();
		actualizarTablas();
	}
	
	/**
	 * Método abrirPagoTarjeta
	 */
	private void abrirPagoTarjeta() {
		if (!enEspera) {
			tarjetaView= new TarjetaView(this);
			tarjetaView.setLocationRelativeTo(null);
			tarjetaView.setVisible(true);
		} else {
			SwingUtil.showInformationDialog("No puede pagar un curso en el que se encuentra en lista de espera");
		}		
	}

	/**
	 * Método confirmarPago
	 * @param tipoPago
	 */
	public void confirmarPago(String tipoPago) {
		if (!enEspera) {
			String titulo = SwingUtil.getSelectedKey(view.getTbSolicitados());
			String fecha = SwingUtil.getSelectedKey(view.getTbSolicitados(),1);
			CursoDTO c = model.getCursoTituloFecha(titulo, fecha);
			if(comprobarFechaInscripcion(c) && comprobarPlazas(c)) {
				String estado ="";
				switch(tipoPago) {
				case "Tarjeta":
					estado="Inscrito";
				case "Transferencia":
					estado="Pendiente";
				}
				if(tarjetaView!=null)
					tarjetaView.dispose();
				model.actualizarEstadoInscripcion(colegiado.getDniColegiado(), 
							curso.getTituloCurso(), curso.getFechaCurso(), estado);
				getTablaCursosSolicitados();
				SwingUtil.showInformationDialog("Se ha registrado el pago del curso: "
							+ c.getTituloCurso()+", con fecha de inicio: "+
						c.getFechaCurso());
			}
		} else {
			SwingUtil.showInformationDialog("No puede pagar un curso en el que se encuentra en lista de espera");
		}
	}
	
	/**
	 * Método para cancelar la inscripción a un curso
	 */
	private void cancelarInscripcion() {
		String titulo = SwingUtil.getSelectedKey(view.getTbSolicitados());
		String fecha = SwingUtil.getSelectedKey(view.getTbSolicitados(),1);
		CursoDTO c = model.getCursoTituloFecha(titulo, fecha);
		if(comprobarCancelable(c) && comprobarFechaCurso(c)) {
			mostrarJustificante(c);
		}
	}

	private void mostrarJustificante(CursoDTO c) {
		JustificanteCancelarInscripcion j = new JustificanteCancelarInscripcion();
		j.getBtnConfirmar().addActionListener(e-> SwingUtil.exceptionWrapper(() -> confirmarCancelacion(j,c)));
		InscribeDTO i = model.buscarInscripcionCurso(dniColegiado, c.getTituloCurso(), c.getFechaCurso());
		j.setDni(dniColegiado);
		j.setTituloCurso(c.getTituloCurso());
		j.setFechaCurso(c.getFechaCurso());
		j.setFechaCancelacion(LocalDate.now().toString());
		j.setDineroDevuelt((c.getPorcentajeDevolucion()/100)*i.getAbonado()+"");
		j.getFrame().setVisible(true);
	}
	
	private void confirmarCancelacion(JustificanteCancelarInscripcion j, CursoDTO c) {
		model.actualizarEstadoInscripcion(colegiado.getDniColegiado(), 
				c.getTituloCurso(), c.getFechaCurso(), "Cancelado");
		j.getFrame().dispose();
		getTablaCursosSolicitados();
	}

	private boolean comprobarCancelable(CursoDTO c) {
		if(c.isCancelable()) {
			return true;
		}
		SwingUtil.showInformationDialog("El curso no permite cancelaciones");
		return false;
	}

	/**
	 * Método para comprobar la validez de la fecha de cancelación
	 * @param c curso de la inscripción
	 * @return valida o no
	 */
	private boolean comprobarFechaCurso(CursoDTO c) {
		if(c.getEstadoc()=="Cerrada") {
			SwingUtil.showInformationDialog("El curso ya ha finalizado");
			return false;
		}
		else if(LocalDate.now().isAfter(LocalDate.parse(c.getFechaCurso()))) {
			SwingUtil.showInformationDialog("El curso ya ha empezado");
			return false;
		}
		else {
			LocalDate fecha = Date.valueOf(c.getFechaCurso()).toLocalDate();
			LocalDate hoy=LocalDate.now().minusDays(7);
			if(hoy.isAfter(fecha)) {
				SwingUtil.showInformationDialog(
						"No se puede cancelar la inscripción a falta de una semana");
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Método comprobarPlazas
	 * @param curso
	 * @return true o false
	 */
	private boolean comprobarPlazas(CursoDTO curso) {
		if(curso.getNplazas()>=1) {
			return true;
		}
		SwingUtil.showInformationDialog("No quedan plazas disponibles");
		return false;
	}

	/**
	 * Método comprobarFechaInscripcion
	 * @param curso
	 * @return true o false
	 */
	private boolean comprobarFechaInscripcion(CursoDTO curso) {
		InscribeDTO i=
				model.buscarInscripcionCurso(colegiado.getDniColegiado(), 
						curso.getTituloCurso(), curso.getFechaCurso());
		 long diasTranscurridos=
				 ChronoUnit.DAYS.between(
						 Util.convertToLocalDateTimeViaInstant( 
								 Util.isoStringToDate(i.getFecha())), LocalDateTime.now());
		 if(diasTranscurridos>2) {
			 SwingUtil.showInformationDialog("Han pasado 2 dias de la fecha de inscripción");
			 return false;
		 }
		return true;
	}
}
