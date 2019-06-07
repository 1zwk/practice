class Node{
	public int val;
	public Node next = null;

    public Node(int val){
		this.val = val;
	}	
	
}
/*
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
	public static Node deleteBack(Node head){
		//1.空链表
		if(head == null){
			System.out.println("空链表无法删除");
			return null;  //忘记的 返回值
		}
		//忘记的   2.只有一个节点,
		if(head.next == null){
			return null;
		}else{       //忘记的 else，
		Node scond = findScond(head);
		scond.next = null;
		}
		return head;
	}
    //子问题
	public static Node findScond(Node head){
		Node cur = head;
		while(cur.next.next != null){                  //忘记的  while(cur.next != null){
			cur = cur.next;
		}
		return cur;
	}
	public static void displayLink(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");    //忘记的   加空行
	}
	
	
	
	public static void main(String[] args){
		//Node newNode = new Node;
		Node head = creatLink();
		displayLink(head);
		head = putFront(head,10);
		displayLink(head);
		head = deleteBack(head);
		displayLink(head);
		
	}
}
*/


class Solution{
	public Node creatLink(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		
		n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;n5.next = null;
		return n1;
	}
	public Node findKthToTail(Node head,int k){
		Node cur = head;
		int count = 0;
		while(cur != null){
			cur = cur.next;
			count++;
		}
		if(k < count){
			System.out.println("没有第k个元素");
			return null;
		}
		int n = count - k;
		Node kth = head;
		for(int i = 0; i<n; i++){
			kth = kth.next;
		}
		return kth;	
	}
	public Node findKthToTail2(Node head,int k){
		Node frond = head;
		Node back = head;
		
		for(int i = 0; i < k; i++){
			if(frond == null){
				return null;
			}
			frond = frond.next;
		}
		
		while(frond != null){
			frond = frond.next;
            back = back.next;			
		}
		return back;
	}	
	
	//结合有序链表
	public Node mergeTwoLists(Node L1, Node L2){
		Node cur1 = L1;
		Node cur2 = L2;
		Node result = null;
		
		while(cur1 != null && cur2 != null){
			if(cur1.val <= cur.val){
				//把cur1尾插到result上
				if(result == null){
					Node
					/*Node newNode = new Node(cur1.val);
					newNode.next = result;
					result = newNode;
				}else{
					Node last = null;					
					Node last = cur1.next;
					cur1 = cur1.next;	
                    last.next = newNode; 
                 */
				 
				}
			}
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void displayLink(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.val);
		}
		System.out.println("null");    
}

public class LinkNode2{
	public static void main(String[] args){
		Solution a = new Solution();
		Node L1 = a.creatLink();
		Node L2 = a.creatLink();
		a.mergeTwoLists(L1, L2);
		
	}
