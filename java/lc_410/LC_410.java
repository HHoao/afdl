package lc_410;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��26��
 *@todo:410. �ָ���������ֵ
����һ���Ǹ��������� nums ��һ������ m ������Ҫ���������ֳ� m ���ǿյ����������顣

���һ���㷨ʹ���� m ����������Ժ͵����ֵ��С��
*/
public class LC_410 {

}
//��̬�滮
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 1; i <= n; i++){
            sub[i] = sub[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }   
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= Math.min(i, m); j++){
                for (int k = 0; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}