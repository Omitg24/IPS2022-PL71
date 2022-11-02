package inscripcion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	private JPanel pnSuperior;
	private JPanel pnInferior;
	private JLabel lblIntroduzcaId;
	private JButton btnEntrar;
	private JTextField textFieldId;

	private Inscripcion inscripcion;

	/**
	 * Create the frame.
	 */
	public IdentificadorView(Inscripcion ins) {
		initialize(ins);
	}

	private void initialize(Inscripcion ins) {
		frmIntroduzcaCredenciales = new JFrame();
		frmIntroduzcaCredenciales.setResizable(false);
		frmIntroduzcaCredenciales.setTitle("Administración COIIPA");
		frmIntroduzcaCredenciales.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmIntroduzcaCredenciales.setBounds(100, 100, 380, 200);
		frmIntroduzcaCredenciales.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmIntroduzcaCredenciales.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);

		inscripcion = ins.getInscripcion();
	} 

	public void reiniciarCampos() {

	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getTextId());
		}
		return pnCentro;
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnSuperior.getLayout();
			flowLayout.setVgap(12);
			flowLayout.setHgap(0);
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
			pnSuperior.add(getLblIntroduzcaId());
		}
		return pnSuperior;
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
		}
		return lblIntroduzcaId;
	}
	public JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEntrar.setForeground(Color.WHITE);
			btnEntrar.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btnEntrar.setFocusable(false);
			btnEntrar.setBackground(new Color(34, 139, 34));
		}
		return btnEntrar;
	}
	public JTextField getTextId() {
		if (textFieldId == null) {
			textFieldId = new JTextField();
			textFieldId.setPreferredSize(new Dimension(55, 35));
			textFieldId.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldId.setFont(new Font("High Tower Text", Font.PLAIN, 17));
			textFieldId.setColumns(16);
			textFieldId.setBorder(new LineBorder(new Color(171, 173, 179)));
			textFieldId.setBackground(Color.LIGHT_GRAY);
		}
		return textFieldId;
	}
	public Inscripcion getInscripcion() {
		return inscripcion;
	}
}
