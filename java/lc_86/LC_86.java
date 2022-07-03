package lc_86;

/**
 * @author �ƺ�
 *86. �ָ�����
����һ�������ͷ�ڵ� head ��һ���ض�ֵ x �������������зָ���ʹ������ С�� x �Ľڵ㶼������ ���ڻ���� x �Ľڵ�֮ǰ��

��Ӧ�� ���� ����������ÿ���ڵ�ĳ�ʼ���λ�á�
 */
public class LC_86 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(5, node1);
		ListNode node3 = new ListNode(2, node2);
		ListNode node4 = new ListNode(3, node3);
		ListNode node5 = new ListNode(4, node4);
		ListNode node6 = new ListNode(1, node5);
		ListNode pNode = (new Solution().partition(node6, 3));
		while (pNode != null) {
			System.out.println(pNode.val);
			pNode = pNode.next;
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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}


