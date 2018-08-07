package com.company;

import java.util.*;

//  一個java只允許一個public 類
public class Main {

//  main function
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "kiki");
        map.put("age", "1");
        map.put("type", "golden dog");
        map.put("price", "24,000");

        new Puppy(map).printStatus();
        /**
         * 匿名用法，作用等同於
         * Puppy myPuppy = new Puppy(map);
         * myPuppy.printStatus();
         */

        new Numbers().printNumbers();

        new AutoType();

        new ForceType();

        new SubClass().test();

        new LoopFuncs();

        new StringObj();

        new JavaDate();
    }
}

class SubClass extends AbstractClass{
    void test(){
        System.out.println("圓周率: " + circle + "\n");
    }
}