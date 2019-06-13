class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
		this.next = null;
	}
}

class Solution{
    public Node reverse1(Node head){		
		//1.遍历所有节点
		//2.把节点头插进新链表
		//头插不管是空还是非空都是直接是要插入的节点的下一个为被插入链表得头结点就可以。
		//3.主意要让最后一个节点的下一个节点为null
		Node newList = null;
		for(Node cur = head; cur != null; cur = cur.next){
			    //因为cur.next每次循环会变化，所以提前保存cur.next的值,
				//不然循环继续走也是要使用cur.next，会出现错误。
				Node next = cur.next;
				//头插
				cur.next = newList;
				newList = cur;				
			    
				cur = next;
		}
		return newList;
	}
	
	public void display(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
	}
}

public class ReverseList{
	public static void testReverseList(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		
		n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;n5.next = null;
		Node head = n1;
		Solution s = new Solution();
		s.display(head);				
		s.reverse1(head);
		s.display(head);		
	}

	
	public static void main(String[] args){
		testReverseList();
		
		
	}
}