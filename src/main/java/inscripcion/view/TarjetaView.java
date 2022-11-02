package inscripcion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import inscripcion.controller.InscripcionController;
import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import util.SwingUtil;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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

	/**
	 * Create the dialog.
	 */
	public TarjetaView(InscripcionController inscripcion) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaView.class.getResource("/images/coiipa_symbol.png")));
		setResizable(false);
		setModal(true);
		setTitle("Confirmar pago con tarjeta");
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBounds(100, 100, 618, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnDatos = new JPanel();
			pnDatos.setBorder(
					new TitledBorder(null, "Datos tarjeta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatos.setBackground(Color.WHITE);
			contentPanel.add(pnDatos);
			pnDatos.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JPanel pnNumero = new JPanel();
				pnNumero.setBackground(Color.WHITE);
				pnDatos.add(pnNumero);
				{
					lbNumero = new JLabel("Número Tarjeta:");
					lbNumero.setBackground(Color.WHITE);
					lbNumero.setDisplayedMnemonic('N');
					lbNumero.setFont(new Font("Calibri", Font.BOLD, 14));
					pnNumero.add(lbNumero);
				}
				{
					txtNumero = new JTextField();
					txtNumero.setBackground(Color.LIGHT_GRAY);
					txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
					txtNumero.addFocusListener(new ChangeColor());
					txtNumero.addKeyListener(new ProccessKeyTarjeta());
					lbNumero.setLabelFor(txtNumero);
					txtNumero.setFont(new Font("Calibri", Font.PLAIN, 14));
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
					lbFechaCaducidad.setFont(new Font("Calibri", Font.BOLD, 14));
					lbFechaCaducidad.setDisplayedMnemonic('F');
					lbFechaCaducidad.setBackground(Color.WHITE);
					pnFecha.add(lbFechaCaducidad);
				}
				{
					txtFechaCaducidad = new JTextField();
					txtFechaCaducidad.setHorizontalAlignment(SwingConstants.CENTER);
					txtFechaCaducidad.setBackground(Color.LIGHT_GRAY);
					txtFechaCaducidad.setForeground(Color.white);
					txtFechaCaducidad.setText("(MM/YY)");
					lbFechaCaducidad.setLabelFor(txtFechaCaducidad);
					txtFechaCaducidad.addFocusListener(new ChangeDateColor("(MM/YY)"));
					txtFechaCaducidad.setFont(new Font("Calibri", Font.PLAIN, 14));
					txtFechaCaducidad.setColumns(10);
					pnFecha.add(txtFechaCaducidad);
				}
			}
		}
		{
			JPanel pnSur = new JPanel();
			pnSur.setPreferredSize(new Dimension(10, 35));
			pnSur.setBackground(Color.WHITE);
			contentPanel.add(pnSur, BorderLayout.SOUTH);
		}
		{
			JPanel pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			contentPanel.add(pnSuperior, BorderLayout.NORTH);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			{
				JLabel lbLogo = new JLabel("");
				lbLogo.setIcon(new ImageIcon(TarjetaView.class.getResource("/images/coiipa_logo.jpg")));
				pnSuperior.add(lbLogo);
			}
			{
				JPanel pnTituloSup = new JPanel();
				pnTituloSup.setBackground(Color.WHITE);
				pnSuperior.add(pnTituloSup);
				{
					JLabel lbInscripcion = new JLabel("Confrimar Pago");
					lbInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
					lbInscripcion.setFont(new Font("High Tower Text", Font.PLAIN, 32));
					pnTituloSup.add(lbInscripcion);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			fl_buttonPane.setHgap(50);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 128, 0));
				okButton.addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarCampos(inscripcion)));
				okButton.setFont(new Font("Calibri", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.RED);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Calibri", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void comprobarCampos(InscripcionController inscripcion) {
		if (txtFechaCaducidad.getText().isBlank() || txtNumero.getText().isBlank()) {
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