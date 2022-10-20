package colegiado.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ui_events.ProccessKeyNoDigits;

/**
 * Título: Clase SolicitanteView
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ColegiadoView extends JFrame {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constante ID_LENGTH
	 */
	private static final int ID_LENGTH = 9;
	/**
	 * Constante YEAR_LENGTH 
	 */
	private static final int YEAR_LENGTH = 4;
	/**
	 * Constante TELEPHONE_LENGTH 
	 */
	private static final int TELEPHONE_LENGTH = 12;
	/**
	 * Constante IBAN_LENGTH 
	 */
	private static final int IBAN_LENGTH = 28;

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
	 * Atributo applicantPanel
	 */
	private JPanel applicantPanel;
	/**
	 * Atributo lbApplicant
	 */
	private JLabel lbApplicant;
	/**
	 * Atributo bottomPanel
	 */
	private JPanel bottomPanel;
	/**
	 * Atributo btAddApplicant
	 */
	private JButton btAddApplicant;
	/**
	 * Atributo middlePanel
	 */
	private JPanel middlePanel;
	/**
	 * Atributo leftDataPanel
	 */
	private JPanel leftDataPanel;
	/**
	 * Atributo middleDataPanel
	 */
	private JPanel middleDataPanel;
	/**
	 * Atributo rightDataPanel
	 */
	private JPanel rightDataPanel;
	/**
	 * Atributo dniPanel
	 */
	private JPanel dniPanel;
	/**
	 * Atributo lbDni
	 */
	private JLabel lbDni;
	/**
	 * Atributo txtDni
	 */
	private JTextField txtDni;
	/**
	 * Atributo namePanel
	 */
	private JPanel namePanel;
	/**
	 * Atributo lbName
	 */
	private JLabel lbName;
	/**
	 * Atributo txtName
	 */
	private JTextField txtName;
	/**
	 * Atributo surnamePanel
	 */
	private JPanel surnamePanel;
	/**
	 * Atributo lbSurname
	 */
	private JLabel lbSurname;
	/**
	 * Atributo txtSurname
	 */
	private JTextField txtSurname;	
	/**
	 * Atributo populationPanel
	 */
	private JPanel populationPanel;
	/**
	 * Atributo lbPopulation
	 */
	private JLabel lbPopulation;
	/**
	 * Atributo txtPopulation
	 */
	private JTextField txtPopulation;
	/**
	 * Atributo telephonePanel
	 */
	private JPanel telephonePanel;
	/**
	 * Atributo lbTelephone
	 */
	private JLabel lbTelephone;
	/**
	 * Atributo txtTelephone
	 */
	private JTextField txtTelephone;
	/**
	 * Atributo titulationPanel
	 */
	private JPanel titulationPanel;
	/**
	 * Atributo lbTitulation
	 */
	private JLabel lbTitulation;
	/**
	 * Atributo txtTitulation
	 */
	private JTextField txtTitulation;	
	/**
	 * Atributo centerPanel
	 */
	private JPanel centerPanel;
	/**
	 * Atributo lbCenter
	 */
	private JLabel lbCenter;
	/**
	 * Atributo txtCenter
	 */
	private JTextField txtCenter;
	/**
	 * Atributo yearPanel
	 */
	private JPanel yearPanel;
	/**
	 * Atributo lbYear
	 */
	private JLabel lbYear;
	/**
	 * Atributo txtYear
	 */
	private JTextField txtYear;
	/**
	 * Atributo ibanPanel
	 */
	private JPanel ibanPanel;
	/**
	 * Atributo lbIban
	 */
	private JLabel lbIban;
	/**
	 * Atributo txtIban
	 */
	private JTextField txtIban;	

//-- INTERFAZ GRÁFICA ----------------------------------------------------------
	/**
	 * Constructor ApplicantView
	 */
	public ColegiadoView() {
		initialize();
	}
	
	/**
	 * Método initialize
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Solicitud de alta");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ColegiadoView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));
		contentPane.add(getUpperPanel(), BorderLayout.NORTH);
		contentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		frame.getRootPane().setDefaultButton(btAddApplicant);
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
			upperPanel.add(getApplicantPanel());
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
			lbLogo.setIcon(new ImageIcon(ColegiadoView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	
	/**
	 * Método getApplicationPanel
	 * @return applicantPanel
	 */
	private JPanel getApplicantPanel() {
		if (applicantPanel == null) {
			applicantPanel = new JPanel();
			applicantPanel.setBackground(Color.WHITE);
			applicantPanel.add(getLbApplicant());
		}
		return applicantPanel;
	}
	
	/**
	 * getLbApplicant
	 * @return lbApplicant
	 */
	private JLabel getLbApplicant() {
		if (lbApplicant == null) {
			lbApplicant = new JLabel("Solicitud de alta");
			lbApplicant.setHorizontalAlignment(SwingConstants.CENTER);
			lbApplicant.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbApplicant;
	}
	
	/**
	 * Método getBottomPanel
	 * @return bottomPanel
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			bottomPanel = new JPanel();
			bottomPanel.setBackground(Color.WHITE);
			bottomPanel.add(getBtAddApplicant());
		}
		return bottomPanel;
	}
	
	/**
	 * Método getBtAddApplicant
	 * @return btAddApplicant
	 */
	public JButton getBtAddApplicant() {
		if (btAddApplicant == null) {
			btAddApplicant = new JButton("Presentar solicitud");
			btAddApplicant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAddApplicant.setForeground(Color.WHITE);
			btAddApplicant.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btAddApplicant.setBackground(new Color(34, 139, 34));
		}
		return btAddApplicant;
	}
	
	/**
	 * Método getRegisterPanel
	 * @return middlePanel
	 */
	private JPanel getMiddlePanel() {
		if (middlePanel == null) {
			middlePanel = new JPanel();
			middlePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), 
					"Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			middlePanel.setLayout(new GridLayout(0, 3, 10, 10));
			middlePanel.add(getLeftDataPanel());
			middlePanel.add(getMiddleDataPanel());
			middlePanel.add(getRightDataPanel());
		}
		return middlePanel;
	}
	
	/**
	 * Método getLeftDataPanel
	 * @return leftDataPanel
	 */
	private JPanel getLeftDataPanel() {
		if (leftDataPanel == null) {
			leftDataPanel = new JPanel();
			leftDataPanel.setLayout(new GridLayout(3, 0, 5, 10));
			leftDataPanel.add(getDniPanel());
			leftDataPanel.add(getNamePanel());
			leftDataPanel.add(getSurnamePanel());
		}
		return leftDataPanel;
	}
	
	/**
	 * Método getDniPanel
	 * @return dniPanel
	 */
	private JPanel getDniPanel() {
		if (dniPanel == null) {
			dniPanel = new JPanel();
			dniPanel.setBackground(Color.WHITE);
			dniPanel.setLayout(new GridLayout(2, 2, 0, 5));
			dniPanel.add(getLbDni());
			dniPanel.add(getTxtDni());
		}
		return dniPanel;
	}
	
	/**
	 * Método getLbDni
	 * @return lbDni
	 */
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI");
			lbDni.setHorizontalAlignment(SwingConstants.CENTER);
			lbDni.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbDni;
	}
	
	/**
	 * Método getTxtDni
	 * @return txtDni
	 */
	public JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setPreferredSize(new Dimension(10, 25));
			txtDni.setHorizontalAlignment(SwingConstants.CENTER);
			txtDni.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtDni.setColumns(10);
			txtDni.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtDni.setBackground(Color.LIGHT_GRAY);
			txtDni.addKeyListener(new ProccessKeyDni());
		}
		return txtDni;
	}
	
	/**
	 * Método getNamePanel
	 * @return namePanel
	 */
	private JPanel getNamePanel() {
		if (namePanel == null) {
			namePanel = new JPanel();
			namePanel.setBackground(Color.WHITE);
			namePanel.setLayout(new GridLayout(2, 2, 0, 5));
			namePanel.add(getLbName());
			namePanel.add(getTxtName());
		}
		return namePanel;
	}
	
	/**
	 * Método getLbName
	 * @return lbName
	 */
	private JLabel getLbName() {
		if (lbName == null) {
			lbName = new JLabel("Nombre");
			lbName.setHorizontalAlignment(SwingConstants.CENTER);
			lbName.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbName;
	}
	
	/**
	 * Método getTxtName
	 * @return txtName
	 */
	public JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setPreferredSize(new Dimension(10, 25));
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtName.setColumns(10);
			txtName.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtName.setBackground(Color.LIGHT_GRAY);
			txtName.addKeyListener(new ProccessKeyNoDigits());
		}
		return txtName;
	}
	
	/**
	 * Método getSurnamePanel
	 * @return surnamePanel
	 */
	private JPanel getSurnamePanel() {
		if (surnamePanel == null) {
			surnamePanel = new JPanel();
			surnamePanel.setBackground(Color.WHITE);
			surnamePanel.setLayout(new GridLayout(2, 2, 0, 5));
			surnamePanel.add(getLbSurname());
			surnamePanel.add(getTxtSurname());
		}
		return surnamePanel;
	}
	
	/**
	 * Método getLbSurname
	 * @return lbSurname
	 */
	private JLabel getLbSurname() {
		if (lbSurname == null) {
			lbSurname = new JLabel("Apellidos");
			lbSurname.setHorizontalAlignment(SwingConstants.CENTER);
			lbSurname.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbSurname;
	}
	
	/**
	 * Método getTxtSurname
	 * @return txtSurname
	 */
	public JTextField getTxtSurname() {
		if (txtSurname == null) {
			txtSurname = new JTextField();
			txtSurname.setPreferredSize(new Dimension(10, 25));
			txtSurname.setHorizontalAlignment(SwingConstants.CENTER);
			txtSurname.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtSurname.setColumns(10);
			txtSurname.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtSurname.setBackground(Color.LIGHT_GRAY);
			txtSurname.addKeyListener(new ProccessKeyNoDigits());
		}
		return txtSurname;
	}
	
	/**
	 * Método getMiddleDataPanel
	 * @return middleDataPanel
	 */
	private JPanel getMiddleDataPanel() {
		if (middleDataPanel == null) {
			middleDataPanel = new JPanel();
			middleDataPanel.setLayout(new GridLayout(3, 0, 5, 10));
			middleDataPanel.add(getPopulationPanel());
			middleDataPanel.add(getTelephonePanel());
			middleDataPanel.add(getTitulationPanel());
		}
		return middleDataPanel;
	}
	
	/**
	 * Método getPopulationPanel
	 * @return populationPanel
	 */
	private JPanel getPopulationPanel() {
		if (populationPanel == null) {
			populationPanel = new JPanel();
			populationPanel.setBackground(Color.WHITE);
			populationPanel.setLayout(new GridLayout(2, 2, 0, 5));
			populationPanel.add(getLbPopulation());
			populationPanel.add(getTxtPopulation());
		}
		return populationPanel;
	}
	
	/**
	 * Método lbPopulation
	 * @return lbPopulation
	 */
	private JLabel getLbPopulation() {
		if (lbPopulation == null) {
			lbPopulation = new JLabel("Población");
			lbPopulation.setHorizontalAlignment(SwingConstants.CENTER);
			lbPopulation.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbPopulation;
	}
	
	/**
	 * Método getTxtPopulation
	 * @return txtPopulation
	 */
	public JTextField getTxtPopulation() {
		if (txtPopulation == null) {
			txtPopulation = new JTextField();
			txtPopulation.setPreferredSize(new Dimension(10, 25));
			txtPopulation.setHorizontalAlignment(SwingConstants.CENTER);
			txtPopulation.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtPopulation.setColumns(10);
			txtPopulation.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtPopulation.setBackground(Color.LIGHT_GRAY);
			txtPopulation.addKeyListener(new ProccessKeyNoDigits());
		}
		return txtPopulation;
	}
	
	/**
	 * Método getTelephonePanel
	 * @return telephonePanel
	 */
	private JPanel getTelephonePanel() {
		if (telephonePanel == null) {
			telephonePanel = new JPanel();
			telephonePanel.setBackground(Color.WHITE);
			telephonePanel.setLayout(new GridLayout(2, 2, 0, 5));
			telephonePanel.add(getLbTelephone());
			telephonePanel.add(getTxtTelephone());
		}
		return telephonePanel;
	}
	
	/**
	 * Método getLbTelephone
	 * @return lbTelephone
	 */
	private JLabel getLbTelephone() {
		if (lbTelephone == null) {
			lbTelephone = new JLabel("Teléfono");
			lbTelephone.setHorizontalAlignment(SwingConstants.CENTER);
			lbTelephone.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbTelephone;
	}
	
	/**
	 * Método getTxtTelephone
	 * @return txtTelephone
	 */
	public JTextField getTxtTelephone() {
		if (txtTelephone == null) {
			txtTelephone = new JTextField();
			txtTelephone.setPreferredSize(new Dimension(10, 25));
			txtTelephone.setHorizontalAlignment(SwingConstants.CENTER);
			txtTelephone.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtTelephone.setColumns(10);
			txtTelephone.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtTelephone.setBackground(Color.LIGHT_GRAY);
			txtTelephone.addKeyListener(new ProccessKeyTelephone());
		}
		return txtTelephone;
	}
	
	/**
	 * Método getTitulationPanel
	 * @return titulationPanel
	 */
	private JPanel getTitulationPanel() {
		if (titulationPanel == null) {
			titulationPanel = new JPanel();
			titulationPanel.setBackground(Color.WHITE);
			titulationPanel.setLayout(new GridLayout(2, 2, 0, 5));
			titulationPanel.add(getLbTitulation());
			titulationPanel.add(getTxtTitulation());
		}
		return titulationPanel;
	}
	
	/**
	 * Método getLbTitulation
	 * @return lbTitulation
	 */
	private JLabel getLbTitulation() {
		if (lbTitulation == null) {
			lbTitulation = new JLabel("Titulación");
			lbTitulation.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulation.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbTitulation;
	}
	
	/**
	 * Método getTxtTitulation
	 * @return txtTitulation
	 */
	public JTextField getTxtTitulation() {
		if (txtTitulation == null) {
			txtTitulation = new JTextField();
			txtTitulation.setPreferredSize(new Dimension(10, 25));
			txtTitulation.setHorizontalAlignment(SwingConstants.CENTER);
			txtTitulation.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtTitulation.setColumns(10);
			txtTitulation.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtTitulation.setBackground(Color.LIGHT_GRAY);
		}
		return txtTitulation;
	}
	
	/**
	 * Método getRightDataPanel
	 * @return rightDataPanel
	 */
	private JPanel getRightDataPanel() {
		if (rightDataPanel == null) {
			rightDataPanel = new JPanel();
			rightDataPanel.setLayout(new GridLayout(3, 0, 5, 10));
			rightDataPanel.add(getCenterPanel());
			rightDataPanel.add(getYearPanel());
			rightDataPanel.add(getIbanPanel());
		}
		return rightDataPanel;
	}
	
	/**
	 * Método getCenterPanel
	 * @return centerPanel
	 */
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setBackground(Color.WHITE);
			centerPanel.setLayout(new GridLayout(2, 2, 0, 5));
			centerPanel.add(getLbCenter());
			centerPanel.add(getTxtCenter());
		}
		return centerPanel;
	}
	
	/**
	 * Método getLbCenter
	 * @return lbCenter
	 */
	private JLabel getLbCenter() {
		if (lbCenter == null) {
			lbCenter = new JLabel("Centro de titulación");
			lbCenter.setHorizontalAlignment(SwingConstants.CENTER);
			lbCenter.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbCenter;
	}
	
	/**
	 * Método getTxtCenter
	 * @return txtCenter
	 */
	public JTextField getTxtCenter() {
		if (txtCenter == null) {
			txtCenter = new JTextField();
			txtCenter.setPreferredSize(new Dimension(10, 25));
			txtCenter.setHorizontalAlignment(SwingConstants.CENTER);
			txtCenter.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtCenter.setColumns(10);
			txtCenter.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtCenter.setBackground(Color.LIGHT_GRAY);
		}
		return txtCenter;
	}
	
	/**
	 * Método getYearPanel
	 * @return yearPanel
	 */
	private JPanel getYearPanel() {
		if (yearPanel == null) {
			yearPanel = new JPanel();
			yearPanel.setBackground(Color.WHITE);
			yearPanel.setLayout(new GridLayout(2, 2, 0, 5));
			yearPanel.add(getLbYear());
			yearPanel.add(getTxtYear());
		}
		return yearPanel;
	}
	
	/**
	 * Método getLbYear
	 * @return lbYear
	 */
	private JLabel getLbYear() {
		if (lbYear == null) {
			lbYear = new JLabel("Año de titulación");
			lbYear.setHorizontalAlignment(SwingConstants.CENTER);
			lbYear.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbYear;
	}
	
	/**
	 * Método getTxtYear
	 * @return txtYear
	 */
	public JTextField getTxtYear() {
		if (txtYear == null) {
			txtYear = new JTextField();
			txtYear.setPreferredSize(new Dimension(10, 25));
			txtYear.setHorizontalAlignment(SwingConstants.CENTER);
			txtYear.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtYear.setColumns(10);
			txtYear.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtYear.setBackground(Color.LIGHT_GRAY);
		}
		return txtYear;
	}
	
	/**
	 * Método getIbanPanel
	 * @return ibanPanel
	 */
	private JPanel getIbanPanel() {
		if (ibanPanel == null) {
			ibanPanel = new JPanel();
			ibanPanel.setBackground(Color.WHITE);
			ibanPanel.setLayout(new GridLayout(2, 2, 0, 5));
			ibanPanel.add(getLbIban());
			ibanPanel.add(getTxtIban());
		}
		return ibanPanel;
	}
	
	/**
	 * Método getLbIban
	 * @return lbIban
	 */
	private JLabel getLbIban() {
		if (lbIban == null) {
			lbIban = new JLabel("IBAN");
			lbIban.setHorizontalAlignment(SwingConstants.CENTER);
			lbIban.setFont(new Font("High Tower Text", Font.BOLD, 16));
		}
		return lbIban;
	}
	
	/**
	 * Método getTxtIban
	 * @return txtIban
	 */
	public JTextField getTxtIban() {
		if (txtIban == null) {
			txtIban = new JTextField();
			txtIban.setPreferredSize(new Dimension(10, 25));
			txtIban.setHorizontalAlignment(SwingConstants.CENTER);
			txtIban.setFont(new Font("Calibri", Font.PLAIN, 16));
			txtIban.setColumns(10);
			txtIban.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtIban.setBackground(Color.LIGHT_GRAY);
		}
		return txtIban;
	}
	
//-- MÉTODOS AUXILIARES --------------------------------------------------------
	/**
	 * Método getFrame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Método getDni
	 * @return string 
	 */
	public String getDni() {
		return getTxtDni().getText();
	}
	
	/**
	 * Método getName
	 * @return string 
	 */
	public String getName() {
		return getTxtName().getText();
	}
	
	/**
	 * Método getSurname
	 * @return string 
	 */
	public String getSurname() {
		return getTxtSurname().getText();
	}
	
	/**
	 * Método getPopulation
	 * @return string 
	 */
	public String getPopulation() {
		return getTxtPopulation().getText();
	}
	
	/**
	 * Método getTelephone
	 * @return string 
	 */
	public String getTelephone() {
		return getTxtTelephone().getText();
	}
	
	/**
	 * Método getTitulation
	 * @return string 
	 */
	public String getTitulation() {
		return getTxtTitulation().getText();
	}
	
	/**
	 * Método getCenter
	 * @return string 
	 */
	public String getCenter() {
		return getTxtCenter().getText();
	}
	
	/**
	 * Método getYear
	 * @return string 
	 */
	public String getYear() {
		return getTxtYear().getText();
	}
	
	/**
	 * Método getIban
	 * @return string 
	 */
	public String getIban() {
		return getTxtIban().getText();
	}
		
	/**
	 * Método resetFields
	 */
	public void resetFields() {
		resetText();
		resetColor();
	}	
	
	/**
	 * Método resetText
	 */
	private void resetText() {
		getTxtDni().setText("");
		getTxtName().setText("");
		getTxtSurname().setText("");
		getTxtPopulation().setText("");
		getTxtTelephone().setText("");
		getTxtTitulation().setText("");
		getTxtCenter().setText("");
		getTxtYear().setText("");
		getTxtIban().setText("");
	}
	
	/**
	 * Método resetColor
	 */	
	private void resetColor() {
		getTxtDni().setBackground(Color.LIGHT_GRAY);
		getTxtName().setBackground(Color.LIGHT_GRAY);
		getTxtSurname().setBackground(Color.LIGHT_GRAY);
		getTxtPopulation().setBackground(Color.LIGHT_GRAY);
		getTxtTelephone().setBackground(Color.LIGHT_GRAY);
		getTxtTitulation().setBackground(Color.LIGHT_GRAY);
		getTxtCenter().setBackground(Color.LIGHT_GRAY);
		getTxtYear().setBackground(Color.LIGHT_GRAY);
		getTxtIban().setBackground(Color.LIGHT_GRAY);
	}
	
//-- EVENTOS--------------------------------------------------------------------
	/**
	 * Título: Clase ProccessKeyDni
	 *
	 * @author Omar Teixeira González, UO281847
	 * @version 9 oct 2022
	 */
	public class ProccessKeyDni extends KeyAdapter {
		/**
		 * Método keyTyped
		 * @param e
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			if (getTxtDni().getText().length()==ID_LENGTH) {
				e.consume();
			} else if (getTxtDni().getText().length()<8) {
				if (Character.isAlphabetic(pressedKey)) {
					e.consume();
				}
			} else if (getTxtDni().getText().length()>=8) {
				if (Character.isAlphabetic(pressedKey)) {
					e.setKeyChar(String.valueOf(pressedKey).toUpperCase().charAt(0));
				} else if (Character.isDigit(pressedKey)) {
					e.consume();
				}
			}
		}
	}	
	
	/**
	 * Título: Clase ProccessKeyTelephone
	 *
	 * @author Omar Teixeira González, UO281847
	 * @version 9 oct 2022
	 */
	public class ProccessKeyTelephone extends KeyAdapter {
		/**
		 * Método keyTyped
		 * @param e
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			if (getTxtTelephone().getText().length()==TELEPHONE_LENGTH) {
				e.consume();
			} else {
				if (Character.isAlphabetic(pressedKey)) {
					e.consume();
				}
			}
		}
	}
	
	/**
	 * Título: Clase ProccessKeyYear
	 *
	 * @author Omar Teixeira González, UO281847
	 * @version 9 oct 2022
	 */
	public class ProccessKeyYear extends KeyAdapter {
		/**
		 * Método keyTyped
		 * @param e
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			if (getTxtYear().getText().length()==YEAR_LENGTH) {
				e.consume();
			} else {
				if (Character.isAlphabetic(pressedKey)) {
					e.consume();
				}
			}
		}
	}	
		
	/**
	 * Título: Clase ProccessKeyIban
	 *
	 * @author Omar Teixeira González, UO281847
	 * @version 9 oct 2022
	 */
	public class ProccessKeyIban extends KeyAdapter {
		/**
		 * Método keyTyped
		 * @param e
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			if (getTxtIban().getText().length()==IBAN_LENGTH) {
				e.consume();
			} else {
				if (getTxtIban().getText().length()<2) {
					if (Character.isAlphabetic(pressedKey)) {
						e.setKeyChar(String.valueOf(pressedKey).toUpperCase().charAt(0));
					} else if (Character.isDigit(pressedKey)) {
						e.consume();
					}
				} else {
					if (Character.isAlphabetic(pressedKey)) {
						e.consume();
					}
				}
			}
		}
	}		
}