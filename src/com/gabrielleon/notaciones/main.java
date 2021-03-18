package com.gabrielleon.notaciones;

import java.io.IOException;

public class main {
    public static void main (String[] args) throws InterruptedException, IOException{
        
        System.out.println("Hola, este programa se encarga de convertir expresiones "
                + "infijas a prefijas y postfijas");
        System.out.println("Para esto un archivo .txt llamado 'expresiones' en la "
                + "ruta de 'C:\\data\\");
        System.out.println("Los datos de salida se van a generar en esa misma ruta");
        userInterface.userinterface();
    }  
}