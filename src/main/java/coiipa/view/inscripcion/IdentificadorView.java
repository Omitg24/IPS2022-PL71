package coiipa.view.inscripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import coiipa.view.InscripcionPericialView;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class IdentificadorView {

	private JFrame frmIntroduzcaCredenciales;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnInferior;
	private JLabel lblIntroduzcaId;
	private JButton btnEntrar;
	private JTextField textFieldId;

	private Inscripcion inscripcion;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JLabel lblIniciarSesin;

	/**
	 * Create the frame.
	 */
	public IdentificadorView(Inscripcion ins) {
		initialize(ins);
	}

	private void initialize(Inscripcion ins) {
		frmIntroduzcaCredenciales = new JFrame();
		frmIntroduzcaCredenciales.setTitle("Administración COIIPA - Iniciar sesión");
		frmIntroduzcaCredenciales.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmIntroduzcaCredenciales.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InscripcionPericialView.class.getResource("/images/coiipa_symbol.png")));
		frmIntroduzcaCredenciales.setBounds(100, 100, 800, 450);
		frmIntroduzcaCredenciales.setMinimumSize(new Dimension(800, 450));
		frmIntroduzcaCredenciales.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmIntroduzcaCredenciales.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frmIntroduzcaCredenciales.getRootPane().setDefaultButton(btnEntrar);
		contentPane.add(getPnSuperior_1(), BorderLayout.NORTH);

		inscripcion = ins.getInscripcion();
	} 

	public void reiniciarCampos() {

	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getLblIntroduzcaId());
			pnCentro.add(getTextId());
		}
		return pnCentro;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setVgap(10);
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtnEntrar());
		}
		return pnInferior;
	}

	public JFrame getFrame() {
		return frmIntroduzcaCredenciales;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
	private JLabel getLblIntroduzcaId() {
		if (lblIntroduzcaId == null) {
			lblIntroduzcaId = new JLabel("Introduzca su DNI:");
			lblIntroduzcaId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblIntroduzcaId;
	}
	public JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEntrar.setForeground(Color.WHITE);
			btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnEntrar.setFocusable(false);
			btnEntrar.setBackground(new Color(34, 139, 34));
		}
		return btnEntrar;
	}
	public JTextField getTextId() {
		if (textFieldId == null) {
			MaskFormatter mf = null;
			try {
				mf = new MaskFormatter("########U");
			} catch (ParseException e) {
				System.out.println("Excepción capturada: JFormattedTextField");
			}
			textFieldId = new JFormattedTextField(mf);	
			textFieldId.setPreferredSize(new Dimension(55, 35));
			textFieldId.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldId.setColumns(16);
			textFieldId.setBorder(new LineBorder(new Color(171, 173, 179)));
			textFieldId.setBackground(Color.LIGHT_GRAY);
		}
		return textFieldId;
	}
	public Inscripcion getInscripcion() {
		return inscripcion;
	}
	private JPanel getPnSuperior_1() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLblIniciarSesin_1());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(IdentificadorView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	private JLabel getLblIniciarSesin_1() {
		if (lblIniciarSesin == null) {
			lblIniciarSesin = new JLabel("Iniciar sesión");
			lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
			lblIniciarSesin.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		}
		return lblIniciarSesin;
	}
}
