package lc_343;

/*
 *@author: �ƺ�
 *@date : 2021��9��20��
 *@todo:
*/
public class LC_343 {

}
//�ҵĶ�̬�滮
class Solution {
    public int integerBreak(int n) {
        if (n == 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        return dp[n];
    }
}