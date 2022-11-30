package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import coiipa.view.apertura.ModificacionView;

/**
 * Título: Clase PericialesView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 18 nov 2022
 */
public class PericialesView {

	private JFrame frmAdministracinCoiipa;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;

	private ModificacionView modificacion;
	private JPanel pnFiltros;
	private JPanel panelFecha;
	private JLabel lblFecha;
	private JSpinner spnFecha;
	private JPanel panelAnulado;
	private JCheckBox chckbxAnulado;
	private JPanel panelNoRealizado;
	private JCheckBox chckbxNoRealizado;
	private JPanel panelRealizado;
	private JCheckBox chckbxRealizado;
	private JPanel panelPerito;
	private JLabel lblPerito;
	private JTextField txtPerito;
	private JScrollPane scrollPanePeritos;
	private JTable tablePeritos;
	private JLabel lbApertura;

	/**
	 * Create the frame.
	 */
	public PericialesView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit().getImage(PericialesView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Listado de peritos");
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
			pnCentro.add(getPnFiltros(), BorderLayout.NORTH);
			pnCentro.add(getScrollPanePeritos(), BorderLayout.CENTER);
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

	public JFrame getFrame() {
		return frmAdministracinCoiipa;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}

	public ModificacionView getModificacion() {
		return this.modificacion;
	}
	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new GridLayout(1, 5, 0, 0));
			pnFiltros.add(getPanelFecha());
			pnFiltros.add(getPanelAnulado());
			pnFiltros.add(getPanelNoRealizado());
			pnFiltros.add(getPanelRealizado());
			pnFiltros.add(getPanelPerito());
		}
		return pnFiltros;
	}
	private JPanel getPanelFecha() {
		if (panelFecha == null) {
			panelFecha = new JPanel();
			panelFecha.setBackground(Color.WHITE);
			panelFecha.add(getLblFecha());
			panelFecha.add(getSpnFecha());
		}
		return panelFecha;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha:");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblFecha;
	}
	public JSpinner getSpnFecha() {
		if (spnFecha == null) {
			spnFecha = new JSpinner();
			spnFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
			spnFecha.setPreferredSize(new Dimension(100, 20));
			spnFecha.setMinimumSize(new Dimension(1000, 20));
			spnFecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return spnFecha;
	}
	private JPanel getPanelAnulado() {
		if (panelAnulado == null) {
			panelAnulado = new JPanel();
			panelAnulado.setBackground(Color.WHITE);
			panelAnulado.add(getChckbxAnulado());
		}
		return panelAnulado;
	}
	public JCheckBox getChckbxAnulado() {
		if (chckbxAnulado == null) {
			chckbxAnulado = new JCheckBox("Anulado");
			chckbxAnulado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxAnulado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			chckbxAnulado.setBackground(Color.WHITE);
		}
		return chckbxAnulado;
	}
	private JPanel getPanelNoRealizado() {
		if (panelNoRealizado == null) {
			panelNoRealizado = new JPanel();
			panelNoRealizado.setBackground(Color.WHITE);
			panelNoRealizado.add(getChckbxNoRealizado());
		}
		return panelNoRealizado;
	}
	public JCheckBox getChckbxNoRealizado() {
		if (chckbxNoRealizado == null) {
			chckbxNoRealizado = new JCheckBox("No realizado");
			chckbxNoRealizado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxNoRealizado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			chckbxNoRealizado.setBackground(Color.WHITE);
		}
		return chckbxNoRealizado;
	}
	private JPanel getPanelRealizado() {
		if (panelRealizado == null) {
			panelRealizado = new JPanel();
			panelRealizado.setBackground(Color.WHITE);
			panelRealizado.add(getChckbxRealizado());
		}
		return panelRealizado;
	}
	public JCheckBox getChckbxRealizado() {
		if (chckbxRealizado == null) {
			chckbxRealizado = new JCheckBox("Realizado");
			chckbxRealizado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chckbxRealizado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			chckbxRealizado.setBackground(Color.WHITE);
		}
		return chckbxRealizado;
	}
	private JPanel getPanelPerito() {
		if (panelPerito == null) {
			panelPerito = new JPanel();
			panelPerito.setBackground(Color.WHITE);
			panelPerito.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelPerito.add(getLblPerito());
			panelPerito.add(getTxtPerito());
		}
		return panelPerito;
	}
	private JLabel getLblPerito() {
		if (lblPerito == null) {
			lblPerito = new JLabel("Nombre:");
			lblPerito.setHorizontalAlignment(SwingConstants.CENTER);
			lblPerito.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblPerito;
	}
	public JTextField getTxtPerito() {
		if (txtPerito == null) {
			txtPerito = new JTextField();
			txtPerito.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtPerito.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtPerito.setColumns(10);
		}
		return txtPerito;
	}
	private JScrollPane getScrollPanePeritos() {
		if (scrollPanePeritos == null) {
			scrollPanePeritos = new JScrollPane();
			scrollPanePeritos.setBackground(Color.WHITE);
			scrollPanePeritos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de peritos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPanePeritos.setViewportView(getTablePeritos());
		}
		return scrollPanePeritos;
	}
	public JTable getTablePeritos() {
		if (tablePeritos == null) {
			tablePeritos = new JTable();
			tablePeritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tablePeritos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tablePeritos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tablePeritos.setRowMargin(5);
			tablePeritos.setAutoscrolls(false);
			tablePeritos.setFillsViewportHeight(true);
			tablePeritos.setRowHeight(30);
			tablePeritos.setSelectionForeground(Color.WHITE);
			tablePeritos.setSelectionBackground(Color.GRAY);
			tablePeritos.setGridColor(SystemColor.windowBorder);
			tablePeritos.setName("Tabla de Peritos");
			tablePeritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePeritos.setDefaultEditor(Object.class, null);
			tablePeritos.setBackground(Color.decode("#f0f0f0"));
		}
		return tablePeritos;
	}
	private JLabel getLbApertura_1() {
		if (lbApertura == null) {
			lbApertura = new JLabel("Listado de peritos");
			lbApertura.setHorizontalAlignment(SwingConstants.CENTER);
			lbApertura.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbApertura;
	}
}
