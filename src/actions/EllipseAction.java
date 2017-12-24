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
import tools.EllipseTool;
import tools.Tool;
import view.PaintPanel;
import view.PowerpaintGUI;

/**
 * The Action that occurs when the Ellipse tool is selected.
 * 
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class EllipseAction extends AbstractAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -2127311033567909957L;

    /** The initial point of the tool. */
    private static final Point2D.Double INITIAL_POINT = new Point2D.Double(0, 0);
    
    /** The PaintPanel. */
    private final PaintPanel myPanel;
    
    /** The tool that represents the Ellipse. */
    private final Tool myTool;
    
    /**
     * Construct an Action of the Ellipse tool.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public EllipseAction(final PaintPanel thePanel) {
        super("Ellipse", (new ImageIcon(PowerpaintGUI.class.getResource("/resources/ellipse.gif"))));        
                
        myPanel = thePanel;
        myTool = new EllipseTool(INITIAL_POINT, INITIAL_POINT);
        putValue(Action.SHORT_DESCRIPTION, "Ellipse Tool");
        putValue(Action.SELECTED_KEY, "anything other than null!");

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
       

    }
    
    /** 
     * This returns the Ellipse tool.
     * 
     * @return returns the Ellipse tool.
     */
    public Tool getTool() {
        return myTool;
    }
    
 
    
}