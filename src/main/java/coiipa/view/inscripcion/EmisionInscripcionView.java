package coiipa.view.inscripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Título: Clase EmisionInscripcionView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class EmisionInscripcionView {

	private JDialog frmEmision;
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNumero;
	private JLabel lblFecha;
	private JLabel lblCantidad;
	private JPanel panelConfirmar;
	private JButton btnConfirmar;
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public EmisionInscripcionView() {
		initialize();
	}

	private void initialize() {
		frmEmision = new JDialog();
		frmEmision.setIconImage(Toolkit.getDefaultToolkit().getImage(EmisionInscripcionView.class.getResource("/images/coiipa_symbol.png")));
		frmEmision.setModal(true);
		frmEmision.setType(Type.POPUP);
		frmEmision.setTitle("Administración COIIPA - Pre-inscripcion completada");
		frmEmision.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmEmision.setBounds(100, 100, 800, 450);
		frmEmision.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmEmision.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnInsRealizada = new JPanel();
		pnInsRealizada.setBackground(Color.WHITE);
		contentPane.add(pnInsRealizada, BorderLayout.NORTH);
		pnInsRealizada.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblLogo = new JLabel("");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setIcon(new ImageIcon(EmisionInscripcionView.class.getResource("/images/coiipa_logo.jpg")));
		pnInsRealizada.add(lblLogo);
		
		JLabel lblInsRealizada = new JLabel("Pre-inscripción completada");
		lblInsRealizada.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsRealizada.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		pnInsRealizada.add(lblInsRealizada);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new TitledBorder(null, "Datos del solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(5, 1, 0, 0));
		
		lblNombre = new JLabel("nombre");
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNombre);
		
		lblApellido = new JLabel("apellido");
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblApellido);
		
		lblNumero = new JLabel("numero");
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumero.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNumero);
		
		lblFecha = new JLabel("fecha");
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFecha.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblFecha);
		
		lblCantidad = new JLabel("abonar");
		lblCantidad.setBackground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblCantidad);
		
		panelConfirmar = new JPanel();
		panelConfirmar.setBackground(Color.WHITE);
		contentPane.add(panelConfirmar, BorderLayout.SOUTH);
		panelConfirmar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBackground(new Color(34, 139, 34));
		panelConfirmar.add(btnConfirmar);
	}

	public void setNombre(String texto) {
		lblNombre.setText("Nombre: " + texto);
	}
	
	public void setApellido(String texto) {
		lblApellido.setText("Apellidos: " + texto);
	}
	
	public void setNumero(String texto) {
		lblNumero.setText("Número de colegiado: " + texto);
	}
	
	public void setFecha(String texto) {
		lblFecha.setText("Fecha de la solicitud: " + texto);
	}
	
	public void setCantidad(String texto) {
		lblCantidad.setText("Cantidad a abonar: " + texto);
	}
	
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	
	public void reiniciarCampos() {
		
	}

	public JDialog getFrame() {
		return frmEmision;
	}

	public void mostrarDialogo(String string) {
		JOptionPane.showMessageDialog(null, string);

	}
}
