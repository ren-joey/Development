package com.company;

public class StringObj {
    public StringObj(){
        System.out.println("***** StringObj *****");

        String str1 = new String("good job!");
        String str2 = "joey";
        System.out.println("String concat: "+str1.concat(str2));

        String str3 = String.format("%f," + " %d," + " %s", 3.2, 3, "mary");
        System.out.println("String format: "+str3);

        StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
        sBuffer.append("www");
        sBuffer.append(".runoob");
        sBuffer.append(".com");
        System.out.println(sBuffer+"\n");
    }
}
