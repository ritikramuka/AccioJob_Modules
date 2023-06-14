import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Method 1 to define que
        Queue<String> que = new ArrayDeque<>();

        que.add("Apple");

        que.add("Orange");

        que.add("Mango");

        que.add("Banana");

        System.out.println(que.peek());

        System.out.println(que.size());

        System.out.println(que.remove());

        System.out.println(que.size());


        // Method 2 to define que
        Queue<Integer> que2 = new LinkedList<>();

        que2.offer(10);

        que2.offer(20);

        que2.offer(30);

        System.out.println(que2.peek());

        System.out.println(que2.poll());

        System.out.println(que2.size());
    }
}
