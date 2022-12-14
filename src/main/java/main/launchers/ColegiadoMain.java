package main.launchers;

import coiipa.controller.ColegiadoController;
import coiipa.model.model.ColegiadoModel;
import coiipa.view.ColegiadoView;

/**
 * Título: Clase SolicitanteMain
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ColegiadoMain {
	/**
	 * Método main
	 * @param args
	 */
	public void main(String[] args) {

		ColegiadoView view = new ColegiadoView();
		ColegiadoModel model = new ColegiadoModel();
		ColegiadoController controller = new ColegiadoController(model, view);

		controller.initController();
	}
}
