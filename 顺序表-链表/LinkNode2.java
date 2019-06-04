class Node{
	public int val;
	public Node next = null;

    public Node(int val){
		this.val = val;
	}	
	
}

public class LinkNode2{
	//创造链表
	public static Node creatLink(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		
		n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;n5.next = null;
		return n1;
	}
	//头插
	public static Node putFront(Node head, int val){
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	//尾删
	public static void deleteBack(Node head){
		if(head == null){
			System.out.println("空链表无法删除");
		}
		Node scond = findScond(head);
		scond.next = null;
	}
    //子问题
	public static Node findScond(Node head){
		Node cur = head;
		while(cur.next != null){
			cur = cur.next;
		}
		return cur;
	}
	public static void displayLink(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
	}
	
	
	
	public static void main(String[] args){
		Node newNode = new Node;
		newNode head = creatLink();
		displayLink(head);
		head = putFront(head,10);
		displayLink(head);
		deleteBack(head);
		displayLink(head);
		
	}
}