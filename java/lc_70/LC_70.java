package lc_70;

/**
 * @author �ƺ�
 *70. ��¥��
������������¥�ݡ���Ҫ n ������ܵ���¥����

ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�

ע�⣺���� n ��һ����������
 */
public class LC_70 {
	
}
class Solution{
	public int climbStairs(int x) {
		int p = 0, q = 0, r = 1;
		for (int i = 1; i <= x; i++) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}
}
