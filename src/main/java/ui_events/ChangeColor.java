package ui_events;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * 
 * Título: Clase ChangeColor
 *
 * @author David Warzynski Abril, UO278968 
 * @version 9 oct 2022
 */
public class ChangeColor implements FocusListener {
	
	/**
	 * Método focusGained
	 * @param e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		((JTextField) e.getSource()).setBackground(Color.WHITE);
	}

	/**
	 * Método focusLost
	 * @param e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		if (f.getText().isBlank())
			f.setBackground(Color.LIGHT_GRAY);
	}
}
