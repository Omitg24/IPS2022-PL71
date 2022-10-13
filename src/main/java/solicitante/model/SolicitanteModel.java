package solicitante.model;

import util.Database;
import util.Util;

/**
 * Título: Clase SolicitanteModel
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class SolicitanteModel {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante SQL_ADD_APPLICANT
	 */
	public static final String SQL_ADD_APPLICANT =
			"INSERT INTO SOLICITANTE (dniSol, nombreSol, apellidosSol, localidadSol, telefonoSol, "
			+ "titulacionSol, centroSol, anioSol, ibanSol, tipoSol, estadoSol) values (?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * Constante DEFAULT_TIPOSOL
	 */
	private static final String DEFAULT_TIPOSOL = "Colegiado";
	/**
	 * Constante DEFAULT_ESTADOSOL
	 */
	private static final String DEFAULT_ESTADOSOL = "Pendiente";
	
//-- ATRIBUTOS -----------------------------------------------------------------	
	/**
	 * Atributo db
	 */
	private Database db = new Database();

	/**
	 * Método applyForApplicant
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param telefono
	 * @param titulacion
	 * @param centro
	 * @param año
	 * @param iban
	 */
	public void applyForApplicant(String dni, String nombre, String apellidos, 
			String localidad, String telefono, String titulacion, String centro, 
			String año, String iban) {
		
		validation(dni, nombre, apellidos, localidad, telefono, titulacion, centro, año, iban);
		db.executeUpdate(SQL_ADD_APPLICANT, dni, nombre, apellidos, 
				localidad, telefono, titulacion, centro, año, iban,DEFAULT_TIPOSOL,DEFAULT_ESTADOSOL);
	}
	
	/**
	 * Método validation
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param telefono
	 * @param titulacion
	 * @param centro
	 * @param año
	 * @param iban
	 */
	private void validation(String dni, String nombre, String apellidos, 
			String localidad, String telefono, String titulacion, 
			String centro, String año, String iban) {
		
		Util.validateNotNull(dni, "El dni del soliciante no no puede ser nulo - D.Pers");
		Util.validateNotNull(nombre, "El nombre del soliciante no no puede ser nulo - D.Pers");
		Util.validateNotNull(apellidos, "Los apellidos del soliciante no no puede ser nulo - D.Pers");
		Util.validateNotNull(localidad, "La localidad del soliciante no no puede ser nulo - D.Pers");
		Util.validateNotNull(telefono, "El teléfono del soliciante no no puede ser nulo - D.Pers");
		Util.validateNotNull(titulacion, "La titulación del soliciante no no puede ser nulo - D.Acad");
		Util.validateNotNull(centro, "El centro del soliciante no no puede ser nulo - D.Acad");
		Util.validateNotNull(año, "El año del soliciante no no puede ser nulo - D.Acad");
		Util.validateNotNull(iban, "El IBAN del soliciante no no puede ser nulo - D.Banc");		
	}
	
	
}