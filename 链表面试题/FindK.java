class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class solution{
    public ListNode FindKth(ListNode head,int k) {
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
