package coiipa.controller;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.table.TableModel;

import coiipa.model.dto.InscritoDTO;
import coiipa.model.model.InscritosModel;
import coiipa.view.InscritosView;
import util.SwingUtil;

/**
 * 
 * Título: Clase InscritosController
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritosController {
	
	
	private InscritosModel model;
	private InscritosView view;

	public InscritosController(InscritosModel model, InscritosView view) {
		this.model=model;
		this.view=view;
		
		this.initView();
	}

	public void initController() {
		view.getComboBoxCursos().addActionListener(
				e ->SwingUtil.exceptionWrapper(()-> getListaInscritos()));
		
	}
	
	private void getListaInscritos() {
		String titulo = view.getComboBoxCursos().getSelectedItem().toString();
		List<InscritoDTO> inscritos = model.getListaInscrito(titulo);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(inscritos, 
				new String[] {"apellidosColegiado","nombreColegiado","fecha","estadoS","abonado"});
		view.getTableInscritos().setModel(tmodel);
		String[] titles = new String[] { "Apellidos", "Nombre", "Fecha", "Situacion",
				"Abonado"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableInscritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableInscritos());
		view.getTableInscritos().getTableHeader().setReorderingAllowed(false);
		view.getTableInscritos().getTableHeader().setResizingAllowed(false);
		
		actualizarTotal();
	}
	
	private void actualizarTotal() {
		double total=0;
		for(int i =0; i< view.getTableInscritos().getRowCount();i++) {
			total+=Double.parseDouble(view.getTableInscritos().getValueAt(i, 4).toString());
		}
		view.getTotal().setText(total + " €");
	}
	
	private void setListaCursos() {
		List<Object[]> cursos = model.getListaCursos();
		ComboBoxModel<Object> cmodel= SwingUtil.getComboModelFromList(cursos);
		view.getComboBoxCursos().setModel(cmodel);
	}
	
	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		this.setListaCursos();
		this.getListaInscritos();
		actualizarTotal();
		view.getFrame().setVisible(true);
	}

}
