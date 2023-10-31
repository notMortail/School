import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Holds the data for the map being displayed to the user
 * @author Trevor Seanan
 */
public class Map {
    /** The x coordinate of the map */
    private static int mapX;
    
    /** The y coordinate of the map */
    private static int mapY;
    
    /** The scale (zoom) of the map */
    private static float scale;
    
    /** The transformation of the map */
    private static AffineTransform transform = new AffineTransform();
    
    /** The array of icons being displayed of the map */
    public ArrayList<Icon> icons;
    
    /** The image path of the current map */
    public String imgPath;

    private static int imgX;

    private static int imgY;
    
    
    /** The constructor of the map, to initialize an instance of a map. 
     * Since the sidebar handles the the functionality of the map, the 
     * constructor takes no parameters.
     */
    public Map() {
        this.mapX = 0;
        this.mapY = 0;
        this.scale = 1;
        this.icons = new ArrayList<Icon>();
        // This is causing a bug
        // this.mapPanel = new DrawMap("Assets/Maps/MiddlesexCollege-0.png");
    }

    /** Sets the scale of the map
     * 
     * @param newScale scale map to this value
     */
    public static void setScale(float newScale) {
        scale = newScale;
    }

    /** This function creates an icon given a point. This is a helper function for the buildIcons method
     * 
     * @param point the point needed to be made an icon
     * @return the newly created icon
     */
    public Icon createIcon(Point point){
        Icon newIcon = new Icon(point);
        return newIcon;
    }
    
        /** This function builds the icons that will be displayed on the map from the list of points filtered by the sidebar
     * 
     * @param points The points needed to be displayed
     */
    public void buildIcons(Point[] points) {
        // Iterate over the array, create icon, append icon to icon
        IconPanel.resetIcons();
        if (!icons.isEmpty()) {
            icons.clear();
        }
        for (Point point : points) {
            Icon newIcon = createIcon(point);
            icons.add(newIcon);
        }
    }
    
    /** Sets the position of the map */
    public static void setPosition(int x, int y) {
        mapX = x;
        mapY = y;
    }

    /** Gets the position of the map */
    public static int[] getPosition() {
        return new int[]{mapX, mapY};
    }
    
        /** Updates the icons displayed */
    public void udpdateIcons(Point[] points) {
        // TODO
        // Using buildIcons sacrifices storage but optimizes runtime for refreshing points
        icons.clear();
        buildIcons(points);
    }
    
    /** This function builds a floor map. All parameters must be specified. If there is no floor (example, the user selects a building from the homepage)
     * it is best practice to set the floor to 1.
     * 
     * @param building The building the user is viewing
     * @param floor the floor of the building that will be displayed
     * @param mapPanel the map panel to draw to
     */
    public void buildMap(String building, int floor, Point[] points) {
        // TODO
        
        String imgPath = "Assets/Maps/"+ building.replaceAll("\\s", "") +"-"+floor+".png";
        this.imgPath = imgPath;
        buildIcons(points);
        
        
    }
    
    /** Translate moves the map based on the user input (when a user clicks and 
     * drags).
     * The mouse manager specifies how much the x and y are too be translated.
     *  
     * @param x translation on the x-axis
     * @param y translation on the y-axis
     */
    public static void translate(int x, int y) {
        mapX += x;
        mapY += y;
    }
    
    /** Given an x and y out of bounds of the display, clamps them to be within 
     * bounds.
     * 
     * @param x x coordinate of attempted translation
     * @param y y coordinate of attempted translation
     * @return the clamped coordinates
     */
    public int[] clamp(float x, float y) {
        // TODO
        int[] coordinates = {0, 1};
        return coordinates;
    }
    
    /** Scales the map based on the user input (when a user scrolls in or out)
     * The mouse manager specifies how much the scale needs to be changed
     * 
     * @param amount the amount the scale needs to be changed by
     */
    public static void scale(float amount){
        scale += amount;
        scale = Math.max(0.25f, Math.min(10, scale));
    }
    
    /** Transforms the map based on either a translation or scale value
     * 
     */
    public AffineTransform getTransform(AffineTransform transform) {
        // TODO
        transform.translate(mapX, mapY);
        transform.scale(scale, scale);
        this.transform = transform;
        return transform;
    }
    
    /** Returns the current transformation */
    public static AffineTransform getTransform() {
        return transform;
    }
    
    /** Returns the image path */
    public String getImagePath() {
        return this.imgPath;
    }
    
    /** Returns the current list of icons stored by the map */
    public ArrayList<Icon> getIcons() {
        return this.icons;
    }

    /** Sets the map image size
     * 
     * @param x x-axis size
     * @param y y-axis size
     */
    public static void setImageSize(int x, int y){
        imgX = x;
        imgY = y;
    }
    
    /** Returns the scale of the map */
    public static float getScale(){
        return scale;
    }

    /** Returns the image size of the map */
    public static int[] getImageSize(){
        return new int[]{imgX, imgY};
    }

}
    
    
