package lc_129;

import java.util.LinkedList;
import java.util.Queue;

import tools.TreeNode;

/**
 * @author �ƺ�
 *129. ����ڵ㵽Ҷ�ڵ�����֮��
����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�

���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��

Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
 */
public class LC_128 {

}
//�ҵ����
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        preOrderTraverse(root, 0);
        return sum;
    }
    public void preOrderTraverse(TreeNode root, int total){
        total = total * 10 + root.val;
        if (root.left == null && root.right== null) sum += total;
        
        if (root.left != null) preOrderTraverse(root.left, total);
        if (root.right != null) preOrderTraverse(root.right, total);
    }
}
//�ٷ� �����������
class Solution1 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
//�����������
class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}