package com.wycliffe.housingAgencyApplication;
//@author Wycliffe.Ochieng
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

public final class Payments extends javax.swing.JFrame {

    Connection con;
    ResultSet rs,rs2,rs3,rsArrears,rsRecon,rsCollection, rsCollectionUpdate,rsGetApartmentName,rsRpt;
    Statement st,stCustomer,stPayments,stRecon,stCollection, stCollectionUpdate,stGetApartmentName,stTable,stReport,stRpt;
    PreparedStatement pstmt;
    String SQLPayments = "select * from payments";
    String strPayment_id , strApartment_id, strCustomer_id, strPayment_details, strPayment_mode, strPayment_type, 
	strPayment_date,strAmount,strPeriod, strArrears,strTempAptID,strTempOwner,strpercentage_commission,strOwner_ID;
    String AmountPaid,CustomerID,PayMode,ApartmentID,PaymentDetails,PaymentID,PaymentType
            ,Arrears,RentPayable,PayPeriod,PaymentOwner, custID;
    String month=" ",modeOfPay=" ", totalArrears;
    String SQLRecon,SQLGetCollection,SQLSubmitCollection,startDate,endDate,SQLPamentRpt;
    String SQLPayments1 = "select * from payments";
    String strCustomerID, strApartmentID, strSum,strOwnerID,strOwnerIDFinal,
            strFinalAmt, agentCommission,strTotalCollection,strTotalCommision;
    int rentDifference, FinalAmt,getComission;
    int yMouse,xMouse;
    float TotalCommision;
    int x = 1;
    String currency="Kes.", FileBaseName="Payments", paymentstartDate, paymentsEndDate;
    String filename = new SimpleDateFormat("yyyyMMddHHmm'.pdf'").format(new Date());
    
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    AdminPayments adminPayData = new AdminPayments();
    DefaultTableModel payModel  = new DefaultTableModel();
    int selectedRowIndex;
 
    public static Payments payments =null; 
    public static Payments getPayements(){
       
        if(payments==null){
           payments = new Payments(); 
        }
         return payments;
    }
    
    
    public void paymentsRun(){
              
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stRecon = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stCollection = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stCollectionUpdate = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stRpt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQLPayments1);
            
            try{
            
            payModel = (DefaultTableModel)jTablePayments.getModel();
             while(rs.next()){
            strPayment_id = rs.getString("payment_id");
            strApartment_id = rs.getString("apartment_id");
            strCustomer_id = rs.getString("customer_id");
            strPayment_details = rs.getString("payment_details");
            strPayment_mode = rs.getString("payment_mode");
            strPayment_date = rs.getString("payment_date");
            strAmount = rs.getString("Amount");
            strPeriod = rs.getString("period");
            strArrears = rs.getString("arrears");
            strOwner_ID =  rs.getString("owner_id");
            strTotalCommision = rs.getString("calc_commission");//total_commission
            strpercentage_commission = rs.getString("percentage_commission");
            
                payModel.addRow(new Object[]{
                    strPayment_id , strApartment_id, strCustomer_id, strPayment_details, strPayment_mode, 
                    strPayment_date,strAmount,strPeriod, strArrears,strOwner_ID,strTotalCommision,strpercentage_commission    
                });
            }
            
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            
        }
        catch(SQLException e){
        }
        
    }
    public void errorDialog(){
                final Toolkit toolkit = Toolkit.getDefaultToolkit();
                final Dimension screenSize = toolkit.getScreenSize();
                final int x = (screenSize.width - ErrorDialog.getWidth()) / 2;
                final int y = (screenSize.height - ErrorDialog.getHeight()) / 2;
                ErrorDialog.setLocation(x, y);
                ErrorDialog.setUndecorated(true);    
                ErrorDialog.setVisible(true); 
    }
    public Payments() {
        initComponents();
        
        this.paymentsRun();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDate = new javax.swing.JDialog();
        dialogPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonReportRequest = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldStartDate = new javax.swing.JTextField();
        jTextFieldEndDate = new javax.swing.JTextField();
        jTextFieldMsg = new javax.swing.JTextField();
        ErrorDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonMsgClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePayments = new javax.swing.JTable();
        sidepane = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonOwners = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonPayReport = new javax.swing.JButton();
        jButtonTenants = new javax.swing.JButton();
        jButtonApartments = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonNewPay = new javax.swing.JButton();

        jDialogDate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogDate.setMinimumSize(new java.awt.Dimension(376, 277));
        jDialogDate.setModal(true);
        jDialogDate.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        jDialogDate.setUndecorated(true);
        jDialogDate.setSize(new java.awt.Dimension(300, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Please Enter Dates for the Report");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("From Date:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("To Date:");

        jButtonReportRequest.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReportRequest.setText("Submit");
        jButtonReportRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportRequestActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jTextFieldMsg.setEditable(false);
        jTextFieldMsg.setBorder(null);

        javax.swing.GroupLayout dialogPanelLayout = new javax.swing.GroupLayout(dialogPanel);
        dialogPanel.setLayout(dialogPanelLayout);
        dialogPanelLayout.setHorizontalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addGroup(dialogPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButtonReportRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialogPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addComponent(jTextFieldMsg)
        );
        dialogPanelLayout.setVerticalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonReportRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        ErrorDialog.setAlwaysOnTop(true);
        ErrorDialog.setMinimumSize(new java.awt.Dimension(300, 200));
        ErrorDialog.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        ErrorDialog.setUndecorated(true);
        ErrorDialog.setResizable(false);
        ErrorDialog.setSize(new java.awt.Dimension(300, 159));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Problem.png"))); // NOI18N
        jLabel6.setText("No Recors Found for Specified Dates. ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText(" Please Check and try again");

        jButtonMsgClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonMsgClose.setText("Close");
        jButtonMsgClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMsgCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButtonMsgClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMsgClose, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ErrorDialogLayout = new javax.swing.GroupLayout(ErrorDialog.getContentPane());
        ErrorDialog.getContentPane().setLayout(ErrorDialogLayout);
        ErrorDialogLayout.setHorizontalGroup(
            ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ErrorDialogLayout.setVerticalGroup(
            ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Received Payments"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTablePayments.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTablePayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Apartment ID", "Customer ID", "Location(Area)", "Payment Mode", "Payment Date", "Amount Paid", "Period", "Arrears", "Owner A/C", "Commision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePayments.setGridColor(new java.awt.Color(51, 51, 51));
        jTablePayments.setRowHeight(24);
        jTablePayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePaymentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePayments);
        if (jTablePayments.getColumnModel().getColumnCount() > 0) {
            jTablePayments.getColumnModel().getColumn(2).setPreferredWidth(140);
            jTablePayments.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTablePayments.getColumnModel().getColumn(9).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        sidepane.setBackground(new java.awt.Color(54, 33, 89));
        sidepane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 5));

        jButtonOwners.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonOwners.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/open.png"))); // NOI18N
        jButtonOwners.setText("View Owners");
        jButtonOwners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOwnersActionPerformed(evt);
            }
        });

        jButtonHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Help.png"))); // NOI18N
        jButtonHelp.setText("Get Help         ");
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

        jButtonPayReport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPayReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/File PDF-01.png"))); // NOI18N
        jButtonPayReport.setText("Payments  Report");
        jButtonPayReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayReportActionPerformed(evt);
            }
        });

        jButtonTenants.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonTenants.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/User_group.png"))); // NOI18N
        jButtonTenants.setText("All Tenants   ");
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

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator2)))
            .addComponent(jButtonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonApartments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonTenants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPayReport, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOwners, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidepaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonHelp, jButtonPayReport});

        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOwners, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTenants, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonApartments, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPayReport, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        sidepaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonHelp, jButtonHome, jButtonOwners, jButtonPayReport});

        jPanel6.setBackground(new java.awt.Color(153, 0, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(153, 0, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("_________ Payments Details________");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonMin)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Payment"));

        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonNewPay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonNewPay.setText("Add Payment");
        jButtonNewPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButtonNewPay, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNewPay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePaymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePaymentsMouseClicked
        selectedRowIndex = jTablePayments.getSelectedRow();
       
        adminPayData.jtxtAmountPaid.setText(payModel.getValueAt(selectedRowIndex,7).toString());
        adminPayData.jtxtAprtmentID.setText(payModel.getValueAt(selectedRowIndex,1).toString());
        adminPayData.jtxtArrears.setText(payModel.getValueAt(selectedRowIndex,8).toString());
        adminPayData.jtxtCustomerID.setText(payModel.getValueAt(selectedRowIndex,2).toString());
        adminPayData.jtxtAptLocation.setText(payModel.getValueAt(selectedRowIndex,3).toString());
        adminPayData.jTextFieldDate.setText(payModel.getValueAt(selectedRowIndex,5).toString());
        adminPayData.jtxtPaymentID.setText(payModel.getValueAt(selectedRowIndex,0).toString());
        //adminPayData.jtxtApartmentName.setText(payModel.getValueAt(selectedRowIndex,).toString());
        //adminPayData.jtxtRentPayable.setText(payModel.getValueAt(selectedRowIndex,7).toString());
        adminPayData.jButtonSave.setEnabled(false);
        
        this.dispose();
        adminPayData.setAlwaysOnTop(true);
        adminPayData.setVisible(true);
        adminPayData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminPayData.pack();
    }//GEN-LAST:event_jTablePaymentsMouseClicked

    private void jButtonOwnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOwnersActionPerformed
        // call owners form
        new Owners().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonOwnersActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // call Home form
         Home.getHome().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonPayReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayReportActionPerformed
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - jDialogDate.getWidth()) / 2;
        final int y = (screenSize.height - jDialogDate.getHeight()) / 2;
        jDialogDate.setLocation(x, y);
        jDialogDate.setUndecorated(true);
        jDialogDate.setVisible(true);

    }//GEN-LAST:event_jButtonPayReportActionPerformed

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

    private void jButtonNewPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPayActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminPayments().setVisible(true);
    }//GEN-LAST:event_jButtonNewPayActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        Home.getHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
                new HousingAgencyHelp().setVisible(true);

    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Home.getHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButtonReportRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportRequestActionPerformed
        // retrieves data from the date chooser;
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
        java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
        java.sql.Date stqlEndDate = java.sql.Date.valueOf(endDate);

        System.out.println("startDate"+sqlStartDate);
        System.out.println("endDate"+stqlEndDate);
        if(jTextFieldStartDate.getText() == null||jTextFieldEndDate.getText() == null){
            JOptionPane.showMessageDialog(null, "No date entered.\n"+"Please check again","Payments  Details",JOptionPane.INFORMATION_MESSAGE);
        }
        try{

            SQLPamentRpt = "select * from payments where date(payment_date) between '"+sqlStartDate+"' and '"+stqlEndDate+"'";
            rsRpt = stRpt.executeQuery(SQLPamentRpt);

            ResultSetMetaData rsmd = rsRpt.getMetaData();
            int columnCount = rsmd.getColumnCount();
            rsRpt.first();
            Document pdf = new Document(PageSize.A4.rotate());

            PdfWriter.getInstance(pdf,new FileOutputStream("E:\\prof\\"+FileBaseName+filename));
                
            Image img = Image.getInstance("E:\\Wycliffe\\Apps\\JAVA_Projects\\HousingAgencyApp\\src\\payrollsystem\\brighter5.JPG");
            img.setWidthPercentage(100);
            img.scaleToFit(770f, 112f);
            
            PdfPTable printTable = new PdfPTable(9);

                printTable.setWidthPercentage(100);
                Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

                printTable.addCell("Receipt Number");
                printTable.addCell("Apartment ID");
                printTable.addCell("National ID");
                printTable.addCell("Apartment Location");
                printTable.addCell("Mode of Payment");
                printTable.addCell("Payment Date");
                printTable.addCell("Amount Paid");
                printTable.addCell("Month Paid");
                printTable.addCell("Arrears");
                //printTable.addCell("Owner A/C");
                //printTable.addCell("Total Commision");

                printTable.setHeaderRows(1);
                pdf.open();

                System.out.println(columnCount);
                pdf.open();
                Paragraph pg =new Paragraph("",boldFont);
                Date date =new Date();
                String sDate = date.toString();
                pg.add("All Rent Payments Report"+"\n"+sDate+"\n");
                pg.setAlignment(Element.ALIGN_CENTER);
                pg.add(" ");
                pdf.add(pg);
                
                Paragraph pgLogo =new Paragraph("",boldFont);//Start of second paragraph
                pgLogo.setAlignment(Element.ALIGN_CENTER);
                pgLogo.add(img);
                pgLogo.add(" ");
                pdf.add(pgLogo);//End of second paragraph
      
                    do{
                        printTable.addCell(rsRpt.getString("payment_id"));
                        printTable.addCell(rsRpt.getString("apartment_id"));
                        printTable.addCell(rsRpt.getString("customer_id"));
                        printTable.addCell(rsRpt.getString("payment_details"));
                        printTable.addCell(rsRpt.getString("payment_mode"));
                        printTable.addCell(rsRpt.getString("payment_date"));
                        printTable.addCell(rsRpt.getString("Amount"));
                        printTable.addCell(rsRpt.getString("period"));
                        printTable.addCell(currency+rsRpt.getString("arrears"));

                    }
                    while(rsRpt.next());
                    pdf.add(printTable);
                    
                    Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
                    Paragraph pgCom =new Paragraph("",boldFont1);
                    pgCom.add(" ");
                    pgCom.add("Prepared By : Isaac Watari Ngigi on: "+sDate+"\n"); 		
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
                    else{
                        this.errorDialog();
                    }
               
            }

            catch(SQLException | DocumentException | IOException ex){
                      this.errorDialog();
                      ex.printStackTrace();
            } 

            jDialogDate.dispose();//close the dialog box and then show the parent form. 
            jTextFieldStartDate.setText(null);
            jTextFieldEndDate.setText(null);
        }
    }//GEN-LAST:event_jButtonReportRequestActionPerformed

    private void jButtonMsgCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMsgCloseActionPerformed
        // TODO add your handling code here:
        ErrorDialog.dispose();
        jTextFieldStartDate.setText(null);
        jTextFieldEndDate.setText(null);
    }//GEN-LAST:event_jButtonMsgCloseActionPerformed

    private void jButtonMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinActionPerformed
         setState(ICONIFIED);
    }//GEN-LAST:event_jButtonMinActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // 
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
        java.awt.EventQueue.invokeLater(() -> {
            new Payments().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDialog ErrorDialog;
    private javax.swing.JPanel dialogPanel;
    private javax.swing.JButton jButtonApartments;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonMsgClose;
    private javax.swing.JButton jButtonNewPay;
    private javax.swing.JButton jButtonOwners;
    private javax.swing.JButton jButtonPayReport;
    private javax.swing.JButton jButtonReportRequest;
    private javax.swing.JButton jButtonTenants;
    private javax.swing.JDialog jDialogDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTablePayments;
    private javax.swing.JTextField jTextFieldEndDate;
    private javax.swing.JTextField jTextFieldMsg;
    private javax.swing.JTextField jTextFieldStartDate;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
