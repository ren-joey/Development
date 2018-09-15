package com.company;

import java.io.File;
import java.util.Scanner;

public class readfile {

    private Scanner x;

    public void openFile(){
        System.out.println("\n***** readfile *****");

        try{
            String dir = "./chinese.txt";
            x = new Scanner(new File(dir));

            System.out.printf("file direction: %s\n", dir);
        }catch (Exception e){
            System.out.println("Could not find file");
        }
    }

    public void readFile(){
        while (x.hasNext()){
            String a = x.next();
            String b = x.next();
            String c = x.next();

            System.out.printf("%s %s %s\n", a, b, c);
        }
    }

    public void closeFile(){
        x.close();
    }

}
