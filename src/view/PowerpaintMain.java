/*
 * TCSS 305 - Autumn 2017
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Main method that starts the program up.
 * Creates metal look and feel.
 * @author Andrew Joshua Loria
 * @version 11/6/17
 *
 */
public final class PowerpaintMain {
   
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerpaintMain() {
        throw new IllegalStateException();
    }
    
    /**
     * Set the look and feel for the GUI program.
     */
    private static void setLookAndFeel() {
        
        try {
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        
        } catch (final UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException");
        } catch (final ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (final InstantiationException e) {
            System.out.println("InstantiationException");
        } catch (final IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
        
    }
    
    /**
     * Main method.
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                setLookAndFeel();
                new PowerpaintGUI();

            }
        });
    }

}
