package lc_116;

import tools.Node;

/**
 * @author �ƺ�
 *116. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ��
����һ�� ���������� ��������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣�������������£�

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��

��ʼ״̬�£����� next ָ�붼������Ϊ NULL��
 */
public class LC_116 {

}

//�ҵĴ���
class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node tail = root;
        Node predecessor = null;
        while (root.left != null){
            predecessor= root.left;
            
            while (root != null){
                Node prenode = root;
                root.left.next = root.right;
                root = root.next;
                if (root != null)
                    prenode.right.next = root.left;
            }
            root = predecessor;
        }
        return tail;
    }
}
//�ٷ�
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Node leftmost = root;
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }
        
        return root;
    }
}