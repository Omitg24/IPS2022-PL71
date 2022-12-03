package coiipa.controller;

import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.InscripcionPericialDTO;
import coiipa.model.dto.SolicitudVisadoDTO;
import coiipa.model.model.AsignacionPericialModel;
import coiipa.model.model.AsignacionVisadorModel;
import coiipa.view.AsignacionVisadorView;
import util.SwingUtil;

/**
 * Título: Clase AsignacionVisador
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class AsignacionVisadorController {

	private AsignacionVisadorModel model;
	private AsignacionVisadorView view;
	List<SolicitudVisadoDTO> informes;

	public AsignacionVisadorController(AsignacionVisadorModel model, AsignacionVisadorView view) {
		this.model = model;
		this.view = view;

		this.initView();
	}

	private void initView() {
		actualizarTablas();
		view.getFrame().setVisible(true);

	}

	private void actualizarTablas() {
		getListaVisadores();
		getListaSolicitudes();
	}

	private void getListaSolicitudes() {
		informes = model.getSolicitudes();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(informes,
				new String[] { "dni", "nombre", "apellidos", "descripcion","estado" });
		view.getTableVisados().setModel(tmodel);

		String[] titles = new String[] { "DNI", "Nombre", "Apellidos", "Descripcion","Estado" };
		for (int i = 0; i < titles.length; i++) {
			view.getTableVisados().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableVisados());
		view.getTableVisados().getTableHeader().setReorderingAllowed(false);
		view.getTableVisados().getTableHeader().setResizingAllowed(false);

	}

	private void getListaVisadores() {
		List<InscripcionPericialDTO> peritos = new AsignacionPericialModel().getVisadores();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(peritos,
				new String[] { "dniColegiado", "fechaInscripcion", 
						"posicionListaVisado","estadoAsignacionVisado"});
		view.getTableVisadores().setModel(tmodel);

		String[] titles = new String[] { "DNI", "Fecha Inscripción", "Turno","Asignación"};
		for (int i = 0; i < titles.length; i++) {
			view.getTableVisadores().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableVisadores());
		view.getTableVisadores().getTableHeader().setReorderingAllowed(false);
		view.getTableVisadores().getTableHeader().setResizingAllowed(false);

	}

	public void initController() {
		view.getAsignar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> asignar()));

	}

	private void asignar() {
		if (view.getTableVisados().getSelectedRowCount() == 0 || view.getTableVisadores().getSelectedRowCount() == 0)
			SwingUtil.showInformationDialog("Debe seleccionar un visador y una solicitud");
		else {
			int indexVisador = view.getTableVisadores().getSelectedRow();
			if(((String) view.getTableVisadores().getValueAt(indexVisador, 3)).equals("Asignado")) {
				SwingUtil.showErrorDialog("El perito ya tiene una solicitud asignada");
				return;
			}
			int indexSol = view.getTableVisados().getSelectedRow();
			if(((String) view.getTableVisados().getValueAt(indexSol, 4)).equals("Asignada")) {
				SwingUtil.showErrorDialog("La solicitud ya está asignada");
				return;
			}
			String dniVisador = (String) view.getTableVisadores().getValueAt(indexVisador, 0);
			for(int i =indexVisador;i< view.getTableVisadores().getRowCount();i++) {
				String dniPeritoAnterior = (String) view.getTableVisadores().getValueAt(i, 0);
				new AsignacionPericialModel().actualizarTurnoVisadoAnt(dniPeritoAnterior);
			}
			int indexSolicitud = view.getTableVisados().getSelectedRow();
			String dniVisado = (String) view.getTableVisados().getValueAt(indexSolicitud, 0);
			String id = informes.get(indexSolicitud).getId();

			if (dniVisado.equals(dniVisador)) {
				SwingUtil.showErrorDialog("El visador no puede sellar su propia solicitud");
			} else {
				model.asignarVisado(dniVisado, id, dniVisador);
				model.actualizarEstadoSolicitud(id,"Asignada");
				new AsignacionPericialModel().actualizarTurnoVisado(dniVisador);
				new AsignacionPericialModel().asignarVisador(dniVisador);
				actualizarTablas();
				SwingUtil.showInformationDialog(
						"Se ha asignado la solicitud del perito con DNI: " + dniVisado + ", al visador con DNI: " + dniVisador);
			}

		}
	}

}
