package coiipa.view.asignacionpericial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import coiipa.controller.AsignacionPericialController;
import coiipa.view.inscripcion.TarjetaView;
import util.SwingUtil;

/**
 * Titulo: Clase AnulacionView
 *
 * @author Omar Teixeira González, UO281847
 * @version 25 nov 2022
 */
public class AnulacionView extends JDialog {
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo contentPane
	 */
	private JPanel contentPane;
	/**
	 * Atributo pnSuperior
	 */
	private JPanel pnSuperior;
	/**
	 * Atributo lbLogo
	 */
	private JLabel lbLogo;
	/**
	 * Atributo pnCentral
	 */
	private JPanel pnCentral;
	/**
	 * Atributo lblAnularAsignaciones
	 */
	private JLabel lblAnularAsignaciones;
	/**
	 * Atributo pnInferior
	 */
	private JPanel pnInferior;
	/**
	 * Atributo btnConfirmar
	 */
	private JButton btnConfirmar;
	/**
	 * Atributo lblMotivo
	 */
	private JLabel lblMotivo;
	/**
	 * Atributo textAreaMotivo
	 */
	private JTextArea textAreaMotivo;
	/**
	 * Atributo lblAux1
	 */
	private JLabel lblAux1;
	/**
	 * Atributo lblAux2
	 */
	private JLabel lblAux2;
	/**
	 * Atributo lblAux3
	 */
	private JLabel lblAux3;	
	/**
	 * Atributo asignacionController
	 */
	private AsignacionPericialController asignacionController;	
	
	/**
	 * Constructor AnulacionView
	 * @param asignacionController
	 */
	public AnulacionView(AsignacionPericialController asignacionController) {
		this.asignacionController = asignacionController;
		initialize();
	}

	/**
	 * Método initialize
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaView.class.getResource("/images/coiipa_symbol.png")));
		setModal(true);
		setType(Type.POPUP);
		setVisible(false);
		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);		
		setTitle("Administración COIIPA - Anular asignaciones");
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(10, 0));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		
		setContentPane(contentPane);
	}
	
	/**
	 * Método getPnSuperior
	 * @return
	 */
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLblAnularAsignaciones());
		}
		return pnSuperior;
	}
	
	/**
	 * Métogo getLbLogo
	 * @return lbLogo
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(AnulacionView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	
	/**
	 * Método getPnCentral
	 * @return pnCentral
	 */
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new BorderLayout(10, 10));
			pnCentral.add(getLblMotivo(), BorderLayout.NORTH);
			pnCentral.add(getTextAreaMotivo(), BorderLayout.CENTER);
			pnCentral.add(getLblAux1(), BorderLayout.WEST);
			pnCentral.add(getLblAux2(), BorderLayout.EAST);
			pnCentral.add(getLblAux3(), BorderLayout.SOUTH);
		}
		return pnCentral;
	}
	
	/**
	 * Método getLblAnularAsignaciones
	 * @return lblAnularAsignaciones
	 */
	private JLabel getLblAnularAsignaciones() {
		if (lblAnularAsignaciones == null) {
			lblAnularAsignaciones = new JLabel("Anular asignaciones");
			lblAnularAsignaciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnularAsignaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
		}
		return lblAnularAsignaciones;
	}
	
	/**
	 * Método getPnInferior
	 * @return pnInferior
	 */
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.add(getBtnConfirmar());
		}
		return pnInferior;
	}
	
	/**
	 * Método getBtnConfirmar
	 * @return btnConfirmar
	 */
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");			
			btnConfirmar.setPreferredSize(new Dimension(170, 35));
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnConfirmar.setBackground(new Color(34, 139, 34));
			btnConfirmar.addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarCampos(asignacionController)));
		}
		return btnConfirmar;
	}
	
	/**
	 * Método getLblMotivo
	 * @return
	 */
	private JLabel getLblMotivo() {
		if (lblMotivo == null) {
			lblMotivo = new JLabel("Motivo");
			lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblMotivo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblMotivo;
	}
	
	/**
	 * Método getTextAreaMotivo
	 * @return textAreaMotivos
	 */
	private JTextArea getTextAreaMotivo() {
		if (textAreaMotivo == null) {
			textAreaMotivo = new JTextArea();
			textAreaMotivo.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return textAreaMotivo;
	}
	
	
	/**
	 * Método getLbAux1
	 * @return lbAux1
	 */
	private JLabel getLblAux1() {
		if (lblAux1 == null) {
			lblAux1 = new JLabel("               ");
		}
		return lblAux1;
	}
	
	/**
	 * Método getLbAux2
	 * @return lblAux2
	 */
	private JLabel getLblAux2() {
		if (lblAux2 == null) {
			lblAux2 = new JLabel("               ");
		}
		return lblAux2;
	}
	
	/**
	 * Método getLbAux3
	 * @return lblAux3
	 */
	private JLabel getLblAux3() {
		if (lblAux3 == null) {
			lblAux3 = new JLabel(" ");
		}
		return lblAux3;
	}
	
	/**
	 * Método comprobarCampos
	 * @param asignacionController
	 */
	private void comprobarCampos(AsignacionPericialController asignacionController) {
		if (textAreaMotivo.getText().isBlank()) {
			SwingUtil.showErrorDialog("El motivo de la anulación es obligatorio");
		} else {
			asignacionController.anularAsignacion(textAreaMotivo.getText());
		}
	}
}
