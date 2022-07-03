package lc_714;

/*
 *@author: �ƺ�
 *@date : 2021��9��19��
 *@todo:714. ������Ʊ�����ʱ����������
����һ���������� prices�����е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ������ fee �����˽��׹�Ʊ���������á�

��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�

���ػ����������ֵ��

ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
*/
public class LC_714 {

}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] f1  = new int[n + 1];
        f1[0] = -prices[0];
        int[] f2 = new int[n + 1];
        for (int i = 1; i <= n; i++){
            f1[i] = Math.max(f1[i - 1], f2[i - 1] - prices[i - 1]);
            f2[i] = Math.max(f2[i - 1], f1[i - 1] + prices[i - 1] - fee);
        }
        return Math.max(f1[n], f2[n]);
    }
}