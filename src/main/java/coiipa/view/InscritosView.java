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
import java.awt.Cursor;

/**
 * Título: Clase InscritosView
 *
 * @author David Warzynski Abril, UO278968, Omar Teixeira González, UO281847
 * 		   y Adrián Alves Morales, UO284288
 * @version 23 nov 2022
 */
public class InscritosView {
	/**
	 * Atributo frame
	 */
	private JFrame frame;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo pnCentro
	 */
	private JPanel pnCentro;
	/**
	 * Atributo pnSuperior
	 */
	private JPanel pnSuperior;
	/**
	 * Atributo lbLogo
	 */
	private JLabel lbLogo;
	/**
	 * Atributo pnInferior
	 */
	private JPanel pnInferior;
	/**
	 * Atributo pnTituloSup
	 */
	private JPanel pnTituloSup;
	/**
	 * Atributo lbPlan
	 */
	private JLabel lbPlan;
	/**
	 * Atributo tbInscritos
	 */
	private JTable tbInscritos;
	/**
	 * Atributo scListaInscritos
	 */
	private JScrollPane scListaInscritos;
	/**
	 * Atributo pnInscritos
	 */
	private JPanel pnInscritos;
	/**
	 * Atributo pnCursos
	 */
	private JPanel pnCursos;
	/**
	 * Atributo scListaCursos
	 */
	private JScrollPane scListaCursos;
	/**
	 * Atributo tbCursos
	 */
	private JTable tbCursos;
	/**
	 * Atributo pnEspera
	 */
	private JPanel pnEspera;
	/**
	 * Atributo scListaEspera
	 */
	private JScrollPane scListaEspera;
	/**
	 * Atributo tbEspera
	 */
	private JTable tbEspera;
	/**
	 * Atributo pnDcha
	 */
	private JPanel pnDcha;
	/**
	 * Atributo pnIzda
	 */
	private JPanel pnIzda;
	/**
	 * Atributo lbTotal
	 */
	private JLabel lbTotal;
	/**
	 * Atributo txtTotal
	 */
	private JTextField txtTotal;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;	

	/**
	 * Constructor sin parámetros
	 */
	public InscritosView() {
		initialize();
	}

	/**
	 * Método initialize
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(true);
		frame.setTitle("Administración COIIPA - Inscripciones de cursos");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(InscritosView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1500, 1000);
		frame.setMinimumSize(new Dimension(1500,1000));
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

	/**
	 * Método getPnCentro
	 * @return pnCentro
	 */
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

	/**
	 * Método getPnSuperior
	 * @return pnSuperior
	 */
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

	/**
	 * Método getLbLogo
	 * @return lbLogo
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(InscritosView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	/**
	 * Método getPnInferior
	 * @return pnInferior
	 */
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(0, 2, 0, 0));
			pnInferior.add(getPnIzda());
			pnInferior.add(getPnDcha());
		}
		return pnInferior;
	}

	/**
	 * Método getPnTituloSup
	 * @return pnTituloSup
	 */
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbPlan());
		}
		return pnTituloSup;
	}

	/**
	 * Método getLbPlan
	 * @return lbPlan
	 */
	private JLabel getLbPlan() {
		if (lbPlan == null) {
			lbPlan = new JLabel("Inscripciones cursos");
			lbPlan.setHorizontalAlignment(SwingConstants.CENTER);
			lbPlan.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbPlan;
	}
	
	/**
	 * Método getPnCursos
	 * @return pnCursos
	 */
	private JPanel getPnCursos() {
		if (pnCursos == null) {
			pnCursos = new JPanel();
			pnCursos.setLayout(new GridLayout(0, 1, 0, 0));
			pnCursos.add(getScListaCursos());
		}
		return pnCursos;
	}
	
	/**
	 * Método getScListaCursos
	 * @return scListaCursos
	 */
	private JScrollPane getScListaCursos() {
		if (scListaCursos == null) {
			scListaCursos = new JScrollPane();
			scListaCursos.setPreferredSize(new Dimension(410, 200));
			scListaCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			scListaCursos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de cursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scListaCursos.setBackground(Color.WHITE);
			scListaCursos.setViewportView(getTbCursos());
		}
		return scListaCursos;
	}
	
	/**
	 * Método getTbCursos
	 * @return tbCursos
	 */
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
	
	/**
	 * Método getPnInscritos
	 * @return pnInscritos
	 */
	private JPanel getPnInscritos() {
		if (pnInscritos == null) {
			pnInscritos = new JPanel();
			pnInscritos.setLayout(new GridLayout(0, 1, 0, 0));
			pnInscritos.add(getScListaInscritos());
		}
		return pnInscritos;
	}
	
	/**
	 * Método getScListaInscritos
	 * @return scListaInscritos
	 */
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
	
	/**
	 * Método getTbInscritos
	 * @return tbInscritos
	 */
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
	
	/**
	 * Método getPnEspera
	 * @return pnEspera
	 */
	private JPanel getPnEspera() {
		if (pnEspera == null) {
			pnEspera = new JPanel();
			pnEspera.setLayout(new GridLayout(0, 1, 0, 0));
			pnEspera.add(getScListaEspera());
		}
		return pnEspera;
	}
	
	/**
	 * Método getScListaEspera
	 * @return scListaEspera
	 */
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
	
	/**
	 * Método getTbEspera
	 * @return tbEspera
	 */
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
	
	/**
	 * Método getPnDcha
	 * @return pnDcha
	 */
	private JPanel getPnDcha() {
		if (pnDcha == null) {
			pnDcha = new JPanel();
			pnDcha.add(getBtCancelar());
		}
		return pnDcha;
	}
	
	/**
	 * Método getPnIzda
	 * @return pnIzda
	 */
	private JPanel getPnIzda() {
		if (pnIzda == null) {
			pnIzda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnIzda.getLayout();
			flowLayout.setHgap(50);
			pnIzda.add(getLbTotal());
			pnIzda.add(getTxtTotal());
		}
		return pnIzda;
	}
	
	/**
	 * Método getLbTotal
	 * @return lbTotal
	 */
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
	
	/**
	 * Método getTxtTotal
	 * @return txtTotal
	 */
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
	
	/**
	 * Método getBtCancelar
	 * @return btCancelar
	 */
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setEnabled(false);
			btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 22));
			btCancelar.setBackground(new Color(34, 139, 34));
		}
		return btCancelar;
	}
	
	/**
	 * Método getFrame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Método getTotal
	 * @return txtTotal
	 */
	public JTextField getTotal() {
		return txtTotal;
	}
	
	/**
	 * Método getTableCursos
	 * @return tbCursos
	 */
	public JTable getTableCursos() {
		return tbCursos;
	}
	
	/**
	 * Método getTableInscritos
	 * @return tbInscritos
	 */
	public JTable getTableInscritos() {
		return tbInscritos;
	}	
	
	/**
	 * Método getTableEspera
	 * @return tbEspera
	 */
	public JTable getTableEspera() {
		return tbEspera;
	}	
}
