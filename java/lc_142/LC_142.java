package lc_142;

import tools.ListNode;

/**
 * @author �ƺ�
 *142. �������� II
����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��

Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣬pos ���������ڱ�ʶ�����������������Ϊ�������ݵ������С�

˵�����������޸ĸ���������

���ף�

���Ƿ����ʹ�� O(1) �ռ������⣿
 */
public class LC_142 {

}
//����ָ��
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}