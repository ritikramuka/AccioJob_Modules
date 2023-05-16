import java.util.*;

class Main {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();
        
        // enqueue operation
        que.add(10);
        que.add(20);
        que.add(30);
        que.add(-100);
        
        // front operation
        int frontEle = que.peek();
        System.out.println(frontEle);
        
        // dequeue operation
        while (que.size() != 0) {
            System.out.println(que.remove());
        }
    }
}