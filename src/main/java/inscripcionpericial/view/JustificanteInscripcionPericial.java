package inscripcionpericial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Título: Clase AperturaView
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class JustificanteInscripcionPericial {

	private JDialog frmEmision;
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNumero;
	private JLabel lbDni;
	private JLabel lbTelefono;
	private JPanel panelConfirmar;
	private JButton btnConfirmar;
	private JLabel lbLocalidad;
	private JLabel lbFecha;
	private JLabel lbTurno;

	/**
	 * Create the frame.
	 */
	public JustificanteInscripcionPericial() {
		initialize();
	}

	private void initialize() {
		frmEmision = new JDialog();
		frmEmision.setModal(true);
		frmEmision.setType(Type.POPUP);
		frmEmision.setResizable(false);
		frmEmision.setTitle("Administración COIIPA");
		frmEmision.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmEmision.setBounds(100, 100, 425, 330);
		frmEmision.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmEmision.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnInsRealizada = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnInsRealizada.getLayout();
		flowLayout.setVgap(15);
		pnInsRealizada.setBackground(Color.WHITE);
		contentPane.add(pnInsRealizada, BorderLayout.NORTH);
		
		JLabel lblInsRealizada = new JLabel("Confirmar Inscripción");
		lblInsRealizada.setFont(new Font("Tahoma", Font.PLAIN, 26));
		pnInsRealizada.add(lblInsRealizada);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new CompoundBorder(new EmptyBorder(6, 6, 6, 6), new LineBorder(new Color(0, 0, 0))));
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(5, 1, 0, 0));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNombre);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblApellido);
		
		lblNumero = new JLabel("Nº Colegiado");
		lblNumero.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNumero);
		
		lbDni = new JLabel("Dni");
		lbDni.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbDni);
		
		lbTelefono = new JLabel("Telefono");
		lbTelefono.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbTelefono);
		
		lbLocalidad = new JLabel("Localidad");
		lbLocalidad.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbLocalidad);
		
		lbFecha = new JLabel("Fecha Inscripción");
		lbFecha.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbFecha);
		
		lbTurno = new JLabel("Turno");
		lbTurno.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbTurno);
		
		panelConfirmar = new JPanel();
		panelConfirmar.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panelConfirmar.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelConfirmar.setPreferredSize(new Dimension(10, 30));
		contentPane.add(panelConfirmar, BorderLayout.SOUTH);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("High Tower Text", Font.BOLD, 14));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBackground(new Color(34, 139, 34));
		panelConfirmar.add(btnConfirmar);
	}
	
	public JDialog getDialog() {
		return frmEmision;
	}

	public void setNombre(String texto) {
		lblNombre.setText("Nombre: " + texto);
	}
	
	public void setApellido(String texto) {
		lblApellido.setText("Apellidos: " + texto);
	}
	
	public void setNumero(String texto) {
		lblNumero.setText("Nº colegiado: " + texto);
	}
	
	public void setDni(String texto) {
		lbDni.setText("DNI: " + texto);
	}
	
	public void setTelefono(String texto) {
		lbTelefono.setText("Telefono: " + texto);
	}
	
	public void setLocalidad(String texto) {
		lbLocalidad.setText("Localidad: " + texto);
	}
	
	public void setFecha(String texto) {
		lbFecha.setText("Fecha Inscripción: " + texto);
	}
	
	public void setTurno(String texto) {
		lbTurno.setText("Turno: " + texto);
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
