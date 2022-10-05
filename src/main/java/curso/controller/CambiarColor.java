package curso.controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class CambiarColor implements FocusListener {
	@Override
	public void focusGained(FocusEvent e) {
		((JTextField) e.getSource()).setBackground(Color.WHITE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		if(f.getText().isBlank())
			f.setBackground(Color.LIGHT_GRAY);
		
	}
}
