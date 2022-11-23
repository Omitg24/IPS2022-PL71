package main.launchers;

import coiipa.controller.SolicitudVisadoController;
import coiipa.model.model.SolicitudVisadoModel;
import coiipa.view.SolicitudVisadoView;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class SolicitudVisadoMain {
	
	public void main(String[] args) {
		
		SolicitudVisadoView view = new SolicitudVisadoView();
		SolicitudVisadoModel model = new SolicitudVisadoModel();
		SolicitudVisadoController controller = new SolicitudVisadoController(model,view);
		
		controller.initController();
	}
}
