/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hp i5
 */
public class Bank {

    static public JFrame frame = new JFrame();
    static JPanel panel = new JPanel();

    public static JPanel homePage() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        frame.setSize(600, 600);
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setMaximumSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bl = new BorderLayout();
        panel.setLayout(bl);

        JButton login = new JButton("Login");
      

        JLabel h = new JLabel("XXX bank management application");
        JLabel h2 = new JLabel("Click Login to continue");
        
        JPanel header = new JPanel();
        header.setBackground(Color.BLUE);
        header.add(h);
       
        
        JPanel content = new JPanel();
        content.add(h2);
        content.add(login);
     
 

        panel.add(header, BorderLayout.PAGE_START);
        panel.add(content, BorderLayout.CENTER);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().removeAll();
                frame.validate();
                frame.repaint();
                frame.add(header,BorderLayout.PAGE_START);
                frame.add(LoginGUI.load(),BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.setVisible(true);
        return panel;
    }

    public static void main(String[] args) {
        Bank b = new Bank();
        frame.add(b.homePage());

    }
}
