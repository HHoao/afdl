package lc_206;

/**
 * @author �ƺ�
 *206. ��ת����
��תһ��������

ʾ��:

����: 1->2->3->4->5->NULL
���: 5->4->3->2->1->NULL
����:
����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
 */
public class LC_206 {
	
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}
//����
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}


//�ݹ�
class Solution2{
	public ListNode reverseList(ListNode head) {
		if (head != null && head.next != null) {
			return head;			
		}
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}