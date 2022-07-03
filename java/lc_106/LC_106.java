package lc_106;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import tools.TreeNode;

/**
 * @author �ƺ�
 *106. �����������������й��������
����һ��������������������������������

ע��:
����Լ�������û���ظ���Ԫ�ء�
 */
public class LC_106 {

}
//�ݹ�
class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // �������û�нڵ㹹��������ˣ��ͽ���
        if (in_left > in_right) {
            return null;
        }

        // ѡ�� post_idx λ�õ�Ԫ����Ϊ��ǰ�������ڵ�
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // ���� root ����λ�÷ֳ�������������
        int index = idx_map.get(root_val);

        // �±��һ
        post_idx--;
        // ����������
        root.right = helper(index + 1, in_right);
        // ����������
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // �Ӻ�����������һ��Ԫ�ؿ�ʼ
        post_idx = postorder.length - 1;

        // ������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        
        return helper(0, inorder.length - 1);
    }
}
//����
class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}