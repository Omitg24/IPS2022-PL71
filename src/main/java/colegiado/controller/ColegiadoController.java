package colegiado.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import colegiado.model.ColegiadoModel;
import colegiado.view.ColegiadoView;
import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import util.SwingUtil;

/**
 * Título: Clase SolicitanteController
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ColegiadoController {	
	/**
	 * Atributo model
	 */
	private ColegiadoModel model;
	/**
	 * Atributo view
	 */
	private ColegiadoView view;
	
	/**
	 * Constructor ApplicantController
	 * @param model
	 * @param view
	 */
	public ColegiadoController(ColegiadoModel model, ColegiadoView view) {
		this.model = model;
		this.view = view;
		
		initView();
	}

	/**
	 * Método initView
	 */
	private void initView() {
		view.getFrame().setVisible(true);
	}

	/**
	 * Método initController
	 */
	public void initController() {
		view.getBtAddApplicant().addActionListener(e -> SwingUtil.exceptionWrapper(() -> applicantPlan()));
		view.getTxtDni().addFocusListener(new ChangeColor());
		view.getTxtName().addFocusListener(new ChangeColor());
		view.getTxtSurname().addFocusListener(new ChangeColor());		
		view.getTxtPopulation().addFocusListener(new ChangeColor());
		view.getTxtTelephone().addFocusListener(new ChangeColor());
		view.getTxtTitulation().addFocusListener(new ChangeColor());
		view.getTxtCenter().addFocusListener(new ChangeColor());
		view.getTxtYear().addFocusListener(new ChangeColor());
		view.getTxtIban().addFocusListener(new ChangeColor());
		
	}

	/**
	 * Método applicantPlan
	 */
	private void applicantPlan() {
		if (checkField(view.getDni()) || checkField(view.getName()) || 
			checkField(view.getSurname()) || checkField(view.getPopulation()) || 
			checkField(view.getTelephone()) || checkField(view.getTitulation()) || 
			checkField(view.getCenter()) || checkField(view.getYear()) || 
			checkField(view.getIban())) {
			SwingUtil.showErrorDialog("Los campos no pueden estar vacios");			
		} else {
			String dni = view.getDni();
			String name = view.getName();
			String surname = view.getSurname();
			String population = view.getPopulation();
			String telephone = view.getTelephone();
			String titulation = view.getTitulation();
			String center = view.getCenter();
			String year = view.getYear();
			String iban = view.getIban();
			model.applyForApplicant(dni, name, surname, population, telephone, 
									titulation, center, year, iban);
			view.resetFields();
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "ES"));
			SwingUtil.showInformationDialog("Solicitud con dni: " + dni + ", a día " + dateFormat.format(new Date()) + ",\n ha sido presentada. Se mantendrá en estado 'Pendiente'.");
		}
	}
	
	/**
	 * Método checkField
	 * @param string
	 * @return boolean
	 */
	private boolean checkField(String string) {
		if (string == null || string.isBlank() || string.equals(ChangeDateColor.DATE)) {
			return true;
		}
		return false;
	}
}