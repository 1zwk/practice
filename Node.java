public class Node{
	public int val;
	public Node next = null;
	
	public Node(int val){
		this.val = val;
	}
	
	public static Node creatList(){
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
		
		return n1;
	}
	//头插
	public static Node putFront(Node head, int val){
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	//尾插
	public static Node putBack(Node head, int val){
		Node newNode = new Node(val);
		if(head == null){
			putFront(head,val);
			return newNode;
		}
		Node back = findBack(head);
		back.next = newNode;
		return head;
	}
	public static Node findBack(Node head){
		Node cur = head;
		while(cur.next != null){//节点的下一个节点不为空，才能找到最后节点
			cur = cur.next;			
		}
		 return cur;	
	}
	//头删
	public static Node deleteFront(Node head){
		if(head == null){
			System.out.println("参数不合法，无法删除");
			return null;
		}
		return head.next;
	}
	//尾删
	public static Node deleteBack(Node head){
		if(head == null){
			System.out.println("参数不合法，无法删除");
			return null;
		}
		if(head.next == null){
			//return deleteFront(Node head);		
			return null; // 直接返回空呀，还调用个啥，只有一个删了不就没了。
		}
		Node lastTwo = findLastTwo(head);
		lastTwo.next = null;
		return head;
	}
	public static Node findLastTwo(Node head){
		Node cur = head;
		while(cur.next.next != null){
			cur = cur.next;			
		}
		 return cur;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void display(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		
		Node head = creatList();
		display(head);
		head = putFront(head,10);
		head = putBack(head,100);
		display(head);
		head = deleteFront(head);
		head = deleteFront(head);
		head = deleteFront(head);
		head = deleteFront(head);
		head = deleteFront(head);
		head = deleteFront(head);
		head = deleteBack(head);
		display(head);
	}
}