/**
ʱ�䣺2020��10��8��21:58:01
��Ŀ��������ӡ���2
*��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
*
*��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
*
*�����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
*
*ʾ����
*
*���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
*�����7 -> 0 -> 8
*ԭ��342 + 465 = 807
**/
package lc_2;
import java.util.*;

public class LC_2 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		ListNode l1 = null, l2 = null, head1 = null, head2 = null;

		System.out.println("������ListNode1�е���:");
		while(s.hasNextInt()) {
			if (head1 == null) {
				head1 = l1 = new ListNode(s.nextInt());
			}else {
				head1.next = new ListNode(s.nextInt());
				head1 = head1.next;
			}
		}
		s.nextLine();
		System.out.println("������ListNode2�е���:");
		while(s.hasNextInt()) {
			if (head2 == null) {
				head2 = l2 = new ListNode(s.nextInt());
			}else {
				head2.next = new ListNode(s.nextInt());
				head2 = head2.next;
			}
		}
		s.close();
		
		ListNode l3 = Solution.addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.printf("%d  ", l3.val);
			l3 = l3.next;
		}
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
			
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        
        return head;
    }
}