package com.company;

import java.util.*;

public class LoopFuncs {

    public  LoopFuncs(){
        int [] numbers = {10, 20, 30, 40, 50};

        // java 加強型 for 迴圈
        for(int x : numbers ){
            System.out.print( x );

            // 中途用 break 強制跳出
            if( x == 30 ) break;
            System.out.print(",");
        }
        System.out.print("\n");

        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name );

            // 中途用 continue 強制跳到下一次循環
            if( name.equals("Lacy")) continue;

            System.out.print(",");
        }
        System.out.print("\n");

        int x = 10;

        /**
         * do while 迴圈無倫條件是否滿足，會先執行過 do 才判斷 while
         * 所以至少會執行一次
         */
        do{
            x++;
            System.out.print("value of x : " + x );
            System.out.print("\n");
        }while( x < 20 );

        System.out.print("\n");

        /**
         * 如果要能判斷 foreach 是否為最後一個，需使用 iterator
         * 使用 iterator 時必須先把資料轉型為 list
         */
        List<String> strings = Arrays.asList(names);
        Iterator<String> itr = strings.iterator();
        while(itr.hasNext()){
            String next = itr.next();
            System.out.print( next );

            if(!itr.hasNext()){
                break;
            }else {
                System.out.print(",");
            }
        }

        System.out.println("\n");
    }

}
