package coiipa.view.inscripcionpericial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
 * Título: Clase JustificanteInscripcionPericial
 *
 * @author David Warzynski Abril, UO278968
 * @version 27 nov 2022
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
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public JustificanteInscripcionPericial() {
		initialize();
	}

	private void initialize() {
		frmEmision = new JDialog();
		frmEmision.setIconImage(Toolkit.getDefaultToolkit().getImage(JustificanteInscripcionPericial.class.getResource("/images/coiipa_symbol.png")));
		frmEmision.setModal(true);
		frmEmision.setType(Type.POPUP);
		frmEmision.setTitle("Administración COIIPA - Confrimar inscripción");
		frmEmision.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmEmision.setBounds(100, 100, 800, 450);
		frmEmision.setMinimumSize(new Dimension(800, 450));
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
		lblLogo.setIcon(new ImageIcon(JustificanteInscripcionPericial.class.getResource("/images/coiipa_logo.jpg")));
		pnInsRealizada.add(lblLogo);
		
		JLabel lblInsRealizada = new JLabel("Confirmar inscripción");
		lblInsRealizada.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsRealizada.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		pnInsRealizada.add(lblInsRealizada);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new TitledBorder(null, "Datos del colegiado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(4, 1, 0, 0));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNombre);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellido.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblApellido);
		
		lblNumero = new JLabel("Nº Colegiado");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumero.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lblNumero);
		
		lbDni = new JLabel("Dni");
		lbDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDni.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbDni);
		
		lbTelefono = new JLabel("Telefono");
		lbTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTelefono.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbTelefono);
		
		lbLocalidad = new JLabel("Localidad");
		lbLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbLocalidad.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbLocalidad);
		
		lbFecha = new JLabel("Fecha Inscripción");
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbFecha.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbFecha);
		
		lbTurno = new JLabel("Turno");
		lbTurno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTurno.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbTurno);
		
		panelConfirmar = new JPanel();
		panelConfirmar.setBackground(Color.WHITE);
		contentPane.add(panelConfirmar, BorderLayout.SOUTH);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
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
