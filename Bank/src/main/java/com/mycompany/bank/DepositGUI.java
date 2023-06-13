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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hp i5
 */
public class DepositGUI {

    static JPanel panel = new JPanel();

    public static JPanel load() {
        panel.removeAll();
        panel.validate();
        panel.repaint();
        Bank.frame.getContentPane().removeAll();
        Bank.frame.validate();
        Bank.frame.repaint();

        JLabel h = new JLabel("XXX bank management application");
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.add(h);

        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gl);

        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField(20);
        JLabel acLabel = new JLabel("Account Number");
        JTextField ac = new JTextField(20);
        JLabel amountLabel = new JLabel("Amount");
        JTextField amount = new JTextField(20);
        JButton save = new JButton("Enter");
        JButton cancel = new JButton("Cancel");

        gbc.insets = new Insets(0, 40, 10, 0);
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(name, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(acLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(ac, gbc);

        gbc.insets = new Insets(0, 40, 10, 0);
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(amountLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(amount, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        save.setBackground(Color.BLUE);
        panel.add(save, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 4;
        cancel.setBackground(Color.red);
        panel.add(cancel, gbc);
        Bank.frame.add(header, BorderLayout.PAGE_START);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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

            }
        });
        save.addActionListener(new ActionListener() {
            int newBal;

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nameValue = name.getText().trim();
                int acValue = Integer.parseInt(ac.getText().trim());
                int amountValue = Integer.parseInt(amount.getText());

                try {

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
                    con.setAutoCommit(false);
                    Statement stat = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    String query = "SELECT balance FROM bank.customers WHERE name = ' " + nameValue + " ' AND accountNumber = ' " + acValue + " ' ";
                    ResultSet rs = stat.executeQuery(query);
                    // stat.close();
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(panel, "User with entered details not found");
                    } else {
                        rs.beforeFirst();
                        while (rs.next()) {
                            int cbal = Integer.parseInt(rs.getString("balance").trim());
                            newBal = amountValue + cbal;
                        }
                        String query2 = "UPDATE bank.customers SET balance = ' " + newBal + " ' WHERE name = ' " + nameValue + " ' ";
                        stat.execute(query2);
                        String query3 = "INSERT INTO bank.transactions (sender ,receiver,amount) values('" + nameValue + " ','bank','" + amountValue + "') ";
                        stat.execute(query3);
                        stat.close();
                        con.commit();
                        JOptionPane.showMessageDialog(panel, "Deposit successful. New balance is :" + newBal);
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
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
        return panel;

    }
}
