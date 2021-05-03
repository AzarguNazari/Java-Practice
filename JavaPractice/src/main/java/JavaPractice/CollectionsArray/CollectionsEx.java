package JavaPractice.CollectionsArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class CollectionsEx {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2 = new LinkedList<>();
        
        Map<String, String> map = new TreeMap<>();
                            map = new HashMap<>();
        
        Set<String> set = new TreeSet<>();  
                    set = new HashSet<>();
                            
        /**
         *  Operations:
         *      --> Add new Item
         *      --> Retrive item
         *      --> Delete Item
         *      --> Join Items
         *      --> Search Item
         *      --> Change Items
         *      --> Clone item
         *      --> Sort Items
         *      --> Iterate Items
         *      --> Make it empty
         */

        
        list2 = Collections.EMPTY_LIST; // returns an empty list
        map = Collections.EMPTY_MAP;    // return an empty map
        set = Collections.EMPTY_SET; // returns an empty set
        
        /*
            ----- Operations using Collections library
                        --> Add items
                        --> Binary Search
                        --> Copy items between collections
                        --> Sort collections
                        --> Check the type safety of elements
                        --> Making the collections unmodfiable
                        --> Making the collections synchronized
                        --> Making collections immutable
                        --> Swaping elements of collections
                        --> Replace
                        --> Min, Max
                        --> Revsering list
        */
    }

}
