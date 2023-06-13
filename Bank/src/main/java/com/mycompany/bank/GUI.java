/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hp i5
 */
public class GUI {
     private static String priv;
     private static String pass;
     private static String email;
    public static void changeView(JFrame f, JPanel p) {
        f.getContentPane().removeAll();
        f.validate();
        f.repaint();
        f.add(GUI.header(),BorderLayout.PAGE_START);
        f.add(p ,BorderLayout.CENTER);
        f.validate();
        f.repaint();
    }
    public static String getPriviledge(){
        return priv;
    }
    public static void setPriviledge(String val){
        priv = val;
    }
    public static String getPassword(){
        return pass;
    }
    public static void setPassword(String s){
        pass = s;
    }
    public static String getEmail(){
        return email;
    }
    public static void setEmail(String s){
        email = s;
    }
    public static JPanel header(){
        JLabel h = new JLabel("XXX bank management application");
        JPanel head = new JPanel();
        head.setBackground(Color.BLUE);
        head.add(h);
        return head;
    }
  
    
}
