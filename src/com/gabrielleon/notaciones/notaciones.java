package com.gabrielleon.notaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class notaciones {
    public static void main (String[] args) throws IOException, InterruptedException{
        
        FileWriter writerprefix = new FileWriter("C:\\data\\Post-expresiones.txt\\");
        FileWriter writerpostfix = new FileWriter("C:\\data\\Pre-expresiones.txt\\");
        
        String data = "C:\\data\\expresiones.txt\\";
        String line;
        
        //userInterface.userinterface();
       
        try(BufferedReader expresions = new BufferedReader(new FileReader (data))){
            while ((line = expresions.readLine()) != null){
                StringBuffer infix0 = new StringBuffer(line);
                StringBuffer infix1 = new StringBuffer(line);
                
                String prefix = toPrefix.toPrefix(infix0).toString();
                String postfix = toPostfix.toPostfix(infix1).toString();
                
                writerprefix.write(postfix + "\n");
                writerpostfix.write(prefix + "\n");
                System.out.println("Prefix: " + prefix);
                System.out.println("Postfix: " + postfix);
            }
            writerprefix.close();
            writerpostfix.close();
            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file path provided is not valid");
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }  
}
