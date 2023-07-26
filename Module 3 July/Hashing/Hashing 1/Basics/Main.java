import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("<------------ HashSet ------------->");

        // declare a hashset
        HashSet<Integer> set = new HashSet<>();

        // add elements to my hashset
        set.add(10);
        set.add(20);
        set.add(44);
        set.add(10);
        set.add(34);

        // print hashset
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // remove an ele
        set.remove(44);

        // print hashset
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // find an ele
        if (set.contains(44) == true) {
            System.out.println("My set has value: " + 44);
        } else {
            System.out.println("My set doesn't have value: " + 44);
        }

        System.out.println("<------------ HashMap ------------->");

        // declare a hashmap, Key -> String, Value -> Integer
        HashMap<String, Integer> map = new HashMap<>();

        // add key, value pairs in hashmap
        map.put("Lays", 2);
        map.put("Frooti", 3);
        map.put("Penut Butter", 1);

        // print a hashmap
        for (String key : map.keySet()) {
            System.out.println(key + " --> " + map.get(key));
        }

        // update a key, value pair
        map.put("Lays", 3);

        // print a hashmap
        for (String key : map.keySet()) {
            System.out.println(key + " --> " + map.get(key));
        }

        // remove a k,v pair from map
        // map.remove("Frooti");
        map.remove("Frooti", 3);

        // print a hashmap
        for (String key : map.keySet()) {
            System.out.println(key + " --> " + map.get(key));
        }

        // getOrDefault : try to get value against a key, but if key is not present return a default value
        System.out.println(map.getOrDefault("Oreo", -1));
        System.out.println(map.get("Oreo"));

        // searching
        if (map.containsKey("Lays") == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
