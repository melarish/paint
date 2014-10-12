/**
 * Brings up a dialog window where the user can pick a color for drawing. 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorChooser extends JPanel implements ActionListener {	
	private static final long serialVersionUID = 1L;

	public JColorChooser colorChooser;	
	public JButton button; 	
	public Color newColor = Color.white;	
	public MainWindow mainWindow;
	
	public ColorChooser(JButton button, MainWindow mainWindow) {
		 colorChooser = new JColorChooser();
		 this.mainWindow = mainWindow;
		 this.button = button;
		 button.addActionListener(this);		 
	}
	
	 public void actionPerformed(ActionEvent e) {		 	
	        mainWindow.setColor(JColorChooser.showDialog(
	                                       ColorChooser.this,
	                                       "Choose Color", Color.BLACK));
	    }	
}
