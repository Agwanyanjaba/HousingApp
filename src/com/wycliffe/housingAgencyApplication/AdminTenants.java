package com.wycliffe.housingAgencyApplication;
//Author: Wycliffe.Ochieng

import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AdminTenants extends javax.swing.JFrame {
    public static AdminTenants adminTenants =null; 
    String strAltPhone,	strApartmentID, strEmail, strFirstName,strHouseEntryDate,
            strHouseNum,strKinContact,strLastName,strNationalID,strNextOfKin,strPhoneNumber,
            strRentPayable,strTenantID,strOwnerID;    
    Connection con,conUpdate;
    String SQLTenants = "select * from customers";
    String SQLOwner,SQLDelete;
    ResultSet rsTenants,rsTenants1,rsGetOwner,rsDelete,rsUpdate;
    Statement stTenants,stTenants1,stGetOwner,stDelete,stUpdate;
    PreparedStatement pstmt;
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    int xMouse, yMouse;
     public static AdminTenants getAdminTenants(){
       
        if(adminTenants==null){
           adminTenants = new AdminTenants(); 
        }
         return adminTenants;
    }
    public AdminTenants() {
        initComponents();
        jtxtHouseEntryDate.setText(currentTimestamp.toString());
        try{
          con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
          stTenants = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          stDelete = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          stUpdate = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rsTenants = stTenants.executeQuery(SQLTenants);
          
          
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again","Data Entry",JOptionPane.ERROR_MESSAGE);
            this.dispose();
            Tenants.getTenants().setVisible(true);
        }
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jpnlLoginBar = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpanelBank2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtNextOfKin = new javax.swing.JTextField();
        jtxtApartmentID = new javax.swing.JTextField();
        jtxtKinContact = new javax.swing.JTextField();
        jtxtHouseNum = new javax.swing.JTextField();
        jtxtHouseEntryDate = new javax.swing.JTextField();
        jtxtRentPayable = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOwnerID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jpanelBank = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtTenantID = new javax.swing.JTextField();
        jtxtFirstName = new javax.swing.JTextField();
        jtxtLastName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtNationalID = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtAltPhone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(73, 74, 155));
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

        jpnlLoginBar.setBackground(new java.awt.Color(153, 0, 153));
        jpnlLoginBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("__________Tenants Details Entry _______");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jButtonMin.setText("Minimize");
        jButtonMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlLoginBarLayout = new javax.swing.GroupLayout(jpnlLoginBar);
        jpnlLoginBar.setLayout(jpnlLoginBarLayout);
        jpnlLoginBarLayout.setHorizontalGroup(
            jpnlLoginBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoginBarLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16))
        );
        jpnlLoginBarLayout.setVerticalGroup(
            jpnlLoginBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoginBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnlLoginBarLayout.createSequentialGroup()
                .addGroup(jpnlLoginBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMin)
                    .addComponent(jLabel16))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpnlLoginBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlLoginBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        jpanelBank2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tenants Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank2.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel8.setText("Next of Kin: ");

        jLabel9.setText("Contact of Next of Kin:");

        jLabel10.setText("Apartment ID:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Date of House Entry:");

        jLabel12.setText("House Number:");

        jtxtNextOfKin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNextOfKinfindRecord(evt);
            }
        });

        jtxtApartmentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtApartmentIDfindRecord(evt);
            }
        });

        jtxtKinContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtKinContactfindRecord(evt);
            }
        });

        jtxtHouseEntryDate.setEditable(false);
        jtxtHouseEntryDate.setBackground(new java.awt.Color(255, 255, 255));
        jtxtHouseEntryDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jtxtRentPayable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Rent Payable:");

        jTextFieldOwnerID.setEditable(false);
        jTextFieldOwnerID.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Owner ID:");

        javax.swing.GroupLayout jpanelBank2Layout = new javax.swing.GroupLayout(jpanelBank2);
        jpanelBank2.setLayout(jpanelBank2Layout);
        jpanelBank2Layout.setHorizontalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanelBank2Layout.createSequentialGroup()
                        .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtApartmentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOwnerID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtHouseNum, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtHouseEntryDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtRentPayable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanelBank2Layout.createSequentialGroup()
                        .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelBank2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtxtKinContact, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpanelBank2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jtxtNextOfKin, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jpanelBank2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldOwnerID, jtxtApartmentID, jtxtHouseEntryDate, jtxtHouseNum, jtxtKinContact, jtxtNextOfKin, jtxtRentPayable});

        jpanelBank2Layout.setVerticalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtNextOfKin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtKinContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtApartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(23, 23, 23)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtHouseNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtHouseEntryDate)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtRentPayable, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jpanelBank2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldOwnerID, jtxtApartmentID});

        jpanelBank2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtxtKinContact, jtxtNextOfKin});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tenants Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jbtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setToolTipText("Saves rcord to database");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setToolTipText("Exit the details form");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonUpdate, jbtnSave});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnExit)
                    .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbtnExit, jbtnSave});

        jpanelBank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tenants Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank.setToolTipText("Tenants Details");
        jpanelBank.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel4.setText("Tenant ID:");

        jLabel5.setText("First Name:");

        jLabel3.setText("Last Name: ");

        jtxtTenantID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtTenantID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtTenantIDfindRecord(evt);
            }
        });

        jLabel1.setText("National ID:");

        jLabel2.setText("Email Address:");

        jLabel6.setText("Phone Number:");

        jtxtNationalID.setEditable(false);
        jtxtNationalID.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNationalID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtNationalID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNationalIDFocusLost(evt);
            }
        });

        jLabel7.setText("Alternative Phone:");

        jtxtAltPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtAltPhonefindRecord(evt);
            }
        });

        javax.swing.GroupLayout jpanelBankLayout = new javax.swing.GroupLayout(jpanelBank);
        jpanelBank.setLayout(jpanelBankLayout);
        jpanelBankLayout.setHorizontalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBankLayout.createSequentialGroup()
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelBankLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23))
                    .addGroup(jpanelBankLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jtxtTenantID)
                    .addComponent(jtxtFirstName)
                    .addComponent(jtxtLastName)
                    .addComponent(jtxtNationalID)
                    .addComponent(jtxtPhoneNumber)
                    .addComponent(jtxtAltPhone))
                .addGap(48, 48, 48))
        );

        jpanelBankLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtxtAltPhone, jtxtEmail, jtxtPhoneNumber});

        jpanelBankLayout.setVerticalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtTenantID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtxtNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtAltPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpanelBankLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtxtAltPhone, jtxtPhoneNumber});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelBank2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jpanelBank2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtTenantIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTenantIDfindRecord
        if(jtxtTenantID.getText().isEmpty()){
             
            JOptionPane.showConfirmDialog(rootPane,"Incorect Value Entered. Please exit and try again" , "Add tenant",JOptionPane.INFORMATION_MESSAGE);
            jtxtTenantID.requestFocusInWindow();
            jtxtTenantID.grabFocus();
        }
        else
        {
             jtxtNationalID.setText(jtxtTenantID.getText());
        }
        
    }//GEN-LAST:event_jtxtTenantIDfindRecord

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        //return user to Tenants view form
         this.dispose();
         new Tenants().setVisible(true);
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // This code saves the new tenants details to customers table   
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
            stTenants1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rsTenants1 = stTenants1.executeQuery(SQLTenants);
            
            strFirstName = jtxtFirstName.getText();
            strTenantID = jtxtTenantID.getText();
            strLastName = jtxtLastName.getText();
            strNationalID  = jtxtNationalID.getText();
            strPhoneNumber = jtxtPhoneNumber.getText();
            strEmail = jtxtEmail.getText();
            strAltPhone = jtxtAltPhone.getText();
            strApartmentID = jtxtApartmentID.getText();
            strHouseEntryDate = jtxtHouseEntryDate.getText();
            strHouseNum = jtxtHouseNum.getText();
            strKinContact = jtxtKinContact.getText();
            strNextOfKin = jtxtNextOfKin.getText();
            strPhoneNumber = jtxtPhoneNumber.getText();
            strRentPayable = jtxtRentPayable.getText();
            strOwnerID = jTextFieldOwnerID.getText();
      
            
            rsTenants1.moveToInsertRow();
            System.out.println("Moving to insert record\n");
            stTenants1.executeUpdate("insert into customers values('" +  strTenantID  + "','" + strFirstName + "','"+ strLastName +"','"+strEmail+"',"
                    + "'"+strPhoneNumber+"','"+strAltPhone+"','"
                    + ""+strNextOfKin+"','"+strKinContact+"','"+strApartmentID+"','"+strHouseNum+"','"+strRentPayable+"','"+strHouseEntryDate+"','NULL','"+strOwnerID+"')");
            System.out.println("strOwnerID\n");
            JOptionPane.showMessageDialog(null, "Record has been saved successfully!\n"+"Proceed to add another Tenant","Tenant's  Details",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
             Tenants.getTenants().setVisible(true);
            
        }
        catch(SQLException e)
        {
            
                System.out.println("Error"+e);
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Duplicate entry made! Please exit and try again");
                Payments error = new Payments();
                jtxtTenantID.requestFocusInWindow();
                jtxtTenantID.grabFocus();
        }
          
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jtxtNationalIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNationalIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNationalIDFocusLost

    private void jtxtNextOfKinfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNextOfKinfindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNextOfKinfindRecord

    private void jtxtAltPhonefindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtAltPhonefindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAltPhonefindRecord

    private void jtxtApartmentIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtApartmentIDfindRecord
        try{
            stGetOwner = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            final String apartmentID = jtxtApartmentID.getText();
            rsGetOwner = stGetOwner.executeQuery("select owner_id from apartments where apartment_id = '"+apartmentID+"'");
            
            while(rsGetOwner.next()){
               String ownerID =  rsGetOwner.getString("owner_id");
               //String ownerName = rsGetOwner.getString("owner_name");
               
               jTextFieldOwnerID.setText(ownerID);
               //jTextFieldOwnerID.setText(ownerName);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again.","Data Entry",JOptionPane.ERROR_MESSAGE);
            this.dispose();
            Tenants.getTenants().setVisible(true);
        }
    }//GEN-LAST:event_jtxtApartmentIDfindRecord

    private void jtxtKinContactfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtKinContactfindRecord
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtKinContactfindRecord

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        
            try {
                
                String email, phone, altPhone, nextOfKin, contactKin, rentPayable,houseNum,customerID;
          
                email = jtxtEmail.getText();
                altPhone = jtxtAltPhone.getText();
                phone = jtxtPhoneNumber.getText();
                houseNum = jtxtHouseNum.getText();
                contactKin = jtxtKinContact.getText();
                nextOfKin = jtxtNextOfKin.getText();
                rentPayable = jtxtRentPayable.getText();
                customerID = jtxtTenantID.getText();

                String UpdateCustomer="update customers set email='"+email+"', phone1='"+phone+"',phone2='"+altPhone+"',next_of_kin_phone='"+contactKin+"',house_no='"+houseNum+"',rate='"+rentPayable+"',next_of_kin='"+nextOfKin+"' where customer_id = "+customerID+" ";
                                         
                pstmt = con.prepareStatement(UpdateCustomer);
                pstmt.executeUpdate();
                int i=pstmt.executeUpdate();
                
                if(i>0)
                {
                   JOptionPane.showMessageDialog(rootPane, "Record has been updated successfully!\n"+"Proceed to update another Tenant's details","Tenant's  Details",JOptionPane.INFORMATION_MESSAGE);  
                   new Tenants().setVisible(true);
                   this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again.","Data Entry",JOptionPane.ERROR_MESSAGE);
                    new Tenants().setVisible(true);
                }
                pstmt.close();

            } catch ( SQLException ex) {
                Logger.getLogger(AdminTenants.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // Delete customer from table
        try {
                
                String customerID;
          
                customerID = jtxtTenantID.getText();

                String DeleteCustomer="delete from customers where customer_id = '"+customerID+"'";
                  //delete from customers where customer_id='78 ';                       
                pstmt = con.prepareStatement(DeleteCustomer);
                int i= pstmt.executeUpdate();
                 if(i>0)
                {
                   JOptionPane.showMessageDialog(rootPane, "Record has been Deleted successfully!\n"+"Proceed to delete another Tenant's details","Tenant's  Details",JOptionPane.INFORMATION_MESSAGE);  
                   Tenants.getTenants().setVisible(true);
                   this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again.","Data Entry",JOptionPane.ERROR_MESSAGE);
                }
                pstmt.close();

            } catch ( SQLException ex) {
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
        // 
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed
//main method declaration
    
    public static void main(String args[]) {
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTenants().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    public javax.swing.JTextField jTextFieldOwnerID;
    private javax.swing.JButton jbtnExit;
    public javax.swing.JButton jbtnSave;
    private javax.swing.JPanel jpanelBank;
    private javax.swing.JPanel jpanelBank2;
    private javax.swing.JPanel jpnlLoginBar;
    public javax.swing.JTextField jtxtAltPhone;
    public javax.swing.JTextField jtxtApartmentID;
    public javax.swing.JTextField jtxtEmail;
    public javax.swing.JTextField jtxtFirstName;
    public javax.swing.JTextField jtxtHouseEntryDate;
    public javax.swing.JTextField jtxtHouseNum;
    public javax.swing.JTextField jtxtKinContact;
    public javax.swing.JTextField jtxtLastName;
    public javax.swing.JTextField jtxtNationalID;
    public javax.swing.JTextField jtxtNextOfKin;
    public javax.swing.JTextField jtxtPhoneNumber;
    public javax.swing.JTextField jtxtRentPayable;
    public javax.swing.JTextField jtxtTenantID;
    // End of variables declaration//GEN-END:variables
}

