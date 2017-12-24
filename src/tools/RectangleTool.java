/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */
package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class creates new Rectangle tool.
 * 
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class RectangleTool extends AbstractTool {
    
    /**
     * Constructs new Rectangle with the start and end points.
     * 
     * @param theStartPoint the start point.
     * @param theEndPoint the end point.
     */
    public RectangleTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);
    }
    
    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        final Rectangle2D.Double rect = new Rectangle2D.Double();
        rect.setFrameFromDiagonal(getStartPoint(), getEndPoint());
        
        return rect;
    }

}