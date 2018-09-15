package com.company;

public class ClassExtends {

    private Tiger t;
    private Cat c;

    public ClassExtends(){
        System.out.println("\n***** ClassExtends *****");
    }

    public Tiger getTiger(String name, int id){
        t = new Tiger(name, id);
        return t;
    }

    public Cat getCat(String name, int id){
        c = new Cat(name, id);
        return c;
    }
}

class Animals{
    String name = "";
    int id = 0;

    public Animals(String name, int id){
        this.name = name;
        this.id = id;
    }

    public void eat(){
        System.out.printf("%s is eating...\n", this.name);
    }

    public void sleep(){
        System.out.printf("%s is sleeping...\n", this.name);
    }

    public void introduce(){
        System.out.printf("its name is %s, its number is %d\n", this.name, this.id);
    }
}


//final class 無法被繼承
final class Tiger extends Animals{
    public Tiger (String name, int id){
        super(name, id);
    }

    @Override
    public void eat() {
        System.out.printf("%s is eating like a tiger\n", super.name);
    }

}

//final class 無法被繼承
final class Cat extends Animals{
    public Cat (String name, int id){
        super(name, id);
    }

    public void scratch(){
        System.out.printf("%s is scratching\n", super.name);
    }
}