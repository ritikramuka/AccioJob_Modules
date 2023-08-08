import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // declare
        ArrayList<Integer> myList = new ArrayList<>();

        // add ele
        myList.add(10);
        myList.add(20);
        myList.add(30);

        // get size
        System.out.println("size: " + myList.size());

        // get ele
        System.out.println(myList.get(1));

        // remove ele
        myList.remove(0);

        System.out.println(myList.get(0));

        System.out.println(myList.size());

        // user input
        Scanner scn = new Scanner(System.in);

        ArrayList<Integer> myList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int a = scn.nextInt();
            myList2.add(a);
        }

        for (int i = 0; i < myList2.size(); i++) {
            System.out.print(myList2.get(i) + " ");
        }


        // static array
        // int[] arr = new int[3];
        // arr[0] = 10;
        // arr[1] = 20;
        // arr[2] = 30;

        // System.out.println(arr.length);

        // System.out.println(arr[1]);
    }
}