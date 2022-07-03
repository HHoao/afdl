package lc_82;

/**
 * @author �ƺ�
 *82. ɾ�����������е��ظ�Ԫ�� II
����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������ û���ظ����� �����֡�
 */
public class LC_82 {
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode ls = new ListNode(1);
		ListNode ls1 = new ListNode(1);
		ListNode ls2 = new ListNode(1);
		ListNode ls3 = new ListNode(2);
		ListNode ls4 = new ListNode(3);

		ls.next= ls1;
		ls1.next = ls2;
		ls2.next = ls3;
		ls3.next=  ls4;

		ListNode node = s.deleteDuplicates(ls);
		while (node != null) {
			System.out.println(node.val);
			node =node.next;
		}
	}
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//�ݹ�
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }
}