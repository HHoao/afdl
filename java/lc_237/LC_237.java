package lc_237;

import tools.ListNode;

/**
 * @author �ƺ�
 *237. ɾ�������еĽڵ�
���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㡣���뺯����Ψһ����Ϊ Ҫ��ɾ���Ľڵ� ��

 

����һ������ -- head = [4,5,1,9]�������Ա�ʾΪ:
 */
public class LC_237 {

}
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        ListNode tail = next.next;
        node.next = tail;
    }
}