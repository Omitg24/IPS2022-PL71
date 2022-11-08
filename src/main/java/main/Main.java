package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import apertura.AperturaMain;
import asignacionpericial.AsignacionPericialMain;
import colegiado.ColegiadoMain;
import consolidacion.ConsolidacionMain;
import curso.CursoMain;
import emision.EmisionMain;
import inscripcion.InscripcionMain;
import inscripcionpericial.InscripcionPericialMain;
import inscritos.InscritosMain;
import util.Database;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAperturaCursos;
	private JButton btnAltaColegiado;
	private JButton btnPlanificarCursos;
	private JButton btnEmitirRecibo;
	private JButton btnInscripcionCurso;
	private JButton btnListarInscritos;
	private JButton btnInscribirPerito;
	private JButton btnConsolidacionPago;
	private JButton btnAsignarInformePericial;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 374);
		setLocationRelativeTo(null);
		setTitle("Administración COIIPA");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.add(getBtnAperturaCursos());
		contentPane.add(getBtnAltaColegiado());
		contentPane.add(getBtnPlanificarCursos());
		contentPane.add(getBtnEmitirRecibo());
		contentPane.add(getBtnInscripcionCurso());
		contentPane.add(getBtnListarInscritos());
		contentPane.add(getBtnInscribirPerito());
		contentPane.add(getBtnConsolidacionPago());
		contentPane.add(getBtnAsignarInformePericial());
	}

	private JButton getBtnAperturaCursos() {
		if (btnAperturaCursos == null) {
			btnAperturaCursos = new JButton("Apertura Cursos");
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
			btnAsignarInformePericial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AsignacionPericialMain().main(null);;
				}
			});
		}
		return btnAsignarInformePericial;
	}
}
