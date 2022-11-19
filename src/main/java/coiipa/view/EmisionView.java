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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Título: Clase EmisionView
 *
 * @author Omar Teixeira González, UO281847
 * @version 15 oct 2022
 */
public class EmisionView extends JFrame {
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
	 * Atributo lblLogo
	 */
	private JLabel lblLogo;
	/**
	 * Atributo lbApplicant
	 */
	private JLabel lbTitle;	
	/**
	 * Atributo middlePanel
	 */
	private JPanel middlePanel;
	/**
	 * Atributo labelPanel
	 */
	private JPanel labelPanel;
	/**
	 * Atributo lblIndication
	 */
	private JLabel lblIndication;
	/**
	 * Atributo lblIndication2
	 */
	private JLabel lblIndication2;
	/**
	 * Atributo buttonPanel
	 */
	private JPanel buttonPanel;
	/**
	 * Atributo btGenerateReceipts
	 */
	private JButton btGenerateReceipts;
	

//-- INTERFAZ GRÁFICA ----------------------------------------------------------
	/**
	 * Constructor ApplicantView
	 */
	public EmisionView() {
		initialize();
	}
	
	/**
	 * Método initialize
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Emisión de recibos");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EmisionView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 425, 330);
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		contentPane.add(getUpperPanel(), BorderLayout.NORTH);
		frame.getRootPane().setDefaultButton(btGenerateReceipts);
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
			upperPanel.setLayout(new BorderLayout(0, 0));
			upperPanel.add(getLblLogo(), BorderLayout.NORTH);
		}
		return upperPanel;
	}
	
	/**
	 * Método getLblLogo
	 * @return lblLogo
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(EmisionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lblLogo;
	}
	/**
	 * getLbApplicant
	 * @return lbApplicant
	 */
	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("Emisión de recibos");
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbTitle;
	}
	
	/**
	 * Método getRegisterPanel
	 * @return middlePanel
	 */
	private JPanel getMiddlePanel() {
		if (middlePanel == null) {
			middlePanel = new JPanel();
			middlePanel.setBorder(null);
			middlePanel.setLayout(new BorderLayout(5, 5));
			middlePanel.add(getLabelPanel());
			middlePanel.add(getButtonPanel(), BorderLayout.SOUTH);
		}
		return middlePanel;
	}	
	
	/**
	 * Método getLabelPanel
	 * @return labelPanel
	 */
	private JPanel getLabelPanel() {
		if (labelPanel == null) {
			labelPanel = new JPanel();
			labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			labelPanel.add(getLbTitle());
			labelPanel.add(getLblIndication());
			labelPanel.add(getLblIndication2());
		}
		return labelPanel;
	}
	
	/**
	 * Método getLblIndication
	 * @return lblIndication
	 */
	private JLabel getLblIndication() {
		if (lblIndication == null) {
			lblIndication = new JLabel("Presione el botón para generar los recibos ");
			lblIndication.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIndication.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIndication;
	}
	
	/**
	 * Método getLblIndication2
	 * @return lblIndication2
	 */
	private JLabel getLblIndication2() {
		if (lblIndication2 == null) {
			lblIndication2 = new JLabel("de los colegiados y precolegiados");
			lblIndication2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblIndication2;
	}
	
	/**
	 * Método getButtonPanel
	 * @return buttonPanel
	 */
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getBtGenerateReceipts());
		}
		return buttonPanel;
	}
	
	/**
	 * Método getBtAddApplicant
	 * @return btAddApplicant
	 */
	public JButton getBtGenerateReceipts() {
		if (btGenerateReceipts == null) {
			btGenerateReceipts = new JButton("Generar recibos");
			btGenerateReceipts.setPreferredSize(new Dimension(150, 35));
			btGenerateReceipts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btGenerateReceipts.setForeground(Color.WHITE);
			btGenerateReceipts.setFont(new Font("High Tower Text", Font.BOLD, 16));
			btGenerateReceipts.setBackground(new Color(34, 139, 34));
		}
		return btGenerateReceipts;
	}

	//-- MÉTODOS AUXILIARES --------------------------------------------------------
	/**
	 * Método getFrame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}