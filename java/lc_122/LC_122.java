package lc_122;

/**
 * @author �ƺ�
 *122. ������Ʊ�����ʱ�� II
����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����

ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 */
public class LC_122 {
	
}
//�ҵĴ��� һ�α���
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowerPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < n; i++){
            if (prices[i] < lowerPrice){
                lowerPrice = prices[i];
            }else{
                profit += prices[i] - lowerPrice;
                lowerPrice = prices[i];
            }
        }
        return profit;
    }
}
//�ٷ� ��̬�滮
class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
//̰���㷨
class Solution2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}