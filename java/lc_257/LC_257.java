package lc_257;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

/**
 * @author �ƺ�
 *257. ������������·��
����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 */
public class LC_257 {

}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        inorderTraversal(root, new StringBuffer(), ans);
        return ans;
    }
    public void inorderTraversal(TreeNode root, StringBuffer sbf, List<String> ans){
        if (root == null) {
            return ;
        }
        
        sbf.append("->"+root.val);
        if (root.left == null && root.right == null) {
            ans.add(sbf.substring(2, sbf.length()).toString());
            return;
        }
        inorderTraversal(root.left, new StringBuffer(sbf.toString()), ans);
        inorderTraversal(root.right, new StringBuffer(sbf.toString()), ans);
    }
}