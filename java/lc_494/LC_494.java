package lc_494;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��11��18��
 *@todo:494. Ŀ���
����һ���������� nums ��һ������ target ��

�������е�ÿ������ǰ��� '+' �� '-' ��Ȼ�������������������Թ���һ�� ���ʽ ��

���磬nums = [2, 1] �������� 2 ֮ǰ��� '+' ���� 1 ֮ǰ��� '-' ��Ȼ���������õ����ʽ "+2-1" ��
���ؿ���ͨ��������������ġ����������� target �Ĳ�ͬ ���ʽ ����Ŀ��
*/
public class LC_494 {

}
//��̬�滮
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        int[][] dp = new int[n+1][total * 2 + 1 + 2 * max];
        dp[0][total+max] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = -total; j <= total; j++){
                dp[i][j + total + max] = dp[i - 1][j + total + max + nums[i - 1]] + dp[i - 1][j + total + max - nums[i - 1]];
            }
        }
        return dp[n][target+total+max];
    }
}