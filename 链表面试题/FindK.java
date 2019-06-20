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
		for (ListNode cur = head; cur != null; cur = cur.next) {
			length++;
		}
		
		if (length < k) {
			return null;
		}
		
		int n = length - k;
		ListNode kth = head;
		for (int i = 0; i < n; i++) {
			kth = kth.next;
		}
		
		return kth;
    }
}

public class FindK{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		Solution s = new Solution();
		s.Fink
	}
}
