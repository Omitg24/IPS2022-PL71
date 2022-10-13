package inscripcion.controller;

import java.util.Date;

import javax.swing.table.TableModel;

import curso.model.CursoDTO;
import inscripcion.model.InscripcionModel;
import inscripcion.view.EmisionView;
import inscripcion.view.IdentificadorView;
import inscripcion.view.InscripcionView;
import solicitante.model.ColegiadoDTO;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase InscripcionController
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionController {

	private InscripcionModel model;
	private IdentificadorView viewId;
	private InscripcionView view;
	private EmisionView emision;
	private ColegiadoDTO colegiado;
	private CursoDTO curso;

	TableModel t;

	public InscripcionController(InscripcionModel m, IdentificadorView v) {
		this.model = m;
		this.viewId = v;
		this.view = viewId.getInscripcion();
		this.emision = view.getEmision();

		this.initView();
	}

	public void initController() {
		viewId.getBtnEntrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> entrar()));
		view.getBtInscribirse().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirse()));
		emision.getBtnConfirmar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarEmision()));
		addCursosToList();
	}

	public void entrar() {
		if (comprobarId(viewId.getTextId().getText())) {
			colegiado = model.getSolicitanteFromKey(viewId.getTextId().getText());
			viewId.getFrame().setVisible(false);
			view.getFrame().setVisible(true);
		}
		else {
			SwingUtil.showErrorDialog("El identificador introducido no es válido");
		}
	}

	public void inscribirse() {
		String key = SwingUtil.getSelectedKey(view.getTableCursos());
		curso = model.getCursoFromKey(key);
		try {
			model.insertarInscribe(curso, colegiado);
			crearEmision();
		} catch (Exception e) {
			SwingUtil.showErrorDialog("Ya ha presentado una solicitud para este curso");
		}

	}

	public void initView() {
		viewId.getFrame().setVisible(true);
	}

	public void cerrarEmision() {
		emision.getFrame().setVisible(false);
	}

	public void addCursosToList() {
		t = SwingUtil.getTableModelFromPojos(model.getCursosAbiertos(), new String[] { "tituloCurso", "fechaCurso", "precio"});
		view.getTableCursos().setModel(t);
		String[] titles = new String[] { "                  Título del curso                  ", "      Fecha de inicio      ", "  Precio  "};
		for (int i = 0; i < titles.length; i++) {
			view.getTableCursos().getColumnModel().getColumn(i).setHeaderValue(titles[i]);
		}
		SwingUtil.autoAdjustColumns(view.getTableCursos());
		view.getTableCursos().getTableHeader().setReorderingAllowed(false);
		view.getTableCursos().getTableHeader().setResizingAllowed(false);
	}

	public boolean comprobarId(String s) {
		if (model.getSolicitanteFromKey(s) == null) return false;
		return true;
	}

	public void crearEmision() {
		String nombre = colegiado.getNombreSol().substring(0, 1).toUpperCase()
				+ colegiado.getNombreSol().substring(1);
		String apellido = colegiado.getApellidoSol();
		String apellido1 = apellido.split(" ")[0];
		String apellido2 = apellido.split(" ")[1];
		String apellidoMayus = apellido1.substring(0, 1).toUpperCase()
				+ apellido1.substring(1)  + " "
				+ apellido2.substring(0, 1).toUpperCase()
				+ apellido2.substring(1);
		String num = colegiado.getNumeroColegiado();
		String fecha = Util.dateToIsoString(new Date());
		String precio = curso.getPrecio() + "";
		emision.setNombre(nombre);
		emision.setApellido(apellidoMayus);
		emision.setNumero(num);
		emision.setFecha(fecha);
		emision.setCantidad(precio);
		emision.getFrame().setVisible(true);
	}
}
