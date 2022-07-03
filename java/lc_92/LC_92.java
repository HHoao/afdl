package lc_92;

/**
 * @author �ƺ�
 *92. ��ת���� II
��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��

˵��:
1 �� m �� n �� �����ȡ�
 */
public class LC_92 {
	public static void main(String[] args) {
		ListNode ls1 = new ListNode(1);
		ListNode ls2 = new ListNode(2, ls1);
		ListNode ls3 = new ListNode(3, ls2);
		Solution solution = new Solution();
		ListNode reNode = solution.reverseBetween(ls3, 2, 3);
		while (reNode != null) {
			System.out.println(reNode.val);
			reNode = reNode.next;
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

class Solution{
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode pNode = new ListNode(-1, head);
		
		ListNode preList = pNode;
		for (int i = 0; i < left - 1; i++) {
			preList = preList.next;
		}
		ListNode betweenList = preList.next;
		ListNode postList = betweenList;
		for (int j = left; j < right; j++) {
			postList = postList.next;
		}
		ListNode temp = postList;
		postList = postList.next;
		temp.next = null;
		ListNode reverseList = reverseList(betweenList);
		preList.next = reverseList;
		while (reverseList.next != null) {
			reverseList = reverseList.next;
		}
		reverseList.next = postList;
		return pNode.next;
	}
	public static ListNode reverseList(ListNode head) {
		ListNode preNode = null, postNode;
		ListNode pNode = head;
		while (pNode != null) {
			postNode = pNode.next;
			pNode.next = preNode;
			preNode = pNode;
			pNode = postNode;
		}
		return preNode;
	}
}