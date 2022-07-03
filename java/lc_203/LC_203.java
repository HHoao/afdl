package lc_203;

import tools.ListNode;

/**
 * @author �ƺ�
 *203. �Ƴ�����Ԫ��
����һ�������ͷ�ڵ� head ��һ������ val ������ɾ���������������� Node.val == val �Ľڵ㣬������ �µ�ͷ�ڵ� ��
 */
public class LC_203 {

}
//�ҵĴ���
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode vir = new ListNode(-1, head);
       
        ListNode pTail = head, pre = vir;
        
        while (pTail != null){
            while (pTail != null && pTail.val == val){
                pTail = pTail.next;
                pre.next = pTail;
            }
            pre = pre.next;
            if (pTail != null) pTail = pTail.next;
        }
        return vir.next;
    }
}