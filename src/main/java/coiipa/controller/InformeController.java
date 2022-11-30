package coiipa.controller;

import javax.swing.JOptionPane;
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
		// no hay inicializacion especifica del modelo, solo de la vista
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
			JOptionPane.showMessageDialog(null, "Solicitud guardada con éxito", 
					"Administración COIIPA", JOptionPane.INFORMATION_MESSAGE);
			reiniciarCampos();
		}
//		else if (model.isSent(view.getTextFieldDni().getText())) {
//			JOptionPane.showMessageDialog(null, "Ya existe una solicitud hecha por el DNI introducido", 
//					"Administración COIIPA", JOptionPane.ERROR_MESSAGE);
//		}
		else {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", 
					"Administración COIIPA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
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
