package lc_155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author �ƺ�
 *155. ��Сջ
���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��

push(x) ���� ��Ԫ�� x ����ջ�С�
pop() ���� ɾ��ջ����Ԫ�ء�
top() ���� ��ȡջ��Ԫ�ء�
getMin() ���� ����ջ�е���СԪ�ء�
 */
public class LC_155 {

}
//�ҵĴ���
class MinStack {
    private Deque<Integer> stack;
    private PriorityQueue<Integer> queue;
    public MinStack() {
        stack = new ArrayDeque<>();
        queue = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);
        queue.add(val);
    }
    
    public void pop() {
        int i = stack.pop();
        queue.remove(i);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}
//����ջ
class MinStack1 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack1() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}