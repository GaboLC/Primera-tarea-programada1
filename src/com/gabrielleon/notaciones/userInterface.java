package com.gabrielleon.notaciones;

import java.io.IOException;
import java.util.Scanner;

public class userInterface {
    
    public static void userinterface() throws InterruptedException, IOException{
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Para empezar ingrese el numero '1' para empezar o '0' para salir del programa");
        String start = in.nextLine();
        
        control.userDecision(start);
    }
}
