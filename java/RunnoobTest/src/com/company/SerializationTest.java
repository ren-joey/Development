package com.company;

import java.io.*;

public class SerializationTest {

    public SerializationTest(){

        System.out.println("\n***** Serialization 序列化 *****");

        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }

        System.out.println("\n***** Deserialize 反序列化 *****");
        Employee e2 = null;

        try
        {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e2 = (Employee) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e2.name);
        System.out.println("Address: " + e2.address);
        System.out.println("SSN: " + e2.SSN);
        System.out.println("Number: " + e2.number);


    }

}

class Employee implements java.io.Serializable{
    public String name;
    public String address;
    // transient 會自動被序列化忽略
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}