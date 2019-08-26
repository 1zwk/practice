import java.util.*;

public class LevelOrderTreversal2 {
    //层序遍历，返回{{A}, {B,C}, {D,E,F,G}}
    private static class Element{
        Node node;
        int level;

        Element(Node node, int level){//因为不光要知道node，还要知道node在第几层，故用类包装。
            this.node = node ;
            this.level = level;
        }
    }
    public static List<List<Integer>> levelOrderTreversal2(Node root){
        List<List<Integer>> retList = new ArrayList<>();//创建最外层列表，里面是空的，装的值是小列表。
        if(root == null){
            return retList;
        }
        Queue<Element> queue = new LinkedList<>();//层序遍历，需要用到工具队列。元素类型是自定义的 e
        Element e = new Element(root,0);//创建基础元素
        queue.add(e);//推进列表里

        while(!queue.isEmpty()){
            Element front = queue.poll();
            if(retList.size() == front.level){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);

            if(front.node.left != null){
                queue.add(new Element(front.node.left, front.level + 1));
            }
            if(front.node.right != null){
                queue.add(new Element(front.node.right,front.level + 1));
            }
        }

        return retList;
    }

    public static void main(String[] args) {
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

        System.out.println(levelOrderTreversal2(a));
    }
}


