package lc_138;

import java.util.HashMap;
import java.util.Map;

import tools.Node;

/**
 * @author �ƺ� 138. ���ƴ����ָ������� ����һ������Ϊ n ������ÿ���ڵ����һ���������ӵ����ָ�� random
 *         ����ָ�����ָ�������е��κνڵ��սڵ㡣
 * 
 *         ������������ ����� ���Ӧ�������� n �� ȫ�� �ڵ���ɣ�����ÿ���½ڵ��ֵ����Ϊ���Ӧ��ԭ�ڵ��ֵ���½ڵ�� next ָ���
 *         random
 *         ָ��Ҳ��Ӧָ���������е��½ڵ㣬��ʹԭ����͸��������е���Щָ���ܹ���ʾ��ͬ������״̬�����������е�ָ�붼��Ӧָ��ԭ�����еĽڵ� ��
 * 
 *         ���磬���ԭ�������� X �� Y �����ڵ㣬���� X.random --> Y ����ô�ڸ��������ж�Ӧ�������ڵ� x �� y ��ͬ����
 *         x.random --> y ��
 * 
 *         ���ظ��������ͷ�ڵ㡣
 * 
 *         ��һ���� n ���ڵ���ɵ���������ʾ����/����е�����ÿ���ڵ���һ�� [val, random_index] ��ʾ��
 * 
 *         val��һ����ʾ Node.val �������� random_index�����ָ��ָ��Ľڵ���������Χ�� 0 ��
 *         n-1���������ָ���κνڵ㣬��Ϊ null �� ��Ĵ��� ֻ ����ԭ�����ͷ�ڵ� head ��Ϊ���������
 */
public class LC_138 {

}

//�ҵĴ���
class Solution {
	Map<Node, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		if (map.containsKey(head))
			return map.get(head);
		Node node = new Node(head.val);
		map.put(head, node);
		node.random = copyRandomList(head.random);
		node.next = copyRandomList(head.next);
		return node;
	}
}

//�ٷ� ����
class Solution1 {
	// HashMap which holds old nodes as keys and new nodes as its values.
	HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

	public Node copyRandomList(Node head) {

		if (head == null) {
			return null;
		}

		// If we have already processed the current node, then we simply return the
		// cloned version of
		// it.
		if (this.visitedHash.containsKey(head)) {
			return this.visitedHash.get(head);
		}

		// Create a new node with the value same as old node. (i.e. copy the node)
		Node node = new Node(head.val);

		// Save this value in the hash map. This is needed since there might be
		// loops during traversal due to randomness of random pointers and this would
		// help us avoid
		// them.
		this.visitedHash.put(head, node);

		// Recursively copy the remaining linked list starting once from the next
		// pointer and then from
		// the random pointer.
		// Thus we have two independent recursive calls.
		// Finally we update the next and random pointers for the new node created.
		node.next = this.copyRandomList(head.next);
		node.random = this.copyRandomList(head.random);

		return node;
	}
}

//�ռ����
/*
 * //Definition for a Node. class Node { public int val; public Node next;
 * public Node random;
 * 
 * public Node() {}
 * 
 * public Node(int _val,Node _next,Node _random) { val = _val; next = _next;
 * random = _random; } };
 */
class Solution2 {
// Visited dictionary to hold old node reference as "key" and new node reference as the "value"
	HashMap<Node, Node> visited = new HashMap<Node, Node>();

	public Node getClonedNode(Node node) {
		// If the node exists then
		if (node != null) {
			// Check if the node is in the visited dictionary
			if (this.visited.containsKey(node)) {
				// If its in the visited dictionary then return the new node reference from the
				// dictionary
				return this.visited.get(node);
			} else {
				// Otherwise create a new node, add to the dictionary and return it
				this.visited.put(node, new Node(node.val));
				return this.visited.get(node);
			}
		}
		return null;
	}

	public Node copyRandomList(Node head) {

		if (head == null) {
			return null;
		}

		Node oldNode = head;

		// Creating the new head node.
		Node newNode = new Node(oldNode.val);
		this.visited.put(oldNode, newNode);

		// Iterate on the linked list until all nodes are cloned.
		while (oldNode != null) {
			// Get the clones of the nodes referenced by random and next pointers.
			newNode.random = this.getClonedNode(oldNode.random);
			newNode.next = this.getClonedNode(oldNode.next);

			// Move one step ahead in the linked list.
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return this.visited.get(head);
	}
}
