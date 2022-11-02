package inscripcionpericial.controller;

import java.sql.Date;
import java.time.LocalDateTime;

import colegiado.model.ColegiadoDTO;
import inscripcion.view.IdentificadorView;
import inscripcionpericial.model.InscripcionPericialDTO;
import inscripcionpericial.model.InscripcionPericialModel;
import inscripcionpericial.view.InscripcionPericialView;
import inscripcionpericial.view.JustificanteInscripcionPericial;
import ui_events.ChangeColor;
import util.SwingUtil;

public class InscripcionPericialController {
	
	private InscripcionPericialModel model;
	private InscripcionPericialView view;
	private IdentificadorView viewId;
	
	
	private ColegiadoDTO colegiado;
	private InscripcionPericialDTO p ;
	
	
	public InscripcionPericialController(InscripcionPericialModel model, IdentificadorView viewId) {
		this.model = model;
		this.viewId=viewId;
		this.view = (InscripcionPericialView) viewId.getInscripcion();
	}
	
	private void initView() {
		rellenarCampos(colegiado);
		view.getFrame().setVisible(true);
	}
	
	public void initController() {
		viewId.getTextId().addFocusListener(new ChangeColor());
		viewId.getBtnEntrar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> entrar()));
		view.getModificar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> modificarCampos()));
		view.getVerificar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> verificar()));
		
	}

	private void entrar() {
		String dni = viewId.getTextId().getText();
		if(dni.isBlank())
			SwingUtil.showErrorDialog("Introduce un identificador válido");
		else if(model.buscarColegiado(dni)==null)
			SwingUtil.showErrorDialog("No existe un colegiado con ese identificador");
		else {
			colegiado= model.buscarColegiado(dni);
			viewId.getFrame().dispose();
			initView();
		}
	}

	private void verificar() {
		JustificanteInscripcionPericial j =new JustificanteInscripcionPericial();
		j.getBtnConfirmar().addActionListener(
				e -> SwingUtil.exceptionWrapper(() -> enviarConfirmacion(j)));
		confirmarCambios();
		confirmarInscripcion();
		rellenarCampos(j);
		j.getDialog().setVisible(true);
	}

	private void confirmarCambios() {
		colegiado.setTelefonoColegiado(view.getTelefono());
		colegiado.setLocalidadColegiado(view.getLocalidad());
		
	}

	private void enviarConfirmacion(JustificanteInscripcionPericial j) {
		if(model.buscarColegiadoPercial(colegiado.getDniColegiado())!=null) {	
			model.actualizarInscripcionPericial(p);
		}else {
			model.insertarInscripcionPericial(p);
		}
		j.getDialog().dispose();
	}

	private void rellenarCampos(JustificanteInscripcionPericial j) {
		j.setDni(p.getDniColegiado());
		j.setNumero(colegiado.getNumeroColegiado());
		j.setNombre(colegiado.getNombreColegiado());
		j.setApellido(colegiado.getApellidosColegiado());
		j.setFecha(p.fechaInscripcion.toString());
		j.setTurno(p.getPosicionLista()+"");
		j.setTelefono(colegiado.getTelefonoColegiado());
		j.setLocalidad(colegiado.getLocalidadColegiado());
		
	}
	
	private void confirmarInscripcion() {
		if(model.buscarColegiadoPercial(colegiado.getDniColegiado())!=null) {
			p=model.buscarColegiadoPercial(colegiado.getDniColegiado());
			p.setEstadoInscripcion("Inscrito");
			p.fechaInscripcion= Date.valueOf(LocalDateTime.now().toLocalDate());
			
		}else {
			p=new InscripcionPericialDTO();
			p.setDniColegiado(colegiado.getDniColegiado());
			p.setPosicionLista(model.getUltimoTurnoPericial()+1);
			p.setEstadoInscripcion("Inscrito");
			p.fechaInscripcion=Date.valueOf(LocalDateTime.now().toLocalDate());
		}
	}

	private void modificarCampos() {
		view.getTxtTelefono().addFocusListener(new ChangeColor());
		view.getTxtLocalidad().addFocusListener(new ChangeColor());
		view.getTxtTelefono().setEditable(true);
		view.getTxtLocalidad().setEditable(true);
	}
	
	private void rellenarCampos(ColegiadoDTO colegiado) {
		view.getTxtNumeroCol().setText(colegiado.getNumeroColegiado());
		view.getTxtDni().setText(colegiado.getDniColegiado());
		view.getTxtNombre().setText(colegiado.getNombreColegiado());
		view.getTxtTelefono().setText(colegiado.getTelefonoColegiado());
		view.getTxtApellidos().setText(colegiado.getApellidosColegiado());
		view.getTxtLocalidad().setText(colegiado.getLocalidadColegiado());
	}
	

}
