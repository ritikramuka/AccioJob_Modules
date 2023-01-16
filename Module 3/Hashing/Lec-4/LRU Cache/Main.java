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
    int val;

    Node next;
    Node prev;

    Node() {
        this.key = 0;
        this.val = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    // your code here

    void addNode(Node node) {
        // add a node in front
        Node A = head.next;

        node.next = A;
        node.prev = head;

        A.prev = node;
        head.next = node;
    }

    void removeNode(Node node) {
        // remove given node
        Node A = node.prev;
        Node B = node.next;

        A.next = B;
        B.prev = A;

        node.prev = null;
        node.next = null;
    }

    void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    Node head;
    Node tail;
    int maxCapacity;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        // your code here
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        // your code here
        if (cache.containsKey(key) == false) {
            return -1;
        } else {
            Node node = cache.get(key);
            moveToFront(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        // your code here
        // cases: 1. updating a value,
        //        2. opening a fresh application

        if (cache.containsKey(key) == true) {
            // case 1.
            Node node = cache.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            // case 2.
            Node node = new Node(key, value);

            if (cache.size() == maxCapacity) {
                Node LRU_Node = tail.prev;
                cache.remove(LRU_Node.key);
                removeNode(LRU_Node);
            }

            cache.put(key, node);
            addNode(node);
        }
    }

}