/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnowebproy2.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import tecnowebproy2.business.UserBusiness;
import tecnowebproy2.data.Mailer;
import tecnowebproy2.data.POP3;
import tecnowebproy2.data.SMTP;
import tecnowebproy2.data.database;

/**
 *
 * @author USUARIO
 */
public class TecnoWebProy2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        POP3 pop3_mail = new POP3();
        boolean smtp_condicion = false;
        boolean pop3_condicion = false;
        UserBusiness negocio = new UserBusiness();
        String menu = "--------MENU---------"
                + "\n 1. Enviar correo by SMTP \n"
                + "\n 2. Conectar POP3 \n"
                + "\n 3. Leer POP3 \n"
                + "\n 4. menu \n";
        int key = 0;
        do {
            System.out.println(menu);
            System.out.println("\n ===================== opcion numero: ");
            key = reader.nextInt();

            switch (key) {
                case 1:
                try {
                    System.out.println("porfavor escriba su subject");
                    Scanner leer = new Scanner(System.in);
                    String subject = leer.nextLine().toString();
                    Mailer.enviarMail(subject);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
                break;
                case 2:
                    try {
                    pop3_mail.connect();
                    pop3_mail.logIn();
                    pop3_condicion = true;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 3:
                  if (pop3_condicion) {
                        try {
                            System.out.print("POP3(numero de mail)# ");
                            String Mail = reader.next().toString();
                            String command = pop3_mail.getSubject(Mail).trim();
                            System.out.println("subject: -->"+command+"<--");
                            negocio.searchCommand(command);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Jefe active primero el POP3");
                    }  
                break;
                case 4:
                    System.out.println(menu);
                    break;
                case 0:
                    System.out.println("Nos cheque");
                    break;
                default:
                    System.out.println("ni idea de tu comando choquito, revisa el menu");
                    System.out.println(menu);
                    break;
                  
            }
        } while (key != 0);
    }

}
