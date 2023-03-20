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

    Node prev;
    Node next;

    Node() {
        this.key = 0;
        this.value = 0;
        this.prev = null;
        this.next = null;
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    // your code here

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

        maxCapacity = capacity;

        cache = new HashMap<>();
    }

    public void addFirst(Node node) {
        Node A = head.next;

        node.next = A;
        A.prev = node;

        head.next = node;
        node.prev = head;
    }

    public void removeNode(Node node) {
        Node A = node.prev;
        Node B = node.next;

        A.next = B;
        B.prev = A;

        node.prev = null;
        node.next = null;
    }

    public void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    public int get(int key) {
        // your code here
        if (cache.containsKey(key) == false) {
            return -1;
        }

        Node application = cache.get(key);
        moveToFront(application);
        return application.value;
    }

    public void set(int key, int value) {
        // your code here
        // cases: case 1: new application
        // case 2: update a prev application

        if (cache.containsKey(key) == true) {
            // case 2: trying to update
            Node application = cache.get(key);
            application.value = value;
            moveToFront(application);
        } else {
            // case 1: new application is opened
            Node application = new Node(key, value);

            // step 1: check space in cache?
            // if not available, do what?
            // remove LRU
            if (cache.size() == maxCapacity) {
                Node LRU = tail.prev;
                removeNode(LRU);
                cache.remove(LRU.key);
            }

            // step 2: add this application
            addFirst(application);
            cache.put(key, application);
        }
    }

}