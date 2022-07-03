package lc_897;

import tools.TreeNode;

/**
 * @author �ƺ�
 *897. ����˳��������
����һ�ö��������������� ��������� ������������Ϊһ�õ���˳����������ʹ��������ߵĽڵ��Ϊ���ĸ��ڵ㣬����ÿ���ڵ�û�����ӽڵ㣬ֻ��һ�����ӽڵ㡣
 */
public class LC_897 {

}
//�ҵĴ���
class Solution {
    private TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
        TreeNode phead = head;
        inorderTraversal(root);
        return phead.right;
    }
    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        head.right = new TreeNode(root.val);
        head = head.right;
        inorderTraversal(root.right);
    }
}
//ԭ���޸�
class Solution1 {
    private TreeNode head;
    private TreeNode currNode;
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
        currNode = head;
        inorderTraversal(root);
        return head.right;
    }
    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        root.left = null;
        currNode.right = root;
        currNode = currNode.right;
        inorderTraversal(root.right);
    }
}