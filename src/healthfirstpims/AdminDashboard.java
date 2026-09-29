package healthfirstpims;

public class AdminDashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboard.class.getName());

    // Creates new form AdminDashboard
    public AdminDashboard() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(51, 51, 51));
        btnMedicines.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        btnMedicines.setBorderPainted(false);
        btnMedicines.setFocusPainted(false);
    }

     // This method is called from within the constructor to initialize the form.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnMedicines = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnLowStock = new javax.swing.JButton();
        btnExpiryReport = new javax.swing.JButton();
        btnItemReport = new javax.swing.JButton();
        btnSalesReport = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("MEDICIAL");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("ADMIN ");

        btnLogout.setBackground(new java.awt.Color(255, 51, 51));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnMedicines.setText("Medicines");
        btnMedicines.setToolTipText("");
        btnMedicines.setBorder(null);
        btnMedicines.setBorderPainted(false);
        btnMedicines.setContentAreaFilled(false);
        btnMedicines.setFocusPainted(false);
        btnMedicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMedicinesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMedicinesMouseExited(evt);
            }
        });
        btnMedicines.addActionListener(this::btnMedicinesActionPerformed);

        btnUsers.setText("Users");
        btnUsers.setBorder(null);
        btnUsers.setBorderPainted(false);
        btnUsers.setContentAreaFilled(false);
        btnUsers.setFocusPainted(false);
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsersMouseExited(evt);
            }
        });
        btnUsers.addActionListener(this::btnUsersActionPerformed);

        btnSuppliers.setText("Suppliers");
        btnSuppliers.setBorderPainted(false);
        btnSuppliers.setContentAreaFilled(false);
        btnSuppliers.setFocusPainted(false);
        btnSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuppliersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuppliersMouseExited(evt);
            }
        });
        btnSuppliers.addActionListener(this::btnSuppliersActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Reports");

        btnLowStock.setText("Low Stock ");
        btnLowStock.setBorderPainted(false);
        btnLowStock.setContentAreaFilled(false);
        btnLowStock.setFocusPainted(false);
        btnLowStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLowStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLowStockMouseExited(evt);
            }
        });
        btnLowStock.addActionListener(this::btnLowStockActionPerformed);

        btnExpiryReport.setText("Expiry");
        btnExpiryReport.setBorderPainted(false);
        btnExpiryReport.setContentAreaFilled(false);
        btnExpiryReport.setFocusPainted(false);
        btnExpiryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExpiryReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExpiryReportMouseExited(evt);
            }
        });
        btnExpiryReport.addActionListener(this::btnExpiryReportActionPerformed);

        btnItemReport.setText("Item-Wise ");
        btnItemReport.setBorderPainted(false);
        btnItemReport.setContentAreaFilled(false);
        btnItemReport.setFocusPainted(false);
        btnItemReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnItemReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnItemReportMouseExited(evt);
            }
        });
        btnItemReport.addActionListener(this::btnItemReportActionPerformed);

        btnSalesReport.setText("Sales");
        btnSalesReport.setBorderPainted(false);
        btnSalesReport.setContentAreaFilled(false);
        btnSalesReport.setFocusPainted(false);
        btnSalesReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalesReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalesReportMouseExited(evt);
            }
        });
        btnSalesReport.addActionListener(this::btnSalesReportActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalesReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnItemReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(btnLowStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExpiryReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuppliers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMedicines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnMedicines, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLowStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExpiryReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnItemReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalesReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("24 HOURS SERVICE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        ManageUsers manageUsers = new ManageUsers();
        manageUsers.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new LoginForm().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLowStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLowStockActionPerformed
        LowStockReport report = new LowStockReport();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLowStockActionPerformed

    private void btnExpiryReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpiryReportActionPerformed
        ExpiryReport report = new ExpiryReport();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExpiryReportActionPerformed

    private void btnSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesReportActionPerformed
        SalesReports sales = new SalesReports();
        sales.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalesReportActionPerformed

    private void btnMedicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicinesActionPerformed
        ManageMedicines medicine = new ManageMedicines();
        medicine.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMedicinesActionPerformed

    private void btnItemReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemReportActionPerformed
        ItemsWiseReport report = new ItemsWiseReport();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnItemReportActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppliersActionPerformed
        new ManageSuppliers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnMedicinesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicinesMouseEntered
        btnMedicines.setOpaque(true);
        btnMedicines.setContentAreaFilled(true);
        btnMedicines.setBackground(new java.awt.Color(102, 102, 255));
        
    }//GEN-LAST:event_btnMedicinesMouseEntered

    private void btnMedicinesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicinesMouseExited
        btnMedicines.setOpaque(false);
        btnMedicines.setContentAreaFilled(false);
    }//GEN-LAST:event_btnMedicinesMouseExited

    private void btnUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseEntered
        btnUsers.setOpaque(true);
        btnUsers.setContentAreaFilled(true);
        btnUsers.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_btnUsersMouseEntered

    private void btnUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseExited
        btnUsers.setOpaque(false);
        btnUsers.setContentAreaFilled(false);
    }//GEN-LAST:event_btnUsersMouseExited

    private void btnSuppliersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppliersMouseEntered
        btnSuppliers.setOpaque(true);
        btnSuppliers.setContentAreaFilled(true);
        btnSuppliers.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_btnSuppliersMouseEntered

    private void btnSuppliersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppliersMouseExited
        btnSuppliers.setOpaque(false);
        btnSuppliers.setContentAreaFilled(false);
    }//GEN-LAST:event_btnSuppliersMouseExited

    private void btnLowStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLowStockMouseEntered
        btnLowStock.setOpaque(true);
        btnLowStock.setContentAreaFilled(true);
        btnLowStock.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_btnLowStockMouseEntered

    private void btnLowStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLowStockMouseExited
        btnLowStock.setOpaque(false);
        btnLowStock.setContentAreaFilled(false);
    }//GEN-LAST:event_btnLowStockMouseExited

    private void btnExpiryReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpiryReportMouseEntered
        btnExpiryReport.setOpaque(true);
        btnExpiryReport.setContentAreaFilled(true);
        btnExpiryReport.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_btnExpiryReportMouseEntered

    private void btnExpiryReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpiryReportMouseExited
        btnExpiryReport.setOpaque(false);
        btnExpiryReport.setContentAreaFilled(false);
    }//GEN-LAST:event_btnExpiryReportMouseExited

    private void btnItemReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnItemReportMouseEntered
        btnItemReport.setOpaque(true);
        btnItemReport.setContentAreaFilled(true);
        btnItemReport.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_btnItemReportMouseEntered

    private void btnItemReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnItemReportMouseExited
        btnItemReport.setOpaque(false);
        btnItemReport.setContentAreaFilled(false);
    }//GEN-LAST:event_btnItemReportMouseExited

    private void btnSalesReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesReportMouseEntered
        btnSalesReport.setOpaque(true);
        btnSalesReport.setContentAreaFilled(true);
        btnSalesReport.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_btnSalesReportMouseEntered

    private void btnSalesReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesReportMouseExited
       btnSalesReport.setOpaque(false);
        btnSalesReport.setContentAreaFilled(false);
    }//GEN-LAST:event_btnSalesReportMouseExited

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create and display the form 
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpiryReport;
    private javax.swing.JButton btnItemReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLowStock;
    private javax.swing.JButton btnMedicines;
    private javax.swing.JButton btnSalesReport;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JButton btnUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
