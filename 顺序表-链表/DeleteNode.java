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
	//直接删除与val相同的节点（首节点和后面分开完成）
	public static Node deleteNode1(Node head, int val){
		if(head == null){
			return null;
		}
		Node cur = head.next;
		Node prev = head;
		while(cur != null){
			if(cur.value == val){
			   prev.next = cur.next;
			}else{
			prev = cur;
			}
			cur = cur.next;
		}
		if(head.value == val){
			return head.next;
		}
		return head;
	} 
	
	//直接删除与val相同的节点（创建假的首节点，使整个链表直接完成删除val）
	public static Node deleteNode2(Node head, int val){
		Node fakeNode = new Node(0);
		fakeNode.next = head;
		
		Node prev = fakeNode;
		Node cur = head;
		while(cur != null){
			if(cur.value == val){
				prev.next = cur.next;
			}else{
				prev = cur;
			}
			cur = cur.next;
		}
		return fakeNode.next;
		
	}
	
	//创建新链表，把不等于val的节点都传过去。
	public static Node deleteNode3(Node head, int val){
		Node newList = null;
		Node newLast = null;//记录newList的最后一个节点
		Node cur = head;
		while(cur != null){
			Node next = cur.next;
			if(cur.value != val){
				//把cur尾插到newList
				if(newList == null){
					cur.next = newList;
					newList = cur;					
				}else{
					newLast.next = cur;					
				}
				newLast = cur;
			}
			cur = next;	
		}
		newLast.next = null;//保证最后一个节点为null
		
		return newList;
	}
	
	public static Node findLast(Node head){
		Node cur = head;
		while(cur != null){
			cur = cur.next;
		}
		return cur;
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
		Node n3 = new Node(6);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(1);
		Node n7 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		display(n1);
		
		Node result1 = deleteNode1(n1,1);
		display(result1);
		Node result2 = deleteNode2(result1,2);
		display(result2);
		//小结：有时候一个代码是错误的，但是和其他代码放在一起有可能会正确，千万小心，会让你忽视你的代码错误。
		// 养成写一个代码，检验一个代码的习惯，不要一股脑全部写完。
	
	}
}

