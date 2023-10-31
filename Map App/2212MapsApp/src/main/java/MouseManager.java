import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.Point;
import java.awt.event.*;

/**
 * Handles mouse input and calls on the correct functions depending on context
 * @author Ryan Lambe
 */
public class MouseManager extends MouseInputAdapter {

    private final int SIDEBAR_OFFSET = 365;
    private final int TOOLBAR_OFFSET = 8;
    
    private static MouseManager main = null;
    private static boolean hoveringIcon = false;
    private static int iconIndex = -1;

    private static MapFrameUI window;

    private static Point dragStart;


    MouseManager(MapFrameUI window){
        main = this;
        this.window = window;
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
        this.window.addMouseWheelListener(this);
    }
    
    /** Mouse click by user 
     *
     * @param event User clicks mouse
     */
    public void mouseClicked(MouseEvent event) {
        super.mouseClicked(event);

        if(SwingUtilities.isRightMouseButton(event)){
            Frame frame = new Frame();
            int createX = 0, createY = 0;
            if (window.building.equals("Thompson Engineering Building")) {
                if (window.sidebar.getFloor() == 0) {
                    createX = event.getX() - Map.getPosition()[0] + SIDEBAR_OFFSET + 1195;
                    createY = event.getY() - Map.getPosition()[1] + TOOLBAR_OFFSET + 105;
                }
                else {
                    createX = event.getX() - Map.getPosition()[0] + SIDEBAR_OFFSET;
                    createY = event.getY() - Map.getPosition()[1] + TOOLBAR_OFFSET;
                }
            }
            if (window.building.equals("Middlesex College")) {
                createX = event.getX() - Map.getPosition()[0] + SIDEBAR_OFFSET - 52;
                createY = event.getY() - Map.getPosition()[1] + TOOLBAR_OFFSET + 45;
            }
            if (window.building.equals("Westminster Hall")) {
                createX = event.getX() - Map.getPosition()[0] + SIDEBAR_OFFSET + 45;
                createY = event.getY() - Map.getPosition()[1] + TOOLBAR_OFFSET - 243;
            }
            createPOI dialog = new createPOI(frame, true, createX, createY);
            dialog.setVisible(true);
            window.sidebar.refresh();
            window.redrawMap();
        }
    }

    /** Mouse pressed by user */
    public void mousePressed(MouseEvent event){
        super.mousePressed(event);
        int[] pos = Map.getPosition();
        dragStart = event.getLocationOnScreen();
        dragStart.x -= pos[0];
        dragStart.y -= pos[1];
    }

    /** Mouse released by user */
    public void mouseReleased(MouseEvent event){
        super.mouseReleased(event);
    }

    /** Mouse dragged by user */
    public void mouseDragged(MouseEvent event){
        // When a user drags there mouse, find beginning and end point and move the map panel proportionally
        super.mouseDragged(event);

        int x = (int)(event.getLocationOnScreen().getX() - dragStart.getX());
        int y = (int)(event.getLocationOnScreen().getY() - dragStart.getY());

        Map.setPosition(x, y);

        window.repaint();
    }

    /** Mouse wheel moved by user */
    public void mouseWheelMoved(MouseWheelEvent event){
        super.mouseWheelMoved(event);

        Map.scale(-0.1f * (float)event.getWheelRotation());

        window.repaint();
    }
}
