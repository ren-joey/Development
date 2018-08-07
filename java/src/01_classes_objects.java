/* class
定義class名稱第一個字母必定為大寫

inherit
可以使用extends來繼承其他class */
class Dog extends Animal{

    // 定義Object的參數
    int age;

    // Class Constructor
    public Dog(int dogAge) {
        age = dogAge;
    }

    // Class methods
    public void bark(){
        System.out.println("Woof!");
    }

    public void run(int feet){
        System.out.println("Your dog ran " + feet + " feet!");
    }

    public int getAge(){
        return age;
    }

    // Class main 
    public static void main (String[] args){
        Dog spike = new Dog(17);
        spike.bark();
        spike.run(1700);

        int spikeAge = spike.getAge();
        System.out.println(spikeAge);

        spike.checkStatus();
    }

}