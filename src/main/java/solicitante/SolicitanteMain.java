package solicitante;

import solicitante.controller.SolicitanteController;
import solicitante.model.SolicitanteModel;
import solicitante.view.SolicitanteView;
import util.Database;

/**
 * Título: Clase SolicitanteMain
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class SolicitanteMain {
	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database();
		db.createDatabase(false);

		SolicitanteView view = new SolicitanteView();
		SolicitanteModel model = new SolicitanteModel();
		SolicitanteController controller = new SolicitanteController(model, view);

		controller.initController();
	}
}
