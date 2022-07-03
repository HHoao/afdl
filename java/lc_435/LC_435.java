package lc_435;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��27��
 *@todo:435. ���ص�����
����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص���

ע��:

������Ϊ������յ����Ǵ���������㡣
���� [1,2] �� [2,3] �ı߽��໥���Ӵ�������û���໥�ص���
*/
public class LC_435 {
	public static void main(String[] args) {
		System.out.println(new Solution().eraseOverlapIntervals(new int[][] {{1,2}, {2,3}, {3,4}, {1,3}})); 
	}
}
//��̬�滮
class Solution{
	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		int[] f = new int[n];
		Arrays.sort(intervals, (a, b)->a[0] - b[0]);
		Arrays.fill(f, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (intervals[j][1] <= intervals[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		return n - f[n - 1];
	}
}
//̰���㷨
class Solution1{
	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, (a, b)->a[1] - b[1]);
		int ans = 1;
		int right = intervals[0][1];
		for (int i = 1; i < n; i++) {
			if (intervals[i][0] > right) {
				ans++;
				right = intervals[i][1];
			}
		}
		return n - ans;
	}
}
