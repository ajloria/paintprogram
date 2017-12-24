/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import tools.RectangleTool;
import tools.Tool;
import view.PaintPanel;
import view.PowerpaintGUI;

/**
 * The Action that occurs when the Rectangle tool is selected.
 * @author Andrew Joshua Loria
 * @version 11/10/17
 *
 */
public class RectangleAction extends AbstractAction {
    
    /**
     * Generated serial version ID.
     */
    private static final long serialVersionUID = 1371023205787747971L;

    /** Initial point of the tool. */
    private static final Point2D.Double STARTING_POINT = new Point2D.Double(0, 0);
    
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    /** The tool that represents the Line. */
    private final Tool myTool;
    
    
   /**
     * Construct an Action of the Rectangle tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public RectangleAction(final PaintPanel thePanel) {
        super("Rectangle", (new ImageIcon(PowerpaintGUI.class.getResource("/resources/rectangle.gif"))));        
        myPanel = thePanel;
        myTool = new RectangleTool(STARTING_POINT, STARTING_POINT);
        putValue(Action.SHORT_DESCRIPTION, "Rectangle Tool");
        putValue(Action.SELECTED_KEY, "anything other than null!");

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    /** 
     * Return Rectangle tool.
     * 
     * @return returns the Rectangle tool.
     */
    public Tool getTool() {
        return myTool;
    }
   

}
