package asignacionpericial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import inscripcionpericial.view.InscripcionPericialView;
import javax.swing.border.TitledBorder;

public class AsignacionPericialView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnTituloSup;
	private JLabel lbAsignacion;
	private JPanel pnCentro;
	private JPanel pnInformes;
	private JScrollPane sPInformes;
	private JTable tbInformes;
	private JPanel pnPeritos;
	private JScrollPane sPPeritos;
	private JTable tbPeritos;
	private JPanel pnInferior;
	private JButton btAsignar;

	/**
	 * Create the frame.
	 */
	public AsignacionPericialView() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1200, 800));
		frame.setSize(new Dimension(1200, 800));
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Asignación Pericial");
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InscripcionPericialView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);

		frame.setContentPane(contentPane);

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
			lbLogo.setIcon(new ImageIcon(AsignacionPericialView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbAsignacion());
		}
		return pnTituloSup;
	}
	private JLabel getLbAsignacion() {
		if (lbAsignacion == null) {
			lbAsignacion = new JLabel("Asignación Peritos");
			lbAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
			lbAsignacion.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbAsignacion;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getPnInformes());
			pnCentro.add(getPnPeritos());
		}
		return pnCentro;
	}
	private JPanel getPnInformes() {
		if (pnInformes == null) {
			pnInformes = new JPanel();
			pnInformes.setBackground(Color.WHITE);
			pnInformes.add(getSPInformes());
		}
		return pnInformes;
	}
	private JScrollPane getSPInformes() {
		if (sPInformes == null) {
			sPInformes = new JScrollPane();
			sPInformes.setBackground(Color.WHITE);
			sPInformes.setPreferredSize(new Dimension(700, 425));
			sPInformes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Informes periciales no asignados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			sPInformes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sPInformes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPInformes.setViewportView(getTbInformes());
		}
		return sPInformes;
	}
	private JTable getTbInformes() {
		if (tbInformes == null) {
			tbInformes = new JTable();
			tbInformes.setBackground(Color.WHITE);
			tbInformes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbInformes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbInformes.setDefaultEditor(Object.class, null);
		}
		return tbInformes;
	}
	private JPanel getPnPeritos() {
		if (pnPeritos == null) {
			pnPeritos = new JPanel();
			pnPeritos.setBackground(Color.WHITE);
			pnPeritos.add(getSPPeritos());
		}
		return pnPeritos;
	}
	private JScrollPane getSPPeritos() {
		if (sPPeritos == null) {
			sPPeritos = new JScrollPane();
			sPPeritos.setBackground(Color.WHITE);
			sPPeritos.setPreferredSize(new Dimension(300, 425));
			sPPeritos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Peritos sin asignaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			sPPeritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sPPeritos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPPeritos.setViewportView(getTbPeritos());
		}
		return sPPeritos;
	}
	private JTable getTbPeritos() {
		if (tbPeritos == null) {
			tbPeritos = new JTable();
			tbPeritos.setBackground(Color.WHITE);
			tbPeritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbPeritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbPeritos.setDefaultEditor(Object.class, null);
		}
		return tbPeritos;
	}
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setVgap(50);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtAsignar());
		}
		return pnInferior;
	}
	private JButton getBtAsignar() {
		if (btAsignar == null) {
			btAsignar = new JButton("Asignar");
			btAsignar.setForeground(Color.WHITE);
			btAsignar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btAsignar.setBackground(new Color(0, 128, 0));
		}
		return btAsignar;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public JTable getTablePeritos() {
		return this.tbPeritos;
	}
	
	public JTable getTableInformes() {
		return this.tbInformes;
	}
	public JButton getAsignar() {
		return this.btAsignar;
	}
}
