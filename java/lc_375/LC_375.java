package lc_375;

/*
 *@author: �ƺ�
 *@date : 2021��11��12��
 *@todo:375. �����ִ�С II
����������һ��������Ϸ����Ϸ�������£�

�Ҵ� 1 �� n ֮��ѡ��һ�����֡�
��������ѡ���ĸ����֡�
�����µ���ȷ�����֣��ͻ� Ӯ����Ϸ ��
�����´��ˣ���ô�һ�����㣬��ѡ�����ֱ���� ������߸�С ����������Ҫ����������
ÿ����������� x ���Ҳ´��˵�ʱ������Ҫ֧�����Ϊ x ���ֽ�����㻨����Ǯ���ͻ� �����Ϸ ��
����һ���ض������� n �������ܹ� ȷ�����ʤ ����С�ֽ�����������ѡ���Ǹ����� ��
*/
public class LC_375 {

}
//��̬�滮
class Solution {
    int[][] dp;
    public int choice(int left, int right){
        if (left >= right) return 0;
        if (right - left == 2) return right - 1;
        if (right - left == 1) return left;
        int curPay = 2147483647;
        for (int i = (right + left) / 2 - 1; i <= right; i++){
            if (dp[left][i - 1] == 0) dp[left][i-1] = choice(left, i - 1);
            if (dp[i+1][right] == 0) dp[i+1][right] = choice(i+1, right);
            curPay = Math.min(curPay, Math.max(dp[left][i - 1], dp[i+1][right]) + i);
        }
        return curPay;
    }
    public int getMoneyAmount(int n) {
        dp = new int[n+2][n+2];
        return choice(1, n);
    }
}