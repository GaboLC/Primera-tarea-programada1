package com.gabrielleon.notaciones;

import com.gabrielleon.notaciones.stack.stack;
import com.gabrielleon.notaciones.stack.node;

public class toPrefix {
    
    StringBuffer inFix, preFix;
    stack stack;
    
    public static StringBuffer toPrefix(StringBuffer inFix){
        StringBuffer preFix = new StringBuffer();
        stack stack = new stack();
        stack.push(')');
        inFix.insert(0, '(');
        
        for (int i = inFix.length()-1; i > -1; i--) {
            if (Character.isDigit(inFix.charAt(i)) || Character.isAlphabetic(inFix.charAt(i))){
                preFix.insert(0, inFix.charAt(i));
            }else if (inFix.charAt(i) == ')'){
                stack.push(inFix.charAt(i));
            }else if (isOperator(inFix.charAt(i))){
                boolean entroIf = true;
                while (entroIf){
                    node operator = (node) stack.pop();
                    if (isOperator(operator.data)){
                        preFix.insert(1, operator.data);
                        entroIf = true;
                    } else{
                        stack.push(operator.data);
                        stack.push(inFix.charAt(i));
                        entroIf = false;
                    }
                }
                
            } else if (inFix.charAt(i) == '('){
                boolean entroIf = true;
                while (entroIf){
                    node operator = (node) stack.pop();
                    if (isOperator(operator.data)){
                        preFix.insert(0, operator.data);
                        entroIf = true;
                    } else{
                        entroIf = false;
                    }
                }
            } 
        }
        return preFix;
    }
    
    public static boolean isOperator(char c){
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%'){
            return true;
        } else{
            return false;
        }
    }
}
