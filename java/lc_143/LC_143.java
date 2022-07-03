package lc_143;

import tools.ListNode;

/**
 * @author �ƺ�
 *143. ��������
����һ�������� L��L0��L1������Ln-1��Ln ��
�����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����

�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 */
public class LC_143 {

}
//�ҵĴ���
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        ListNode post = recoverList(slow.next);
        while (head != slow){
            ListNode next= head.next;
            ListNode postnext =post.next;
            head.next = post;
            post.next = next;
            head = next;
            post = postnext;
        }
        head.next = post;
        if (post != null) post.next = null;
    }
    public ListNode recoverList(ListNode head){
        ListNode prev=  null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}