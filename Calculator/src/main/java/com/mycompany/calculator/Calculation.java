/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

/**
 *
 * @author hp i5
 */

import java.util.ArrayList;

public class Calculation {
    ArrayList<String> firstOperand = new ArrayList();
    ArrayList<String> secondOperand = new ArrayList();
    String operator ="";
    int operatorPos = 0;
    public void split(String data) {
        
        char [] a = data.toCharArray();
        for (int i=0;i<a.length;i++) {
            if(a[i]=='+'||a[i]=='-'||a[i]=='/'||a[i]=='x'||a[i]=='%') {

               operator = String.valueOf(a[i]);
               operatorPos = i;
            }
        }
        
        for (int j =0;j<operatorPos;j++){
           firstOperand.add(String.valueOf(a[j])); 
        }
         for (int k =operatorPos+1;k<a.length;k++){
           secondOperand.add(String.valueOf(a[k])); 
        }
              
    }
    public static boolean check(String data){
        boolean status = false;
            char [] a = data.toCharArray();
            for (int i=0;i<a.length;i++) {
               if(a[i]=='+'||a[i]=='-'||a[i]=='/'||a[i]=='x'||a[i]=='%'){
                   status = true; 
                } 
    }
            return status;
}
}
