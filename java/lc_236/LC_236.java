package lc_236;

import tools.TreeNode;

/**
 * @author �ƺ�
 *236. �������������������
����һ��������, �ҵ�����������ָ���ڵ������������ȡ�

�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 */
public class LC_236 {

}
class Solution {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        dfs(root, p, q);
        return this.ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        boolean isL = dfs(root.left, p, q);
        boolean isR = dfs(root.right, p, q);
        if ((isL && isR) || (root.val == p.val || root.val == q.val) && (isL || isR)){
            this.ans = root;
        }
        return root.val == p.val || root.val == q.val || isL || isR;
    }
}