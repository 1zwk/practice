package learn0815;


class Node{
	int val;
	Node next;

	Node(int val){
		this.val = val;
	}
    @Override
	public String toString() {
    	return String.format("Node(%d)",val);
    }

}

public class AddDeleteNode {
	public Node creatList() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5; n5.next = null;
				
		return n1;
	}
	
	//头插
	public Node addFront(Node head, int val) {		
		Node newNode = new Node(val);		
		newNode.next = head;
		return newNode;
	}
	
	//尾插
	public Node addBack(Node head, int val) {
		if(head == null) {
			addFront(head,val);			
		}else {
			Node newNode = new Node(val);
			Node last = getLast(head);
			last.next = newNode;			
		}
		return head;
	}
	
	//找到最后一个节点
	public Node getLast(Node head) {
		Node cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		return cur;			
	}
	
	//打印
	public void display(Node head) {
		for(Node cur = head; cur != null;cur = cur.next) {
			System.out.printf("(%d) --> ", cur.val);			
		}
		System.out.println("null");
	}
	
	//头删
	public Node deleteFront(Node head) {
		if(head == null) {
			System.out.println("错误，无法删除。");
			return null;
		}
		return head.next;
	}
	
	//尾删
	public Node deleteBack(Node head) {
		if(head == null) {
			System.out.println("错误，无法删除。");
			return null;
		}else if(head.next == null) {
			return null;
		}else {
			Node scondlast = getLastLast(head);
			scondlast.next = null;
		}
		return head;
	}
	
	//找到倒数第二个节点
		public Node getLastLast(Node head) {
			Node cur = head;
			while(cur.next.next != null) {
				cur = cur.next;
			}
			return cur;			
		}
	
	
	public static void main(String[] args) {
		AddDeleteNode a = new AddDeleteNode();
		Node head = a.creatList();
		a.display(head);
	    head = a.addFront(head, 0);
		head = a.addBack(head, 5);
		a.display(head);
		head = a.deleteFront(head);
		a.display(head);
		head = a.deleteBack(head);
		a.display(head);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
