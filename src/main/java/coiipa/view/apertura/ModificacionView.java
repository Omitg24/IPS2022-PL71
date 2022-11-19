package coiipa.view.apertura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JDialog;
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
public class ModificacionView {

	private JDialog frmModificacion;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JPanel pnInferior;
	private JButton btListo;
	private JLabel lblIntroduzca;
	private JPanel panelInicio;
	private JPanel panelFin;
	private JTextField textFin;
	private JTextField textInicio;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JPanel panelNplazas;
	private JLabel lblNplazas;
	private JTextField textFieldNplazas;

	/**
	 * Create the frame.
	 */
	public ModificacionView() {
		initialize();
	}

	private void initialize() {
		frmModificacion = new JDialog();
		frmModificacion.setModal(true);
		frmModificacion.setType(Type.POPUP);
		frmModificacion.setResizable(false);
		frmModificacion.setTitle("Establecimiento de plazos");
		frmModificacion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmModificacion.setBounds(100, 100, 340, 270);
		frmModificacion.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmModificacion.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frmModificacion.getRootPane().setDefaultButton(btListo);
	}

	public void reiniciarCampos() {
		textInicio.setText("(YYYY-MM-DD)");
		textInicio.setForeground(Color.WHITE);
		textInicio.setBackground(Color.LIGHT_GRAY);
		textFin.setText("(YYYY-MM-DD)");
		textFin.setForeground(Color.WHITE);
		textFin.setBackground(Color.LIGHT_GRAY);
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(3, 1, 0, 0));
			pnCentro.add(getPanelInicio());
			pnCentro.add(getPanelFin());
			pnCentro.add(getPanelNplazas());
		}
		return pnCentro;
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));
			pnSuperior.add(getLblIntroduzca());
		}
		return pnSuperior;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(10);
			flowLayout.setHgap(10);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtListo());
		}
		return pnInferior;
	}
	public JButton getBtListo() {
		if (btListo == null) {
			btListo = new JButton("Listo");
			btListo.setFocusable(false);
			btListo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btListo.setForeground(Color.WHITE);
			btListo.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btListo.setBackground(new Color(34, 139, 34));
		}
		return btListo;
	}

	public JDialog getFrame() {
		return frmModificacion;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
	private JLabel getLblIntroduzca() {
		if (lblIntroduzca == null) {
			lblIntroduzca = new JLabel("Por favor, introduzca los plazos de inscripción:");
		}
		return lblIntroduzca;
	}
	private JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setBackground(Color.WHITE);
			panelInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
			panelInicio.add(getLblInicio());
			panelInicio.add(getTextInicio());
		}
		return panelInicio;
	}
	private JPanel getPanelFin() {
		if (panelFin == null) {
			panelFin = new JPanel();
			panelFin.setBackground(Color.WHITE);
			panelFin.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
			panelFin.add(getLblFin());
			panelFin.add(getTextFin());
		}
		return panelFin;
	}
	public JTextField getTextFin() {
		if (textFin == null) {
			textFin = new JTextField();
			textFin.setText("(YYYY-MM-DD)");
			textFin.setPreferredSize(new Dimension(10, 25));
			textFin.setHorizontalAlignment(SwingConstants.CENTER);
			textFin.setForeground(Color.WHITE);
			textFin.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			textFin.setColumns(10);
			textFin.setBorder(new LineBorder(new Color(171, 173, 179)));
			textFin.setBackground(Color.LIGHT_GRAY);
		}
		return textFin;
	}
	public JTextField getTextInicio() {
		if (textInicio == null) {
			textInicio = new JTextField();
			textInicio.setText("(YYYY-MM-DD)");
			textInicio.setPreferredSize(new Dimension(10, 25));
			textInicio.setHorizontalAlignment(SwingConstants.CENTER);
			textInicio.setForeground(Color.WHITE);
			textInicio.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			textInicio.setColumns(10);
			textInicio.setBorder(new LineBorder(new Color(171, 173, 179)));
			textInicio.setBackground(Color.LIGHT_GRAY);
		}
		return textInicio;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Inicio:     ");
		}
		return lblInicio;
	}
	private JLabel getLblFin() {
		if (lblFin == null) {
			lblFin = new JLabel("Fin:          ");
		}
		return lblFin;
	}
	private JPanel getPanelNplazas() {
		if (panelNplazas == null) {
			panelNplazas = new JPanel();
			panelNplazas.setBackground(Color.WHITE);
			panelNplazas.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
			panelNplazas.add(getLblNplazas());
			panelNplazas.add(getTextFieldNplazas());
		}
		return panelNplazas;
	}
	private JLabel getLblNplazas() {
		if (lblNplazas == null) {
			lblNplazas = new JLabel("Nº plazas:");
		}
		return lblNplazas;
	}
	public JTextField getTextFieldNplazas() {
		if (textFieldNplazas == null) {
			textFieldNplazas = new JTextField();
			textFieldNplazas.setPreferredSize(new Dimension(10, 25));
			textFieldNplazas.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNplazas.setForeground(Color.WHITE);
			textFieldNplazas.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			textFieldNplazas.setColumns(10);
			textFieldNplazas.setBorder(new LineBorder(new Color(171, 173, 179)));
			textFieldNplazas.setBackground(Color.LIGHT_GRAY);
		}
		return textFieldNplazas;
	}
}
