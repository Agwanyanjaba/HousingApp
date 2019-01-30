package com.wycliffe.housingAgencyApplication;

// @author Wycliffe.Ochieng

import com.itextpdf.text.DocumentException;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
public final class Owners extends javax.swing.JFrame {

    Connection con;
    ResultSet rs, rsComputeCom;
    Statement st,stComputeCom;
    String SQLOwners = "select * from owners";
    String ownerID, ownerName, phone1, phone2, Commission, BankName,percent,totalComm,totalColn,compute;
    DefaultTableModel ownersTableModel;
    int selectedRowIndex;
    AdminOwners ownersData = new AdminOwners();
    
    int yMouse;
    int xMouse;
    public static Owners owners =null; 
    public static Owners getOwners(){
       
        if(owners==null){
           owners = new Owners(); 
        }
         return owners;
    }
    
    public void viewOwners(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stComputeCom = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQLOwners);
            
            try{
            ownersTableModel = (DefaultTableModel)jTableOwners.getModel();
             while(rs.next()){
                 
                            ownerID = rs.getString("owner_id");
                            ownerName=rs.getString("owner_name");
                            phone1=rs.getString("phone1");
                            phone2=rs.getString("phone2");
                            Commission=rs.getString("percentage_commission");
                            BankName=rs.getString("Bank_Name");
                            totalComm =  rs.getString("total_collection");
                            totalColn = rs.getString("total_commission"); 
                            
                            ownersTableModel.addRow(new Object[]{ownerID, ownerName, phone1, phone2, Commission, 
                            BankName,totalComm,totalColn});

                    }
             
                }catch(SQLException e){
                
            }
        }
        catch(SQLException e){
            
        }
       
    }
    
    public Owners() {
        initComponents();
        this.viewOwners();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonNew = new javax.swing.JButton();
        jTextFieldTotalComm = new javax.swing.JTextField();
        sidepane2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jButtonHelp1 = new javax.swing.JButton();
        jButtonHome1 = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        jButtonTenants = new javax.swing.JButton();
        jButtonApartments = new javax.swing.JButton();
        jButtonPayments = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOwners = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("ownerFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1308, 610));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(73, 74, 155));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data "));

        jButtonNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonNew.setText("Add Owner");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jTextFieldTotalComm.setEditable(false);
        jTextFieldTotalComm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldTotalComm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldTotalComm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalComm))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonNew, jTextFieldTotalComm});

        sidepane2.setBackground(new java.awt.Color(54, 33, 89));
        sidepane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator4.setMinimumSize(new java.awt.Dimension(50, 5));

        jButtonHelp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonHelp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Help.png"))); // NOI18N
        jButtonHelp1.setText("Get Help        ");
        jButtonHelp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelp1ActionPerformed(evt);
            }
        });

        jButtonHome1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Brick_house.png"))); // NOI18N
        jButtonHome1.setText("Return Home");
        jButtonHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHome1ActionPerformed(evt);
            }
        });

        jButtonReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/File PDF-01.png"))); // NOI18N
        jButtonReport.setText("Commisions Report");
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
            }
        });

        jButtonTenants.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonTenants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/User_group.png"))); // NOI18N
        jButtonTenants.setText("All Tenants");
        jButtonTenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTenantsActionPerformed(evt);
            }
        });

        jButtonApartments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonApartments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Home.png"))); // NOI18N
        jButtonApartments.setText("Apartments ");
        jButtonApartments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApartmentsActionPerformed(evt);
            }
        });

        jButtonPayments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/New Doc.png"))); // NOI18N
        jButtonPayments.setText("Payments    ");
        jButtonPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidepane2Layout = new javax.swing.GroupLayout(sidepane2);
        sidepane2.setLayout(sidepane2Layout);
        sidepane2Layout.setHorizontalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane2Layout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sidepane2Layout.createSequentialGroup()
                .addGroup(sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonTenants, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPayments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonHome1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jButtonApartments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonHelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReport, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidepane2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonApartments, jButtonHelp1, jButtonHome1, jButtonPayments, jButtonReport, jButtonTenants});

        sidepane2Layout.setVerticalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonTenants, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonApartments, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonApartments, jButtonHelp1, jButtonHome1, jButtonPayments, jButtonReport, jButtonTenants});

        jTableOwners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Owner ID", "Owner Full Name", "Phone1", "Phone 2", "% Commission Offered", "Bank Name", "Collection", "Commission"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOwners.setGridColor(new java.awt.Color(102, 102, 102));
        jTableOwners.setRowHeight(24);
        jTableOwners.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableOwners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOwnersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOwners);
        if (jTableOwners.getColumnModel().getColumnCount() > 0) {
            jTableOwners.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableOwners.getColumnModel().getColumn(1).setPreferredWidth(210);
            jTableOwners.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("__________Owners Details ________");

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 51, 102));
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jButtonMin.setText("Minimize");
        jButtonMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMin)
                    .addComponent(jLabelClose))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sidepane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHome1ActionPerformed
        // call Home form
        Home.getHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonHome1ActionPerformed

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Please select a record on right hand table!\n"+"You will be promted to key in dates for Statement","Statement Report",JOptionPane.INFORMATION_MESSAGE);
       
    }//GEN-LAST:event_jButtonReportActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // opens add owners details
        AdminOwners.getAdminOwners().setVisible(true);
        ownersData.jButtonDelete.setEnabled(false);
        ownersData.jbtnUpdate.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonTenantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTenantsActionPerformed
        // call all Tenants Form
        Tenants.getTenants().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonTenantsActionPerformed

    private void jButtonApartmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApartmentsActionPerformed
        // TODO add your handling code here:
        Apartments.getApartment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonApartmentsActionPerformed

    private void jButtonPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentsActionPerformed

        Payments.getPayements().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPaymentsActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Home.getHome().setVisible(true);
        
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jButtonHelp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelp1ActionPerformed
                new HousingAgencyHelp().setVisible(true);

    }//GEN-LAST:event_jButtonHelp1ActionPerformed

    private void jTableOwnersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOwnersMouseClicked
        // TODO add your handling code here:
        selectedRowIndex = jTableOwners.getSelectedRow();
        
        ownersData.jtxPhoneNumber.setText(ownersTableModel.getValueAt(selectedRowIndex,2).toString());
        ownersData.jTextFieldCommsion.setText(ownersTableModel.getValueAt(selectedRowIndex,4).toString());
        ownersData.jtxtAltContact.setText(ownersTableModel.getValueAt(selectedRowIndex,3).toString());
        ownersData.jtxtBankName.setText(ownersTableModel.getValueAt(selectedRowIndex,5).toString());
        ownersData.jtxtFullName.setText(ownersTableModel.getValueAt(selectedRowIndex,1).toString());
        ownersData.jtxtID.setText(ownersTableModel.getValueAt(selectedRowIndex,0).toString());
        
        ownersData.jbtnSave.setEnabled(false);
        
        this.dispose();
        ownersData.setAlwaysOnTop(true);
        ownersData.setVisible(true);
        ownersData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ownersData.pack();
    }//GEN-LAST:event_jTableOwnersMouseClicked

    private void jButtonMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinActionPerformed
        // TODO add your handling code here:
         setState(ICONIFIED);
    }//GEN-LAST:event_jButtonMinActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Owners().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApartments;
    private javax.swing.JButton jButtonHelp1;
    private javax.swing.JButton jButtonHome1;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonPayments;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonTenants;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableOwners;
    private javax.swing.JTextField jTextFieldTotalComm;
    private javax.swing.JPanel sidepane2;
    // End of variables declaration//GEN-END:variables
}
