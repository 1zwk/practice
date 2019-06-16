//1.先遍历复制一边链表
//2.把每一个新节点插入到每一个老节点的后面
//3.再复制旧链表的random.
//4.把head代表的链表拆开成新老链表
//5.记得考虑cur和cur.next为空的情况
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
		//1.先遍历复制一边链表
        //2.把每一个新节点插入到每一个老节点的后面
		if(head == null){
			return null;
		}
		Node newhead = head;
        Node cur = head;
        while(cur != null){
		    Node node = new Node(cur.val);
		   
		    node.next = cur.next;
           	cur.next = node;

            cur = node.next;			
	    }	
        //3.再复制旧链表的random.
        cur = head;
        while(cur != null){
			if(cur.random != null){
				cur.next.random = cur.random.next;
			}else{
				cur.next.random = null;
			}
		}
        //4.把head代表的链表拆开成新老链表
        cur = head;
        while(cur != null){
			Node node = cur.next;
			
			if(node.next != null){
				cur.next = node.next;
			    node.next = node.next.next;
			}else{
				node.next = null;
			}	
			node.next = node.next.next;
		}	
        return 	newhead;	
    }
	
	public void display(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
    }
}

public class CopyComplicatedLink{
	public static void testCopyRandomList(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		Node result = new Solution().copyRandomList(n1);
		for(Node cur = n1; cur != null; cur = cur.next){
			System.out.printf("Node(%s, %d, %s)-->%n",cur, cur.val, cur.random);
		}
	    System.out.println();
	}
	
	public static void main(String[] args){
		testCopyRandomList();
	}
}
















