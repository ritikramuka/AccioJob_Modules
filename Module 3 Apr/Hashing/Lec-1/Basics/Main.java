import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
       
        // insert in hashmap
        map.put(1, "Accio");
        map.put(3, "Ritik");
        map.put(2, "Hamza");

        // search in hashmap
        if (map.containsKey(2) == true) {
            System.out.println("Yes, and value against this is key is " + map.get(2));
        }

        System.out.println(map.containsKey(4));

        // delete from a map
        // map.remove(2);
        // if (map.containsKey(2) == true) {
        //     System.out.println("Yes, and value against this is key is " + map.get(2));
        // } else {
        //     System.out.println("Not found");
        // }

        // map.remove(3, "Ritik");
        // System.out.println(map.containsKey(3));

        // getOrDefault
        System.out.println(map.get(4));
            
        String ans = map.getOrDefault(4, "Eeeeeeeeee");
        System.out.println(ans);

        // update
        System.out.println(map.get(2));
        map.put(2, "Rohan");
        System.out.println(map.get(2));

        // loop around
        for (int key : map.keySet()) {
            System.out.println("key" + " " + key + " value " + map.get(key));
        }
        System.out.println("=================================================");

        // HashSet
        HashSet<String> set = new HashSet<>();
        set.add("Accio");
        set.add("Accio");
        set.add("Ritik");
        set.add("accio");

        for (String str : set) {
            System.out.println(str);
        }

        set.remove("Ritik");

        for (String str : set) {
            System.out.println(str);
        }

        if (set.contains("ritik") == true) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }
}
