import java.util.*;

class Solution {
    // int[] arr = new int[1000001];

    // public void add(int key) {
    // //Complete the function
    // arr[key] = 1;
    // }

    // public void remove(int key) {
    // //Complete the function
    // arr[key] = 0;
    // }

    // public boolean contains(int key) {
    // //Complete the function
    // if (arr[key] == 0) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    List<Integer>[] hashTable;
    int size = 750000;

    Solution() {
        hashTable = new LinkedList[size];
    }

    public int hashFunction (int key) {
        return key % size;
    }

    public void add(int key) {
        // Complete the function
        int i = hashFunction(key);

        if (hashTable[i] == null) {
            hashTable[i] = new LinkedList<>();
        }

        if (hashTable[i].indexOf(key) == -1) {
            hashTable[i].add(key);
        }
    }

    public void remove(int key) {
        // Complete the function
        int i = hashFunction(key);

        if (hashTable[i] == null) {
            return;
        }

        if (hashTable[i].indexOf(key) != -1) {
            hashTable[i].remove(hashTable[i].indexOf(key));
        }
    }

    public boolean contains(int key) {
        // Complete the function
        int i = hashFunction(key);

        if (hashTable[i] == null || hashTable[i].indexOf(key) == -1) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}