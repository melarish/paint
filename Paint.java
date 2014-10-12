/**
 * Initializes the program and shows main window.
 */

import javax.swing.JFrame;

public class Paint extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	
	private Paint() {
		mainWindow = new MainWindow();
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.run();

	}
	
	private void run() {
		mainWindow.setVisible(true);
	}

}
