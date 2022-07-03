package lc_416;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��29��
 *@todo:416. �ָ�Ⱥ��Ӽ�
����һ�� ֻ���������� �� �ǿ� ���� nums �������ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
*/
public class LC_416 {
	public static void main(String[] args) {
		System.out.println(new Solution2().canPartition(new int[] {14, 9, 8, 4, 3, 2}));
	}
}
//��̬�滮
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int target = total/2;
        boolean[][] dp = new boolean[n+1][total+1];
        boolean ans = false;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j){
                    dp[i][j] = dp[i][j] || nums[i - 1] == j || dp[i-1][j - nums[i - 1]];
                }
            }
            ans = ans || dp[i][target];
        }
        return ans;
    }
}
class Solution2 {
    public boolean canPartition(int[] nums) {
    	int n = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int target = total/2;
        boolean[] dp = new boolean[total+1];
        for (int i = 1; i <= n; i++){
            for (int j = target; j >= nums[i - 1]; j--){
                if (nums[i - 1] <= j){
                    dp[j] = dp[j] || nums[i - 1] == j || dp[j - nums[i - 1]];
                }
            }
            if (dp[target]) return true;
        }
        return false;
    }
}
//����n < 31��������
class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < (1 << n) - 1; i++){
            int k = 0;
            for (int j = 0; j < n; j++){
                if ((i & 1<<j) != 0){
                    k += nums[n - j - 1];
                }
            }
            if (sum - k == k) return true;
        }
        return false;
    }
}