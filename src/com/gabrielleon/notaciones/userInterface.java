package com.gabrielleon.notaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class userInterface {
    
    public static void userinterface() throws InterruptedException, IOException{
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Para empezar ingrese el numero '1' para empezar o '0' para salir del programa");
        String start = in.nextLine();
        
        if ("1".equals(start)) {
            
            FileWriter writerprefix = new FileWriter("C:\\data\\Post-expresiones.txt\\");
            FileWriter writerpostfix = new FileWriter("C:\\data\\Pre-expresiones.txt\\");
            
            String data = "C:\\data\\expresiones.txt\\";
            String line; 
            
            try(BufferedReader expresions = new BufferedReader(new FileReader (data))){
                while ((line = expresions.readLine()) != null){
                    StringBuffer infix0 = new StringBuffer(line);
                    StringBuffer infix1 = new StringBuffer(line);
                
                    String prefix = logic.toPrefix(infix0).toString();
                    String postfix = logic.toPostfix(infix1).toString();
                
                    writerprefix.write(postfix + "\n");
                    writerpostfix.write(prefix + "\n");
                    System.out.println("Prefix: " + prefix);
                    System.out.println("Postfix: " + postfix);
                }
                writerprefix.close();
                writerpostfix.close();
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("The file path provided is not valid");
            }
            
        }else if("0".equals(start)){
            System.out.println("Gracias por usar el programa");
        }else{
            System.out.println("Se ingresó un valor distinto a '1' \n\n");
            TimeUnit.SECONDS.sleep(1);
            userinterface();            
        }
    }
}
