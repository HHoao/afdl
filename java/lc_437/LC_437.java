package lc_437;

import java.util.HashMap;
import java.util.Map;

import tools.TreeNode;

/*
 *@author: �ƺ�
 *@date : 2021��9��28��
 *@todo:437. ·���ܺ� III
����һ���������ĸ��ڵ� root ����һ������ targetSum ����ö�������ڵ�ֵ֮�͵��� targetSum �� ·�� ����Ŀ��

·�� ����Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
*/
public class LC_437 {

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
    int ans;
    public void dfs(TreeNode root, int targetSum, int total, boolean cut){
        if (root == null){
            return;
        }
        if (root.val + total == targetSum){
            ans++;
        }
        dfs(root.left, targetSum, total+root.val, cut);
        dfs(root.right, targetSum, total+root.val, cut);
        if (!cut){
            dfs(root.left, targetSum, 0, true);
            dfs(root.right, targetSum, 0, true);
        }  
    }
    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        dfs(root, targetSum, 0, false);
        return ans;
    }
}
//ǰ׺��
class Solution1 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}