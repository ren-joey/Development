package com.company;

public class Finalization {
    public Finalization(){
        System.out.println("***** Finalization *****");

        Cake c1 = new Cake(1);

        c1 = null;

        System.gc();
        /**
         * 調用垃圾蒐集器來查看哪些 class 被丟棄了
         * 如果有找到對應的項目，就會呼叫該項目的 finalize() 方法
          */
    }
}

class Cake extends Object{
    private int id;

    public Cake (int id){
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    // 等待垃圾收集器呼叫
    protected void finalize() throws java.lang.Throwable{
        super.finalize();
        System.out.println("Cake Object " + id + "is disposed");
    }
}