public class TreePractice {
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

    //遍历找树的节点数(需要在每次调用前把 count 归零）
    public static int count = 0;
    public static int countTreeNode(Node root) {
        if (root == null) {
            return count;
        }

        count++;
        countTreeNode(root.left);
        countTreeNode(root.right);
        return count;
    }

    //使用汇总的思想计算树的节点数(不用使用到全局变量，并且不用每次调用前归零计数）
    public static int countTreeNode2(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countTreeNode2(root.left);
        int right = countTreeNode2(root.right);
        int count = left + right + 1;
        return count;
    }

    //找叶子数（用遍历的方式求解）
    public static int leafcount = 0;
    public static int countTreeLeaf(Node root) {
        if (root == null) {
            return leafcount;
        }

        if (root.left == null && root.right == null) {//代表是叶子节点
            leafcount++;
        }
        countTreeLeaf(root.left);
        countTreeLeaf(root.right);
        return leafcount;
    }

    //找叶子数（用汇总的方式求解）
    public static int countTree2(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {//代表只有一个节点的树
            return 1;
        }
        int left = countTree2(root.left);
        int right = countTree2(root.right);
        return  right + left;
    }

    //求树高
    public static int countHeight(Node root) {
        if(root == null){
            return 0;
        }
        int left = countHeight(root.left);
        int right = countHeight(root.right);
        return Math.max(left,right) + 1;
    }

    //查找值为val的节点：
    /*
    思路：首先，树为空返回null，根为val就返回根，
    如果根不是就去左子树找（只会有找到和没找到，找到必定返回正确的值，未找到返回null）
    如果还未找到就去右子树找
     */
    public static Node search(Node root, char val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else {
            Node left = search(root.left, val);//去左子树查找
            if (left != null) {
                return left;
            } else {
                Node right = search(root.right, val);
                if (right != null) {
                    return right;
                }
                return null;
            }
        }
    }

    //另一版：找val对应的节点
    public static Node search3(Node root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        Node left = search3(root.left, val);
        if (left != null) {
            return left;
        }
        Node right = search3(root.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }

    //search，找到返回boolean
    public static boolean search2(Node root, char val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (search2(root.left, val)) {
            return true;
        }
        return search2(root.right, val);
    }

    //找到K层的节点数
    /*
    思路：求root的k层就是求root.right的k-1层和root.left的k-1层之和
     */
    public static int kNode(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int left = kNode(root.left, k-1);
        int right = kNode(root.right, k-1);
        return left + right;
    }

    public static boolean isSame(Node a, Node b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        return a.val == b.val
                && (a.left == b.left)
                && (a.right == b.right);
    }

    //两个树是否是镜像的
    public static boolean isMirror(Node p, Node q) {
        if(q == null && p == null){
            return true;
        }
        if(q == null || p  == null){
            return false;
        }
        return q.val == p.val
                && (q.left == p.right)
                && (q.right == p.left);
    }



    public static void main(String[] args) {
        Node root = buildTree();
        count = 0;
        System.out.println(countTreeNode(root));//树的节点1,全局变量定义
        System.out.println(countTreeNode2(root));//树的节点2，局部变量定义
        System.out.println(countTreeLeaf(root));//叶子数
        Node result = search(root,'D');
        System.out.println(result.val);//搜索
        System.out.println(countHeight(root));//树高
        System.out.println(kNode(root,3));
    }
}
