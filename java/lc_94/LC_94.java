package lc_94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tools.TreeNode;

/**
 * @author �ƺ�
 *94. ���������������
����һ���������ĸ��ڵ� root ���������� ���� ������
 */
public class LC_94 {
}

//ջ
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//�ݹ�
class Solution1{
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> ans=  new ArrayList<Integer>();
		traversal(root, ans);
		return ans;
	}
	public void traversal(TreeNode node, List<Integer> ans) {
		if (node == null) return ; 
		traversal(node.left, ans);
		ans.add(node.val);
		traversal(node.right, ans);
	}
}
//Morris�������
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor �ڵ���ǵ�ǰ root �ڵ�������һ����Ȼ��һֱ���������޷���Ϊֹ
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // �� predecessor ����ָ��ָ�� root����������������
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // ˵���������Ѿ��������ˣ�������Ҫ�Ͽ�����
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // ���û�����ӣ���ֱ�ӷ����Һ���
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}