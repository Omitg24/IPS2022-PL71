package coiipa.controller;

import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.InformeDTO;
import coiipa.model.dto.InscripcionPericialDTO;
import coiipa.model.dto.SolicitudPericialDTO;
import coiipa.model.model.AsignacionPericialModel;
import coiipa.view.AsignacionPericialView;
import util.SwingUtil;

/**
 * Título: Clase AsignacionPericialController
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 23 nov 2022
 */
public class AsignacionPericialController {

	private AsignacionPericialModel model;
	private AsignacionPericialView view;

	public AsignacionPericialController(AsignacionPericialModel model, AsignacionPericialView view) {
		this.model = model;
		this.view = view;

		this.initView();
	}

	private void initView() {
		actualizarTablas();
		view.getFrame().setVisible(true);

	}

	private void actualizarTablas() {
		getListaPeritos();
		getListaInformes();
		getListaAsignaciones();
	}

	private void getListaInformes() {
		List<InformeDTO> informes = model.getInformes();
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
	
	private void getListaPeritos() {
		List<InscripcionPericialDTO> peritos = model.getPeritos();
		peritos.addAll(model.getPeritosAsignados());
		TableModel tmodel = SwingUtil.getTableModelFromPojos(peritos,
				new String[] { "dniColegiado", "fechaInscripcion", "posicionLista", "estadoInscripcion","estadoAsignacionPericial"});
		view.getTablePeritos().setModel(tmodel);

		String[] titles = new String[] { "DNI", "Fecha Inscripción", "Turno", "Inscripción","Asignación"};
		for (int i = 0; i < titles.length; i++) {
			view.getTablePeritos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTablePeritos());
		view.getTablePeritos().getTableHeader().setReorderingAllowed(false);
		view.getTablePeritos().getTableHeader().setResizingAllowed(false);
	}
	
	private void getListaAsignaciones() {
		List<SolicitudPericialDTO> asignaciones = model.getAsignaciones();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(asignaciones,
				new String[] { "id", "dni", "fecha", "estado"});
		view.getTableAsignaciones().setModel(tmodel);

		String[] titles = new String[] { "Identifier", "DNI", "Fecha", "Estado"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableAsignaciones().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableAsignaciones());
		view.getTableAsignaciones().getTableHeader().setReorderingAllowed(false);
		view.getTableAsignaciones().getTableHeader().setResizingAllowed(false);
	}

	public void initController() {
		view.getAsignar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> asignar()));

	}

	private void asignar() {
		if(view.getTableInformes().getSelectedRowCount()==0 
				|| view.getTablePeritos().getSelectedRowCount()==0)
			SwingUtil.showErrorDialog("Debe seleccionar un informe y un perito");
		else {
			int indexPerito= view.getTablePeritos().getSelectedRow();
			String dniPerito = (String) view.getTablePeritos().getValueAt(indexPerito, 0);
			for(int i =indexPerito;i< view.getTablePeritos().getRowCount();i++) {
				String dniPeritoAnterior = (String) view.getTablePeritos().getValueAt(i, 0);
				model.actualizarTurnoAnt(dniPeritoAnterior);
			}
			
			int indexInforme= view.getTableInformes().getSelectedRow();
			String dniInforme = (String) view.getTableInformes().getValueAt(indexInforme, 1);
			String nombre = (String) view.getTableInformes().getValueAt(indexInforme, 0);
			
			model.asignarInforme(dniPerito, nombre);
			model.asignarPerito(dniPerito);
			model.actualizarTurno(dniPerito);
			actualizarTablas();
			SwingUtil.showInformationDialog(
					"Se ha asignado el informe de "+nombre+", \ncon dni/cif: "+ dniInforme + " al perito con dni: "+ dniPerito);
		}
	}
	
	private void anular() {
		if (view.getTableAsignaciones().getSelectedRowCount() == 0) {
			SwingUtil.showErrorDialog("Debe seleccionar una asignación a anular");
		}
		
	}

}
