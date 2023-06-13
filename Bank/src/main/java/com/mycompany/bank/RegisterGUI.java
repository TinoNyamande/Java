/*s
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import static com.mycompany.bank.Bank.frame;
import static com.mycompany.bank.LoggedInRegular.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author hp i5
 */
public class RegisterGUI {

    static JPanel container = new JPanel();

    public static JPanel registerPanel() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        container.removeAll();
        container.revalidate();
        container.repaint();
        Bank.frame.add(GUI.header(), BorderLayout.PAGE_START);
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel header = new JLabel("Enter your details to register");
        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(gl);
        JLabel empty = new JLabel("       ");

        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField(20);
        JLabel surnameLabel = new JLabel("Surname");
        JTextField surname = new JTextField(20);
        JLabel emailLabel = new JLabel("Email");
        JTextField email = new JTextField(20);
        JLabel positionLabel = new JLabel("Position");
        JTextField position = new JTextField(20);
        JLabel addressLabel = new JLabel("Address");
        JTextField address = new JTextField(20);
        JLabel phoneLabel = new JLabel("Phone");
        JTextField phone = new JTextField(20);
        JLabel branchLabel = new JLabel("Branch");
        JTextField branch = new JTextField(20);
        ButtonGroup priviledgeLabel = new ButtonGroup();
        JRadioButton r1 = new JRadioButton("All");
        r1.setActionCommand("Admin");
        JRadioButton r2 = new JRadioButton("ReadOnly");
        r2.setActionCommand("Regular");
        priviledgeLabel.add(r1);
        priviledgeLabel.add(r2);
        JLabel priviledge = new JLabel("Priviledge");
        JLabel natIdLabel = new JLabel("National Id");
        JTextField natId = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField password = new JPasswordField(20);
        JLabel repeatPasswordLabel = new JLabel("Confirm password");
        JPasswordField repeatPassword = new JPasswordField(20);
        JButton save = new JButton("Enter");
        JButton cancel = new JButton("Cancel");

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        loginpanel.add(header, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        loginpanel.add(nameLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginpanel.add(name, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginpanel.add(surnameLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginpanel.add(surname, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginpanel.add(emailLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        loginpanel.add(email, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 4;
        loginpanel.add(positionLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 4;
        loginpanel.add(position, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 5;
        loginpanel.add(addressLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 5;
        loginpanel.add(address, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 6;
        loginpanel.add(phoneLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 6;
        loginpanel.add(phone, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 7;
        loginpanel.add(branchLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 7;
        loginpanel.add(branch, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 8;
        loginpanel.add(priviledge, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 8;
        loginpanel.add(r1, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 8;
        loginpanel.add(r2, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 9;
        loginpanel.add(natIdLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 9;
        loginpanel.add(natId, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 10;
        loginpanel.add(passwordLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 10;
        loginpanel.add(password, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 11;
        loginpanel.add(repeatPasswordLabel, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 11;
        loginpanel.add(repeatPassword, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 12;
        save.setBackground(Color.BLUE);
        loginpanel.add(save, gbc);

        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 13;
        cancel.setBackground(Color.RED);
        loginpanel.add(cancel, gbc);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nameValue = name.getText();
                String surnameValue = surname.getText();
                String emailValue = email.getText();
                String positionValue = position.getText();
                char[] pValue = password.getPassword();
                char[] cpassword = repeatPassword.getPassword();
                String addressValue = address.getText();
                String phoneValue = phone.getText();
                String branchValue = branch.getText();
                String priviledgeValue = priviledgeLabel.getSelection().getActionCommand();

                String natIdValue = natId.getText();
                String addedByValue = GUI.getEmail();
                if (nameValue.equals("") | surnameValue.equals("") | emailValue.equals("") | positionValue.equals("")
                        | pValue.length == 0 | cpassword.length == 0 | addressValue.equals("") | phoneValue.equals("")
                        | branchValue.equals("") | priviledgeValue.equals("") | natIdValue.equals("") | addedByValue.equals("")) {
                    JOptionPane.showMessageDialog(container, "Enter all details");
                } else {
                    if (pValue.length == cpassword.length) {
                        String passwordValue = "";
                        for (int i = 0; i < pValue.length; i++) {
                            passwordValue = passwordValue + pValue[i];
                        }
                        String encryptedPass = Security.encrypt(passwordValue + emailValue);

                        RegisterGUI p = new RegisterGUI();
                        try {
                            p.save(nameValue, surnameValue, emailValue, positionValue, addressValue, phoneValue, branchValue, encryptedPass, priviledgeValue, natIdValue, addedByValue);
                            JOptionPane.showMessageDialog(container, "User added");
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
                            JOptionPane.showMessageDialog(container, "Enter valid details");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(container, "Error connecting to database");
                        }
                    } else {
                        JOptionPane.showMessageDialog(container, "Passwords are not matching");
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

        container.add(loginpanel);

        return container;

    }

    public void save(String name, String surname, String email, String position, String address, String phone, String branch, String passwords, String priviledge, String natId, String addedBy) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String database = "bank";
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url + database, username, password);
        Statement stat = (Statement) con.createStatement();
        String query1 = "INSERT INTO users (name, surname,email,position,address,"
                + "phone,branch,password,priviledge,natId,addedBy)"
                + " values(' " + name + "','" + surname + " ',' " + email + " ','" + position + " ', "
                + "' " + address + " ',' " + phone + " ', ' " + branch + " ',' " + passwords + " ', ' " + priviledge + " ' ,'" + natId + "' ,'" + addedBy + "')";
        Boolean rs1 = stat.execute(query1);

    }
}
