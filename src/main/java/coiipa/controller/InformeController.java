package coiipa.controller;

import javax.swing.table.TableModel;

import coiipa.model.model.InformeModel;
import coiipa.view.InformeView;
import util.SwingUtil;

/**
 * Título: Clase AperturaController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InformeController {

	private InformeModel model;
	private InformeView view;

	TableModel t;

	public InformeController(InformeModel m, InformeView v) {
		this.model = m;
		this.view = v;
		this.initView();
	}

	public void initController() {
		view.getBtConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> confirmar()));
	}

	private void confirmar() {
		if (!view.getTextFieldNombre().getText().isBlank() &&
			!view.getTextFieldDni().getText().isBlank() &&
			!view.getTextFieldTelefono().getText().isBlank() &&
			!view.getTextFieldCorreo().getText().isBlank() &&
			!view.getTextAreaDescripcion().getText().isBlank()) {
			model.addInformePericial(view.getTextFieldNombre().getText()
					, view.getTextFieldTelefono().getText()
					, view.getTextFieldCorreo().getText()
					, view.getTextFieldDni().getText()
					, view.getTextAreaDescripcion().getText()
					, view.getRdbtnNormal().isSelected());
			SwingUtil.showInformationDialog("Solicitud guardada con éxito");
			reiniciarCampos();
		}
		else {
			SwingUtil.showInformationDialog("Todos los campos deben estar rellenos");
		}
	}

	public void initView() {	
		view.getFrame().setVisible(true);
	}
	
	public void reiniciarCampos() {
		view.getTextFieldNombre().setText("");
		view.getTextFieldDni().setText("");
		view.getTextFieldTelefono().setText("");
		view.getTextFieldCorreo().setText("");
		view.getTextAreaDescripcion().setText("");
	}
}
