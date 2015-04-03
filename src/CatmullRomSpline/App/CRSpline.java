/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatmullRomSpline.App;

import CatmullRomSpline.GUI.AppInterface;
import javax.swing.SwingUtilities;

/**
 *
 * @author juraj
 */
public class CRSpline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppInterface();
            }
        });
    }
    
}
