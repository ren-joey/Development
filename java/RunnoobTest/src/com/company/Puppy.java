package com.company;

import java.util.*;

public class Puppy {
    String puppyName = "";
    String puppyAge = "";
    String puppyType = "";
    String puppyPrice = "";

    public Puppy(HashMap<String, Object> setObj){
        this.puppyName = (String) setObj.get("name");
        this.puppyAge = (String) setObj.get("age");
        this.puppyType = (String) setObj.get("type");
        this.puppyPrice = (String) setObj.get("price");
    }

    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public void setPuppyAge(String puppyAge) {
        this.puppyAge = puppyAge;
    }

    public void setPuppyType(String puppyType) {
        this.puppyType = puppyType;
    }

    public void setPuppyPrice(String puppyPrice) {
        this.puppyPrice = puppyPrice;
    }

    public void printStatus (){
        System.out.println("puppy name is " + puppyName);
        System.out.println("puppy age is " + puppyAge);
        System.out.println("puppy type is " + puppyType);
        System.out.println("puppy price is " + puppyPrice + "\n");
    }

}
