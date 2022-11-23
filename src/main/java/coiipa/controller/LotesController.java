package coiipa.controller;

import java.awt.Color;
import java.time.LocalDate;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

import coiipa.model.dto.ColegiadoDTO;
import coiipa.model.model.LotesModel;
import coiipa.view.LotesView;
import util.LotesUtil;
import util.SwingUtil;

/**
 * Título: Clase AperturaController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class LotesController {

	private LotesModel model;
	private LotesView view;
	
	private final static Set<String> validValues = Set.of("licenciado en informática", "titulado en informática", "máster en ingeniería informática");

	TableModel t;

	public LotesController(LotesModel model2, LotesView view2) {
		this.model = model2;
		this.view = view2;
		// no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtEnviar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> enviarSolicitud()));
		view.getTableColegiados().getSelectionModel().addListSelectionListener(
				e -> SwingUtil.exceptionWrapper(() -> mostrarTitulacion(e)));
		addSolicitudesToList();
	}

	public void enviarSolicitud() {
		int index = view.getTableColegiados().getSelectedRow();
		ColegiadoDTO col = model.getColegiados().get(index);
		if (validValues.contains(col.getTitulacionColegiado())) {
			if (!model.isSent(col.getDniColegiado())) {
				LotesUtil.sendToBatchFile(LotesModel.BATCH_PATH, col, calcularProximoNum(col));
				JOptionPane.showMessageDialog(null, "Solicitud enviada con exito", 
						"Administración COIIPA", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya se ha enviado esta solicitud", 
						"Administración COIIPA", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			if (model.findByDni(col.getDniColegiado())) {
				model.insertAsInvalid(col);
				JOptionPane.showMessageDialog(null, "Guardado colegiado con estado anulado", 
						"Administración COIIPA", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Este colegiado ya ha sido guardado", 
						"Administración COIIPA", JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	
	private String calcularProximoNum(ColegiadoDTO dto) {
		String result = "" + LocalDate.now().getYear();
		return  result + "-" + model.getLargestNumColegiado();
	}
	
	public void mostrarTitulacion(ListSelectionEvent e) {
		view.getBtEnviar().setEnabled(true);
		int index = view.getTableColegiados().getSelectedRow();
		String text = model.getColegiados().get(index).getTitulacionColegiado();
				
		view.getTextFieldTitulacion().setText(text);
		if (validValues.contains(text)) {
			view.getTextFieldTitulacion().setForeground(Color.WHITE);
			view.getTextFieldTitulacion().setBackground(Color.decode("#008000"));
		}
		else {
			view.getTextFieldTitulacion().setForeground(Color.BLACK);
			view.getTextFieldTitulacion().setBackground(Color.WHITE);
		}
	}

	public void listo() {
		addSolicitudesToList();
	}

	public void initView() {
		// Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true);
	}

	public void addSolicitudesToList() {
		t = SwingUtil.getTableModelFromPojos(model.getColegiados(), new String[] { "nombreColegiado", "apellidosColegiado", "dniColegiado" });
		view.getTableColegiados().setModel(t);
		String[] titles = new String[] { "Nombre", "Apellidos", "Dni" };
		for (int i = 0; i < titles.length; i++) {
			view.getTableColegiados().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableColegiados());
		view.getTableColegiados().getTableHeader().setReorderingAllowed(false);
		view.getTableColegiados().getTableHeader().setResizingAllowed(false);
	}
}
