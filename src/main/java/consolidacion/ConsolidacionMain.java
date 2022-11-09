package consolidacion;

import consolidacion.controller.ConsolidacionController;
import consolidacion.model.ConsolidacionModel;
import consolidacion.view.ConsolidacionView;

/**
 * Titulo: Clase ConsolodicacionMain
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class ConsolidacionMain {
	/**
	 * Método main
	 * @param args
	 */
	public void main(String[] args) {

		ConsolidacionView view = new ConsolidacionView();
		ConsolidacionModel model = new ConsolidacionModel();
		ConsolidacionController controller = new ConsolidacionController(model, view);

		controller.initController();
	}
}
