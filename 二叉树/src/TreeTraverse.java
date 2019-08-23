import java.util.ArrayList;
import java.util.List;

public class TreeTraverse {
    public static class Node{
        private int val;
        private Node left = null;
        private Node right = null;

        public Node(int val){
            this.val = val;
        }
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

    //OJ ：返回一个
    public List<Integer> preordertraversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        perOrderTraversal(root.left);
        list.add(root.val);
        perOrderTraversal(root.right);

        return list;
    }
}
