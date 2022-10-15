package emision;

import emision.controller.EmisionController;
import emision.model.EmisionModel;
import emision.view.EmisionView;
import util.Database;

/**
 * Titulo: Clase EmisionMain
 *
 * @author Omar Teixeira González, UO281847
 * @version 15 oct 2022
 */
public class EmisionMain {
	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		EmisionView view = new EmisionView();
		EmisionModel model = new EmisionModel();
		EmisionController controller = new EmisionController(model, view);
		
		controller.initController();
	}	
}
