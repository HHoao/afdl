package lc_124;

import tools.TreeNode;

/**
 * @author �ƺ�
 *124. �������е����·����
·�� ������Ϊһ������������ڵ�������ظ��ڵ�-�ӽڵ����ӣ��ﵽ����ڵ�����С�ͬһ���ڵ���һ��·�������� �������һ�� ����·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣

·���� ��·���и��ڵ�ֵ���ܺ͡�

����һ���������ĸ��ڵ� root �������� ���·���� ��
 */
public class LC_124 {

}
//�ҵĴ���
class Solution {
    int maxTotal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getTotal(root);
        return maxTotal;
    }
    public int getTotal(TreeNode root){
        int leftMaxSum = 0, rightMaxSum = 0;
        if (root.left != null) leftMaxSum = getTotal(root.left);   
        if (root.right != null) rightMaxSum = getTotal(root.right);
        int tempTotal = Math.max(root.val, Math.max(leftMaxSum+root.val, rightMaxSum+root.val));
        maxTotal = Math.max(maxTotal, Math.max(tempTotal, leftMaxSum+root.val + rightMaxSum));
        return tempTotal;
    }
}
//�ٷ�
class Solution1 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // �ݹ���������ӽڵ�������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ�ӽڵ�
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewpath = node.val + leftGain + rightGain;

        // ���´�
        maxSum = Math.max(maxSum, priceNewpath);

        // ���ؽڵ�������ֵ
        return node.val + Math.max(leftGain, rightGain);
    }
}