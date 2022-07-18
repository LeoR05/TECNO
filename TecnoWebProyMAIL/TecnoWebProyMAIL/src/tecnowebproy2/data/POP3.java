package tecnowebproy2.data;

import java.io.*;
import java.net.*;
// TRES CAPAS
// Data
// Business
// Presentation
public class POP3 {

    private static final String Servidor = "mail.tecnoweb.org.bo";
    private static final int Puerto = 110;
//    private static final String Usuario = "grupo01sa";
//    private static final String Contrasenha = "grup001grup001";
    private static final String Usuario = "grupo18sc";
    private static final String Contrasenha = "grup018grup018";
    private static final String SALTO = "\n";
    private String Comando = "";
    private Socket Conexion;
    private BufferedReader Entrada;
    private DataOutputStream Salida;

    public POP3() {
        this.Conexion = null;
        this.Entrada = null;
        this.Salida = null;
    }
    
    public void connect() throws IOException { // NOS CONECTAMOS
        this.Conexion = new Socket(Servidor, Puerto);
        this.Entrada = new BufferedReader(new InputStreamReader(Conexion.getInputStream()));
        this.Salida = new DataOutputStream(Conexion.getOutputStream());
        System.out.println("S:" + this.Entrada.readLine());
    }

    public void close() throws IOException { // CERRAMOS SESION
        this.Conexion.close();
        this.Entrada.close();
        this.Salida.close();
        System.out.println("Conexion cerrada");
    }

    public void logIn() throws IOException { // HACEMOS LOGIN
        Comando = "USER " + Usuario + SALTO;
        this.Salida.writeBytes(Comando);
        this.Entrada.readLine();
        Comando = "PASS " + Contrasenha + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
    }

    public void logOut() throws IOException { // CERRAMOS SESION
        Comando = "QUIT" + SALTO;
        this.Salida.writeBytes(Comando);
        System.out.println("S:" + this.Entrada.readLine());
    }

    public String getList() throws IOException {
        Comando = "LIST" + SALTO;
        this.Salida.writeBytes(Comando);
        return getData(this.Entrada);
    }

    public void delete(String j) throws IOException {
        this.Salida.writeBytes("dele " + j + SALTO);
        System.out.println("S:" + this.Entrada.readLine());
    }

    public String getStat() {
        String line = "";
        try {
            this.Salida.writeBytes("STAT" + SALTO);
            line = this.Entrada.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (line != "") {
            line = line.substring(4);
            int i = 1;
            while (line.charAt(i) != ' ') {
                i++;
            }
            line = line.substring(0, i);
        }
        return line;
    }

    public String getSubject(String Mail) {
        try{
          String mail = getMail(Mail);
//        System.out.println(mail);
        String find = "Subject: ";
        return mail.substring(mail.indexOf(find)+find.length(),mail.indexOf("MIME-Version:")-1);   
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "error correo no hay subject";
        }
    }
    
   

    public String getMail(String mail) throws IOException {
        try{
            Comando = "retr " + mail + SALTO;
            this.Salida.writeBytes(Comando);
            return getData(this.Entrada);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    static protected String getData(BufferedReader buffer) throws IOException { // 
        String Data = "";
        String Line = "";
        while ((Line = buffer.readLine()) != null) {
            //ULTIMA LINEA
            if (Line.equals(".")) {
                break;
            }
            //LINEA COMIENZA CON .
            if ((Line.length() > 0) && (Line.charAt(0) == '.')) {
                Line = Line.substring(1);
            }
            Data = Data + Line + SALTO;
        }
        return Data;
    }
    
}
