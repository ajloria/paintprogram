/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Color;
import java.awt.Shape;

/**
 * This class gives information about each paint element that will
 * be added to the paint panel: the shape, draw color, fill color,
 * and the thickness. This class will be used in an array list which
 * stores the previous used paint elements so that it will continue to 
 * appear on the PaintPanel.
 * @author Andrew Joshua Loria
 * @version 11/16/17
 *
 */
public class PaintElements {
    
    /**Shape of element.*/
    private final Shape myShape;
    
    /**Draw color of element.*/
    private final Color myDrawColor;
    
    /**Fill color of element.*/
    private final Color myFillColor;
    
    /**Says if element is filled.*/
    private final boolean myShapeFilled;
    
    /**Thickness of element.*/
    private final int myThickness;
    
    /**
     * Constructor which initializes the fields above.
     * @param theShape shape of element
     * @param theDrawColor draw color of element
     * @param theFillColor fill color of element
     * @param theFilled whether or not element filled
     * @param theThickness the thickness of the element
     */
    public PaintElements(final Shape theShape, final Color theDrawColor,
                         final Color theFillColor, final boolean theFilled,
                         final int theThickness) {
        myShape = theShape;
        myDrawColor = theDrawColor;
        myFillColor = theFillColor;
        myShapeFilled = theFilled;
        myThickness = theThickness;
    }
    
    /**
     * Get the shape of the element.
     * @return name of shape.
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * Get the draw color of the element.
     * @return draw color.
     */
    public Color getDrawColor() {
        return myDrawColor;
    }
    
    /**
     * Get the fill color of the element.
     * @return fill color.
     */
    public Color getFillColor() {
        return myFillColor;
    }
    
    /**
     * Get whether or not element filled.
     * @return boolean true if filled.
     */
    public boolean isFilled() {
        return myShapeFilled;
    }
    
    /**
     * Get the thickness of the element.
     * @return thickness.
     */
    public int getThickness() {
        return myThickness;
    }

}
