
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {val = x;}
	 
 }

//把旧链表一次遍历头插到新链表里
//1.创建新链表
//2.遍历
//3.头插到新链表
class Solution {
    public ListNode reverseList(ListNode head) {
		ListNode newList = null;
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;//保存cur.next的值
			
			cur.next = newList;//头插
			newList = cur;
			
			cur = next;//让cur往后遍历
		}
        return newList;
    }
	
	//打印
	public static void display(ListNode head){
		for(ListNode i = head; i != null; i = i.next){
			System.out.printf("%d-->", i.val);
		}
		System.out.printf("null");
	}
}

public class ReverseList{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		Solution s = new Solution();
		ListNode result = s.reverseList(n1);
		s.display(result);
		//想要在一个类之中使用另一个类的方法，必须先用另一个类构造一个对象，然后使用这个对象的方法和属性，用“ 对象名” + “.”
		
	}
}
