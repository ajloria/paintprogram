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
import tools.RoundRectangleTool;
import tools.Tool;
import view.PaintPanel;
import view.PowerpaintGUI;

/**
 * The Action that occurs when the RoundRectangle tool is selected.
 * @author Andrew Joshua Loria
 * @version 11/10/17
 *
 */
public class RoundRectangleAction extends AbstractAction {
    
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
     * Construct an Action of the RoundRectangle tool.
     * 
     * @param thePanel a PaintPanel to associate with this Action.
     */
    public RoundRectangleAction(final PaintPanel thePanel) {
        super("RoundRectangle", (new ImageIcon(PowerpaintGUI.class.getResource("/resources/roundrectangle.gif"))));        
        myPanel = thePanel;
        myTool = new RoundRectangleTool(STARTING_POINT, STARTING_POINT);
        putValue(Action.SHORT_DESCRIPTION, "RoundRectangle Tool");
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    /** 
     * Return RoundRectangle tool.
     * 
     * @return returns the RoundRectangle tool.
     */
    public Tool getTool() {
        return myTool;
    }
   

}
