package ruang;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class kondisikeamanan extends javax.swing.JFrame {
ruang d = new ruang();
int sesuai =0, tidaksesuai=0, hasil;
    public kondisikeamanan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbkokoh = new javax.swing.JCheckBox();
        cbtkokoh = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbada = new javax.swing.JCheckBox();
        cbtada = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cbaman = new javax.swing.JCheckBox();
        cbtaman = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KOndisi Keamanan");

        jLabel2.setText("Apakah Bangunan Anda Masih Kokoh ??");

        cbkokoh.setText("Kokoh");
        cbkokoh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkokohActionPerformed(evt);
            }
        });

        cbtkokoh.setText("Rapuh");
        cbtkokoh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtkokohActionPerformed(evt);
            }
        });

        jLabel3.setText("Apakah Ada Kunci Pintu Dan Jendala ??");

        cbada.setText("Ada");
        cbada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbadaActionPerformed(evt);
            }
        });

        cbtada.setText("Kosong");
        cbtada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtadaActionPerformed(evt);
            }
        });

        jLabel4.setText("Apakah Ruangan Aman ??");

        cbaman.setText("Aman");

        cbtaman.setText("Berbahaya");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbtada)
                            .addComponent(cbtaman)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbkokoh)
                                .addGap(66, 66, 66)
                                .addComponent(cbtkokoh))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(cbaman)
                            .addComponent(cbada)
                            .addComponent(jLabel3))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbkokoh)
                    .addComponent(cbtkokoh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbada)
                    .addComponent(cbtada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbaman)
                    .addComponent(cbtaman))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbkokohActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkokohActionPerformed
     cbtkokoh.setSelected(false);
    }//GEN-LAST:event_cbkokohActionPerformed

    private void cbtkokohActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtkokohActionPerformed
    cbkokoh.setSelected(false);
    }//GEN-LAST:event_cbtkokohActionPerformed

    private void cbadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbadaActionPerformed
    cbtada.setSelected(false);
    }//GEN-LAST:event_cbadaActionPerformed

    private void cbtadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtadaActionPerformed
    cbada.setSelected(false);
    }//GEN-LAST:event_cbtadaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //ruang t=new ruang();
        String kokoh="";
        String pintujendela="";
        String keamanan="";
        if(cbkokoh.isSelected())
           // t.setKekokohan("kokoh");
            kokoh+="Kokoh";
        if(cbtkokoh.isSelected())
            kokoh+="Rapuh";
        if(cbada.isSelected())
            pintujendela+="Ada";
        if(cbtada.isSelected())
            pintujendela+="Kosong";
        if(cbaman.isSelected())
            keamanan+="Aman";
        if(cbtaman.isSelected())
            keamanan+="Bahaya";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/myproject","root","");
            Statement statement=connection.createStatement();
            String sql = "insert into keamanan values('"+kokoh+"','"+pintujendela+"','"+keamanan+"')";
            statement.executeUpdate(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, "tersimpan");
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah"+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(kondisikeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kondisikeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kondisikeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kondisikeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kondisikeamanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbada;
    private javax.swing.JCheckBox cbaman;
    private javax.swing.JCheckBox cbkokoh;
    private javax.swing.JCheckBox cbtada;
    private javax.swing.JCheckBox cbtaman;
    private javax.swing.JCheckBox cbtkokoh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
