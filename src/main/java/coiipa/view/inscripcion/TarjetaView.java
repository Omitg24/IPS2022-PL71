package coiipa.view.inscripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import coiipa.controller.InscripcionController;
import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import util.SwingUtil;

public class TarjetaView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumero;
	private JLabel lbNumero;
	private JTextField txtFechaCaducidad;
	private JLabel lbFechaCaducidad;
	private JTextField txtCvv;
	private JLabel lbCvv;

	/**
	 * Create the dialog.
	 */
	public TarjetaView(InscripcionController inscripcion) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaView.class.getResource("/images/coiipa_symbol.png")));
		setModal(true);
		setTitle("Administración COIIPA - Confirmar pago ");
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBounds(100, 100, 800, 450);
		setMinimumSize(new Dimension(800, 450));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnDatos = new JPanel();
			pnDatos.setBorder(
					new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de la tarjeta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatos.setBackground(Color.WHITE);
			contentPanel.add(pnDatos);
			pnDatos.setLayout(new GridLayout(3, 1, 0, 0));
			{
				JPanel pnNumero = new JPanel();
				pnNumero.setBackground(Color.WHITE);
				pnDatos.add(pnNumero);
				{
					lbNumero = new JLabel("Número Tarjeta:  ");
					lbNumero.setBackground(Color.WHITE);
					lbNumero.setDisplayedMnemonic('N');
					lbNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
					pnNumero.add(lbNumero);
				}
				{
					txtNumero = new JTextField();
					txtNumero.setBackground(Color.LIGHT_GRAY);
					txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
					txtNumero.addFocusListener(new ChangeColor());
					txtNumero.addKeyListener(new ProccessKeyTarjeta());
					lbNumero.setLabelFor(txtNumero);
					txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
					pnNumero.add(txtNumero);
					txtNumero.setColumns(10);
				}
			}
			{
				JPanel pnFecha = new JPanel();
				pnFecha.setBackground(Color.WHITE);
				pnDatos.add(pnFecha);
				{
					lbFechaCaducidad = new JLabel("Fecha Caducidad:");
					lbFechaCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lbFechaCaducidad.setDisplayedMnemonic('F');
					lbFechaCaducidad.setBackground(Color.WHITE);
					pnFecha.add(lbFechaCaducidad);
				}
				{
					txtFechaCaducidad = new JTextField();
					txtFechaCaducidad.setText("(MM/YY)");
					txtFechaCaducidad.setHorizontalAlignment(SwingConstants.CENTER);
					txtFechaCaducidad.setBackground(Color.LIGHT_GRAY);
					txtFechaCaducidad.setForeground(Color.white);
					lbFechaCaducidad.setLabelFor(txtFechaCaducidad);
					txtFechaCaducidad.addFocusListener(new ChangeDateColor("(MM/YY)"));
					txtFechaCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
					txtFechaCaducidad.setColumns(10);
					pnFecha.add(txtFechaCaducidad);
				}
			}
			{
				JPanel pnNumero = new JPanel();
				pnNumero.setBackground(Color.WHITE);
				pnDatos.add(pnNumero);
				{
					lbCvv = new JLabel("CVV:                ");
					lbCvv.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lbCvv.setDisplayedMnemonic('C');
					lbCvv.setBackground(Color.WHITE);
					pnNumero.add(lbCvv);
				}
				{
					txtCvv = new JPasswordField();
					lbCvv.setLabelFor(txtCvv);
					txtCvv.setHorizontalAlignment(SwingConstants.CENTER);
					txtCvv.setFont(new Font("Tahoma", Font.PLAIN, 18));
					txtCvv.setColumns(10);
					txtCvv.setBackground(Color.LIGHT_GRAY);
					txtCvv.addFocusListener(new ChangeColor());
					pnNumero.add(txtCvv);
				}
			}
		}
		{
			JPanel pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			contentPanel.add(pnSuperior, BorderLayout.NORTH);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JLabel lbLogo = new JLabel("");
				lbLogo.setIcon(new ImageIcon(TarjetaView.class.getResource("/images/coiipa_logo.jpg")));
				pnSuperior.add(lbLogo);
			}
			{
				JLabel lbInscripcion = new JLabel("Confirmar pago");
				lbInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
				lbInscripcion.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
				pnSuperior.add(lbInscripcion);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setBackground(Color.WHITE);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setHgap(50);
			buttonPane.setLayout(fl_buttonPane);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 128, 0));
				okButton.addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarCampos(inscripcion)));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 24));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.RED);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 24));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void comprobarCampos(InscripcionController inscripcion) {
		if (txtFechaCaducidad.getText().isBlank() || txtNumero.getText().isBlank()
				|| txtCvv.getText().isBlank()) {
			SwingUtil.showErrorDialog("Los campos no pueden estar vacios");

		} else if (!comprobarFechaCaducidad()){
			SwingUtil.showErrorDialog("La fecha de caducidad es anterior a la actual");
		}else {
			inscripcion.confirmarPago("Tarjeta");
		}

	}

	private boolean comprobarFechaCaducidad() {
		String[] fecha = txtFechaCaducidad.getText().split("/");
		int year =2000+ Integer.parseInt(fecha[1]);
		int month = Integer.parseInt(fecha[0]);
		return LocalDateTime.now().toLocalDate().isBefore(LocalDate.of(year, month, 1));
	}

	public class ProccessKeyTarjeta extends KeyAdapter {
		/**
		 * Método keyTyped
		 * 
		 * @param e
		 */
		public void keyTyped(KeyEvent e) {
			char pressedKey = e.getKeyChar();
			if (Character.isAlphabetic(pressedKey)) {
				e.consume();
			}

		}
	}

}
