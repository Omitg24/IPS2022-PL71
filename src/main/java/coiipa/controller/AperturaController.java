package coiipa.controller;

import java.util.Date;

import javax.swing.table.TableModel;

import coiipa.model.model.AperturaModel;
import coiipa.view.AperturaView;
import coiipa.view.apertura.ModificacionView;
import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase AperturaController
 *
 * @author Adrián Alves Morales, UO284288 y David Warzynski Abril, UO278968
 * @version 28 nov 2022
 */
public class AperturaController {

	private AperturaModel model;
	private AperturaView view;
	private ModificacionView modificacion;

	TableModel t;

	public AperturaController(AperturaModel m, AperturaView v) {
		this.model = m;
		this.view = v;
		this.modificacion = view.getModificacion();
		// no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtModificar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> modificarCurso()));
		modificacion.getBtListo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> listo()));
		modificacion.getTextInicio().addFocusListener(new ChangeDateColor());
		modificacion.getTextFin().addFocusListener(new ChangeDateColor());
		modificacion.getTextFieldNplazas().addFocusListener(new ChangeColor());
		addCursosToList();
	}

	public void modificarCurso() {
		modificacion.reiniciarCampos();
		view.getModificacion().getFrame().setVisible(true);
	}

	public void listo() {
		String titulo = SwingUtil.getSelectedKey(view.getTableCursos());
		String fecha = SwingUtil.getSelectedKey(view.getTableCursos(),1);
		Date inicio = Util.isoStringToDate(modificacion.getTextInicio().getText());
		Date fin = Util.isoStringToDate(modificacion.getTextFin().getText());
		int nplazas = Integer.parseInt(modificacion.getTextFieldNplazas().getText());
		model.updateFechasCurso(inicio, fin, nplazas, titulo,fecha);
		modificacion.getFrame().dispose();
		modificacion.reiniciarCampos();
		addCursosToList();
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true);
	}

	public void addCursosToList() {
		t = SwingUtil.getTableModelFromPojos(model.getCursos(), new String[] { "tituloCurso", "fechaCurso", "precio",
				"fechaInicioIns", "fechaFinIns", "estadoc", "nplazas","cancelable", "porcentajeDevolucion" });
		view.getTableCursos().setModel(t);
		String[] titles = new String[] { "Título del curso", "Fecha de inicio", "Precio", "Fecha inicio ins.",
				"Fecha fin ins.", "Estado", "Nº de plazas","Cancelable","Porcentaje devolución"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableCursos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableCursos());
		view.getTableCursos().getTableHeader().setReorderingAllowed(false);
		view.getTableCursos().getTableHeader().setResizingAllowed(false);
	}
}
