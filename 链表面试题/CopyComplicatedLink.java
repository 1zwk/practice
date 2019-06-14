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
		}	
        return 	newhead;	
    }
}

















