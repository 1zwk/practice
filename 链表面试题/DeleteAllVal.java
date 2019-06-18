class Node{
	int val;
	Node next;
	
	public Node(int val){
		this.val = val;
		this.next = next;
	}
}

class Solution{
	public Node deleteALLVal(Node head, int val){
		if(head == null){
			System.out.println("错");
		}
		Node cur = head;
		Node prev = new Node(0);
		prev.next = head;
		while(cur != null){
			if(cur.val == val){
				prev.next = cur.next;
			}else{
				prev = prev.next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public void display(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");
    }
}