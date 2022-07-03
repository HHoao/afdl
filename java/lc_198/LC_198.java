package lc_198;

/**
 * @author �ƺ�
 *198. ��ҽ���
����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������

����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 */
public class LC_198 {

}
//�ҵĴ���
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
//�����Ż�
class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        int pre = 0, cur = nums[0], post = 0;
        for (int i = 2; i <= n; i++){
            post = Math.max(cur, pre + nums[i - 1]);
            pre = cur;
            cur = post;
        }
        return cur;
    }
}