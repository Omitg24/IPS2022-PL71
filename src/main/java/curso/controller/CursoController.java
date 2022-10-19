package curso.controller;

import java.util.Date;

import curso.model.CursoModel;
import curso.view.CursoView;
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
	}

	private void planificarCurso() {
		if (comprobarCampo(view.getTitulo()) || comprobarCampo(view.getFecha()) || comprobarCampo(view.getPrecio())) {
			SwingUtil.showErrorDialog("Los campos no pueden estar vacios");
		} else if (comprobarPrecio()) {
			SwingUtil.showErrorDialog("Formato de precio no valido");
			view.getTxtPrecio().setText("");
		} else if (comprobarTitulo(view.getTitulo())){
			view.reiniciarCampos();
			SwingUtil.showErrorDialog("El curso ya existe");
		}else {
			String titulo = view.getTitulo();
			Date fecha = Util.isoStringToDate(view.getFecha());
			double precio = Double.parseDouble(view.getPrecio());
			model.planificarCurso(titulo, fecha, precio);
			view.reiniciarCampos();
			SwingUtil.showInformationDialog("Curso " + titulo + " añadido correctamente");
		}
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
