package com.company;

public class Overloading {

    public Overloading(){
        System.out.println("\n***** Overloading *****");
    }

    public void printout(){
        System.out.println("No property");
    }

    public void printout(String str){
        System.out.println("One property : "+str);
    }

    public void printout(String... str){
        for(int i = 0; i < str.length; i++){
            System.out.printf("properties %d: %s\n", i+1, str[i]);
        }
    }
}
