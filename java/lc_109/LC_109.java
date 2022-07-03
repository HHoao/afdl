package lc_109;

import java.util.ArrayList;
import java.util.List;

import tools.ListNode;
import tools.TreeNode;

/**
 * @author �ƺ�
 *109. ��������ת������������
����һ�����������е�Ԫ�ذ��������򣬽���ת��Ϊ�߶�ƽ��Ķ�����������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 */
public class LC_109 {

}
class Solution {
	private List<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
    	buildArray(head);
    	if (list == null || list.size() == 0) return null; 
    	return buildBST(0, list.size() - 1);
    }
    private TreeNode buildBST(int l, int r) {
    	if (l > r) return null;
    	int mid = (l + r) >> 1;
    	TreeNode root=  new TreeNode(list.get(mid));
    	root.left = buildBST(l, mid - 1);
    	root.right = buildBST(mid + 1, r);
    	return root;
    }
    private void buildArray(ListNode head) {
    	list = new ArrayList<>();
    	while(head != null) {
    		list.add(head.val);
    		head = head.next;
    	}
    }
}
//�ٷ�//����
class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//����,����������Ż�
class Solution2 {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}