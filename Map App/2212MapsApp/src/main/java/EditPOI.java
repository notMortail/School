
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author Trevor Seaman
 */
public class EditPOI extends javax.swing.JDialog {

    private final String[] ROOM_TYPES = {"Classroom", "Computer Lab", "Collaborative Room", "Mens Washroom", "Restaurant", "Unisex Washroom", "Womens Washroom", "Elevator", "Stairs", "Door"};
    
    Icon icon;
    String newName = "";
    String newImagePath;
    
    /**
     * Creates new form EditPOI
     * 
     * @param i The icon this frame is being initialized in reference to
     */
    public EditPOI(java.awt.Frame parent, boolean modal, Icon i) {
        super(parent, modal);
        this.setTitle("Edit " + i.point.getName());
        this.setLocation(700, 300);
        icon = i;
        initComponents();
        this.nameField.setText(i.point.getName());
        newName = i.point.getName();
        newImagePath = i.point.getIconImg();
        this.iconComboBox.setSelectedIndex(0);
        Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW);
        icon.imgLabel.setBorder(yellowBorder);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        iconComboBox = new javax.swing.JComboBox<>();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        nameLabel.setText("New Name");

        typeLabel.setText("Select Type");

        nameField.setText("jTextField1");
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        iconComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ROOM_TYPES));
        iconComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconComboBoxActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(iconComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Cancels the popup when the user hits the cancel button
     * 
     * @param evt User hits cancel button
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        icon.imgLabel.setBorder(null);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** User sets name field
     * 
     * @param evt user modifies the text field
     */
    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
        if (nameField.getText().equals("") && !AccountManager.getUser().equals("admin")) {
            JOptionPane.showMessageDialog(this, "Please enter a new name");
        }
        else {
            newName = nameField.getText();
        }
    }//GEN-LAST:event_nameFieldActionPerformed

    /** User selects from the icon combo box
     * 
     * @param evt User selects an option from the combo box
     */
    private void iconComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconComboBoxActionPerformed

        newImagePath = (String) iconComboBox.getSelectedItem();
    }//GEN-LAST:event_iconComboBoxActionPerformed

    /** User saves actions
     * 
     * @param evt User hits saves button
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (nameField.getText().equals("") && !AccountManager.getUser().equals("admin")) {
            JOptionPane.showMessageDialog(this, "Please enter a new name");
        }
        else {
            icon.updateImage(newImagePath);
            icon.updateTitle(newName);
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed
    
    /** Action to delete the current point
     * 
     * @param evt User hits delete button
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
 
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you wish to delete this point?");
        if (confirm == JOptionPane.YES_OPTION) {
            AccountManager.remove(icon.point);
            MapFrameUI.mainFrame.mapPanel.remove(icon.imgLabel);
            MapFrameUI.mainFrame.redrawMap();
            this.dispose();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /** Reset border on window state change
     * 
     * @param evt Window state changed
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
 
        icon.imgLabel.setBorder(null);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> iconComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
