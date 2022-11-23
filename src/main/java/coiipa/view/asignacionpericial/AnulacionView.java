package coiipa.view.asignacionpericial;

import javax.swing.JDialog;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AnulacionView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JDialog frame;
	private JPanel contentPane;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnCentral;
	private JLabel lblAnularAsignaciones;
	private JPanel pnInferior;
	private JButton btnConfirmar;
	private JLabel lblMotivo;
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public AnulacionView() {		
		initialize();		
	}
	
	private void initialize() {
		frame = new JDialog();
		frame.setModal(true);
		frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 425, 330);
		frame.setLocationRelativeTo(null);		
		frame.setTitle("Anular asignaciones");
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		
		frame.setContentPane(contentPane);
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLblAnularAsignaciones());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(AnulacionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			GridBagLayout gbl_pnCentral = new GridBagLayout();
			gbl_pnCentral.columnWidths = new int[]{684, 0};
			gbl_pnCentral.rowHeights = new int[] {125, 250};
			gbl_pnCentral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_pnCentral.rowWeights = new double[]{0.0, 0.0};
			pnCentral.setLayout(gbl_pnCentral);
			GridBagConstraints gbc_lblMotivo = new GridBagConstraints();
			gbc_lblMotivo.fill = GridBagConstraints.BOTH;
			gbc_lblMotivo.insets = new Insets(0, 0, 5, 0);
			gbc_lblMotivo.gridx = 0;
			gbc_lblMotivo.gridy = 0;
			pnCentral.add(getLblMotivo(), gbc_lblMotivo);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 0;
			gbc_textArea.gridy = 1;
			pnCentral.add(getTextArea(), gbc_textArea);
		}
		return pnCentral;
	}
	private JLabel getLblAnularAsignaciones() {
		if (lblAnularAsignaciones == null) {
			lblAnularAsignaciones = new JLabel("Anular asignaciones");
			lblAnularAsignaciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnularAsignaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
		}
		return lblAnularAsignaciones;
	}
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.add(getBtnConfirmar());
		}
		return pnInferior;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setPreferredSize(new Dimension(170, 35));
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnConfirmar.setBackground(new Color(34, 139, 34));
		}
		return btnConfirmar;
	}
	private JLabel getLblMotivo() {
		if (lblMotivo == null) {
			lblMotivo = new JLabel("Motivo");
			lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblMotivo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblMotivo;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
