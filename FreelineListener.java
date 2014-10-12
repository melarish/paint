/**
 * Allows the user to draw a freeline by pressing the left mouse button and dragging.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FreelineListener implements MouseListener, MouseMotionListener {	
	private Point from;
	private Point nextPoint;
	private Freeline currentFreeline = null;	// temporary freeline
	private Color color;
	private ShapeStore shapeStore;
    
    public FreelineListener(ShapeStore shapeStore) {
            this.shapeStore = shapeStore;
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		from = e.getPoint();	// gets starting point
		System.out.println("Mouse button pressed.");
		currentFreeline = new Freeline(from, color);	// creates a new temporary freeline from current position
		Graphics graphics = e.getComponent().getGraphics();
		graphics.drawLine(from.x, from.y, from.x, from.y);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		shapeStore.addShape(currentFreeline);	// saves temporary freeline to shapeStore
		System.out.println("Mouse button released.");		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		nextPoint = e.getPoint();	// gets current location
		System.out.println("Mouse button dragged.");
		currentFreeline.addNextPoint(nextPoint);	// adds current location to temporary freeline's list of points
		Graphics graphics = e.getComponent().getGraphics();
		currentFreeline.paintShape(graphics);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/* Sets color of lines drawn; color is given by drawingPanel. */
	public void setColor(Color color) {
		this.color = color;		
	}
}