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

	Node () {}

	Node(int key, int value) {
		this.key = key;
		this.value = value;

		this.next = null;
		this.prev = null;
	}
}

// TC : O(1)
class LRUCache {
	Node head;
	Node tail;
	int maxCapacity;

	HashMap<Integer, Node> map;

	private void addLast (Node node) {
		Node temp = tail.prev;

		node.next = tail;
		tail.prev = node;

		temp.next = node;
		node.prev = temp;
	}

	private void removeNode (Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		node.next = null;
		node.prev = null;
	}

	private void moveToLast (Node node) {
		removeNode(node);
		addLast(node);
	}
	
    // your code here
    public LRUCache(int capacity) {
        // your code here
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;

		maxCapacity = capacity;

		map = new HashMap<>();
    }

    public int get(int key) {
        // your code here
		if (map.containsKey(key) == false) {
			return -1;
		} else {
			Node node = map.get(key);
			int value = node.value;
			moveToLast(node);
			return value;
		}
    }

    public void set(int key, int value) {
        // your code here
		if (map.containsKey(key) == false) {
			Node node = new Node(key, value);

			if (map.size() == maxCapacity) {
				Node LRU_Node = head.next;
				removeNode(LRU_Node);
				map.remove(LRU_Node.key);
			}

			addLast(node);
			map.put(key, node);
		} else {
			Node node = map.get(key);
			node.value = value;
			moveToLast(node);
		}
    }

}