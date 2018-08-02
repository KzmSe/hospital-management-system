/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.RootUserDaoImpl;
import model.RootUser;

/**
 *
 * @author Kazi_tg54
 */
public class AdminPortal extends javax.swing.JFrame {

    private RootUser currentRootUser;
    private RootUserDaoImpl rootUserDaoImpl = new RootUserDaoImpl();
    
    public AdminPortal() {
        initComponents();
    }

    AdminPortal(RootUser currentRootUser) {
        this();
        this.currentRootUser = currentRootUser;
        customInit();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelPatientDetails = new javax.swing.JLabel();
        jLabelReceptionistDetails = new javax.swing.JLabel();
        jLabelDoctorDetails = new javax.swing.JLabel();
        jLabelIndoorPatients = new javax.swing.JLabel();
        jLabelAppointments = new javax.swing.JLabel();
        jLabelOutdoorPatients = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonProfile = new javax.swing.JButton();
        jLabelLastLoginDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin_icon.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(102, 51, 255));
        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel1.setText("Admin Portal");

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabelPatientDetails.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelPatientDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/patient_details_icon.png"))); // NOI18N
        jLabelPatientDetails.setText("PATIENT DETAILS");
        jLabelPatientDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelPatientDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelPatientDetails.setMaximumSize(new java.awt.Dimension(161, 152));
        jLabelPatientDetails.setMinimumSize(new java.awt.Dimension(161, 152));
        jLabelPatientDetails.setPreferredSize(new java.awt.Dimension(161, 152));
        jLabelPatientDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelPatientDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelPatientDetailsMousePressed(evt);
            }
        });

        jLabelReceptionistDetails.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelReceptionistDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receptionist_details_icon.png"))); // NOI18N
        jLabelReceptionistDetails.setText("RECEPTIONIST DETAILS");
        jLabelReceptionistDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelReceptionistDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelReceptionistDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelReceptionistDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelReceptionistDetailsMousePressed(evt);
            }
        });

        jLabelDoctorDetails.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelDoctorDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/doctor_details_icon.png"))); // NOI18N
        jLabelDoctorDetails.setText("DOCTOR DETAILS");
        jLabelDoctorDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelDoctorDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelDoctorDetails.setMaximumSize(new java.awt.Dimension(161, 152));
        jLabelDoctorDetails.setMinimumSize(new java.awt.Dimension(161, 152));
        jLabelDoctorDetails.setPreferredSize(new java.awt.Dimension(161, 152));
        jLabelDoctorDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelDoctorDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDoctorDetailsMousePressed(evt);
            }
        });

        jLabelIndoorPatients.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelIndoorPatients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/indoor_patients_icon.png"))); // NOI18N
        jLabelIndoorPatients.setText("INDOOR PATIENTS");
        jLabelIndoorPatients.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelIndoorPatients.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelIndoorPatients.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelAppointments.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelAppointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/appoinments_icon.png"))); // NOI18N
        jLabelAppointments.setText("APPOINTMENTS");
        jLabelAppointments.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelAppointments.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelAppointments.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAppointmentsMousePressed(evt);
            }
        });

        jLabelOutdoorPatients.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabelOutdoorPatients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/outdoor_patients_icon.png"))); // NOI18N
        jLabelOutdoorPatients.setText("OUTDOOR PATIENTS");
        jLabelOutdoorPatients.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelOutdoorPatients.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelOutdoorPatients.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPatientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelReceptionistDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIndoorPatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDoctorDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelOutdoorPatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelReceptionistDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDoctorDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIndoorPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOutdoorPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("MV Boli", 1, 26)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("WELCOME to");

        jLabel10.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Admin Portal");

        jButtonProfile.setText("Profile");

        jLabelLastLoginDate.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabelLastLoginDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jButtonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelLastLoginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLastLoginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProfile)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        new LoginAs().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jLabelPatientDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPatientDetailsMousePressed
        String backAction = "adminPortal";
        new PatientDetails(false, true, true, backAction, null).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelPatientDetailsMousePressed

    private void jLabelReceptionistDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReceptionistDetailsMousePressed
        new ReceptionistDetails().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelReceptionistDetailsMousePressed

    private void jLabelDoctorDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoctorDetailsMousePressed
        new DoctorDetails().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelDoctorDetailsMousePressed

    private void jLabelAppointmentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAppointmentsMousePressed
        String backAction = "adminPortal";
        new Appointments(false, true, true, backAction).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelAppointmentsMousePressed

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
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAppointments;
    private javax.swing.JLabel jLabelDoctorDetails;
    private javax.swing.JLabel jLabelIndoorPatients;
    private javax.swing.JLabel jLabelLastLoginDate;
    private javax.swing.JLabel jLabelOutdoorPatients;
    private javax.swing.JLabel jLabelPatientDetails;
    private javax.swing.JLabel jLabelReceptionistDetails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    private void customInit() {
        String lastLoginDate = currentRootUser.getLastLoginDate() == null ? "null" : currentRootUser.getLastLoginDate().toString();
        jLabelLastLoginDate.setText("Your last login date: " + lastLoginDate);
        rootUserDaoImpl.updateLastLoginDate(currentRootUser);
    }
}
