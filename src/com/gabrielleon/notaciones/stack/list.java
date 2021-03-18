package com.gabrielleon.notaciones.stack;

public class list {
    
    private node firstNode;
    private node lastNode;
    private node actualNode;
    private String name;
    
    public list(){
        this("List!");
    }
    
    public list(String listName){
        name = listName;
        firstNode = lastNode = null;
    }
    
    public void InsertToFront(char insertElement){
        if (isEmpty()){
            firstNode = lastNode = new node(insertElement);
        }else{
            firstNode = new node(insertElement, firstNode);
        }
    }
    
    public void InsertToEnd(char insertElement){
        if (isEmpty()){
            firstNode = lastNode = new node(insertElement);
        }else{
            lastNode = lastNode.nextNode = new node(insertElement);
        }
    }
    
    public Object deleteFromFront() throws ExceptionEmptyList{
        if (isEmpty()){
            throw new ExceptionEmptyList(name);
        }
        
        Object elementRemoved = firstNode;
        
        if (firstNode == lastNode){
            firstNode = lastNode = null;
        }else{
            firstNode = firstNode.nextNode;
        }
        return elementRemoved;
    }
    
    public Object deleteFromEnd() throws ExceptionEmptyList{
        if (isEmpty()){
            throw new ExceptionEmptyList(name);
        }
        
        Object elementRemoved = lastNode.data;
        
        if (firstNode == lastNode){
            firstNode = lastNode = null;
        }else{
            node actual = firstNode;
            
            while (actual.nextNode != lastNode){
                actual = actual.nextNode;
            }
            
            lastNode = actual;
            actual.nextNode = null;
        }
        return elementRemoved;
    }
    
    public int nodesQuantity(){
        int can = 0;
        node aux = firstNode;
        
        while (aux != null){
            can++;
            aux = aux.nextNode;
        }
        return can;
    }
    
    public node getActual(){
        return actualNode;
    }
    
    public boolean last(){
        actualNode = lastNode;
        return true;
    }
    
    public boolean first(){
        actualNode = firstNode;
        return true;
    }
    
    public boolean previous(){
        node antNode = firstNode;
        
        if (lastNode == null){
            return false;
        }
        if (actualNode == firstNode){
            return false;
        }
        if (actualNode == null){
            actualNode = lastNode;
            return true;
        } else{
            while (antNode.nextNode != actualNode){
                antNode = antNode.nextNode;
            }
            actualNode = antNode.nextNode;
            return true;
        }
    }
    
    public boolean next(){
        if (firstNode == null){
            return false;
        }
        if (actualNode == null){
            actualNode = firstNode;
            return true;
        } else{
            if (actualNode.nextNode != null){
                actualNode = actualNode.nextNode;
                return true;
            } else{
                return false;
            }
        }
    }
    
    public boolean isEmpty(){
        return firstNode == null;
    }
    
    public Object topStack(){
        Object value = lastNode.data;
        return value;
    }
    
    public void print(){
        if (isEmpty()){
            System.out.printf("%s empty\n", name);
            return;
        }
        System.out.printf("The %s is: ", name);
        node actual = firstNode;
        
        while (actual != null){
            System.out.printf("%s ", actual.data);
            actual = actual.nextNode;
        }
        
        System.out.println("\n");
    }
}
