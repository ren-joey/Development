package com.company;

import org.apache.commons.collections4.map.HashedMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionFramworks {

    public CollectionFramworks(){
        System.out.println("\n***** CollectionFramworks 集合框架 *****");
        /**
         * http://www.runoob.com/java/java-collections.html
         */

        List<Object> arraylist = new ArrayList<Object>();
        List<Object> linkedlist = new LinkedList<Object>();

        Set<Object> hashset = new HashSet<Object>();
        Set<Object> linkedhashset = new LinkedHashSet<Object>();

        Map<String, Object> hashmap = new HashedMap<String, Object>();
        Map<String, Object> linkedhashmap = new LinkedHashMap<String, Object>();
        Map<String, Object> hashtable = new Hashtable<String, Object>();
        Map<String, Object> concurrenthashmap = new ConcurrentHashMap<String, Object>();
        Map<String, Object> linkedconcurrenthashmap = Collections.synchronizedMap(new LinkedHashMap<String, Object>());


        /**
         * Put numbers
         */
        arraylist.add( new Integer(16) );

        hashset.add( new Integer(44) );

        hashmap.put( "name", new String("joey") );
        hashmap.put( "email", new String("tsuyiren@gmail.com") );
        linkedconcurrenthashmap.put( "name", new String("joey") );
        linkedconcurrenthashmap.put( "email", new String("tsuyiren@gmail.com") );


        /**
         * Iterator
         */
        Iterator<Object> arraylist_itr = arraylist.iterator();
        while ( arraylist_itr.hasNext() ){
            arraylist_itr.next();
        }

        Iterator<Object> hashset_itr = hashset.iterator();
        while ( hashset_itr.hasNext() ){
            hashset_itr.next();
        }

        Set<String> hashmapkeyset = hashmap.keySet();
        Iterator<String> itrkeyset = hashmapkeyset.iterator();
        while ( itrkeyset.hasNext() ){
            hashmap.get( itrkeyset.next() );
        }

        /**
         * ForEach
         */

        for(Object thisdata: arraylist){
            String str = thisdata.toString();
            System.out.println(str);
        }

        for(Object thisset: hashset){
            String str = thisset.toString();
            System.out.println(str);
        }

        Set<Map.Entry<String, Object>> hashmapentry = linkedconcurrenthashmap.entrySet();
        for (Map.Entry<String, Object> thisentry: hashmapentry){
            System.out.printf("%s: %s\n", thisentry.getKey(), thisentry.getValue());
        }

    }
}
