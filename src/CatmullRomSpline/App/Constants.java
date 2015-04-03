package CatmullRomSpline.App;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Constant values used all over the application.
 * 
 * @author Juraj Strecha, duri.strecha@gmail.com
 * @version 1.0
 */
public class Constants {
    /* colors */
    public static final Color BACKGROUND_COLOR = new Color(52, 73, 94);
    public static final Color CANVAS_COLOR = new Color(236, 240, 241);
    public static final Color SPLINE_COLOR = new Color(155, 89, 182);
    public static final Color TRANSLUCENT_CANVAS_COLOR = new Color(0, 0, 0, 0);
    public static final Color CONTROL_POINT_COLOR = new Color(211, 84, 0);
    
    /* dimensions */
    public static final Dimension APP_WINDOW_MIN_SIZE = new Dimension(800, 600);
    public static final Dimension CANVAS_SIZE = new Dimension(640, 480);
    public static final Dimension CTRL_BUTTONS_SIZE = new Dimension(100, 30);
    public static final Dimension CTRL_BUTTONS_GAP = new Dimension(0, 10);
    
    /* various numerical values */
    public static final int CROSS_VERT_DIAMETER = 4;
    public static final int CROSS_HORIZ_DIAMETER = 4;
    public static final int SPLINE_SAMPLES_PER_SPAN = 20;
    public static final int SPLINE_THICKNESS = 2;
    public static final float ALIGN_CENTER = 0.5f;
}
