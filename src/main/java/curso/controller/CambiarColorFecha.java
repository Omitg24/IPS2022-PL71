package curso.controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class CambiarColorFecha implements FocusListener {
	
	public static final String DATE="(YYYY-MM-DD)";
	
	@Override
	public void focusGained(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		f.setForeground(Color.BLACK);
		f.setBackground(Color.WHITE);
		if(f.getText().equals(DATE))
			f.setText("");
		
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		if(f.getText().isBlank()) {
			f.setBackground(Color.LIGHT_GRAY);
			f.setForeground(Color.WHITE);
			f.setText(DATE);
		}
		
	}

}
