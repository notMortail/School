import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.sql.Time;
import java.util.ArrayList;

public class IconPanel extends JLabel {

    Point pos = new Point(0, 0);

    static ArrayList<IconPanel> icons = new ArrayList<>();

    public IconPanel(){
        System.out.println("icon created");
        icons.add(this);
        setBackground(Color.WHITE);
    }

    public void setPos(int x, int y){
        pos = new Point(x, y);
        setLocation(x/2, y/2);
    }

    public Point getPos(){
        return pos;
    }

    static void resetIcons() {
        icons.clear();
    }
}
