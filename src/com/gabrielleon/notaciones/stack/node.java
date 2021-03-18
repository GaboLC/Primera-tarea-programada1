package com.gabrielleon.notaciones.stack;

public class node {
    
    public char data;
    node nextNode;
    
    node(char object){
        this(object, null);
    }
    
    node(char object, node node){
        data = object;
        nextNode = node;
    }
    
    char getChar(){
        return data;
    }
    
    node getNext(){
        return nextNode;
    }
}

