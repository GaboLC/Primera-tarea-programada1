package com.gabrielleon.notaciones.stack;

public class stack {
    
    private list stackList;
    
    public stack(){
        stackList = new list("list!");
    }
    
    public void push(char object){
        stackList.InsertToFront(object);
    }
    
    public Object pop() throws ExceptionEmptyList{
        return stackList.deleteFromFront();
    }
    
    public boolean isEmpty(){
        return stackList.isEmpty();
    }
    
    public void print(){
        stackList.print();
    }
    
    public Object topPartStack(){
        Object operator = stackList.topStack();
        return operator;
    }
    
    public boolean first(){
        return stackList.first();
    }
    
    public boolean last(){
        return stackList.previous();
    }
    
    public boolean next(){
        return stackList.next();
    }
    
    public node getActual(){
        return stackList.getActual();
    }

    public int size() {
        return stackList.nodesQuantity();
    }

    public char peek() {
        return (char) stackList.topStack();
    }
}
