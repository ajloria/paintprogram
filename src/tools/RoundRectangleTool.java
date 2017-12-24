/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */
package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 * This class creates new RoundedRectangle tool.
 * 
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class RoundRectangleTool extends AbstractTool {
    
    /**Default arc dimension to be used for both arc height and width.*/
    public static final double DEFAULT_ARC_DIM = 20.0;

    
    /**
     * Constructs new Rectangle with the start and end points.
     * 
     * @param theStartPoint the start point.
     * @param theEndPoint the end point.
     */
    public RoundRectangleTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);
    }
    
    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        final RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double();
        roundRect.archeight = DEFAULT_ARC_DIM;
        roundRect.arcwidth = DEFAULT_ARC_DIM;
        roundRect.setFrameFromDiagonal(getStartPoint(), getEndPoint());
        
        return roundRect;
    }

}