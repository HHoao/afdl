package lc_230;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/**
 * @author �ƺ�
 *230. �����������е�KС��Ԫ��
����һ�������������ĸ��ڵ� root ����һ������ k ���������һ���㷨�������е� k ����СԪ�أ��� 1 ��ʼ��������

 
 */
public class LC_230 {

}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right; 
        }
        return -1;
    }
}