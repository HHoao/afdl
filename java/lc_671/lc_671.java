package lc_671;

import tools.TreeNode;

/*
 *@author: �ƺ�
 *@date : 2021��7��27��
 *@todo:671. �������еڶ�С�Ľڵ�
����һ���ǿ�����Ķ�������ÿ���ڵ㶼������������ÿ���ڵ���ӽڵ�����ֻ��Ϊ 2 �� 0�����һ���ڵ��������ӽڵ�Ļ�����ô�ýڵ��ֵ���������ӽڵ��н�С��һ����

����ʽ��˵��root.val = min(root.left.val, root.right.val) �ܳ�����

����������һ��������������Ҫ������нڵ��еĵڶ�С��ֵ������ڶ�С��ֵ�����ڵĻ������ -1 ��
*/
public class lc_671 {

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
    int second = -1;
    public void find(TreeNode root){
        if (root == null){
            return;
        }
       if (root.left.val == root.val){
            if (root.right.val != root.val){
                second = second == -1 ? root.right.val : Math.min(root.right.val, second);
            }
            findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val){
            if (root.left.val != root.val){
                second = second == -1 ? root.left.val : Math.min(root.left.val, second);
            }
            findSecondMinimumValue(root.right);
        } 
    }
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null){
            return -1;
        }
        find(root);
        
        return second;
    }
}