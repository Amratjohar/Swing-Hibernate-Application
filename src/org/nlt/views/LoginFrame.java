package org.nlt.views;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.nlt.model.Users;
import org.nlt.services.EmailServices;
import static org.nlt.views.PInterface.ses;

public class LoginFrame extends javax.swing.JFrame implements PInterface
{
    public LoginFrame() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextfield = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        signUpButton = new javax.swing.JButton();
        forgotButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel1.setText("USERNAME");
        jPanel1.add(jLabel1);

        nameTextfield.setText("hehe@gmail.com");
        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextfield);

        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);

        passwordTextfield.setText("442827");
        passwordTextfield.setToolTipText("");
        jPanel1.add(passwordTextfield);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel3.add(loginButton);

        jButton2.setText("RESET");
        jPanel3.add(jButton2);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        signUpButton.setText("SIGNUP");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel2.add(signUpButton);

        forgotButton.setText("FORGOT");
        forgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotButtonActionPerformed(evt);
            }
        });
        jPanel2.add(forgotButton);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        userFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void forgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotButtonActionPerformed
        try 
        {
            String registeredEmail=JOptionPane.showInputDialog("Enter Your Registered Email ID");
            
            Query query =ses.createQuery("from Users where status=1 and email='"+registeredEmail+"'");
            List<Users> list = query.list();

            //means typed email not present in database
            if (list.size()==0)
            {
                JOptionPane.showMessageDialog(this, "This Email ID Not Registered", "LoginFrame", JOptionPane.ERROR_MESSAGE);
            } 
            else
            {
                Users user=list.get(0);
                new EmailServices().sendMail(registeredEmail, "Your Login Password Is:"+user.getPassword(), "Forgot Password");
                JOptionPane.showMessageDialog(this, "Your Password sent On Your Email Id! Please Check Details", "CA", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e, "Frame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_forgotButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try 
        {
            String username=nameTextfield.getText();
            String password=passwordTextfield.getText();
            
            Query query=ses.createQuery("from Users where email='"+username+"' and password='"+password+"'");
            List<Users> userList=query.list();
            
            if (userList.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "LoginFrame", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Users user=userList.get(0);
                //cityFrame.setTitle(user.getName());
                PInterface.setStatesMap();  //will fetch records from db & them into map
                PInterface.setCityMap();    //will fetch records from db & them into map
                PInterface.setPersonMap();  //will fetch records from db & them into map
                personFrame.setTitle(user.getName());
                personFrame.setVisible(true);
                personFrame.setStateComboBox();
                this.dispose();
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e, "LoginFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JPasswordField passwordTextfield;
    private javax.swing.JButton signUpButton;
    // End of variables declaration//GEN-END:variables
}