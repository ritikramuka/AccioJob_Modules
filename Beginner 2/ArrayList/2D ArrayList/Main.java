import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(10);
        list.get(1).add(20);
    }    
}
