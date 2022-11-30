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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InformeView {

	private JFrame frmAdministracinCoiipa;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JButton btConfirmar;
	private JPanel panelNombre;
	private JPanel panelCorreoTel;
	private JPanel panelDescripción;
	private JPanel panelUrgencia;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblCorreo;
	private JTextField textFieldCorreo;
	private JLabel lblDescripcion;
	private JLabel lblDni;
	private JTextField textFieldDni;
	private JLabel lblTelefono;
	private JTextField textFieldTelefono;
	private JLabel lblUrgencia;
	private JRadioButton rdbtnUrgente;
	private JRadioButton rdbtnNormal;
	private ButtonGroup bg;
	private JTextArea textAreaDescripcion;
	private JLabel lblAux1;
	private JLabel lblAux2;
	private JLabel lblAux3;
	private JLabel lbSolicitud;

	/**
	 * Create the frame.
	 */
	public InformeView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit().getImage(InformeView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Solicitud de informe pericial");
		frmAdministracinCoiipa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setBounds(100, 100, 1500, 900);
		frmAdministracinCoiipa.setMinimumSize(new Dimension(1500,900));
		frmAdministracinCoiipa.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmAdministracinCoiipa.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frmAdministracinCoiipa.getRootPane().setDefaultButton(btConfirmar);
		bg = new ButtonGroup();
		rdbtnNormal.setSelected(true);
		bg.add(rdbtnUrgente);
		bg.add(rdbtnNormal);
	}

	public ButtonGroup getButtonGroupUrgencia() {
		return bg;
	}
	
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(2, 2, 0, 0));
			pnCentro.add(getPanelNombre());
			pnCentro.add(getPanelCorreoTel());
			pnCentro.add(getPanelDescripción());
			pnCentro.add(getPanelUrgencia());
		}
		return pnCentro;
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLbSolicitud_1());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(InformeView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtConfirmar());
		}
		return pnInferior;
	}
	public JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar");
			btConfirmar.setFocusable(false);
			btConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btConfirmar.setForeground(Color.WHITE);
			btConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btConfirmar.setBackground(new Color(34, 139, 34));
		}
		return btConfirmar;
	}

	public JFrame getFrame() {
		return frmAdministracinCoiipa;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
	private JPanel getPanelNombre() {
		if (panelNombre == null) {
			panelNombre = new JPanel();
			panelNombre.setBorder(new TitledBorder(null, "Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelNombre.setBackground(Color.WHITE);
			panelNombre.setLayout(new GridLayout(0, 1, 0, 0));
			panelNombre.add(getLblNombre());
			panelNombre.add(getTextFieldNombre());
			panelNombre.add(getLblDni());
			panelNombre.add(getTextFieldDni());
		}
		return panelNombre;
	}
	private JPanel getPanelCorreoTel() {
		if (panelCorreoTel == null) {
			panelCorreoTel = new JPanel();
			panelCorreoTel.setBorder(new TitledBorder(null, "Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCorreoTel.setBackground(Color.WHITE);
			panelCorreoTel.setLayout(new GridLayout(0, 1, 0, 0));
			panelCorreoTel.add(getLblCorreo());
			panelCorreoTel.add(getTextFieldCorreo());
			panelCorreoTel.add(getLblTelefono());
			panelCorreoTel.add(getTextFieldTelefono());
		}
		return panelCorreoTel;
	}
	private JPanel getPanelDescripción() {
		if (panelDescripción == null) {
			panelDescripción = new JPanel();
			panelDescripción.setBackground(Color.WHITE);
			panelDescripción.setLayout(new BorderLayout(20, 50));
			panelDescripción.add(getLblDescripcion(), BorderLayout.NORTH);
			panelDescripción.add(getTextAreaDescripcion());
			panelDescripción.add(getLblAux1(), BorderLayout.WEST);
			panelDescripción.add(getLblAux2(), BorderLayout.EAST);
			panelDescripción.add(getLblAux3(), BorderLayout.SOUTH);
		}
		return panelDescripción;
	}
	private JPanel getPanelUrgencia() {
		if (panelUrgencia == null) {
			panelUrgencia = new JPanel();
			panelUrgencia.setBackground(Color.WHITE);
			panelUrgencia.setLayout(new GridLayout(0, 1, 0, 0));
			panelUrgencia.add(getLblUrgencia());
			panelUrgencia.add(getRdbtnUrgente());
			panelUrgencia.add(getRdbtnNormal());
		}
		return panelUrgencia;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre/Empresa");
			lblNombre.setBorder(new EmptyBorder(12, 0, 0, 0));
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setMaximumSize(new Dimension(200, 50));
			lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblNombre;
	}
	public JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNombre.setMaximumSize(new Dimension(280, 30));
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	private JLabel getLblCorreo() {
		if (lblCorreo == null) {
			lblCorreo = new JLabel("Correo");
			lblCorreo.setBorder(new EmptyBorder(12, 0, 0, 0));
			lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblCorreo.setMaximumSize(new Dimension(200, 50));
			lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorreo.setAlignmentX(0.5f);
		}
		return lblCorreo;
	}
	public JTextField getTextFieldCorreo() {
		if (textFieldCorreo == null) {
			textFieldCorreo = new JTextField();
			textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCorreo.setMaximumSize(new Dimension(280, 30));
			textFieldCorreo.setColumns(10);
		}
		return textFieldCorreo;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setBorder(new EmptyBorder(10, 0, 0, 0));
			lblDescripcion.setMinimumSize(new Dimension(200, 50));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblDescripcion.setMaximumSize(new Dimension(200, 50));
			lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescripcion.setAlignmentX(0.5f);
		}
		return lblDescripcion;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI");
			lblDni.setBorder(new EmptyBorder(12, 0, 0, 0));
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblDni.setMaximumSize(new Dimension(200, 50));
			lblDni.setHorizontalAlignment(SwingConstants.CENTER);
			lblDni.setAlignmentX(0.5f);
		}
		return lblDni;
	}
	public JTextField getTextFieldDni() {
		if (textFieldDni == null) {
			textFieldDni = new JTextField();
			textFieldDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldDni.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDni.setMaximumSize(new Dimension(280, 30));
			textFieldDni.setColumns(10);
		}
		return textFieldDni;
	}
	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Teléfono");
			lblTelefono.setBorder(new EmptyBorder(12, 0, 0, 0));
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblTelefono.setMaximumSize(new Dimension(200, 50));
			lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			lblTelefono.setAlignmentX(0.5f);
		}
		return lblTelefono;
	}
	public JTextField getTextFieldTelefono() {
		if (textFieldTelefono == null) {
			textFieldTelefono = new JTextField();
			textFieldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTelefono.setMaximumSize(new Dimension(280, 30));
			textFieldTelefono.setColumns(10);
		}
		return textFieldTelefono;
	}
	private JLabel getLblUrgencia() {
		if (lblUrgencia == null) {
			lblUrgencia = new JLabel("Urgencia");
			lblUrgencia.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblUrgencia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblUrgencia;
	}
	public JRadioButton getRdbtnUrgente() {
		if (rdbtnUrgente == null) {
			rdbtnUrgente = new JRadioButton("Urgente");
			rdbtnUrgente.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnUrgente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			rdbtnUrgente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnUrgente.setBackground(Color.WHITE);
		}
		return rdbtnUrgente;
	}
	public JRadioButton getRdbtnNormal() {
		if (rdbtnNormal == null) {
			rdbtnNormal = new JRadioButton("Normal");
			rdbtnNormal.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNormal.setFont(new Font("Tahoma", Font.PLAIN, 18));
			rdbtnNormal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnNormal.setBackground(Color.WHITE);
		}
		return rdbtnNormal;
	}
	public JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setFont(new Font("Monospaced", Font.PLAIN, 16));
			textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
			textAreaDescripcion.setMinimumSize(new Dimension(280, 90));
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setMaximumSize(new Dimension(280, 90));
		}
		return textAreaDescripcion;
	}
	private JLabel getLblAux1() {
		if (lblAux1 == null) {
			lblAux1 = new JLabel("                         ");
		}
		return lblAux1;
	}
	private JLabel getLblAux2() {
		if (lblAux2 == null) {
			lblAux2 = new JLabel("                         ");
		}
		return lblAux2;
	}
	private JLabel getLblAux3() {
		if (lblAux3 == null) {
			lblAux3 = new JLabel("                         ");
		}
		return lblAux3;
	}
	private JLabel getLbSolicitud_1() {
		if (lbSolicitud == null) {
			lbSolicitud = new JLabel("Solicitud de informe pericial");
			lbSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
			lbSolicitud.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbSolicitud;
	}
}
