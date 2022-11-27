package main.launchers;

import coiipa.controller.PericialesController;
import coiipa.model.model.PericialesModel;
import coiipa.view.PericialesView;

/**
 * Título: Clase PericialesMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 18 nov 2022
 */
public class PericialesMain {
	public void main(String[] args) {

		PericialesView view = new PericialesView();
		PericialesModel model = new PericialesModel();

		PericialesController controller = new PericialesController(model,view);

		controller.initController();
	}
}
