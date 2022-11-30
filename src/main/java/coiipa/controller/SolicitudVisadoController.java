package coiipa.controller;

import javax.swing.table.TableModel;

import coiipa.model.model.SolicitudVisadoModel;
import coiipa.view.SolicitudVisadoView;
import ui_events.ChangeColor;
import ui_events.ProccessKeyNoDigits;
import util.SwingUtil;

/**
 * 
 * Título: Clase SolicitudVisadoController
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class SolicitudVisadoController {

	private SolicitudVisadoModel model;
	private SolicitudVisadoView view;

	TableModel t;

	public SolicitudVisadoController(SolicitudVisadoModel m, SolicitudVisadoView v) {
		this.model = m;
		this.view = v;
		this.initView();
	}

	public void initController() {
		view.getBtConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> confirmar()));
		view.getTextFieldDni().addFocusListener(new ChangeColor());
		view.getTextFieldNombre().addFocusListener(new ChangeColor());
		view.getTextFieldApellido().addFocusListener(new ChangeColor());
		view.getTextFieldNombre().addKeyListener(new ProccessKeyNoDigits());
		view.getTextFieldApellido().addKeyListener(new ProccessKeyNoDigits());
	}

	private void confirmar() {
		if (comprobarCampos()) {
			String dni = view.getTextFieldDni().getText();
			if (!model.buscarPerito(dni).isEmpty()) {
				String nombre = view.getTextFieldNombre().getText();
				String apellidos = view.getTextFieldApellido().getText();
				String descripcion = view.getTextAreaDescripcion().getText();
				model.addInformePericial(dni, nombre, apellidos, descripcion);
				SwingUtil.showInformationDialog("Solicitud guardada con éxito");
			} else {
				SwingUtil.showErrorDialog("El DNI no corresponde a ningún perito inscrito");
			}
			reiniciarCampos();
		} else {
			SwingUtil.showErrorDialog("Todos los campos deben estar rellenos");
		}
	}

	public void initView() {
		view.getFrame().setVisible(true);
	}

	private boolean comprobarCampos() {
		return (!view.getTextFieldNombre().getText().isBlank() 
				&& !view.getTextFieldDni().getText().isBlank()
				&& !view.getTextFieldApellido().getText().isBlank()
				&& !view.getTextAreaDescripcion().getText().isBlank());
	}

	public void reiniciarCampos() {
		view.getTextFieldNombre().setText("");
		view.getTextFieldDni().setText("");
		view.getTextFieldApellido().setText("");
		view.getTextAreaDescripcion().setText("");
	}
}
