package coiipa.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.table.TableModel;

import coiipa.model.model.PericialesModel;
import coiipa.view.PericialesView;
import util.SwingUtil;

/**
 * Título: Clase AperturaController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class PericialesController {

	private PericialesModel model;
	private PericialesView view;

	private boolean noRealizado = false;
	private boolean realizado = false;
	private boolean anulado = false;
	private String date = "Todas";
	private String dniPerito = "";

	TableModel t;

	public PericialesController(PericialesModel m, PericialesView v) {
		this.model = m;
		this.view = v;
		// no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		// view.getBtModificar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> modificarCurso()));
		view.getSpnFecha().addChangeListener(
				e -> SwingUtil.exceptionWrapper(() -> filtrarFechas(
						(String) view.getSpnFecha().getValue())));
		view.getChckbxNoRealizado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> activarNoRealizado()));
		view.getChckbxRealizado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> activarRealizado()));
		view.getChckbxAnulado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> activarAnulado()));
		view.getTxtPerito().addKeyListener(new ProcessVisadoFilter(this));
		addPeritosToList();
		addFechasToSpinner();
	}

	private void activarNoRealizado() {
		this.noRealizado = view.getChckbxNoRealizado().isSelected();
		addPeritosToList();
	}

	private void activarRealizado() {
		this.realizado = view.getChckbxRealizado().isSelected();
		addPeritosToList();
	}

	private void activarAnulado() {
		this.anulado = view.getChckbxAnulado().isSelected();
		addPeritosToList();
	}

	private void filtrarFechas(String date) {
		this.date = date;
		addPeritosToList();
	}

	private void filtrarPorPerito(String dniPerito) {
		this.dniPerito = dniPerito;
		addPeritosToList();
	}

	private void addFechasToSpinner() {
		view.getSpnFecha().setModel(model.getFechas());
		view.getSpnFecha().getModel().setValue("Todas");
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true);
	}

	public void addPeritosToList() {
		t = SwingUtil.getTableModelFromPojos(model.getAsignacionesFiltradas(date, noRealizado, realizado, anulado, dniPerito), new String[]
				{ "dni", "nombre", "nombreColegiado", "fecha", "estado"});
		view.getTablePeritos().setModel(t);

		String[] titles = new String[] { "Dni del perito", "Nombre del perito", "Nombre del colegiado", "Fecha de asignación",
				"Estado de la asignación"};
		for (int i = 0; i < titles.length; i++) {
			view.getTablePeritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTablePeritos());
		view.getTablePeritos().getTableHeader().setReorderingAllowed(false);
		view.getTablePeritos().getTableHeader().setResizingAllowed(false);
	}

	public String getDniPerito() {
		return this.dniPerito;
	}

	public PericialesView getView() {
		return this.view;
	}

	public class ProcessVisadoFilter extends KeyAdapter {

		private PericialesController p;

		public ProcessVisadoFilter(PericialesController p) { this.p = p; }

		/**
		 * Método keyTyped
		 * @param e
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			p.filtrarPorPerito(p.getView().getTxtPerito().getText());
		}
	}
}
