package com.company;

import java.util.*;
import java.io.*;

//  一個java只允許一個public 類
public class Main {

//  main function
    public static void main(String[] args){
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

        RegularExpression RE = new RegularExpression();
        RE.mather();
        RE.matches_lookingAt();
        RE.replace();
        RE.replacement_tail();
        RE = null;

        System.gc();

        new DynamicArgs(1, 15, 17.3, 35.1, 11, 42.3, 2, 42);

        new Finalization();

//        new bufferedReader();

        new JavaIOFile();

        readfile r = new readfile();
        r.openFile();
        r.readFile();
        r.closeFile();

        new CreateDir();

        FileControl fc = new FileControl();
        File f = new File("./doubletest");
        fc.newFile(f);
        fc.deleteFile(f);

//        JavaScanner s = new JavaScanner();
//        s.scanByNext();
//        s.scanByNextLine();
//        s.scanNumbers();
//        s.scanAdd();
//        s = null;

        System.gc();

        ClassExtends ce = new ClassExtends();
        Tiger t = ce.getTiger("kale", 1235522);
        Cat c = ce.getCat("climo", 12315233);
        t.introduce();
        t.eat();
        c.introduce();
        c.scratch();
        c.sleep();

        Overloading or = new Overloading();
        or.printout();
        or.printout("1");
        or.printout("a", "b", "c");

        new Polymorphism();

        new EnumerationTester();

        new HashSetTester();
    }
}

class SubClass extends AbstractClass{

    void test(){
        System.out.println("***** AbstractClass *****");
        System.out.println("圓周率: " + circle + "\n");
    }
}