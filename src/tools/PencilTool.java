/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * This class creates new PencilTool.
 * 
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class PencilTool extends AbstractTool {
    
    /**Path.*/
    private Path2D myPencilPath;
    
    /**
     * Constructs new Pencil with the start and end points.
     * 
     * @param theStartPoint the start point.
     * @param theEndPoint the end point.
     */
    public PencilTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);
        myPencilPath = new Path2D.Double();
    }
    
    /**
     * Set the start point of pencil tool.
     * @param theStartPoint the starting point.
     */
    public void setStartPoint(final Point2D theStartPoint) {
        myPencilPath = new Path2D.Double();
        myPencilPath.moveTo(theStartPoint.getX(), theStartPoint.getY());
    }
    
    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        myPencilPath.lineTo(getEndPoint().getX(), getEndPoint().getY());
        return myPencilPath;
        
    }

}