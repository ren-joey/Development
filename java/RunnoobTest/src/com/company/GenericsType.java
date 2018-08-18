package com.company;

import java.util.*;

public class GenericsType {

    public GenericsType(){
        System.out.println("\n***** GenericsType 泛型 *****");

        /**
         * 泛型的參數可傳入各種符合方法的對象
         * 如：可比對的數字 Comparable 包含 String, Integer, Double, int ..等
         * 如：可用 ArrayList 遍歷的對象包含 String, Integer, Double, int ..等
         *
         * <? extends T>表示该通配符所代表的类型是T类型的子类。
         * <? super T>表示该通配符所代表的类型是T类型的父类。
         */

        Integer[] ints = { 1, 2, 4, 8, 10 };
        Double[] doubles = { .34, 1.3, 2.5, .97 };
        Character[] chars = { 'A', 'B', 'C' };
        String[] strs = {"i", "am", "joey"};

        printArray(ints);
        printArray(doubles);
        printArray(chars);
        printArray(strs);

        setPrintMap(new String("ID"), new Integer(6744));

        System.out.printf("比較 %d, %d, %d 中最大值為: %d\n", 5, 8, 4, maximun(new Integer(5), 8, 4));

        System.out.printf("比較 %.1f, %.1f, %.1f 中最大值為: %.1f\n", 5.5, 8.3, 4.3, maximun(new Double(5.5), new Double(8.3), 4.3));

        System.out.printf("比較 %s, %s, %s 中最大值為: %s\n", "orange", "pear", "strawberry", maximun(new String("orange"), "pear", new String("strawberry"))) ;

        List<String> stringList = new ArrayList<String>();
        stringList.add("cool");
        stringList.add("yes");
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(123);
        integerList.add(432);

        getData(stringList);
        getData(integerList);

        getDataOnlyNum(integerList);
    }

    public static <E> void printArray( E[] inputArray){
        System.out.println("\n- 使用泛型 <E> E[] 進行遍歷 -");

        StringBuffer sb = new StringBuffer();
        for( E element: inputArray){
            sb.append(element).append(", ");
        }
        System.out.println(sb);
    }

    public static <K, V> void setPrintMap ( K mykey, V myvalue ) {
        System.out.println("\n- 使用泛型 <K, T> 進行 map 操作 -");

        Map<K, V> map = new HashMap<K, V>();
        map.put(mykey, myvalue);

        Collection<V> col = map.values();
        Iterator<V> itr = col.iterator();

        while ( itr.hasNext() ){
            System.out.println(itr.next());
        }

        Set<Map.Entry<K, V>> set = map.entrySet();

        for (Map.Entry<K, V> myset: set){
            System.out.print(myset.getKey() + ": ");
            System.out.print(myset.getValue());
            System.out.println("");
        }
    }

    public static <T extends Comparable<T>> T maximun(T x, T y, T z){
        System.out.println("\n- 使用泛型 <T extends Comparable<T>> 進行比較 -");

        // 假設 x 初始是最大值
        T max = x;

        // compareTo 比較，較大返回 1 ，較小返回 -1
        if( y.compareTo(max) > 0 ){
            max = y;
        }else if( z.compareTo(max) > 0 ){
            max = z;
        }
        return max;

    }

    public static void getData (List<?> mylist){
        System.out.println("\n- 使用類型通配符 <?> 進行遍歷 -");

        for ( int i = 0; i < mylist.size(); i++ ){
            System.out.print( mylist.get(i) + ", " );
        }
        System.out.printf("\n");
    }

    public static void getDataOnlyNum (List<? extends Number> myList){
        System.out.println("\n- 使用類型通配符 <? extends Numbers> 來限定傳入類型為數字-");

        for ( int i = 0; i < myList.size(); i++ ){
            System.out.print( myList.get(i) + ", " );
        }
        System.out.printf("\n");
    }
}
