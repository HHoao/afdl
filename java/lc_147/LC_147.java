package lc_147;

import tools.ListNode;

/**
 * @author �ƺ�
 *147. ��������в�������
��������в�������


��������Ķ�����ʾ���ϡ��ӵ�һ��Ԫ�ؿ�ʼ����������Ա���Ϊ�Ѿ����������ú�ɫ��ʾ����
ÿ�ε���ʱ���������������Ƴ�һ��Ԫ�أ��ú�ɫ��ʾ������ԭ�ؽ�����뵽���ź���������С�

 

���������㷨��

���������ǵ����ģ�ÿ��ֻ�ƶ�һ��Ԫ�أ�ֱ������Ԫ�ؿ����γ�һ�����������б�
ÿ�ε����У���������ֻ�������������Ƴ�һ���������Ԫ�أ��ҵ������������ʵ���λ�ã���������롣
�ظ�ֱ�������������ݲ�����Ϊֹ��
 */
public class LC_147 {

}
//�ҵĴ���
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode vir = new ListNode(-1, head);
        ListNode pTail = head;
        while (pTail.next != null){
            if (pTail.next.val > pTail.val){
                pTail = pTail.next;
            }else{
                ListNode cur = pTail.next;
                ListNode post = pTail.next.next;
                pTail.next = post;
                ListNode temp = vir;
                while (cur.val > temp.next.val){
                    temp = temp.next;
                }
                cur.next= temp.next;
                temp.next = cur;
            }
        }
        return vir.next;
    }
}