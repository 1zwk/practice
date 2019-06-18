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

public class DeleteAllVal{
	public static void testDeleteAllVal(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(5);
		
		n1.next = n2;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		Solution s = new Solution();
		Node result = s.deleteALLVal(n1, 5);
		s.display(result);
	}
	
	public static void main(String[] args){
		testDeleteAllVal();
	}
}