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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Titulo: Clase ConsolidacionView
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class ConsolidacionView extends JFrame {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;

//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo frame
	 */
	private JFrame frame;
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo upperPanel
	 */
	private JPanel upperPanel;
	/**
	 * Atributo lbLogo
	 */
	private JLabel lbLogo;
	/**
	 * Atributo lbConsolidacion
	 */
	private JLabel lbConsolidacion;
	/**
	 * Atributo bottomPanel
	 */
	private JPanel bottomPanel;
	/**
	 * Atributo btConsolidacion
	 */
	private JButton btConsolidacion;
	/**
	 * Atributo middlePanel
	 */
	private JPanel middlePanel;
	/**
	 * Atributo panelCursos
	 */
	private JScrollPane scrollPaneCursos;
	/**
	 * Atributo panelColegiados
	 */
	private JScrollPane scrollPaneColegiados;
	/**
	 * Atributo tableCursos
	 */
	private JTable tableCursos;
	/**
	 * Atributo tableColegiados
	 */
	private JTable tableColegiados;
	
//-- INTERFAZ GRÁFICA ----------------------------------------------------------
	/**
	 * Constructor ConsolidacionView
	 */
	public ConsolidacionView() {
		initialize();
	}
	
	/**
	 * Método initialize
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(true);
		frame.setTitle("Administración COIIPA - Consolidación de pagos");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsolidacionView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1500, 900);
		frame.setMinimumSize(new Dimension(1500, 900));
		frame.setLocationRelativeTo(null);
		frame.getRootPane().setDefaultButton(btConsolidacion);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		contentPane.setLayout(new BorderLayout(5, 5));
		contentPane.add(getUpperPanel(), BorderLayout.NORTH);
		contentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		frame.setContentPane(contentPane);
		contentPane.add(getMiddlePanel(), BorderLayout.CENTER);
	}

	/**
	 * Método getUpperPanel
	 * @return upperPanel
	 */
	private JPanel getUpperPanel() {
		if (upperPanel == null) {
			upperPanel = new JPanel();
			upperPanel.setBackground(Color.WHITE);
			upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			upperPanel.add(getLbLogo());
			upperPanel.add(getLbConsolidacion());
		}
		return upperPanel;
	}
	
	/**
	 * Método getLbLogo
	 * @return lbLogo
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(ConsolidacionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	
	/**
	 * getLbApplicant
	 * @return lbApplicant
	 */
	private JLabel getLbConsolidacion() {
		if (lbConsolidacion == null) {
			lbConsolidacion = new JLabel("Consolidación de pagos");
			lbConsolidacion.setHorizontalAlignment(SwingConstants.CENTER);
			lbConsolidacion.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbConsolidacion;
	}
	
	/**
	 * Método getBottomPanel
	 * @return bottomPanel
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			bottomPanel = new JPanel();
			bottomPanel.setBackground(Color.WHITE);
			bottomPanel.add(getBtnConsolidacion());
		}
		return bottomPanel;		
	}
	
	/**
	 * Método getBtConsolidacion
	 * @return btConsolidacion
	 */
	private JButton getBtnConsolidacion() {
		if (btConsolidacion == null) {
			btConsolidacion = new JButton("Consolidar");
			btConsolidacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btConsolidacion.setForeground(Color.WHITE);
			btConsolidacion.setFont(new Font("Tahoma", Font.BOLD, 24));
			btConsolidacion.setBackground(new Color(34, 139, 34));
			btConsolidacion.setEnabled(false);
		}
		return btConsolidacion;
	}
	
	/**
	 * Método getMiddlePanel
	 * @return middlePanel
	 */
	private JPanel getMiddlePanel() {
		if (middlePanel == null) {
			middlePanel = new JPanel();
			middlePanel.setBackground(Color.WHITE);
			middlePanel.setLayout(new GridLayout(2, 1, 10, 10));
			middlePanel.add(getScrollPaneCursos());
			middlePanel.add(getScrollPaneColegiados());
		}
		return middlePanel;
	}
	
	/**
	 * Método getPanelCursos
	 * @return panelCursos
	 */
	private JScrollPane getScrollPaneCursos() {
		if (scrollPaneCursos == null) {
			scrollPaneCursos = new JScrollPane();
			scrollPaneCursos.setBackground(Color.WHITE);
			scrollPaneCursos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de cursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPaneCursos.setViewportView(getTableCursos());
		}
		return scrollPaneCursos;
	}
	
	/**
	 * Método getPanelColegiados
	 * @return
	 */
	private JScrollPane getScrollPaneColegiados() {
		if (scrollPaneColegiados == null) {
			scrollPaneColegiados = new JScrollPane();
			scrollPaneColegiados.setBackground(Color.WHITE);
			scrollPaneColegiados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de pre-inscritos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPaneColegiados.setViewportView(getTableColegiados());
		}
		return scrollPaneColegiados;
	}
	
	/**
	 * Método getTableCursos
	 * @return tableCursos
	 */
	private JTable getTableCursos() {
		if (tableCursos == null) {
			tableCursos = new JTable();			
			tableCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableCursos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableCursos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableCursos.setRowMargin(5);
			tableCursos.setAutoscrolls(false);
			tableCursos.setFillsViewportHeight(true);
			tableCursos.setRowHeight(30);
			tableCursos.setSelectionForeground(Color.WHITE);
			tableCursos.setSelectionBackground(Color.GRAY);
			tableCursos.setGridColor(SystemColor.windowBorder);
			tableCursos.setName("Tabla de Cursos");
			tableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCursos.setDefaultEditor(Object.class, null);
			tableCursos.setBackground(Color.decode("#f0f0f0"));			
		}
		return tableCursos;
	}

	/**
	 * Método getTableColegiados
	 * @return tableColegiados
	 */
	private JTable getTableColegiados() {
		if (tableColegiados == null) {
			tableColegiados = new JTable();
			tableColegiados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableColegiados.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableColegiados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tableColegiados.setRowMargin(5);
			tableColegiados.setAutoscrolls(false);
			tableColegiados.setFillsViewportHeight(true);
			tableColegiados.setRowHeight(30);
			tableColegiados.setRowSelectionAllowed(false);
			tableColegiados.setColumnSelectionAllowed(false);			
			tableColegiados.setGridColor(SystemColor.windowBorder);
			tableColegiados.setName("Tabla de Colegiados");
			tableColegiados.setDefaultEditor(Object.class, null);
			tableColegiados.setBackground(Color.decode("#f0f0f0"));;
		}
		return tableColegiados;
	}

//-- MÉTODOS AUXILIARES --------------------------------------------------------
	/**
	 * Método getTblCursos
	 * @return tableCursos
	 */
	public JTable getTblCursos() {
		return getTableCursos();
	}
	
	/**
	 * Método getTblColegiados
	 * @return tableColegiados
	 */
	public JTable getTblColegiados() {
		return getTableColegiados();
	}
	/**
	 * Método getFrame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtConsolidacion() {
		return btConsolidacion;		
	}
}