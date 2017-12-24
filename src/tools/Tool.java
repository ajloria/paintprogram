/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Tool interface.
 * Defines behavior common to all Tool subclasses.
 * 
 * @author Andrew Joshua Loria
 * @version 11/8/17
 */
public interface Tool {
    
    /**
     * Sets start point.
     * 
     * @param theStartPoint the start point.
     */
    void setStartPoint(Point2D theStartPoint);
    
    /**
     * Sets end point.
     * 
     * @param theEndPoint the end point.
     */
    void setEndPoint(Point2D theEndPoint);
    
    /**
     * Returns start point.
     * 
     * @return the start point.
     */
    Point2D getStartPoint();
    
    /**
     * Returns end point.
     * 
     * @return the end point.
     */
    Point2D getEndPoint();
    
    /**
     * Returns shape.
     * 
     * @return shape
     */
    Shape getShape();
}