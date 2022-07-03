package lc_141;

import tools.ListNode;

/**
 * @author �ƺ�
 *141. ��������
����һ�������ж��������Ƿ��л���

�����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������

��������д��ڻ����򷵻� true �� ���򣬷��� false ��

 

���ף�

������ O(1)�������������ڴ�����������
 */
public class LC_141 {

}
//����ָ��
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next;
            quick = quick.next;
            slow = slow.next;
            if (quick == slow) return true;
        }
        return false;
    }
}