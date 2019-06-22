//输入一个链表，输出该链表中倒数第k个结点。
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode FindK(ListNode head,int k) {
	    int length = 0;
	    for(ListNode cur = head; cur != null; cur = cur.next){
		    length++;
	    }
		if(k > length){
			return null;
		}
		
		int n = length - k;
		ListNode aim = head;
		for(int i = 0; i < n; i++){
			aim = aim.next;
		}
		return aim;		
    }
	
	public ListNode FindK2(ListNode head; int k){
		ListNode slow = head;
		ListNode fast = head;
	    for(int i = 0; i < k; i++){
			if(fast == null){
			return null;
		  }
			fast = fast.next;
	    }
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
}

public class FindK{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		Solution s = new Solution();
		ListNode result = s.FindK(n1, 3);
	   
	}
}
