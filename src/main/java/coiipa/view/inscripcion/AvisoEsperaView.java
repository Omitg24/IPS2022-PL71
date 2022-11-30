package coiipa.view.inscripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import coiipa.controller.InscripcionController;
import coiipa.view.asignacionpericial.AnulacionView;
import util.SwingUtil;

/**
 * Titulo: Clase AvisoEsperaView
 *
 * @author Omar Teixiera González, UO281847
 * @version 27 nov 2022
 */
public class AvisoEsperaView extends JDialog {
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo pnSuperior
	 */
	private JPanel pnSuperior;
	/**
	 * Atributo lbLogo
	 */
	private JLabel lbLogo;
	/**
	 * Atributo pnCentral
	 */
	private JPanel pnCentral;
	/**
	 * Atributo lblEspera
	 */
	private JLabel lblEspera;
	/**
	 * Atributo pnInferior
	 */
	private JPanel pnInferior;
	/**
	 * Atributo btnConfirmar
	 */
	private JButton btnConfirmar;
	/**
	 * Atributo inscripcionController
	 */
	private InscripcionController inscripcionController;	
	/**
	 * Atributo pnDatos
	 */
	private JPanel pnDatos;
	/**
	 * Atributo pnPosicion
	 */
	private JPanel pnPosicion;
	/**
	 * Atributo lblPosicion
	 */
	private JLabel lblPosicion;
	/**
	 * Atributo txtPosicion
	 */
	private JTextField txtPosicion;
	/**
	 * Atributo pnCurso
	 */
	private JPanel pnCurso;
	/**
	 * Atributo pnSolicitante
	 */
	private JPanel pnSolicitante;
	/**
	 * Atributo lblTituloCurso
	 */
	private JLabel lblTituloCurso;
	/**
	 * Atributo lblFechaCurso
	 */
	private JLabel lblFechaCurso;
	/**
	 * Atributo txtTitulo
	 */
	private JTextField txtTitulo;
	/**
	 * Atributo txtFecha
	 */
	private JTextField txtFecha;
	/**
	 * Atributo lblFechaInscripcion
	 */
	private JLabel lblFechaInscripción;
	/**
	 * Atributo txtFechaInscripcion
	 */
	private JTextField txtFechaInscripcion;
	/**
	 * Atributo lblDniColegiado
	 */
	private JLabel lblDniColegiado;
	/**
	 * Atributo txtDni
	 */
	private JTextField txtDni;
	/**
	 * Atributo lblNombreColegiado
	 */
	private JLabel lblNombreColegiado;
	/**
	 * Atributo txtNombre
	 */
	private JTextField txtNombre;
	/**
	 * Atributo lblApellidosColegiado
	 */
	private JLabel lblApellidosColegiado;
	/**
	 * Atributo txtApellidos
	 */
	private JTextField txtApellidos;
	
	/**
	 * Constructor AvisoEsperaView
	 * @param inscripcionController
	 */
	public AvisoEsperaView(InscripcionController asignacionController) {
		this.inscripcionController = asignacionController;
		initialize();
	}

	/**
	 * Método initialize
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaView.class.getResource("/images/coiipa_symbol.png")));
		setModal(true);
		setType(Type.POPUP);
		setVisible(false);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		setMinimumSize(new Dimension(800, 450));
		setLocationRelativeTo(null);		
		setTitle("Administración COIIPA - Unirse a la espera");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(10, 0));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		
		setContentPane(contentPane);
	}
	
	/**
	 * Método getPnSuperior
	 * @return pnSuperior
	 */
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLblEspera());
		}
		return pnSuperior;
	}
	
	/**
	 * Métogo getLbLogo
	 * @return lbLogo
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(AnulacionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	
	/**
	 * Método getPnCentral
	 * @return pnCentral
	 */
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setBackground(Color.WHITE);
			pnCentral.setLayout(new BorderLayout(0, 0));
			pnCentral.add(getPnDatos(), BorderLayout.CENTER);
			pnCentral.add(getPnPosicion(), BorderLayout.SOUTH);
		}
		return pnCentral;
	}
	
	/**
	 * Método getLblEspera
	 * @return lblEspera
	 */
	private JLabel getLblEspera() {
		if (lblEspera == null) {
			lblEspera = new JLabel("Unirse a la espera");
			lblEspera.setHorizontalAlignment(SwingConstants.CENTER);
			lblEspera.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		}
		return lblEspera;
	}
	
	/**
	 * Método getPnInferior
	 * @return pnInferior
	 */
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtnConfirmar());
		}
		return pnInferior;
	}
	
	/**
	 * Método getBtnConfirmar
	 * @return btnConfirmar
	 */
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");			
			btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConfirmar.setPreferredSize(new Dimension(170, 35));
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnConfirmar.setBackground(new Color(34, 139, 34));
			btnConfirmar.addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarCampos(inscripcionController)));
		}
		return btnConfirmar;
	}
	
	/**
	 * Método comprobarCampos
	 * @param inscripcionController
	 */
	private void comprobarCampos(InscripcionController inscripcionController) {
		inscripcionController.insertarEnEspera();
	}
	
	/**
	 * Método getPnDatos
	 * @return pnDatos
	 */
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(Color.WHITE);
			pnDatos.setLayout(new GridLayout(1, 0, 10, 10));
			pnDatos.add(getPnCurso());
			pnDatos.add(getPnSolicitante());
		}
		return pnDatos;
	}
	
	/**
	 * Método getPnPosicion
	 * @return pnPosicion
	 */
	private JPanel getPnPosicion() {
		if (pnPosicion == null) {
			pnPosicion = new JPanel();
			pnPosicion.setBackground(Color.WHITE);
			pnPosicion.add(getLblPosicion());
			pnPosicion.add(getTxtPosicion());
		}
		return pnPosicion;
	}
	
	/**
	 * Método getLblPosicion
	 * @return lblPosicion
	 */
	private JLabel getLblPosicion() {
		if (lblPosicion == null) {
			lblPosicion = new JLabel("Entrará en la lista de espera en la posición:");
			lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblPosicion;
	}
	
	/**
	 * Método getTxtPosicion
	 * @return txtPosicion
	 */
	private JTextField getTxtPosicion() {
		if (txtPosicion == null) {
			txtPosicion = new JTextField();
			txtPosicion.setBorder(new LineBorder(Color.BLACK));
			txtPosicion.setEditable(false);
			txtPosicion.setHorizontalAlignment(SwingConstants.CENTER);
			txtPosicion.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtPosicion.setColumns(5);
		}
		return txtPosicion;
	}
	
	/**
	 * Método getPnCurso
	 * @return pnCurso
	 */
	private JPanel getPnCurso() {
		if (pnCurso == null) {
			pnCurso = new JPanel();
			pnCurso.setBackground(Color.WHITE);
			pnCurso.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos del curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnCurso.setLayout(new GridLayout(6, 1, 0, 0));
			pnCurso.add(getLblTituloCurso());
			pnCurso.add(getTxtTitulo());
			pnCurso.add(getLblFechaCurso());
			pnCurso.add(getTxtFecha());
			pnCurso.add(getLblFechaInscripción());
			pnCurso.add(getTextFechaInscripcion());
		}
		return pnCurso;
	}
	
	/**
	 * Método getPnSolicitante
	 * @return pnSolicitante
	 */
	private JPanel getPnSolicitante() {
		if (pnSolicitante == null) {
			pnSolicitante = new JPanel();
			pnSolicitante.setBackground(Color.WHITE);
			pnSolicitante.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnSolicitante.setLayout(new GridLayout(6, 1, 0, 0));
			pnSolicitante.add(getLblDniColegiado());
			pnSolicitante.add(getTxtDni());
			pnSolicitante.add(getLblNombreColegiado());
			pnSolicitante.add(getTxtNombre());
			pnSolicitante.add(getLblApellidosColegiado());
			pnSolicitante.add(getTxtApellidos());
		}
		return pnSolicitante;
	}
	
	/**
	 * Método getLblTituloCurso
	 * @return lblTituloCurso
	 */
	private JLabel getLblTituloCurso() {
		if (lblTituloCurso == null) {
			lblTituloCurso = new JLabel("Título del curso:");
			lblTituloCurso.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblTituloCurso;
	}
	
	/**
	 * Método getLblFechaCurso
	 * @return lblFechaCurso
	 */
	private JLabel getLblFechaCurso() {
		if (lblFechaCurso == null) {
			lblFechaCurso = new JLabel("Fecha del curso:");
			lblFechaCurso.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblFechaCurso;
	}
	
	/**
	 * Método getTxtTitulo
	 * @return txtTitulo
	 */
	private JTextField getTxtTitulo() {
		if (txtTitulo == null) {
			txtTitulo = new JTextField();
			txtTitulo.setBorder(new LineBorder(Color.BLACK));
			txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTitulo.setEditable(false);
			txtTitulo.setColumns(10);
		}
		return txtTitulo;
	}
	
	/**
	 * Método getTxtFecha
	 * @return txtFecha
	 */
	private JTextField getTxtFecha() {
		if (txtFecha == null) {
			txtFecha = new JTextField();
			txtFecha.setBorder(new LineBorder(Color.BLACK));
			txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
			txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
		}
		return txtFecha;
	}
	
	/**
	 * Método getLblFechaInscripción
	 * @return lblFechaInscripción
	 */
	private JLabel getLblFechaInscripción() {
		if (lblFechaInscripción == null) {
			lblFechaInscripción = new JLabel("Fecha de inscripción:");
			lblFechaInscripción.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaInscripción.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblFechaInscripción;
	}
	
	/**
	 * Método getTextFechaInscripcion
	 * @return txtFechaInscripcion
	 */
	private JTextField getTextFechaInscripcion() {
		if (txtFechaInscripcion == null) {
			txtFechaInscripcion = new JTextField();
			txtFechaInscripcion.setBorder(new LineBorder(Color.BLACK));
			txtFechaInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
			txtFechaInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtFechaInscripcion.setEditable(false);
			txtFechaInscripcion.setColumns(10);
		}
		return txtFechaInscripcion;
	}
	
	/**
	 * Método getLblDniColegiado
	 * @return lblDniColegiado
	 */
	private JLabel getLblDniColegiado() {
		if (lblDniColegiado == null) {
			lblDniColegiado = new JLabel("DNI del solicitante:");
			lblDniColegiado.setHorizontalAlignment(SwingConstants.CENTER);
			lblDniColegiado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblDniColegiado;
	}
	
	/**
	 * Método getTxtDni
	 * @return txtDni
	 */
	private JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setBorder(new LineBorder(Color.BLACK));
			txtDni.setHorizontalAlignment(SwingConstants.CENTER);
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDni.setEditable(false);
			txtDni.setColumns(10);
		}
		return txtDni;
	}
	
	/**
	 * Método getLblNombreColegiado
	 * @return lblNombreColegiado
	 */
	private JLabel getLblNombreColegiado() {
		if (lblNombreColegiado == null) {
			lblNombreColegiado = new JLabel("Nombre del solicitante:");
			lblNombreColegiado.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreColegiado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNombreColegiado;
	}
	
	/**
	 * Método getTxtNombre
	 * @return pnDatos
	 */
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBorder(new LineBorder(Color.BLACK));
			txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	
	/**
	 * Método getLblApellidosColegiado
	 * @return lblApellidosColegiado
	 */
	private JLabel getLblApellidosColegiado() {
		if (lblApellidosColegiado == null) {
			lblApellidosColegiado = new JLabel("Apellidos del solicitante:");
			lblApellidosColegiado.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidosColegiado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblApellidosColegiado;
	}
	
	/**
	 * Método getTxtApellidos
	 * @return txtApellidos
	 */
	private JTextField getTxtApellidos() {
		if (txtApellidos == null) {
			txtApellidos = new JTextField();
			txtApellidos.setBorder(new LineBorder(Color.BLACK));
			txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtApellidos.setEditable(false);
			txtApellidos.setColumns(10);
		}
		return txtApellidos;
	}
	
	/**
	 * Método getTextTituloCurso
	 * @return txtTitulo
	 */
	public JTextField getTextTituloCurso() {
		return txtTitulo;
	}
	
	/**
	 * Método getTextFechaCurso
	 * @return txtFecha
	 */
	public JTextField getTextFechaCurso() {
		return txtFecha;
	}
	
	/**
	 * Método getTextFechaInscripcionCurso
	 * @return txtFechaInscripcion
	 */
	public JTextField getTextFechaInscripcionCurso() {
		return txtFechaInscripcion;
	}
	
	/**
	 * Método getTextDniColegiado
	 * @return txtDni
	 */
	public JTextField getTextDniColegiado() {
		return txtDni;
	}
	
	/**
	 * Método getTextNombreColegiado
	 * @return txtNombre
	 */
	public JTextField getTextNombreColegiado() {
		return txtNombre;
	}
	
	/**
	 * Método getTextApellidosColegiado
	 * @return txtApellidos
	 */
	public JTextField getTextApellidosColegiado() {
		return txtApellidos;
	}
	
	/**
	 * Método getTextPosicion
	 * @return txtPosicion
	 */
	public JTextField getTextPosicion() {
		return txtPosicion;
	}
}
