package learn0815;
/*
 * 合并两个有序链表
 */
public class TwoListAdd {
    public Node twoListAdd(Node head1, Node head2) {
    	if(head1 == null) {
    		return head1;
    	}
    	if(head2 == null) {
    		return head2;
    	}
    	
    	//比较两个链表节点值的大小，然后把小的尾插进新链表。
    	Node cur1 = head1;
    	Node cur2 = head2;
    	Node result = null;
    	Node last = null;
    	while(cur1 != null && cur2 != null) {    		
    		if(cur1.val <= cur2.val) {
    			Node next = cur1.next;
    			//把cur1尾插进result
    			if(result == null) {
    				//尾插分两个，第一个尾插进空链表    				
    				result = cur1;
    			}else {
    				//第二个插进非空链表
    				last.next = cur1;
    			}
    			last = cur1;  
    			
    			cur1 = next; 
    		}else {
    			Node next = cur2.next;
    			//把cur2尾插进result   			
    			if(result == null) {
    				result = cur2;    					
    			}else {
    				last.next = cur2;
    			}   				    		
    		    last = cur2;
    		    cur2 = next;	
    		}
    	}  		
    
        if(cur1 != null) {
    	    last.next = cur1;
        }else if(cur2 != null) {
    	    last.next = cur2;    		
        }
        return result;
    }
    
    public static void main(String[] args) {
    	AddDeleteNode a = new AddDeleteNode();
    	Node head1 = a.creatList();
    	a.display(head1);
    	Node head2 = a.creatList();
    	a.display(head2);
    	TwoListAdd t = new TwoListAdd();
    	Node result = t.twoListAdd(head1, head2);
    	a.display(result);
    	
	}
}
