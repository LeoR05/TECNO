/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnowebproy2.data;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USUARIO
 */
public class Mailer {
    
    
    public static void enviarMail(String subject){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        //propiedad.setProperty("mail.smtp.host", "mail.tecnoweb.org.bo");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        //propiedad.setProperty("mail.smtp.port", "25");
        propiedad.setProperty("mail.smtp.auth", "true");
        propiedad.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "lrrifarachi80@gmail.com";
        String contrasena = "pdsnidkraugwtcwe";
        String destinatario = "grupo18sc@tecnoweb.org.bo";
        String asunto = subject;
        String mensaje = ""; 
        
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            System.out.println("Jefe correo enviado");   
            
        } catch (AddressException ex) {
            System.out.println("AddressException "+ex.getMessage());
        } catch (MessagingException ex) {
            System.out.println("MessagingException "+ex.getMessage());
        }
   
    }
}
