package controller;

import org.springframework.context.support.AbstractApplicationContext;
import service.AutoWire;
import service.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.JavaCollections;
import service.TextEditer;

public class MainApp {

    public static void main(String[] args){
        // 初始化容器
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // 取得 Bean
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj.getMsg());
        System.out.println(obj.getMsg2());

        TextEditer textEditer = (TextEditer) context.getBean("textEditer");
        textEditer.spellCheck();

        // 注入集合
        JavaCollections javaCollections = (JavaCollections) context.getBean("javaCollections");
        javaCollections.getList();
        javaCollections.getSet();
        javaCollections.getMap();
        javaCollections.getProperties();
        javaCollections.getTextEditers();

        // 自動裝配
        AutoWire autoWire = (AutoWire) context.getBean("autoWire");
        autoWire.spellCheck();

        // 銷毀 Bean
        context.registerShutdownHook();
    }

}
