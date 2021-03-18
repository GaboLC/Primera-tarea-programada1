package com.gabrielleon.notaciones;

import java.util.Stack;

//import com.gabrielleon.notaciones.stack.stack;


public class conversion {
    
    static StringBuilder conversionToPrefix(String expresion){
        StringBuilder ePrefix = new StringBuilder();
        StringBuilder eInfix = new StringBuilder(expresion);
        eInfix.reverse();
        Stack preFix = new Stack();
        char[] carexp = new String(eInfix).toCharArray();
        
        for (int i = 0; i < carexp.length; i++) {
            if (carexp[i] == '('){
                carexp[i] = ')';
                i++;
            }else if (carexp[i] == ')'){
                carexp[i] = '(';
                i++;
            }
        }
        
        for (int i = 0; i < carexp.length; i++) {
            char car = carexp[i];
            
            if (hierarchy(car) > 0){
                while (preFix.isEmpty() == false && hierarchy((char) preFix.peek()) >= hierarchy(car)){
                    ePrefix.append(preFix.pop());
                }
                preFix.push(car);
            }else if (car == ')'){
                char aux = (char) preFix.pop();
                while (aux != '('){
                    ePrefix.append(aux);
                    aux = (char) preFix.pop();
                }
            }else if (car == '('){
                preFix.push(car);
            }else{
                ePrefix.append(car);
            }
        }
        
        for (int i = 0; i < preFix.size(); i++) {
            ePrefix.append(preFix.pop());
        }
        return ePrefix.reverse();
    }
    
    static StringBuilder conversionToPostfix(String expresion){
        StringBuilder ePostfix = new StringBuilder();
        StringBuilder eInfix = new StringBuilder(expresion);
        eInfix.reverse();
        Stack postFix = new Stack();
        char[] carexp = new String(eInfix).toCharArray();
        
        for (int i = 0; i < carexp.length; i++) {
            if (carexp[i] == '('){
                carexp[i] = ')';
                i++;
            }else if (carexp[i] == ')'){
                carexp[i] = '(';
                i++;
            }
        }
        
        for (int i = 0; i < carexp.length; i++) {
            char car = carexp[i];
            
            if (hierarchy(car) > 0){
                while (postFix.isEmpty() == false && hierarchy((char) postFix.peek()) >= hierarchy(car)){
                    ePostfix.append(postFix.pop());
                }
                postFix.push(car);
            }else if (car == ')'){
                char aux = (char) postFix.pop();
                while (aux != '('){
                    ePostfix.append(aux);
                    aux = (char) postFix.pop();
                }
            }else if (car == '('){
                postFix.push(car);
            }else{
                ePostfix.append(car);
            }
        }
        
        for (int i = 0; i < postFix.size(); i++) {
            ePostfix.append(postFix.pop());
        }
        
        return ePostfix;
    }
    
    static int hierarchy(char car){
        switch(car){
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
