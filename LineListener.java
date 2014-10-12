/**
 * Allows the user to draw a straight line by pressing the left mouse button and dragging.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class LineListener implements MouseListener, MouseMotionListener {
	
	private Point from;
	private Point to;
	private Point tempPoint;	// end location of previous line in mouseDragged
	private Color color = Color.BLACK;	// default color	
	private DrawingPanel drawingPanel;
	public Graphics graphics;
	private ShapeStore shapeStore;
    
    public LineListener(DrawingPanel drawingPanel, ShapeStore shapeStore) {
            this.drawingPanel = drawingPanel;            
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
		tempPoint = from;
		System.out.println("Mouse button pressed.");		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		to = e.getPoint();		// gets ending point
		System.out.println("Mouse button released.");
		shapeStore.addShape(	// adds new line to shapeStore
				new Line(from,
						to,	
						color)			
				);
		drawingPanel.repaint(); // repaints drawingPanel to show the new line
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		to = e.getPoint();	// gets current location of mouse to show a preview line
		System.out.println("Mouse button dragged.");		
		graphics = e.getComponent().getGraphics();
		graphics.setColor(Color.WHITE);	// change color temporarily to hide previous preview lines
		graphics.drawLine(from.x, from.y, tempPoint.x, tempPoint.y);	// overpaint previous preview line
		shapeStore.paintShapes(graphics);		// repaint existing shapes, in case they got overpainted
		graphics.setColor(color);		// set color back to what it was
		tempPoint = to;			
		graphics.drawLine(from.x, from.y, to.x, to.y);
//		drawingPanel.repaint();	// repaints drawingPanel to erase previous preview lines
//		
//		/* draws preview line only when repaint is done, to avoid it disappearing right after it's drawn */
//		Runnable drawLine = new Runnable() {
//			public void run() {
//				graphics.drawLine(from.x, from.y, to.x, to.y);
//			}			
//		};
//		SwingUtilities.invokeLater(drawLine);	 
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