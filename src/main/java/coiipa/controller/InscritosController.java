package coiipa.controller;

import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.CursoDTO;
import coiipa.model.dto.InscritoDTO;
import coiipa.model.model.InscritosModel;
import coiipa.view.InscritosView;
import util.SwingUtil;

/**
 * Título: Clase InscritosController
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 26 nov 2022
 */
public class InscritosController {	
	/**
	 * Atributo model
	 */
	private InscritosModel model;
	/**
	 * Atributo view
	 */
	private InscritosView view;

	/**
	 * Constructor con parámetros
	 * @param model
	 * @param view
	 */
	public InscritosController(InscritosModel model, InscritosView view) {
		this.model=model;
		this.view=view;
		
		this.initView();
	}

	/**
	 * Método initView
	 */
	public void initView() {
		this.getListaCursos();
		actualizarTotal();
		view.getFrame().setVisible(true);
	}
	
	/**
	 * Método initController
	 */
	public void initController() {
		view.getTableCursos().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> getListaInscritos()));
		view.getTableCursos().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> getListaEspera()));
	}
	
	/**
	 * Método getListaCursos
	 */
	private void getListaCursos() {
		List<CursoDTO> cursos = model.getListaCursos();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos, 
				new String[] {"tituloCurso", "fechaCurso", 
						"fechaInicioIns", "fechaFinIns", 
						"precio", "estadoc", "nplazas", "ninscritos"});
		view.getTableCursos().setModel(tmodel);
		String[] titles = new String[] {"Titulo", "Fecha", 
				"Fecha de inicio de inscripción", 
				"Fecha de fin de inscripción",
				"Precio", "Estado del curso", "Nº de plazas", "Nº de inscritos"};
		
		for (int i = 0; i < titles.length; i++) {
			view.getTableCursos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableCursos());
		view.getTableCursos().getTableHeader().setReorderingAllowed(false);
		view.getTableCursos().getTableHeader().setResizingAllowed(false);
	}
	
	/**
	 * Método getListaInscritos
	 */
	private void getListaInscritos() {
		String titulo = view.getTableCursos().getModel().getValueAt(view.getTableCursos().getSelectedRow(), 0).toString();
		String fecha = view.getTableCursos().getModel().getValueAt(view.getTableCursos().getSelectedRow(), 1).toString();
		List<InscritoDTO> inscritos = model.getListaInscritos(titulo, fecha);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(inscritos, 
				new String[] {"apellidosColegiado","nombreColegiado","fecha","estadoS","abonado"});
		view.getTableInscritos().setModel(tmodel);
		String[] titles = new String[] { "Apellidos", "Nombre", "Fecha de inscripción", 
				"Estado de la inscripción", "Cantidad abonada"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableInscritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableInscritos());
		view.getTableInscritos().getTableHeader().setReorderingAllowed(false);
		view.getTableInscritos().getTableHeader().setResizingAllowed(false);
		
		actualizarTotal();
	}
	
	/**
	 * Método getListaEspera
	 */
	private void getListaEspera() {
		String titulo = view.getTableCursos().getModel().getValueAt(view.getTableCursos().getSelectedRow(), 0).toString();
		String fecha = view.getTableCursos().getModel().getValueAt(view.getTableCursos().getSelectedRow(), 1).toString();
		List<InscritoDTO> espera = model.getListaEspera(titulo, fecha);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(espera, 
				new String[] {"apellidosColegiado", "nombreColegiado", "fecha", "estadoS", "posicionEspera"});
		view.getTableEspera().setModel(tmodel);
		String[] titles = new String[] { "Apellidos", "Nombre", "Fecha de inscripción",
				"Estado de la inscripción", "Posición en la lista"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableEspera().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableInscritos());
		view.getTableEspera().getTableHeader().setReorderingAllowed(false);
		view.getTableEspera().getTableHeader().setResizingAllowed(false);
	}
	
	/**
	 * Método actualizarTotal
	 */
	private void actualizarTotal() {
		double total=0;
		for(int i =0; i< view.getTableInscritos().getRowCount();i++) {
			total+=Double.parseDouble(view.getTableInscritos().getValueAt(i, 4).toString());
		}
		view.getTotal().setText(total + " €");
	}
}
