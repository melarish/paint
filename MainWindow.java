/**
 * Configures the main window and adds all its components.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainWindow extends JFrame implements ActionListener {	
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private JPanel toolPanel;			// where the line/color/clear buttons are 
	private DrawingPanel drawingPanel;	// where the drawing takes place
	public ShapeStore shapeStore;		// where drawn lines and freelines are stored 
	public Color color;	
	private ColorChooser colorChooser;	
	
	public MainWindow() {			
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setSize(500, 500);
		this.setLocation(600, 100);
		
		shapeStore = new ShapeStore();		
		mainPanel = new JPanel(new BorderLayout());
		this.add(mainPanel);
		drawingPanel = new DrawingPanel(shapeStore);
		mainPanel.add(drawingPanel, BorderLayout.CENTER);		
		toolPanel = new JPanel(new FlowLayout());
		mainPanel.add(toolPanel, BorderLayout.NORTH);
		
		/* Radio buttons to choose between line and freeline mode */
		JRadioButton lineButton = new JRadioButton("Line");
        lineButton.setSelected(true);
        lineButton.setActionCommand("1");
        JRadioButton freelineButton = new JRadioButton("Freeline");
        freelineButton.setActionCommand("0");
        lineButton.addActionListener(this);
        freelineButton.addActionListener(this);
        
        ButtonGroup buttonGroup = new ButtonGroup();        
        buttonGroup.add(lineButton);
        buttonGroup.add(freelineButton);
                
        toolPanel.add(lineButton);
        toolPanel.add(freelineButton);        
		
        /* Buttons for opening color chooser window and for deleting drawn image */
		JButton colorButton = new JButton("Show Color Chooser...");
		toolPanel.add(colorButton);
		JButton clearButton = new JButton("Clear drawing");
		toolPanel.add(clearButton);
		clearButton.addActionListener(this);
		clearButton.setActionCommand("c");
        
        colorChooser = new ColorChooser(colorButton, this);          		
	}
	
	/* Sends the color given by colorChooser to drawingPanel */
	public void setColor (Color color) {
		drawingPanel.setColor(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "1") {		// if line mode was selected
			drawingPanel.setMode(1);
		}
		else if (e.getActionCommand() == "0") {	// if freeline mode was selected
			drawingPanel.setMode(0);
		}
		else if (e.getActionCommand() == "c") {	// if clear button was clicked
			System.out.println("Clear button clicked");
			shapeStore.clearShapes();
			drawingPanel.repaint();
		}
	}

}
