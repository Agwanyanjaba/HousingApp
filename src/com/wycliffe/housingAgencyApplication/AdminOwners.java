package com.wycliffe.housingAgencyApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
//Author Wycliffe           
public class AdminOwners extends javax.swing.JFrame {
 String strPhoneNumber, strAccNum,strAltContact,strAptID,strBankName,strFullName,strID,strCommsions, bankName;
 Connection con;
 ResultSet rs,rsStatement,rsGetOwners,rsGetPay;
 
 double commisison,commRate,arrears, expenses, netPay,totalRent,deductions;
 int xMouse, yMouse;
 Statement st,stStatement,stGetOwners,stGetPay;
 String SQLQuery  = "SELECT * FROM owners";
 PreparedStatement pstmt;
 String SQLPaymentRpt,startDate,endDate,currency="Kes.",FileBaseName="Statement";
 String filename = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());
 
    public static AdminOwners adminOwners;
    
    public static AdminOwners getAdminOwners(){
        if(adminOwners==null){
            adminOwners = new AdminOwners();
        }
        return adminOwners;
    }
    public static String formatMonth(int month) {
    DateFormatSymbols symbols = new DateFormatSymbols();
    String[] monthNames = symbols.getMonths();
    return monthNames[month];
    }
    public AdminOwners() {
        initComponents();
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
        st  = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stGetOwners = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stGetPay = con.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE);
        rs = st.executeQuery(SQLQuery);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Duplicate Entry Made!\n Or something went wrong.Please try again the Entry","Data Entry",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Owners.getOwners().setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDate = new javax.swing.JDialog();
        dialogPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonReportRequest = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldStartDate = new javax.swing.JTextField();
        jTextFieldEndDate = new javax.swing.JTextField();
        jTextFieldPassOwnerID = new javax.swing.JTextField();
        jDialogStatement = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButtonSubimit = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTextFieldPassName = new javax.swing.JTextField();
        jTextFieldPassAcc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldEndDate1 = new javax.swing.JTextField();
        jTextFieldStartDate1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jtxtExpenses = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpanelBank2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtxtBankName = new javax.swing.JTextField();
        jtxtAltContact = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCommsion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonStament = new javax.swing.JButton();
        jpanelBank = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jtxtFullName = new javax.swing.JTextField();
        jtxPhoneNumber = new javax.swing.JTextField();
        jLabelNewAccount = new javax.swing.JLabel();
        jTextFieldNewAccount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();

        jDialogDate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogDate.setMinimumSize(new java.awt.Dimension(376, 277));
        jDialogDate.setModal(true);
        jDialogDate.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jDialogDate.setUndecorated(true);
        jDialogDate.setSize(new java.awt.Dimension(300, 300));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Please Enter Dates for the Statement");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("From Date:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("To Date:");

        jButtonReportRequest.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReportRequest.setText("Submit");
        jButtonReportRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportRequestActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 0, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jTextFieldPassOwnerID.setEditable(false);
        jTextFieldPassOwnerID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldPassOwnerID.setBorder(null);

        javax.swing.GroupLayout dialogPanelLayout = new javax.swing.GroupLayout(dialogPanel);
        dialogPanel.setLayout(dialogPanelLayout);
        dialogPanelLayout.setHorizontalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8))
                    .addGroup(dialogPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButtonReportRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialogPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(jTextFieldPassOwnerID)
        );
        dialogPanelLayout.setVerticalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonReportRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPassOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jDialogDateLayout = new javax.swing.GroupLayout(jDialogDate.getContentPane());
        jDialogDate.getContentPane().setLayout(jDialogDateLayout);
        jDialogDateLayout.setHorizontalGroup(
            jDialogDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogDateLayout.setVerticalGroup(
            jDialogDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialogStatement.setAlwaysOnTop(true);
        jDialogStatement.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jDialogStatement.setUndecorated(true);
        jDialogStatement.setResizable(false);
        jDialogStatement.setSize(new java.awt.Dimension(450, 400));

        jButtonSubimit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonSubimit.setText("Submit");
        jButtonSubimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubimitActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(153, 0, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Dates", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        jTextFieldPassName.setEditable(false);
        jTextFieldPassName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPassName.setForeground(new java.awt.Color(204, 0, 51));
        jTextFieldPassName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldPassAcc.setEditable(false);
        jTextFieldPassAcc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPassAcc.setForeground(new java.awt.Color(204, 0, 51));
        jTextFieldPassAcc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("From Date:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("To Date:");

        jTextFieldEndDate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldStartDate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Please Enter Dates for the Statement");

        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStartDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPassAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPassName, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelExit))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelExit)
                    .addComponent(jTextFieldPassAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPassName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStartDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expenses ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Total Expenses:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtxtExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jButtonSubimit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSubimit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialogStatementLayout = new javax.swing.GroupLayout(jDialogStatement.getContentPane());
        jDialogStatement.getContentPane().setLayout(jDialogStatementLayout);
        jDialogStatementLayout.setHorizontalGroup(
            jDialogStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogStatementLayout.setVerticalGroup(
            jDialogStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        jLabel9.setText("Bank Name:");

        jtxtAltContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtAltContactFocusLost(evt);
            }
        });

        jLabel1.setText("Alternative Contact:");

        jLabel7.setText("Commsion Offered e.g 12:");

        jTextFieldCommsion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jpanelBank2Layout = new javax.swing.GroupLayout(jpanelBank2);
        jpanelBank2.setLayout(jpanelBank2Layout);
        jpanelBank2Layout.setHorizontalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtBankName)
                    .addComponent(jtxtAltContact)
                    .addComponent(jTextFieldCommsion, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelBank2Layout.setVerticalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtAltContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtBankName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCommsion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jbtnExit.setToolTipText("Exit the bank details form");
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

        jButtonStament.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonStament.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/fprinter.png"))); // NOI18N
        jButtonStament.setText("Statement");
        jButtonStament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStamentActionPerformed(evt);
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
                .addGap(32, 32, 32)
                .addComponent(jButtonDelete)
                .addGap(28, 28, 28)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonStament)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelete, jbtnSave, jbtnUpdate});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonStament, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonDelete, jbtnExit, jbtnSave, jbtnUpdate});

        jpanelBank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank.setToolTipText("Tenants Details");
        jpanelBank.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel4.setText("Owners Account :");

        jLabel5.setText("Full Name:");

        jLabel3.setText("Phone Number:");

        jtxtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIDfindRecord(evt);
            }
        });

        jLabelNewAccount.setText("Enter New Account:");

        jTextFieldNewAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNewAccountFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpanelBankLayout = new javax.swing.GroupLayout(jpanelBank);
        jpanelBank.setLayout(jpanelBankLayout);
        jpanelBankLayout.setHorizontalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBankLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNewAccount)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtID, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jtxtFullName)
                    .addComponent(jtxPhoneNumber)
                    .addComponent(jTextFieldNewAccount))
                .addGap(27, 27, 27))
        );
        jpanelBankLayout.setVerticalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewAccount)
                    .addComponent(jTextFieldNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
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
                        .addComponent(jpanelBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpanelBank2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanelBank2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanelBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("__________Owners Details Entry_______");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
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
                .addGap(147, 147, 147)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // This code saves the new details to  owners table
        try
        {
            strID = jtxtID.getText();
            strFullName = jtxtFullName.getText();
            strPhoneNumber = jtxPhoneNumber.getText();
            strAltContact = jtxtAltContact.getText();
            strBankName = jtxtBankName.getText();
            strCommsions = jTextFieldCommsion.getText();

            System.out.println("Moving to insert record");
            System.out.println("commission is"+strCommsions);
            rs.moveToInsertRow();
            st.executeUpdate("insert into owners values('" +  strID  + "','" + strFullName + "','"+ 
                    strPhoneNumber +"','"+ strAltContact +"','"+strBankName+"','"+strCommsions+"','','')");
            JOptionPane.showMessageDialog(rootPane, "Record has been saved successfully!\nProceed to add  Details","Owners  Details",JOptionPane.INFORMATION_MESSAGE);
            
            jtxPhoneNumber.setText(null);
            jtxtAltContact.setText(null);
            jtxtBankName.setText(null);
            jtxtFullName.setText(null);
            jtxtID.setText(null);
            jTextFieldCommsion.setText(null);
            jTextFieldNewAccount.setText(null);
            
            this.dispose();
            new Owners().setVisible(true);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, "Duplicate Entry Made!\n Or something went wrong.Please try again the Entry","Owners  Details",JOptionPane.INFORMATION_MESSAGE);
            new Owners().setVisible(true);
            jtxPhoneNumber.setText(null);
            jtxtAltContact.setText(null);
            jtxtBankName.setText(null);
            jtxtFullName.setText(null);
            jtxtID.setText(null);
            jTextFieldCommsion.setText(null);
            jTextFieldNewAccount.setText(null);
            
            e.printStackTrace();
            this.dispose();
        }
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        //return user to owners
        this.dispose();
        Owners.getOwners().setVisible(true);
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        // updates the  owners relation
        try{
            strID = jtxtID.getText();
            strFullName = jtxtFullName.getText();
            strPhoneNumber = jtxPhoneNumber.getText();
            strAltContact = jtxtAltContact.getText();
            strBankName = jtxtBankName.getText();
            String newAccount = jTextFieldNewAccount.getText();
            String commission = jTextFieldCommsion.getText();

            
            String updateOwners = "update owners set owner_id ='"+newAccount+"', owner_name ='"+strFullName+"', phone1 = '"+strPhoneNumber+"',phone2='"+strAltContact+"', Bank_Name='"+strBankName+"', percentage_commission='"+commission+"' where owner_id="+strID+" ";
            
           //Perform update on the selected row
            pstmt = con.prepareStatement(updateOwners);
            pstmt.executeUpdate();
            
            int i=pstmt.executeUpdate();

            
               JOptionPane.showMessageDialog(rootPane, "Record has been updated successfully!\n"+"Proceed to update another record","Tenant's  Details",JOptionPane.INFORMATION_MESSAGE);  
               jTextFieldNewAccount.setText(null);
               jTextFieldCommsion.setText(null);
               new Owners().setVisible(true);
               pstmt.close();
               this.dispose();     
            }
            catch (SQLException err)
            {
            JOptionPane.showMessageDialog(rootPane, "Invalid entry made!\n Or something went wrong.Please try again the Update","Data Entry",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Owners.getOwners().setVisible(true);
            err.printStackTrace();
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jtxtIDfindRecord(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIDfindRecord

    }//GEN-LAST:event_jtxtIDfindRecord

    private void jtxtAltContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtAltContactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAltContactFocusLost

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
       Owners.getOwners().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Owners.getOwners().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextFieldNewAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewAccountFocusLost
        //Sets sync with Bank account Filed.
    }//GEN-LAST:event_jTextFieldNewAccountFocusLost

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // Deletes Owner completely from Database;
        try {
                
                String ownerID;
          
                ownerID = jtxtID.getText();

                String DeleteCustomer="delete from owners where owner_id = '"+ownerID+"'";
                  //delete from customers where customer_id='78 ';                       
                pstmt = con.prepareStatement(DeleteCustomer);
                pstmt.executeUpdate();
               // int i=pstmt.executeUpdate();
                
               
                JOptionPane.showMessageDialog(rootPane, "Record has been Deleted successfully!\n"+"Proceed to delete another Tenant's details","Tenant's  Details",JOptionPane.INFORMATION_MESSAGE);  
                new Owners().setVisible(true);
                
                jtxPhoneNumber.setText(null);
                jtxtAltContact.setText(null);
                jtxtBankName.setText(null);
                jtxtFullName.setText(null);
                jtxtID.setText(null);
                
                this.dispose();
               pstmt.close();

            } catch ( SQLException ex) {
                Logger.getLogger(AdminTenants.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonReportRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportRequestActionPerformed
       /* // retrieves data from the date chooser;
        if(jTextFieldStartDate.getText().isEmpty()||jTextFieldEndDate.getText().isEmpty()){

            //JOptionPane.showConfirmDialog(null,"Incorect Date Entered. Please check and try again" , "Tenants Report",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldStartDate.requestFocusInWindow();
            jTextFieldStartDate.grabFocus();
            jTextFieldEndDate.requestFocusInWindow();
            jTextFieldEndDate.grabFocus();
        }

        else{
            startDate  = jTextFieldStartDate.getText();
            endDate = jTextFieldEndDate.getText();
           // jTextFieldPassOwnerID.setText(jtxtID.getText());
            
            
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
            java.sql.Date stqlEndDate = java.sql.Date.valueOf(endDate);

            System.out.println("startDate"+sqlStartDate);
            System.out.println("endDate"+stqlEndDate);
            if(jTextFieldStartDate.getText() == null||jTextFieldEndDate.getText() == null){
                JOptionPane.showMessageDialog(null, "No date entered.\n"+"Please check again","Payments  Details",JOptionPane.INFORMATION_MESSAGE);
            }
            try{

                SQLPaymentRpt = "select * from payments where date(payment_date) between '"+sqlStartDate+"' and '"+stqlEndDate+"'";
                rsStatement = stStatement.executeQuery(SQLPaymentRpt);

                ResultSetMetaData rsmd = rsStatement.getMetaData();
                int columnCount = rsmd.getColumnCount();
                rsStatement.first();
                Document pdf = new Document(PageSize.A4.rotate());

                try {
                    PdfWriter.getInstance(pdf,new FileOutputStream("E:\\prof\\"+FileBaseName+filename));
                } catch (DocumentException | FileNotFoundException ex) {
                    Logger.getLogger(AdminOwners.class.getName()).log(Level.SEVERE, null, ex);
                }
                    PdfPTable printTable = new PdfPTable(10);

                    printTable.setWidthPercentage(100);
                    Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

                    printTable.addCell("Receipt Number");
                    printTable.addCell("Apartment ID");
                    printTable.addCell("Customer ID");
                    printTable.addCell("Apartment Location");
                    printTable.addCell("Mode of Payment");
                    printTable.addCell("Apartment Name");
                    printTable.addCell("Payment Date");
                    printTable.addCell("Amount Paid");
                    printTable.addCell("Month Paid");
                    printTable.addCell("Arrears");
                    printTable.addCell("Owner A/C");
                    printTable.addCell("Total Commision");

                    printTable.setHeaderRows(1);
                    pdf.open();

                    System.out.println(columnCount);
                    pdf.open();
                    Paragraph pg =new Paragraph("",boldFont);
                    Date date =new Date();
                    String sDate = date.toString();
                    pg.add("Rent Payments Report"+"\n"+sDate+"\n");
                    pg.setAlignment(Element.ALIGN_CENTER);
                    pg.add(" ");
                    pdf.add(pg);

                    do{
                        printTable.addCell(rsStatement.getString("payment_id"));
                        printTable.addCell(rsStatement.getString("apartment_id"));
                        printTable.addCell(rsStatement.getString("customer_id"));
                        printTable.addCell(rsStatement.getString("payment_details"));
                        printTable.addCell(rsStatement.getString("payment_mode"));
                        printTable.addCell(rsStatement.getString("payment_type"));
                        printTable.addCell(rsStatement.getString("payment_date"));
                        printTable.addCell(rsStatement.getString("Amount"));
                        printTable.addCell(rsStatement.getString("period"));
                        printTable.addCell(currency+rsStatement.getString("arrears"));
                        //printTable.addCell(currency+rsRpt.getString("arrears"));
                        //printTable.addCell(currency+rsRpt.getString("arrears"));
                        //printTable.addCell(rsRpt.getString("owner_id"));
                    }
                    while(rsStatement.next());
                    pdf.add(printTable);
                    pdf.close();

                    if(Desktop.isDesktopSupported()){

                        File report = new File("E:/prof/"+FileBaseName+filename);
                        Desktop.getDesktop().open(report);
                    }
                    else{
                        //this.errorDialog();
                        
                    }
                }

                catch(SQLException | DocumentException | IOException ex){
                   // this.errorDialog();
                   ex.printStackTrace();
                }

                jDialogDate.dispose();//close the dialog box and then show the parent form.
            }
        */
    }//GEN-LAST:event_jButtonReportRequestActionPerformed

    private void jButtonStamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStamentActionPerformed
        // pass parameters to the new dialog
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - jDialogStatement.getWidth()) / 2;
        final int y = (screenSize.height - jDialogStatement.getHeight()) / 2;
        jDialogStatement.setLocation(x, y);
        //jDialogStatement.setUndecorated(false);
        jDialogStatement.setVisible(true);
        
        jTextFieldPassAcc.setText(jtxtID.getText());
        jTextFieldPassName.setText(jtxtFullName.getText());
        bankName = jtxtBankName.getText();
        
    }//GEN-LAST:event_jButtonStamentActionPerformed

    private void jButtonSubimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubimitActionPerformed
        // code to get the payments records using owners;
        if(jTextFieldStartDate1.getText().isEmpty()||jTextFieldEndDate1.getText().isEmpty()){
             
            //JOptionPane.showConfirmDialog(null,"Incorect Date Entered. Please check and try again" , "Tenants Report",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldStartDate1.requestFocusInWindow();
            jTextFieldStartDate1.grabFocus();
            jTextFieldEndDate1.requestFocusInWindow();
            jTextFieldEndDate1.grabFocus();
        }

        else{
        startDate  = jTextFieldStartDate1.getText();
        endDate = jTextFieldEndDate1.getText();
        java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
        java.sql.Date stqlEndDate = java.sql.Date.valueOf(endDate);
        
        
        if(jTextFieldStartDate1.getText() == null||jTextFieldEndDate1.getText() == null){
            JOptionPane.showMessageDialog(null, "No date entered.\n"+"Please check again","Payments  Details",JOptionPane.INFORMATION_MESSAGE);
        }
        try{

            String OwnerID = jTextFieldPassAcc.getText();
            String OwnerName = jTextFieldPassName.getText();
            //SQLPamentRpt = "select * from payments where date(payment_date) between '"+sqlStartDate+"' and '"+stqlEndDate+"'";
            
            
            SQLPaymentRpt = "select * from payments, customers  where payments.customer_id = customers.customer_id  "
                    + "and customers.owner_id = '"+OwnerID+"' "
                    + "and date(payment_date) between '"+sqlStartDate+"' and '"+stqlEndDate+"' group by payments.payment_id";
            
                   
            rsGetOwners = stGetOwners.executeQuery(SQLPaymentRpt);

            ResultSetMetaData rsmd = rsGetOwners.getMetaData();
            int columnCount = rsmd.getColumnCount();
            rsGetOwners.beforeFirst();
            Document pdf = new Document(PageSize.A4.rotate());

            PdfWriter.getInstance(pdf,new FileOutputStream("E:\\prof\\"+FileBaseName+filename));
                Image img = Image.getInstance("E:\\Wycliffe\\Apps\\JAVA_Projects\\HousingAgencyApp\\src\\payrollsystem\\brighter5.JPG");
                img.setWidthPercentage(100);
                img.scaleToFit(770f, 112f);
                
                Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
                Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
                Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);

                PdfPTable printTable = new PdfPTable(7);
                printTable.setWidths(new int[]{50,100,50,50,50,50,50});
                printTable.setWidthPercentage(100);
                
                printTable.addCell("House Number");
                printTable.addCell("Tenant's Name");
                printTable.addCell("National ID");
                printTable.addCell("Receipt Number");
                printTable.addCell("Rent Rate");
                printTable.addCell("Amount Paid");
                printTable.addCell("Arrears");
                

                printTable.setHeaderRows(1);
                pdf.open();

                System.out.println(columnCount);
                pdf.open();
                           
                Paragraph pg =new Paragraph("",titleFont);
                Date date =new Date();
                String sDate = date.toString();
                
                java.sql.Date monthValue  = java.sql.Date.valueOf(startDate);
                Calendar calMonth = Calendar.getInstance();
                calMonth.setTime(monthValue);
                int month = calMonth.get(Calendar.MONTH);
                int year = calMonth.get(Calendar.YEAR);
                pg.add("Monthly Rent Statement - "+formatMonth(month)+" "+year+"\n");
                pg.setAlignment(Element.ALIGN_CENTER);
               
                pdf.add(pg);
                
                Paragraph pgOwnerDetails =new Paragraph("",boldFont);
                pgOwnerDetails.add(OwnerName+" : "+bankName+" : "+"Account Number :"+OwnerID);
                pgOwnerDetails.setAlignment(Element.ALIGN_CENTER);
                pgOwnerDetails.add(" ");
                pdf.add(pgOwnerDetails);
                
                Paragraph pgLogo =new Paragraph("",boldFont);//Start of logo paragraph
                pgLogo.setAlignment(Element.ALIGN_CENTER);
                pgLogo.add(img);
                
                Paragraph nopg =new Paragraph("",boldFont);
                nopg.add("");
                pdf.add(nopg);
                
                pdf.add(pgLogo);//End of logo paragraph
                if(rsGetOwners.next())
                {
                  
                do{
                        printTable.addCell(rsGetOwners.getString("house_no"));
                        printTable.addCell(rsGetOwners.getString("first_name")+" "+rsGetOwners.getString("last_name"));
                        printTable.addCell(rsGetOwners.getString("customer_id"));
                        printTable.addCell(rsGetOwners.getString("payment_id"));
                        printTable.addCell(currency+rsGetOwners.getString("rate"));
                        printTable.addCell(currency+rsGetOwners.getString("Amount")); 
                        printTable.addCell(currency+rsGetOwners.getString("arrears"));
                        
                        String comm = rsGetOwners.getString("percentage_commission");
                        commRate = Double.parseDouble(comm);
   
                    }
                    while(rsGetOwners.next());
                    
                    String SQLGetPay = "select sum(Amount), payments.period, sum(arrears),payments.owner_id,payments.percentage_commission, "
                                + "sum(payments.calc_commission) from payments "
                                + "where payments.owner_id = '"+OwnerID+"' and date(payment_date) between '"+sqlStartDate+"' and '"+stqlEndDate+"';";
                        
                    rsGetPay = stGetPay.executeQuery(SQLGetPay);
                    
                    while(rsGetPay.next()){
                        
                        String amtPaid = rsGetPay.getString("sum(Amount)");
                        String strArrears = rsGetPay.getString("sum(arrears)");
                        
                        
                        
                        
                        totalRent = Double.parseDouble(amtPaid);

                        arrears = Double.parseDouble(strArrears);
                        
                    }
                    pdf.add(printTable);
                    
                    Paragraph pgSummary =new Paragraph("",boldFont);
                    pgSummary.add("Summary");
                    pgSummary.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgSummary);
                    

                    commisison = ((totalRent*commRate)/100);
                    if(jtxtExpenses.getText().isEmpty()){
                       // JOptionPane.showMessageDialog(null, "No Expense entered.\n"+"Please check again","Expenses Entry",JOptionPane.ERROR_MESSAGE);
                        jtxtExpenses.requestFocusInWindow();
                        jtxtExpenses.grabFocus();
                        
                    }
                    else{
                    String strExpenses = jtxtExpenses.getText(); 
                    expenses = Double.parseDouble(strExpenses);
                    }
                    deductions = expenses + commisison;
                    netPay = totalRent-deductions;
                    
                    Paragraph pgRentPaid =new Paragraph("",boldFont1);
                    pgRentPaid.add("Total Rent Paid : "+totalRent);
                    pgRentPaid.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgRentPaid);
                    
                    Paragraph pgArrears =new Paragraph("",boldFont1);
                    pgArrears.add("Total Unpaid Rent :"+arrears);
                    pgArrears.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgArrears);
                    
                    Paragraph pgdeduct =new Paragraph("",boldFont);
                    pgdeduct.add("Deductions");
                    pgdeduct.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgdeduct);
                    
                    Paragraph pgExpenses =new Paragraph("",boldFont1);
                    pgExpenses.add("Total Expenses : "+expenses);
                    pgExpenses.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgExpenses);
                    
                    Paragraph pgComms =new Paragraph("",boldFont1);
                    pgComms.add("Commissions Payable : "+commisison);
                    pgComms.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgComms);
                    
                    Paragraph pgNetPay =new Paragraph("",boldFont1);
                    pgNetPay.add("Net Pay / Amount Banked :"+netPay);
                    pgNetPay.setAlignment(Element.ALIGN_LEFT);
                    pdf.add(pgNetPay);
               
                    Paragraph pgCom =new Paragraph("",boldFont1);
                    pgCom.add(" ");
                    pgCom.add("Prepared By : Isaac Watari Ngigi on : "+sDate+"\n"); 		
                    pgCom.add("");
                    pgCom.add("___________________________________________________________________________");
                    pgCom.add("___________________________________________________________________________");
                    pgCom.setAlignment(Element.ALIGN_BOTTOM);
                    pdf.add(pgCom);//add third paragraph
                   
                    
                    pdf.close();
                    
                    if(Desktop.isDesktopSupported()){

                        File report = new File("E:/prof/"+FileBaseName+filename);
                        Desktop.getDesktop().open(report);
                        
                    }
                    jtxtExpenses.setText(null);
                    jTextFieldStartDate1.setText(null);
                    jTextFieldEndDate1.setText(null);
                    jDialogStatement.dispose();//close the dialog box and then show the parent form. 
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "No payments exist for Owner "+OwnerName+"!","Statement Report\n",JOptionPane.INFORMATION_MESSAGE); 
                    jtxtExpenses.setText(null);
                    jTextFieldStartDate1.setText(null);
                    jTextFieldEndDate1.setText(null);
                    jDialogStatement.dispose();
                    pdf.close();
                
                }
            }
            catch(SQLException | DocumentException | IOException ex){
                      //this.errorDialog();
                      ex.printStackTrace();
            } 

        }
    
    }//GEN-LAST:event_jButtonSubimitActionPerformed

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // Disposes the jDialog
        jDialogStatement.dispose();
        
    }//GEN-LAST:event_jLabelExitMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> {
            new AdminOwners().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dialogPanel;
    public javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonReportRequest;
    private javax.swing.JButton jButtonStament;
    private javax.swing.JButton jButtonSubimit;
    private javax.swing.JDialog jDialogDate;
    private javax.swing.JDialog jDialogStatement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelExit;
    public javax.swing.JLabel jLabelNewAccount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField jTextFieldCommsion;
    private javax.swing.JTextField jTextFieldEndDate;
    public javax.swing.JTextField jTextFieldEndDate1;
    public javax.swing.JTextField jTextFieldNewAccount;
    public javax.swing.JTextField jTextFieldPassAcc;
    public javax.swing.JTextField jTextFieldPassName;
    private javax.swing.JTextField jTextFieldPassOwnerID;
    private javax.swing.JTextField jTextFieldStartDate;
    public javax.swing.JTextField jTextFieldStartDate1;
    public javax.swing.JButton jbtnExit;
    public javax.swing.JButton jbtnSave;
    public javax.swing.JButton jbtnUpdate;
    private javax.swing.JPanel jpanelBank;
    private javax.swing.JPanel jpanelBank2;
    public javax.swing.JTextField jtxPhoneNumber;
    public javax.swing.JTextField jtxtAltContact;
    public javax.swing.JTextField jtxtBankName;
    private javax.swing.JTextField jtxtExpenses;
    public javax.swing.JTextField jtxtFullName;
    public javax.swing.JTextField jtxtID;
    // End of variables declaration//GEN-END:variables
}
