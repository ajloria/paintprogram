/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This describes line tool behavior.
 * @author Andrew Joshua Loria
 * @version 11/8/17
 *
 */
public class LineTool extends AbstractTool {
    
    /**
     * Constructor of LineTool by calling AbstractTool and having start and
     * end point as parameters.
     * @param theStartPoint start point.
     * @param theEndPoint end point.
     */
    public LineTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        super(theStartPoint, theEndPoint);        
        
    }

    @Override
    public Shape getShape() {
        return new Line2D.Double(getStartPoint(), getEndPoint());
    }

}
