package colegiado;

import colegiado.controller.ColegiadoController;
import colegiado.model.ColegiadoModel;
import colegiado.view.ColegiadoView;
import util.Database;

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
	public static void main(String[] args) {
		Database db = new Database();
		db.createDatabase(false);

		ColegiadoView view = new ColegiadoView();
		ColegiadoModel model = new ColegiadoModel();
		ColegiadoController controller = new ColegiadoController(model, view);

		controller.initController();
	}
}
