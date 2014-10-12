/**
 * Where the drawn shapes are stored.
 */

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ShapeStore {
	
	public List<Shape> shapes = new ArrayList<Shape>();
		
	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}
	
	public void paintShapes(Graphics graphics) {
		for (Shape shape : shapes) {
			shape.paintShape(graphics);
		}
	}
	
	public void clearShapes() {
		this.shapes.clear();
	}	                          

}
