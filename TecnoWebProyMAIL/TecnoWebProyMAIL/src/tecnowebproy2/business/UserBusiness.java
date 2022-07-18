/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnowebproy2.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import tecnowebproy2.data.database;

/**
 *
 * @author USUARIO
 */
public class UserBusiness {
    database db = new database();
    Scanner reader = new Scanner(System.in);
    int id = 0;
    String params = "";
    String command = "";
    Boolean badParams = false;
    ArrayList<String> paramsList = new ArrayList<String>();
    
    public UserBusiness(){
       try {
            db.connect();
        } 
        catch (SQLException e) {
              System.out.println(e.getMessage());
        }
    }
    
    public void loadParams(){
        String pal = this.params.replaceAll(", ","");
// ["users", "name", "carlitos"]        
        this.paramsList.clear();
        int i = 0;
        String wordParam= "";
        Boolean completeParam = false;
        
        while(i < pal.length()){
            
            if (pal.charAt(i) == '"') {
                if (completeParam) {
                    this.paramsList.add(wordParam);
                    wordParam = "";
                    completeParam = false;
                }else{  
                    completeParam = true;
                }
            }
            else{
                wordParam+= pal.charAt(i);
            }
            i++;
        }
        
//        for (int j = 0; j < this.paramsList.size(); j++) {
//            System.out.println(this.paramsList.get(j));
//        }
    }
    
    
    
    public void separeParamsAndCommand(String subject){
        try{
            int pos = subject.indexOf('[');
            this.command = subject.substring(0,pos-1).trim();
            this.params = subject.substring(pos+1, subject.length()-1).trim();
            this.loadParams();
            
//            System.out.println("--"+this.command+"--");
//            System.out.println("--"+this.params+"--");
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
    
    public void showResult(String res, int ParamAmount){
        if (this.paramsList.size() == ParamAmount) {
            System.out.println(res);
        }else{
            System.out.println("tienen que haber un total de "+ParamAmount+" parametros y hay "+ this.paramsList.size());
        }
    }
    
    public void searchCommand(String subject){
        
        this.separeParamsAndCommand(subject);
        
        switch(command.toUpperCase()){
            case "CU1-1":
               System.out.println(db.selectAllofTable("users"));           
            break;
            case "CU1-2":
                if (this.paramsList.size() == 1) {
                    System.out.println(db.getById("users", this.paramsList.get(0)));
                }else{
                    System.out.println("tienen que haber un total de "+1+" parametros y hay "+ this.paramsList.size());
                }       
            break;
            case "CU1-3": 
                if (this.paramsList.size() == 2) {
                    System.out.println(db.updateElementofTable("users", Integer.parseInt(this.paramsList.get(0)), "email", this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                
            break;
            case "CU1-4":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.updateElementofTable("users", Integer.parseInt(this.paramsList.get(0)), "name", this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                
            break;    
            case "CU1-5":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.updateElementofTable("users", Integer.parseInt(this.paramsList.get(0)), "password", this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                
                
            break;
            case "CU1-6":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.updateElementofTable("users", Integer.parseInt(this.paramsList.get(0)), "username", this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                
                this.showResult(db.updateElementofTable("users", Integer.parseInt(this.paramsList.get(0)), "username", this.paramsList.get(1)), 2);                       break;
            case "CU1-7":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.insertUser(this.paramsList.get(0), this.paramsList.get(1), this.paramsList.get(2), this.paramsList.get(3)));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                
            break;
            case "CU1-8":
                if (this.paramsList.size() == 1) {
                    System.out.println(db.deleteById("users", Integer.parseInt(this.paramsList.get(0))));
                }else{
                    System.out.println("tienen que haber un total de "+1+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            //---------------------------------
            case "CU2-1":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.selectDataByElement(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU2-2":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.updateFieldOfTable(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4)));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU2-3":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.updateFieldOfTable(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(1),this.paramsList.get(3)));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU2-4":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.deleteByElement(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            //-----------------
            case "CU3-1":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.getByWord(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),1));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-2":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.updateByWord1(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4)));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-3":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.deleteByWord1(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-4":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.getByWord(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),2));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-5":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.updateByWord2(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4)));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-6":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.deleteByWord2(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-7":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.getByWord(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),3));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-8":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.updateByWord3(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4)));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU3-9":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.deleteByWord3(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            //---------------------------------
            case "CU4-1":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.selectDataByElement(this.paramsList.get(0),"id",this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU4-2":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.updateFieldOfTable(this.paramsList.get(0),"id",this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3)));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU4-3":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.deleteByElement(this.paramsList.get(0),"id",this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            //---------------------------------
            case "CU5-1":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.selectDataByElement(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2)));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU5-2":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.selectDataByTwoElements(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4),"AND"));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU5-3":
                if (this.paramsList.size() == 5) {
                    System.out.println(db.selectDataByTwoElements(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4),"OR"));
                }else{
                    System.out.println("tienen que haber un total de "+5+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU5-4":
                if (this.paramsList.size() == 7) {
                    System.out.println(db.selectDataByThreeElements(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4),this.paramsList.get(5),this.paramsList.get(6),"AND","AND"));
                }else{
                    System.out.println("tienen que haber un total de "+7+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU5-5":
                if (this.paramsList.size() == 7) {
                    System.out.println(db.selectDataByThreeElements(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4),this.paramsList.get(5),this.paramsList.get(6),"OR","OR"));
                }else{
                    System.out.println("tienen que haber un total de "+7+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU5-6":
                if (this.paramsList.size() == 7) {
                    System.out.println(db.selectDataByThreeElements(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),this.paramsList.get(4),this.paramsList.get(5),this.paramsList.get(6),"AND","OR"));
                }else{
                    System.out.println("tienen que haber un total de "+7+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-1":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.selectOrderBy(this.paramsList.get(0),this.paramsList.get(1),"DESC"));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-2":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.selectOrderBy(this.paramsList.get(0),this.paramsList.get(1),"ASC"));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-3":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.selectByJoin(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),"INNER"));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-4":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.selectByJoin(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),"LEFT"));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-5":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.selectByJoin(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),"RIGHT"));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-6":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.selectByJoin(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3),"FULL"));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU6-7":
                if (this.paramsList.size() == 2) {
                    System.out.println(db.selectGroupBy(this.paramsList.get(0),this.paramsList.get(1)));
                }else{
                    System.out.println("tienen que haber un total de "+2+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            //-------------------------
            case "CU7-1":
                if (this.paramsList.size() == 1) {
                    System.out.println(db.selectAllofTable(this.paramsList.get(0)));
                }else{
                    System.out.println("tienen que haber un total de "+1+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU7-2":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.selectDataByDate(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),"<"));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU7-3":
                if (this.paramsList.size() == 3) {
                    System.out.println(db.selectDataByDate(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),">"));
                }else{
                    System.out.println("tienen que haber un total de "+3+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU7-4":
                if (this.paramsList.size() == 4) {
                    System.out.println(db.selectDataByDateBetween(this.paramsList.get(0),this.paramsList.get(1),this.paramsList.get(2),this.paramsList.get(3)));
                }else{
                    System.out.println("tienen que haber un total de "+4+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
           
            case "CU8-1":
                System.out.println(db.tablesQuantity());                        
            break;            
            case "CU8-2":
                if (this.paramsList.size() == 1) {
                    System.out.println(db.rowsQuantity(this.paramsList.get(0)));
                }else{
                    System.out.println("tienen que haber un total de "+1+" parametros y hay "+ this.paramsList.size());
                }                            
            break;
            case "CU8-3":
                System.out.println(db.tablesStats());                        
            break;
            default:
                System.out.println("Ni idea de tu caso de uso choco, revisa la lista, escribiste: "+subject.toUpperCase());
                break;
        }
    }

    
    //public void 
    
}
