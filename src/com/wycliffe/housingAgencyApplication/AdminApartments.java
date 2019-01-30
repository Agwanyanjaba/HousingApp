package com.wycliffe.housingAgencyApplication;

import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//Author Wycliffe           
public class AdminApartments extends javax.swing.JFrame {
 String apartment_id , apartment_name ,agent_id , location_id , rooms , status  , owner_id;
 Connection con;
 ResultSet rs;
 Statement st;
 int xMouse, yMouse;
 String SQLQuery  = "SELECT * FROM Apartments";
 
PreparedStatement pstmt;
    public void getConnection(){
        
    }
    public AdminApartments() {
        initComponents();
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
        st  = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = st.executeQuery(SQLQuery);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again","Data Entry",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Apartments.getApartment().setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpanelBank2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtRoomStatus = new javax.swing.JTextField();
        jtxtAptLocationID = new javax.swing.JTextField();
        jtxtOwnerID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jpanelBank = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtApartmentID = new javax.swing.JTextField();
        jtxtAptName = new javax.swing.JTextField();
        jtxAgentID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtRooms = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Owner's Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        jpanelBank2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional  Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank2.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel7.setText("Status:");

        jLabel9.setText("Owner ID:");

        jtxtRoomStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtRoomStatusfindRecord(evt);
            }
        });

        jtxtAptLocationID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtAptLocationIDfindRecord(evt);
            }
        });
        jtxtAptLocationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAptLocationIDActionPerformed(evt);
            }
        });

        jtxtOwnerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtOwnerIDfindRecord(evt);
            }
        });

        jLabel3.setText("Location_Name:");

        javax.swing.GroupLayout jpanelBank2Layout = new javax.swing.GroupLayout(jpanelBank2);
        jpanelBank2.setLayout(jpanelBank2Layout);
        jpanelBank2Layout.setHorizontalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtxtRoomStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jtxtAptLocationID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtOwnerID))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jpanelBank2Layout.setVerticalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtAptLocationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtRoomStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data modofications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jbtnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setToolTipText("Saves rcord to database");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setToolTipText("Exit details form");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jbtnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.setToolTipText("Updates a record");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete)
                .addGap(31, 31, 31)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelete, jbtnExit, jbtnSave, jbtnUpdate});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExit)
                    .addComponent(jButtonDelete))
                .addGap(26, 26, 26))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonDelete, jbtnExit, jbtnSave, jbtnUpdate});

        jpanelBank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank.setToolTipText("Owners Details");
        jpanelBank.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel4.setText("Apartment ID:");

        jLabel5.setText("Apartment Name:");

        jtxtApartmentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtApartmentIDfindRecord(evt);
            }
        });

        jtxAgentID.setEditable(false);
        jtxAgentID.setBackground(new java.awt.Color(255, 255, 255));
        jtxAgentID.setText("47");

        jLabel1.setText("Number of Rooms:");

        jtxtRooms.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtRoomsFocusLost(evt);
            }
        });

        jLabel8.setText("Agent ID:");

        javax.swing.GroupLayout jpanelBankLayout = new javax.swing.GroupLayout(jpanelBank);
        jpanelBank.setLayout(jpanelBankLayout);
        jpanelBankLayout.setHorizontalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBankLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtxAgentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jtxtAptName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtApartmentID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtRooms, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(67, 67, 67))
        );
        jpanelBankLayout.setVerticalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtApartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtAptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxAgentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtxtRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jpanelBank, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpanelBank2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelBank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanelBank2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("__________Apartments Details Entry_______");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButtonMin.setText("Minimize");
        jButtonMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMin)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtRoomStatusfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtRoomStatusfindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtRoomStatusfindRecord

    private void jtxtAptLocationIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtAptLocationIDfindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAptLocationIDfindRecord

    private void jtxtOwnerIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtOwnerIDfindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtOwnerIDfindRecord

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // This code saves the new details to  owners table
        try
        {
            //apartment_id | apartment_name | agent_id | location_id | rooms | status   | owner_id
            apartment_id = jtxtApartmentID.getText();
            apartment_name = jtxtAptName.getText();
            agent_id = jtxAgentID.getText();
            location_id = jtxtRooms.getText();
            rooms = jtxtAptLocationID.getText();
            status = jtxtRoomStatus.getText();
            owner_id = jtxtOwnerID.getText();

            System.out.println("Moving to insert record");
            rs.moveToInsertRow();
                    
            st.executeUpdate("insert into apartments values('" +  apartment_id  + "','" + apartment_name + "','"+ 
                    agent_id +"','"+ rooms +"','"+location_id+"','"+status+"','"+owner_id+"')");
            
            JOptionPane.showMessageDialog(rootPane, "Record has been saved successfully!","Apartments  Details\n",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Apartments.getApartment().setVisible(true);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "Dublicate entry made! Exit and try again","Apartments Deatails",JOptionPane.ERROR_MESSAGE);
            Apartments.getApartment().setVisible(true);
            this.dispose();
                     
        }
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        this.dispose();
         Apartments.getApartment().setVisible(true);
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        // this code updates the  payemnts relation
        try
        { 
            apartment_id = jtxtApartmentID.getText();
            apartment_name = jtxtAptName.getText();
            agent_id = jtxAgentID.getText();
            location_id = jtxtAptLocationID.getText(); 
            rooms = jtxtRooms.getText();
            status = jtxtRoomStatus.getText();
            owner_id = jtxtOwnerID.getText();
            

            String updateApt = "update apartments set rooms = '"+rooms+"',status='"+status+"',location_id='"+location_id+"', apartment_name ='"+apartment_name+"' where apartment_id='"+apartment_id+"'";

            pstmt = con.prepareStatement(updateApt);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(rootPane,"The Record has been Updated","Record Update",JOptionPane.INFORMATION_MESSAGE);
            pstmt.close();
            this.dispose();
            new Apartments().setVisible(true);
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(rootPane, "Duplicate Entry Made!\n Or something went wrong.Please try again the Entry","Record Update",JOptionPane.ERROR_MESSAGE);
            err.printStackTrace();
            this.dispose();
            Apartments.getApartment().setVisible(true);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jtxtApartmentIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtApartmentIDfindRecord

    }//GEN-LAST:event_jtxtApartmentIDfindRecord

    private void jtxtRoomsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtRoomsFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtRoomsFocusLost

    private void jtxtAptLocationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAptLocationIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAptLocationIDActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Tenants().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // Deletes apartment
        try {
                
                String aptID;
          
                aptID = jtxtApartmentID.getText();

                String DeleteApt="delete from apartments where  apartment_id = '"+aptID+"'";
                  //delete from customers where customer_id='78 ';                       
                pstmt = con.prepareStatement(DeleteApt);
                pstmt.executeUpdate();
                int i=pstmt.executeUpdate();
                
                
                JOptionPane.showMessageDialog(rootPane, "Record has been Deleted successfully!\n"+"Proceed to delete another Record","Record Deletion",JOptionPane.INFORMATION_MESSAGE);  
                Apartments.getApartment().setVisible(true);
                this.dispose();
              
                pstmt.close();

            } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again.","Record Deletion",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AdminTenants.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

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

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminApartments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JButton jbtnExit;
    public javax.swing.JButton jbtnSave;
    public javax.swing.JButton jbtnUpdate;
    private javax.swing.JPanel jpanelBank;
    private javax.swing.JPanel jpanelBank2;
    public javax.swing.JTextField jtxAgentID;
    public javax.swing.JTextField jtxtApartmentID;
    public javax.swing.JTextField jtxtAptLocationID;
    public javax.swing.JTextField jtxtAptName;
    public javax.swing.JTextField jtxtOwnerID;
    public javax.swing.JTextField jtxtRoomStatus;
    public javax.swing.JTextField jtxtRooms;
    // End of variables declaration//GEN-END:variables
}
