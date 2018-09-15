package com.company;

import java.util.*;

public class HashMapTester {

    public HashMapTester(){
        System.out.println("\n***** HashMapTester *****");

        // 會紀錄插入順序
        Map<String, String> map = new LinkedHashMap<String, String>();
        // 會按照 key 自動排序
//        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "joey");
        map.put("email", "tsuyiren@gmail.com");
        map.put("address", "台中市北區太原八街30號2樓D室");

        boolean name = map.containsKey("name");
        boolean phone = map.containsKey("phont");
        boolean joey = map.containsValue("joey");

        System.out.printf("Map 中是否存在 name 的 key: %b\n" +
                "Map 中是否存在 phone 的 key: %b\n" +
                "Map 中是否存在 joey 這個 value: %b\n", name, phone, joey);

        System.out.println("\n- iterator key set -");
        Set<String> set = map.keySet();
        Iterator<String> itr = set.iterator();

        while( itr.hasNext() ){
            String key = itr.next();
            String value = map.get( key );
            System.out.printf("%s: %s\n", key, value);
        }

        System.out.println("\n- map entry set -");
        Set<Map.Entry<String, String>> entry = map.entrySet();
        Iterator<Map.Entry<String, String>> itrEntry = entry.iterator();

        while ( itrEntry.hasNext() ){
            Map.Entry<String, String> thisEntry = itrEntry.next();
            String key = thisEntry.getKey();
            String value = thisEntry.getValue();
            System.out.printf("%s: %s\n", key, value);
        }

        System.out.println("\n- only value -");
        Collection<String> col = map.values();
        Iterator<String> itrCollection = col.iterator();

        while( itrCollection.hasNext() ){
            String value = itrCollection.next();
            System.out.println( value );
        }
    }

}
