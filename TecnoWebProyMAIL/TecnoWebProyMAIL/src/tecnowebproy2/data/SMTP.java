package tecnowebproy2.data;

import java.io.*;
import java.net.*;

public class SMTP {

    private static final String Servidor = "mail.tecnoweb.org.bo";
    private static final int Puerto = 25;
    private static final String Emisor = "lrrifarachi80@gmail.com";
    private static final String Receptor = "grupo18sc@tecnoweb.org.bo";
    private String Comando = "";
    private static final String SALTO = "\n";
    private Socket Conexion;
    private BufferedReader Entrada;
    private DataOutputStream Salida;

    public SMTP() {
        this.Conexion = null;
        this.Entrada = null;
        this.Salida = null;
    }

    public void connect() throws IOException {
        this.Conexion = new Socket(Servidor, Puerto);
        this.Entrada = new BufferedReader(new InputStreamReader(Conexion.getInputStream()));
        this.Salida = new DataOutputStream(Conexion.getOutputStream());
        System.out.println("S:" + this.Entrada.readLine());
    }

    public void close() throws IOException {
        this.Conexion.close();
        this.Entrada.close();
        this.Salida.close();
    }

    public void logIn() throws IOException {
        Comando = "HELO " + Servidor + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
    }

    public void logOut() throws IOException {
        Comando = "quit" + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
    }
//public void sendMail(String SUBJECT, String DATA) throws IOException {
    public void sendMail(String SUBJECT) throws IOException {
        Comando = "MAIL FROM: " + Emisor + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
        Comando = "RCPT TO: " + Receptor + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
        Comando = "DATA" + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
        Comando = "SUBJECT: " + SUBJECT + SALTO;
//        this.Salida.writeBytes(Comando);
//        Comando = DATA + SALTO;
//        this.Salida.writeBytes(Comando);
        Comando = "." + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + Entrada.readLine());
    }

}
