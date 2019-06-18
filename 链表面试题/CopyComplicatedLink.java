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
		
        Node cur = head;
        while(cur != null){
		    Node node = new Node(cur.val);
		   
		    node.next = cur.next;
           	cur.next = node;

            cur = node.next;//指向原节点的下一个			
	    }	
        //3.再复制旧链表的random.
        cur = head;
        while(cur != null){
			if(cur.random != null){
				cur.next.random = cur.random.next;//指向自己的random
			}else{
				cur.next.random = null;
			}
			cur = cur.next.next;
		}		
        //4.把head代表的链表拆开成新老链表
		Node newhead = head.next;      //返回的是新链表的头结点。
        cur = head;
        while(cur != null){
			Node node = cur.next;	
            cur.next = node.next;	   //调整原来节点指向它自身原本的下一个节点，需要一直执行。		
			if(node.next != null){     //调整新节点指向新节点自身的下一个节点，
			node.next = node.next.next;//到最后一步时node.next已经是空，这时node.next.next对空解引用会出错，
			}else{					   //所以分情况讨论。 							
			node.next = null;
			}	
			cur = cur.next;   // 拆分完成之后cur.next就是原链表原本的next。                    			
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
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		n1.random = n1;		
		n2.random = n4;
		n3.random = n3;
		n4.random = n2;
		n5.random = null;
		
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
















