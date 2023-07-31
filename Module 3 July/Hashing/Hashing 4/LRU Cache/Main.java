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

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	Node() {
	}
}

class LRUCache {
    // your code here
	Node dh;
	Node dt;
	int maxCap;

	HashMap<Integer, Node> map = new HashMap();
	
    public LRUCache(int capacity) {
        // your code here
		dh = new Node();
		dt = new Node();

		dh.next = dt;
		dt.prev = dh;

		maxCap = capacity;
    }

	void addLast(Node node) {
		Node prevNode = dt.prev;
		
		dt.prev = node;
		node.next = dt;
		
		prevNode.next = node;
		node.prev = prevNode;
	}

	void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		node.next = null;
		node.prev = null;
	}

	void moveToLast(Node node) {
		removeNode(node);
		addLast(node);
	}

    public int get(int key) {
        // your code here
		if (map.containsKey(key) == true) {
			Node node = map.get(key);
			moveToLast(node);
			return node.value;
		} else {
			return -1;
		}
    }

    public void set(int key, int value) {
        // your code here
		if (map.containsKey(key) == true) {
			Node node = map.get(key);
			node.value = value;
			moveToLast(node);
		} else {
			// adding a new application to cache
			if (map.size() == maxCap) {
				Node LRU_NODE = dh.next;
				removeNode(LRU_NODE);
				map.remove(LRU_NODE.key);
			}

			Node node = new Node(key, value);

			map.put(key, node);
			
			addLast(node);
		}
    }

}