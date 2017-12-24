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
import tools.PencilTool;
import tools.Tool;
import view.PaintPanel;
import view.PowerpaintGUI;

/**
 * The Action that occurs when the Pencil tool is selected.
 * @author Andrew Joshua Loria
 * @version 11/10/17
 *
 */
public class PencilAction extends AbstractAction {
    
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
    public PencilAction(final PaintPanel thePanel) {
        super("Pencil", (new ImageIcon(PowerpaintGUI.class.getResource("/resources/pencil.gif"))));        
        myPanel = thePanel;
        myTool = new PencilTool(STARTING_POINT, STARTING_POINT);
        putValue(Action.SHORT_DESCRIPTION, "Pencil Tool");
        putValue(Action.SELECTED_KEY, "anything other than null!");

    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
    }
    
    /** 
     * Return Pencil tool.
     * 
     * @return returns the Pencil tool.
     */
    public Tool getTool() {
        return myTool;
    }
   

}
