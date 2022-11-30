package coiipa.view.inscripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * Título: Clase JustificanteCancelarInscripcion
 *
 * @author David Warzynski Abril, UO278968
 * @version 27 nov 2022
 */
public class JustificanteCancelarInscripcion {

	private JDialog frmEmision;
	private JPanel contentPane;
	private JLabel lbDni;
	private JPanel panelConfirmar;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lbTituloCurso;
	private JLabel lbFechaCurso;
	private JLabel lbFechaCancelacion;
	private JLabel lbDineroDevuelto;
	private JLabel lblConfirmarCancelacin;
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public JustificanteCancelarInscripcion() {
		initialize();
	}

	private void initialize() {
		frmEmision = new JDialog();
		frmEmision.setIconImage(Toolkit.getDefaultToolkit().getImage(JustificanteCancelarInscripcion.class.getResource("/images/coiipa_symbol.png")));
		frmEmision.setModal(true);
		frmEmision.setType(Type.POPUP);
		frmEmision.setTitle("Administración COIIPA - Confirmar cancelación");
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
		lblLogo.setIcon(new ImageIcon(JustificanteCancelarInscripcion.class.getResource("/images/coiipa_logo.jpg")));
		pnInsRealizada.add(lblLogo);
		
		lblConfirmarCancelacin = new JLabel("Confirmar cancelación");
		lblConfirmarCancelacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarCancelacin.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		pnInsRealizada.add(lblConfirmarCancelacin);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new TitledBorder(null, "Datos del curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(5, 1, 0, 0));

		lbDni = new JLabel("Dni");
		lbDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDni.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbDni);

		lbTituloCurso = new JLabel("Titulo curso");
		lbTituloCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTituloCurso.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbTituloCurso);

		lbFechaCurso = new JLabel("Fecha curso");
		lbFechaCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbFechaCurso.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbFechaCurso);

		lbFechaCancelacion = new JLabel("Fecha cancelación");
		lbFechaCancelacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbFechaCancelacion.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbFechaCancelacion);

		lbDineroDevuelto = new JLabel("Dinero devuelto");
		lbDineroDevuelto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDineroDevuelto.setBorder(new EmptyBorder(0, 6, 0, 0));
		panelDatos.add(lbDineroDevuelto);

		panelConfirmar = new JPanel();
		panelConfirmar.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panelConfirmar.getLayout();
		flowLayout_1.setHgap(50);
		contentPane.add(panelConfirmar, BorderLayout.SOUTH);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBackground(new Color(34, 139, 34));
		panelConfirmar.add(btnConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(Color.red);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();

			}
		});
		panelConfirmar.add(btnCancelar);
	}

	public void cancelar() {
		frmEmision.dispose();

	}

	public JDialog getDialog() {
		return frmEmision;
	}

	public void setDni(String dni) {
		lbDni.setText("Dni: " + dni);
	}

	public void setTituloCurso(String titulo) {
		lbTituloCurso.setText("Titulo curso: " + titulo);
	}

	public void setFechaCurso(String fechaCurso) {
		lbFechaCurso.setText("Fecha curso: " + fechaCurso);
	}

	public void setFechaCancelacion(String fechaCancelacion) {
		lbFechaCancelacion.setText("Fecha cancelación: " + fechaCancelacion);
	}

	public void setDineroDevuelt(String dinero) {
		lbDineroDevuelto.setText("Dinero devuelto: " + dinero + "€");
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
