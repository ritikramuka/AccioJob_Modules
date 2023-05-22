import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // key -> Integer, Value -> String
        HashMap<Integer, String> map = new HashMap<>();

        // put method: add key, value pair in a map, 
        // if this key exist then it updates that key value pair
        map.put(1, "Accio");
        map.put(2, "Shiva");
        map.put(10, "Raju");
        map.put(4, "Engineer");

        // to iterate over hashmap, first you get all the keys in the map, by keySet() method
        // apply for each loop to iterate over all the keys
        // to get value corresponding to a key use get() method
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println("----------------");

        map.put(4, "Rohan");

        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println("----------------");

        System.out.println(map.size());

        System.out.println("----------------");

        // remove from hashmap
        map.remove(4);
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println("----------------");

        map.remove(10, "Raju");
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println("----------------");

        // getORDeafult: try to get a value corresponding to the key, if not found return default value
        System.out.println(map.getOrDefault(20, "Not Found"));

        System.out.println("----------------");

        map.put(20, "Accio");
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // containsKey() -> is the key present or not
        if (map.containsKey(10) == true) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }

        System.out.println("<-------- HashSet -------->");
        HashSet<Integer> set = new HashSet<>();

        // add elements to hashset
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        // print set
        for (int e : set) {
            System.out.println(e);
        }

        System.out.println("----------------");

        // remove
        set.remove(10);
        for (int e : set) {
            System.out.println(e);
        }

        // find in set
        if (set.contains(20) == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
