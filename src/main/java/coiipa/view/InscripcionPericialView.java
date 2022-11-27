package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import coiipa.view.inscripcion.Inscripcion;
import ui_events.ProccessKeyNoDigits;

/**
 * Titulo: Clase InscripcionPericialView
 *
 * @author David Leszek Warzynski Abril, UO278968
 * @version 17 oct 2022
 */
public class InscripcionPericialView implements Inscripcion {

	// -- ATRIBUTOS
	// -----------------------------------------------------------------
	/**
	 * Atributo frame
	 */
	private JFrame frmAdministracinCoiipa;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo upperPanel
	 */
	private JPanel pnSuperior;
	/**
	 * Atributo lbLogo
	 */
	private JLabel lbLogo;
	/**
	 * Atributo applicantPanel
	 */
	private JPanel pnTitulo;
	/**
	 * Atributo lbApplicant
	 */
	private JLabel lbTitulo;
	/**
	 * Atributo bottomPanel
	 */
	private JPanel pnInf;
	/**
	 * Atributo btAddApplicant
	 */
	private JButton btModificar;
	/**
	 * Atributo middlePanel
	 */
	private JPanel middlePanel;
	/**
	 * Atributo leftDataPanel
	 */
	private JPanel pnIzqDatos;
	/**
	 * Atributo middleDataPanel
	 */
	private JPanel pnCnDatos;
	/**
	 * Atributo rightDataPanel
	 */
	private JPanel pnDeDatos;
	/**
	 * Atributo dniPanel
	 */
	private JPanel pnNumeroCol;
	/**
	 * Atributo lbDni
	 */
	private JLabel lbNumeroCol;
	/**
	 * Atributo txtDni
	 */
	private JTextField txtNumeroCol;
	/**
	 * Atributo namePanel
	 */
	private JPanel pnDni;
	/**
	 * Atributo lbName
	 */
	private JLabel lbDni;
	/**
	 * Atributo txtName
	 */
	private JTextField txtDni;
	/**
	 * Atributo populationPanel
	 */
	private JPanel pnNombre;
	/**
	 * Atributo lbPopulation
	 */
	private JLabel lbNombre;
	/**
	 * Atributo txtPopulation
	 */
	private JTextField txtNombre;
	/**
	 * Atributo telephonePanel
	 */
	private JPanel pnTelefono;
	/**
	 * Atributo lbTelephone
	 */
	private JLabel lbTelefono;
	/**
	 * Atributo txtTelephone
	 */
	private JTextField txtTelefono;
	/**
	 * Atributo centerPanel
	 */
	private JPanel pnApellidos;
	/**
	 * Atributo lbCenter
	 */
	private JLabel lbApellidos;
	/**
	 * Atributo txtCenter
	 */
	private JTextField txtApellidos;
	/**
	 * Atributo yearPanel
	 */
	private JPanel pnLocalidad;
	/**
	 * Atributo lbYear
	 */
	private JLabel lbLocalidad;
	/**
	 * Atributo txtYear
	 */
	private JTextField txtLocalidad;
	private JButton btVerificar;
	private JPanel pnModificar;
	private JPanel pnVerificar;

//-- INTERFAZ GRÁFICA ----------------------------------------------------------
	/**
	 * Constructor ApplicantView
	 */
	public InscripcionPericialView() {
		initialize();
	}

	/**
	 * Método initialize
	 */
	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setPreferredSize(new Dimension(1200, 800));
		frmAdministracinCoiipa.setSize(new Dimension(1500, 1000));
		frmAdministracinCoiipa.setResizable(false);
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Inscripcion Pericial");
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InscripcionPericialView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setBounds(100, 100, 895, 500);
		frmAdministracinCoiipa.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmAdministracinCoiipa.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInf(), BorderLayout.SOUTH);
		frmAdministracinCoiipa.getRootPane().setDefaultButton(btModificar);
		contentPane.add(getMiddlePanel(), BorderLayout.CENTER);
	}

	/**
	 * Método getUpperPanel
	 * 
	 * @return upperPanel
	 */
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getPnTitulo());
		}
		return pnSuperior;
	}

	/**
	 * Método getLbLogo
	 * 
	 * @return lbLogo
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(InscripcionPericialView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	/**
	 * Método getApplicationPanel
	 * 
	 * @return applicantPanel
	 */
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.add(getLbTitulo());
		}
		return pnTitulo;
	}

	/**
	 * getLbApplicant
	 * 
	 * @return lbApplicant
	 */
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Inscripción Pericial");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 60));
		}
		return lbTitulo;
	}

	/**
	 * Método getBottomPanel
	 * 
	 * @return bottomPanel
	 */
	private JPanel getPnInf() {
		if (pnInf == null) {
			pnInf = new JPanel();
			pnInf.setPreferredSize(new Dimension(10, 50));
			pnInf.setFont(new Font("Tahoma", Font.PLAIN, 16));
			pnInf.setBackground(Color.WHITE);
			pnInf.setLayout(new GridLayout(0, 2, 0, 0));
			pnInf.add(getPnModificar());
			pnInf.add(getPnVerificar());
		}
		return pnInf;
	}

	/**
	 * Método getBtModificar
	 * 
	 * @return btModificar
	 */
	public JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
			btModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btModificar.setForeground(Color.WHITE);
			btModificar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btModificar.setBackground(new Color(34, 139, 34));
		}
		return btModificar;
	}

	/**
	 * Método getMiddlePanel
	 * 
	 * @return middlePanel
	 */
	private JPanel getMiddlePanel() {
		if (middlePanel == null) {
			middlePanel = new JPanel();
			middlePanel.setBackground(Color.WHITE);
			middlePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null),
					"Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			middlePanel.setLayout(new GridLayout(0, 3, 10, 10));
			middlePanel.add(getPnIzqDatos());
			middlePanel.add(getPnCnDatos());
			middlePanel.add(getPnDeDatos());
		}
		return middlePanel;
	}

	/**
	 * Método getPnIzqDatos
	 * 
	 * @return pnIzqDatos
	 */
	private JPanel getPnIzqDatos() {
		if (pnIzqDatos == null) {
			pnIzqDatos = new JPanel();
			pnIzqDatos.setBorder(null);
			pnIzqDatos.setBackground(Color.WHITE);
			pnIzqDatos.setLayout(new GridLayout(2, 0, 5, 10));
			pnIzqDatos.add(getPnNumeroCol());
			pnIzqDatos.add(getPnDni());
		}
		return pnIzqDatos;
	}

	/**
	 * Método getPnNumeroCol
	 * 
	 * @return pnNumeroCol
	 */
	private JPanel getPnNumeroCol() {
		if (pnNumeroCol == null) {
			pnNumeroCol = new JPanel();
			pnNumeroCol.setBackground(Color.WHITE);
			pnNumeroCol.setLayout(new GridLayout(2, 2, 0, 5));
			pnNumeroCol.add(getLbNumeroCol());
			pnNumeroCol.add(getTxtNumeroCol());
		}
		return pnNumeroCol;
	}

	/**
	 * Método getLbNumeroCol
	 * 
	 * @return lbNumeroCol
	 */
	private JLabel getLbNumeroCol() {
		if (lbNumeroCol == null) {
			lbNumeroCol = new JLabel("Número Colegiado");
			lbNumeroCol.setBorder(null);
			lbNumeroCol.setLabelFor(getTxtNumeroCol());
			lbNumeroCol.setHorizontalAlignment(SwingConstants.CENTER);
			lbNumeroCol.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbNumeroCol;
	}

	/**
	 * Método getTxtNumeroCol
	 * 
	 * @return txtNumeroCol
	 */
	public JTextField getTxtNumeroCol() {
		if (txtNumeroCol == null) {
			txtNumeroCol = new JTextField();
			txtNumeroCol.setEditable(false);
			txtNumeroCol.setPreferredSize(new Dimension(10, 25));
			txtNumeroCol.setHorizontalAlignment(SwingConstants.CENTER);
			txtNumeroCol.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNumeroCol.setColumns(10);
			txtNumeroCol.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtNumeroCol.setBackground(Color.WHITE);
		}
		return txtNumeroCol;
	}

	/**
	 * Método getNamePanel
	 * 
	 * @return namePanel
	 */
	private JPanel getPnDni() {
		if (pnDni == null) {
			pnDni = new JPanel();
			pnDni.setBackground(Color.WHITE);
			pnDni.setLayout(new GridLayout(2, 2, 0, 5));
			pnDni.add(getLbDni());
			pnDni.add(getTxtDni());
		}
		return pnDni;
	}

	/**
	 * Método getLbName
	 * 
	 * @return lbName
	 */
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI");
			lbDni.setLabelFor(getTxtDni());
			lbDni.setHorizontalAlignment(SwingConstants.CENTER);
			lbDni.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbDni;
	}

	/**
	 * Método getTxtName
	 * 
	 * @return txtName
	 */
	public JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setEditable(false);
			txtDni.setPreferredSize(new Dimension(10, 25));
			txtDni.setHorizontalAlignment(SwingConstants.CENTER);
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDni.setColumns(10);
			txtDni.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtDni.setBackground(Color.WHITE);
			txtDni.addKeyListener(new ProccessKeyNoDigits());
		}
		return txtDni;
	}

	/**
	 * Método getMiddleDataPanel
	 * 
	 * @return middleDataPanel
	 */
	private JPanel getPnCnDatos() {
		if (pnCnDatos == null) {
			pnCnDatos = new JPanel();
			pnCnDatos.setBackground(Color.WHITE);
			pnCnDatos.setLayout(new GridLayout(2, 0, 5, 10));
			pnCnDatos.add(getPnNombre());
			pnCnDatos.add(getPnTelefono());
		}
		return pnCnDatos;
	}

	/**
	 * Método getPopulationPanel
	 * 
	 * @return populationPanel
	 */
	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setBackground(Color.WHITE);
			pnNombre.setLayout(new GridLayout(2, 2, 0, 5));
			pnNombre.add(getLbNombre());
			pnNombre.add(getTxtNombre());
		}
		return pnNombre;
	}

	/**
	 * Método lbPopulation
	 * 
	 * @return lbPopulation
	 */
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre");
			lbNombre.setLabelFor(getTxtNombre());
			lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbNombre;
	}

	/**
	 * Método getTxtPopulation
	 * 
	 * @return txtPopulation
	 */
	public JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setPreferredSize(new Dimension(10, 25));
			txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtNombre.setBackground(Color.WHITE);
			txtNombre.addKeyListener(new ProccessKeyNoDigits());
		}
		return txtNombre;
	}

	/**
	 * Método getTelephonePanel
	 * 
	 * @return telephonePanel
	 */
	private JPanel getPnTelefono() {
		if (pnTelefono == null) {
			pnTelefono = new JPanel();
			pnTelefono.setBackground(Color.WHITE);
			pnTelefono.setLayout(new GridLayout(2, 2, 0, 5));
			pnTelefono.add(getLbTelefono());
			pnTelefono.add(getTxtTelefono());
		}
		return pnTelefono;
	}

	/**
	 * Método getLbTelephone
	 * 
	 * @return lbTelephone
	 */
	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Teléfono (*)");
			lbTelefono.setLabelFor(getTxtTelefono());
			lbTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			lbTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbTelefono;
	}

	/**
	 * Método getTxtTelephone
	 * 
	 * @return txtTelephone
	 */
	public JTextField getTxtTelefono() {
		if (txtTelefono == null) {
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setPreferredSize(new Dimension(10, 25));
			txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTelefono.setColumns(10);
			txtTelefono.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtTelefono.setBackground(Color.WHITE);
		}
		return txtTelefono;
	}

	/**
	 * Método getRightDataPanel
	 * 
	 * @return rightDataPanel
	 */
	private JPanel getPnDeDatos() {
		if (pnDeDatos == null) {
			pnDeDatos = new JPanel();
			pnDeDatos.setBackground(Color.WHITE);
			pnDeDatos.setLayout(new GridLayout(2, 0, 5, 10));
			pnDeDatos.add(getPnApellidos());
			pnDeDatos.add(getPnLocalidad());
		}
		return pnDeDatos;
	}

	/**
	 * Método getCenterPanel
	 * 
	 * @return centerPanel
	 */
	private JPanel getPnApellidos() {
		if (pnApellidos == null) {
			pnApellidos = new JPanel();
			pnApellidos.setBackground(Color.WHITE);
			pnApellidos.setLayout(new GridLayout(2, 2, 0, 5));
			pnApellidos.add(getLbApellidos());
			pnApellidos.add(getTxtApellidos());
		}
		return pnApellidos;
	}

	/**
	 * Método getLbCenter
	 * 
	 * @return lbCenter
	 */
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos");
			lbApellidos.setLabelFor(getTxtApellidos());
			lbApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lbApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbApellidos;
	}

	/**
	 * Método getTxtCenter
	 * 
	 * @return txtCenter
	 */
	public JTextField getTxtApellidos() {
		if (txtApellidos == null) {
			txtApellidos = new JTextField();
			txtApellidos.setEditable(false);
			txtApellidos.setPreferredSize(new Dimension(10, 25));
			txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtApellidos.setColumns(10);
			txtApellidos.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtApellidos.setBackground(Color.WHITE);
		}
		return txtApellidos;
	}

	/**
	 * Método getYearPanel
	 * 
	 * @return yearPanel
	 */
	private JPanel getPnLocalidad() {
		if (pnLocalidad == null) {
			pnLocalidad = new JPanel();
			pnLocalidad.setBackground(Color.WHITE);
			pnLocalidad.setLayout(new GridLayout(2, 2, 0, 5));
			pnLocalidad.add(getLbLocalidad());
			pnLocalidad.add(getTxtLocalidad());
		}
		return pnLocalidad;
	}

	/**
	 * Método getLbYear
	 * 
	 * @return lbYear
	 */
	private JLabel getLbLocalidad() {
		if (lbLocalidad == null) {
			lbLocalidad = new JLabel("Localidad (*)");
			lbLocalidad.setLabelFor(getTxtLocalidad());
			lbLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
			lbLocalidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbLocalidad;
	}

	/**
	 * Método getTxtYear
	 * 
	 * @return txtYear
	 */
	public JTextField getTxtLocalidad() {
		if (txtLocalidad == null) {
			txtLocalidad = new JTextField();
			txtLocalidad.setEditable(false);
			txtLocalidad.setPreferredSize(new Dimension(10, 25));
			txtLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
			txtLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtLocalidad.setColumns(10);
			txtLocalidad.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtLocalidad.setBackground(Color.WHITE);
		}
		return txtLocalidad;
	}

//-- MÉTODOS AUXILIARES --------------------------------------------------------
	/**
	 * Método getFrame
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frmAdministracinCoiipa;
	}


	public String getNumeroColegiado() {
		return getTxtNumeroCol().getText();
	}

	public String getDni() {
		return getTxtDni().getText();
	}


	public String getNombre() {
		return getTxtNombre().getText();
	}

	public String getTelefono() {
		return getTxtTelefono().getText();
	}


	public String getApellidos() {
		return getTxtApellidos().getText();
	}

	public String getLocalidad() {
		return getTxtLocalidad().getText();
	}
	
	public JButton getModificar() {
		return getBtModificar();
	}
	
	public JButton getVerificar() {
		return getBtVerificar();
	}


	/**
	 * Método resetFields
	 */
	public void resetFields() {
		resetColor();
	}


	/**
	 * Método resetColor
	 */
	private void resetColor() {
		getTxtNumeroCol().setBackground(Color.LIGHT_GRAY);
		getTxtDni().setBackground(Color.LIGHT_GRAY);
		getTxtNombre().setBackground(Color.LIGHT_GRAY);
		getTxtTelefono().setBackground(Color.LIGHT_GRAY);
		getTxtApellidos().setBackground(Color.LIGHT_GRAY);
		getTxtLocalidad().setBackground(Color.LIGHT_GRAY);
	}

	private JButton getBtVerificar() {
		if (btVerificar == null) {
			btVerificar = new JButton("Verificar");
			btVerificar.setAlignmentX(Component.CENTER_ALIGNMENT);
			btVerificar.setForeground(Color.WHITE);
			btVerificar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btVerificar.setBackground(new Color(0, 128, 0));
		}
		return btVerificar;
	}
	private JPanel getPnModificar() {
		if (pnModificar == null) {
			pnModificar = new JPanel();
			pnModificar.setBackground(Color.WHITE);
			pnModificar.add(getBtModificar());
		}
		return pnModificar;
	}
	private JPanel getPnVerificar() {
		if (pnVerificar == null) {
			pnVerificar = new JPanel();
			pnVerificar.setBackground(Color.WHITE);
			pnVerificar.add(getBtVerificar());
		}
		return pnVerificar;
	}

	@Override
	public Inscripcion getInscripcion() {
		return this;
	}
}