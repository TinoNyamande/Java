/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 *
 * @author hp i5
 */
public class GUI {
    public JTextField field,answerLabel;
    public void showGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton dot = new JButton(".");
        JButton C = new JButton("C");
        JButton D = new JButton("D");
        JButton P = new JButton("%");
        field = new JTextField(30);
        answerLabel = new JTextField(30);
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton times = new JButton("x");
        JButton equals = new JButton("=");
        JButton oBracket = new JButton("(");
        JButton cBracket = new JButton(")");
        JButton sin = new JButton("Sin");
        JButton cos = new JButton("Cos");
        JButton tan = new JButton("Tan");
        JButton log = new JButton("log");
        JButton asin = new JButton("ArcSin");
        JButton acos = new JButton("ArcCos");
        JButton atan = new JButton("ArcTan");
        JButton power = new JButton("x2");
        JButton squareRoot = new JButton("_/");
        
        
        zero.setActionCommand("0");
        one.setActionCommand("1");
        two.setActionCommand("2");
        three.setActionCommand("3");
        four.setActionCommand("4");
        five.setActionCommand("5");
        six.setActionCommand("6");
        seven.setActionCommand("7");
        eight.setActionCommand("8");
        nine.setActionCommand("9");
        plus.setActionCommand("+");
        minus.setActionCommand("-");
        divide.setActionCommand("/");
        times.setActionCommand("*");
        dot.setActionCommand(".");
        P.setActionCommand("%");
        oBracket.setActionCommand("(");
        cBracket.setActionCommand(")");
        sin.setActionCommand("Math.sin( ");
        cos.setActionCommand("Math.cos( ");
        tan.setActionCommand("Math.tan( ");
        asin.setActionCommand("Math.ArcSin(");
        acos.setActionCommand("Math.ArcCos(");
        atan.setActionCommand("Math.ArcTan(");
        log.setActionCommand("Math.log");
        power.setActionCommand("Math.Power(");
        squareRoot.setActionCommand("Math.SquareRoot(");
        
        
        
        zero.addActionListener(new ButtonClick());
        one.addActionListener(new ButtonClick());
        two.addActionListener(new ButtonClick());
        three.addActionListener(new ButtonClick());
        four.addActionListener(new ButtonClick());
        five.addActionListener(new ButtonClick());
        six.addActionListener(new ButtonClick());
        seven.addActionListener(new ButtonClick());
        eight.addActionListener(new ButtonClick());
        nine.addActionListener(new ButtonClick());
        dot.addActionListener(new ButtonClick());
        P.addActionListener(new ButtonClick());
        C.addActionListener(new Clear() );
        plus.addActionListener(new ButtonClick());
        minus.addActionListener(new  ButtonClick());
        divide.addActionListener(new  ButtonClick());
        times.addActionListener(new  ButtonClick());
        equals.addActionListener(new Equals());
        oBracket.addActionListener(new ButtonClick());
        cBracket.addActionListener(new ButtonClick());
        sin.addActionListener(new ButtonClick());
        cos.addActionListener(new ButtonClick());
        tan.addActionListener(new ButtonClick());
        asin.addActionListener(new ButtonClick());
        acos.addActionListener(new ButtonClick());
        atan.addActionListener(new ButtonClick());
        log.addActionListener(new ButtonClick());
        power.addActionListener(new ButtonClick());
        squareRoot.addActionListener(new ButtonClick());
        D.addActionListener(new Delete());

        
        JPanel pn1 = new JPanel();
        JPanel pnl2 = new JPanel();
        GridLayout gl1 = new GridLayout(6,5);
        pn1.setLayout(gl1);
        
        pn1.add(seven);
        pn1.add(eight);
        pn1.add(nine);
        pn1.add(four);
        pn1.add(five);
        pn1.add(six);
        pn1.add(one);
        pn1.add(two);
        pn1.add(three);
        pn1.add(zero);
        pn1.add(minus);
        pn1.add(plus);
        pn1.add(equals);
        pn1.add(divide);
        pn1.add(times);
        pn1.add(dot);
        pn1.add(D);
        pn1.add(C);
        pn1.add(oBracket);
        pn1.add(cBracket);
        pn1.add(P);
        pn1.add(power);
        pn1.add(squareRoot);
        pn1.add(sin);
        pn1.add(cos);
        pn1.add(tan);
        pn1.add(asin);
        pn1.add(acos);
        pn1.add(atan);
        pn1.add(log);
        JPanel pnlField = new JPanel();
        pnlField.add(field);
        pnlField.add(answerLabel);
        
        GridLayout gl = new GridLayout(3,1);
        frame.setLayout(gl);
        frame.add(pnl2);
        frame.add(pnlField);
        frame.add(pn1);
        frame.setVisible(true);
    }
    class ButtonClick implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        answerLabel.setText("");
        String command = e.getActionCommand();
        String data = field.getText();
        if (command != null ) {
            field.setText(data+command);
        }
    }
    }

    
    class Equals implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae)   {
            try{
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("graal.js");
            String input = field.getText();
            Number ans = (Number)engine.eval(input);
            //System.out.println(engine.eval("Math.log(100)"));
            answerLabel.setText(ans.toString());  
        }catch(NullPointerException npe) {
            answerLabel.setText("");
        } catch(ScriptException se) {
            answerLabel.setText("Invalid Expression");
        }   
          
          
 
        }
    }
   class Delete implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
               String exp = field.getText();
               if (exp.equals("")){
                    field.setText("");
                }
                else {
                char [] expArray = exp.toCharArray();
                char [] newExpArray = Arrays.copyOf(expArray, expArray.length-1);
                String newExp ="";
                for (int i =0;i<newExpArray.length;i++){
                    newExp = newExp +newExpArray[i];
                }
                field.setText(newExp);
                answerLabel.setText("");
                }
        }
   }
 
    
   class Clear implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        field.setText("");
        answerLabel.setText("");
    }
    
    }
}

 