import java.util.*;

public class TreeWithPreIn {
    public static class Node {
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val) {
            this.val = val;
        }
    }


    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = null;
        d.right = null;
        e.left = null;
        e.right = h;
        f.left = null;
        f.right = null;
        g.left = null;
        g.right = null;
        h.left = null;
        h.right = null;

        return a;
    }

    //用List
    public static Node buildTreeWithInPre(List<Character> preorder, List<Character> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTreeWithInPre(leftPreorder, leftInorder);
        root.left = left;
        List<Character> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Character> rightInorder = inorder.subList(leftCount, inorder.size());
        Node right = buildTreeWithInPre(rightPreorder, rightInorder);
        root.right = right;
        return root;
    }

    //用数组（错误）
    public static Node buildTreeWithInPre2(char[] preorder2, char[] inorder2) {
        char rootValue = preorder2[0];
        int leftCount = 0;//左子树的大小
        for (int i = 0; i < inorder2.length; i++) {
            if (inorder2[i] == rootValue) {
                leftCount = i;
            }
        }
        char[] leftInorder = new char[leftCount];
        for (int i = 0; i < leftCount; i++) {
            leftInorder[i] = inorder2[i];
        }
        char[] leftPreorder = new char[inorder2.length - leftCount - 1];
        for (int i = 1; i < 1 + inorder2.length - leftCount; i++) {
            leftPreorder[i - 1] = preorder2[i];
        }
        Node left = buildTreeWithInPre2(leftPreorder, leftInorder);
        Node root = new Node(rootValue);
        root.left = left;
        char[] rightPreorder = new char[preorder2.length - leftCount];
        for (int i = 0; i < preorder2.length - leftCount; i++) {
            rightPreorder[i] = preorder2[i + 1 + leftCount];
        }
        char[] rightInorder;
        return root;
    }

    //使用数组（正确）
    public static Node buildTreeWithInPre3(char[] preorder2, char[] inorder2) {
        if (preorder2.length == 0) {
            return null;
        }
        char rootValue = preorder2[0];
        int leftCount = 0;
        for (int i = 0; i < inorder2.length; i++) {
            if (inorder2[i] == rootValue) {
                leftCount = i;
            }
        }
        char[] leftPreorder = Arrays.copyOfRange(preorder2, 1, leftCount + 1);
        char[] rightPreorder = Arrays.copyOfRange(preorder2, leftCount + 1, preorder2.length);
        char[] leftInorder = Arrays.copyOfRange(inorder2, 0, leftCount);
        char[] rightInorder = Arrays.copyOfRange(inorder2, leftCount + 1, inorder2.length);
        Node root = new Node(rootValue);
        Node left = buildTreeWithInPre3(leftPreorder, rightInorder);
        Node right = buildTreeWithInPre3(rightPreorder, rightInorder);
        root.left = left;
        root.right = right;

        return root;
    }


    //只用前序来完成一个二叉树
    /*
    思路：首先在前序中把空的节点也用符号表示起来，同时方法需要返回两个值，一个是节点，
    一个值是使用掉的前序。故使用一个两个属性的类来保存，使可以返回两个值。
     */

    public static Node buildTreeWithInPre2(List<Character> preorder) {
        char rootValue = preorder.get(0);

        Node root = new Node('a');
        return root;

    }

    public static int countHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countHeight(root.left);
        int right = countHeight(root.right);
        return Math.max(left, right) + 1;
    }

    //判断一个数是不是平衡二叉树
    /*
    思路：从根角度看，左右子树都为平衡二叉树，且高度相差最大为1.
     */
    public boolean isbalanceTree(Node root) {
        if (root == null) {
            return true;
        }
//        if(isbalanceTree(root.left) && isbalanceTree(root.right)) {
//            return true;
//        }
//        if(countHeight(root.left)-countHeight(root.right) < 2 ){
        boolean leftBalance = isbalanceTree(root.left);
        if (!leftBalance) {// ! 使用这种否定的形式，是为了让满足条件的代码能够正常走下去，
            return false;//如果不满足，则直接返回false。
        }
        boolean rightBalance = isbalanceTree(root.right);
        if (!rightBalance) {
            return false;
        }
        int deff = countHeight(root.left) - countHeight(root.right);
        if (deff < -1 || deff > 1) {
            return false;
        }
        return true;
    }


    //下面的小操作
    public boolean search(Node root, Node obj) {
        if (root == null) {
            return false;
        }
        if (root == obj) {
            return true;
        }
        if (search(root.left, obj)) {
            return true;
        }
        return search(root.right, obj);
    }

    //给定两个该树节点，找两个节点的共同节点。
    public Node Lowst(Node root, Node q, Node p) {
        if (root == null) {
            return null;
        }
        //1.如果q，p中有一个和根相等，那么共同节点就是跟节点
        if (q == root || p == root) {
            return root;
        }
        boolean qLeft = search(root.left, q);
        boolean pLeft = search(root.left, p);
        //2.如果q，p两个都在左子树中，那就去左子树找
        if (qLeft && pLeft) {
            Lowst(root.left, q, p);
        }
        //3.如果两个都不在左子树中，那就去右子树之中找；
        if (!qLeft && !pLeft) {
            Lowst(root.right, q, p);
        }
        //4.如果前两个都不是，那就只可能一个在左，一个再右，那他们的共同节点就是根节点
        return root;
    }


    //层序遍历（一定要记住）
    public static void levelOrderTraversal(Node root) {
        if (root == null) {//队列中不允许出现空节点。
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if (front.left != null) {//队列中不允许出现空节点。
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    //判断完全二叉树
    /*
    完全二叉树：层序遍历，碰到null之后检查是否还有 非null  的存在，
                有： 不是。      没有： 是这玩意。
     */
    public static boolean isComplete(Node root){
        if(root == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            Node front = queue.poll();
            if(front == null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node != null){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        Node root = buildTreeWithInPre(preorder, inorder);
        System.out.println("成功");
        char[] preorder2 = new char[]{'A', 'B', 'D', 'E', 'G', 'C', 'F', 'H'};
        char[] inorder2 = new char[]{'D', 'B', 'G', 'E', 'A', 'C', 'F', 'H'};
    }

}
