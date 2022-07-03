package lc_98;

import java.util.Deque;
import java.util.LinkedList;
import tools.TreeNode;

/**
 * @author �ƺ�
 *98. ��֤����������
����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������

�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������
 */
public class LC_98 {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		TreeNode tree7 = new TreeNode(7);
		
		TreeNode tree3 = new TreeNode(3, tree7);
		TreeNode tree6 = new TreeNode(6, tree3);
		//TreeNode tree1 = new TreeNode(-1);
		//TreeNode tree1_2 = new TreeNode(0, tree1);
		TreeNode tree4 = new TreeNode(4);
		TreeNode tree5 = new TreeNode(5, tree4, tree6);
		System.out.println(solution.isValidBST(tree5));
	}
}
// �ݹ�
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }	
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
//����+ջ
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
              // �����������õ��Ľڵ��ֵС�ڵ���ǰһ�� inorder��˵�����Ƕ���������
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
//Morris�������
class Solution3 {
	public boolean isValidBST(TreeNode root) {
		double inorder = -Double.MAX_VALUE; 
		while (root != null) {
			if (root.left != null) {
				TreeNode predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				}else {
					predecessor.right = null;
					if (root.val <= inorder) return false;
					inorder = root.val;
					root = root.right;
				}
			}else {
				if (root.val <= inorder) return false;
				inorder = root.val;
				root = root.right;
			}
		}
		return true;
	}
}