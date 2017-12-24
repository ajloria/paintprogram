/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * In this abstract class, default behavior for each tool
 * is described here.
 * 
 * @author Andrew Joshua Loria
 * @version 11/8/17
 */
public abstract class AbstractTool implements Tool {
    
    /** Starting point. */
    private Point2D myStartPoint;
    
    /** End point. */
    private Point2D myEndPoint;
    
    /**
     * Initialize instance fields in constructor.
     * 
     * @param theStartPoint the start point of the shape.
     * @param theEndPoint the end point of the shape.
     */
    protected AbstractTool(final Point2D theStartPoint, final Point2D theEndPoint) {
        //initialize
        myStartPoint = theStartPoint;
        myEndPoint = theEndPoint;
    }
    
    /** 
     * The start point is set here.
     */
    @Override
    public void setStartPoint(final Point2D theStartPoint) {
        myStartPoint = theStartPoint;
        
    }

    /**
     * The end point is set here.
     */
    @Override
    public void setEndPoint(final Point2D theEndPoint) {
        myEndPoint = theEndPoint;
        
    }

    /**
     * Return start point.
     */
    @Override
    public Point2D getStartPoint() {
        return myStartPoint;
    }
    
    /**
     * Return end point.
     */
    @Override
    public Point2D getEndPoint() {
        return myEndPoint;
    }
    
    /** 
     * Return shape.
     */
    @Override
    public abstract Shape getShape();

}