import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> mymap = new HashMap<>();

        // add key, value pair in map
        mymap.put(1, "Ritik");
        mymap.put(3, "Rohan");
        mymap.put(2, "Ananya");
        mymap.put(4, "Rockey");

        // print these values, or see them
        // how to loop around
        // for (Map.Entry m : mymap.entrySet()) {
        //     System.out.print(m.getKey() + ", ");
        //     System.out.println(m.getValue());
        // }

        // remove
        // mymap.remove(2);
        // for (Map.Entry m : mymap.entrySet()) {
        //     System.out.print(m.getKey() + ", ");
        //     System.out.println(m.getValue());
        // }

        // System.out.println(mymap.getOrDefault(5, "Accio"));
        
        // loop
        for (int key : mymap.keySet()) {
            System.out.print(key + ", ");
            System.out.println(mymap.get(key));
        }

        // contains that key, yes or no
        if (mymap.containsKey(9) == false) {
            System.out.println("Doesn't contain");
        } else {
            System.out.println("Contains");
        }
    }
}
