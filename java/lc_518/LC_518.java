package lc_518;

/*
 *@author: �ƺ�
 *@date : 2021��10��28��
 *@todo:518. ��Ǯ�һ� II
����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�

������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��

����ÿһ������Ӳ�������޸��� 

��Ŀ���ݱ�֤������� 32 λ������������
*/
public class LC_518 {

}
//��̬�滮
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}