package com.company;

public class Polymorphism {
    public Polymorphism(){
        System.out.println("\n***** Polymorphism 多態 *****");

        show(new shark());
        show(new dog());

        Animal a = new shark();
        a.eat();
        shark c = (shark) a;
        c.work();
    }

    protected void show(Animal a){
        a.eat();
        a.work();

        if(a instanceof shark){
            System.out.println("is a shark!");
        }else if(a instanceof dog){
            System.out.println("cutie dog!");
        }
    }
}


abstract class Animal{
    abstract void eat();
    abstract void work();
}

class shark extends Animal{

    public void eat(){
        System.out.println("eat fish");
    }
    public void work(){
        System.out.println("get some fish");
    }

}

class dog extends Animal{

    public void eat(){
        System.out.println("eat meat");
    }
    public void work(){
        System.out.println("get some bones");
    }

}