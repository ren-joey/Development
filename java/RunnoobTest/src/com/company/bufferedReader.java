package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferedReader {

    public bufferedReader(){
        System.out.println("\n***** bufferedReader *****");

        try{
            bufferedReaderLine();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        try {
            bufferedReaderChar();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    static void bufferedReaderLine() throws IOException{
        String str;

        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字串, 輸入 'exit' 键退出。");

        // 讀取字串
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("exit"));
    }

    static void bufferedReaderChar() throws IOException{
        char c;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("輸入字符, 輸入 'q' 鍵退出。");

        do{
            c = (char) br.read();
            System.out.println(c);
        }while(c != 'q');

    }

}
