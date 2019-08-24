import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        Node root = buildTreeWithInPre(preorder, inorder);
        System.out.println("成功");
    }

}
