package lc_104;

import java.util.LinkedList;
import java.util.Queue;

import tools.TreeNode;

/**
 * @author �ƺ�
 *104. ��������������
����һ�����������ҳ��������ȡ�

�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 */
public class LC_104 {

}
//�ݹ�
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
//����
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}