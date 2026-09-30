package healthfirstpims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class SalesReports extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SalesReports.class.getName());

    /**
     * Creates new form SalesReports
     */
    public SalesReports() {
        initComponents();
        loadSalesData();
        getContentPane().setBackground(new java.awt.Color(0, 102, 102));
    }
    
    private void calculateTotalSales() {

    double total = 0.0;
    int totalItems = 0;

    // Store invoice numbers so we count each invoice only once
    java.util.HashSet<Integer> invoiceNumbers =
            new java.util.HashSet<>();

    for (int i = 0; i < tblSales.getRowCount(); i++) {

        // ==============================
        // TOTAL ITEMS SOLD
        // ==============================

        Object qtyValue = tblSales.getValueAt(i, 3);

        if (qtyValue != null) {

            try {

                totalItems += Integer.parseInt(
                        qtyValue.toString()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Could not read quantity."
                );
            }
        }


        // ==============================
        // TOTAL SALES
        // ==============================

        Object value = tblSales.getValueAt(i, 5);

        if (value != null) {

            String amount = value.toString()
                    .replace("R", "")
                    .replace(",", ".")
                    .trim();

            if (!amount.isEmpty()) {

                try {

                    total += Double.parseDouble(amount);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Could not read amount: " + amount
                    );
                }
            }
        }


        // ==============================
        // UNIQUE INVOICES
        // ==============================

        Object invoiceValue =
                tblSales.getValueAt(i, 1);

        if (invoiceValue != null) {

            try {

                int invoiceNumber =
                        Integer.parseInt(
                                invoiceValue.toString()
                        );

                invoiceNumbers.add(invoiceNumber);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Could not read invoice number."
                );
            }
        }
    }


    // ==============================
    // DISPLAY TOTAL SALES
    // ==============================

    lblTotalSales.setText(
            String.format(
                    java.util.Locale.US,
                    "Total Sales: R%.2f",
                    total
            )
    );


    // ==============================
    // DISPLAY TOTAL ITEMS
    // ==============================

    lblTotalItems.setText(
            "Total Items Sold: " + totalItems
    );


    // ==============================
    // DISPLAY TOTAL INVOICES
    // ==============================

    lblTotalInvoices.setText(
            "Number of Invoices: "
            + invoiceNumbers.size()
    );
}
    
    private void loadSalesData() {

    DefaultTableModel model =
            (DefaultTableModel) tblSales.getModel();

    // Clear existing rows
    model.setRowCount(0);

    String sql =
            "SELECT s.sale_date, "
          + "s.sale_id, "
          + "m.name, "
          + "si.quantity_sold, "
          + "si.price_at_sale, "
          + "(si.quantity_sold * si.price_at_sale) AS item_total "
          + "FROM sales s "
          + "JOIN sale_items si ON s.sale_id = si.sale_id "
          + "JOIN medicines m ON si.medicine_id = m.medicine_id "
          + "ORDER BY s.sale_date DESC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getTimestamp("sale_date"),
                rs.getInt("sale_id"),
                rs.getString("name"),
                rs.getInt("quantity_sold"),
                String.format("R%.2f",
                        rs.getDouble("price_at_sale")),
                String.format("R%.2f",
                        rs.getDouble("item_total"))
            });
        }

        calculateTotalSales();

    } catch (SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Error loading sales: " + e.getMessage()
        );
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblFromDate = new javax.swing.JLabel();
        txtFromDate = new javax.swing.JTextField();
        lblToDate = new javax.swing.JLabel();
        txtToDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        btnClearShowAll = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new RoundedPanel();
        lblTotalSales = new javax.swing.JLabel();
        lblTotalItems = new javax.swing.JLabel();
        lblTotalInvoices = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("SALES REPORTS");

        lblFromDate.setForeground(new java.awt.Color(255, 255, 255));
        lblFromDate.setText("From Date");

        lblToDate.setForeground(new java.awt.Color(255, 255, 255));
        lblToDate.setText("To Date:");

        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH");
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("PRINT");
        btnPrint.setBorderPainted(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.setFocusPainted(false);
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(this::btnBackActionPerformed);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Invoice", "Medicine", "Qty", "Unit Price", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblSales);

        btnClearShowAll.setForeground(new java.awt.Color(255, 255, 255));
        btnClearShowAll.setText("Clear/Show All");
        btnClearShowAll.setBorderPainted(false);
        btnClearShowAll.setContentAreaFilled(false);
        btnClearShowAll.setFocusPainted(false);
        btnClearShowAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearShowAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearShowAllMouseExited(evt);
            }
        });
        btnClearShowAll.addActionListener(this::btnClearShowAllActionPerformed);

        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setFocusPainted(false);
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRefreshMouseExited(evt);
            }
        });
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTotalSales.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblTotalSales.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSales.setText("Total Sales: R0.00");

        lblTotalItems.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblTotalItems.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalItems.setText("Total Items Sold: 0");

        lblTotalInvoices.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblTotalInvoices.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalInvoices.setText("Number of Invoices: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalSales)
                    .addComponent(lblTotalItems)
                    .addComponent(lblTotalInvoices))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalSales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalInvoices)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFromDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblToDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearShowAll)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrint))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFromDate)
                            .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblToDate)
                            .addComponent(txtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)
                            .addComponent(btnClearShowAll)
                            .addComponent(btnRefresh))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminDashboard dashboard = new AdminDashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String fromText = txtFromDate.getText().trim();
    String toText = txtToDate.getText().trim();

    if (fromText.isEmpty() || toText.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please enter both From Date and To Date."
        );
        return;
    }

    try {

        java.sql.Date fromDate =
                java.sql.Date.valueOf(fromText);

        java.sql.Date toDate =
                java.sql.Date.valueOf(toText);

        DefaultTableModel model =
                (DefaultTableModel) tblSales.getModel();

        model.setRowCount(0);

        String sql =
                "SELECT s.sale_date, "
              + "s.sale_id, "
              + "m.name, "
              + "si.quantity_sold, "
              + "si.price_at_sale, "
              + "(si.quantity_sold * si.price_at_sale) AS item_total "
              + "FROM sales s "
              + "JOIN sale_items si ON s.sale_id = si.sale_id "
              + "JOIN medicines m ON si.medicine_id = m.medicine_id "
              + "WHERE s.sale_date >= ? "
              + "AND s.sale_date < DATE_ADD(?, INTERVAL 1 DAY) "
              + "ORDER BY s.sale_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getTimestamp("sale_date"),
                        rs.getInt("sale_id"),
                        rs.getString("name"),
                        rs.getInt("quantity_sold"),
                        String.format("R%.2f",
                                rs.getDouble("price_at_sale")),
                        String.format("R%.2f",
                                rs.getDouble("item_total"))
                    });
                }
            }

            calculateTotalSales();
        }

    } catch (IllegalArgumentException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid date format.\nPlease use YYYY-MM-DD.\nExample: 2026-09-18"
        );

    } catch (SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Error searching sales: " + e.getMessage()
        );
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
         try {

        boolean complete = tblSales.print(
                javax.swing.JTable.PrintMode.FIT_WIDTH,
                new java.text.MessageFormat("Sales Report"),
                new java.text.MessageFormat("Page {0}")
        );

        if (complete) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Sales report printed successfully."
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Printing was cancelled."
            );
        }

    } catch (java.awt.print.PrinterException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Printing error: " + e.getMessage()
        );
    }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnClearShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearShowAllActionPerformed
        txtFromDate.setText("");
        txtToDate.setText("");
        
        loadSalesData();
    }//GEN-LAST:event_btnClearShowAllActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadSalesData();
        txtFromDate.setText("");
        txtToDate.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setOpaque(true);
        btnBack.setContentAreaFilled(true);
        btnBack.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        btnSearch.setOpaque(true);
        btnSearch.setContentAreaFilled(true);
        btnSearch.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        btnSearch.setOpaque(false);
        btnSearch.setContentAreaFilled(false);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnClearShowAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearShowAllMouseEntered
        btnClearShowAll.setOpaque(true);
        btnClearShowAll.setContentAreaFilled(true);
        btnClearShowAll.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnClearShowAllMouseEntered

    private void btnClearShowAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearShowAllMouseExited
        btnClearShowAll.setOpaque(false);
        btnClearShowAll.setContentAreaFilled(false);
    }//GEN-LAST:event_btnClearShowAllMouseExited

    private void btnRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseEntered
        btnRefresh.setOpaque(true);
        btnRefresh.setContentAreaFilled(true);
        btnRefresh.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnRefreshMouseEntered

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
        btnRefresh.setOpaque(false);
        btnRefresh.setContentAreaFilled(false);
    }//GEN-LAST:event_btnRefreshMouseExited

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        btnPrint.setOpaque(true);
        btnPrint.setContentAreaFilled(true);
        btnPrint.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        btnPrint.setOpaque(false);
        btnPrint.setContentAreaFilled(false);
    }//GEN-LAST:event_btnPrintMouseExited

    /**
     * @param args the command line arguments
     */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SalesReports().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearShowAll;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JLabel lblTotalInvoices;
    private javax.swing.JLabel lblTotalItems;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtFromDate;
    private javax.swing.JTextField txtToDate;
    // End of variables declaration//GEN-END:variables
}
