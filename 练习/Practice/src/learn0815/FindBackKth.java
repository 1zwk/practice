package learn0815;
/*
 *找到倒数第k个元素。 
 */

public class FindBackKth {
    public Node findBackKth(Node head, int k) {
    	int length = 0;
    	Node cur = head;
    	while(cur != null) {
    		cur = cur.next;
    		length++;
    	}
    	
    	if(length < k) {
    		return null;
    	}
    	
    	Node kth = head;
    	int n = length - k;
    	for(int i=0; i<n; i++) {
    		kth = kth.next;
    	}
    	return kth;    	
    }
    
    public Node findBackKth2(Node head, int k) {
    	Node front = head;
    	Node last = head;
    	for(int i=0; i<k; i++) {
    		front = front.next;    		
    	}
    	
    	while(front != null) {
    		front = front.next;
    		last = last.next;
    	}
    	return last;
    }
    
    public static void main(String[] args) {
    	AddDeleteNode a = new AddDeleteNode();
    	Node head = a.creatList();
    	a.display(head);
    	FindBackKth f = new FindBackKth();
    	Node result = f.findBackKth(head, 2);
    	System.out.printf("%d ",result.val);
    	result = f.findBackKth2(result, 1);
    	System.out.printf("%d",result.val);   	
    }
}











