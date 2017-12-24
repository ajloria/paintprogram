/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Creates ToolBar for PowerPaint GUI.
 * @author Andrew Joshua Loria
 * @version 11/13/17
 */
public class ToolBar extends JToolBar {
    /**
     * Generated serial ID.
     */
    private static final long serialVersionUID = -6297787221312734786L;
    
    /**Button group.*/
    private final ButtonGroup myButtonGroup;

    /**
     * Creates new toolbar.
     */
    public ToolBar() {
        super("PowerPaint ToolBar");
        myButtonGroup = new ButtonGroup();
    }

    /**
     * Create a toggle button for the toolbar for each action.
     * @param theAction the Tool action.
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton tglbtn = new JToggleButton(theAction);
        myButtonGroup.add(tglbtn); //add to buttongroup
        add(tglbtn); //add button to toolbar
        
    }


}
