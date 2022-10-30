package ui_events;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * Título: Clase ChangeDateColor
 *
 * @author David Warzynski Abril, UO278968
 * @version 9 oct 2022
 */
public class ChangeDateColor implements FocusListener {
	/**
	 * Constante DATE
	 */
	public static final String DATE = "(YYYY-MM-DD)";

	private String dateFormat;

	public ChangeDateColor() {
	}

	public ChangeDateColor(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * Método focusGained
	 * 
	 * @param e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		f.setForeground(Color.BLACK);
		f.setBackground(Color.WHITE);
		if (dateFormat == null) {
			if (f.getText().equals(DATE))
				f.setText("");
		} else {
			if (f.getText().equals(dateFormat))
				f.setText("");
		}

	}

	/**
	 * Método focusLost
	 * 
	 * @param e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		JTextField f = ((JTextField) e.getSource());
		if (f.getText().isBlank()) {
			f.setBackground(Color.LIGHT_GRAY);
			f.setForeground(Color.WHITE);
			if (dateFormat == null) {
				f.setText(DATE);
			}else {
				f.setText(dateFormat);
			}
		}
	}
}