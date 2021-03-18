package com.gabrielleon.notaciones.stack;

public class ExceptionEmptyList extends RuntimeException{
    
    public ExceptionEmptyList(){
        this("List!");
    }
    
    public ExceptionEmptyList(String name){
        super(name + "Is empty :(");
    }
    
}
