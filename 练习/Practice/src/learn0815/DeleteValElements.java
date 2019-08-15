package learn0815;
/*
 * 删除指定val的节点
 */

/*class Node{
	int val;
	Node next;

	Node(){
		this.val = val;
	}
	
	Node(int val){
		this.val = val;
	}

}*/


public class DeleteValElements {
     public Node deleteValElements(Node head, int val) {
    	 //空链表
    	 if(head == null) {
    		 System.out.println("无法删除");
    		 return null;     		 
    	 }else if(head.next == null) {//只有一个节点链表
    		 if(head.val == val) {
    			 return null;    			 
    		 }else {
    			 System.out.println("未找到");
    			 return head;
    		 }
    	 }
    	 
    	 Node prev = head;
    	 Node cur = head.next;    	
    	 while(cur != null) {   		 
    		 if(cur.val == val) {
    			 prev.next = cur.next;          			 
    		 }else {
    			prev = cur;
    		 }    		 
    		 cur = cur.next;
    	 }

    	 if(head.val == val) {
    		 return head.next;
    	 }   	
    	 return head;    	 
     }
     
     public static void main(String[] args) {
    	 AddDeleteNode a = new AddDeleteNode();
    	 Node head = a.creatList();
    	 a.display(head);
    	 DeleteValElements d = new DeleteValElements();
    	 head = d.deleteValElements(head, 2);
    	 a.display(head);
    	 head = d.deleteValElements(head, 10);
    	 a.display(head);
    	 head = d.deleteValElements(head, 1);
    	 head = d.deleteValElements(head, 3);
    	 head = d.deleteValElements(head, 4);
    	 a.display(head);   	
	}
}























