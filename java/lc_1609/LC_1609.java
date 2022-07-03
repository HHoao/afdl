package lc_1609;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/*
 *@author: �ƺ�
 *@date : 2021��12��25��
 *@todo:1609. ��ż��
���һ�ö���������������������������Գ�Ϊ ��ż�� ��

���������ڵ����ڲ��±�Ϊ 0 �������ӽڵ����ڲ��±�Ϊ 1 ��������ڵ����ڲ��±�Ϊ 2 ���������ơ�
ż���±� ���ϵ����нڵ��ֵ���� �� �����������Ұ�˳�� �ϸ����
�����±� ���ϵ����нڵ��ֵ���� ż �����������Ұ�˳�� �ϸ�ݼ�
����������ĸ��ڵ㣬���������Ϊ ��ż�� ���򷵻� true �����򷵻� false ��
*/
public class LC_1609 {

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
//���в������
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int tier = 0;
        if (root.val % 2 == 0){
            return false;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size(); 
            int pre = 0;
            for (int i = 0; i < size; i++){
                if (i != 0){
                    if (tier % 2 == 0){
                        if (queue.peek().val <= pre){
                            return false;
                        }
                    }else{
                        if (queue.peek().val >= pre){
                            return false;
                        }
                    }
                }
                TreeNode curNode = queue.poll();
                pre = curNode.val;
                if (pre % 2 == 0 && tier % 2 == 0) return false;
                if (pre % 2 == 1 && tier % 2 == 1) return false;
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            tier++;
        }
        return true;
    }
}