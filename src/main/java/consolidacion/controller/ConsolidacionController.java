package consolidacion.controller;

import java.util.List;

import javax.swing.table.TableModel;

import consolidacion.model.ConsolidacionModel;
import consolidacion.view.ConsolidacionView;
import curso.model.CursoDTO;
import inscritos.model.InscritoDTO;
import util.SwingUtil;

/**
 * Titulo: Clase ConsolidacionController
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 nov 2022
 */
public class ConsolidacionController {
	/**
	 * Atributo model
	 */
	private ConsolidacionModel model;
	/**
	 * Atributo view
	 */
	private ConsolidacionView view;
	
	/**
	 * Constructor ConsolidacionController
	 * @param model
	 * @param view
	 */
	public ConsolidacionController(ConsolidacionModel model, ConsolidacionView view) {
		this.model=model;
		this.view=view;
		
		this.initView();
	}
	
	/**
	 * Método initView
	 */
	public void initView() {
		loadTableCursos();
		view.getFrame().setVisible(true);
	}
	
	/**
	 * Método initController
	 */
	public void initController() {
		view.getTblCursos().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> loadTableColegiados()));
	}
	
	/**
	 * Método loadTableCursos
	 */
	private void loadTableCursos() {
		List<CursoDTO> cursos = model.getListaCursos();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos, new String[] {"tituloCurso", "fechaCurso", 
				"fechaInicioIns", "fechaFinIns", "precio", "estadoc", "nplazas"});
		view.getTblCursos().setModel(tmodel);
		String[] titulos = new String[] {"Titulo", "Fecha del Curso", 
				"Fecha de inicio de inscripción", "Fecha de fin de inscripción", 
				"Precio", "Estado", "Nº de plazas"};
		for (int i = 0; i < titulos.length; i++) {
			view.getTblCursos().getColumnModel().getColumn(i).setHeaderValue(titulos[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTblCursos());
		view.getTblCursos().getTableHeader().setReorderingAllowed(false);
		view.getTblCursos().getTableHeader().setResizingAllowed(false);
	}
	
	/**
	 * Método loadTableColegiados
	 */
	private void loadTableColegiados() {
		String tituloCurso = view.getTblCursos().getModel().getValueAt(view.getTblCursos().getSelectedRow(), 0).toString();
		String fechaCurso = view.getTblCursos().getModel().getValueAt(view.getTblCursos().getSelectedRow(), 1).toString();
		List<InscritoDTO> colegiados = model.getListaPreinscritos(tituloCurso, fechaCurso);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[] {"apellidosColegiado", "nombreColegiado", 
				"fecha", "estadoS", "abonado"});
		view.getTblColegiados().setModel(tmodel);
		String[] titulos = new String[] {"Apellidos", "Nombre", 
				"Fecha de inscripción", "Estado de la solicitud", "Importe abonado"};
		for (int i = 0; i < titulos.length; i++) {
			view.getTblColegiados().getColumnModel().getColumn(i).setHeaderValue(titulos[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTblColegiados());
		view.getTblColegiados().getTableHeader().setReorderingAllowed(false);
		view.getTblColegiados().getTableHeader().setResizingAllowed(false);
	}
}
