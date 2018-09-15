package com.company;

import java.util.*;

public class GenericsType {

    public GenericsType(){
        System.out.println("\n***** CollectionFramworks 泛型 *****");

        Integer[] ints = { 1, 2, 4, 8, 10 };
        Double[] doubles = { .34, 1.3, 2.5, .97 };
        Character[] chars = { 'A', 'B', 'C' };
        String[] strs = {"i", "am", "joey"};

        printArray(ints);
        printArray(doubles);
        printArray(chars);
        printArray(strs);

        setPrintMap(new String("ID"), new Integer(6744));
    }

    public static <E> void printArray( E[] inputArray){
        StringBuffer sb = new StringBuffer();
        for( E element: inputArray){
            sb.append(element).append(", ");
        }
        System.out.println(sb);
    }

    public static <K, V> void setPrintMap ( K mykey, V myvalue ) {
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
}
