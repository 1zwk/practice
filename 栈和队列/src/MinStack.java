import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MinStack() {

    }

    public void add(int x) {
        stack1.push(x);
    }

    public int  poll() {
        if (stack2.empty()) {
            while(!(stack1.empty())){
                int v = stack1.pop();
                stack2.push(v);
            }
        }
        return stack2.pop();
    }

    public int top() {
        if (stack2.empty()) {
            while(!(stack1.empty())){
                int v = stack1.pop();
                stack2.push(v);
            }
        }
        return stack2.peek();
    }

    public int getMin() {
        

    }
}
