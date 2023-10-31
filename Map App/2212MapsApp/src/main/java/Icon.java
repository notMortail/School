  import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Frame;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * An icon represents a point on the map. It is the visual aspect of a point
 * @author Trevor
 */
public class Icon implements MouseListener {
    
    /** The point that this icon represents */
    public Point point;
    
    /** The image panel for the icon image */
    public JLabel imgLabel;
    
    // public ImagePanel image;
    
    /** The scale of the image being displayed. By default this value is 1 */
    public float scale;
    
    /** Creates an icon representing the given point
     * @param point the default x coordinate of the icon
    */
    public Icon(Point point) {
        this.point = point;
        this.imgLabel = new JLabel();
        ImageIcon img = new ImageIcon("Assets/Icons/" + point.getIconImg().replaceAll("\\s", "") + ".png"); // Create image icon
        
        imgLabel.setIcon(img);
        imgLabel.setText(point.getName());
        imgLabel.setHorizontalTextPosition(JLabel.CENTER); // Align text in center
        imgLabel.setVerticalTextPosition(JLabel.BOTTOM); // Align text on bottom
        imgLabel.setForeground(new Color(0x0C0D0F)); // Set text colour
        imgLabel.setOpaque(false); // Keep background transparent
        imgLabel.setIconTextGap(5);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setPreferredSize(new Dimension(30, 30));
        imgLabel.setBounds((int) this.point.getX(), (int) this.point.getY(), 60, 60);
        imgLabel.setLocation((int) this.point.getX(), (int) this.point.getY());
        imgLabel.addMouseListener(this);
        imgLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    }
    
    /** Verifies the path of an image is valid
     * 
     * @param imgPath
     * @return 
     */
    public boolean verifyImgPath(String imgPath) {
        // Verify the image path is valid
        File IconsFolder = new File("Assets/Icons/");
        File[] folderSearch = IconsFolder.listFiles((File dir, String name1) -> name1.equals(imgPath));
        return folderSearch.length != 0;
    }
    
    /** Updates the icon image specified by the image Path
     * 
     * @param imgPath The filepath to the image (Ex: "book.png");
     */
    public void updateImage(String imgPath) {
        String newImagePath = imgPath;
        if (this.point.isFavourite()) {
            newImagePath = newImagePath + "Favourite";
        }
        ImageIcon newImg = new ImageIcon("Assets/Icons/" + newImagePath.replaceAll("\\s", "") + ".png");
        imgLabel.setIcon(newImg);
        this.point.setIcon(imgPath);
    }
    
    /** Updates the icon title specified by the string title
     * 
     * @param title The new icon title
     */
    public void updateTitle(String title) {
        imgLabel.setText(title);
        point.setName(title);
    }
    
    public void updatePosition(int x, int y) {
        imgLabel.setLocation(x, y);
    }
    
    /** Transforms a point
     * @param scale the scale by which an icon is transformed 
     */
    public void transform(float scale) {
        this.scale = scale;
    }
    
    private boolean invalidType(String iconType) {
        String[] invalidTypes = {"Stairs", "Elevator", "Exit", "Door"};
        for (int i = 0; i < invalidTypes.length; i++) {
            if (iconType.equals(invalidTypes[i]))
                return true;
        }
        return false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // If the user left clicked...
        if (e.getButton() == MouseEvent.BUTTON1) {
            // Verify the user left clicked on a valid icon
            if (!invalidType(this.point.getIconImg())) {
                System.out.println("Clicked");
        
                Frame frame = new Frame();
        
                selectPOI dialog = new selectPOI(frame, true, this);
                dialog.setVisible(true);
            }
        }
        else {
            if (!this.point.isBuiltIn()) {
                Frame frame = new Frame();
                EditPOI dialog = new EditPOI(frame, true, this);
                dialog.setVisible(true);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }
    
    /** Checks if the user is hovering over the icon
     * 
     * @param event
     */
    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO
        System.out.println("Entered");
    }
    
    /** Checks when the user has exited the icon
     *
     * @param event 
     */
    @Override
    public void mouseExited(MouseEvent event) {
        // TODO
        System.out.println("Exited");
    }
}
