class Node{
	private int val;
	private Node next = null;

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
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		
	}
}