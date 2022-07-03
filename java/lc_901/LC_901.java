package lc_901;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��24��
 *@todo:901. ��Ʊ�۸���
��дһ�� StockSpanner �࣬���ռ�ĳЩ��Ʊ��ÿ�ձ��ۣ������ظù�Ʊ���ռ۸�Ŀ�ȡ�

�����Ʊ�۸�Ŀ�ȱ�����Ϊ��Ʊ�۸�С�ڻ���ڽ���۸����������������ӽ��쿪ʼ���������������죩��

���磬���δ��7���Ʊ�ļ۸��� [100, 80, 60, 70, 60, 75, 85]����ô��Ʊ��Ƚ��� [1, 1, 1, 2, 1, 4, 6]��

 

ʾ����

���룺["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
�����[null,1,1,1,2,1,4,6]
���ͣ�
���ȣ���ʼ�� S = StockSpanner()��Ȼ��
S.next(100) �����ò����� 1��
S.next(80) �����ò����� 1��
S.next(60) �����ò����� 1��
S.next(70) �����ò����� 2��
S.next(60) �����ò����� 1��
S.next(75) �����ò����� 4��
S.next(85) �����ò����� 6��

ע�� (����) S.next(75) ���� 4����Ϊ������������ 4 ���۸�
(��������ļ۸� 75) С�ڻ���ڽ���ļ۸�
 

��ʾ��

���� StockSpanner.next(int price) ʱ������ 1 <= price <= 10^5��
ÿ���������������Ե���  10000 �� StockSpanner.next��
�����в��������У������� 150000 �� StockSpanner.next��
���������ʱ�����Ƽ����� 50%��
*/
public class LC_901 {

}
//����ջ
class StockSpanner {
    Deque<int[]> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int seq = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price){
            seq += stack.pop()[1];
        }
        stack.push(new int[]{price, seq});
        return seq;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */