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

import ui_events.ChangeColor;
import ui_events.ChangeDateColor;
import ui_events.ConfirmarTarjeta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private InscripcionView inscripcion;

	/**
	 * Create the dialog.
	 */
	public TarjetaView(InscripcionView insc) {
		this.inscripcion=insc;
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaView.class.getResource("/images/coiipa_symbol.png")));
		setResizable(false);
		setModal(true);
		setTitle("Confirmar pago con tarjeta");
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setBounds(100, 100, 450, 300);
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
					txtNumero.addFocusListener(new ChangeColor());
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
					lbFechaCaducidad.setLabelFor(txtFechaCaducidad);
					txtFechaCaducidad.addFocusListener(new ChangeDateColor("(MM/YY)"));
					txtFechaCaducidad.setFont(new Font("Calibri", Font.PLAIN, 14));
					txtFechaCaducidad.setColumns(10);
					pnFecha.add(txtFechaCaducidad);
				}
			}
		}
		{
			JPanel pnSup = new JPanel();
			pnSup.setPreferredSize(new Dimension(10, 35));
			pnSup.setBackground(Color.WHITE);
			contentPanel.add(pnSup, BorderLayout.NORTH);
		}
		{
			JPanel pnSur = new JPanel();
			pnSur.setPreferredSize(new Dimension(10, 35));
			pnSur.setBackground(Color.WHITE);
			contentPanel.add(pnSur, BorderLayout.SOUTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ConfirmarTarjeta(inscripcion));
				okButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
