package lc_83;

/**
 * @author �ƺ�
 *83. ɾ�����������е��ظ�Ԫ��
����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
 */
public class LC_83 {
	
}
class ListNode{
	int val;
	ListNode next;
}
class Solution{
	public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr!= null && curr.next !=null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}
