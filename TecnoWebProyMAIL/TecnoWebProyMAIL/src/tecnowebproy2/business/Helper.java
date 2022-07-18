/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnowebproy2.business;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author USUARIO
 */
public class Helper {
    
    public static String toString(ResultSet data)throws SQLException {
       try{
            ResultSetMetaData rsMetaData = data.getMetaData();
            int count = rsMetaData.getColumnCount();
            String response = "\n [ \n ";
            String tab = "  ";
            while(data.next()){
                response += tab+"{ \n";
                for(int i = 1; i<=count; i++) {
                    if (i == count) {
                        response+= tab+tab+" "+rsMetaData.getColumnName(i)+" : "+data.getString(i);
                    }
                    else{
                        response+= tab+tab+" "+rsMetaData.getColumnName(i)+" : "+data.getString(i)+ " ,\n";
                    }     
                }
                response += tab+"\n } \n";    
            }
            
            return response+" ] \n";   
       }
       catch(SQLException error){   
            return error.getMessage();
       }
    }
}
