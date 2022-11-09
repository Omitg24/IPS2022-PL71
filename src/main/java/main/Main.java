package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import apertura.AperturaMain;
import asignacionpericial.AsignacionPericialMain;
import colegiado.ColegiadoMain;
import consolidacion.ConsolidacionMain;
import curso.CursoMain;
import emision.EmisionMain;
import informepericial.InformeMain;
import inscripcion.InscripcionMain;
import inscripcionpericial.InscripcionPericialMain;
import inscritos.InscritosMain;
import lotes.LotesMain;
import util.Database;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnSuperior;
	private JLabel lbLogo;
	private JPanel pnTituloSup;
	private JLabel lblAdministracinCoiipa;
	private JPanel pnBotones;
	private JButton btnAperturaCursos;
	private JButton btnAltaColegiado;
	private JButton btnPlanificarCursos;
	private JButton btnEmitirRecibo;
	private JButton btnInscripcionCurso;
	private JButton btnListarInscritos;
	private JButton btnInscribirPerito;
	private JButton btnConsolidacionPago;
	private JButton btnAsignarInformePericial;
	private JButton btnLotes;
	private JButton btnInforme;
	private JButton btnNuevaFuncionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Database db=new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/coiipa_symbol.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		setTitle("Administración COIIPA");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnBotones(), BorderLayout.CENTER);
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
			lbLogo.setIcon(new ImageIcon(Main.class.getResource("/images/coiipa_logo.jpg")));
		}
		return lbLogo;
	}
	private JPanel getPnTituloSup() {
		if (pnTituloSup == null) {
			pnTituloSup = new JPanel();
			pnTituloSup.setBackground(Color.WHITE);
			pnTituloSup.add(getLblAdministracinCoiipa());
		}
		return pnTituloSup;
	}
	private JLabel getLblAdministracinCoiipa() {
		if (lblAdministracinCoiipa == null) {
			lblAdministracinCoiipa = new JLabel("Administración COIIPA");
			lblAdministracinCoiipa.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdministracinCoiipa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 56));
		}
		return lblAdministracinCoiipa;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnBotones.setBackground(Color.WHITE);
			pnBotones.setLayout(new GridLayout(3, 4, 40, 40));
			pnBotones.add(getBtnAperturaCursos());
			pnBotones.add(getBtnAltaColegiado());
			pnBotones.add(getBtnPlanificarCursos());
			pnBotones.add(getBtnEmitirRecibo());
			pnBotones.add(getBtnInscripcionCurso());
			pnBotones.add(getBtnListarInscritos());
			pnBotones.add(getBtnInscribirPerito());
			pnBotones.add(getBtnConsolidacionPago());
			pnBotones.add(getBtnAsignarInformePericial());
			pnBotones.add(getBtnLotes());
			pnBotones.add(getBtnLotes());
			pnBotones.add(getBtnInforme());
			pnBotones.add(getBtnNuevaFuncionalidad());
		}
		return pnBotones;
	}
	private JButton getBtnAperturaCursos() {
		if (btnAperturaCursos == null) {
			btnAperturaCursos = new JButton("Apertura Cursos");
			btnAperturaCursos.setBackground(Color.LIGHT_GRAY);
			btnAperturaCursos.setBorder(new LineBorder(Color.BLACK));
			btnAperturaCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAperturaCursos.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAperturaCursos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AperturaMain().main(null);;
				}
			});
		}
		return btnAperturaCursos;
	}
	private JButton getBtnAltaColegiado() {
		if (btnAltaColegiado == null) {
			btnAltaColegiado = new JButton("Alta Colegiado");
			btnAltaColegiado.setBackground(Color.LIGHT_GRAY);
			btnAltaColegiado.setBorder(new LineBorder(Color.BLACK));
			btnAltaColegiado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAltaColegiado.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAltaColegiado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ColegiadoMain().main(null);;
				}
			});
		}
		return btnAltaColegiado;
	}
	
	private JButton getBtnPlanificarCursos() {
		if (btnPlanificarCursos == null) {
			btnPlanificarCursos = new JButton("Planificar Cursos");
			btnPlanificarCursos.setBackground(Color.LIGHT_GRAY);
			btnPlanificarCursos.setBorder(new LineBorder(Color.BLACK));
			btnPlanificarCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPlanificarCursos.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnPlanificarCursos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CursoMain().main(null);
				}
			});
		}
		return btnPlanificarCursos;
	}
	private JButton getBtnEmitirRecibo() {
		if (btnEmitirRecibo == null) {
			btnEmitirRecibo = new JButton("Emitir Recibo");
			btnEmitirRecibo.setBackground(Color.LIGHT_GRAY);
			btnEmitirRecibo.setBorder(new LineBorder(Color.BLACK));
			btnEmitirRecibo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEmitirRecibo.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnEmitirRecibo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EmisionMain().main(null);;
				}
			});
		} 
		return btnEmitirRecibo;
	}
	
	private JButton getBtnInscripcionCurso() {
		if (btnInscripcionCurso == null) {
			btnInscripcionCurso = new JButton("Inscripcion Curso");
			btnInscripcionCurso.setBackground(Color.LIGHT_GRAY);
			btnInscripcionCurso.setBorder(new LineBorder(Color.BLACK));
			btnInscripcionCurso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInscripcionCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnInscripcionCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InscripcionMain().main(null);;
				}
			});
		}
		return btnInscripcionCurso;
	}
	private JButton getBtnListarInscritos() {
		if (btnListarInscritos == null) {
			btnListarInscritos = new JButton("Listar Inscritos");
			btnListarInscritos.setBackground(Color.LIGHT_GRAY);
			btnListarInscritos.setBorder(new LineBorder(Color.BLACK));
			btnListarInscritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnListarInscritos.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnListarInscritos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InscritosMain().main(null);;
				}
			});
		}
		return btnListarInscritos;
	}
	
	private JButton getBtnInscribirPerito() {
		if (btnInscribirPerito == null) {
			btnInscribirPerito = new JButton("Inscribir Perito");
			btnInscribirPerito.setBackground(Color.LIGHT_GRAY);
			btnInscribirPerito.setBorder(new LineBorder(Color.BLACK));
			btnInscribirPerito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInscribirPerito.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnInscribirPerito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InscripcionPericialMain().main(null);;
				}
			});
		}
		return btnInscribirPerito;
	}
	
	private JButton getBtnConsolidacionPago() {
		if (btnConsolidacionPago == null) {
			btnConsolidacionPago = new JButton("Consolidacion de pagos");
			btnConsolidacionPago.setBackground(Color.LIGHT_GRAY);
			btnConsolidacionPago.setBorder(new LineBorder(Color.BLACK));
			btnConsolidacionPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsolidacionPago.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnConsolidacionPago.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ConsolidacionMain().main(null);;
				}
			});
		}
		return btnConsolidacionPago;
	}
	
	private JButton getBtnAsignarInformePericial() {
		if (btnAsignarInformePericial == null) {
			btnAsignarInformePericial = new JButton("Asginar Informe Pericial");
			btnAsignarInformePericial.setBackground(Color.LIGHT_GRAY);
			btnAsignarInformePericial.setBorder(new LineBorder(Color.BLACK));
			btnAsignarInformePericial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAsignarInformePericial.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAsignarInformePericial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AsignacionPericialMain().main(null);
				}
			});
		}
		return btnAsignarInformePericial;
	}
	private JButton getBtnLotes() {
		if (btnLotes == null) {
			btnLotes = new JButton("Enviar lotes");
			btnLotes.setBackground(Color.LIGHT_GRAY);
			btnLotes.setBorder(new LineBorder(Color.BLACK));
			btnLotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLotes.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LotesMain().main(null);
				}
			});
		}
		return btnLotes;
	}
	private JButton getBtnInforme() {
		if (btnInforme == null) {
			btnInforme = new JButton("Enviar solicitud de informe");
			btnInforme.setBackground(Color.LIGHT_GRAY);
			btnInforme.setBorder(new LineBorder(Color.BLACK));
			btnInforme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInforme.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnInforme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InformeMain().main(null);
				}
			});
		}
		return btnInforme;
	}
	
	private JButton getBtnNuevaFuncionalidad() {
		if (btnNuevaFuncionalidad== null) {
			btnNuevaFuncionalidad = new JButton("*Próxima Funcionalidad*");
			btnNuevaFuncionalidad.setBackground(Color.LIGHT_GRAY);
			btnNuevaFuncionalidad.setBorder(new LineBorder(Color.BLACK));
			btnNuevaFuncionalidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNuevaFuncionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNuevaFuncionalidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog j = new JDialog();
					j.setBounds(0, 0, 500, 500);
					j.setLocationRelativeTo(null);
					j.setLayout(new BorderLayout());
					JLabel l = new JLabel();
					l.setIcon(new ImageIcon(Main.class.getResource("/images/altoke.png")));
					l.setHorizontalAlignment(SwingConstants.CENTER);
					j.add(l, BorderLayout.CENTER);
					j.setVisible(true);
				}
			});
		}
		return btnNuevaFuncionalidad;
	}

}
