package lc_121;

/**
 * @author �ƺ�
 *121. ������Ʊ�����ʱ��
����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�

��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������

��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 */
public class LC_121 {

}
//�ҵĴ���
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowerPrice = prices[0];
        int hightPrice = prices[0];
        int profit=  0;
        for (int i = 0; i< n; i++){
            if (prices[i] < lowerPrice){
                lowerPrice = prices[i];
                hightPrice = lowerPrice;
            }else{
                hightPrice = prices[i];
            }
            profit = Math.max(profit, hightPrice-lowerPrice);
        }
        return profit;
    }
}	
//�ٷ�������
class Solution1 {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
//һ�α���
class Solution2 {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
