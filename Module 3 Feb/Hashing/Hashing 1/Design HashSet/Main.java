import java.util.*;

class Solution {
    // int[] set = new int[1000000];

    // Solution () {
    // Arrays.fill(set, -1);
    // }

    // public void add(int key) {
    // // Complete the function
    // set[key] = key;
    // }

    // public void remove(int key) {
    // // Complete the function
    // set[key] = -1;
    // }

    // public boolean contains(int key) {
    // // Complete the function
    // if (set[key] == -1) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    // size = 1000000 * 0.75
    int size = 750000;
    List<Integer>[] hashTable;

    Solution() {
        hashTable = new LinkedList[size];
    }

    int hashFunction(int key) {
        return key % size;
    }

    public void add(int key) {
        // Complete the function
        int hashValue = hashFunction(key);

        if (hashTable[hashValue] == null) {
            hashTable[hashValue] = new LinkedList<>();
        }

        if (hashTable[hashValue].indexOf(key) == -1) {
            hashTable[hashValue].add(key);
        }
    }

    public void remove(int key) {
        // Complete the function
        int hashValue = hashFunction(key);

        if (hashTable[hashValue] == null) {
            return;
        }

        if (hashTable[hashValue].indexOf(key) != -1) {
            hashTable[hashValue].remove(hashTable[hashValue].indexOf(key));
        }
    }

    public boolean contains(int key) {
        // Complete the function
        int hashValue = hashFunction(key);

        if (hashTable[hashValue] == null) {
            return false;
        }

        if (hashTable[hashValue].indexOf(key) != -1) {
            return true;
        } else {
            return false;
        }
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