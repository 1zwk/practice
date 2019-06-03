//删除链表中等于给定值的所有节点
//1.遍历链表
//2.找到与给定值相同值的节点
//3.删除节点
//如何删除？
//使当前节点的前驱节点的下一个节点等于当前节点的后继节点，那么当前节点就从这个链表中消失。
//prev.next = cur.next;

class Node{
	public int value;
	public Node next = null;
	
	public Node(int value){
		this.value = value;
	}
}

public class DeleteNode{
	public static Node deleteNode(Node head, int a){
		if(head == null){
			return null;
		}
		Node cur = head.next;
		Node prev = head;
		while(cur != null){
			if(cur.value == a){
			   prev.next = cur.next;
			}else{
			prev = cur;
			}
			cur = cur.next;
		}
		if(head.value == a){
			return head.next;
		}
		return head;
	} 
	
	public static void display(Node head){
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.printf("%d-->",cur.value);
		}
		System.out.println("null");
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(1);
		
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		display(n1);
		
		Node result = deleteNode(n1,1);
		display(result);
	
	}
}

