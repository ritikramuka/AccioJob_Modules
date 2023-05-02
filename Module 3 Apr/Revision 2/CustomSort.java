import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomSort {

    static void fun() {
        Integer[] arr = {2, 1, 10, 3, 44, 21, -10};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun2() {
        Integer[] arr = {2, 1, 10, 3, 44, 21, -10};

        // term a -> this, b -> other, so this - other gives default behaviour
        // other - this, reverse of default behaviour
        Arrays.sort(arr, (a, b) -> {
            // return value expected in form
            // 1. -ve number
            // 2. +ve number
            // 3. 0 
            
            // if (a < b) {
            //     return -1000;
            // } else if (a > b) {
            //     return 1;
            // } else {
            //     return 0;
            // }

            return a - b;
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun3() {
        Integer[] arr = {2, 1, 10, 3, 44, 21, -10};

        Arrays.sort(arr, (a, b) -> {
            // return value expected in form
            // 1. -ve number
            // 2. +ve number
            // 3. 0 

            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            } else {
                return 0;
            }

            // return b - a;
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun4() {
        Integer[] arr = {2, 1, 10, 3, 44, 21, -10};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(list, (x, y) -> {
            return x - y;
        });

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " ");

        System.out.println();
    }

    static void fun5() {
        Integer[] arr = {2, 1, 10, 3, 44, 21, -10};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(list, (x, y) -> {
            return y - x;
        });

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " ");

        System.out.println();
    }

    static void fun6() {
        String[] arr = {"apple", "banana", "peach", "mango", "orange", "watermelon"};

        // sort this string array such that length is in inc. order
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun7() {
        String[] arr = {"apple", "banana", "mango", "orange", "watermelon", "peach"};

        // sort this string array such that length is in dec. order
        Arrays.sort(arr, (a, b) -> {
            return b.length() - a.length();
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun8() {
        String[] arr = {"apple", "banana", "peach", "mango", "orange", "watermelon"};

        // sort this string array in lexo order
        Arrays.sort(arr, (a, b) -> {
            return a.compareTo(b);
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun9() {
        String[] arr = {"apple", "banana", "mango", "orange", "watermelon", "peach"};

        // sort this string array in reverse lexo order
        Arrays.sort(arr, (a, b) -> {
            return b.compareTo(a);
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void fun10() {
        String[] arr = {"apple", "banana", "peach", "mango", "orange", "watermelon"};

        // sort this string array such that length is in inc. order, and when length is same, sort in lexo order
        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static class Pair {
        int key;
        int val;

        Pair () {
            this.key = 0;
            this.val = 0;
        }

        Pair (int key, int val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return "[" + this.key + " " + this.val + "]";
        }
    }

    static void fun11() {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(10, 20));
        list.add(new Pair(12, 21));
        list.add(new Pair(1, 2));
        list.add(new Pair(10, 19));
        list.add(new Pair(10, 22));
        list.add(new Pair(12, -20));

        Collections.sort(list, (a, b) -> {
            return a.key - b.key;
        });

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " "); 
 
        System.out.println();
    }

    static void fun12() {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(10, 20));
        list.add(new Pair(12, 21));
        list.add(new Pair(1, 2));
        list.add(new Pair(10, 19));
        list.add(new Pair(10, 22));
        list.add(new Pair(12, -20));

        // sort in terms of dec order of value
        Collections.sort(list, (a, b) -> {
            return b.val - a.val;
        });

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " "); 
 
        System.out.println();
    }

    static void fun13() {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(10, 20));
        list.add(new Pair(12, 21));
        list.add(new Pair(1, 2));
        list.add(new Pair(10, 19));
        list.add(new Pair(10, 22));
        list.add(new Pair(12, -20));

        // dec value of keys, but inc value of val when keys are same
        Collections.sort(list, (a, b) -> {
            if (a.key == b.key) {
                return a.val - b.val;
            } else {
                return b.key - a.key;
            }
        });

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " "); 
 
        System.out.println();
    }

    static class ABC implements Comparable<ABC> {
        int key;
        int val;

        ABC () {
            this.key = 0;
            this.val = 0;
        }

        ABC (int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int compareTo(ABC other) {
            return this.key - other.key;
        }

        public String toString() {
            return "[" + this.key + " " + this.val + "]";
        }
    }

    static void fun14() {
        ArrayList<ABC> list = new ArrayList<>();
        list.add(new ABC(10, 20));
        list.add(new ABC(12, 21));
        list.add(new ABC(1, 2));
        list.add(new ABC(10, 19));
        list.add(new ABC(10, 22));
        list.add(new ABC(12, -20));

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " "); 
 
        System.out.println();
    }

    public static void main(String[] args) {
        fun14();
    }
}
