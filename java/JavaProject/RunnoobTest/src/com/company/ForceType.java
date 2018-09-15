package com.company;

public class ForceType {

    private int i1 = 123;
    private byte b = (byte)i1;//强制类型转换为byte

    public ForceType(){
        System.out.println("***** ForceType *****");
        System.out.println("int强制类型转换为byte后的值等于"+b+"\n");
    }
}
