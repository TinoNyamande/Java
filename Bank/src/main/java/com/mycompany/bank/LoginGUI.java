/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author hp i5
 */
public class LoginGUI {

    static JPanel panel = new JPanel();

    public static JPanel load() {

        
    
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel emailLabel = new JLabel("Email");
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(emailLabel, gbc);

        JTextField email = new JTextField(40);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(email, gbc);

        JLabel passwordLabel = new JLabel("Password");
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField password = new JPasswordField(40);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(password, gbc);

        JButton save = new JButton("Enter");
        save.setBackground(Color.BLUE);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(save, gbc);

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cancel, gbc);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Bank.frame.getContentPane().removeAll();
                Bank.frame.validate();
                Bank.frame.repaint();
                Bank.frame.add(Bank.homePage());
                Bank.frame.revalidate();
                Bank.frame.repaint();

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String enteredEmail = email.getText().trim();
                String enteredPass = "";
                char[] ePass = password.getPassword();
                for(int i = 0;i<ePass.length;i++){
                    enteredPass =enteredPass+ePass[i];
                }
                if (enteredEmail.equals("") | ePass.equals("")) {
                    JOptionPane.showMessageDialog(panel, "Enter valid details");
                } else {
                    try {
                        ArrayList ar = LoginGUI.check(enteredEmail, enteredPass);
                        String access = ar.get(0).toString();
                        String priv = ar.get(1).toString();
                        String change = ar.get(2).toString();
                        String emailSession = ar.get(3).toString();
                        if (access.equals("1")) {
                            Bank.frame.getContentPane().removeAll();
                            Bank.frame.validate();
                            Bank.frame.repaint();
                            GUI.setPriviledge(priv);
                            GUI.setPassword(change);
                            GUI.setEmail(emailSession);
                            
                            if (priv.equals("Admin")&change.equals("yes")) {
         
                                Bank.frame.add(LoggedIn.load(), BorderLayout.LINE_START);
                            } else if (priv.equals("Admin")&change.equals("No"))  {
                                
                                Bank.frame.add(ChangePassword.load(), BorderLayout.LINE_START);
                            } else if (priv.equals("Regular")&change.equals("yes"))  {
                                
                                Bank.frame.add(LoggedInRegular.load(), BorderLayout.LINE_START);
                            } else  {   
                                Bank.frame.add(ChangePassword.load(), BorderLayout.LINE_START);
                            }

                            Bank.frame.revalidate();
                            Bank.frame.repaint();

                        } else {
                            JOptionPane.showMessageDialog(panel, "Incorrect email or password");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(panel, "Error connecting to database");
                    }
                }

            }
        });
        return panel;
    }

    public static ArrayList check(String emailV, String passwordV) throws SQLException {
        String answer = "";
        String pr = "";
        String changed = "";
        String email ="";
        String data = passwordV + emailV;
        String enteredData = Security.encrypt(data);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
        Statement stat = (Statement) con.createStatement();
        String query = "SELECT * FROM bank.users where email = ' " + emailV + "' ";
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            String p = (rs.getString("password")).trim();
            pr = (rs.getString("priviledge")).trim();
            changed = (rs.getString("changed")).trim();
            email = (rs.getString("email")).trim();
            if (p.equals(enteredData)) {
                answer = "1";
            } else {
                answer = "0";
            }

        }

        ArrayList<String> outPut = new ArrayList<>();
        outPut.add(answer);
        outPut.add(pr);
        outPut.add(changed);
        outPut.add(email);
        return outPut;
    }
}
