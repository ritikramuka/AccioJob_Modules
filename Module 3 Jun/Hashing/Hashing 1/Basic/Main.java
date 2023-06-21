import java.util.*;

public class Main {
    public static void main(String[] args) {
        // declare a hashmap
        // key -> String, value -> Integer
        HashMap<String, Integer> map = new HashMap<>();

        // put method: insert a key -> value pair in a hashmap
        // if key is already presnt, put method update the prev value
        // TC: O(1)
        map.put("Chips", 2);
        map.put("Coke", 2);
        map.put("Penut Butter", 1);
        map.put("Bars", 10);
        map.put("Coke", 4);

        // iterate over a hashmap
        // keySet method: returns a set of all the keys in the map
        // to get value agaist a key from a map, you can use get method
        // TC (get): O(1) 
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // size of hashmap
        System.out.println(map.size());

        System.out.println(map.get("Bread"));

        // get OR Default
        // method: getOrDefault(key, default_value)
        System.out.println(map.getOrDefault("Bread", 0));

        // containsKey
        // is the key present or not
        if (map.containsKey("Bread") == true) {
            System.out.println("Yes my cart has bread");
        } else {
            System.out.println("My cart doesn't have bread");
        }

        // remove from hasmap
        map.remove("Chips");

        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("---------------------");

        map.remove("Coke", 4);
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }


        System.out.println("==========================HashSet=========================");
        // HashSet -> stores unique entity

        HashSet<Integer> set = new HashSet<>();

        // insert value in a hashset
        // add method
        set.add(10);
        set.add(20);
        set.add(50);
        set.add(10);

        // iterate over a hashset
        for (int val : set) {
            System.out.println(val);
        }

        // is present in set or not
        if (set.contains(10) == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // remove
        set.remove(10);

        if (set.contains(10) == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
