package ui_events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import inscripcion.view.InscripcionView;

public class ConfirmarTarjeta implements ActionListener{
	
	private InscripcionView inscripcion;

	public ConfirmarTarjeta(InscripcionView inscripcion) {
		this.inscripcion=inscripcion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inscripcion.confirmarPagoTarjeta(); 
		
	}

}
