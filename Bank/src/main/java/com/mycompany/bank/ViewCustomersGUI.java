/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import static com.mycompany.bank.Bank.frame;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hp i5
 */
public class ViewCustomersGUI {

    
    static JPanel panel = new JPanel();
    static int count = 2;
    public static JPanel load() {
        
        panel.removeAll();
        panel.validate();
        panel.repaint();
        Bank.frame.getContentPane().removeAll();
        Bank.frame.validate();
        Bank.frame.repaint();

        JButton home = new JButton("Home");
         JLabel h = new JLabel("XXX bank management application");
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.add(h);
        try {
            int rows = ViewCustomersGUI.getCount();
            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();

            panel.setLayout(gl);
            JLabel names = new JLabel("NAME");
            JLabel surnames = new JLabel("SURNAME");
            JLabel accounts = new JLabel("ACCOUNT NUMBER");
            JLabel balances = new JLabel("BALANCE");
            JLabel actions = new JLabel("Action");
            
            gbc.weightx = 0.5;
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0,0,40,0);
            panel.add(home,gbc);
            
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0,10,10,0);
            panel.add(names, gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(surnames, gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 1;
            panel.add(accounts, gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 3;
            gbc.gridy = 1;
            panel.add(balances, gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 1;
            panel.add(actions, gbc);

            

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            Statement stat = (Statement) con.createStatement();
            String query = "SELECT * FROM bank.customers ";
            ResultSet rs = stat.executeQuery(query);
            
            while (rs.next()) {
                String name = (rs.getString("name"));
                String surname = (rs.getString("surname"));
                String accountNumber = (rs.getString("accountNumber"));
                String balance = (rs.getString("balance"));

                JLabel nameLabel = new JLabel(name);
                JLabel surnameLabel = new JLabel(surname);
                JLabel accountNumberLabel = new JLabel(accountNumber);
                JLabel balanceLabel = new JLabel(balance);
                JButton edit = new JButton("Edit");

                gbc.weightx = 0.5;
                gbc.gridx = 0;
                gbc.gridy = count;
                panel.add(nameLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 1;
                gbc.gridy = count;
                panel.add(surnameLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 2;
                gbc.gridy = count;
                panel.add(accountNumberLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 3;
                gbc.gridy = count;
                panel.add(balanceLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 4;
                gbc.gridy = count;
                panel.add(edit,gbc);
                count++;
               

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().removeAll();
                frame.validate();
                frame.repaint();
                if (GUI.getPriviledge().equals("Admin")) {
                    Bank.frame.add(LoggedIn.load(), BorderLayout.LINE_START);
                } else {
                    Bank.frame.add(LoggedInRegular.load(), BorderLayout.LINE_START);
                }
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(header,BorderLayout.PAGE_START);
        return panel;
    }

    public static int getCount() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
        Statement stat = (Statement) con.createStatement();
        String query = "SELECT COUNT(*) FROM bank.customers ";
        ResultSet rs = stat.executeQuery(query);
        rs.next();
        int p = rs.getInt(1);
        return p + 1;
    }
}
