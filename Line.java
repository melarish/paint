/**
 * A straight line from one point to another; subclass of Shape.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {	
	private Point from;	
	private Point to;	
	private Color color;
	
	public Line(Point from, Point to, Color color) {
		super();		
		this.from = from;
		this.to = to;
		this.color = color;
	}

	@Override
	public void paintShape(Graphics graphics) {
		graphics.setColor(this.color);
		graphics.drawLine(from.x, from.y, to.x, to.y);
	}

}
