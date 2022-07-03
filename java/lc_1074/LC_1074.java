package lc_1074;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��3��
 *@todo:1074. Ԫ�غ�ΪĿ��ֵ���Ӿ�������
�������� matrix ��Ŀ��ֵ target������Ԫ���ܺ͵���Ŀ��ֵ�ķǿ��Ӿ����������

�Ӿ��� x1, y1, x2, y2 ������ x1 <= x <= x2 �� y1 <= y <= y2 �����е�Ԫ matrix[x][y] �ļ��ϡ�

��� (x1, y1, x2, y2) �� (x1', y1', x2', y2') �����Ӿ����в������겻ͬ���磺x1 != x1'������ô�������Ӿ���Ҳ��ͬ��
ʾ�� 1��



���룺matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
�����4
���ͣ��ĸ�ֻ�� 0 �� 1x1 �Ӿ���
ʾ�� 2��

���룺matrix = [[1,-1],[-1,1]], target = 0
�����5
���ͣ����� 1x2 �Ӿ��󣬼������� 2x1 �Ӿ����ټ���һ�� 2x2 �Ӿ���

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/
public class LC_1074 {
	public static void main(String[] args) {
		new Solution().numSubmatrixSumTarget(new int[][]{{1, -1},{-1, 1}}, 0);
	}
}
//ǰ׺��+��ϣ��
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            int[] columns = new int[m];
            for (int j = i; j < n; j++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int col = 0; col < m; col++){
                    columns[col] += matrix[j][col];
                }
                int sum = 0;
                for (int colSum : columns){
                    sum += colSum;
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) +1);
                }
            }
        }
        
        return ans;
    }
}