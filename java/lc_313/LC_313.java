package lc_313;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��9��28��
 *@todo:313. ��������
�������� ��һ�������������������������������������������� primes �С�

����һ������ n ��һ���������� primes �����ص� n �� �������� ��

��Ŀ���ݱ�֤�� n �� �������� �� 32-bit ������������Χ�ڡ�

 
*/
public class LC_313 {

}
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int m = primes.length;
        int[] points = new int[m];
        Arrays.fill(points, 1);
        for (int i = 2; i <= n; i++){
            int[] nums = new int[m];
            int minValue = 2147483647;
            for (int j = 0; j < m; j++){
                nums[j] = dp[points[j]] * primes[j];
                minValue = Math.min(minValue, nums[j]);
                dp[i] = minValue;
            }
            for (int j = 0; j < m; j++){
                if (nums[j] == minValue){
                    points[j]++;
                }
            }
        }
        return dp[n];
    }
}