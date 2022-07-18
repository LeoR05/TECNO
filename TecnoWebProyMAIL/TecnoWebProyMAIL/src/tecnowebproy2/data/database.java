/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnowebproy2.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import tecnowebproy2.business.Helper;

/**
 *
 * @author USUARIO
 */
public class database {
        Connection con = null;
        final String successMessage = "Database's SUCCESSFUL Message: ";
        final String wrongMessage = "Database's WRONG Message: ";
    
        public void connect() throws SQLException
        {
            try{
                String connectionChain = "jdbc:postgresql://mail.tecnoweb.org.bo:5432/db_grupo18sc";
                con = DriverManager.getConnection(connectionChain, "grupo18sc", "grup018grup018");
                System.out.println(successMessage + "I'm connected :) ");
            }
            catch(SQLException e){
                System.out.println(wrongMessage + "SQL EXCEPTION" + e.getMessage());
            }
        }
        
        public void disconnect() throws SQLException
        {
            if (con != null) { // si existe una conexion
                try{
                    con.close();
                    System.out.println(successMessage + "Connection close");
                }
                catch(SQLException e){
                    System.out.println(wrongMessage + e.getMessage());
                }
            }
        }

        
       
        
        public String selectAllofTable(String tableName) {
            try{         
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName);
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String getById(String tableName,String id){
            try{
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where id = "+ id);
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
       
        public String selectDataByElement(String tableName,String field, String value){
            try{
                String space = "  |  ";
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field+" = '"+ value+"'");
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectDataByDate(String tableName,String field, String value, String indicator){
            try{
                String space = "  |  ";
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field+" "+indicator+" '"+ value+"'");
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String rowsQuantity(String tableName){
            try{
                String space = "  |  ";
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select count(*) from "+tableName);
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String tablesStats(){
            try{
                String space = "  |  ";
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("SELECT * from Information_Schema.Tables where TABLE_TYPE = 'BASE TABLE' and TABLE_SCHEMA = 'public'");
                
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String tablesQuantity(){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("SELECT count(*) from Information_Schema.Tables where TABLE_TYPE = 'BASE TABLE' and TABLE_SCHEMA = 'public'");
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        
        public String selectDataByDateBetween(String tableName,String field, String value1, String value2){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field+" between '"+value1+"' and '"+ value2+"'"); 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectDataByTwoElements(String tableName,String field1, String value1,String field2, String value2, String connector){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field1+" = '"+ value1+"' "+connector+" "+field2+" = '"+value2+"' ");        
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectDataByThreeElements(String tableName,String field1, String value1,String field2, String value2,String field3, String value3, String connector1, String connector2){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field1+" = '"+ value1+"' "+connector1+" "+field2+" = '"+value2+"' "+connector2+" "+ field3+" = '"+value3+"' ");        
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectOrderBy(String tableName,String field, String order){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" order by "+field+" "+order);        
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectGroupBy(String tableName,String field){
            try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName+" group by "+field);        
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String selectByJoin(String tableName1,String id1,String tableName2,String id2, String join){
            try{
             
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("select * from "+tableName1+" "+join+" join "+tableName2+ " on "+tableName1+"."+id1+" = "+tableName2+"."+id2);        
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String updateElementofTable(String tableName, int userId, String field, String value){
            try{
                      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where id = "+userId);
                data.close();
                statement.close();
                return "Actualizacion exitosa";
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String updateFieldOfTable(String tableName, String fieldWhere,String valueWhere, String field, String value){
            try{
                      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" = '"+valueWhere+"'" );
                data.close();
                statement.close();
                return "Actualizacion exitosa";
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String insertUser(String name, String email, String password, String username){
            try{
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("insert into users (name,email,password,username) values ( '"+name+"' , '"+email+"' , '"+password+"' , '"+username+"' );");
                data.close();
                statement.close();
                return "Insercion de usuario exitosa";
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String deleteByElement(String tableName, String field, String value){
            try{
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+ " where "+field+" = '"+value+"'");
                data.close();
                statement.close();
                return "Eliminacion exitosa";
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String deleteById(String tableName, int id){
            try{
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+ " where id = "+id);
                data.close();
                statement.close();
                return "Eliminacion exitosa";
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            } 
        }
        
        public String getByWord(String tableName, String field, String value, int option){
           try{
                
                String response;      
                Statement statement = con.createStatement();
               ResultSet data = statement.executeQuery("select * from "+tableName+" where "+field+" like '"+value+"%'"); 
                
               if (option == 1) {
                   data = statement.executeQuery("select * from "+tableName+" where "+field+" like '%"+value+"'"); 
               }
               else if (option == 2) {
                   data = statement.executeQuery("select * from "+tableName+" where "+field+" like '"+value+"%'"); 
               }
               else if (option == 3) {
                   data = statement.executeQuery("select * from "+tableName+" where "+field+" like '%"+value+"%'"); 
               }
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String deleteByWord(String tableName, String field, String value, int option){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"'"); 
                
                if (option == 1) {
                   data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"'"); 
               }
               else if (option == 2) {
                   data = statement.executeQuery("delete from "+tableName+" where "+field+" like '"+value+"%'"); 
               }
               else if (option == 3) {
                   data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"%'"); 
               }
//                switch(option){
//                    case 1:
//                        data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"'"); 
//                    break;
//                    case 2:
//                        data = statement.executeQuery("delete from "+tableName+" where "+field+" like '"+value+"%'"); 
//                    break;
//                    case 3:
//                        data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"%'"); 
//                    break;
//                } 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String deleteByWord1(String tableName, String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"'"); 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String deleteByWord2(String tableName, String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+" where "+field+" like '"+value+"%'"); 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String deleteByWord3(String tableName, String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("delete from "+tableName+" where "+field+" like '%"+value+"%'"); 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        //ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" = '"+valueWhere+"'" );
        public String updateByWord1(String tableName, String fieldWhere,String valueWhere,String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"'");
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String updateByWord2(String tableName, String fieldWhere,String valueWhere,String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '"+valueWhere+"%'");
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String updateByWord3(String tableName, String fieldWhere,String valueWhere,String field, String value){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"%'");
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        
        public String updateByWord(String tableName, String fieldWhere,String valueWhere,String field, String value, int option){
           try{
                
                String response;      
                Statement statement = con.createStatement();
                ResultSet data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"'");
                
                if (option == 1) {
                   data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"'");
                }
                else if (option == 2) {
                   data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '"+valueWhere+"%'");
                    System.out.println("ejecutando 2");
                }
                else if (option == 3) {
                   data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"%'");
                   System.out.println("ejecutando 2");
                }
                
//                switch(option){
//                    case 1:
//                        data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"'");
//                    break;
//                    case 2:
//                        data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '"+valueWhere+"%'");
//                    break;
//                    case 3:
//                        data = statement.executeQuery("update "+ tableName +" set "+ field +" = '"+ value +"' where "+fieldWhere+" like '%"+valueWhere+"%'");
//                    break;
//                } 
                response =  Helper.toString(data);
                data.close();
                statement.close();
                return response;
            }
            catch(SQLException e){
                    return wrongMessage + e.getMessage();
            }  
        }
        public String execQuery(String pattern) throws SQLException  // ejecutar consulta
        {
            Statement statement = con.createStatement();
            String query = "SELECT * FROM persona where "
                + "per_cod like '%" + pattern + "%'\n"
                + "or per_nom like '%" + pattern + "%'\n"
                + "or per_appm like '%" + pattern + "%'\n"
                + "or per_prof like '%" + pattern + "%'\n"
                + "or per_telf	like '%" + pattern + "%'\n"
                + "or per_cel like '%" + pattern + "%'\n"
                + "or per_email like '%" + pattern + "%'\n"   
                + "or per_dir like '%" + pattern + "%'\n"  
                + "or per_flug like '%" + pattern + "%'\n"  
                + "or per_pass like '%" + pattern + "%'"  
                + ";";
            ResultSet data = statement.executeQuery(query);
         
            String space = " | ";
            String space2= " |   ";
            String response = "\n -------------------------------------------------------------------------------"
                    + "------------------------------------------------------------------------------- \n";
            response+= space2+"per_cod"+space2+"per_nom"+space2+"per_appm"+space2+"per_prof"+space2+"per_telf"+space2
                    +"per_cel"+space2+"per_email"+space2+"per_dir"+space2+"per_flug"+space2+"per_pass"+space2;
            response += "\n -------------------------------------------------------------------------------"
                    + "------------------------------------------------------------------------------- \n";
            Boolean found = false;
            while(data.next())
            {
                found = true;
                response+= space + data.getString("per_cod").trim() + space + data.getString("per_nom").trim()
                        + space + data.getString("per_appm").trim()+ space + data.getString("per_prof").trim()
                        + space + data.getString("per_telf").trim()+ space + data.getString("per_cel").trim()
                        + space + data.getString("per_email").trim()+ space + data.getString("per_dir").trim()
                        + space + data.getString("per_flug").trim()+ space + data.getString("per_pass").trim()+ space;
                response += "\n -------------------------------------------------------------------------------"
                    + "------------------------------------------------------------------------------- \n";
            }
            data.close();
            statement.close();
            if (found) {
                return response;
            }
            else{
                return "\n ------------------------------------ \n NO COINCIDE CON EL PATRON "+pattern+"\n ------------------------------------ \n";
            }
        }
               
}
