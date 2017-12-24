/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;


/**
 * Creates the MenuBar for PowerPaint.
 * @author Andrew Joshua Loria
 * @version 11/13/17
 *
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {
    

    /**
     * Generated ID.
     */
    private static final long serialVersionUID = 3760196898480077389L;
    
    /**Husky purple color.*/
    private static final Color HUSKY_PURP = new Color(51, 0, 111);

    /**Husky gold color.*/
    private static final Color HUSKY_GOLD = new Color(232, 211, 162);
    
    /** Major tick spacing for slider.*/
    private static final int MAJOR_TICK = 5;    
    
    /**Button group.*/
    private final ButtonGroup myButtonGroup;

    /** Frame for this project.*/
    private final JFrame myFrame;
    
    /**Options Menu for menu bar.*/
    private final JMenu myOptionsMenu;
    
    /**Tools Menu for menu bar.*/
    private final JMenu myToolMenu;
    
    /**Help Menu for menu bar.*/
    private final JMenu myHelpMenu;

    
    /**The PaintPanel used in the GUI.*/
    private final PaintPanel myPaintPanel;
    
    /**Clear button.*/
    private final JMenuItem myClearButton;
    
    /**Fill check box.*/
	private JCheckBoxMenuItem myFillCheckBox;
    
   
    /**
     * Creates new tool menu bar.
     * @param thePanel the PaintPanel used in the GUI.
     */
    public MenuBar(final PaintPanel thePanel) {
        super();
        myButtonGroup = new ButtonGroup();
        myFrame = new JFrame();
        myClearButton = new JMenuItem("Clear");
        myOptionsMenu = new JMenu("Options");
        add(setUpOptions());
        myToolMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myPaintPanel = thePanel;
        add(setUpHelp());       
    }


    /**
     * Set up "Options".
     * @return menu of options.
     */
    private JMenu setUpOptions() {
        final JMenu thicknessMenu = new JMenu("Thickness");       
        final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 
                                          0, 25, 5);
        thicknessSlider.setMajorTickSpacing(MAJOR_TICK);
        thicknessSlider.setMinorTickSpacing(1);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setPaintTicks(true);
        thicknessMenu.add(thicknessSlider);
        myOptionsMenu.add(thicknessMenu);
        
        thicknessSlider.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(final PropertyChangeEvent theEvent) {
                final int thickness = thicknessSlider.getValue();
                myPaintPanel.setThickness(thickness);
                
            }
            
            });

        
        myOptionsMenu.addSeparator();
        
        final JMenuItem drawColor = new JMenuItem("Draw Color...");
        drawColor.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final Color drawColor = JColorChooser.showDialog(null, 
                                         "Draw Color Chooser", HUSKY_PURP);   
                myPaintPanel.setColor(drawColor);
                
            }
        });
        myOptionsMenu.add(drawColor);
        
        final JMenuItem fillColorMenuItem = new JMenuItem("Fill Color...");
        fillColorMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final Color fillColor = JColorChooser.showDialog(null, 
                                         "Fill Color Chooser", HUSKY_GOLD);  
                myPaintPanel.setFill(fillColor);
            }
        });
        myOptionsMenu.add(fillColorMenuItem);
        
        myOptionsMenu.addSeparator();
        
        myFillCheckBox = new JCheckBoxMenuItem("Fill");
        myOptionsMenu.add(myFillCheckBox);
        
        
        myFillCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (myFillCheckBox.isSelected()) {
                    myPaintPanel.fillBoxSaid(true);
                } else {
                    myPaintPanel.fillBoxSaid(false);

                }
                
            }
        });
        
        //Clear Button
        myOptionsMenu.addSeparator();
        myClearButton.setEnabled(false);
        myOptionsMenu.add(myClearButton);
        
        
        myClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myPaintPanel.clearPaintPanel(true);
                myClearButton.setEnabled(false);
            }
        });

        
        return myOptionsMenu;
    }
    
    public void resetFill() {
    	myFillCheckBox.setSelected(false);
    }

    /**
     * Set up "Help" which includes About menu item.
     * @return menu of help.
     */
    private JMenu setUpHelp() {

        final JMenuItem aboutButton = new JMenuItem("About...");
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                //resize UW logo for the About dialog
            	final URL url = MenuBar.class.getResource("/resources/w.gif");
                final ImageIcon resizedIcon = new ImageIcon(new ImageIcon(url).
                                                            getImage().
                                getScaledInstance(57, 40, Image.SCALE_SMOOTH));
                //Display About
                JOptionPane.showMessageDialog(myFrame, "TCSS 305 Powerpaint \nAutumn 2017"
                                + "\nAndrew Joshua Loria"
                                + "\nIcon: University of Washington", "About", 
                                              JOptionPane.INFORMATION_MESSAGE, 
                                              resizedIcon);
            }
        });
        
        myHelpMenu.add(aboutButton);
        addStuff();        
        return myHelpMenu;                 
            
    }
    
    /**
     * Add each menu to the menu bar in the order of
     * Options, Tools, Help. Also add PropertyChangeListener.
     */
    private void addStuff() {
        myPaintPanel.setFill(HUSKY_GOLD); 
        add(myOptionsMenu);
        add(myToolMenu);
        add(myHelpMenu);
        
        //add PropertyChangeListener to PaintPanel
        myPaintPanel.addPropertyChangeListener(this);
        
        
    }

    /**
     * Make tools menu bar button for each action.
     * @param theAction action for tool.
     */
    public void createMenuButton(final Action theAction) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        myButtonGroup.add(createdButton);
        myToolMenu.add(createdButton);      
    }
  
    // Here is the handler for property change events
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("clear".equals(theEvent.getPropertyName())) {                
            myClearButton.setEnabled("yes".equals(theEvent.getNewValue())); //enable "Clear"
        }
        
        if ("fill".equals(theEvent.getPropertyName()) &&
        		"unfilled".equals(theEvent.getNewValue())) {                
           myFillCheckBox.setSelected(false); //disable "fill"
        }
        
    }

}



