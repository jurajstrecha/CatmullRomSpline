package CatmullRomSpline.GUI;

import CatmullRomSpline.App.Constants;
import CatmullRomSpline.Logic.CatmullRom;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Main graphical user interface for the Catmull-Rom Spline Demonstration application.
 * Creates and initializes all interface components and adds their functionality as well.
 * 
 * @author Juraj Strecha, duri.strecha@gmail.com
 * @version 1.0
 */
public class AppInterface extends JFrame {
    private Canvas canvas;
    private Button buttonGenerate;
    private Button buttonReset;
    private JLabel splineLengthLabel;
    
    public AppInterface() {
        super("Catmull Rom Spline Demonstration");
        
        // set up the application main window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Constants.BACKGROUND_COLOR);
        setMinimumSize(Constants.APP_WINDOW_MIN_SIZE);
        
        // creater, initialize and add components to the interface
        addComponentsToPane(getContentPane());

        // display the window
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Construct, set and add all GUI components to the main window.
     * 
     * @param pane Pane for constructed components
     */
    private void addComponentsToPane(Container pane) {
        pane.setLayout(new BorderLayout());
        
        JPanel canvasHolder = new JPanel();
        canvasHolder.setBackground(Constants.TRANSLUCENT_CANVAS_COLOR);
        canvasHolder.setLayout(new GridBagLayout());        
        canvas = new Canvas();
        canvas.setBackground(Constants.CANVAS_COLOR);
        canvas.setPreferredSize(Constants.CANVAS_SIZE);        
        canvasHolder.add(canvas);
        pane.add(canvasHolder, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        controls.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        controls.setLayout(new BoxLayout(controls ,BoxLayout.Y_AXIS));
        buttonGenerate = addButton(controls, "Generate");
        buttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Point> controlPoints = canvas.getControlPoints();
                ArrayList<Point> splinePoints;
                splinePoints = CatmullRom.calculateSpline(controlPoints);
                canvas.setSplinePoints(splinePoints);
                int length = (int)CatmullRom.getSplineLength(splinePoints);
                splineLengthLabel.setText("d = " + length);
            }
        });
        controls.add(Box.createRigidArea(Constants.CTRL_BUTTONS_GAP));
        buttonReset = addButton(controls, "Reset");
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.reset();
                splineLengthLabel.setText("");
            }
        });
        controls.add(Box.createRigidArea(Constants.CTRL_BUTTONS_GAP));
        splineLengthLabel = new JLabel();
        splineLengthLabel.setAlignmentX(Constants.ALIGN_CENTER);
        controls.add(splineLengthLabel);
        JPanel controlsHolder = new JPanel();
        controlsHolder.add(controls);
        pane.add(controlsHolder, BorderLayout.EAST);        
    }
    
    /**
     * Creates button with preferred button size and adds it to the provided 
     * container.
     * 
     * @param container Container for the button to be added to
     * @param text Text displayed on the button
     */
    private static Button addButton(Container container, String text) {
        Button button = new Button(text);
        button.setPreferredSize(Constants.CTRL_BUTTONS_SIZE);
        container.add(button);
        return button;
    }
}
