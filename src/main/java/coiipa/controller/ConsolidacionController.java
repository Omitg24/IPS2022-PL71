package coiipa.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import coiipa.model.dto.CursoDTO;
import coiipa.model.dto.InscritoDTO;
import coiipa.model.model.ConsolidacionModel;
import coiipa.view.ConsolidacionView;
import util.SwingUtil;
import util.Util;

/**
 * Titulo: Clase ConsolidacionController
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 nov 2022
 */
public class ConsolidacionController {	
//-- CONSTANTES -----------------------------------------------
	/**
	 * Constante LIMITE_DIAS
	 */
	public static final int LIMITE_DIAS = 2;
	/**
	 * Constante CANCELADO
	 */
	public static final String CANCELADO = "Cancelado";
	/**
	 * Constante INSCRITO
	 */
	public static final String INSCRITO = "Inscrito";
//-- ATRIBUTOS ------------------------------------------------
	/**
	 * Atributo model
	 */
	private ConsolidacionModel model;
	/**
	 * Atributo view
	 */
	private ConsolidacionView view;
	/**
	 * Atributo cursos
	 */
	private List<CursoDTO> cursos;
	/**
	 * Atributo preinscritos
	 */
	private List<InscritoDTO> preinscritos;
	/**
	 * Atributo tituloCuros
	 */
	private String tituloCurso;
	/**
	 * Atributo fechaCurso
	 */
	private String fechaCurso;
	/**
	 * Atributo precio
	 */
	private double precio;
	/**
	 * Atributo fileName
	 */
	private String fileName;
	
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
		view.getBtConsolidacion().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> consolidate()));
	}
	
	/**
	 * Método loadTableCursos
	 */
	private void loadTableCursos() {
		this.cursos = model.getListaCursos();
		
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
		this.tituloCurso = view.getTblCursos().getModel().getValueAt(view.getTblCursos().getSelectedRow(), 0).toString();
		this.fechaCurso = view.getTblCursos().getModel().getValueAt(view.getTblCursos().getSelectedRow(), 1).toString();
		this.precio = Double.valueOf(view.getTblCursos().getModel().getValueAt(view.getTblCursos().getSelectedRow(), 4).toString());
		
		this.fileName = tituloCurso.toLowerCase().replace(" ", "_")+"_"+fechaCurso;
		this.preinscritos = model.getListaPreinscritos(tituloCurso, fechaCurso);		
		updateTableColegiados();			
		
		if (preinscritos.isEmpty()) {
			view.getBtConsolidacion().setEnabled(false);
		} else {
			view.getBtConsolidacion().setEnabled(true);
		}				
	}
	
	/**
	 * Método loadTableColegiados
	 */
	private void consolidate() {
		boolean isPresent = false;		
		int fechaCounter = 0;		
		int abonadoCounter = 0;		
		int noPresenteCounter = 0;
		int inscritoCounter = 0;
		
		List<InscritoDTO> preinscritosBanco = new ArrayList<InscritoDTO>(); 
		if (!Util.readFinanceFiles(fileName, preinscritosBanco)) {
			SwingUtil.showErrorDialog("No se han podido consolidar los pagos."
									+ "\nEsto se debe a que no se ha recibido aún el fichero del banco correspondiente.");
			return;
		}
		
		for (InscritoDTO preinscrito : preinscritos) {
			isPresent = false;
			for (InscritoDTO preinscritoBanco : preinscritosBanco) {
				if (preinscrito.getDniColegiado().equals(preinscritoBanco.getDniColegiado())) {					
					isPresent = true;
					LocalDate fechaInscrito = LocalDate.parse(preinscrito.getFecha());
					LocalDate fechaPago = LocalDate.parse(preinscritoBanco.getFecha());
					
					if (ChronoUnit.DAYS.between(fechaInscrito, fechaPago) > LIMITE_DIAS) {
						fechaCounter++;
						model.updatePreinscrito(CANCELADO, "Inscripción cancelada por exceder el límite de tiempo del pago (2 días)", 
								preinscrito.getDniColegiado(), tituloCurso, fechaCurso);
					} else if (preinscritoBanco.getAbonado() < precio) {
						abonadoCounter++;
						model.updatePreinscrito(CANCELADO, "Inscripción cancelada por no pagar el curso al completo. Se devolverá el importe abonado.", 
								preinscrito.getDniColegiado(), tituloCurso, fechaCurso);
					} else {
						inscritoCounter++;
						model.updateInscrito(INSCRITO, preinscritoBanco.getAbonado(), 
								preinscrito.getDniColegiado(), tituloCurso, fechaCurso);
					}
				}
			}
			if (!isPresent) {				
				noPresenteCounter++;
				model.updateEstado(CANCELADO, preinscrito.getDniColegiado(), tituloCurso, fechaCurso);
			}
		}
		
		this.preinscritos = model.getListaPreinscritos(tituloCurso, fechaCurso);
		updateTableColegiados();
		
		SwingUtil.showInformationDialog(getMsg(fechaCounter, abonadoCounter, noPresenteCounter, inscritoCounter));
		view.getBtConsolidacion().setEnabled(false);
	}	
	
	/**
	 * Método updateTableColegiados
	 */
	private void updateTableColegiados() {
		TableModel tmodel = SwingUtil.getTableModelFromPojos(preinscritos, new String[] {"apellidosColegiado", "nombreColegiado", 
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
	
	/**
	 * Método getMsg
	 * @param fechaCounter
	 * @param abonadoCounter
	 * @param noPresenteCounter
	 * @param inscritoCounter
	 * @return
	 */
	private String getMsg(int fechaCounter, int abonadoCounter, int noPresenteCounter, int inscritoCounter) {
		int canceladoCounter = fechaCounter + abonadoCounter + noPresenteCounter;
		String msg = "Se han actualizado todos los estados."
				   + "\nUn total de " + canceladoCounter + " inscripciones se han cancelado, concretamente:"
				   + "\n      • Cancelados por exceder el limite de tiempo del pago: " + fechaCounter 
				   + "\n      • Cancelados por no hacer el pago completo: " + abonadoCounter
				   + "\n      • Cancelados por no estar presentes en el informe bancario: " + noPresenteCounter
				   + "\nEl resto de inscripciones (un total de " + inscritoCounter + ") han cumplido los requisitos y se ha confirmado su inscripción.";
		return msg;
	}
}
