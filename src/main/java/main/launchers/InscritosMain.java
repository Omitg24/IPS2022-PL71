package main.launchers;

import coiipa.controller.InscritosController;
import coiipa.model.model.InscritosModel;
import coiipa.view.InscritosView;

/**
 * 
 * Título: Clase InscritosMain
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritosMain {
	public void main(String[] args) {

		InscritosView view = new InscritosView();
		InscritosModel model = new InscritosModel();
		InscritosController controller = new InscritosController(model, view);

		controller.initController();
	}
}
