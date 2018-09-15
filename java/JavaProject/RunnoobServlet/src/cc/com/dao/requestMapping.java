package cc.com.dao;

import java.util.*;

public class requestMapping {
    private Map<String, String[]> map;

    public requestMapping(){}

    public void setMap(Map<String, String[]> map) {
        this.map = map;
    }

    public Map<String, String[]> getMap() {
        return map;
    }

    public void printProperties() {
        Set<Map.Entry<String, String[]>> Set = map.entrySet();
        Iterator<Map.Entry<String, String[]>> itr = Set.iterator();

        while(itr.hasNext()){
            Map.Entry<String, String[]> each = itr.next();
            System.out.print(each.getKey() + " : ");

            String[] values = each.getValue();
            for ( int i = 0; i < values.length; i++){
                System.out.print(values[i]);
                if ( i != values.length - 1){
                    System.out.print(", ");
                }else{
                    System.out.print("\n");
                }
            }
        }
    }
}
