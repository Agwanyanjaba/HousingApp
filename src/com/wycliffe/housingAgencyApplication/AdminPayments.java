package com.wycliffe.housingAgencyApplication;
//@author Wycliffe.Ochieng
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AdminPayments extends javax.swing.JFrame {

    Connection con;
    ResultSet rs2,rs3,rSave,rsArrears,rsRecon,rsCollection, rsCollectionUpdate,rsGetApartmentName,
            rsGetCustomer,rsOwners,rsUpdateComm,srGetReport;
    Statement st,stSave,stCustomer,stPayments,stRecon,stCollection, stCollectionUpdate,stGetApartmentName,stGetCustomer,
            stGetOwners,stUpdateComm,stGetReport;
    PreparedStatement pstmt,pstmtCommission;
    String strPayment_id , strApartment_id, strCustomer_id, strPayment_details, strPayment_mode, strPayment_type, 
	strPayment_date,strAmount,strPeriod, strArrears,strTempAptID,strTempOwner;
    String AmountPaid,CustomerID,PayMode,ApartmentID,PaymentDetails,PaymentID,PaymentType
            ,Arrears,RentPayable,PayPeriod,PaymentOwner, custID;
    String month=" ",modeOfPay=" ", totalArrears;
    String SQLRecon,SQLGetCollection,SQLSubmitCollection;
    String SQLPayments = "select * from payments";
    String SQLGetApartments = "select * from apartemnts";
    String SQLGetCustomers;
    String strCustID, strAptID,strOwnID;
    String strCustomerID, strApartmentID, strSum,strOwnerID,strOwnerIDFinal,strFinalAmt, agentCommission;
    DecimalFormat decimalFormattter = new DecimalFormat(".##");
    double rentDifference, FinalAmt,getComission, TotalCommision,totalComm,commission;
    int x = 1;
    int xMouse, yMouse;
    
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    public void adminPayments() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
        stSave = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stRecon = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stCollection = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stCollectionUpdate = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stGetCustomer = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stUpdateComm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }
    
    public AdminPayments()  {
        initComponents();
        jTextFieldDate.setText(currentTimestamp.toString());
        try {
            this.adminPayments();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpanelBank2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtAprtmentID = new javax.swing.JTextField();
        jtxtAptLocation = new javax.swing.JTextField();
        jtxtCustomerID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtAmountPaid = new javax.swing.JTextField();
        jtxtPaymentID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtApartmentName = new javax.swing.JTextField();
        jpanelBank = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtArrears = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtxtRentPayable = new javax.swing.JTextField();
        jComboBoxMonth = new javax.swing.JComboBox<>();
        jComboBoxPayMode = new javax.swing.JComboBox<>();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jButtonMin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jTextFieldOwnerID = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Payment"));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jpanelBank2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank2.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel7.setText("Payment ID/Receipt:");

        jLabel8.setText("Apartment ID:");

        jLabel9.setText("Customer ID:");

        jLabel10.setText("Location/Area:");

        jtxtAprtmentID.setEditable(false);
        jtxtAprtmentID.setBackground(new java.awt.Color(255, 255, 255));

        jtxtAptLocation.setEditable(false);
        jtxtAptLocation.setBackground(new java.awt.Color(255, 255, 255));

        jtxtCustomerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtCustomerIDFocusLost(evt);
            }
        });

        jLabel4.setText("Amount Paid:");

        jtxtAmountPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtAmountPaidFocusLost(evt);
            }
        });

        jtxtPaymentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPaymentIDActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Apartment Name:");

        jtxtApartmentName.setEditable(false);
        jtxtApartmentName.setBackground(new java.awt.Color(204, 204, 204));
        jtxtApartmentName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpanelBank2Layout = new javax.swing.GroupLayout(jpanelBank2);
        jpanelBank2.setLayout(jpanelBank2Layout);
        jpanelBank2Layout.setHorizontalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBank2Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(52, 52, 52)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtxtPaymentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtCustomerID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtAmountPaid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtAprtmentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtAptLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtApartmentName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jpanelBank2Layout.setVerticalGroup(
            jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBank2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtAprtmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtAptLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBank2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtApartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jpanelBank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jpanelBank.setToolTipText("Payment Details");
        jpanelBank.setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel5.setText("Month Paid");

        jLabel1.setText("Mode of Payment:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Arrears/Balance:");

        jtxtArrears.setEditable(false);
        jtxtArrears.setBackground(new java.awt.Color(204, 204, 204));
        jtxtArrears.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtArrears.setForeground(new java.awt.Color(153, 0, 51));
        jtxtArrears.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Rent Payable:");

        jtxtRentPayable.setEditable(false);
        jtxtRentPayable.setBackground(new java.awt.Color(204, 204, 204));
        jtxtRentPayable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBoxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMonthItemStateChanged(evt);
            }
        });
        jComboBoxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMonthActionPerformed(evt);
            }
        });

        jComboBoxPayMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "M-Pesa", "Bank Deposit", "Cheque" }));
        jComboBoxPayMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPayModeActionPerformed(evt);
            }
        });

        jTextFieldDate.setEditable(false);
        jTextFieldDate.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldDate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextFieldDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateActionPerformed(evt);
            }
        });

        jLabel3.setText("Payment Date");

        javax.swing.GroupLayout jpanelBankLayout = new javax.swing.GroupLayout(jpanelBank);
        jpanelBank.setLayout(jpanelBankLayout);
        jpanelBankLayout.setHorizontalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 51, Short.MAX_VALUE)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxMonth, 0, 183, Short.MAX_VALUE)
                    .addComponent(jtxtArrears, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jComboBoxPayMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtRentPayable, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jTextFieldDate))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jpanelBankLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxMonth, jComboBoxPayMode, jtxtArrears, jtxtRentPayable});

        jpanelBankLayout.setVerticalGroup(
            jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPayMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jtxtRentPayable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jtxtArrears, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxMonth.getAccessibleContext().setAccessibleParent(this);
        jComboBoxPayMode.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelBank2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpanelBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpanelBank2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanelBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jpanelBank2.getAccessibleContext().setAccessibleName("Payment  Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 0, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(153, 0, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("_________ Payments Details Entry________");

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 51, 102));
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Close-01.png"))); // NOI18N
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        jLabelClose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelCloseKeyPressed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelClose))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonMin)
                        .addComponent(jLabelClose)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modify Payments"));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButtonSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jTextFieldOwnerID.setEditable(false);
        jTextFieldOwnerID.setForeground(new java.awt.Color(240, 240, 240));

        jButtonDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jTextFieldOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelete, jButtonExit, jButtonSave});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDelete)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonDelete, jButtonExit, jButtonSave});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Payments().setVisible(true);
        
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        //check and saves data
        do{
        try{
            rSave = stSave.executeQuery(SQLPayments);
            
            rSave.moveToInsertRow();
            AmountPaid=jtxtAmountPaid.getText();
            CustomerID=jtxtCustomerID.getText();
            PayMode= modeOfPay;
            PayPeriod = month;
            System.out.print(month+modeOfPay+currentTimestamp);
            ApartmentID=jtxtAprtmentID.getText();
            PaymentDetails=jtxtAptLocation.getText();
            PaymentID=jtxtPaymentID.getText();
            PaymentType=jtxtApartmentName.getText();
            PaymentOwner = jTextFieldOwnerID.getText();
            //get Commsion and owners details
           
            String SQLGetOwners1 = "select * from apartments where apartments.apartment_id = '"+ApartmentID+"'";
             
            rsCollectionUpdate = stCollectionUpdate.executeQuery(SQLGetOwners1);
            while(rsCollectionUpdate.next()){
            strOwnerIDFinal = rsCollectionUpdate.getString("owner_id");
            System.out.println(strOwnerIDFinal);
            }
            
            String SQLGetOwners2 = "select * from owners where owners. owner_id = '"+strOwnerIDFinal+"'";
            
            rsCollectionUpdate = stUpdateComm.executeQuery(SQLGetOwners2);
            while(rsCollectionUpdate.next()){
            strOwnerIDFinal = rsCollectionUpdate.getString("owner_id");
            strFinalAmt = rsCollectionUpdate.getString("total_collection");
            agentCommission = rsCollectionUpdate.getString("percentage_commission");
   
            System.out.println(agentCommission);
            }
            
            
            commission  = Double.parseDouble(agentCommission);
            Double dAmtPaid = Double.parseDouble(AmountPaid);
            totalComm = ((commission * dAmtPaid)/100);
            
            //First: insertion  on payments table
            stSave.execute("INSERT INTO housing.payments values('" + PaymentID + "','"+ApartmentID +
                   "','"+CustomerID+"','"+PaymentDetails+"','"+PayMode+"','"+currentTimestamp+"','"+AmountPaid+"','"+PayPeriod+"','"+rentDifference+"','"+PaymentOwner+"','"+commission+"','"+totalComm+"')");
           
            //Second: Get updated arears sum from payments table for specific customer
           SQLRecon = "select sum(arrears) from payments where customer_id ='"+jtxtCustomerID.getText()+"'";
            
            rsRecon = stRecon.executeQuery(SQLRecon);
            while(rsRecon.next()){
            totalArrears = rsRecon.getString("sum(arrears)");
            System.out.println(totalArrears);
            }
            //Third: Update the customers table with Total arrears from Payments Table
            stRecon.executeUpdate("Update customers set Total_Arrears = '"+totalArrears+"' where customer_id ='"+CustomerID+"'");
            
            //Fourth: Get the total amount for specific customer from payments and then store sum in Total_Arrears
            SQLGetCollection = "select payments.customer_id, payments.apartment_id,payments.owner_id, sum(Amount) from payments inner join customers on customers.customer_id where customers.apartment_id=payments.apartment_id and  customers.customer_id= '"+CustomerID+"'";
            rsCollection = stCollection.executeQuery(SQLGetCollection);
            while(rsCollection.next()){
            strCustomerID = rsCollection.getString("customer_id");
            strApartmentID = rsCollection.getString("apartment_id");
            strOwnerID = rsCollection.getString("owner_id");
            strSum = rsCollection.getString("sum(Amount)");
   
            System.out.println(strSum);
            }
            stCollection.executeUpdate("Update owners set total_collection = '"+strSum+"' where owners.owner_id ='"+strOwnerID+"'");
           
            FinalAmt = Double.parseDouble(strSum);
            getComission = Double.parseDouble(agentCommission);
            
            TotalCommision = ((getComission*FinalAmt)/100);
            
            double fTotalCommision = Double.valueOf(decimalFormattter.format(TotalCommision));
            
            //get amt from payments then add to amt in total collection...
            stCollectionUpdate.executeUpdate("Update owners set total_collection = '"+FinalAmt+"',total_commission='"+fTotalCommision+"' where owner_id ='"+strOwnerID+"'");
            
            //group by id sum should work
            JOptionPane.showMessageDialog(rootPane, "Payment Added successfully","Rent Payment Success",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new Payments().setVisible(true);
            

        }
        catch(SQLException e){
          JOptionPane.showMessageDialog(rootPane,"Incorect Value Entered. Please exit and try again" , "Rent Payment Error",JOptionPane.ERROR_MESSAGE);
          Payments.getPayements().setVisible(true);
          this.dispose();
          e.printStackTrace();
        }
        
        }while (x==1);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComboBoxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMonthItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
           month = jComboBoxMonth.getSelectedItem().toString();
           System.out.print(month);
        }
        
    
    }//GEN-LAST:event_jComboBoxMonthItemStateChanged

    private void jtxtAmountPaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtAmountPaidFocusLost
        // TODO add your handling code here:
        custID = jtxtCustomerID.getText();
        System.out.println("first name:"+custID);
        if(jtxtAmountPaid.getText().isEmpty()){
             
            int ok=JOptionPane.showConfirmDialog(rootPane,"Incorect Value Entered. Please exit and try again" , "Rent Payment",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE);
            jtxtAmountPaid.requestFocusInWindow();
            jtxtAmountPaid.grabFocus();
        }
        else
        {
        try {
            // searches and Desplays customer details;
            String payCustID = custID; 
            String custCustID = custID;
            System.out.println("Cust ID is "+custCustID);
            System.out.println("Pay ID is "+payCustID);
            
            //con = DriverManager.getConnection("jdbc:mysql://localhost/housing?autoReconnect=true&useSSL=true","root","prof1989*");
            stCustomer = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stPayments = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stGetApartmentName = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stGetOwners = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            rs2 = stCustomer.executeQuery("select * from customers where customers.customer_id = '"+custCustID+"'");
            System.out.println("rs:"+rs2+"\n");
            
            while(rs2.next()){
            String rate;
            rate = rs2.getString("rate");
            strTempAptID = rs2.getString("apartment_id");
            strTempOwner = rs2.getString("owner_id");
            jtxtRentPayable.setText(rate);
            System.out.println(rate);
            int rentRate,amtPaid;
            String amountPaid =  jtxtAmountPaid.getText();
            amtPaid = Integer.parseInt(amountPaid);
            rentRate = Integer.parseInt(rate);
            rentDifference = rentRate-amtPaid;
            
            jtxtArrears.setText(Double.toString(rentDifference));
            x =2;
            }
                       
            rsArrears = stPayments.executeQuery("select * from payments where payments.customer_id ='"+payCustID+"'");
            
            while(rsArrears.next()){
                jTextFieldOwnerID.setText(strTempOwner);
                jtxtAprtmentID.setText(strTempAptID);
                System.out.println("ID is:"+strTempOwner);
            }
            
            String sqlGetName = "Select * from apartments where owner_id='"+strTempOwner+"'";
            rsGetApartmentName = stGetApartmentName.executeQuery(sqlGetName);
            while(rsGetApartmentName.next()){
               String aptName = rsGetApartmentName.getString("apartment_name");
               String aptLoc =  rsGetApartmentName.getString("location_id");
               jtxtAptLocation.setText(aptLoc);
               jtxtApartmentName.setText(aptName);
            }
            
            if (rentDifference <0)
            {
                JOptionPane.showMessageDialog(null, "Rent overpayment Please check!", "Rent Payment", JOptionPane.INFORMATION_MESSAGE);
                
            }
            else if(rentDifference>0){
                JOptionPane.showMessageDialog(null, "Rent underpayment Please check!", "Rent Payment", JOptionPane.INFORMATION_MESSAGE); 
            }
            else{
                JOptionPane.showMessageDialog(null, "Rent amount is ok!", "Rent Payment", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
            String SQLGetOwners = "select * from owners where owner_id='"+strTempOwner+"'";
            rsOwners = stGetOwners.executeQuery(SQLGetOwners);
            while(rsOwners.next()){
                
            }
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Something went wrong.Please try again.","Data Entry",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Payments.getPayements().setVisible(true);    

         } 
            
        }
    
    }//GEN-LAST:event_jtxtAmountPaidFocusLost

    private void jtxtPaymentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPaymentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPaymentIDActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Payments.getPayements().setVisible(true);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelCloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelCloseKeyPressed
        // TODO add your handling code here:
        this.dispose();
        Payments.getPayements().setVisible(true);
    }//GEN-LAST:event_jLabelCloseKeyPressed

    private void jtxtCustomerIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCustomerIDFocusLost
        try {
            //Gets owner ID and apartment ID
            String tempCustID = jtxtCustomerID.getText();
            SQLGetCustomers = "select * from customers where customer_id='"+tempCustID+"'";
          
            rsGetCustomer  = stGetCustomer.executeQuery(SQLGetCustomers);
            if(rsGetCustomer.equals(null)){
                JOptionPane.showMessageDialog(rootPane,"Incorect Customer ID. Try another ID or Register customer" , "Customer Search",JOptionPane.ERROR_MESSAGE);
            }
            else
            while(rsGetCustomer.next()){
                //strCustID =  rsGetCustomer.getString("customer_id");
                strAptID = rsGetCustomer.getString("apartment_id");
                strOwnID = rsGetCustomer.getString("owner_id");
                jtxtAprtmentID.setText(strAptID);
                jTextFieldOwnerID.setText(strOwnID);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtxtCustomerIDFocusLost

    private void jTextFieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // Deletes Owner completely from Database;
        try {
                
                String PayID;
          
                PayID = jtxtPaymentID.getText();

                String DelPay="delete from payments where payment_id = '"+PayID+"'";
                  //delete from customers where customer_id='78 ';                       
                pstmt = con.prepareStatement(DelPay);
                pstmt.executeUpdate();
               // int i=pstmt.executeUpdate();
                
               
                JOptionPane.showMessageDialog(rootPane, "Record has been Deleted successfully!\n"+"Proceed to delete another payment","Payments  Details",JOptionPane.INFORMATION_MESSAGE);  
                new Payments().setVisible(true);
                
                jtxtAmountPaid.setText(null);
                jtxtAprtmentID.setText(null);
                jtxtArrears.setText(null);
                jtxtCustomerID.setText(null);
                jtxtPaymentID.setText(null);  
                jtxtRentPayable.setText(null);
                jtxtApartmentName.setText(null);
                jTextFieldDate.setText(null);
                jtxtArrears.setText(null);
                
                
                this.dispose();
               pstmt.close();

            } catch ( SQLException ex) {
                new Payments().setVisible(true);
                JOptionPane.showMessageDialog(rootPane, "Record has been Deleted successfully!\n"+"Proceed to delete another payment","Payment's  Details",JOptionPane.INFORMATION_MESSAGE);  
                ex.printStackTrace();
                jtxtAmountPaid.setText(null);
                jtxtAprtmentID.setText(null);
                jtxtArrears.setText(null);
                jtxtCustomerID.setText(null);
                jtxtPaymentID.setText(null);  
                jtxtRentPayable.setText(null);
                jtxtApartmentName.setText(null);
                jTextFieldDate.setText(null);
                jtxtArrears.setText(null);
            }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMonthActionPerformed
        // Assign valaue to the jcomboBox
      month = jComboBoxMonth.getSelectedItem().toString();
      
    }//GEN-LAST:event_jComboBoxMonthActionPerformed

    private void jComboBoxPayModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPayModeActionPerformed
        // Assigns value for mode of pay.
         modeOfPay  =(String) jComboBoxPayMode.getSelectedItem();
      
         
    }//GEN-LAST:event_jComboBoxPayModeActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new AdminPayments().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonDelete;
    public javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMin;
    public javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxMonth;
    private javax.swing.JComboBox<String> jComboBoxPayMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldOwnerID;
    private javax.swing.JPanel jpanelBank;
    private javax.swing.JPanel jpanelBank2;
    public javax.swing.JTextField jtxtAmountPaid;
    public javax.swing.JTextField jtxtApartmentName;
    public javax.swing.JTextField jtxtAprtmentID;
    public javax.swing.JTextField jtxtAptLocation;
    public javax.swing.JTextField jtxtArrears;
    public javax.swing.JTextField jtxtCustomerID;
    public javax.swing.JTextField jtxtPaymentID;
    public javax.swing.JTextField jtxtRentPayable;
    // End of variables declaration//GEN-END:variables
}
