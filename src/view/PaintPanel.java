/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import tools.LineTool;
import tools.PaintElements;
import tools.Tool;


/**
 * This class creates the paint panel for the GUI in which
 * shapes can be drawn with different draw and fill colors.
 * 
 * @author Andrew Joshua Loria
 * @version 11/10/17
 */
public class PaintPanel extends JPanel {
   
  
    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 2601568404093146018L;
    
    /**Husky purple color.*/
    private static final Color HUSKY_PURP = new Color(51, 0, 111);

    /** The default size of the drawing panel. */
    private static final Dimension PANEL_DEFAULT_SIZE = new Dimension(200, 200);
    
    /** The initial thickness size. */
    private static final int THICKNESS_DEFAULT = 5;
        
    /** The initial point of the tool. */
    private static final Point INITIAL_POINT = new Point(0, 0);
    
    /**Background color of panel.*/
    private static final Color BACKGROUND_COLOR = Color.WHITE;
        
    /** The color of the current tool to draw on the paint panel. */
    private Color myColor;
    
    /** List of previously made paint art.*/
    private final List<PaintElements> myList;
    
    /** Thickness of tool. */
    private int myThickness;
    
    /** Says if the current tool is being dragged. */
    private boolean myDragged; 
    
    /** Current tool. */
    private Tool myTool;
    
    /** The start point of  tool being used. */
    private Point myStartPosition;
    
    /** The end point of the tool. */
    private Point myEndPosition;

    /** Whether or not the shape will actually be filled.*/
    private boolean myWillFillShape;
    
    /** Whether or not the "Fill" checkbox from MenuBar was selected.*/
    private boolean myFillCheckboxSaid;
    
    /** My fill color.*/
    private Color myFillColor;    
    
    /**
     * Constructs a paint panel, and initializes all the fields.
     */
    public PaintPanel() {
        super();
        
        myDragged = false;
        myTool = new LineTool(INITIAL_POINT, INITIAL_POINT);  
        myThickness = THICKNESS_DEFAULT;
        
        setPreferredSize(PANEL_DEFAULT_SIZE);
        setBackground(BACKGROUND_COLOR);
        
        setForeground(HUSKY_PURP);
        myColor = HUSKY_PURP; //default draw color
        make();
        myList = new ArrayList<PaintElements>(); //array list of paint elements
    }
    
    /**
     * This method sets up listeners and cursor for the paint panel.
     */
    private void make() {
        addMouseListener(new MouseEventListener());
        addMouseMotionListener(new MouseEventListener());
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); //crosshair cursor
    }
    
    /**
     * Set drawing tool.
     *  
     * @param theTool tool to draw.
     */
    public void setCurrentTool(final Tool theTool) {
        myTool = theTool;
    }
    
    /**
     * Set drawing tool's color.
     * 
     * @param theColor color of tool.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Sets thickness.
     * 
     * @param theThickness the thickness size of the drawing tool.
     */
    public void setThickness(final int theThickness) {
        myThickness = theThickness;
    }
    
    /**
     * This methods clear the paint panel by removing all shapes from collections.
     * 
     * @param theSelection the selection status.
     */
    public void clearPaintPanel(final boolean theSelection) {
        if (theSelection) { 
            myList.clear(); //clear list of previous shapes    
            if (myFillCheckboxSaid) {
            	myFillCheckboxSaid = false;
            	firePropertyChange("fill", "filled", "unfilled");
            }
            repaint();
        }
           
    }
    


    /**
     * Set fill color. Called from MenuBar class.
     * @param theCol the fill color
     */
    public void setFill(final Color theCol) {
        myFillColor = theCol;
        
    }
    

    /**
     * Here two booleans are being set to whether or not the "Fill" checkbox from MenuBar
     * was selected. The reason there are two booleans that are being set to the same thing
     * is because if the "Fill" checkbox is actually selected, and the pencil tool is selected,
     * the "myWillFillShape" boolean will prevent the pencil tool from actually having
     * a fill (see paintComponent below).
     * @param theBoolean whether or not "Fill" was selected
     */
    public void fillBoxSaid(final boolean theBoolean) {
        myWillFillShape = theBoolean; 
        //the above boolean says if we will actually fill the shape
        myFillCheckboxSaid = theBoolean; 
        //the above boolean says if the checkbox really was selected
        
    }

    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        //draw old stuff
        g2d.setStroke(new BasicStroke(THICKNESS_DEFAULT));


        final Iterator<PaintElements> itr = myList.iterator();
        while (itr.hasNext()) {
            final PaintElements pe = itr.next();
            g2d.setStroke(new BasicStroke(pe.getThickness()));
            if (pe.isFilled()) {
                g2d.setColor(pe.getFillColor());
                g2d.fill(pe.getShape());
                g2d.setColor(pe.getDrawColor());
                g2d.draw(pe.getShape());
            } else {
                g2d.setColor(pe.getDrawColor());
                g2d.draw(pe.getShape());
            }
                        
        }
        
        //draw new stuff
        g2d.setStroke(new BasicStroke(THICKNESS_DEFAULT));
        
        /* This next if statement checks if the "Fill" checkbox was actually selected and 
         * if your tool is not a pencil. This ensures we do not fill pencil shapes.*/
        if (myFillCheckboxSaid 
                        && (!myTool.getClass().toString().equals("class tools.PencilTool"))) {
            myWillFillShape = true;
            g2d.setColor(myFillColor); 
            g2d.fill(myTool.getShape());
            myWillFillShape = true; //this means I will actually fill the shape with color
            if (myDragged) {
                g2d.setStroke(new BasicStroke(myThickness, 
                                              BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.setColor(myColor);
                
                if (myThickness != 0) {
                    g2d.draw(myTool.getShape());
                }
            }
            
            
        } else {
            myWillFillShape = false; //I will not fill the shape with color
            if (myDragged) {
                g2d.setStroke(new BasicStroke(myThickness, 
                                          BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.setColor(myColor);
                if (myThickness != 0) {
                    g2d.draw(myTool.getShape());
                
                }
            
            }   
        }
          
        
    }

    
    /**
     * Various methods such as mousePressed, mouseDragged, and
     * mouseReleased are created here in this inner class.
     * This class extends the MouseAdapater.
     * @author Andrew Joshua Loria
     * @version 11/10/17
     */
    class MouseEventListener extends MouseAdapter {
        
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {          
            
            myDragged = true;
            myStartPosition = theEvent.getPoint();
            myEndPosition = myStartPosition;
            myTool.setStartPoint(myStartPosition);
            myTool.setEndPoint(myEndPosition);
            repaint();
        }
              
        @Override
        public void mouseDragged(final MouseEvent theEvent) {

            myDragged = true;
            myEndPosition = theEvent.getPoint();
            myTool.setEndPoint(myEndPosition); 
            repaint();
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            
            myEndPosition = theEvent.getPoint();
            myTool.setEndPoint(myEndPosition);
            
            if (myDragged && myThickness != 0) {
                myDragged = false;
               
            }
            myList.add(new PaintElements(myTool.getShape(), 
                                                    myColor, 
                                                    myFillColor, 
                                                    myWillFillShape, myThickness));

            //Once the mouse is released, I want the clear button to be enabled.
            myWillFillShape = myFillCheckboxSaid; //set back to what the Fill checkbox said
            final String clearOkay = "yes"; //since I release mouse, clear should be enabled
            firePropertyChange("clear", "no", clearOkay);
        }
    }



}