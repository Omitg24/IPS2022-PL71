package inscripcion.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

import colegiado.model.ColegiadoDTO;
import curso.model.CursoDTO;
import inscripcion.model.InscribeDTO;
import inscripcion.model.InscripcionModel;
import inscripcion.view.EmisionView;
import inscripcion.view.IdentificadorView;
import inscripcion.view.InscripcionView;
import inscripcion.view.TarjetaView;
import ui_events.ChangeColor;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase InscripcionController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionController {

	private InscripcionModel model;
	private IdentificadorView viewId;
	private InscripcionView view;
	private EmisionView emision;
	private TarjetaView tarjetaView;
	private ColegiadoDTO colegiado;
	private CursoDTO curso;

	TableModel t;

	public InscripcionController(InscripcionModel m, IdentificadorView v) {
		this.model = m;
		this.viewId = v;
		this.view = (InscripcionView) viewId.getInscripcion();
		this.emision = view.getEmision();

		this.initView();
	}

	public void initController() {
		viewId.getTextId().addFocusListener(new ChangeColor());
		viewId.getBtnEntrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> entrar()));
		view.getBtInscribirse().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirse()));
		emision.getBtnConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarEmision()));
		view.getBtTarjeta().addActionListener(e -> SwingUtil.exceptionWrapper(() -> abrirPagoTarjeta()));
		view.getBtTransferencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> confirmarPago("Transferencia")));
		view.getTablePreinscritos().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> activarPagos(e)));
		addCursosToList();
	}

	private void activarPagos(ListSelectionEvent e) {
		view.getBtTarjeta().setEnabled(true);
		view.getBtTransferencia().setEnabled(true);
	}

	private void abrirPagoTarjeta() {
		tarjetaView= new TarjetaView(this);
		tarjetaView.setLocationRelativeTo(null);
		tarjetaView.setVisible(true);
	}

	private void getListaPreInscritos() {
		List<CursoDTO> preinscritos = model.buscarCursoPorInscrito(colegiado.getDniColegiado());
		TableModel tmodel = SwingUtil.getTableModelFromPojos(preinscritos, 
				new String[] {"tituloCurso", "fechaCurso", "precio"});
		view.getTablePreinscritos().setModel(tmodel);
		String[] titles = new String[] { "                  Título del curso                  ", "      Fecha de inicio      ", "  Precio  "};
		for (int i = 0; i < titles.length; i++) {
			view.getTablePreinscritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTablePreinscritos());
		view.getTablePreinscritos().getTableHeader().setReorderingAllowed(false);
		view.getTablePreinscritos().getTableHeader().setResizingAllowed(false);
		
	}

	public void entrar() {
		if (comprobarId(viewId.getTextId().getText())) {
			colegiado = model.getSolicitanteFromKey(viewId.getTextId().getText());
			getListaPreInscritos();
			viewId.getFrame().setVisible(false);
			view.getFrame().setVisible(true);
		}
		else {
			SwingUtil.showErrorDialog("El identificador introducido no es válido");
			viewId.getTextId().setText("");
		}
	}

	public void inscribirse() {
		String key = SwingUtil.getSelectedKey(view.getTableCursos());
		curso = model.getCursoFromKey(key);
		try {
			model.insertarInscribe(curso, colegiado);
			crearEmision();
			getListaPreInscritos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SwingUtil.showErrorDialog("Ya ha presentado una solicitud para este curso");
		}
	}

	public void initView() {
		viewId.getFrame().setVisible(true);
	}

	public void cerrarEmision() {
		emision.getFrame().setVisible(false);
	}

	public void addCursosToList() {
		t = SwingUtil.getTableModelFromPojos(model.getCursosAbiertos(), new String[] { "tituloCurso", "fechaCurso", "precio"});
		view.getTableCursos().setModel(t);
		String[] titles = new String[] { "                  Título del curso                  ", "      Fecha de inicio      ", "  Precio  "};
		for (int i = 0; i < titles.length; i++) {
			view.getTableCursos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableCursos());
		view.getTableCursos().getTableHeader().setReorderingAllowed(false);
		view.getTableCursos().getTableHeader().setResizingAllowed(false);
	}

	public boolean comprobarId(String s) {
		if (model.getSolicitanteFromKey(s) == null) return false;
		return true;
	}

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

	public void confirmarPago(String tipoPago) {
		String titulo = SwingUtil.getSelectedKey(view.getTablePreinscritos());
		String fecha = SwingUtil.getSelectedKey(view.getTablePreinscritos(),1);
		System.out.println(titulo+"\n"+fecha);
		CursoDTO c = model.getCursoFromKey(titulo, fecha);
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
			getListaPreInscritos();
			SwingUtil.showInformationDialog("Se ha registrado el pago del curso: "
						+ c.getTituloCurso()+", con fecha de inicio: "+
					c.getFechaCurso());
		}
	}

	private boolean comprobarPlazas(CursoDTO curso) {
		if(curso.getNplazas()>=1)
			return true;
		return false;
	}

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
