import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> mymap = new HashMap<>();

        mymap.put("Ritik", 21);

        mymap.put("Accio", 23);

        mymap.put("Ajay", 33);

        for (Map.Entry m : mymap.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

        System.out.println("===========================");

        // mymap.remove("Ajay");

        // mymap.remove("Ritik", 21);

        // for (Map.Entry m : mymap.entrySet()) {
        //     System.out.println(m.getKey());
        //     System.out.println(m.getValue());
        // }

        System.out.println(mymap.get("Rohan"));

        System.out.println(mymap.getOrDefault("Rohan", 0));

        if(mymap.containsKey("Accio")) {
            System.out.println("Hello");
        }

        for (String myKeys : mymap.keySet()) {
            System.out.println(myKeys);
        }
    }
}
