package com.company;

import java.util.*;

public class HashSetTester {

    public HashSetTester(){
        System.out.println("\n***** HashSetTester *****");

        HashSet<String> hs = new HashSet<String>();

        hs.add("joey");
        hs.add("marry");
        hs.add("charlie");
        hs.add("joey");

        List<String> list = new ArrayList<String>(hs);

        HashSetTesterGO tester = new HashSetTesterGO();
        tester.EnumerationTester(list);
        tester.ForloopTester(list);
        tester.IteratorTester(list);

    }

}

class HashSetTesterGO extends Tester{

    public HashSetTesterGO(){
        super();
    }
}
