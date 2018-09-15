package com.company;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTester {
    public VectorTester(){
        System.out.println("\n***** VectorTester *****");
        /**
         * http://www.runoob.com/java/java-vector-class.html
         */

        // 設定初始大小為3, 每次增長的級距為2
        int size = 3;
        int incr = 2;
//        Collection c;

        /**
         *  Vector 类支持 4 种构造方法
         *  1. 不傳大小，預設 10
         *  2. 傳入預設大小
         *  3. 傳入預設大小及增長級距
         *  4. 傳入 collection 的集合向量 vector
         */
        Vector<Object> vec = new Vector<Object>();
        Vector<Object> vec2 = new Vector<Object>(size);
        Vector<Object> vec3 = new Vector<Object>(size, incr);
//        Vector<Object> vec4 = new Vector<Object>(c);


        /**
         * int capacity() 返回此向量的当前容量。
         */
        System.out.println("Initial size: " + vec3.size());
        System.out.println("Initial capacity: " +
                vec3.capacity());
        vec3.addElement(new Integer(1));
        vec3.addElement(new Integer(2));
        vec3.addElement(new Integer(3));
        vec3.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " +
                vec3.capacity());

        System.out.println("First element: " +
                (Integer)vec3.firstElement());
        System.out.println("Last element: " +
                (Integer)vec3.lastElement());

        // enumerate the elements in the vector.
        if(vec3.contains(new Integer(3)))
            System.out.println("Vector contains 3.");

        System.out.println("\nElements in vector use Enumeration:");
        Enumeration vEnum = vec3.elements();

        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();


        System.out.println("\nElements in vector use Iterator:");
        Iterator itr = vec3.iterator();

        while(itr.hasNext())
            System.out.print(itr.next() + " ");
    }
}
