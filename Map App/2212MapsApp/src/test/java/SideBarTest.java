/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kyven
 */
public class SideBarTest {
    
    public SideBarTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("SideBarTest.setUpClass()");
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("SideBarTest.tearDownClass()");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("SideBarTest.setUp()");
        Point testPoint1 = new Point(0, 0, "Point A", "Classroom", 1, "Middlesex College", true, true);
        Point testPoint2 = new Point(0, 0, "Point B", "Classroom", 1, "Thompson Engineering Building", true, true);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("SideBarTest.tearDown()");
    }

    /**
     * Test of refresh method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testRefresh() {
        System.out.println("refresh");
        SideBar instance = new SideBar("Middlesex College");
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPOI method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testSearchPOI() {
        System.out.println("searchPOI");
        String name = "";
        SideBar instance = null;
        Point[] expResult = null;
        Point[] result = instance.searchPOI(name);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableOnlyFavourites method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testEnableOnlyFavourites() {
        System.out.println("enableOnlyFavourites");
        Boolean on = null;
        SideBar instance = null;
        instance.enableOnlyFavourites(on);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableOnlyFloor method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testEnableOnlyFloor() {
        System.out.println("enableOnlyFloor");
        int floorNum = 0;
        SideBar instance = null;
        instance.enableOnlyFloor(floorNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enableOnlyIcon method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testEnableOnlyIcon() {
        System.out.println("enableOnlyIcon");
        String icon = "";
        SideBar instance = null;
        instance.enableOnlyIcon(icon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBuilding method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        String building = "";
        SideBar instance = null;
        instance.setBuilding(building);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFloor method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testGetFloor() {
        System.out.println("getFloor");
        int expResult = 0;
        int result = SideBar.getFloor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuilding method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        SideBar instance = null;
        String expResult = "";
        String result = instance.getBuilding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoints method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testGetPoints() {
        System.out.println("getPoints");
        SideBar instance = null;
        Point[] expResult = null;
        Point[] result = instance.getPoints();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIcons method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testGetIcons() {
        System.out.println("getIcons");
        SideBar instance = null;
        Icon[] expResult = null;
        Icon[] result = instance.getIcons();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFavourited method, of class SideBar.
     */
    @org.junit.jupiter.api.Test
    public void testIsFavourited() {
        System.out.println("isFavourited");
        SideBar instance = null;
        boolean expResult = false;
        boolean result = instance.isFavourited();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
