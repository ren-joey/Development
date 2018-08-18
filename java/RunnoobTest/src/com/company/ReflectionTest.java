package com.company;

import org.jsoup.select.Evaluator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {

    public ReflectionTest(){

    }

    public static void main(String[] args) throws Exception{
        try {
            demo1();
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void demo1() throws Exception{

        Class<?> class1 = Class.forName("java.lang.Object");

        Method[] methods = class1.getDeclaredMethods();

        for(Method method: methods){
            System.out.println(method.toString());
        }


        /**
         * 傳統方法
         * invokeTester invoketester = new invokeTester();
         * System.out.println(invoketester.add(1,5));
         * System.out.println(invoketester.echo("hello"));
         */

        /**
         * 反射方法
         */

        // 方法一
        // Class<?> class2 = invokeTester.class;

        // 方法二，可拋出 ClassNotFoundException
        Class<?> class2 = Class.forName("com.company.invokeTester");

        Object reflectionInvokeTester = class2.newInstance();

        /**
         * 確認 reflectionInvokeTester 是否為 invokeTester 的實例
         * 結果為 true
         */
        System.out.println( "reflectionInvokeTester 是否為 invokeTester 的實例: " + (reflectionInvokeTester instanceof invokeTester) );

        Method reflectionInvokeAddMethod = class2.getMethod("add", new Class[] { int.class, int.class });

        Object result = reflectionInvokeAddMethod.invoke(reflectionInvokeTester, new Object[] { 1 , 2 });

        System.out.println( (Integer)result );

        System.out.println("-------------------");

        Method reflectionEchoMethod = class2.getMethod("echo", new Class[] { String.class });

        Object result2 = reflectionEchoMethod.invoke(reflectionInvokeTester, new Object[] { "tom" });

        System.out.println( (String)result2 );

        System.out.println("-------------------");

        Class<?> class3 = Class.forName("com.company.invokeTester");
        Constructor<?> constructor = class3.getConstructor();
        invokeTester tester1 = (invokeTester) constructor.newInstance();
        System.out.println(tester1.add(1, 7));
    }

}

class invokeTester {

    public invokeTester(){

    }

    public int add (int param1, int param2){
        return param1 + param2;
    }

    public String echo ( String str ){
        str = str.toUpperCase();
        return str;
    }

}

class myPerson {

    private int age;
    private String name;

    public myPerson(){

    }

    public myPerson(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

}