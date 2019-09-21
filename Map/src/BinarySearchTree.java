import java.util.*;

public class BinarySearchTree {
    private static class Node {
        int key;
        int value;

        Node left;
        Node right;
    }

    private Node root = null;

    /**
     * 查找
     * @param key
     * @return 找key对应的value，找到了返回value，没找到返回-1.
     */
    public int get(int key){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }else if(cur.key < key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return -1;
    }

    /**
     * 插入
     * @param key
     * @param value
     * @return
     */
    public int put(int key, int value){
        if(root == null){
            Node node = new Node();
            node.value = value;
            node.key = key;
            return 1;
        }
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }else if(cur.key < key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        Node newNode = new Node();
        newNode.value = value;
        newNode.key = key;
        if(key < parent.key){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        return 1;
    }


    /**
     * 查找，未找到返回默认值。
     * @param key
     * @param defaultValue
     * @return
     */
    public int getOrDefault(int key, int defaultValue) {
        Node cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            } else if (cur.key < key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    /**
     * 返回所有的key的不重复集合
     * @return
     */
    public Set<Integer> keySet() {
        Set<Integer> set = new HashSet<>();
        if (root == null) {
            return set;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            Node front = queue.poll();
            set.add(front.key);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
        return set;
    }

    /**
     * 中序遍历返回所有不重复的key。
     * @return
     */
    public Set<Integer> keySet2(){
        Set<Integer> set = new HashSet<>();
        inorderTraversal(set,root);
        return set;

    }

    private void inorderTraversal(Set<Integer> set, Node node) {
        if(node != null){
            inorderTraversal(set, node.left);
            set.add(node.key);
            inorderTraversal(set, node.right);
        }
    }

    /**
     * 返回所有可重复的value
     * @return
     */
    public Collection<Integer> values(){
        Collection<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            list.add(front.value);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
        return list;
    }

    private static class Entry{
        private int key;
        private int value;

        public int getKey(){
            return key;
        }

        public int value(){
            return value;
        }

    }
    public Set<Entry> entrySet(){
        Set<Entry> set = new HashSet<>();
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            Node front = queue.poll();
            Entry entry = new Entry();
            entry.value = front.value;
            entry.key = front.key;
            set.add(entry);
            if(front.left != null){
                queue.add(front.left);
            }else if(front.right != null){
                queue.add(front.right);
            }
        }
        return set;
    }


    /**
     * 删除 八种情况
     * @return
     */
    public int remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.value;
                delete(cur,parent);
                return oldValue;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return -1;
    }

    private void delete(Node cur, Node parent) {
        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.right){
                parent.right = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else{
           Node sheep = cur.right;
           Node sheepParent = cur;
           while(sheep.left != null){
               sheepParent = sheep;
               sheep = sheep.left;
           }
           cur.key = sheep.key;
           cur.value = sheep.value;
           //不是一直往左吗？为什么还要判断左右？
           if(sheep == sheepParent.right){
               sheepParent.right = sheep.right;
           }else if(sheep == sheepParent.left){
               sheepParent.left = sheep.right;
           }
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.value = 1;
        root.key = 1;


    }
}
