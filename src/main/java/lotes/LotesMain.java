package lotes;

import lotes.controller.LotesController;
import lotes.model.LotesModel;
import lotes.view.LotesView;
import util.Database;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class LotesMain {
	
	public static void main(String[] args) {
		
		LotesView view = new LotesView();
		LotesModel model = new LotesModel();
		LotesController controller = new LotesController(model,view);
		
		Database db=new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		view.getFrame().setVisible(true);
		
		controller.initController();
	}
}
