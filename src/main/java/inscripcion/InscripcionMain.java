package inscripcion;

import inscripcion.controller.InscripcionController;
import inscripcion.model.InscripcionModel;
import inscripcion.view.IdentificadorView;
import util.Database;

/**
 * Título: Clase InscripcionMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionMain {
	
	public static void main(String[] args) {
	
		Database db=new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		IdentificadorView view = new IdentificadorView();
		InscripcionModel model = new InscripcionModel();
		System.out.println(model.getCursosAbiertos());
		InscripcionController controller = new InscripcionController(model,view);
		
		view.getFrame().setVisible(true);
		
		controller.initController();
	}
}
