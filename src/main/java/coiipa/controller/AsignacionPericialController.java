package coiipa.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.AsignacionPericialDTO;
import coiipa.model.dto.InformeDTO;
import coiipa.model.dto.InscripcionPericialDTO;
import coiipa.model.model.AsignacionPericialModel;
import coiipa.view.AsignacionPericialView;
import coiipa.view.asignacionpericial.AnulacionView;
import util.SwingUtil;

/**
 * Título: Clase AsignacionPericialController
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 23 nov 2022
 */
public class AsignacionPericialController {
	/**
	 * Atributo model
	 */
	private AsignacionPericialModel model;
	/**
	 * Atributo view
	 */
	private AsignacionPericialView view;
	/**
	 * Atributo anulacionView
	 */
	private AnulacionView anulacionView;
	/**
	 * Atributo informes
	 */
	private List<InformeDTO> informes;
	/**
	 * Atributo id
	 */
	private String id;
	/**
	 * Atributo dniPerito
	 */
	private String dniPerito;

	/**
	 * Constructor AsignacionPericialController
	 * @param model
	 * @param view
	 */
	public AsignacionPericialController(AsignacionPericialModel model, AsignacionPericialView view) {
		this.model = model;
		this.view = view;

		this.initView();
	}

	/**
	 * Método initView
	 */
	private void initView() {
		actualizarTablas();
		view.getFrame().setVisible(true);
	}
	
	/**
	 * Método initController
	 */
	public void initController() {
		view.getAsignar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> asignar()));
		view.getAnular().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> anular()));
	}

	/**
	 * Método actualizarTablas
	 */
	private void actualizarTablas() {
		getListaPeritos();
		getListaInformes();
		getListaAsignaciones();
	}

	/**
	 * Método getListaInformes
	 */
	private void getListaInformes() {
		informes = model.getInformes();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(informes,
				new String[] { "nombre", "dni", "correo", "telefono", "descripcion", "urgencia" });
		view.getTableInformes().setModel(tmodel);

		String[] titles = new String[] { "Nombre", "DNI", "Correo", "Telefono", "Descripción", "Urgencia" };
		for (int i = 0; i < titles.length; i++) {
			view.getTableInformes().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableInformes());
		view.getTableInformes().getTableHeader().setReorderingAllowed(false);
		view.getTableInformes().getTableHeader().setResizingAllowed(false);
	}
	
	/**
	 * Método getListaPeritos
	 */
	private void getListaPeritos() {
		List<InscripcionPericialDTO> peritos = model.getPeritos();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(peritos,
				new String[] { "dniColegiado", "fechaInscripcion", 
						"posicionLista", "estadoInscripcion",
						"estadoAsignacionPericial"});
		view.getTablePeritos().setModel(tmodel);

		String[] titles = new String[] { "DNI", "Fecha Inscripción", "Turno", "Inscripción","Asignación"};
		for (int i = 0; i < titles.length; i++) {
			view.getTablePeritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTablePeritos());
		view.getTablePeritos().getTableHeader().setReorderingAllowed(false);
		view.getTablePeritos().getTableHeader().setResizingAllowed(false);
	}
	
	/**
	 * Método getListaAsignaciones
	 */
	private void getListaAsignaciones() {
		List<AsignacionPericialDTO> asignaciones = model.getAsignaciones();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(asignaciones,
				new String[] { "id", "dni", "nombre",
						"dniColegiado", "nombreColegiado", "fecha", "estado"});
		view.getTableAsignaciones().setModel(tmodel);

		String[] titles = new String[] { "Identifier", "Dni del Solicitante", "Nombre del Solicitante",
				"DNI del Perito", "Nombre del Perito", "Fecha de la asignación", "Estado de la asignación"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableAsignaciones().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableAsignaciones());
		view.getTableAsignaciones().getTableHeader().setReorderingAllowed(false);
		view.getTableAsignaciones().getTableHeader().setResizingAllowed(false);
	}

	/**
	 * Método asignar
	 */
	private void asignar() {
		if(view.getTableInformes().getSelectedRowCount()==0 
				|| view.getTablePeritos().getSelectedRowCount()==0)
			SwingUtil.showInformationDialog("Debe seleccionar un informe y un perito");
		else {
			int indexPerito= view.getTablePeritos().getSelectedRow();
			String dniPerito = (String) view.getTablePeritos().getValueAt(indexPerito, 0);
			for(int i =indexPerito;i< view.getTablePeritos().getRowCount();i++) {
				String dniPeritoAnterior = (String) view.getTablePeritos().getValueAt(i, 0);
				model.actualizarTurnoAnt(dniPeritoAnterior);
			}
			
			int indexInforme= view.getTableInformes().getSelectedRow();
			String dniInforme = (String) view.getTableInformes().getValueAt(indexInforme, 1);
			String id = informes.get(indexInforme).getId();
			
			model.asignarInforme(dniPerito, id);
			model.asignarPerito(dniPerito);
			model.actualizarTurno(dniPerito);
			actualizarTablas();
			SwingUtil.showInformationDialog(
					"Se ha asignado el informe "+id+", \ncon dni/cif: "+ dniInforme + " al perito con dni: "+ dniPerito);
		}
	}
	
	/**
	 * Método anular
	 */
	private void anular() {
		if (view.getTableAsignaciones().getSelectedRowCount() == 0) {
			SwingUtil.showErrorDialog("Debe seleccionar una asignación a anular");
		} else {
			this.id = view.getTableAsignaciones().getModel().getValueAt(view.getTableAsignaciones().getSelectedRow(), 0).toString();
			this.dniPerito = view.getTableAsignaciones().getModel().getValueAt(view.getTableAsignaciones().getSelectedRow(), 3).toString();
			anulacionView = new AnulacionView(this);
			anulacionView.setLocationRelativeTo(null);
			anulacionView.setVisible(true);
		}		
	}

	/**
	 * Método anularAsignacion
	 * @param motivo
	 */
	public void anularAsignacion(String motivo) {		
		model.anularAsignacion(String.valueOf(new Timestamp(System.currentTimeMillis()).getTime()), motivo, id);
		model.anularPerito(dniPerito);
		SwingUtil.showInformationDialog("Se ha anulado la asignación del perito al informe\nEl motivo de dicha cancelación es el siguiente:\n" + motivo);
		actualizarTablas();
		anulacionView.dispose();		
	}
}