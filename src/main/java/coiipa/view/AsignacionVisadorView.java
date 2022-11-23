package coiipa.view;

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
	private JFrame frame;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnTituloSup;
	private JLabel lbAsignacion;
	private JPanel pnCentro;
	private JPanel pnVisadores;
	private JScrollPane sPVisadores;
	private JTable tbVisadores;
	private JPanel pnVisados;
	private JScrollPane sPVisados;
	private JTable tbVisados;
	private JPanel pnInferior;
	private JButton btAsignar;

	/**
	 * Create the frame.
	 */
	public AsignacionVisadorView() {
		frame = new JFrame();
		frame.setBounds(100,100,1500,800);
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Asignación Visador");
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
			lbLogo.setIcon(new ImageIcon(AsignacionVisadorView.class.getResource("/images/coiipa_logo.jpg")));
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
			lbAsignacion = new JLabel("Asignación Visadores");
			lbAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
			lbAsignacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
		}
		return lbAsignacion;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
			pnCentro.add(getPnVisadores());
			pnCentro.add(getPnVisados());
		}
		return pnCentro;
	}
	private JPanel getPnVisadores() {
		if (pnVisadores == null) {
			pnVisadores = new JPanel();
			pnVisadores.setBackground(Color.WHITE);
			pnVisadores.add(getSPVisadores());
		}
		return pnVisadores;
	}
	private JScrollPane getSPVisadores() {
		if (sPVisadores == null) {
			sPVisadores = new JScrollPane();
			sPVisadores.setBackground(Color.WHITE);
			sPVisadores.setPreferredSize(new Dimension(500, 425));
			sPVisadores.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista visadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			sPVisadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sPVisadores.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPVisadores.setViewportView(getTbVisadores());
		}
		return sPVisadores;
	}
	private JTable getTbVisadores() {
		if (tbVisadores == null) {
			tbVisadores = new JTable();
			tbVisadores.setBackground(Color.WHITE);
			tbVisadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbVisadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbVisadores.setDefaultEditor(Object.class, null);
		}
		return tbVisadores;
	}
	private JPanel getPnVisados() {
		if (pnVisados == null) {
			pnVisados = new JPanel();
			pnVisados.setBackground(Color.WHITE);
			pnVisados.add(getSPVisados());
		}
		return pnVisados;
	}
	private JScrollPane getSPVisados() {
		if (sPVisados == null) {
			sPVisados = new JScrollPane();
			sPVisados.setBackground(Color.WHITE);
			sPVisados.setPreferredSize(new Dimension(500, 425));
			sPVisados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Solicitudes de visado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			sPVisados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sPVisados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPVisados.setViewportView(getTbVisados());
		}
		return sPVisados;
	}
	private JTable getTbVisados() {
		if (tbVisados == null) {
			tbVisados = new JTable();
			tbVisados.setBackground(Color.WHITE);
			tbVisados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbVisados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbVisados.setDefaultEditor(Object.class, null);
		}
		return tbVisados;
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
	
	public JTable getTableVisados() {
		return this.tbVisados;
	}
	
	public JTable getTableVisadores() {
		return this.tbVisadores;
	}
	public JButton getAsignar() {
		return this.btAsignar;
	}
}
