package com.company;

import java.io.*;

public class CreateDir {
    public CreateDir(){
        System.out.println("\n***** CreateDir *****");

        String dirname = "./testJava";
        File d = new File(dirname);

        System.out.printf("create direction: %s\n", dirname);
        d.mkdir();
    }
}
