/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package view;

import actions.EllipseAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;
import actions.RoundRectangleAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * This class adds the elements such as toolbar and menubar to the GUI.
 * @author Andrew Joshua Loria
 * @version 11/6/17
 *
 */
public class PowerpaintGUI extends JFrame {
    
    /** The default width of the frame. */
    public static final int DEFAULT_WIDTH = 500;

    /** The default height of the frame. */
    public static final int DEFAULT_HEIGHT = 400; 
    /**
     * Generated ID.
     */
    private static final long serialVersionUID = -7074716198018469902L;
    
    /**Painting panel.*/
    private final PaintPanel myPaintPanel;
    
    /**MenuBar.*/
    private final MenuBar myMenuBar;
    
    /**ToolBar.*/
    private final ToolBar myToolBar;

    /**
     * Constructor for GUI.
     */
    public PowerpaintGUI() {
        super("PowerPaint");       
        myPaintPanel = new PaintPanel();
        myMenuBar = new MenuBar(myPaintPanel);
        myToolBar = new ToolBar();
        setUpActions();  
 
    }
    
    /**
     * Add tools to the myActions array list and assign each an action.
     */
    private void setUpActions() {
        final ArrayList<Action> actionsList = new ArrayList<Action>(); 
        actionsList.add(new LineAction(myPaintPanel));
        actionsList.add(new PencilAction(myPaintPanel));
        actionsList.add(new RectangleAction(myPaintPanel));
        actionsList.add(new RoundRectangleAction(myPaintPanel));
        actionsList.add(new EllipseAction(myPaintPanel));



        for (final Action action : actionsList) {
            myMenuBar.createMenuButton(action);
            myToolBar.createToolBarButton(action);
        }
        
        setUpFrame();

        
    }

    /**
     * Set up GUI frame.
     */
    private void setUpFrame() {
        final URL url = PowerpaintGUI.class.getResource("/resources/w.gif");
        setIconImage(new ImageIcon(url).getImage()); 
        setJMenuBar(myMenuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPaintPanel.setBackground(Color.WHITE);
        
        add(myToolBar, BorderLayout.SOUTH);
        add(myPaintPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        
        //Center frame
        setLocation(
                             (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 
                                             - getWidth() / 2),
                             (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() 
                                             / 2 - getHeight() / 2));
                         
        setVisible(true);
    }


}
