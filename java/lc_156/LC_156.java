package lc_156;

import tools.ListNode;

/**
 * @author �ƺ�
 *160. �ཻ����
��дһ�������ҵ������������ཻ����ʼ�ڵ㡣	
 */
public class LC_156 {

}
//�ҵĴ���
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode tailA = headA, tailB = headB;
        while (tailA != null && tailB != null){
            tailA = tailA.next;
            n++;
            tailB = tailB.next;
            m++;
        }
        if (tailA == null){
            while (tailB != null){
                m++;
                tailB = tailB.next;
            }
        }else{
            while (tailA != null){
                n++;
                tailA = tailA.next;
            }
        }
        if (n > m){
            for (int i = 0; i< n - m; i++){
                headA = headA.next;
            }
        }else{
            for (int i = 0; i< m - n; i++){
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}