import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt(), q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                s += " " + sc.nextInt();
            else
                s += " " + sc.nextInt() + " " + sc.nextInt();
            queries[i] = s;
        }
        sc.close();
        LRUCache lruCache = new LRUCache(cap);
        for (String s : queries) {
            String[] arr = s.split(" ");
            if (arr.length == 3)
                lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            else
                System.out.println(lruCache.get(Integer.parseInt(arr[1])));
        }
    }
}

class Node {
    int key;
    int value;

    Node next;
    Node prev;

    Node() {
        this.key = 0;
        this.value = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    // your code here
    Node head;
    Node tail;

    int maxCapacity;

    // map is key, address
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        // your code here
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        maxCapacity = capacity;
        map = new HashMap<>();
    }

    // TC: O(1)
    void removeNode(Node node) {
        Node A = node.prev;
        Node B = node.next;

        A.next = B;
        B.prev = A;

        node.next = null;
        node.prev = null;
    }

    // TC: O(1)
    void addAtFront(Node node) {
        Node A = head.next;

        node.next = A;
        node.prev = head;

        head.next = node;
        A.prev = node;
    }

    // TC: O(1)
    void moveToFront(Node node) {
        removeNode(node);
        addAtFront(node);
    }

    // TC: O(1)
    public int get(int key) {
        // your code here
        if (map.containsKey(key) == false) {
            return -1;
        } else {
            Node node = map.get(key);
            int value = node.value;
            moveToFront(node);
            return value;
        }
    }

    // TC: O(1)
    public void set(int key, int value) {
        // your code here
        if (map.containsKey(key) == true) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);

            // check is capacity full
            if (map.size() == maxCapacity) {
                // remove LRU
                Node LRU_Node = tail.prev;
                removeNode(LRU_Node);
                map.remove(LRU_Node.key);
            }

            map.put(key, node);
            addAtFront(node);
        }
    }

}