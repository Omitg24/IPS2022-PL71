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
import javax.swing.JTextField;
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
 * Título: Clase InscripcionView
 *
 * @author Adrián Alves Morales, UO284288 y Omar Teixeira González, UO281847
 * @version 27 nov 2022
 */
public class InscripcionView implements Inscripcion {
	/**
	 * Atributo frmAdministracinCoiipa
	 */
	private JFrame frmAdministracinCoiipa;
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
	 * Atributo btInscribirse
	 */
	private JButton btInscribirse;
	/**
	 * Atributo scrollPaneCursos
	 */
	private JScrollPane scrollPaneCursos;
	/**
	 * Atributo tableDisponibles
	 */
	private JTable tableDisponibles;
	/**
	 * Atributo pnRegistro
	 */
	private JPanel pnRegistro;
	/**
	 * Atributo emision
	 */
	private EmisionInscripcionView emision;
	/**
	 * Atributo pnSolicitados
	 */
	private JPanel pnSolicitados;
	/**
	 * Atributo scrollPaneSolicitados
	 */
	private JScrollPane scrollPaneSolicitados;
	/**
	 * Atributo tableSolicitados
	 */
	private JTable tableSolicitados;
	/**
	 * Atributo pnInfD
	 */
	private JPanel pnInfD;
	/**
	 * Atributo pnInfIz
	 */
	private JPanel pnInfIz;
	/**
	 * Atributo btTarjeta
	 */
	private JButton btTarjeta;
	/**
	 * Atributo btTransferencia
	 */
	private JButton btTransferencia;
	/**
	 * Atributo btCancelar
	 */
	private JButton btCancelar;
	/**
	 * Atributo pnInfo
	 */
	private JPanel pnInfo;
	/**
	 * Atributo pnTablas
	 */
	private JPanel pnTablas;
	/**
	 * Atributo lblNombre
	 */
	private JLabel lblNombre;
	/**
	 * Atributo txtNombre
	 */
	private JTextField txtNombre;
	/**
	 * Atributo lblDni
	 */
	private JLabel lblDni;
	/**
	 * Atributo txtDni
	 */
	private JTextField txtDni;
	/**
	 * Atributo lblApellidos
	 */
	private JLabel lblApellidos;
	/**
	 * Atributo txtApellidos
	 */
	private JTextField txtApellidos;
	/**
	 * Atributo pnEspera
	 */
	private JPanel pnEspera;
	/**
	 * Atributo scrollPaneEspera
	 */
	private JScrollPane scrollPaneEspera;
	/**
	 * Atributo tableEspera
	 */
	private JTable tableEspera;
	private JLabel lbInscripcion;

	/**
	 * Constructor sin parámetros de la clase InscripcionView
	 */
	public InscripcionView() {
		initialize();
	}

	/**
	 * Método initialize
	 */
	private void initialize() {
		frmAdministracinCoiipa = new JFrame();
		frmAdministracinCoiipa.setIconImage(Toolkit.getDefaultToolkit().getImage(InscripcionView.class.getResource("/images/coiipa_symbol.png")));
		frmAdministracinCoiipa.setResizable(true);
		frmAdministracinCoiipa.setTitle("Administración COIIPA - Listado de inscripciones a cursos");
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
		frmAdministracinCoiipa.getRootPane().setDefaultButton(btInscribirse);
		
		emision = new EmisionInscripcionView();
	}

	/**
	 * Método setEmision
	 * @param emision
	 */
	public void setEmision(EmisionInscripcionView emision) {
		this.emision = emision;
	}

	/**
	 * Método getEmision
	 * @return emision
	 */
	public EmisionInscripcionView getEmision() {
		return emision;
	}	

	/**
	 * Método getPnCentro
	 * @return pnCentro
	 */
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getPnInfo(), BorderLayout.NORTH);
			pnCentro.add(getPnTablas());
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
			pnSuperior.add(getLbInscripcion_1());
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
			lbLogo.setIcon(new ImageIcon(InscripcionView.class.getResource("/images/coiipa_logo.jpg")));
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
			pnInferior.add(getPnInfD());
			pnInferior.add(getPnInfIz());
		}
		return pnInferior;
	}
	
	/**
	 * Método getBtInscribirse
	 * @return btInscribirse
	 */
	public JButton getBtInscribirse() {
		if (btInscribirse == null) {
			btInscribirse = new JButton("Inscribirse");
			btInscribirse.setEnabled(false);
			btInscribirse.setFocusable(false);
			btInscribirse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btInscribirse.setForeground(Color.WHITE);
			btInscribirse.setFont(new Font("Tahoma", Font.BOLD, 24));
			btInscribirse.setBackground(new Color(34, 139, 34));
		}
		return btInscribirse;
	}
	
	/**
	 * Método getPnDisponibles
	 * @return pnRegistro
	 */
	private JPanel getPnDisponibles() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setPreferredSize(new Dimension(414, 200));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de cursos disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getScrollPaneDisponibles());
		}
		return pnRegistro;
	}
	
	/**
	 * Método getScrollPaneDisponibles
	 * @return scrollPaneCursos
	 */
	private JScrollPane getScrollPaneDisponibles() {
		if (scrollPaneCursos == null) {
			scrollPaneCursos = new JScrollPane();
			scrollPaneCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneCursos.setViewportView(getTableDisponibles());
		}
		return scrollPaneCursos;
	}
	
	/**
	 * Método getPnCentro
	 * @return pnCentro
	 */
	private JTable getTableDisponibles() {
		if (tableDisponibles == null) {
			tableDisponibles = new JTable();			
			tableDisponibles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableDisponibles.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableDisponibles.setRowMargin(5);
			tableDisponibles.setAutoscrolls(false);
			tableDisponibles.setFillsViewportHeight(true);
			tableDisponibles.setRowHeight(30);
			tableDisponibles.setSelectionForeground(Color.WHITE);
			tableDisponibles.setSelectionBackground(Color.GRAY);
			tableDisponibles.setGridColor(SystemColor.windowBorder);
			tableDisponibles.setName("Tabla de cursos disponibles");
			tableDisponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableDisponibles.setDefaultEditor(Object.class, null);
			tableDisponibles.setBackground(Color.decode("#f0f0f0"));	
		}
		return tableDisponibles;
	}

	/**
	 * Método getPnCentro
	 * @return pnCentro
	 */
	private JPanel getPnSolicitados() {
		if (pnSolicitados == null) {
			pnSolicitados = new JPanel();
			pnSolicitados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de cursos solicitados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnSolicitados.setBackground(Color.WHITE);
			pnSolicitados.setPreferredSize(new Dimension(414, 200));
			pnSolicitados.setLayout(new BorderLayout(0, 0));
			pnSolicitados.add(getScrollPaneSolicitados());
		}
		return pnSolicitados;
	}
	
	/**
	 * Método getScrollPaneSolicitados
	 * @return scrollPaneSolicitados
	 */
	private JScrollPane getScrollPaneSolicitados() {
		if (scrollPaneSolicitados == null) {
			scrollPaneSolicitados = new JScrollPane();
			scrollPaneSolicitados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPaneSolicitados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneSolicitados.setViewportView(getTableSolicitados());
		}
		return scrollPaneSolicitados;
	}
	
	/**
	 * Método getTableSolicitados
	 * @return tableSolicitados
	 */
	private JTable getTableSolicitados() {
		if (tableSolicitados == null) {
			tableSolicitados = new JTable();			
			tableSolicitados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableSolicitados.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableSolicitados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableSolicitados.setRowMargin(5);
			tableSolicitados.setAutoscrolls(false);
			tableSolicitados.setFillsViewportHeight(true);
			tableSolicitados.setRowHeight(30);
			tableSolicitados.setSelectionForeground(Color.WHITE);
			tableSolicitados.setSelectionBackground(Color.GRAY);
			tableSolicitados.setGridColor(SystemColor.windowBorder);
			tableSolicitados.setName("Tabla de cursos solicitados");
			tableSolicitados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableSolicitados.setDefaultEditor(Object.class, null);
			tableSolicitados.setBackground(Color.decode("#f0f0f0"));
		}
		return tableSolicitados;
	}
	
	/**
	 * Método getPnEspera
	 * @return pnEspera
	 */
	private JPanel getPnEspera() {
		if (pnEspera == null) {
			pnEspera = new JPanel();
			pnEspera.setPreferredSize(new Dimension(414, 200));
			pnEspera.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Lista de cursos en espera", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnEspera.setBackground(Color.WHITE);
			pnEspera.setLayout(new BorderLayout(0, 0));
			pnEspera.add(getScrollPaneEspera(), BorderLayout.CENTER);
		}
		return pnEspera;
	}
	
	/**
	 * Método getScrollPaneEspera
	 * @return scrollPaneEspera
	 */
	private JScrollPane getScrollPaneEspera() {
		if (scrollPaneEspera == null) {
			scrollPaneEspera = new JScrollPane();
			scrollPaneEspera.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneEspera.setViewportView(getTableEspera());
		}
		return scrollPaneEspera;
	}
	
	/**
	 * Método getTableEspera
	 * @return tableEspera
	 */
	private JTable getTableEspera() {
		if (tableEspera == null) {
			tableEspera = new JTable();			
			tableEspera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableEspera.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableEspera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableEspera.setRowMargin(5);
			tableEspera.setAutoscrolls(false);
			tableEspera.setFillsViewportHeight(true);
			tableEspera.setRowHeight(30);
			tableEspera.setSelectionForeground(Color.WHITE);
			tableEspera.setSelectionBackground(Color.GRAY);
			tableEspera.setGridColor(SystemColor.windowBorder);
			tableEspera.setName("Tabla de cursos en espera");
			tableEspera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableEspera.setDefaultEditor(Object.class, null);
			tableEspera.setBackground(Color.decode("#f0f0f0"));	
		}
		return tableEspera;
	}

	/**
	 * Método getPnInfD
	 * @return pnInfD
	 */
	private JPanel getPnInfD() {
		if (pnInfD == null) {
			pnInfD = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInfD.getLayout();
			flowLayout.setHgap(50);
			pnInfD.setBackground(Color.WHITE);
			pnInfD.add(getBtInscribirse());	
			pnInfD.add(getBtCancelar());
		}
		return pnInfD;
	}
	
	/**
	 * Método getPnInfIz
	 * @return pnInfIz
	 */
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
	
	/**
	 * Método getBtTarjeta
	 * @return btTarjeta
	 */
	private JButton getBtTarjeta() {
		if (btTarjeta == null) {
			btTarjeta = new JButton("Tarjeta");
			btTarjeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btTarjeta.setEnabled(false);
			btTarjeta.setForeground(Color.WHITE);
			btTarjeta.setFont(new Font("Tahoma", Font.BOLD, 24));
			btTarjeta.setFocusable(false);
			btTarjeta.setBackground(new Color(34, 139, 34));
		}
		return btTarjeta;
	}
	
	/**
	 * Método getBtTransferencia
	 * @return btTransferencia
	 */
	private JButton getBtTransferencia() {
		if (btTransferencia == null) {
			btTransferencia = new JButton("Transferencia");
			btTransferencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btTransferencia.setEnabled(false);
			btTransferencia.setForeground(Color.WHITE);
			btTransferencia.setFont(new Font("Tahoma", Font.BOLD, 24));
			btTransferencia.setFocusable(false);
			btTransferencia.setBackground(new Color(34, 139, 34));
		}
		return btTransferencia;
	}

	/**
	 * Método getBtCancelar
	 * @return btCancelar
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btCancelar.setEnabled(false);
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btCancelar.setFocusable(false);
			btCancelar.setBackground(new Color(34, 139, 34));
		}
		return btCancelar;
	}
	
	/**
	 * Método getPnInfo
	 * @return pnInfo
	 */
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnInfo.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnInfo.add(getLblNombre());
			pnInfo.add(getTxtNombre());
			pnInfo.add(getLblApellidos());
			pnInfo.add(getTxtApellidos());
			pnInfo.add(getLblDni());
			pnInfo.add(getTxtDni());
		}
		return pnInfo;
	}
	
	/**
	 * Método getPnTablas
	 * @return pnTablas
	 */
	private JPanel getPnTablas() {
		if (pnTablas == null) {
			pnTablas = new JPanel();
			pnTablas.setBackground(Color.WHITE);
			pnTablas.setLayout(new GridLayout(3, 1, 0, 0));
			pnTablas.add(getPnDisponibles());
			pnTablas.add(getPnSolicitados());
			pnTablas.add(getPnEspera());
		}
		return pnTablas;
	}
	
	/**
	 * Método getLblNombre
	 * @return lblNombre
	 */
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNombre;
	}
	
	/**
	 * Método getTxtNombre
	 * @return txtNombre
	 */
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txtNombre.setEditable(false);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	
	/**
	 * Método getLblApellidos
	 * @return lblApellidos
	 */
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblApellidos;
	}
	
	/**
	 * Método getPnCentro
	 * @return pnCentro
	 */
	private JTextField getTxtApellidos() {
		if (txtApellidos == null) {
			txtApellidos = new JTextField();
			txtApellidos.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtApellidos.setEditable(false);
			txtApellidos.setColumns(20);
		}
		return txtApellidos;
	}
	
	/**
	 * Método getLblDni
	 * @return lblDni
	 */
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblDni;
	}
	
	/**
	 * Método getTxtDni
	 * @return txtDni
	 */
	private JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtDni.setHorizontalAlignment(SwingConstants.CENTER);
			txtDni.setEditable(false);
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtDni.setColumns(10);
		}
		return txtDni;
	}
	
	/**
	 * Método getInscripcion
	 * @return this
	 */
	@Override
	public Inscripcion getInscripcion() {
		return this;
	}
	
	/**
	 * Método getFrame
	 * @return frmAdministracinCoiipa
	 */
	public JFrame getFrame() {
		return frmAdministracinCoiipa;
	}
	
	/**
	 * Método getButtonInscribirse
	 * @return btInscribirse
	 */
	public JButton getButtonInscribirse() {
		return btInscribirse;
	}
	
	/**
	 * Método getButtonCancelar
	 * @return btCancelar
	 */
	public JButton getButtonCancelar() {
		return btCancelar;
	}
	
	/**
	 * Método getButtonTarjeta
	 * @return btTarjeta
	 */
	public JButton getButtonTarjeta() {
		return btTarjeta;
	}
	
	/**
	 * Método getButtonTransferencia
	 * @return btTransferencia
	 */
	public JButton getButtonTransferencia() {
		return btTransferencia;
	}
	
	/**
	 * Método getTextNombre
	 * @return txtNombre
	 */
	public JTextField getTextNombre() {
		return txtNombre;
	}
	
	/**
	 * Método getTextApellidos
	 * @return txtApellidos
	 */
	public JTextField getTextApellidos() {
		return txtApellidos;
	}
	
	/**
	 * Método getTextDni
	 * @return txtDni
	 */
	public JTextField getTextDni() {
		return txtDni;
	}
	
	/**
	 * Método getTbDisponibles
	 * @return tableDisponibles
	 */
	public JTable getTbDisponibles() {
		return tableDisponibles;
	}
	
	/**
	 * Método getTbSolicitados
	 * @return tableSolicitados
	 */
	public JTable getTbSolicitados() {
		return tableSolicitados;
	}
	
	/**
	 * Método getTbEspera
	 * @return tableEspera
	 */
	public JTable getTbEspera() {
		return tableEspera;
	}
	private JLabel getLbInscripcion_1() {
		if (lbInscripcion == null) {
			lbInscripcion = new JLabel("Listado de inscripciones a cursos");
			lbInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lbInscripcion.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbInscripcion;
	}
}
