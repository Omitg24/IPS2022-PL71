package lotes.view;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class LotesView {

	private JFrame frmAdministracinCoiipa;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JPanel pnTituloSup;
	private JLabel lbTitulo;
	private JScrollPane scrollPaneCursos;
	private JTable tableCursos;
	private JPanel pnRegistro;
	private JPanel panelTitulacion;
	private JTextField textFieldTitulacion;
	private JPanel panelAlta;
	private JButton btAlta;
	private JLabel lblTitulacion;

	/**
	 * Create the frame.
	 */
	public LotesView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setResizable(false);
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Envío de lotes");
		frmAdministracinCoiipa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setBounds(100, 100, 730, 502);
		frmAdministracinCoiipa.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmAdministracinCoiipa.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
	}

	public void reiniciarCampos() {
		
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getPnRegistro());
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
			lbLogo.setIcon(new ImageIcon(LotesView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBorder(new EmptyBorder(20, 0, 20, 0));
			pnInferior.setSize(new Dimension(0, 200));
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(1, 2, 0, 0));
			pnInferior.add(getPanelTitulacion());
			pnInferior.add(getPanelAlta());
		}
		return pnInferior;
	}
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbTitulo());
		}
		return pnTituloSup;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Envío de lotes");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbTitulo;
	}

	public JFrame getFrame() {
		return frmAdministracinCoiipa;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
	private JScrollPane getScrollPaneCursos() {
		if (scrollPaneCursos == null) {
			scrollPaneCursos = new JScrollPane();
			scrollPaneCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneCursos.setViewportView(getTableColegiados());
		}
		return scrollPaneCursos;
	}
	public JTable getTableColegiados() {
		if (tableCursos == null) {
			tableCursos = new JTable();
			tableCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCursos.setDefaultEditor(Object.class, null);
		}
		return tableCursos;
	}
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setPreferredSize(new Dimension(520, 200));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Listado de solicitudes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getScrollPaneCursos());
		}
		return pnRegistro;
	}
	private JPanel getPanelTitulacion() {
		if (panelTitulacion == null) {
			panelTitulacion = new JPanel();
			panelTitulacion.setBorder(new EmptyBorder(0, 40, 0, 0));
			panelTitulacion.setBackground(Color.WHITE);
			panelTitulacion.add(getLblTitulacion());
			panelTitulacion.add(getTextFieldTitulacion());
		}
		return panelTitulacion;
	}
	public JTextField getTextFieldTitulacion() {
		if (textFieldTitulacion == null) {
			textFieldTitulacion = new JTextField();
			textFieldTitulacion.setEditable(false);
			textFieldTitulacion.setColumns(20);
		}
		return textFieldTitulacion;
	}
	private JPanel getPanelAlta() {
		if (panelAlta == null) {
			panelAlta = new JPanel();
			panelAlta.setBorder(new EmptyBorder(0, 100, 0, 0));
			panelAlta.setBackground(Color.WHITE);
			panelAlta.add(getBtEnviar());
		}
		return panelAlta;
	}
	public JButton getBtEnviar() {
		if (btAlta == null) {
			btAlta = new JButton("Enviar");
			btAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAlta.setForeground(Color.WHITE);
			btAlta.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btAlta.setFocusable(false);
			btAlta.setBackground(new Color(34, 139, 34));
		}
		return btAlta;
	}
	private JLabel getLblTitulacion() {
		if (lblTitulacion == null) {
			lblTitulacion = new JLabel("Titulación: ");
		}
		return lblTitulacion;
	}
}
