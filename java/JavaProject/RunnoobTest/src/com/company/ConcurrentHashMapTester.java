package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTester {
    public ConcurrentHashMapTester(){
        System.out.println("\n***** ConcurrentHashMapTester *****");
        /**
         * 單線程效能比 HashMap 更差
         * 多線程效能與 HashMap 相當，但 ConcurrentHashMap 具備線程安全
         */

        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("name", "joey");
        map.put("email", "tsuyiren@gmail.com");
        map.put("phone", "+886937472767");


        System.out.println("\n- for loop set -");
        Set<String> set = map.keySet();
         for (String s:set){
             String value = map.get(s);

             System.out.printf("%s: %s\n", s, value);
         }

        System.out.println("\n- iterator key set -");
         Set<Map.Entry<String, String>> setEntry = map.entrySet();
        Iterator<Map.Entry<String, String>> itr = setEntry.iterator();

        while(itr.hasNext()){
            Map.Entry<String, String> thisMap = itr.next();
            String key = thisMap.getKey();
            String value = thisMap.getValue();

            System.out.printf("%s: %s\n", key, value);
        }

        System.out.println("\n- only value set -");
        Collection<String> col = map.values();
        Iterator<String> colItr = col.iterator();

        while(colItr.hasNext()){
            System.out.println(colItr.next());
        }

    }
}
