package coiipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

/**
 * 
 * Título: Clase SolicitudVisadoView
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class SolicitudVisadoView {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnInferior;
	private JButton btConfirmar;
	private JPanel panelNombre;
	private JPanel panelDescripción;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblApellido;
	private JTextField textFieldApellido;
	private JLabel lblDescripcion;
	private JLabel lblDni;
	private JTextField textFieldDni;
	private JTextArea textAreaDescripcion;
	private JLabel lblAux1;
	private JLabel lblAux2;
	private JLabel lblAux3;
	private JLabel lbSolicitud;

	/**
	 * Create the frame.
	 */
	public SolicitudVisadoView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SolicitudVisadoView.class.getResource("/images/coiipa_symbol.png")));
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Solicitud de visado");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1500, 900);
		frame.setMinimumSize(new Dimension(1500,900));
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frame.getRootPane().setDefaultButton(btConfirmar);
	}

	
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new GridLayout(1, 2, 10, 0));
			pnCentro.add(getPanelNombre());
			pnCentro.add(getPanelDescripción());
		}
		return pnCentro;
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLbSolicitud_1());
		}
		return pnSuperior;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(SolicitudVisadoView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtConfirmar());
		}
		return pnInferior;
	}
	public JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar");
			btConfirmar.setFocusable(false);
			btConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btConfirmar.setForeground(Color.WHITE);
			btConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btConfirmar.setBackground(new Color(34, 139, 34));
		}
		return btConfirmar;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
	private JPanel getPanelNombre() {
		if (panelNombre == null) {
			panelNombre = new JPanel();
			panelNombre.setBackground(Color.WHITE);
			panelNombre.setLayout(new GridLayout(0, 1, 0, 10));
			panelNombre.add(getLblDni());
			panelNombre.add(getTextFieldDni());
			panelNombre.add(getLblNombre());
			panelNombre.add(getTextFieldNombre());
			panelNombre.add(getLblApellido());
			panelNombre.add(getTextFieldApellido());

		}
		return panelNombre;
	}
	private JPanel getPanelDescripción() {
		if (panelDescripción == null) {
			panelDescripción = new JPanel();
			panelDescripción.setBackground(Color.WHITE);
			panelDescripción.setLayout(new BorderLayout(25, 50));
			panelDescripción.add(getLblDescripcion(), BorderLayout.NORTH);
			panelDescripción.add(getTextAreaDescripcion());
			panelDescripción.add(getLblAux1(), BorderLayout.WEST);
			panelDescripción.add(getLblAux2(), BorderLayout.EAST);
			panelDescripción.add(getLblAux3(), BorderLayout.SOUTH);
		}
		return panelDescripción;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setMaximumSize(new Dimension(200, 50));
			lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblNombre;
	}
	public JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldNombre.setBackground(Color.LIGHT_GRAY);
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNombre.setMaximumSize(new Dimension(280, 30));
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	
	private JLabel getLblApellido() {
		if (lblApellido == null) {
			lblApellido = new JLabel("Apellidos");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellido.setMaximumSize(new Dimension(200, 50));
			lblApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return lblApellido;
	}
	public JTextField getTextFieldApellido() {
		if (textFieldApellido == null) {
			textFieldApellido = new JTextField();
			textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldApellido.setBackground(Color.LIGHT_GRAY);
			textFieldApellido.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldApellido.setMaximumSize(new Dimension(280, 30));
			textFieldApellido.setColumns(10);
		}
		return textFieldApellido;
	}

	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción");
			lblDescripcion.setBorder(new EmptyBorder(10, 0, 0, 0));
			lblDescripcion.setMinimumSize(new Dimension(200, 50));
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDescripcion.setMaximumSize(new Dimension(200, 50));
			lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescripcion.setAlignmentX(0.5f);
		}
		return lblDescripcion;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDni.setMaximumSize(new Dimension(200, 50));
			lblDni.setHorizontalAlignment(SwingConstants.CENTER);
			lblDni.setAlignmentX(0.5f);
		}
		return lblDni;
	}
	public JTextField getTextFieldDni() {
		if (textFieldDni == null) {
			MaskFormatter mf = null;
			try {
				mf = new MaskFormatter("########U");
			} catch (ParseException e) {
				System.out.println("Excepción capturada: JFormattedTextField");
			}
			textFieldDni = new JFormattedTextField(mf);	
			textFieldDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldDni.setBackground(Color.LIGHT_GRAY);
			textFieldDni.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDni.setMaximumSize(new Dimension(280, 30));
			textFieldDni.setColumns(10);
		}
		return textFieldDni;
	}
	public JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setFont(new Font("Monospaced", Font.PLAIN, 16));
			textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
			textAreaDescripcion.setMinimumSize(new Dimension(280, 90));
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setMaximumSize(new Dimension(280, 150));
		}
		return textAreaDescripcion;
	}
	private JLabel getLblAux1() {
		if (lblAux1 == null) {
			lblAux1 = new JLabel("                ");
		}
		return lblAux1;
	}
	private JLabel getLblAux2() {
		if (lblAux2 == null) {
			lblAux2 = new JLabel("                ");
		}
		return lblAux2;
	}
	private JLabel getLblAux3() {
		if (lblAux3 == null) {
			lblAux3 = new JLabel("                ");
		}
		return lblAux3;
	}
	private JLabel getLbSolicitud_1() {
		if (lbSolicitud == null) {
			lbSolicitud = new JLabel("Solicitud de visado");
			lbSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
			lbSolicitud.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lbSolicitud;
	}
}
