package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

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

import coiipa.view.apertura.ModificacionView;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288 y David Warzynski Abril, UO278968
 * @version 28 nov 2022
 */
public class AperturaView {

	private JFrame frmAdministracinCoiipa;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JButton btModificar;
	private JScrollPane scrollPaneCursos;
	private JTable tableCursos;
	private JPanel pnRegistro;

	private ModificacionView modificacion;
	private JLabel lbApertura;

	/**
	 * Create the frame.
	 */
	public AperturaView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit().getImage(AperturaView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Apertura de cursos");
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
		frmAdministracinCoiipa.getRootPane().setDefaultButton(btModificar);

		modificacion = new ModificacionView();
	}

	public void reiniciarCampos() {
		modificacion.reiniciarCampos();
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new BorderLayout(0, 0));
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
			pnSuperior.add(getLbApertura_1());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(AperturaView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtModificar());
		}
		return pnInferior;
	}
	public JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setFocusable(false);
			btModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btModificar.setForeground(Color.WHITE);
			btModificar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btModificar.setBackground(new Color(34, 139, 34));
		}
		return btModificar;
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
			scrollPaneCursos.setViewportView(getTableCursos());
		}
		return scrollPaneCursos;
	}
	public JTable getTableCursos() {
		if (tableCursos == null) {
			tableCursos = new JTable();
			tableCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableCursos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableCursos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableCursos.setRowMargin(5);
			tableCursos.setAutoscrolls(false);
			tableCursos.setFillsViewportHeight(true);
			tableCursos.setRowHeight(30);
			tableCursos.setSelectionForeground(Color.WHITE);
			tableCursos.setSelectionBackground(Color.GRAY);
			tableCursos.setGridColor(SystemColor.windowBorder);
			tableCursos.setName("Tabla de Cursos");
			tableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCursos.setDefaultEditor(Object.class, null);
			tableCursos.setBackground(Color.decode("#f0f0f0"));
		}
		return tableCursos;
	}
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setPreferredSize(new Dimension(670, 200));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de cursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getScrollPaneCursos());
		}
		return pnRegistro;
	}

	public ModificacionView getModificacion() {
		return this.modificacion;
	}
	private JLabel getLbApertura_1() {
		if (lbApertura == null) {
			lbApertura = new JLabel("Apertura de cursos");
			lbApertura.setHorizontalAlignment(SwingConstants.CENTER);
			lbApertura.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbApertura;
	}
}
