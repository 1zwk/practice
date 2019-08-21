import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithQueue {


    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int v = queue.poll();
            queue.add(v);
        }
        return queue.poll();
    }

    public int peek() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int v = queue.poll();
            queue.add(v);
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}

