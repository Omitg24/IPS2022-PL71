package ui_events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Título: Clase ProccessKeyNoDigits
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 oct 2022
 */
public class ProccessKeyNoDigits extends KeyAdapter {
	/**
	 * Método keyTyped
	 * @param e
	 */
	public void keyTyped(KeyEvent e) {
		char pressedKey = e.getKeyChar();
		if (Character.isDigit(pressedKey)) {
			e.consume();
		}
	}
}
