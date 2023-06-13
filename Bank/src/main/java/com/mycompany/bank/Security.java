/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author hp i5
 */
public class Security {
    public static String encrypt(String data ) {
        String encryptedData = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(data.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i = 0;i<bytes.length;i++){
                s.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
            }
            encryptedData = s.toString();
        } catch(NoSuchAlgorithmException e) {
            System.out.println("Error");
        }
        return encryptedData;
    }
  public boolean allowAccess(String emailV ,String passwordV) throws SQLException{
      boolean answer = false;
      String data = passwordV + emailV;
      String enteredData = Security.encrypt(data);
       try{
          Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","");
          Statement stat = (Statement)con.createStatement();
          String query = "SELECT password FROM class.teachers where email = ' "+emailV+"' ";
          ResultSet rs = stat.executeQuery(query);
          while (rs.next()) { 
              String p = (rs.getString("password")).trim();
              if (p.equals(enteredData)) {
                  answer = true;
              } else {
                 answer = false;
              }
              
         }
          
       }catch(Exception e){
           e.printStackTrace();
       }
     
       return answer;
      
}
}
