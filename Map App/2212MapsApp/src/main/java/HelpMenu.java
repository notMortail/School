import javax.swing.*;
import java.awt.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kyven
 */
public class HelpMenu extends JFrame {

    /**
     * Creates new form HelpMenu
     */
    public HelpMenu() {
        super("Help");
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpPane.setText("Navigating the Homepage \n     To open a building map, you can press the icon above the desired building. \nNavigating the In-Building Maps \n     The user can utilize zooming and clicking and dragging to look throughout the floor map.\n     To go back to the Campus Map, you can press the Campus Map button near the top left.  \n     To quickly switch between buildings, you can utilize the Buildings combo box near the top. Pressing it will drop down a list of the available buildings, from which you can select a different building. \nThe Sidebar\n     To find a Point of Interest, you can utilize the filters and search bar on the sidebar.\n     The search bar can be used to look for a specific Point of Interest name.\n     The Favourites button can filter the sidebar list of Points of Interest to only the ones that you have favourited.\n     The Floor Number combo box allows you to switch between floor maps and filter the sidebar list by a certain floor.\n     The Room Type combo box allows you to filter by a certain room type (e.g. Classroom, Lab, Library, etc.). \nCreating a Point of Interest\n To create a point of interest, right click on a building map floor and input the point information. \nEditing a Point of Interest\n To edit a point of interest, left click on an existing point and input the new information."
);
    }
    
    public static void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new HelpMenu().setVisible(true);
        }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        helpPane = new javax.swing.JEditorPane();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        helpPane.setEditable(false);
        jScrollPane2.setViewportView(helpPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane helpPane;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}