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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * Título: Clase AsignacionVisadorView
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class AsignacionVisadorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frmAdministracinCoiipa;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnCentro;
	private JPanel pnVisadores;
	private JScrollPane sPVisadores;
	private JTable tbVisadores;
	private JPanel pnVisados;
	private JScrollPane sPVisados;
	private JTable tbVisados;
	private JPanel pnInferior;
	private JButton btAsignar;
	private JLabel lbAsignacion;

	/**
	 * Create the frame.
	 */
	public AsignacionVisadorView() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setBounds(100,100,1500,900);
		frmAdministracinCoiipa.setMinimumSize(new Dimension(1500,900));
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Asignación de visadores");
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InscripcionPericialView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);

		frmAdministracinCoiipa.setContentPane(contentPane);

	}

	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLbAsignacion_1());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(AsignacionVisadorView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(0, 2, 0, 0));
			pnCentro.add(getPnVisados());
			pnCentro.add(getPnVisadores());

		}
		return pnCentro;
	}
	private JPanel getPnVisadores() {
		if (pnVisadores == null) {
			pnVisadores = new JPanel();
			pnVisadores.setBorder(new TitledBorder(null, "Lista de visadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnVisadores.setBackground(Color.WHITE);
			pnVisadores.setLayout(new BorderLayout(0, 0));
			pnVisadores.add(getSPVisadores());
		}
		return pnVisadores;
	}
	private JScrollPane getSPVisadores() {
		if (sPVisadores == null) {
			sPVisadores = new JScrollPane();
			sPVisadores.setBackground(Color.WHITE);
			sPVisadores.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPVisadores.setViewportView(getTbVisadores());
		}
		return sPVisadores;
	}
	private JTable getTbVisadores() {
		if (tbVisadores == null) {
			tbVisadores = new JTable();
			tbVisadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbVisadores.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tbVisadores.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbVisadores.setRowMargin(5);
			tbVisadores.setAutoscrolls(false);
			tbVisadores.setFillsViewportHeight(true);
			tbVisadores.setRowHeight(30);
			tbVisadores.setSelectionForeground(Color.WHITE);
			tbVisadores.setSelectionBackground(Color.GRAY);
			tbVisadores.setGridColor(SystemColor.windowBorder);
			tbVisadores.setName("Tabla de Visadores");
			tbVisadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbVisadores.setDefaultEditor(Object.class, null);
			tbVisadores.setBackground(Color.decode("#f0f0f0"));
		}
		return tbVisadores;
	}
	private JPanel getPnVisados() {
		if (pnVisados == null) {
			pnVisados = new JPanel();
			pnVisados.setBorder(new TitledBorder(null, "Lista de solicitudes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnVisados.setBackground(Color.WHITE);
			pnVisados.setLayout(new BorderLayout(0, 0));
			pnVisados.add(getSPVisados());
		}
		return pnVisados;
	}
	private JScrollPane getSPVisados() {
		if (sPVisados == null) {
			sPVisados = new JScrollPane();
			sPVisados.setBackground(Color.WHITE);
			sPVisados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sPVisados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPVisados.setViewportView(getTbVisados());
		}
		return sPVisados;
	}
	private JTable getTbVisados() {
		if (tbVisados == null) {
			tbVisados = new JTable();
			tbVisados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbVisados.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tbVisados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbVisados.setRowMargin(5);
			tbVisados.setAutoscrolls(false);
			tbVisados.setFillsViewportHeight(true);
			tbVisados.setRowHeight(30);
			tbVisados.setSelectionForeground(Color.WHITE);
			tbVisados.setSelectionBackground(Color.GRAY);
			tbVisados.setGridColor(SystemColor.windowBorder);
			tbVisados.setName("Tabla de Visados");
			tbVisados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbVisados.setDefaultEditor(Object.class, null);
			tbVisados.setBackground(Color.decode("#f0f0f0"));
		}
		return tbVisados;
	}
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtAsignar());
		}
		return pnInferior;
	}
	private JButton getBtAsignar() {
		if (btAsignar == null) {
			btAsignar = new JButton("Asignar");
			btAsignar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAsignar.setForeground(Color.WHITE);
			btAsignar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btAsignar.setBackground(new Color(0, 128, 0));
		}
		return btAsignar;
	}
	
	public JFrame getFrame() {
		return this.frmAdministracinCoiipa;
	}
	
	public JTable getTableVisados() {
		return this.tbVisados;
	}
	
	public JTable getTableVisadores() {
		return this.tbVisadores;
	}
	public JButton getAsignar() {
		return this.btAsignar;
	}
	private JLabel getLbAsignacion_1() {
		if (lbAsignacion == null) {
			lbAsignacion = new JLabel("Asignación de visadores");
			lbAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
			lbAsignacion.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbAsignacion;
	}
}
