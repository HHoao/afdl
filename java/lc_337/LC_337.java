package lc_337;

import tools.TreeNode;

/*
 *@author: �ƺ�
 *@date : 2021��9��28��
 *@todo:337. ��ҽ��� III
���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������

�����ڲ���������������£�С͵һ���ܹ���ȡ����߽�
*/
public class LC_337 {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void dfs(TreeNode root){
        if (root == null)
            return;
        int i = root.val;
        int j = 0;
        if (root.right != null){
            dfs(root.right);
            j += root.right.val;
            if (root.right.left != null){
                i+= root.right.left.val;
            }
            if (root.right.right != null){
                i+= root.right.right.val;
            }
        }
        if (root.left != null){
            dfs(root.left);
            j += root.left.val;
            if (root.left.left != null){
                i+= root.left.left.val;
            }
            if (root.left.right != null){
                i+= root.left.right.val;
            }
        }
        root.val = Math.max(i, j);
        return;
    }
    public int rob(TreeNode root) {
        dfs(root);
        return root.val;
    }
}