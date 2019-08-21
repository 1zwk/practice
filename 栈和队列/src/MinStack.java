/**
 * 求能保存一组数据最小值得一个栈（即调用getMin()就立即可以显示这组数据的最小值）；
 */

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack1.push(x);
        if (min.empty()) {
            min.push(x);
        } else {
            int n = min.peek();
            if (x <= n) {
                min.push(x);
            } else {
                min.push(n);
            }
        }
    }
    public int pop() {
        min.pop();
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
