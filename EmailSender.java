package com.example.dukedemo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;
import javax.activation.*;
import javax.mail.internet.*;


//final String username = "dukesautoinvoicesender@gmail.com";
//final String password = "pudsdhvmoqarrwer";


public class EmailSender extends Scene2Controller{
    public static void main(String[] args) {

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String date = dateFormat.format(new Date());
        //SendEmail();
        System.out.println(date);
    }

    static void SendEmail() {
        final String username = "dukesautoinvoicesender@gmail.com";
        final String password = "pudsdhvmoqarrwer";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dukesautoinvoicesender@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("azdmcpeak@gmail.com")
            );

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Mail Body");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("put your file path here"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);


            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}





