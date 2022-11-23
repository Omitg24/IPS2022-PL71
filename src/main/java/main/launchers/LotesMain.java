package main.launchers;

import coiipa.controller.LotesController;
import coiipa.model.model.LotesModel;
import coiipa.view.LotesView;
import util.Database;

/**
 * Título: Clase LotesMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class LotesMain {
	
	public void main(String[] args) {
		
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
