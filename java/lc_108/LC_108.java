package lc_108;

import tools.TreeNode;

/**
 * @author �ƺ�
 *108. ����������ת��Ϊ����������
����һ���������� nums ������Ԫ���Ѿ��� ���� ���У����㽫��ת��Ϊһ�� �߶�ƽ�� ������������

�߶�ƽ�� ��������һ�����㡸ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ���Ķ�������
 */
public class LC_108 {

}
//�������,���������Ϊ���ڵ�
class Solution{
	public TreeNode sortedArrayToBST(int[] nums) {
		return buildBST(nums, 0, nums.length - 1);
	}
	private TreeNode buildBST(int[] nums, int l, int r) {
		if (l > r) return null;
		int mid = (l + r) >> 1;
		TreeNode root= new TreeNode(nums[mid]);
		root.left = buildBST(nums, l, mid - 1);
		root.right = buildBST(nums, mid + 1, r);
		return root;
	}
}