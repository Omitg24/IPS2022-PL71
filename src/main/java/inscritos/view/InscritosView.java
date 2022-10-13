package inscritos.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import curso.view.CursoView;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 
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
	private JPanel pnEast;
	private JPanel pnCurso;
	private JComboBox<Object> cbCursos;
	private JLabel lbCurso;
	private JPanel pnTotal;
	private JLabel lbTotal;
	private JTextField txtTotal;
	private JScrollPane scLista;

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
				Toolkit.getDefaultToolkit().getImage(CursoView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 500);
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
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getScLista(), BorderLayout.CENTER);
			pnCentro.add(getPnEast(), BorderLayout.EAST);
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
			lbLogo.setIcon(new ImageIcon(CursoView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setVgap(40);
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
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
			lbPlan.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbPlan;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	private JTable getTbInscritos() {
		if (tbInscritos == null) {
			tbInscritos = new JTable();
			tbInscritos.setRowMargin(5);
			tbInscritos.setAutoscrolls(false);
			tbInscritos.setFillsViewportHeight(true);
			tbInscritos.setRowHeight(30);
			tbInscritos.setSelectionForeground(Color.WHITE);
			tbInscritos.setGridColor(Color.WHITE);
			tbInscritos.setFont(new Font("Calibri", Font.PLAIN, 16));
			tbInscritos.setName("Tabla Inscritos");
			tbInscritos.setRowSelectionAllowed(false);
			tbInscritos.setDefaultEditor(Object.class, null); //readonly
			tbInscritos.setBackground(Color.WHITE);
		}
		return tbInscritos;
	}
	private JPanel getPnEast() {
		if (pnEast == null) {
			pnEast = new JPanel();
			pnEast.setBackground(Color.WHITE);
			pnEast.setLayout(new GridLayout(2, 1, 0, 0));
			pnEast.add(getPnCurso());
			pnEast.add(getPnTotal());
		}
		return pnEast;
	}
	private JPanel getPnCurso() {
		if (pnCurso == null) {
			pnCurso = new JPanel();
			pnCurso.setPreferredSize(new Dimension(300, 100));
			pnCurso.setBackground(Color.WHITE);
			pnCurso.setLayout(null);
			pnCurso.add(getLbCurso());
			pnCurso.add(getCbCursos());
		}
		return pnCurso;
	}
	private JComboBox<Object> getCbCursos() {
		if (cbCursos == null) {
			cbCursos = new JComboBox<Object>();
			cbCursos.setBackground(Color.WHITE);
			cbCursos.setMaximumRowCount(15);
			cbCursos.setBounds(10, 50, 263, 28);
			cbCursos.setFont(new Font("Calibri", Font.PLAIN, 16));
		}
		return cbCursos;
	}
	private JLabel getLbCurso() {
		if (lbCurso == null) {
			lbCurso = new JLabel("Seleccionar curso:");
			lbCurso.setBounds(10, 23, 116, 20);
			lbCurso.setLabelFor(getCbCursos());
			lbCurso.setDisplayedMnemonic('S');
			lbCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		}
		return lbCurso;
	}
	private JPanel getPnTotal() {
		if (pnTotal == null) {
			pnTotal = new JPanel();
			pnTotal.setPreferredSize(new Dimension(300, 100));
			FlowLayout flowLayout = (FlowLayout) pnTotal.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(50);
			pnTotal.setBackground(Color.WHITE);
			pnTotal.add(getLbTotal());
			pnTotal.add(getTxtTotal());
		}
		return pnTotal;
	}
	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("Total abonado:");
			lbTotal.setVerticalAlignment(SwingConstants.BOTTOM);
			lbTotal.setLabelFor(getTxtTotal());
			lbTotal.setDisplayedMnemonic('T');
			lbTotal.setFont(new Font("Calibri", Font.PLAIN, 16));
		}
		return lbTotal;
	}
	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setBackground(Color.WHITE);
			txtTotal.setEditable(false);
			txtTotal.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtTotal.setColumns(6);
		}
		return txtTotal;
	}
	
	public JComboBox<Object> getComboBoxCursos() {
		return this.getCbCursos();
	}
	
	public JTextField getTotal() {
		return txtTotal;
	}
	
	public JTable getTableInscritos() {
		return this.getTbInscritos();
	}
	private JScrollPane getScLista() {
		if (scLista == null) {
			scLista = new JScrollPane();
			scLista.setPreferredSize(new Dimension(410, 200));
			scLista.setFont(new Font("Calibri", Font.PLAIN, 11));
			scLista.setBorder(new TitledBorder(null, "Inscripciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scLista.setBackground(Color.WHITE);
			scLista.setViewportView(getTbInscritos());
		}
		return scLista;
	}
}
