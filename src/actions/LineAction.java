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
import tools.LineTool;
import tools.Tool;
import view.PaintPanel;
import view.PowerpaintGUI;

/**
 * Represents the action for a line.
 * @author Andrew Joshua Loria
 * @version 11/10/17
 *
 */
public class LineAction extends AbstractAction {
    
    /**
     * Generated ID.
     */
    private static final long serialVersionUID = 8422003791428559004L;

    /** Initial point of the tool. */
    private static final Point2D.Double STARTING_POINT = new Point2D.Double(0, 0);
    
    /** The JPanel to associate with this Action. */
    private final PaintPanel myPanel;
    
    /** The tool that represents the Line. */
    private final Tool myTool;
    
    
   /**
     * Construct an Action of the Line tool.
     * 
     * @param thePanel a PaintPanel.
     */
    public LineAction(final PaintPanel thePanel) {
        super("Line", (new ImageIcon(PowerpaintGUI.class.getResource("/resources/line.gif"))));        
        myPanel = thePanel;
        myTool = new LineTool(STARTING_POINT, STARTING_POINT);
        putValue(Action.SHORT_DESCRIPTION, "Line Tool");
        putValue(Action.SELECTED_KEY, "anything other than null!");

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    /** 
     * Return Line tool.
     * 
     * @return returns the Line tool.
     */
    public Tool getTool() {
        return myTool;
    }
   

}
