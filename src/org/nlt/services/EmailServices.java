package org.nlt.services;

//Successfully Execute on 02-May-2016
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

//for mail.jar requires to connect in library
public class EmailServices
{
    //before writing this code copy mail.jar file in lib then
    //link in libray then after open your email id then find security option
    public  void sendMail(String receiver, String text, String subject) {
        String to = receiver;//change accordingly

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return getPasswordAuthonticate();
            }
        });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("amratjohar13@gmail.com"));  //change accordingly  
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            System.out.println("Email Sent Successfully!");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Can not send backup file on email", "Backup", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

    private PasswordAuthentication getPasswordAuthonticate() {
        return new PasswordAuthentication("amratjohar13@gmail.com","nwkkjcsneruorwhq");//change accordingly
                                                                     
    }
    
    public static void main(String[] args) 
    {
        new EmailServices().sendMail("amratjohar13@gmail.com", "Hello Text Content From Sample Mail", "My Subject");
    }
}