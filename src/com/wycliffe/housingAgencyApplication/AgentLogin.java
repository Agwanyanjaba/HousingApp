package com.wycliffe.housingAgencyApplication;
//@author Wycliffe

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AgentLogin extends javax.swing.JFrame
{
    /** Creates new form AdminLogin */
   int xMouse, yMouse;
    public static AgentLogin login = null;
    public static AgentLogin getAgentLogin(){
      if(login==null){
          login =new AgentLogin();
    }  
      return login;
    }
    
    public AgentLogin()
    {
        initComponents();
        jLoginTextField.setHorizontalAlignment(JTextField.RIGHT);
        jLoginPasswordField.setHorizontalAlignment(JTextField.RIGHT);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jlblLoginlUserName = new javax.swing.JLabel();
        jlblPassword = new javax.swing.JLabel();
        jLoginTextField = new javax.swing.JTextField();
        jLoginPasswordField = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLoginOK = new javax.swing.JButton();
        jLoginCancel = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabelSignup = new javax.swing.JLabel();
        jLabelPassReset = new javax.swing.JLabel();
        jpnlLoginBar = new javax.swing.JPanel();
        jlblLoginTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jPanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("User Login"));
        jPanelLogin.setFocusCycleRoot(true);
        jPanelLogin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jlblLoginlUserName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblLoginlUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/User-01.png"))); // NOI18N
        jlblLoginlUserName.setText("Enter Username");

        jlblPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblPassword.setText("Enter Password");

        jLoginTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLoginTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginTextFieldActionPerformed(evt);
            }
        });
        jLoginTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLoginTextFieldKeyPressed(evt);
            }
        });

        jLoginPasswordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLoginPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginPasswordFieldActionPerformed(evt);
            }
        });

        jLoginOK.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLoginOK.setText("Login");
        jLoginOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginOKActionPerformed(evt);
            }
        });

        jLoginCancel.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLoginCancel.setText("Clear");
        jLoginCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginCancelActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/icons/Button Turn Off-01.png"))); // NOI18N
        jButtonExit.setToolTipText("Shutdown Application");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLoginOK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLoginCancel)
                .addGap(41, 41, 41)
                .addComponent(jButtonExit)
                .addGap(74, 74, 74))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonExit, jLoginCancel, jLoginOK});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLoginOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLoginCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonExit, jLoginCancel, jLoginOK});

        jLabelSignup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSignup.setText("Signup Here ");
        jLabelSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignupMouseClicked(evt);
            }
        });

        jLabelPassReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPassReset.setText("Forgot Password");
        jLabelPassReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPassResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblLoginlUserName)
                            .addComponent(jlblPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLoginPasswordField)))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabelSignup)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPassReset))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblLoginlUserName)
                    .addComponent(jLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPassword)
                    .addComponent(jLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSignup)
                    .addComponent(jLabelPassReset)))
        );

        jpnlLoginBar.setBackground(new java.awt.Color(153, 0, 153));
        jpnlLoginBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblLoginTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jlblLoginTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblLoginTitle.setText("Brightercom Housing Agency");
        jlblLoginTitle.setToolTipText("Brightercom Housing Agency");

        javax.swing.GroupLayout jpnlLoginBarLayout = new javax.swing.GroupLayout(jpnlLoginBar);
        jpnlLoginBar.setLayout(jpnlLoginBarLayout);
        jpnlLoginBarLayout.setHorizontalGroup(
            jpnlLoginBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlLoginBarLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jlblLoginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jpnlLoginBarLayout.setVerticalGroup(
            jpnlLoginBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlLoginBarLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jlblLoginTitle)
                .addGap(31, 31, 31))
        );

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jLabel7.setBackground(new java.awt.Color(204, 0, 0));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Brightercom Housing Agency system                                                                              P.O Box 2222-60999, Nairobi-Kenya; E-Mail:brithercom@gmail.com");
        jLabel7.setToolTipText("Bank Payment details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlLoginBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlLoginBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLoginTextFieldActionPerformed

    private void jLoginOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginOKActionPerformed

  if (evt.getSource() == jLoginOK)
  {
  try {
    Connection conn = null;
    String userName = "root";
    String password = "prof1989*";
    Class.forName ("com.mysql.jdbc.Driver").newInstance();
    String url = "jdbc:mysql://localhost:3306/housing?useSSL=true";
    conn = (Connection) DriverManager.getConnection (url, userName, password);
    String userPassword;
    userPassword= Arrays.toString(jLoginPasswordField.getPassword());
    try {
        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username='" + jLoginTextField.getText() +
                "' and password='" +userPassword+ "'");

        String uname="",pass="";
        System.out.print("resultset is"+rs+"\n");
        if (rs.next())
        {
            uname=rs.getString("username");
            pass=rs.getString("password");
            
            System.out.print("Passwors is:\n"+pass);

            if (uname.equals(uname) && pass.equals(pass))
            {
             JOptionPane.showMessageDialog( null, "LOGIN IS SUCCESSFUL","User Login",JOptionPane.INFORMATION_MESSAGE);
             jLoginTextField.setText(null);
             jLoginPasswordField.setText(null);
             new AppModulesLoader().setVisible(true);
             this.dispose();
            }
            else
             {
                new AgentLogin().setVisible(true);
             }
        }
        else
        {
         JOptionPane.showMessageDialog(null,"Invalid username or password","User Login",JOptionPane.ERROR_MESSAGE);
            System.out.println("pass is:"+userPassword);
            jLoginTextField.setText(null);
            jLoginPasswordField.setText(null);
        }
        conn.close();
        } 
    catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "User Login", JOptionPane.ERROR_MESSAGE);
            System.out.println("pass is:"+userPassword);
            jLoginTextField.setText("");
            jLoginPasswordField.setText("");
        }//inner try catch closed
    }
    catch (Exception x)
    {
        JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", JOptionPane.ERROR_MESSAGE);
    }//outer try catch closed
}//if closed

   
   
    }//GEN-LAST:event_jLoginOKActionPerformed

    private void jLoginCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginCancelActionPerformed
        // TODO add your handling code here:
        jLoginTextField.setText(null);
        jLoginPasswordField.setText(null);
        
    }//GEN-LAST:event_jLoginCancelActionPerformed

    private void jLoginTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLoginTextFieldKeyPressed
        

    }//GEN-LAST:event_jLoginTextFieldKeyPressed

    private void jLoginPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLoginPasswordFieldActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to shutdown Application?"," Brightercom Application",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jLabelSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignupMouseClicked
        try {
            // Calls signup form
            AgentSignUp.getAgentSignup().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AgentLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSignupMouseClicked

    private void jLabelPassResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPassResetMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Please register as a new user!", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelPassResetMouseClicked

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
     * @throws java.lang.ClassNotFoundException
    */
    public static void main(String args[]) throws ClassNotFoundException
    {
        java.awt.EventQueue.invokeLater(() -> {
            new AgentLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelPassReset;
    private javax.swing.JLabel jLabelSignup;
    private javax.swing.JButton jLoginCancel;
    private javax.swing.JButton jLoginOK;
    private javax.swing.JPasswordField jLoginPasswordField;
    private javax.swing.JTextField jLoginTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JLabel jlblLoginTitle;
    private javax.swing.JLabel jlblLoginlUserName;
    private javax.swing.JLabel jlblPassword;
    private javax.swing.JPanel jpnlLoginBar;
    // End of variables declaration//GEN-END:variables

}
