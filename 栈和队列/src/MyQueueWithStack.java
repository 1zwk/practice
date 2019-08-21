import java.util.Stack;

public class MyQueueWithStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(int x) {
        stack1.push(x);
    }

    public int poll() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                int v = stack1.pop();
                stack2.push(v);
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while(!(stack1.empty())){
                int v = stack1.pop();
                stack2.push(v);
            }
        }
        return stack2.peek();
    }

    public boolean emplty() {
        return stack1.empty() && stack2.empty();
    }
}
