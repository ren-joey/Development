package com.company;

import java.util.Scanner;

public class JavaScanner {

    private Scanner s;

    public JavaScanner() {
        System.out.println("\n***** JavaScanner *****");
    }

    protected void scanByNext(){
        // 從硬碟獲取數據
        s = new Scanner(System.in);

        // next方式接收字符串
        System.out.println("next方式接收 (不可含空白)：");

        // 判斷是否還有輸入
        if(s.hasNext()){
            String str = s.next();
            System.out.printf("輸入的數據為：%s\n", str);
        }
    }

    protected void scanByNextLine(){
        // 從硬碟獲取數據
        s = new Scanner(System.in);

        // next方式接收字符串
        System.out.println("next line方式接收 (可含空白)：");

        // 判斷是否還有輸入
        if(s.hasNextLine()){
            String str = s.nextLine();
            System.out.printf("輸入的數據為：%s\n", str);
        }
    }

    protected void scanNumbers(){
        s = new Scanner(System.in);

        int i = 0;
        float f = 0.0f;

        System.out.print("输入整数：");
        if (s.hasNextInt()) {
            // 判断输入的是否是整数
            i = s.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (s.hasNextFloat()) {
            // 判断输入的是否是小数
            f = s.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
    }

    protected void scanAdd(){
        s = new Scanner(System.in);

        double sum = 0;
        int m = 0;

        System.out.print("输入數字：");
        while (s.hasNextDouble()) {
            double x = s.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
    }

    protected void finalize() throws java.lang.Throwable{
        super.finalize();
        System.out.println("關閉 scanner");

        s.close();
    }
}
