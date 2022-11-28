package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
 * Título: Clase AsignacionPericialView
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 23 nov 2022
 */
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
	private JPanel pnInferior;
	private JButton btAsignar;
	private JPanel pnAsignacion;
	private JPanel pnAsignaciones;
	private JPanel pnPeritos;
	private JPanel pnInformes;
	private JScrollPane sPInformes;
	private JScrollPane sPPeritos;
	private JScrollPane sPAsignaciones;
	private JButton btAnular;
	private JTable tbInformes;
	private JTable tbPeritos;
	private JTable tbAsignaciones;
	private JPanel pnAsignar;
	private JPanel pnAnular;	

	/**
	 * Create the frame.
	 */
	public AsignacionPericialView() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1200, 800));
		frame.setSize(new Dimension(1500, 800));
		frame.setMinimumSize(new Dimension(1500,1000));
		frame.setResizable(true);
		frame.setTitle("Administración COIIPA - Gestion de Asignaciones Periciales");
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
			lbAsignacion = new JLabel("Gestion de Asignaciones Periciales");
			lbAsignacion.setHorizontalAlignment(SwingConstants.CENTER);
			lbAsignacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 60));
		}
		return lbAsignacion;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(2, 1, 0, 0));
			pnCentro.add(getPnAsignacion());
			pnCentro.add(getPnAsignaciones());
		}
		return pnCentro;
	}
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(1, 2, 0, 0));
			pnInferior.add(getPnAsignar());
			pnInferior.add(getPnAnular());
		}
		return pnInferior;
	}
	private JPanel getPnAsignar() {
		if (pnAsignar == null) {
			pnAsignar = new JPanel();
			pnAsignar.add(getBtAsignar());
		}
		return pnAsignar;
	}
	private JPanel getPnAnular() {
		if (pnAnular == null) {
			pnAnular = new JPanel();
			pnAnular.add(getBtAnular());
		}
		return pnAnular;
	}
	
	
	private JButton getBtAsignar() {
		if (btAsignar == null) {
			btAsignar = new JButton("Asignar");
			btAsignar.setForeground(Color.WHITE);
			btAsignar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btAsignar.setBackground(new Color(0, 128, 0));
		}
		return btAsignar;
	}
	
	private JButton getBtAnular() {
		if (btAnular == null) {
			btAnular = new JButton("Anular");
			btAnular.setForeground(Color.WHITE);
			btAnular.setFont(new Font("Tahoma", Font.BOLD, 24));
			btAnular.setBackground(new Color(0, 128, 0));
		}
		return btAnular;
	}
	

	private JPanel getPnAsignacion() {
		if (pnAsignacion == null) {
			pnAsignacion = new JPanel();
			GridBagLayout gbl_pnAsignacion = new GridBagLayout();
			gbl_pnAsignacion.columnWidths = new int[] {982, 491};
			gbl_pnAsignacion.rowHeights = new int[] {290, 0};
			gbl_pnAsignacion.columnWeights = new double[]{0.0, 0.0};
			gbl_pnAsignacion.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnAsignacion.setLayout(gbl_pnAsignacion);
			GridBagConstraints gbc_pnInformes = new GridBagConstraints();
			gbc_pnInformes.fill = GridBagConstraints.BOTH;
			gbc_pnInformes.insets = new Insets(0, 0, 0, 5);
			gbc_pnInformes.gridx = 0;
			gbc_pnInformes.gridy = 0;
			pnAsignacion.add(getPnInformes(), gbc_pnInformes);
			GridBagConstraints gbc_pnPeritos = new GridBagConstraints();
			gbc_pnPeritos.fill = GridBagConstraints.BOTH;
			gbc_pnPeritos.gridx = 1;
			gbc_pnPeritos.gridy = 0;
			pnAsignacion.add(getPnPeritos(), gbc_pnPeritos);
		}
		return pnAsignacion;
	}
	private JPanel getPnAsignaciones() {
		if (pnAsignaciones == null) {
			pnAsignaciones = new JPanel();
			pnAsignaciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Asignaciones realizadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnAsignaciones.setLayout(new BorderLayout(0, 0));
			pnAsignaciones.add(getSPAsignaciones(), BorderLayout.CENTER);
		}
		return pnAsignaciones;
	}
	private JPanel getPnPeritos() {
		if (pnPeritos == null) {
			pnPeritos = new JPanel();
			pnPeritos.setBackground(Color.WHITE);
			pnPeritos.setLayout(new BorderLayout(0, 0));
			pnPeritos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Peritos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPeritos.add(getSPPeritos(), BorderLayout.CENTER);
		}
		return pnPeritos;
	}
	private JPanel getPnInformes() {
		if (pnInformes == null) {
			pnInformes = new JPanel();
			pnInformes.setLayout(new BorderLayout(0, 0));
			pnInformes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Informes periciales no asignados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnInformes.add(getSPInformes());
		}
		return pnInformes;
	}
	private JScrollPane getSPInformes() {
		if (sPInformes == null) {
			sPInformes = new JScrollPane();
			sPInformes.setPreferredSize(new Dimension(700, 425));
			sPInformes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);			
			sPInformes.setBackground(Color.WHITE);
			sPInformes.setViewportView(getTbInformes());
		}
		return sPInformes;
	}
	private JScrollPane getSPPeritos() {
		if (sPPeritos == null) {
			sPPeritos = new JScrollPane();
			sPPeritos.setPreferredSize(new Dimension(300, 425));
			sPPeritos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);			
			sPPeritos.setBackground(Color.WHITE);
			sPPeritos.setViewportView(getTbPeritos());
		}
		return sPPeritos;
	}
	private JScrollPane getSPAsignaciones() {
		if (sPAsignaciones == null) {
			sPAsignaciones = new JScrollPane();
			sPAsignaciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);			
			sPAsignaciones.setBackground(Color.WHITE);
			sPAsignaciones.setViewportView(getTbAsignaciones());
		}
		return sPAsignaciones;
	}
	

	private JTable getTbInformes() {
		if (tbInformes == null) {
			tbInformes = new JTable();			
			tbInformes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbInformes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbInformes.setRowMargin(5);
			tbInformes.setAutoscrolls(false);
			tbInformes.setFillsViewportHeight(true);
			tbInformes.setRowHeight(30);
			tbInformes.setSelectionForeground(Color.WHITE);
			tbInformes.setSelectionBackground(Color.GRAY);
			tbInformes.setGridColor(SystemColor.windowBorder);
			tbInformes.setName("Tabla de Informes");
			tbInformes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbInformes.setDefaultEditor(Object.class, null);
			tbInformes.setBackground(Color.decode("#f0f0f0"));
		}
		return tbInformes;
	}
	
	
	private JTable getTbPeritos() {
		if (tbPeritos == null) {
			tbPeritos = new JTable();			
			tbPeritos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbPeritos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbPeritos.setRowMargin(5);
			tbPeritos.setAutoscrolls(false);
			tbPeritos.setFillsViewportHeight(true);
			tbPeritos.setRowHeight(30);
			tbPeritos.setSelectionForeground(Color.WHITE);
			tbPeritos.setSelectionBackground(Color.GRAY);
			tbPeritos.setGridColor(SystemColor.windowBorder);
			tbPeritos.setName("Tabla de Peritos");
			tbPeritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbPeritos.setDefaultEditor(Object.class, null);
			tbPeritos.setBackground(Color.decode("#f0f0f0"));
		}
		return tbPeritos;
	}
	
	
	private JTable getTbAsignaciones() {
		if (tbAsignaciones == null) {
			tbAsignaciones = new JTable();			
			tbAsignaciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbAsignaciones.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbAsignaciones.setRowMargin(5);
			tbAsignaciones.setAutoscrolls(false);
			tbAsignaciones.setFillsViewportHeight(true);
			tbAsignaciones.setRowHeight(30);
			tbAsignaciones.setSelectionForeground(Color.WHITE);
			tbAsignaciones.setSelectionBackground(Color.GRAY);
			tbAsignaciones.setGridColor(SystemColor.windowBorder);
			tbAsignaciones.setName("Tabla de Asignaciones");
			tbAsignaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbAsignaciones.setDefaultEditor(Object.class, null);
			tbAsignaciones.setBackground(Color.decode("#f0f0f0"));
		}
		return tbAsignaciones;
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
	
	public JTable getTableAsignaciones() {
		return this.tbAsignaciones;
	}
	
	public JButton getAsignar() {
		return this.btAsignar;
	}
	
	public JButton getAnular() {
		return this.btAnular;
	}	
}
