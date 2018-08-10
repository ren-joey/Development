package com.company;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationTester {

    public EnumerationTester(){
        System.out.println("\n***** EnumerationTester *****");

        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("monday");
        dayNames.add("tuesday");
        dayNames.add("wednesday");
        dayNames.add("thursday");
        dayNames.add("friday");
        dayNames.add("saturday");
        dayNames.add("sunday");
        days = dayNames.elements();

        System.out.println("-Enumeration next-");
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }

        System.out.println("-for loop-");
        for (String d : dayNames){
            System.out.println(d);
        }

        System.out.println("-Iterator-");
        Iterator itr = dayNames.iterator();
        while( itr.hasNext() ){
            System.out.println(itr.next());
        }
    }
}

class VectorTester extends Tester{
    public VectorTester(){
        super();
    }

    public void EnumerationTester(Vector<String> h) {

    }
}
