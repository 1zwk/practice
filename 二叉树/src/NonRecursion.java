import java.util.Stack;

public class NonRecursion {
    //非递归前序：
    public static void preorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //非递归中序：
    public static void inorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();//需要使用到工具栈。
        Node cur = root;//记录当前走到的节点。

        while (!stack.empty() || cur != null) {//进栈出栈(只有栈不为空，并且cur不等于空才进)
            while (cur != null) {//进栈（非空元素）

                stack.push(cur);//把cur进栈，
                cur = cur.left;// 并且让循环往左走，
            }
            Node top = stack.pop();//让首元素出栈，并且记录元素
            System.out.println(top.val);//打印出栈元素。
            cur = top.right;//使循环往右走。
        }
    }

    //非迭代遍历
    public static void postorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();//工具栈
        Node cur = root;//记录当前位置
        Node last = null;//记录上一个被三次完成经过的节点（出栈得节点）

        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if(top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else{
                cur = top.right;
            }

        }
    }
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        n1.left = new Node();
        n1.left.val = 2;
        n1.right = new Node();
        n1.right.val = 3;
        n1.left.left = new Node();
        n1.left.left.val = 4;

        preorderNoR(n1);
        System.out.println("**************");
        inorderNoR(n1);
        System.out.println("**************");
        postorderNoR(n1);
    }
}
