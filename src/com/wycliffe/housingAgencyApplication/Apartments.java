package com.wycliffe.housingAgencyApplication;

// @author Wycliffe.Ochieng

import com.itextpdf.text.DocumentException;
import static java.awt.Frame.ICONIFIED;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

 
public class Apartments extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    Statement st;
    String SQLOwners = "select * from apartments";
    String strApartment, strApartName, strAgent, strLocation,strRooms, strStatus,strOwner;
    DefaultTableModel apartmentsTableModel;
    int selectedRowIndex;
    int xMouse, yMouse;
    AdminApartments adminAptData = new AdminApartments();
    
    public void viewOwners(){
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQLOwners);
            
            try{
            apartmentsTableModel = (DefaultTableModel)jTableApartments.getModel();
             while(rs.next()){
                            strApartment = rs.getString("apartment_id");
                            strApartName=rs.getString("apartment_name");
                            strAgent=rs.getString("agent_id");
                            strLocation=rs.getString("location_id");
                            strRooms=rs.getString("rooms");
                            strStatus=rs.getString("status");
                            strOwner=rs.getString("owner_id");
                            
                      apartmentsTableModel.addRow(new Object[]{strApartment, strApartName, strAgent, strLocation,strRooms, strStatus,strOwner});

                    }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    public static Apartments apartment =null; 
    public static Apartments getApartment(){
       
        if(apartment==null){
           apartment = new Apartments(); 
        }
         return apartment;
    }
    
    public Apartments() {
        initComponents();
        this.viewOwners();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonAddApartment = new javax.swing.JButton();
        sidepane2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jButtonOwners1 = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        jButtonPayments = new javax.swing.JButton();
        jButtonTenants = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableApartments = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 671));
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

        jButtonAddApartment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAddApartment.setText("Add Apartment");
        jButtonAddApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddApartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButtonAddApartment)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButtonAddApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        sidepane2.setBackground(new java.awt.Color(54, 33, 89));
        sidepane2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jSeparator4.setMinimumSize(new java.awt.Dimension(50, 5));

        jButtonOwners1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonOwners1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/open.png"))); // NOI18N
        jButtonOwners1.setText("View Owners");
        jButtonOwners1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOwners1ActionPerformed(evt);
            }
        });

        jButtonHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Help.png"))); // NOI18N
        jButtonHelp.setText("Get Help           ");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        jButtonHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Brick_house.png"))); // NOI18N
        jButtonHome.setText("Return Home");
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jButtonReport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/File PDF-01.png"))); // NOI18N
        jButtonReport.setText("Apartments Reports");
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
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

        jButtonTenants.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonTenants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/User_group.png"))); // NOI18N
        jButtonTenants.setText("All Tenants");
        jButtonTenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTenantsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidepane2Layout = new javax.swing.GroupLayout(sidepane2);
        sidepane2.setLayout(sidepane2Layout);
        sidepane2Layout.setHorizontalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane2Layout.createSequentialGroup()
                .addGroup(sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepane2Layout.createSequentialGroup()
                        .addGroup(sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonOwners1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sidepane2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonTenants, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPayments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        sidepane2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonHelp, jButtonHome, jButtonOwners1, jButtonPayments, jButtonReport, jButtonTenants});

        sidepane2Layout.setVerticalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepane2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOwners1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTenants, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonHelp, jButtonHome, jButtonOwners1, jButtonPayments, jButtonReport, jButtonTenants});

        jTableApartments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apartment ID", "Apartment Name", "Agent ID", "Location/Area", "Rooms Number", "Status", "Name of Owner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableApartments.setGridColor(new java.awt.Color(102, 102, 102));
        jTableApartments.setRowHeight(24);
        jTableApartments.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableApartments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableApartmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableApartments);

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("__________Apartments Details _______");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
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
                .addGap(62, 62, 62)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMin)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(sidepane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sidepane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.getAccessibleContext().setAccessibleName("Data  Entry");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOwners1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOwners1ActionPerformed
        // call owners form
        Owners.getOwners().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonOwners1ActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // call Home form
         Home.getHome().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed

        ApartmentsReport Obj =  new ApartmentsReport();
        try {
            Obj.apartmentsReports();
        } catch (DocumentException ex) {
            Logger.getLogger(Apartments.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Apartments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonReportActionPerformed

    private void jButtonAddApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddApartmentActionPerformed
        // TODO add your handling code here:
        new AdminApartments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAddApartmentActionPerformed

    private void jButtonPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentsActionPerformed

        new Payments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPaymentsActionPerformed

    private void jButtonTenantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTenantsActionPerformed
        // call all Tenants Form
        new Tenants().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonTenantsActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
                new HousingAgencyHelp().setVisible(true);

    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Home.getHome().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTableApartmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableApartmentsMouseClicked
        // TODO add your handling code here:
        selectedRowIndex = jTableApartments.getSelectedRow();
        
        
        adminAptData.jtxtApartmentID.setText(apartmentsTableModel.getValueAt(selectedRowIndex,0).toString());
        adminAptData.jtxtAptName.setText(apartmentsTableModel.getValueAt(selectedRowIndex,1).toString());
        adminAptData.jtxAgentID.setText(apartmentsTableModel.getValueAt(selectedRowIndex,2).toString());
        adminAptData.jtxtAptLocationID.setText(apartmentsTableModel.getValueAt(selectedRowIndex,3).toString());
        adminAptData.jtxtRooms.setText(apartmentsTableModel.getValueAt(selectedRowIndex,4).toString());
        adminAptData.jtxtRoomStatus.setText(apartmentsTableModel.getValueAt(selectedRowIndex,5).toString());
        adminAptData.jtxtOwnerID.setText(apartmentsTableModel.getValueAt(selectedRowIndex,6).toString());
        
        this.dispose();
        adminAptData.setVisible(true);
        adminAptData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminAptData.pack();
        
    }//GEN-LAST:event_jTableApartmentsMouseClicked

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
        // 
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apartments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddApartment;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonOwners1;
    private javax.swing.JButton jButtonPayments;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonTenants;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableApartments;
    private javax.swing.JPanel sidepane2;
    // End of variables declaration//GEN-END:variables
}
