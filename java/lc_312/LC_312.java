package lc_312;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��26��
 *@todo:312. ������
�� n �����򣬱��Ϊ0 �� n - 1��ÿ�������϶�����һ�����֣���Щ���ִ������� nums �С�

����Ҫ����������е����򡣴��Ƶ� i ����������Ի�� nums[i - 1] * nums[i] * nums[i + 1] öӲ�ҡ� ����� i - 1 �� i + 1 ����� i ���ڵ������������š���� i - 1�� i + 1 ����������ı߽磬��ô�͵�����һ������Ϊ 1 ������

�����ܻ��Ӳ�ҵ����������
*/
public class LC_312 {
	public static void main(String[] args) {
		int[] nums = new int[] {3, 1, 5, 8};
		System.out.println(new Solution().maxCoins(nums));
	}
}
//���仯����
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n+2][n+2];
        int[] val = new int[n + 2];
        System.arraycopy(nums, 0, val, 1, n);
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 0; i <= n+1; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve(memo, val, 0, n+1);
    }
    public int solve(int[][] memo, int[] nums, int left, int right){
        if (left >= right -1){
            return 0;
        }
        if (memo[left][right] != -1){
            return memo[left][right];
        }
        for (int i = left + 1; i < right; i++){
            int sum = nums[left] * nums[i] * nums[right];
            sum += solve(memo, nums, left, i) + solve(memo, nums, i, right);
            memo[left][right] = Math.max(memo[left][right], sum);
        }
        return memo[left][right];
    }
}
//��̬�滮
class Solution1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        System.arraycopy(nums, 0, val, 1, n);
        val[0] = val[n+1] = 1; 
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 2; i < n + 2; i++){
            for (int j = i; j < n + 2; j++){
                for (int k = j - i + 1; k < j;  k++){
                    int sum = val[j - i] * val[k] * val[j];
                    dp[j - i][j] = Math.max(dp[j - i][j], dp[j - i][k]+dp[k][j] + sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}