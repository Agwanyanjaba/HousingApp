package com.wycliffe.housingAgencyApplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;

/**
 *
 * @author Wycliffe
 */
public class AppModulesLoader extends JFrame  implements ActionListener, PropertyChangeListener
{
        private Task task;
        class Task extends SwingWorker<Void,Void>
{
@Override
  public Void doInBackground()
    {
        Random random = new Random();
        int progress = 0;
         //Initialize progress property.
        setProgress(0);
            while (progress < 100)
            {
            //Sleep for up to one second.
                try
                {
                   Thread.sleep(random.nextInt(1000));
                }
                catch (InterruptedException i)
                {
                    String s = "System Error Occurred ";
                }
                //Make random progress.
                progress += random.nextInt(20);
               
                setProgress(Math.min(progress, 100));
             }

        return null;
        }
    public void done()
    {
        Toolkit.getDefaultToolkit().beep();
        
        setCursor(null); //turn off the wait cursor
        jtaLoader.append("Done!\n");
        
    }
}
    /** Creates new form PayrollLoader */
    public AppModulesLoader()
    {
        initComponents();
        jProgressBarLoader.setValue(0);
        jProgressBarLoader.setStringPainted(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
        setOpacity(0.9f);
        
    }
    public void propertyChange(PropertyChangeEvent evt)
    {
    if ("progress".equals(evt.getPropertyName()))
    {
    int progress = (Integer) evt.getNewValue();
    jProgressBarLoader.setValue(progress);
    jProgressBarLoader.setForeground(Color.green);
    
   
    jtaLoader.append(String.format(
    "\n Completed %d%% of Loading Housing Agency Application Modules....", task.getProgress()));

    }
    if(task.getProgress()==100)
    {
      this.dispose();
      Home.getHome().setVisible(true);
    }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLoader = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLoader = new javax.swing.JTextArea();
        jProgressBarLoader = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jlblLoaderTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));
        setUndecorated(true);

        jPanelLoader.setBackground(new java.awt.Color(73, 74, 155));
        jPanelLoader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 204), null, null));
        jPanelLoader.setToolTipText("Housing App");

        jtaLoader.setBackground(new java.awt.Color(204, 204, 255));
        jtaLoader.setColumns(20);
        jtaLoader.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jtaLoader.setRows(5);
        jtaLoader.setText("Loading please wait...");
        jtaLoader.setBorder(null);
        jScrollPane1.setViewportView(jtaLoader);

        jProgressBarLoader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBarLoader.setForeground(new java.awt.Color(51, 51, 51));
        jProgressBarLoader.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblLoaderTitle.setBackground(new java.awt.Color(153, 0, 153));
        jlblLoaderTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlblLoaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblLoaderTitle.setText("                                 Brightercom Housing Agency");
        jlblLoaderTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblLoaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblLoaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLoaderLayout = new javax.swing.GroupLayout(jPanelLoader);
        jPanelLoader.setLayout(jPanelLoaderLayout);
        jPanelLoaderLayout.setHorizontalGroup(
            jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
            .addGroup(jPanelLoaderLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(jProgressBarLoader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLoaderLayout.setVerticalGroup(
            jPanelLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaderLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBarLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLoader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLoader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(676, 624));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) throws ClassNotFoundException
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            
            public void run()
            {
                new AppModulesLoader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLoader;
    private javax.swing.JProgressBar jProgressBarLoader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblLoaderTitle;
    private javax.swing.JTextArea jtaLoader;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");

    }

   
}
