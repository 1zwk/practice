package learn0815;
/*
 * 找到未知长度链表的中间节点
 */
public class FindMiddle {
    public Node findMiddle(Node head) {
    	Node fast = head;
    	Node last = head;
    	while(fast != null) {
    		fast = fast.next;
    		if(fast == null) {
    			break;
    		}
    		last = last.next;
    		fast = fast.next;
    	}
    	
    	return last;
    }
    
    public static void main(String[] args) {
    	AddDeleteNode a = new AddDeleteNode();
    	Node head = a.creatList();
    	a.display(head);
    	FindMiddle f = new FindMiddle();
    	Node mid = f.findMiddle(head);
    	System.out.printf("Node(%d)", mid.val);
	}
}
