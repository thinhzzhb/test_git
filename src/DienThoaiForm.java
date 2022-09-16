
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DienThoai;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HOANG SON
 */
public class DienThoaiForm extends javax.swing.JFrame implements Serializable {
    List<DienThoai> _lstDT;
    DefaultTableModel _model;
    DefaultComboBoxModel _defaultcbx;
    DienThoai dienThoai;

    
    public DienThoaiForm() {
        initComponents();
        _lstDT = new ArrayList<>();
        _model = new DefaultTableModel();
        dienThoai = new DienThoai();
        _model = (DefaultTableModel) tblQLDT.getModel();
        _defaultcbx = new DefaultComboBoxModel();
        hienThiCot();
        fakeDT();
        hienThiLenBang();
        cbx();
    }

    private void fakeDT() {
        _lstDT.add(new DienThoai(1l, "Iphone11", 0, 5000f));
        _lstDT.add(new DienThoai(2l, "SamSung Galaxy S20", 1, 1500f));
        _lstDT.add(new DienThoai(3l, "Iphone12", 0, 5500f));
        _lstDT.add(new DienThoai(4l, "Iphone11 pro", 0, 5000f));
        _lstDT.add(new DienThoai(5l, "SamSung S22 Ultra", 1, 4500f));
    }

    private void hienThiCot() {
        _model.setColumnCount(0);
        _model.addColumn("Id");
        _model.addColumn("Tên");
        _model.addColumn("Hãng");
        _model.addColumn("Giá");
        _model.addColumn("Trạng thái");
    }

    private void hienThiLenBang() {
        _model.setRowCount(0);
        for (DienThoai x : _lstDT) {
            Object row[] = new Object[]{
                x.getId(),
                x.getTenMay(),
                x.getHang() == 0 ? "Iphone" : "SamSung",
                x.getGia(),
                x.getTT()
            };
            _model.addRow(row);
        }
    }

    private void cbx() {
        _defaultcbx.addElement("Iphone");
        _defaultcbx.addElement("SamSung");
        cbxHang.setModel(_defaultcbx);
    }

    private DienThoai getTTJF() {
        return new DienThoai(Long.parseLong(txtID.getText()), txtTen.getText(), cbxHang.getSelectedIndex(), Float.parseFloat(txtGia.getText()));
    }

    private boolean checkKieu(String txt, int kieu) {
        if (kieu == 1) {
            Pattern pattern = Pattern.compile("[-]*\\d+");
            Matcher matcher = pattern.matcher(txt);
            return matcher.matches();
        }
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(txt);
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cbxHang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLDT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý điện thoại");

        jLabel2.setText("ID:");

        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtIDMouseExited(evt);
            }
        });

        jLabel3.setText("Tên:");

        jLabel4.setText("Hãng:");

        jLabel5.setText("Giá:");

        cbxHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHangActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm kiếm:");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        tblQLDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblQLDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLDTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLDT);

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Lưu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Mở");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Tìm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxHang, 0, 116, Short.MAX_VALUE)
                                    .addComponent(txtID)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimKiem)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(43, 43, 43)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(43, 43, 43)
                                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtID.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống ID", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtTen.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống Tên", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtGia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống Giá", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkKieu(txtID.getText(), 1)) {
            JOptionPane.showMessageDialog(this, "Id không phải là kiểu chữ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkKieu(txtGia.getText().replace(".", ""), 1)) {
            JOptionPane.showMessageDialog(this, "Giá không phải là kiểu chữ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Long.parseLong(txtID.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Id không nhỏ hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Float.parseFloat(txtGia.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Giá không nhỏ hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            _lstDT.add(getTTJF());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            hienThiLenBang();
            resertTXT();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resertTXT() {
        txtID.setText("");
        txtTen.setText("");
        cbxHang.setSelectedIndex(0);
        txtGia.setText("");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblQLDT.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần phải chọn vào 1 bản ghi để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String idSTR = tblQLDT.getValueAt(selectedRow, 0).toString();
            Long id = Long.parseLong(idSTR);
            int confirm = JOptionPane.showConfirmDialog(this, "bạn có chắc chắn muốn xóa sản phẩm này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                for (int i = 0; i < _lstDT.size(); i++) {
                    if (_lstDT.get(i).getId() == id) {
                        _lstDT.remove(i);
                    }
                }
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                hienThiLenBang();
                resertTXT();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblQLDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLDTMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblQLDT.getSelectedRow();

        txtID.setText(tblQLDT.getValueAt(selectedRow, 0).toString());
        txtTen.setText(tblQLDT.getValueAt(selectedRow, 1).toString());
        cbxHang.setSelectedIndex(tblQLDT.getValueAt(selectedRow, 2).toString().equals("Iphone") ? 0 : 1);
        txtGia.setText(tblQLDT.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_tblQLDTMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String idstr = txtTimKiem.getText();
        if (idstr.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không thể tìm thấy vì không có id");
            return;
        } else {
            Long id = Long.parseLong(idstr);
            for (int i = 0; i < _lstDT.size(); i++) {
                if (_lstDT.get(i).getId() == id) {
                    txtID.setText(_lstDT.get(i).getId().toString());
                    txtTen.setText(_lstDT.get(i).getTenMay().toString());
                    cbxHang.setSelectedIndex(_lstDT.get(i).getHang());
                    txtGia.setText(_lstDT.get(i).getGia().toString());
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void luuFile() throws IOException {
        FileWriter writer = new FileWriter("baitestJV.txt");
        for (DienThoai x : _lstDT) {
            writer.write(
                    x.getId() + ";"
                    + x.getTenMay() + ";"
                    + x.getHang() + ";"
                    + x.getGia() + "\n"
            );
        }
        writer.close();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            luuFile();
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lưu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void moFile() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("baitestJV.txt");
        BufferedReader br = new BufferedReader(reader);
        _lstDT = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            String arr[] = line.split(";");
            DienThoai dt = new DienThoai(Long.parseLong(arr[0]), arr[1], Integer.parseInt(arr[2]), Float.parseFloat(arr[3]));
            _lstDT.add(dt);
            line = br.readLine();
        }
        br.close();
        reader.close();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            moFile();
            hienThiLenBang();
            JOptionPane.showMessageDialog(this, "Mở thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Mở file thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbxHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHangActionPerformed

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        // TODO add your handling code here:
        txtID.setBackground(Color.blue);
    }//GEN-LAST:event_txtIDMouseClicked

    private void txtIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMouseExited

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DienThoaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DienThoaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DienThoaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DienThoaiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DienThoaiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQLDT;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
