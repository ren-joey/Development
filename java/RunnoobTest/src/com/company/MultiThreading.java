package com.company;

public class MultiThreading {
    public MultiThreading(){
        System.out.println("\n***** MultiThreading 多線程 *****");

        RunnableDemo R1 = new RunnableDemo("thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("thread-2");
        R2.start();

        ThreadDemo R3 = new ThreadDemo("thread-3");
        R3.start();

//        Runnable hello = new DisplayMessage("hello");
//        Thread thread1 = new Thread(hello);
//        thread1.setDaemon(true);
//        thread1.setName("hello");
//        System.out.println("Starting hello thread...");
//        thread1.start();
//
//        Runnable bye = new DisplayMessage("Goodbye");
//        Thread thread2 = new Thread(bye);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//        thread2.setDaemon(true);
//        System.out.println("Starting goodbye thread...");
//        thread2.start();

//        System.out.println("Starting thread3...");
//        Thread thread3 = new GuessANumber(27);
//        thread3.start();
//        try {
//            thread3.join();
//        }catch(InterruptedException e) {
//            System.out.println("Thread interrupted.");
//        }
//        System.out.println("Starting thread4...");
//        Thread thread4 = new GuessANumber(75);
//
//        thread4.start();
//        System.out.println("main() is ending...");
    }
}

class ThreadDemo extends Thread {
    private String threadName;

    ThreadDemo(String name){

        System.out.println("\n- 多線程，使用 extends Thread -");
        threadName = name;
        System.out.println("- Creating new thread " + threadName + " -");

    }

    public void run(){
        System.out.println( threadName + " is running");

        try{
            for(int i=0; i < 4; i++){
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Thread " +  threadName + " interrupted");
        }

        System.out.println("Thread " +  threadName + " exiting.");
    }
}

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String name){

        System.out.println("\n- 多線程，使用 implements Runnable -");
        threadName = name;
        System.out.println("- Creating new thread " + threadName + " -");

    }

    public void run(){
        System.out.println("- " + threadName + " is running");

        try{
            for(int i=0; i < 4; i++){
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("Thread " +  threadName + " interrupted");
        }

        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class DisplayMessage implements Runnable {
    private String message;

    DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}

class GuessANumber extends Thread {
    private int number;

    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        try {
            do {
                guess = (int) (Math.random() * 100 + 1);
                System.out.println(this.getName() + " guesses " + guess);
                counter++;
                Thread.sleep(10);
            } while (guess != number);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
    }
}