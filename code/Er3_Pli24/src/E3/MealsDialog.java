/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package E3;

import static java.awt.Frame.NORMAL;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class MealsDialog extends javax.swing.JDialog {
    
     DefaultTableModel tableModel;
     ArrayList<Meal> listOfMeals;
     
    public MealsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tableModel=(DefaultTableModel)jTable1.getModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        jButton1.setText("Αναζήτηση");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 204, 204));
        exitButton.setText("Έξοδος");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Όνομα", "Κατηγορία", "Περιοχή", "Οδηγίες"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        editButton.setText("Επεξεργασία δεδομένων γεύματος");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Διαγραφή δεδομένων γεύματος");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String onoma = this.nameField.getText();
        if(onoma.length()==0){
            JOptionPane.showMessageDialog(this, "Πρέπει να εισάγετε όνομα.");
            return;
        }
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s="+onoma;
        String data = JSonAnalyzer.getJSonData(url);
        listOfMeals = JSonAnalyzer.getInformationAboutMeals(data, null);
        
        if(listOfMeals.size()==0){
            JOptionPane.showMessageDialog(this, "Δεν βρέθηκαν κάποια δεδομένα");
            deleteAllData(tableModel);
        } else {
            for(Meal theMeal:listOfMeals){
                Meal meal = DBController.mealExists(theMeal);
                if(meal == null){
                    theMeal.setViews(0);
                    DBController.saveObject(theMeal);
                } else {
                    int counter = meal.getViews()+1;
                    meal.setViews(counter);
                    listOfMeals.set(listOfMeals.indexOf(theMeal), meal);
                    DBController.modifyObject(meal);
                }
            }
            putDataToTable(tableModel, listOfMeals);
            this.nameField.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = this.jTable1.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Πρέπει να επιλέξετε γραμμή ");
        } else {
            Meal theMeal = listOfMeals.get(row);
            JFrame mf = (JFrame) SwingUtilities.getWindowAncestor(this);
            EditMealDialog dialog = new EditMealDialog(mf, true, theMeal, row,  this);
            dialog.setLocation(250,250);
            dialog.setTitle("Επεξεργασία Δεδομένων");
            dialog.pack();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.jTable1.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Πρέπει να επιλέξετε γραμμή");
        } else {
            Meal theMeal = listOfMeals.get(row);
            DBController.deleteObject(theMeal);
            listOfMeals.remove(row);
            tableModel.removeRow(row);
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    private void putDataToTable(DefaultTableModel tableModel, ArrayList<Meal> list){ 
        tableModel.setRowCount(0);
        for(Meal m:list){
            Vector grammi = new Vector();
            grammi.add(m.getStrmeal());       
            grammi.add(MainClass.getCategoryName(m.getCategory()));
            grammi.add(m.getStrarea());
            grammi.add(m.getStrinstuctions());
            tableModel.addRow(grammi);
        }
    }

    private void deleteAllData(DefaultTableModel model){ 
        int rowCount = model.getRowCount();
        for (int i = rowCount-1; i >= 0; i--) 
                model.removeRow(i);
    }
    
    
    public void editMeals(int grammi, Meal m){
        this.listOfMeals.set(grammi, m);
        jTable1.setValueAt(MainClass.getCategoryName(m.getCategory()), grammi, 1);
        jTable1.setValueAt(m.getStrarea(), grammi, 2);
        jTable1.setValueAt(m.getStrinstuctions(), grammi, 3);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables
}
