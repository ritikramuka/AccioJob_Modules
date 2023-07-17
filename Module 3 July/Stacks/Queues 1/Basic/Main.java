import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();

        que.add(10);
        que.add(20);
        que.add(30);

        System.out.println("size: " + que.size());

        System.out.println("peek: " + que.peek());

        System.out.println("remove: " + que.remove());
        
        System.out.println("size: " + que.size());

        System.out.println("peek: " + que.peek());

        
        Queue<Integer> que2 = new LinkedList<>();

        que2.offer(10);
        que2.offer(20);
        que2.offer(30);

        System.out.println("size: " + que2.size());

        System.out.println("peek: " + que2.peek());

        System.out.println("remove: " + que2.poll());

        System.out.println("size: " + que2.size());

        System.out.println("peek: " + que2.peek());
    }
}