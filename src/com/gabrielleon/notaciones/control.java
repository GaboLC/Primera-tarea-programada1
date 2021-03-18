package com.gabrielleon.notaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class control {
    
    public static void userDecision(String decision) throws IOException, InterruptedException{
        
        switch (decision) {
            case "1":
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
                        System.out.println("Infix: " + line);
                        System.out.println("Prefix: " + prefix);
                        System.out.println("Postfix: " + postfix);
                        System.out.println("");
                    }
                    writerprefix.close();
                    writerpostfix.close();
                    System.out.println("Todos los archivos se han exportado con exito!");
                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("The file path provided is not valid");
                }   break;
            case "0":
                System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("Se ingresó un valor distinto a '1' o '0' \n");
                TimeUnit.SECONDS.sleep((long) 0.5);
                userInterface.userinterface();
                break;
        }
    }
    
}
