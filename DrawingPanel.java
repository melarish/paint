/**
 * The drawing panel where the user can draw using the mouse.
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {	
	private static final long serialVersionUID = 1L;
	
	private ShapeStore shapeStore;	
	public LineListener lineListener;
	public FreelineListener freelineListener;
	
	public DrawingPanel(ShapeStore shapeStore) {
		super();
		this.setBackground(Color.WHITE);
		
		this.shapeStore = shapeStore;		
		lineListener = new LineListener(this, shapeStore);
		freelineListener = new FreelineListener(shapeStore);	
		addMouseListener(lineListener);	// by default, enables line drawing mode
		addMouseMotionListener(lineListener);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);		
		shapeStore.paintShapes(g);
	}

	/* Sends color given by mainWindow to mouse listeners */
	public void setColor(Color color) {
		freelineListener.setColor(color);
		lineListener.setColor(color);
	}
	
	/* If line mode is selected, removes freeline listeners and adds line listeners.
	 * If freeline mode is selected, does the opposite. 
	 */
	public void setMode(int mode) {
		// 1 - line, 0 - freeline
		if (mode == 1) {
			removeMouseListener(freelineListener);
			removeMouseMotionListener(freelineListener);
			addMouseListener(lineListener);
			addMouseMotionListener(lineListener);
		} else {
			removeMouseListener(lineListener);
			removeMouseMotionListener(lineListener);
			addMouseListener(freelineListener);
			addMouseMotionListener(freelineListener);
		}
	}

}
