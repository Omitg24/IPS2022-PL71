package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Título: Clase InscritosView
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritosView {
	
	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JPanel pnTituloSup;
	private JLabel lbPlan;
	private JTable tbInscritos;
	private JScrollPane scListaInscritos;
	private JPanel pnInscritos;
	private JPanel pnCursos;
	private JScrollPane scCursos;
	private JTable tbCursos;
	private JPanel pnEspera;
	private JScrollPane scListaEspera;
	private JTable tbEspera;
	private JLabel lbTotal;
	private JTextField txtTotal;
	private JButton btCancelar;

	/**
	 * Create the frame.
	 */
	public InscritosView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Inscripciones de cursos");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(InscritosView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1500, 1000);
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
	}


	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(3, 1, 0, 0));
			pnCentro.add(getPnCursos());
			pnCentro.add(getPnInscritos());
			pnCentro.add(getPnEspera());
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
			lbLogo.setIcon(new ImageIcon(InscritosView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(0, 3, 10, 10));
			pnInferior.add(getLbTotal());
			pnInferior.add(getTxtTotal());
			pnInferior.add(getBtCancelar());
		}
		return pnInferior;
	}

	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbPlan());
		}
		return pnTituloSup;
	}

	private JLabel getLbPlan() {
		if (lbPlan == null) {
			lbPlan = new JLabel("Inscripciones cursos");
			lbPlan.setHorizontalAlignment(SwingConstants.CENTER);
			lbPlan.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbPlan;
	}
	
	
	private JPanel getPnCursos() {
		if (pnCursos == null) {
			pnCursos = new JPanel();
			pnCursos.setLayout(new GridLayout(0, 1, 0, 0));
			pnCursos.add(getScCursos());
		}
		return pnCursos;
	}
	
	private JScrollPane getScCursos() {
		if (scCursos == null) {
			scCursos = new JScrollPane();
			scCursos.setPreferredSize(new Dimension(410, 200));
			scCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			scCursos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Cursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scCursos.setBackground(Color.WHITE);
			scCursos.setViewportView(getTbCursos());
		}
		return scCursos;
	}
	
	private JTable getTbCursos() {
		if (tbCursos == null) {
			tbCursos = new JTable();			
			tbCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbCursos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbCursos.setRowMargin(5);
			tbCursos.setAutoscrolls(false);
			tbCursos.setFillsViewportHeight(true);
			tbCursos.setRowHeight(30);
			tbCursos.setSelectionForeground(Color.WHITE);
			tbCursos.setSelectionBackground(Color.GRAY);
			tbCursos.setGridColor(SystemColor.windowBorder);
			tbCursos.setName("Tabla de cursos");
			tbCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbCursos.setDefaultEditor(Object.class, null);
			tbCursos.setBackground(Color.decode("#f0f0f0"));
		}
		return tbCursos;
	}
	
	private JPanel getPnInscritos() {
		if (pnInscritos == null) {
			pnInscritos = new JPanel();
			pnInscritos.setLayout(new GridLayout(0, 1, 0, 0));
			pnInscritos.add(getScListaInscritos());
		}
		return pnInscritos;
	}
	
	private JScrollPane getScListaInscritos() {
		if (scListaInscritos == null) {
			scListaInscritos = new JScrollPane();
			scListaInscritos.setPreferredSize(new Dimension(410, 200));
			scListaInscritos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			scListaInscritos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de inscritos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scListaInscritos.setBackground(Color.WHITE);
			scListaInscritos.setViewportView(getTbInscritos());
		}
		return scListaInscritos;
	}
	
	private JTable getTbInscritos() {
		if (tbInscritos == null) {
			tbInscritos = new JTable();			
			tbInscritos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbInscritos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbInscritos.setRowMargin(5);
			tbInscritos.setAutoscrolls(false);
			tbInscritos.setFillsViewportHeight(true);
			tbInscritos.setRowHeight(30);
			tbInscritos.setSelectionForeground(Color.WHITE);
			tbInscritos.setSelectionBackground(Color.GRAY);
			tbInscritos.setGridColor(SystemColor.windowBorder);
			tbInscritos.setName("Tabla de inscritos");
			tbInscritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbInscritos.setDefaultEditor(Object.class, null);
			tbInscritos.setBackground(Color.decode("#f0f0f0"));
		}
		return tbInscritos;
	}	
	
	private JPanel getPnEspera() {
		if (pnEspera == null) {
			pnEspera = new JPanel();
			pnEspera.setLayout(new GridLayout(0, 1, 0, 0));
			pnEspera.add(getScListaEspera());
		}
		return pnEspera;
	}
	private JScrollPane getScListaEspera() {
		if (scListaEspera == null) {
			scListaEspera = new JScrollPane();
			scListaEspera.setPreferredSize(new Dimension(410, 200));
			scListaEspera.setFont(new Font("Tahoma", Font.PLAIN, 16));
			scListaEspera.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de espera", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scListaEspera.setBackground(Color.WHITE);
			scListaEspera.setViewportView(getTbEspera());
		}
		return scListaEspera;
	}
	private JTable getTbEspera() {
		if (tbEspera == null) {
			tbEspera = new JTable();			
			tbEspera.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tbEspera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tbEspera.setRowMargin(5);
			tbEspera.setAutoscrolls(false);
			tbEspera.setFillsViewportHeight(true);
			tbEspera.setRowHeight(30);
			tbEspera.setSelectionForeground(Color.WHITE);
			tbEspera.setSelectionBackground(Color.GRAY);
			tbEspera.setGridColor(SystemColor.windowBorder);
			tbEspera.setName("Tabla de espera");
			tbEspera.setRowSelectionAllowed(false);
			tbEspera.setDefaultEditor(Object.class, null);
			tbEspera.setBackground(Color.decode("#f0f0f0"));
		}
		return tbEspera;
	}
	
	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("Total abonado:");
			lbTotal.setHorizontalTextPosition(SwingConstants.CENTER);
			lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
			lbTotal.setFont(new Font("Calibri", Font.PLAIN, 16));
			lbTotal.setDisplayedMnemonic('T');
		}
		return lbTotal;
	}
	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
			txtTotal.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtTotal.setEditable(false);
			txtTotal.setColumns(6);
			txtTotal.setBackground(Color.WHITE);
		}
		return txtTotal;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 22));
			btCancelar.setBackground(new Color(34, 139, 34));
		}
		return btCancelar;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getTotal() {
		return txtTotal;
	}
	
	public JTable getTableCursos() {
		return tbCursos;
	}
	
	public JTable getTableInscritos() {
		return tbInscritos;
	}	
	
	public JTable getTableEspera() {
		return tbEspera;
	}
}
