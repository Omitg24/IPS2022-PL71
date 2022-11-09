package informepericial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

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
	private JPanel pnTituloSup;
	private JLabel lbSolicitud;
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

	/**
	 * Create the frame.
	 */
	public InformeView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setResizable(false);
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Solicitud de informe pericial");
		frmAdministracinCoiipa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setBounds(100, 100, 778, 502);
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
			pnSuperior.add(getPnTituloSup());
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
			flowLayout.setVgap(40);
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
			btConfirmar.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btConfirmar.setBackground(new Color(34, 139, 34));
		}
		return btConfirmar;
	}
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbSolicitud());
		}
		return pnTituloSup;
	}
	private JLabel getLbSolicitud() {
		if (lbSolicitud == null) {
			lbSolicitud = new JLabel("Solicitud de informe pericial");
			lbSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
			lbSolicitud.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		}
		return lbSolicitud;
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
			panelNombre.setBackground(Color.WHITE);
			panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.Y_AXIS));
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
			panelCorreoTel.setBackground(Color.WHITE);
			panelCorreoTel.setLayout(new BoxLayout(panelCorreoTel, BoxLayout.Y_AXIS));
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
			panelDescripción.setLayout(new BoxLayout(panelDescripción, BoxLayout.Y_AXIS));
			panelDescripción.add(getLblDescripcion());
			panelDescripción.add(getTextAreaDescripcion());
		}
		return panelDescripción;
	}
	private JPanel getPanelUrgencia() {
		if (panelUrgencia == null) {
			panelUrgencia = new JPanel();
			panelUrgencia.setBackground(Color.WHITE);
			panelUrgencia.setLayout(new BoxLayout(panelUrgencia, BoxLayout.Y_AXIS));
			panelUrgencia.add(getLblUrgencia());
			panelUrgencia.add(getRdbtnUrgente());
			panelUrgencia.add(getRdbtnNormal());
		}
		return panelUrgencia;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre/Empresa");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setMaximumSize(new Dimension(200, 30));
			lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblNombre;
	}
	public JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNombre.setMaximumSize(new Dimension(280, 30));
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	private JLabel getLblCorreo() {
		if (lblCorreo == null) {
			lblCorreo = new JLabel("Correo");
			lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCorreo.setMaximumSize(new Dimension(200, 30));
			lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorreo.setAlignmentX(0.5f);
		}
		return lblCorreo;
	}
	public JTextField getTextFieldCorreo() {
		if (textFieldCorreo == null) {
			textFieldCorreo = new JTextField();
			textFieldCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCorreo.setMaximumSize(new Dimension(280, 30));
			textFieldCorreo.setColumns(10);
		}
		return textFieldCorreo;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setMinimumSize(new Dimension(200, 30));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDescripcion.setMaximumSize(new Dimension(200, 30));
			lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescripcion.setAlignmentX(0.5f);
		}
		return lblDescripcion;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI");
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDni.setMaximumSize(new Dimension(200, 30));
			lblDni.setHorizontalAlignment(SwingConstants.CENTER);
			lblDni.setAlignmentX(0.5f);
		}
		return lblDni;
	}
	public JTextField getTextFieldDni() {
		if (textFieldDni == null) {
			textFieldDni = new JTextField();
			textFieldDni.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDni.setMaximumSize(new Dimension(280, 30));
			textFieldDni.setColumns(10);
		}
		return textFieldDni;
	}
	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Teléfono");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTelefono.setMaximumSize(new Dimension(200, 30));
			lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			lblTelefono.setAlignmentX(0.5f);
		}
		return lblTelefono;
	}
	public JTextField getTextFieldTelefono() {
		if (textFieldTelefono == null) {
			textFieldTelefono = new JTextField();
			textFieldTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTelefono.setMaximumSize(new Dimension(280, 30));
			textFieldTelefono.setColumns(10);
		}
		return textFieldTelefono;
	}
	private JLabel getLblUrgencia() {
		if (lblUrgencia == null) {
			lblUrgencia = new JLabel("Urgencia");
			lblUrgencia.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUrgencia.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblUrgencia.setBorder(new EmptyBorder(32, 48, 0, 0));
			lblUrgencia.setMaximumSize(new Dimension(180, 48));
			lblUrgencia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblUrgencia;
	}
	public JRadioButton getRdbtnUrgente() {
		if (rdbtnUrgente == null) {
			rdbtnUrgente = new JRadioButton("Urgente");
			rdbtnUrgente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnUrgente.setMaximumSize(new Dimension(100, 23));
			rdbtnUrgente.setBackground(Color.WHITE);
		}
		return rdbtnUrgente;
	}
	public JRadioButton getRdbtnNormal() {
		if (rdbtnNormal == null) {
			rdbtnNormal = new JRadioButton("Normal");
			rdbtnNormal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnNormal.setMaximumSize(new Dimension(100, 23));
			rdbtnNormal.setBackground(Color.WHITE);
		}
		return rdbtnNormal;
	}
	public JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
			textAreaDescripcion.setMinimumSize(new Dimension(280, 90));
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setMaximumSize(new Dimension(280, 90));
		}
		return textAreaDescripcion;
	}
}
