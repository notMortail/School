import java.util.*;
/**
 * Manages filters and searching of Points of Interest
 * 
 * Filtered list of Points of Interest is updated via @refresh method. 
 * @author Kyven Tran
 */

public class SideBar {

    /**
     * The default value in the Room Filter combo box
     */
    private final String DEFAULT_ROOM_FILTER_IDENTIFIER = "Room Type";
    /**
     * The list of all different room types. The room filter is set to this by default.
     */
    private final String[] DEFAULT_ROOM_FILTER = {"Classroom", "Computer Lab", "Collaborative Room", "Mens Washroom", "Restaurant", "Unisex Washroom", "Womens Washroom", "Elevator", "Stairs", "Door"};
    /**
     * If the user has enabled the Favourites filter
     */
    private Boolean favourited;
    /**
     * List of active room types. If the user filters by a room type, it will hold only that room type. 
     */
    private String[] roomTypes;
    /**
     * Name searched for by the user. 
     */
    private String search;
    /**
     * List of all points that apply to the current filters
     */
    private Point[] filteredPoints;
    /**
     * Current floor number of building.
     */
    private static int floor;
    /**
     * Name of building
     */
    private String building;
    
    /** If the point represents stairs, exit signs, or washrooms, it will not be displayed */
    private boolean display;
    
    /** The icons currently held by the sidebar */
    private ArrayList<Icon> icons;

    
    /**
     * SideBar constructor. Creates a Sidebar object. 
     * 
     * @param building the building name
     */
    SideBar(String building) {
        favourited = false;
        floor = 1;
        this.building = building;
        roomTypes = DEFAULT_ROOM_FILTER;
        search = "";
        filteredPoints = AccountManager.GetPoints(search, favourited, floor, this.building, roomTypes);

        System.out.println("start");
                
        for (int i = 0; i < filteredPoints.length; i++) {
            System.out.println(i);
        }
        Point testPoint1 = new Point(1500, 1500, "Point A", "Classroom", 1, "Middlesex College", true, true);
        Point testPoint2 = new Point(1000, 2000, "Point B", "Classroom", 1, "Thompson Engineering Building", true, true);
        
        Point[] testPoints = {testPoint1, testPoint2};
        //filteredPoints = testPoints;
    }

    /**
     * Retrieves new list of points according to current applied filters.
     */
    public void refresh() {
        filteredPoints = AccountManager.GetPoints(search, favourited, floor, building, roomTypes);
    }
    
    /**
     * Updates search to new search term
     * @param name New name to search for.
     */
    public Point[] searchPOI(String name) {
        
        if (name == "") {
            return filteredPoints;
        }
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < filteredPoints.length; i++) {
            if (filteredPoints[i].getName().contains(name) == true) {
                points.add(filteredPoints[i]);
            }
        }
        // search = name;
        return points.toArray(Point[]::new);
    }
    
    /**
     * Updates favourited
     * @param on New value of favourited
     */
    public void enableOnlyFavourites(Boolean on) {
        if (on == true) {
            favourited = true;
        } else {
            favourited = false;
        }
    }

    /**
     * Updates floor to new floor number
     * @param floorNum New floor number
     */
    public void enableOnlyFloor(int floorNum) {
        floor = floorNum;
    }
    
    /**
     * Updates roomTypes filter to new room type
     * @param icon Room type to filter by. 
     */
    public void enableOnlyIcon(String icon) {
        if (icon.compareTo(DEFAULT_ROOM_FILTER_IDENTIFIER) == 0) {
            roomTypes = DEFAULT_ROOM_FILTER;
        } else {
            String[] newRoomFilter = new String[1];
            newRoomFilter[0] = icon;
            roomTypes = newRoomFilter;
        }
    }
    
    /**
     * Sets the building and resets filters
     * @param building New building
     */
    public void setBuilding(String building) {
        favourited = false;
        floor = 1;
        this.building = building;
        roomTypes = DEFAULT_ROOM_FILTER;
        search = "";
        filteredPoints = AccountManager.GetPoints(search, favourited, floor, this.building, roomTypes);
    }
    
    /**
     * Getter for floor number
     * @return floor number
     */
    public static int getFloor() {
        return floor;
    }
    
    /**
     * Getter for building name
     * @return building name
     */
    public String getBuilding() {
        return building;
    }
    
    /**
     * Getter for filtered points
     * @return list of filtered points
     */
    public Point[] getPoints() {
        return filteredPoints;
    }
    
    /**
     * Getter for icons
     * @return list of icons
     */
    public Icon[] getIcons() {
        Icon[] iconArray = new Icon[icons.size()];
        return icons.toArray(iconArray);
    }
    
    /**
     * Getter for if favourited filter is on
     * @return favourited boolean
     */
    public boolean isFavourited() {
        return favourited;
    }
}

