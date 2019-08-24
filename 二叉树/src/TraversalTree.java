import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraversalTree {
    public static class Node{
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val){
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

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;

        return a;
    }

    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }
    //前序遍历
    public static void perOrderTraversal(Node root){
        if(root == null){
            return;
        }
        perOrderTraversal(root.left);
        System.out.println(root.val);
        perOrderTraversal(root.right);
    }
    //后续遍历
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        System.out.println(root.val);
        postOrderTraversal(root.right);
    }

    //OJ ：给定一个二叉树，返回一个返回它的前序遍历 。错误答案(因为看似把root.val尾插进list了
    // 但是每次递归进入都会创建一个list，所以实际上有很多个list，返回的只是其中之一。
    public List<Character> preOrderTraversal(Node root){
        ArrayList<Character> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        preOrderTraversal(root.left);
        list.add(root.val);
        preOrderTraversal(root.right);

        return list;
    }

    //OJ ：给定一个二叉树，返回一个返回它的前序遍历 。正确答案1
    public static List<Character> preOrderTraversal2(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Character> list = new ArrayList<>();
        List<Character> leftPreOrder = preOrderTraversal2(root.left);
        List<Character> rightPreOrder = preOrderTraversal2(root.right);
        list.add(root.val);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }
    //OJ ：给定一个二叉树，返回一个返回它的前序遍历 。正确答案2
    public static void preOrderTraversal3(Node root, List<Character> list){
        if(root == null){
            return ;
        }
        list.add(root.val);
        preOrderTraversal3(root.left, list);
        preOrderTraversal3(root.right, list);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        List<Character> list = new ArrayList<>();
        preOrderTraversal3(root,list);
        System.out.println(list);
        System.out.println(preOrderTraversal2(root));


    }
}
