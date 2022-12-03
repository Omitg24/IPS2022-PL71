package coiipa.controller;

import java.util.Calendar;
import java.util.Date;

import coiipa.model.model.CursoModel;
import coiipa.view.CursoView;
import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import util.SwingUtil;
import util.Util;

public class CursoController {

	private CursoModel model;
	private CursoView view;

	public CursoController(CursoModel m, CursoView v) {
		this.model = m;
		this.view = v;
		// no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtAddCurso().addActionListener(e -> SwingUtil.exceptionWrapper(() -> planificarCurso()));
		view.getTxtFecha().addFocusListener(new ChangeDateColor());
		view.getTxtTitulo().addFocusListener(new ChangeColor());
		view.getTxtPrecio().addFocusListener(new ChangeColor());
		view.getTxtDevolucion().addFocusListener(new ChangeColor());
	}

	private void planificarCurso() {
		if (comprobarCampo(view.getTitulo()) || comprobarCampo(view.getFecha()) || comprobarCampo(view.getPrecio())) {
			SwingUtil.showErrorDialog("Los campos no pueden estar vacios");
		} else if (comprobarPrecio()) {
			SwingUtil.showErrorDialog("Formato de precio no valido");
			view.getTxtPrecio().setText("");
		} else if (comprobarFecha()){
			SwingUtil.showErrorDialog("La fecha no puede ser anterior");
		}else if (comprobarTitulo(view.getTitulo())){
			view.reiniciarCampos();
			SwingUtil.showErrorDialog("El curso ya existe");
		}else if ( view.getCancelable() && comprobarDevolucion()) {
			SwingUtil.showErrorDialog("Porcentaje de devolución no válido");
			}else {
			String titulo = view.getTitulo();
			Date fecha = Util.isoStringToDate(view.getFecha());
			double precio = Double.parseDouble(view.getPrecio());
			boolean cancelable = false;
			double porcentaje=0;
			if(view.getCancelable()) {
				cancelable = true;
				porcentaje = Double.parseDouble(view.getDevoculicion());
			}
			model.planificarCurso(titulo, fecha, precio,cancelable,porcentaje);
			view.reiniciarCampos();
			String str= "'" + titulo+ "'";
			SwingUtil.showInformationDialog("El curso " +str+" se ha añadido correctamente");
		}
	}

	private boolean comprobarDevolucion() {
		try {
			double d =Double.parseDouble(view.getDevoculicion());
			if(d<0 || d>100) return true;
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private boolean comprobarFecha() {
		Date introduce = Util.isoStringToDate(view.getFecha());
		Date actual = Calendar.getInstance().getTime();
		return introduce.before(actual);
	}

	private boolean comprobarTitulo(String titulo) {
		return !model.buscarCursoPorTitulo(titulo).isEmpty();
	}

	private boolean comprobarPrecio() {
		try {
			Double.parseDouble(view.getPrecio());
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private boolean comprobarCampo(String cadena) {
		if (cadena == null || cadena.isBlank() || cadena.equals(ChangeDateColor.DATE))
			return true;
		return false;
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true);
	}

}
