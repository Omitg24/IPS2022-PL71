package coiipa.view.apertura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
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
 * @author Adrián Alves Morales, UO284288 y David Warzynski Abril, UO278968
 * @version 28 nov 2022
 */
public class ModificacionView {

	private JDialog frmModificacion;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JPanel pnInferior;
	private JButton btListo;
	private JPanel panelInicio;
	private JPanel panelFin;
	private JTextField textFin;
	private JTextField textInicio;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JPanel panelNplazas;
	private JLabel lblNplazas;
	private JTextField textFieldNplazas;
	private JLabel lblIntroduzca;
	private JLabel lblLogo;
	private JLabel lblTitulo;

	/**
	 * Create the frame.
	 */
	public ModificacionView() {
		initialize();
	}

	private void initialize() {
		frmModificacion = new JDialog();
		frmModificacion.setIconImage(Toolkit.getDefaultToolkit().getImage(ModificacionView.class.getResource("/images/coiipa_symbol.png")));
		frmModificacion.setModal(true);
		frmModificacion.setType(Type.POPUP);
		frmModificacion.setTitle("Administracion COIIPA - Establecimiento de plazos");
		frmModificacion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmModificacion.setBounds(100, 100, 800, 450);
		frmModificacion.setMinimumSize(new Dimension(800, 450));
		frmModificacion.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);

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
		textFieldNplazas.setText("");
		textFieldNplazas.setBackground(Color.LIGHT_GRAY);
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(4, 1, 0, 0));
			pnCentro.add(getLblIntroduzca_1());
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
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getLblLogo());
			pnSuperior.add(getLblTitulo());
		}
		return pnSuperior;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
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
			btListo.setFont(new Font("Tahoma", Font.BOLD, 24));
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
			textFin.setHorizontalAlignment(SwingConstants.CENTER);
			textFin.setForeground(Color.WHITE);
			textFin.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			textInicio.setHorizontalAlignment(SwingConstants.CENTER);
			textInicio.setForeground(Color.WHITE);
			textInicio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textInicio.setColumns(10);
			textInicio.setBorder(new LineBorder(new Color(171, 173, 179)));
			textInicio.setBackground(Color.LIGHT_GRAY);
		}
		return textInicio;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Inicio:     ");
			lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblInicio;
	}
	private JLabel getLblFin() {
		if (lblFin == null) {
			lblFin = new JLabel("Fin:        ");
			lblFin.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			lblNplazas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNplazas;
	}
	public JTextField getTextFieldNplazas() {
		if (textFieldNplazas == null) {
			textFieldNplazas = new JTextField();
			textFieldNplazas.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNplazas.setForeground(Color.BLACK);
			textFieldNplazas.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldNplazas.setColumns(10);
			textFieldNplazas.setBorder(new LineBorder(new Color(171, 173, 179)));
			textFieldNplazas.setBackground(Color.LIGHT_GRAY);
		}
		return textFieldNplazas;
	}
	private JLabel getLblIntroduzca_1() {
		if (lblIntroduzca == null) {
			lblIntroduzca = new JLabel("Por favor, introduzca los plazos de inscripción:");
			lblIntroduzca.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroduzca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblIntroduzca;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(ModificacionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lblLogo;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Establecimiento de plazos");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		}
		return lblTitulo;
	}
}
