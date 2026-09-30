package healthfirstpims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import healthfirstpims.database.DatabaseConnection;

public class ManageMedicines extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ManageMedicines.class.getName());

    /**
     * Creates new form ManageMedicines
     */
    public ManageMedicines() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0, 102, 102));
        
        
 
        // Click a table row to load it into the form fields.
        tblMedicines.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                fillFieldsFromTable();
            }
        });

        loadMedicines();
        
        styleTextField(txtMedicineId);
        styleTextField(txtMedicineName);
        styleTextField(txtCompany);
        styleTextField(txtMedicineType);
        styleTextField(txtPrice);
        styleTextField(txtQuantity);
        styleTextField(txtReorderLevel);
        styleTextField(txtExpiryDate);
        styleTextField(txtSupplierId); 
    }
    
    private void styleTextField(javax.swing.JTextField field) {
        field.setBackground(new java.awt.Color(235, 235, 235));
        field.setBorder(
        javax.swing.BorderFactory.createLineBorder(
        new java.awt.Color(180, 180, 180),
                1
        )
        );
    }
    
    // DATABASE METHODS
    private void loadMedicines() {

        DefaultTableModel model = (DefaultTableModel) tblMedicines.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM medicines ORDER BY name";
        
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("medicine_id"),
                    rs.getString("name"),
                    rs.getString("company"),
                    rs.getString("medicine_type"),
                    rs.getDouble("price"),
                    rs.getInt("quantity_in_stock"),
                    rs.getInt("reorder_level"),
                    rs.getDate("expiry_date"),
                    rs.getInt("supplier_id")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading medicines: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        txtMedicineId.setText("");
        txtMedicineName.setText("");
        txtCompany.setText("");
        txtMedicineType.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtReorderLevel.setText("");
        txtExpiryDate.setText("");
        txtSupplierId.setText("");
        tblMedicines.clearSelection();
    }

    /** Copies the selected table row into the text fields. */
    private void fillFieldsFromTable() {

        int row = tblMedicines.getSelectedRow();
        if (row < 0) {
            return;
        }
        row = tblMedicines.convertRowIndexToModel(row);

        DefaultTableModel model = (DefaultTableModel) tblMedicines.getModel();

        txtMedicineId.setText(text(model.getValueAt(row, 0)));
        txtMedicineName.setText(text(model.getValueAt(row, 1)));
        txtCompany.setText(text(model.getValueAt(row, 2)));
        txtMedicineType.setText(text(model.getValueAt(row, 3)));
        txtPrice.setText(text(model.getValueAt(row, 4)));
        txtQuantity.setText(text(model.getValueAt(row, 5)));
        txtReorderLevel.setText(text(model.getValueAt(row, 6)));
        txtExpiryDate.setText(text(model.getValueAt(row, 7)));
        txtSupplierId.setText(text(model.getValueAt(row, 8)));
    }

    private String text(Object value) {
        return value == null ? "" : value.toString();
    }
    
    /**
     * Checks the form before it is sent to the database.
     * Returns true when every field holds a usable value.
     */
    private boolean validateFields() {

        if (txtMedicineName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Medicine name is required.",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            txtMedicineName.requestFocus();
            return false;
        }

        try {
            Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number, e.g. 24.50",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            txtPrice.requestFocus();
            return false;
        }

        try {
            Integer.parseInt(txtQuantity.getText().trim());
            Integer.parseInt(txtReorderLevel.getText().trim());
            Integer.parseInt(txtSupplierId.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Quantity, Reorder Level and Supplier ID must be whole numbers.",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            java.sql.Date.valueOf(txtExpiryDate.getText().trim());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                    "Expiry date must use the format yyyy-MM-dd, e.g. 2027-05-30",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            txtExpiryDate.requestFocus();
            return false;
        }

        return true;
    }
    
    /** Fills parameters 1-8, shared by the INSERT and UPDATE statements. */
    private void bindFields(PreparedStatement pst) throws SQLException {
        pst.setString(1, txtMedicineName.getText().trim());
        pst.setString(2, txtCompany.getText().trim());
        pst.setString(3, txtMedicineType.getText().trim());
        pst.setDouble(4, Double.parseDouble(txtPrice.getText().trim()));
        pst.setInt(5, Integer.parseInt(txtQuantity.getText().trim()));
        pst.setInt(6, Integer.parseInt(txtReorderLevel.getText().trim()));
        pst.setDate(7, java.sql.Date.valueOf(txtExpiryDate.getText().trim()));
        pst.setInt(8, Integer.parseInt(txtSupplierId.getText().trim()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel();
        btnBack = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicines = new javax.swing.JTable();
        jPanel3 = new RoundedPanel();
        lblMedicineId = new javax.swing.JLabel();
        txtMedicineId = new javax.swing.JTextField();
        lblMedicineName = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        txtMedicineName = new javax.swing.JTextField();
        txtCompany = new javax.swing.JTextField();
        lblMedicineType = new javax.swing.JLabel();
        txtMedicineType = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblRecorderLevel = new javax.swing.JLabel();
        txtReorderLevel = new javax.swing.JTextField();
        lblExpiryDate = new javax.swing.JLabel();
        txtExpiryDate = new javax.swing.JTextField();
        lblSupplierId = new javax.swing.JLabel();
        txtSupplierId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(0, 102, 102));
        btnAdd.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnClear.setBackground(new java.awt.Color(0, 102, 102));
        btnClear.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnDelete.setBackground(new java.awt.Color(0, 102, 102));
        btnDelete.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel1.setText("Add item");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setText("Update item");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel3.setText("Clear item");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel4.setText("Delete item");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("< ");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MANAGE MEDICINES");

        tblMedicines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Medicine ID", "Name", "Company", "Medicine Type", "Price", "Quantity", "Recorder Level", "Expiry Date", "Supplier ID"
            }
        ));
        jScrollPane1.setViewportView(tblMedicines);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(330, 330, 330))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        lblMedicineId.setForeground(new java.awt.Color(255, 255, 255));
        lblMedicineId.setText("Medicine ID:");

        txtMedicineId.setBackground(new java.awt.Color(204, 204, 204));

        lblMedicineName.setForeground(new java.awt.Color(255, 255, 255));
        lblMedicineName.setText("Medicine Name:");

        lblCompany.setForeground(new java.awt.Color(255, 255, 255));
        lblCompany.setText("Company:");

        txtMedicineName.setBackground(new java.awt.Color(204, 204, 204));

        txtCompany.setBackground(new java.awt.Color(204, 204, 204));

        lblMedicineType.setForeground(new java.awt.Color(255, 255, 255));
        lblMedicineType.setText("Medicine Type:");

        txtMedicineType.setBackground(new java.awt.Color(204, 204, 204));

        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("Price:");

        txtPrice.setBackground(new java.awt.Color(204, 204, 204));

        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity in Stock:");

        txtQuantity.setBackground(new java.awt.Color(204, 204, 204));

        lblRecorderLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblRecorderLevel.setText("Record Level:");

        txtReorderLevel.setBackground(new java.awt.Color(204, 204, 204));

        lblExpiryDate.setForeground(new java.awt.Color(255, 255, 255));
        lblExpiryDate.setText("Expiry Date:");

        txtExpiryDate.setBackground(new java.awt.Color(204, 204, 204));

        lblSupplierId.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierId.setText("Supplier ID:");

        txtSupplierId.setBackground(new java.awt.Color(204, 204, 204));
        txtSupplierId.addActionListener(this::txtSupplierIdActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMedicineId)
                    .addComponent(lblMedicineName)
                    .addComponent(lblCompany)
                    .addComponent(lblMedicineType)
                    .addComponent(lblPrice)
                    .addComponent(lblQuantity)
                    .addComponent(lblRecorderLevel)
                    .addComponent(lblExpiryDate)
                    .addComponent(lblSupplierId))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMedicineId, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(txtMedicineName)
                    .addComponent(txtCompany)
                    .addComponent(txtPrice)
                    .addComponent(txtMedicineType)
                    .addComponent(txtQuantity)
                    .addComponent(txtReorderLevel)
                    .addComponent(txtExpiryDate)
                    .addComponent(txtSupplierId))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMedicineId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedicineId))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMedicineName)
                    .addComponent(txtMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompany)
                    .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMedicineType)
                    .addComponent(txtMedicineType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRecorderLevel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpiryDate))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplierId)
                    .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(863, 863, 863))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(126, 126, 126))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       
    

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminDashboard dashboard = new AdminDashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtMedicineId.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Select a medicine from the table first.",
            "No Selection",
            JOptionPane.WARNING_MESSAGE
    );

    return;
}
    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Delete \"" + txtMedicineName.getText() + "\" permanently?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "DELETE FROM medicines WHERE medicine_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(
                1,
                Integer.parseInt(txtMedicineId.getText().trim())
            );

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                "Medicine deleted successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );

            clearFields();
            loadMedicines();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                this,
                "Could not delete this medicine. It may already be linked to a sale.\n\n"
                + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         if (txtMedicineId.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Select a medicine from the table first.",
                "No Selection",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    if (!validateFields()) {
        return;
    }

    String sql = "UPDATE medicines SET "
            + "name = ?, "
            + "company = ?, "
            + "medicine_type = ?, "
            + "price = ?, "
            + "quantity_in_stock = ?, "
            + "reorder_level = ?, "
            + "expiry_date = ?, "
            + "supplier_id = ? "
            + "WHERE medicine_id = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        bindFields(pst);

        pst.setInt(
                9,
                Integer.parseInt(txtMedicineId.getText().trim())
        );

        int rows = pst.executeUpdate();

        if (rows > 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Medicine updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            clearFields();
            loadMedicines();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No medicine was updated.",
                    "Update",
                    JOptionPane.WARNING_MESSAGE
            );
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error updating medicine:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         if (!validateFields()) {
        return;
    }

    String sql = "INSERT INTO medicines "
            + "(name, company, medicine_type, price, "
            + "quantity_in_stock, reorder_level, expiry_date, supplier_id) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        bindFields(pst);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                this,
                "Medicine added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearFields();
        loadMedicines();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error adding medicine:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSupplierIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIdActionPerformed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setOpaque(true);
        btnBack.setContentAreaFilled(true);
        btnBack.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
    }//GEN-LAST:event_btnBackMouseExited


     /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
        java.awt.EventQueue.invokeLater(() -> new ManageMedicines().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblMedicineId;
    private javax.swing.JLabel lblMedicineName;
    private javax.swing.JLabel lblMedicineType;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRecorderLevel;
    private javax.swing.JLabel lblSupplierId;
    private javax.swing.JTable tblMedicines;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtMedicineId;
    private javax.swing.JTextField txtMedicineName;
    private javax.swing.JTextField txtMedicineType;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReorderLevel;
    private javax.swing.JTextField txtSupplierId;
    // End of variables declaration//GEN-END:variables
}


