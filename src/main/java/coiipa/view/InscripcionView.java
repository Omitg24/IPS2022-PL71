package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

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

import coiipa.view.inscripcion.EmisionInscripcionView;
import coiipa.view.inscripcion.Inscripcion;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionView implements Inscripcion {

	private JFrame frmAdministracinCoiipa;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JButton btInscribirse;
	private JPanel pnTituloSup;
	private JLabel lbInscripcion;
	private JScrollPane scrollPaneCursos;
	private JTable tableCursos;
	private JPanel pnRegistro;

	private EmisionInscripcionView emision;
	private JPanel pnInscripciones;
	private JScrollPane scrollPaneInscripciones;
	private JTable tablePreInscritos;
	private JPanel pnInfD;
	private JPanel pnInfIz;
	private JButton btTarjeta;
	private JButton btTransferencia;

	/**
	 * Create the frame.
	 */
	public InscripcionView() {
		initialize();
	}

	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setResizable(false);
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Apertura de cursos");
		frmAdministracinCoiipa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmAdministracinCoiipa.setBounds(100, 100, 871, 500);
		frmAdministracinCoiipa.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmAdministracinCoiipa.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frmAdministracinCoiipa.getRootPane().setDefaultButton(btInscribirse);
		
		emision = new EmisionInscripcionView();
	}

	public void reiniciarCampos() {

	}

	public void setEmision(EmisionInscripcionView emision) {
		this.emision = emision;
	}

	public EmisionInscripcionView getEmision() {
		return emision;
	}
	

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getPnRegistro());
			pnCentro.add(getPnInscripciones());
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
			lbLogo.setIcon(new ImageIcon(InscripcionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(0, 2, 0, 0));
			pnInferior.add(getPnInfD());
			pnInferior.add(getPnInfIz());
		}
		return pnInferior;
	}
	public JButton getBtInscribirse() {
		if (btInscribirse == null) {
			btInscribirse = new JButton("Inscribirse");
			btInscribirse.setFocusable(false);
			btInscribirse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btInscribirse.setForeground(Color.WHITE);
			btInscribirse.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btInscribirse.setBackground(new Color(34, 139, 34));
		}
		return btInscribirse;
	}
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbInscripcion());
		}
		return pnTituloSup;
	}
	private JLabel getLbInscripcion() {
		if (lbInscripcion == null) {
			lbInscripcion = new JLabel("Inscripciones Cursos");
			lbInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lbInscripcion.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbInscripcion;
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
			tableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCursos.setDefaultEditor(Object.class, null);
		}
		return tableCursos;
	}
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setPreferredSize(new Dimension(414, 200));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Cursos disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getScrollPaneCursos());
		}
		return pnRegistro;
	}
	private JPanel getPnInscripciones() {
		if (pnInscripciones == null) {
			pnInscripciones = new JPanel();
			pnInscripciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Cursos Pre-Inscritos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnInscripciones.setBackground(Color.WHITE);
			pnInscripciones.setPreferredSize(new Dimension(414, 200));
			pnInscripciones.setLayout(new BorderLayout(0, 0));
			pnInscripciones.add(getScrollPaneInscripciones());
		}
		return pnInscripciones;
	}
	private JScrollPane getScrollPaneInscripciones() {
		if (scrollPaneInscripciones == null) {
			scrollPaneInscripciones = new JScrollPane();
			scrollPaneInscripciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPaneInscripciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneInscripciones.setViewportView(getTablePreinscritos());
		}
		return scrollPaneInscripciones;
	}
	public JTable getTablePreinscritos() {
		if (tablePreInscritos == null) {
			tablePreInscritos = new JTable();
			tablePreInscritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tablePreInscritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePreInscritos.setDefaultEditor(Object.class, null);
		}
		return tablePreInscritos;
	}

	private JPanel getPnInfD() {
		if (pnInfD == null) {
			pnInfD = new JPanel();
			pnInfD.setBackground(Color.WHITE);
			pnInfD.add(getBtInscribirse());	
		}
		return pnInfD;
	}
	private JPanel getPnInfIz() {
		if (pnInfIz == null) {
			pnInfIz = new JPanel();
			pnInfIz.setPreferredSize(new Dimension(10, 50));
			FlowLayout flowLayout = (FlowLayout) pnInfIz.getLayout();
			flowLayout.setHgap(50);
			pnInfIz.setBackground(Color.WHITE);
			pnInfIz.add(getBtTarjeta());
			pnInfIz.add(getBtTransferencia());
		}
		return pnInfIz;
	}
	public JButton getBtTarjeta() {
		if (btTarjeta == null) {
			btTarjeta = new JButton("Tarjeta");
			btTarjeta.setEnabled(false);
			btTarjeta.setForeground(Color.WHITE);
			btTarjeta.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btTarjeta.setFocusable(false);
			btTarjeta.setBackground(new Color(34, 139, 34));
		}
		return btTarjeta;
	}
	public JButton getBtTransferencia() {
		if (btTransferencia == null) {
			btTransferencia = new JButton("Transferencia");
			btTransferencia.setEnabled(false);
			btTransferencia.setForeground(Color.WHITE);
			btTransferencia.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btTransferencia.setFocusable(false);
			btTransferencia.setBackground(new Color(34, 139, 34));
		}
		return btTransferencia;
	}

	@Override
	public Inscripcion getInscripcion() {
		return this;
	}
}