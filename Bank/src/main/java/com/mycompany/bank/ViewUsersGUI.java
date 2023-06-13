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
public class ViewUsersGUI {

    static JPanel panel = new JPanel();
    static int count = 2;

    public static JPanel load() {
        panel.removeAll();
        panel.validate();
        panel.repaint();
        JButton home = new JButton("Home");
        JLabel h = new JLabel("XXX bank management application");
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.add(h);
        try {
            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();

            panel.setLayout(gl);

            panel.setLayout(gl);
            JLabel ids = new JLabel("ID");
            JLabel names = new JLabel("NAME");
            JLabel surnames = new JLabel("SURNAME");
            JLabel position = new JLabel("POSITION");
            JLabel actions = new JLabel("Action");
            
            gbc.weightx = 0.5;
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0,0,40,0);
            panel.add(home,gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0,0,20,0);
            panel.add(ids,gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(names,gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 1;
            panel.add(surnames,gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 3;
            gbc.gridy = 1;
            panel.add(position,gbc);

            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 1;
            panel.add(actions,gbc);


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            Statement stat = (Statement) con.createStatement();
            String query = "SELECT * FROM bank.users ";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                String id = (rs.getString("Id"));
                String name = (rs.getString("name"));
                String surname = (rs.getString("surname"));
                String pos = (rs.getString("position"));
                JLabel idLabel = new JLabel(id);
                JLabel nameLabel = new JLabel(name);
                JLabel surnameLabel = new JLabel(surname);
                JLabel balanceLabel = new JLabel(pos);
                JButton edit = new JButton("Edit");

                gbc.weightx = 0.5;
                gbc.gridx = 0;
                gbc.gridy = count;
                panel.add(idLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 1;
                gbc.gridy = count;
                panel.add(nameLabel,gbc);

                gbc.weightx = 0.5;
                gbc.gridx = 2;
                gbc.gridy = count;
                panel.add(surnameLabel,gbc);

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
        frame.add(header, BorderLayout.PAGE_START);
        return panel;
    }

    public static int getCount() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
        Statement stat = (Statement) con.createStatement();
        String query = "SELECT COUNT(*) FROM bank.users ";
        ResultSet rs = stat.executeQuery(query);
        rs.next();
        int p = rs.getInt(1);
        return p + 1;
    }
}
