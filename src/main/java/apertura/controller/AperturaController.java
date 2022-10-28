package apertura.controller;

import java.util.Date;

import javax.swing.table.TableModel;

import apertura.model.AperturaModel;
import apertura.view.AperturaView;
import apertura.view.ModificacionView;
import ui_events.ChangeDateColor;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase AperturaController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
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
		addCursosToList();
	}

	public void modificarCurso() {
		view.getModificacion().getFrame().setVisible(true);
	}

	public void listo() {
		String key = SwingUtil.getSelectedKey(view.getTableCursos());
		// System.out.println(key);
		Date inicio = Util.isoStringToDate(modificacion.getTextInicio().getText());
		// System.out.println(inicio);
		Date fin = Util.isoStringToDate(modificacion.getTextFin().getText());
		int nplazas = Integer.parseInt(modificacion.getTextFieldNplazas().getText());
		// System.out.println(fin);
		model.updateFechasCurso(inicio, fin, nplazas, key);
		modificacion.getFrame().setVisible(false);
		// System.out.println(model.getCursos());
		addCursosToList();
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true);
	}

	public void addCursosToList() {
		t = SwingUtil.getTableModelFromPojos(model.getCursos(), new String[] { "tituloCurso", "fechaCurso", "precio",
				"fechaInicioIns", "fechaFinIns", "estadoc", "nplazas" });
		view.getTableCursos().setModel(t);
		String[] titles = new String[] { "Título del curso", "Fecha de inicio", "Precio", "Fecha inicio ins.",
				"Fecha fin ins.", "Estado", "Nº de plazas" };
		for (int i = 0; i < titles.length; i++) {
			view.getTableCursos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableCursos());
		view.getTableCursos().getTableHeader().setReorderingAllowed(false);
		view.getTableCursos().getTableHeader().setResizingAllowed(false);
	}
}
