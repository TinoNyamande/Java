/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import static com.mycompany.bank.Bank.frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author hp i5
 */
public class CreateAccountGUI {

    public static JPanel panel = new JPanel();

    public static JPanel load() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        GridLayout gl = new GridLayout(11, 2);

        panel.setLayout(gl);
        JLabel acc = new JLabel("Enter customer details");
        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField(25);
        JLabel surnameLabel = new JLabel("Surname");
        JTextField email = new JTextField(25);
        JLabel emailLabel = new JLabel("Email");
        JLabel natIdLabel = new JLabel("National Id Number");
        JTextField natId = new JTextField(25);
        JTextField surname = new JTextField(25);
        JLabel phoneLabel = new JLabel("Phone");
        JTextField address = new JTextField(25);
        JLabel addressLabel = new JLabel("Address");
        JTextField phone = new JTextField(25);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField password = new JPasswordField(25);
        JPasswordField repeatPassword = new JPasswordField(25);
        JButton cancel = new JButton("Cancel");
        JButton save = new JButton("Enter");
        JLabel repeatPasswordLabel = new JLabel("Confirm password");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        //acc.setPreferredSize(new Dimension(500, 25));
        panel.add(acc, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        // nameLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(nameLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        // name.setPreferredSize(new Dimension(600, 25));
        panel.add(name, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        // surnameLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(surnameLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;
        //surname.setPreferredSize(new Dimension(600, 25));
        panel.add(surname, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        // phoneLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(phoneLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        // phone.setPreferredSize(new Dimension(600, 25));
        panel.add(phone, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 4;
        //emailLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(emailLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 4;
        //  email.setPreferredSize(new Dimension(600, 25));
        panel.add(email, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 5;
        // natIdLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(natIdLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 5;
        // natId.setPreferredSize(new Dimension(600, 25));
        panel.add(natId, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 6;
        //addressLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(addressLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 6;
        // address.setPreferredSize(new Dimension(600, 25));
        panel.add(address, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 7;
        //passwordLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(passwordLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 7;
        // password.setPreferredSize(new Dimension(600, 25));
        panel.add(password, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 8;
        //repeatPasswordLabel.setPreferredSize(new Dimension(100, 25));
        panel.add(repeatPasswordLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 8;
        // repeatPassword.setPreferredSize(new Dimension(600, 25));
        panel.add(repeatPassword, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 9;
        save.setBackground(Color.blue);
        save.setPreferredSize(new Dimension(100, 25));
        panel.add(save, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 10;
        cancel.setPreferredSize(new Dimension(100, 25));
        cancel.setBackground(Color.red);
        panel.add(cancel, gbc);
        JLabel h = new JLabel("XXX bank management application");
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.add(h);
        frame.add(header, BorderLayout.PAGE_START);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nameValue = name.getText();
                String surnameValue = surname.getText();
                String emailValue = email.getText();
                String phoneValue = phone.getText();
                String natIdValue = natId.getText();
                String addressValue = address.getText();
                char[] pValue = password.getPassword();
                char[] rPassword = repeatPassword.getPassword();

                if (nameValue.equals("") | surnameValue.equals("") | emailValue.equals("") | phoneValue.equals("")
                        | pValue.length == 0 | rPassword.length == 0 | addressValue.equals("") | natIdValue.equals("")) {
                    JOptionPane.showMessageDialog(panel, "Enter all details");
                } else {
                    if (pValue.length == rPassword.length) {
                        String passwordValue = "";
                        for (int i = 0; i < pValue.length; i++) {
                            passwordValue = passwordValue + pValue[i];
                        }
                        String encryptedPass = Security.encrypt(passwordValue + phoneValue);

                        try {
                            int accountNumber = CreateAccountGUI.generateAccountNumber();
                            CreateAccountGUI.save(accountNumber, nameValue, surnameValue, natIdValue, addressValue, phoneValue,
                                    emailValue, encryptedPass);
                            JOptionPane.showMessageDialog(panel, "Account created successfully");
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
                if (GUI.getPriviledge().equals("Admin")) {
                    Bank.frame.add(LoggedIn.load(), BorderLayout.LINE_START);
                } else {
                    Bank.frame.add(LoggedInRegular.load(), BorderLayout.LINE_START);
                }
                Bank.frame.revalidate();
                Bank.frame.repaint();

            }
        });

        return panel;
    }

    public static void save(int accountNumber, String name, String surname, String natId, String address, String phone, String email, String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String database = "bank";
        String username = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url + database, username, pass);
        Statement stat = (Statement) con.createStatement();
        String query1 = "INSERT INTO customers (accountNumber ,name, surname,natId,address,phone,email,password) values('" + accountNumber + "', ' " + name + "',' " + surname + " ',' " + natId + " ',' " + address + " ',' " + phone + " ',' " + email + " ', ' " + password + " ')";
        Boolean rs1 = stat.execute(query1);

    }

    public static int generateAccountNumber() throws SQLException {
        String ac = "";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
        Statement stat = (Statement) con.createStatement();
        String query = "SELECT * FROM bank.customers ORDER BY id DESC LIMIT 1";
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            String p = (rs.getString("accountNumber")).trim();
            ac = p;
        }

        int acN = Integer.parseInt(ac) + 1;
        return acN;
    }

}
