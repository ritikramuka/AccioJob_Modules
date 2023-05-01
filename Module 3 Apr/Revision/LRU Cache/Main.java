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
		
	}

	Node (int key, int value) {
		this.key = key;
		this.value = value;
	}

	void updateValue (int value) {
		this.value = value;
	}
}

class LRUCache {
    // your code here

	Node head;
	Node tail;
	int size;
	HashMap<Integer, Node> map;
	
	public LRUCache(int capacity) {
        // your code here
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = capacity;
		map = new HashMap<>();
    }

	void addFront(Node node) {
		Node temp = head.next;
		head.next = node;
		node.prev = head;
		node.next = temp;
		temp.prev = node;
	}

	void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		node.next = null;
		node.prev = null;
	}

	void moveToFront(Node node) {
		removeNode(node);
		addFront(node);
	}

	// TC: O(1)
    public int get(int key) {
        // your code here
		if (map.containsKey(key) == true) {
			Node node = map.get(key);
			moveToFront(node);
			return node.value;
		} else {
			return -1;
		}
    }

	// TC: O(1)
    public void set(int key, int value) {
        // your code here
		if (map.containsKey(key) == true) {
			// updating
			Node node = map.get(key);
			node.updateValue(value);
			moveToFront(node);
		} else {
			Node node = new Node(key, value);
			if (map.size() == size) {
				Node LRU_Node = tail.prev;
				removeNode(LRU_Node);
				map.remove(LRU_Node.key);
			} 
			addFront(node);
			map.put(key, node);
		}
    }
}