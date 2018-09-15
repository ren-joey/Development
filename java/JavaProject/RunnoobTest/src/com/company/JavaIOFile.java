package com.company;

import com.jcraft.jsch.IO;

import java.io.*;

public class JavaIOFile {

    public JavaIOFile(){
        System.out.println("\n***** JavaIOFileUtf8 *****");

        /**
         * 該寫法無法編碼，會有亂碼問題
         */
//        try {
//            byte bWrite[] = { 11, 21, 3, 40, 5 };
//            OutputStream os = new FileOutputStream("test.txt");
//            for (int x = 0; x < bWrite.length; x++) {
//                os.write(bWrite[x]); // writes the bytes
//            }
//            os.close();
//
//            InputStream is = new FileInputStream("test.txt");
//            int size = is.available();
//
//            for (int i = 0; i < size; i++) {
//                System.out.print((char) is.read() + "  ");
//            }
//            is.close();
//        } catch (IOException e) {
//            System.out.print("Exception");
//        }


        try{
            javaIOFileUtf8();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }

    static void javaIOFileUtf8() throws IOException{

        // 建構 FileOutputStream 對象，如果文件不存在會直接新建
        File f = new File("test.txt");
        FileOutputStream fop = new FileOutputStream(f);

        // 建構 OutputStreamWriter，參數可以指定編碼，默認為操作系統的默認編碼
        OutputStreamWriter writer = new OutputStreamWriter(fop, "utf-8");

        // 將中文寫入緩衝區
        writer.append("中文輸入無亂碼");

        // 將換行寫入緩衝區
        writer.append("\r\n");

        // 將英文寫入緩衝區
        writer.append("English");

        // 關閉緩衝區，寫入到文件中，如果下方沒有寫入的內容，直接close也會寫入
        writer.close();

        // 關閉輸出流，釋放系統資源
        fop.close();

        FileInputStream fip = new FileInputStream(f);

        InputStreamReader reader = new InputStreamReader(fip, "utf-8");

        StringBuffer sb = new StringBuffer();

        while (reader.ready()){
            sb.append((char) reader.read());
        }
        reader.close();

        fip.close();

        System.out.printf("成功寫入內容:\n%s\n", sb.toString());
    }

}
