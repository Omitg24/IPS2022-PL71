package coiipa.view;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JPanel pnCancelable;
	private JCheckBox chCancelable;
	private JPanel pnDevolucion;
	private JLabel lbDevolución;
	private JTextField txtDevolución;
	private JLabel lblPlanificacinDeCursos;

	/**
	 * Create the frame.
	 */
	public CursoView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(true);
		frame.setTitle("Administración COIIPA - Planificación de cursos");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(CursoView.class.getResource("/images/coiipa_symbol.png")));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txtTitulo.grabFocus();
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new BorderLayout(0, 0));
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
			pnSuperior.add(getLbPlan_1());
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
			pnRegistro.setPreferredSize(new Dimension(400, 250));
			pnRegistro.setName("");
			pnRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new GridLayout(5, 1, 0, 5));
			pnRegistro.add(getPnTitulo());
			pnRegistro.add(getPnFecha());
			pnRegistro.add(getPnPrecio());
			pnRegistro.add(getPnCancelable());
			pnRegistro.add(getPnDevolucion());
		}
		return pnRegistro;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnTitulo.getLayout();
			flowLayout.setHgap(17);
			pnTitulo.setBackground(Color.WHITE);
			pnTitulo.add(getLbTitulo());
			pnTitulo.add(getTxtTitulo());
		}
		return pnTitulo;
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Titulo del curso:");
			lbTitulo.setLabelFor(getTxtTitulo());
			lbTitulo.setDisplayedMnemonic('T');
			lbTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTitulo.setColumns(15);
		}
		return txtTitulo;
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnFecha.getLayout();
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
			lbFecha.setLabelFor(getTxtFecha());
			lbFecha.setDisplayedMnemonic('F');
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtFecha.setColumns(15);
		}
		return txtFecha;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnPrecio.getLayout();
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
			lbPrecio.setLabelFor(getTxtPrecio());
			lbPrecio.setDisplayedMnemonic('P');
			lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtPrecio.setColumns(15);
		}
		return txtPrecio;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInferior.getLayout();
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
			btAddCurso.setFont(new Font("Tahoma", Font.BOLD, 24));
			btAddCurso.setBackground(new Color(34, 139, 34));
		}
		return btAddCurso;
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
	
	public boolean getCancelable() {
		return getChCancelable().isSelected();
	}
	
	public String getDevoculicion() {
		return getTxtDevolucion().getText();
	}
	
	private JPanel getPnCancelable() {
		if (pnCancelable == null) {
			pnCancelable = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnCancelable.getLayout();
			flowLayout.setHgap(35);
			pnCancelable.setBackground(Color.WHITE);
			pnCancelable.add(getChCancelable());
		}
		return pnCancelable;
	}
	private JCheckBox getChCancelable() {
		if (chCancelable == null) {
			chCancelable = new JCheckBox("Cancelable");
			chCancelable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JCheckBox j = (JCheckBox) e.getSource();
					if(j.isSelected()) 
						getTxtDevolucion().setEnabled(true);
					else {
						getTxtDevolucion().setText("");
						getTxtDevolucion().setEnabled(false);
					}
				}
			});
			chCancelable.setFont(new Font("Tahoma", Font.PLAIN, 18));
			chCancelable.setBackground(Color.WHITE);
		}
		return chCancelable;
	}
	private JPanel getPnDevolucion() {
		if (pnDevolucion == null) {
			pnDevolucion = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnDevolucion.getLayout();
			flowLayout.setHgap(20);
			pnDevolucion.setBackground(Color.WHITE);
			pnDevolucion.add(getLbDevolucion());
			pnDevolucion.add(getTxtDevolucion());
		}
		return pnDevolucion;
	}
	private JLabel getLbDevolucion() {
		if (lbDevolución == null) {
			lbDevolución = new JLabel("Política devolución:");
			lbDevolución.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbDevolución.setDisplayedMnemonic('P');
		}
		return lbDevolución;
	}
	public JTextField getTxtDevolucion() {
		if (txtDevolución == null) {
			txtDevolución = new JTextField();
			txtDevolución.setPreferredSize(new Dimension(10, 25));
			txtDevolución.setHorizontalAlignment(SwingConstants.CENTER);
			txtDevolución.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDevolución.setColumns(15);
			txtDevolución.setBorder(new LineBorder(new Color(171, 173, 179)));
			txtDevolución.setBackground(Color.LIGHT_GRAY);
			txtDevolución.setEnabled(false);
		}
		return txtDevolución;
	}
	private JLabel getLbPlan_1() {
		if (lblPlanificacinDeCursos == null) {
			lblPlanificacinDeCursos = new JLabel("Planificación de cursos");
			lblPlanificacinDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlanificacinDeCursos.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		}
		return lblPlanificacinDeCursos;
	}
}
