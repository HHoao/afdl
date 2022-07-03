package lc_117;

import java.util.LinkedList;
import java.util.Queue;

import tools.Node;

/**
 * @author �ƺ�
 *117. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� II
����һ��������

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
��
��ʼ״̬�£����� next ָ�붼������Ϊ NULL��
 */
public class LC_117 {

}
//�ҵĴ���
class Solution {
	Node pre, post;
    public Node connect(Node root) {
        if (root == null) return null;
        Node nextNode = root;
        while (nextNode.left != null || nextNode.right != null || nextNode.next != null){
            Node temp = nextNode;
            pre= null;
            post = null;
            while (temp != null){
            	delivery(temp.left);
                delivery(temp.right);
                temp = temp.next;
            }
            if (nextNode.left != null) nextNode = nextNode.left;
            else if(nextNode.right != null) nextNode = nextNode.right;
            else nextNode = nextNode.next;
        }
        return root;
    }
    public void delivery(Node node) {
    	if (node != null && pre == null) pre = node;
        else if(node != null) post = node;
        if (post != null){
            pre.next = post;
            pre = post;
            post = null;
        }
    }
}
//��α���
class Solution1 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}
//ʹ���Ѿ�������nextָ��
class Solution2 {
    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        } 
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
