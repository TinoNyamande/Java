/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import static com.mycompany.bank.CreateAccountGUI.panel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author hp i5
 */
public class ChangePassword {

    static JPanel panel = new JPanel();

    public static JPanel load() {
        Bank.frame.getContentPane().removeAll();
        Bank.frame.revalidate();
        Bank.frame.repaint();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        Bank.frame.add(GUI.header(),BorderLayout.PAGE_START);
        JLabel head = new JLabel("Resset password");
        JLabel passLabel = new JLabel("Password");
        JPasswordField pass = new JPasswordField(25);
        JLabel cpassLabel = new JLabel(" ConfirmPassword");
        JPasswordField cpass = new JPasswordField(25);
        JButton save = new JButton("Change");
        JButton cancel = new JButton("Cancel");
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        panel.add(head, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(passLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(pass, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cpassLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cpass, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(save, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cancel, gbc);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                char[] pValue = pass.getPassword();
                char[] rPassword = cpass.getPassword();

                if (pValue.length == 0 | rPassword.length == 0) {
                    JOptionPane.showMessageDialog(panel, "Enter all details");
                } else {
                    if (pValue.length == rPassword.length) {
                        String passwordValue = "";
                        for (int i = 0; i < pValue.length; i++) {
                            passwordValue = passwordValue + pValue[i];
                        }
                        String encryptedPass = Security.encrypt(passwordValue + GUI.getEmail());

                        try {
                            int accountNumber = CreateAccountGUI.generateAccountNumber();
                            ChangePassword.save(encryptedPass);
                            JOptionPane.showMessageDialog(panel, "Password changed successfully");
                            GUI.setPassword("yes");
                            Bank.frame.getContentPane().removeAll();
                            Bank.frame.validate();
                            Bank.frame.repaint();
                            if (GUI.getPriviledge().equals("Admin")) {
                                Bank.frame.add(LoggedIn.load(), BorderLayout.LINE_START);
                            } else {
                                Bank.frame.add(LoggedInRegular.load(), BorderLayout.LINE_START);
                            }
                            Bank.frame.revalidate();
                            Bank.frame.repaint();
                        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                            JOptionPane.showMessageDialog(panel, "Enter valid details");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(panel, e);
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel, "Passwords are not matching");
                    }
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Bank.frame.getContentPane().removeAll();
                Bank.frame.validate();
                Bank.frame.repaint();
                if (GUI.getPriviledge().equals("Admin")&GUI.getPassword().equals("yes")) {
                    Bank.frame.add(LoggedIn.load(), BorderLayout.LINE_START);
                } else if (GUI.getPriviledge().equals("Regular")&GUI.getPassword().equals("yes")) {
                    Bank.frame.add(LoggedInRegular.load(), BorderLayout.LINE_START);
                }else  {
                    Bank.frame.add(Bank.homePage(), BorderLayout.CENTER);
                }
                Bank.frame.revalidate();
                Bank.frame.repaint();

            }
        });

        return panel;
    }

    public static void save(String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String database = "bank";
        String username = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url + database, username, pass);
        Statement stat = (Statement) con.createStatement();
        String em = GUI.getEmail();
        String changed = "yes";
        String query = " UPDATE bank.users SET password = ' " + password + " ' WHERE email = ' " + em + " ' ";
        String query1 = " UPDATE bank.users SET changed = ' " + changed + " ' WHERE email = ' " + em + " ' ";
        Boolean rs = stat.execute(query);
        Boolean rs1 = stat.execute(query1);

    }

}
