/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */
package tools;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * This class creates new Ellipse tool.
 * 
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class EllipseTool extends AbstractTool {
    
    /**
     * Constructs new Ellipse with the start and end points.
     * 
     * @param theStartPoint the start point.
     * @param theEndPoint the end point.
     */
    public EllipseTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);
    }
    
    @Override
    public Shape getShape() {
        final Ellipse2D.Double ellipse = new Ellipse2D.Double();
        //new Ellipse2D.Double
        ellipse.setFrameFromDiagonal(getStartPoint(), getEndPoint());
        
        return ellipse;
    }
    


}