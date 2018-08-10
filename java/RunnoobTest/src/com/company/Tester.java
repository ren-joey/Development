package com.company;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Tester {
    public Tester(){
        System.out.println("\n***** Tester *****");
    }

    public void EnumerationTester(List<String> h){

        System.out.println("-Enumeration next-");

        Enumeration<String> e;
        e = Collections.enumeration(h);

        while( e.hasMoreElements() ){
            System.out.println(e.nextElement());
        }
    }

    public void ForloopTester(List<String> h){

        System.out.println("-for loop-");

        for (String s:h){
            System.out.println(s);
        }
    }

    public void IteratorTester(List<String> h){

        System.out.println("-for loop-");

        Iterator<String> itr;
        itr = h.iterator();

        while ( itr.hasNext() ){
            System.out.println(itr.next());
        }
    }
}
