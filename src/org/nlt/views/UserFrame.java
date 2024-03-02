package org.nlt.views;

import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import org.nlt.model.Users;
import org.nlt.services.EmailServices;

public class UserFrame extends javax.swing.JFrame implements PInterface
{
    public UserFrame() 
    {
        initComponents();
    }
    
    public static void main(String[] args) {
        UserFrame uf=new UserFrame();
        uf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailTextfield = new javax.swing.JTextField();
        createAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel1.setText("ENTER YOUR NAME");
        jPanel1.add(jLabel1);

        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextfield);

        jLabel2.setText("ENTER EMAIL ID");
        jPanel1.add(jLabel2);
        jPanel1.add(emailTextfield);

        createAccountButton.setText("CREATE ACCOUNT");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });
        jPanel1.add(createAccountButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        try 
        {
            String email=emailTextfield.getText();
            String name=nameTextfield.getText();
            
            Users user=new Users();
            user.setCreated(new Date());
            user.setEmail(email);
            user.setName(name);
            user.setModified(new Date());
            
            Random r=new Random();
            int password = r.nextInt(1000000);
            user.setPassword(password+"");
            user.setStatus(1);
            
            ses.beginTransaction();
            ses.save(user);
            ses.getTransaction().commit();
            
            String textMsg="Login Authentication Your Email:"+email+"\n Password:"+password;
            String subject="Login Details:";
            
            String msg="Dear"+name+"Your Password Sent on Email Id \n Please Check Your EmailId for Authentication";
            JOptionPane.showMessageDialog(this, msg, "Account Created", JOptionPane.INFORMATION_MESSAGE);
            new EmailServices().sendMail(email, textMsg, subject);
            loginFrame.setVisible(true);
            this.dispose();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, e, "CA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createAccountButtonActionPerformed

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField emailTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextfield;
    // End of variables declaration//GEN-END:variables
}