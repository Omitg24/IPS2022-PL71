package curso.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CursoView {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnRegistro;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JTextField txtTitulo;
	private JPanel pnFecha;
	private JLabel lbFecha;
	private JTextField txtFecha;
	private JPanel pnPrecio;
	private JLabel lbPrecio;
	private JTextField txtPrecio;
	private JPanel pnInferior;
	private JButton btAddCurso;
	private JPanel pnTituloSup;
	private JLabel lbPlan;

	/**
	 * Create the frame.
	 */
	public CursoView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Administración COIIPA - Planificación de cursos");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(CursoView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
		frame.getRootPane().setDefaultButton(btAddCurso);
	}

	public void reiniciarCampos() {
		getTxtTitulo().setText("");
		getTxtPrecio().setText("");
		txtTitulo.setBackground(Color.LIGHT_GRAY);
		txtPrecio.setBackground(Color.LIGHT_GRAY);
		txtFecha.setBackground(Color.LIGHT_GRAY);
		txtFecha.setForeground(Color.WHITE);
		txtFecha.setText("(YYYY-MM-DD)");
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCentro.add(getPnRegistro());
		}
		return pnCentro;
	}

	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getPnTituloSup());
		}
		return pnSuperior;
	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(CursoView.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setPreferredSize(new Dimension(400, 200));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Informaci\u00F3n curso",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new GridLayout(3, 1, 0, 5));
			pnRegistro.add(getPnTitulo());
			pnRegistro.add(getPnFecha());
			pnRegistro.add(getPnPrecio());
		}
		return pnRegistro;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnTitulo.getLayout();
			flowLayout.setHgap(17);
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.add(getLbTitulo());
			pnTitulo.add(getTxtTitulo());
		}
		return pnTitulo;
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Titulo del curso:");
			lbTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lbTitulo.setFont(new Font("High Tower Text", Font.BOLD, 14));
		}
		return lbTitulo;
	}

	public JTextField getTxtTitulo() {
		if (txtTitulo == null) {
			txtTitulo = new JTextField();
			txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			txtTitulo.setBackground(Color.LIGHT_GRAY);
			txtTitulo.setPreferredSize(new Dimension(10, 25));
			txtTitulo.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtTitulo.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			txtTitulo.setColumns(10);
		}
		return txtTitulo;
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnFecha.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(20);
			pnFecha.setBackground(Color.WHITE);
			pnFecha.add(getLbFecha());
			pnFecha.add(getTxtFecha());
		}
		return pnFecha;
	}

	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha del curso:");
			lbFecha.setFont(new Font("High Tower Text", Font.BOLD, 14));
		}
		return lbFecha;
	}

	public JTextField getTxtFecha() {
		if (txtFecha == null) {
			txtFecha = new JTextField();
			txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
			txtFecha.setBackground(Color.LIGHT_GRAY);
			txtFecha.setForeground(Color.WHITE);
			txtFecha.setText("(YYYY-MM-DD)");
			txtFecha.setPreferredSize(new Dimension(10, 25));
			txtFecha.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtFecha.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			txtFecha.setColumns(10);
		}
		return txtFecha;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnPrecio.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(17);
			pnPrecio.setBackground(Color.WHITE);
			pnPrecio.add(getLbPrecio());
			pnPrecio.add(getTxtPrecio());
		}
		return pnPrecio;
	}

	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio del curso:");
			lbPrecio.setFont(new Font("High Tower Text", Font.BOLD, 14));
		}
		return lbPrecio;
	}

	public JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrecio.setBackground(Color.LIGHT_GRAY);
			txtPrecio.setPreferredSize(new Dimension(10, 25));
			txtPrecio.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtPrecio.setFont(new Font("High Tower Text", Font.PLAIN, 14));
			txtPrecio.setColumns(10);
		}
		return txtPrecio;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
			flowLayout.setVgap(40);
			flowLayout.setHgap(0);
			pnInferior.setBackground(Color.WHITE);
			pnInferior.add(getBtAddCurso());
		}
		return pnInferior;
	}

	public JButton getBtAddCurso() {
		if (btAddCurso == null) {
			btAddCurso = new JButton("Planificar");
			btAddCurso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAddCurso.setForeground(Color.WHITE);
			btAddCurso.setFont(new Font("High Tower Text", Font.BOLD, 14));
			btAddCurso.setBackground(new Color(34, 139, 34));
		}
		return btAddCurso;
	}

	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLbPlan());
		}
		return pnTituloSup;
	}

	private JLabel getLbPlan() {
		if (lbPlan == null) {
			lbPlan = new JLabel("Planificación cursos");
			lbPlan.setHorizontalAlignment(SwingConstants.CENTER);
			lbPlan.setFont(new Font("High Tower Text", Font.PLAIN, 35));
		}
		return lbPlan;
	}

	public JFrame getFrame() {
		return frame;
	}

	public String getTitulo() {
		return getTxtTitulo().getText();
	}

	public String getPrecio() {
		return getTxtPrecio().getText();
	}

	public String getFecha() {
		return getTxtFecha().getText();
	}
}
