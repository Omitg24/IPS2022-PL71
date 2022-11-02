package inscripcionpericial.controller;

import colegiado.model.ColegiadoDTO;
import inscripcion.view.IdentificadorView;
import inscripcionpericial.model.InscripcionPericialModel;
import inscripcionpericial.view.InscripcionPericialView;
import ui_events.ChangeColor;
import util.SwingUtil;

public class InscripcionPericialController {
	
	private InscripcionPericialModel model;
	private InscripcionPericialView view;
	private IdentificadorView viewId;
	private String dni;
	
	
	public InscripcionPericialController(InscripcionPericialModel model, IdentificadorView viewId) {
		this.model = model;
		this.viewId=viewId;
		this.view = (InscripcionPericialView) viewId.getInscripcion();
	}
	
	private void initView() {
		view.getFrame().setVisible(true);
	}
	
	public void initController() {
		viewId.getTextId().addFocusListener(new ChangeColor());
		viewId.getBtnEntrar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> entrar()));
		view.getModificar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> modificarCampos()));
		view.getVerificar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> verificar()));
		
	}

	private void entrar() {
		String dni = viewId.getTextId().getText();
		if(dni.isBlank())
			SwingUtil.showErrorDialog("Introduce un identificador válido");
		else if(model.buscarColegiado(dni)==null)
			SwingUtil.showErrorDialog("No existe un colegiado con ese identificador");
		else {
			this.dni=dni;
			viewId.getFrame().dispose();
			initView();
		}
	}

	private void verificar() {

	}

	private void modificarCampos() {
		view.getTxtTelefono().addFocusListener(new ChangeColor());
		view.getTxtLocalidad().addFocusListener(new ChangeColor());
		view.getTxtTelefono().setEditable(true);
		view.getTxtLocalidad().setEditable(true);
	}
	
	private void rellenarCampos(String dni) {
		ColegiadoDTO colegiado = model.buscarColegiado(dni);
		view.getTxtNumeroCol().setText(colegiado.getNumeroColegiado());
		view.getTxtDni().setText(colegiado.getDniSol());
		view.getTxtNombre().setText(colegiado.getNombreSol());
		view.getTxtTelefono().setText(colegiado.getTelefonoSol());
		view.getTxtApellidos().setText(colegiado.getApellidoSol());
		view.getTxtLocalidad().setText(colegiado.getLocalidadSol());
	}
	

}
