package lc_295;

import java.util.PriorityQueue;

/*
 *@author: �ƺ�
 *@date : 2021��9��8��
 *@todo:��Ŀ����
���� (326)
��� (493)
�ύ��¼
295. ����������λ��
��λ���������б��м����������б�����ż������λ�������м���������ƽ��ֵ��

���磬

[2,3,4] ����λ���� 3

[2,3] ����λ���� (2 + 3) / 2 = 2.5

���һ��֧���������ֲ��������ݽṹ��

void addNum(int num) - �������������һ�����������ݽṹ�С�
double findMedian() - ����Ŀǰ����Ԫ�ص���λ����
*/
public class LC_295 {
	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		m.findMedian();
	}
}

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        Integer minPeek = minHeap.peek();
        Integer maxPeek = maxHeap.peek();
        if (minSize <= maxSize){
            if (maxPeek != null && maxPeek > num){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
        }else{
            if (minPeek != null && minPeek < num){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }
        
    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (minSize < maxSize){
            return maxHeap.peek();
        }else if (minSize > maxSize){
            return minHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
