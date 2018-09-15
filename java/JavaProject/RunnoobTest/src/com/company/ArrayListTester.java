package com.company;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTester {
    public ArrayListTester(){
        System.out.println("\n***** ArrayListTester *****");

        List<String> l = new ArrayList<String>();

        l.add("marry");
        l.add("joey");
        l.add("marry");

        ArrayListTesterGo alt = new ArrayListTesterGo();
        alt.EnumerationTester(l);
        alt.ForloopTester(l);
        alt.IteratorTester(l);
        alt.ForloopBasicTester(l);
    }
}

class ArrayListTesterGo extends Tester{
    public ArrayListTesterGo(){
        super();
    }
}
