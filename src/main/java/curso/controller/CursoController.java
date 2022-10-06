package curso.controller;

import java.util.Date;

import curso.model.CursoModel;
import curso.view.CursoView;
import util.SwingUtil;
import util.Util;

public class CursoController {
	
	private CursoModel model;
	private CursoView view;
	
	
	public CursoController(CursoModel m, CursoView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	public void initController() {
		view.getBtAddCurso().addActionListener(e -> 
		SwingUtil.exceptionWrapper(()-> planificarCurso()));
		view.getTxtFecha().addFocusListener(new CambiarColorFecha());
		view.getTxtTitulo().addFocusListener(new CambiarColor());
		view.getTxtPrecio().addFocusListener(new CambiarColor());
	}
	
	private void planificarCurso() {
		if(comprobarCampo(view.getTitulo()) || comprobarCampo(view.getFecha())
				|| comprobarCampo(view.getPrecio())) {
				view.mostrarDialogo("Los campos no pueden estar vacios");
		}else if (comprobarPrecio()){
			view.mostrarDialogo("Formato de precio no valido");	
			view.getTxtPrecio().setText("");
		}else {
			String titulo = view.getTitulo();
			Date fecha = Util.isoStringToDate(view.getFecha()) ;
			double precio = Double.parseDouble(view.getPrecio());
			model.planificarCurso(titulo,fecha,precio);
			view.reiniciarCampos();
			view.mostrarDialogo("Curso "+titulo+" añadido correctamente");
		}
	}

	private boolean comprobarPrecio() {
		try {
			Double.parseDouble(view.getPrecio());
			return false;
		}catch(NumberFormatException e) {
			return true;
		}
	}

	private boolean comprobarCampo(String cadena) {
		if(cadena==null || cadena.isBlank() || cadena.equals(CambiarColorFecha.DATE))
			return true;
		return false;
	}

	public void initView() {
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}

}