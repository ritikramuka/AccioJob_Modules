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

	Node () {
		this.key = 0;
		this.value = 0;
		this.next = null;
		this.prev = null;
	}

	Node (int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

class LRUCache {
	Node head;
	Node tail;

	HashMap<Integer, Node> cache;

	int limit;
	
    // your code here
    public LRUCache(int capacity) {
        // your code here
		limit = capacity;
		
		cache = new HashMap<>();

		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
    }

	// TC: O(1)
	// add application to the MRU position
	public void addLast(Node node) {
		Node prevNode = tail.prev;

		prevNode.next = node;
		node.prev = prevNode;

		node.next = tail;
		tail.prev = node;
	}

	// TC: O(1)
	// remove application from cache
	public void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		node.prev = null;
		node.next = null;
	}

	// TC: O(1)
	// move a application to MRU position from anyb position
	public void moveToLast(Node node) {
		removeNode(node);
		addLast(node);
	}

	// TC: O(1)
    public int get(int key) {
        // your code here
		if (cache.containsKey(key) == false) {
			return -1;
		} else {
			Node node = cache.get(key);
			int value = node.value;
			moveToLast(node);
			return value;
		}
    }

	// TC: O(1)
    public void set(int key, int value) {
        // your code here

		if (cache.containsKey(key) == true) {
			// your dll has this application, hence you have reopened it
			Node node = cache.get(key);

			node.value = value;

			moveToLast(node);
		} else {
			// seen for the first time
			Node node = new Node(key, value);

			if (cache.size() == limit) {
				// remove the LRU Application
				Node LRU_Node = head.next;
				removeNode(LRU_Node);
				cache.remove(LRU_Node.key);
			}

			addLast(node);
			cache.put(key, node);
		}
    }

}