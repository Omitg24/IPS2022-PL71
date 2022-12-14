package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import main.launchers.AperturaMain;
import main.launchers.AsignacionPericialMain;
import main.launchers.AsignacionVisadorMain;
import main.launchers.ColegiadoMain;
import main.launchers.ConsolidacionMain;
import main.launchers.CursoMain;
import main.launchers.EmisionMain;
import main.launchers.InformeMain;
import main.launchers.InscripcionMain;
import main.launchers.InscripcionPericialMain;
import main.launchers.InscritosMain;
import main.launchers.LotesMain;
import main.launchers.PericialesMain;
import main.launchers.SolicitudVisadoMain;
import util.Database;

/**
 * Titulo: Clase Main
 *
 * @author Adrián Alves Morales, UO284288, Omar Teixeira González, UO281847 y
 * 		   David Warzynski Abril, UO278968
 * @version 30 nov 2022
 */
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnSuperior;
	private JLabel lbLogo;
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
	private JButton btnAsignarVisador;
	private JButton btnSolicitudVisado;
	private JButton btnListadoPericial;
	private JLabel lblAdministracinCoiipa;
	private JButton btnAuxLeft;
	private JButton btnAuxRight;

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
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/coiipa_symbol.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		setMinimumSize(new Dimension(1500, 900));
		setLocationRelativeTo(null);
		setTitle("Administración COIIPA");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.add(getPnSuperior(), BorderLayout.NORTH);
		contentPane.add(getPnBotones(), BorderLayout.CENTER);
	}
	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
			pnSuperior.add(getLbLogo());
			pnSuperior.add(getLblAdministracinCoiipa_1());
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
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnBotones.setBackground(Color.WHITE);
			pnBotones.setLayout(new GridLayout(0, 4, 40, 40));
			pnBotones.add(getBtnAperturaCursos());
			pnBotones.add(getBtnPlanificarCursos());
			pnBotones.add(getBtnInscripcionCurso());
			pnBotones.add(getBtnListarInscritos());
			pnBotones.add(getBtnAltaColegiado());
			pnBotones.add(getBtnInforme());
			pnBotones.add(getBtnInscribirPerito());
			pnBotones.add(getBtnListadoPericial());
			pnBotones.add(getBtnConsolidacionPago());
			pnBotones.add(getBtnSolicitudVisado());
			pnBotones.add(getBtnEmitirRecibo());
			pnBotones.add(getBtnLotes());
			pnBotones.add(getBtnAuxLeft());
			pnBotones.add(getBtnAsignarInformePericial());
			pnBotones.add(getBtnAsignarVisador());
			pnBotones.add(getBtnAuxRight());
		}
		return pnBotones;
	}
	private JButton getBtnAperturaCursos() {
		if (btnAperturaCursos == null) {
			btnAperturaCursos = new JButton("Apertura de cursos");
			btnAperturaCursos.setMargin(new Insets(1, 5, 1, 5));
			btnAperturaCursos.setFocusable(false);
			btnAperturaCursos.setFocusPainted(false);
			btnAperturaCursos.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnAperturaCursos.setBackground(Color.LIGHT_GRAY);
			btnAperturaCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAperturaCursos.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnAltaColegiado = new JButton("Solicitud de alta de colegiado");
			btnAltaColegiado.setMargin(new Insets(1, 5, 1, 5));
			btnAltaColegiado.setFocusable(false);
			btnAltaColegiado.setFocusPainted(false);
			btnAltaColegiado.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnAltaColegiado.setBackground(Color.LIGHT_GRAY);
			btnAltaColegiado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAltaColegiado.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnPlanificarCursos = new JButton("Planificación de cursos");
			btnPlanificarCursos.setMargin(new Insets(1, 5, 1, 5));
			btnPlanificarCursos.setFocusable(false);
			btnPlanificarCursos.setFocusPainted(false);
			btnPlanificarCursos.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnPlanificarCursos.setBackground(Color.LIGHT_GRAY);
			btnPlanificarCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPlanificarCursos.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnEmitirRecibo = new JButton("Emisión de recibos");
			btnEmitirRecibo.setMargin(new Insets(1, 5, 1, 5));
			btnEmitirRecibo.setFocusable(false);
			btnEmitirRecibo.setFocusPainted(false);
			btnEmitirRecibo.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnEmitirRecibo.setBackground(Color.LIGHT_GRAY);
			btnEmitirRecibo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEmitirRecibo.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnInscripcionCurso = new JButton("Inscripción a cursos");
			btnInscripcionCurso.setMargin(new Insets(1, 5, 1, 5));
			btnInscripcionCurso.setFocusable(false);
			btnInscripcionCurso.setFocusPainted(false);
			btnInscripcionCurso.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnInscripcionCurso.setBackground(Color.LIGHT_GRAY);
			btnInscripcionCurso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInscripcionCurso.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnListarInscritos = new JButton("Listados de inscripciones a cursos");
			btnListarInscritos.setMargin(new Insets(1, 5, 1, 5));
			btnListarInscritos.setFocusable(false);
			btnListarInscritos.setFocusPainted(false);
			btnListarInscritos.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnListarInscritos.setBackground(Color.LIGHT_GRAY);
			btnListarInscritos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnListarInscritos.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnInscribirPerito = new JButton("Inscripción pericial");
			btnInscribirPerito.setMargin(new Insets(1, 5, 1, 5));
			btnInscribirPerito.setFocusable(false);
			btnInscribirPerito.setFocusPainted(false);
			btnInscribirPerito.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnInscribirPerito.setBackground(Color.LIGHT_GRAY);
			btnInscribirPerito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInscribirPerito.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnConsolidacionPago = new JButton("Consolidación de pagos");
			btnConsolidacionPago.setMargin(new Insets(1, 5, 1, 5));
			btnConsolidacionPago.setFocusable(false);
			btnConsolidacionPago.setFocusPainted(false);
			btnConsolidacionPago.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnConsolidacionPago.setBackground(Color.LIGHT_GRAY);
			btnConsolidacionPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsolidacionPago.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnAsignarInformePericial = new JButton("Gestión de asignaciones periciales");
			btnAsignarInformePericial.setMargin(new Insets(1, 5, 1, 5));
			btnAsignarInformePericial.setFocusable(false);
			btnAsignarInformePericial.setFocusPainted(false);
			btnAsignarInformePericial.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnAsignarInformePericial.setBackground(Color.LIGHT_GRAY);
			btnAsignarInformePericial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAsignarInformePericial.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnLotes = new JButton("Emisión de lotes");
			btnLotes.setMargin(new Insets(1, 5, 1, 5));
			btnLotes.setFocusable(false);
			btnLotes.setFocusPainted(false);
			btnLotes.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnLotes.setBackground(Color.LIGHT_GRAY);
			btnLotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLotes.setFont(new Font("Tahoma", Font.BOLD, 18));
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
			btnInforme = new JButton("Solicitud de informe pericial");
			btnInforme.setMargin(new Insets(1, 5, 1, 5));
			btnInforme.setFocusable(false);
			btnInforme.setFocusPainted(false);
			btnInforme.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnInforme.setBackground(Color.LIGHT_GRAY);
			btnInforme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInforme.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnInforme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InformeMain().main(null);
				}
			});
		}
		return btnInforme;
	}
	
	private JButton getBtnAsignarVisador() {
		if (btnAsignarVisador == null) {
			btnAsignarVisador = new JButton("Gestión de asignaciones de visado");
			btnAsignarVisador.setMargin(new Insets(1, 5, 1, 5));
			btnAsignarVisador.setFocusable(false);
			btnAsignarVisador.setFocusPainted(false);
			btnAsignarVisador.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnAsignarVisador.setBackground(Color.LIGHT_GRAY);
			btnAsignarVisador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAsignarVisador.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnAsignarVisador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AsignacionVisadorMain().main(null);
				}
			});
		}
		return btnAsignarVisador;
	}
	
	private JButton getBtnSolicitudVisado() {
		if (btnSolicitudVisado == null) {
			btnSolicitudVisado = new JButton("Solicitud de visado");
			btnSolicitudVisado.setMargin(new Insets(1, 5, 1, 5));
			btnSolicitudVisado.setFocusable(false);
			btnSolicitudVisado.setFocusPainted(false);
			btnSolicitudVisado.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnSolicitudVisado.setBackground(Color.LIGHT_GRAY);
			btnSolicitudVisado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSolicitudVisado.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnSolicitudVisado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SolicitudVisadoMain().main(null);
				}
			});
		}
		return btnSolicitudVisado;
	}

	private JButton getBtnListadoPericial() {
		if (btnListadoPericial == null) {
			btnListadoPericial = new JButton("Listado de peritos");
			btnListadoPericial.setMargin(new Insets(1, 5, 1, 5));
			btnListadoPericial.setFocusable(false);
			btnListadoPericial.setFocusPainted(false);
			btnListadoPericial.setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
			btnListadoPericial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnListadoPericial.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnListadoPericial.setBackground(Color.LIGHT_GRAY);
			btnListadoPericial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new PericialesMain().main(null);
				}
			});
		}
		return btnListadoPericial;
	}
	private JLabel getLblAdministracinCoiipa_1() {
		if (lblAdministracinCoiipa == null) {
			lblAdministracinCoiipa = new JLabel("Administración COIIPA");
			lblAdministracinCoiipa.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdministracinCoiipa.setFont(new Font("Baskerville Old Face", Font.BOLD, 56));
		}
		return lblAdministracinCoiipa;
	}
	private JButton getBtnAuxLeft() {
		if (btnAuxLeft == null) {
			btnAuxLeft = new JButton("");
			btnAuxLeft.setBorder(null);
			btnAuxLeft.setBackground(Color.WHITE);
			btnAuxLeft.setEnabled(false);
		}
		return btnAuxLeft;
	}
	private JButton getBtnAuxRight() {
		if (btnAuxRight == null) {
			btnAuxRight = new JButton("");
			btnAuxRight.setBorder(null);
			btnAuxRight.setBackground(Color.WHITE);
			btnAuxRight.setEnabled(false);
		}
		return btnAuxRight;
	}
}
