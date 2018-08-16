package com.company;

import java.util.Stack;

public class StackTester {
    public StackTester(){
        System.out.println("\n***** StackTester *****");

        Stack<Object> stack = new Stack<Object>();

        System.out.println(stack);
        System.out.println("stack: " + stack);

        StackPush(stack, 42);
        StackPush(stack, 66);
        StackPush(stack, 99);
        StackPop(stack);
        StackPop(stack);
        StackPop(stack);

        try{
            StackPop(stack);
        } catch (Exception e) {
            System.out.println("empty stack");
        }

    }

    static void StackPush(Stack<Object> stack, int a){
        stack.push( new Integer(a) );

        System.out.println("push(" + a + ")");
        System.out.println("stack: " + stack);
    }

    static void StackPop(Stack<Object> stack) {
        System.out.print("pop -> ");
        Integer a = (Integer) stack.pop();
        System.out.println(a);
        System.out.println("stack: " + stack);
    }
}
