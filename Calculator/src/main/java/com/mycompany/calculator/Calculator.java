/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculator;


import javax.script.ScriptException;

/**
 *11
 * @author hp i5
 */
public class Calculator {

    public static void main(String[] args) throws ScriptException {
        GUI g = new GUI();
        g.showGUI();
        // ScriptEngineManager mgr = new ScriptEngineManager();
        //ScriptEngine engine = mgr.getEngineByName("graal.js");
        //String res = "5+8*2";
        //System.out.println(engine.eval(res));
    }
}
