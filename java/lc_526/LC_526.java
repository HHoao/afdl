package lc_526;

/*
 *@author: �ƺ�
 *@date : 2021��10��28��
 *@todo:526. ����������
�����д� 1 �� n �� n ������������Щ��������һ������ perm���±�� 1 ��ʼ����ֻҪ������������ ֮һ �����������һ�� ���������� ��

perm[i] �ܹ��� i ����
i �ܹ��� perm[i] ����
����һ������ n �����ؿ��Թ���� �������� �� ���� ��
*/
public class LC_526 {
	

	
}
//��̬�滮
class Solution {
    public int countArrangement(int n) {
    	int[] dp = new int[1<<n];
    	dp[0] = 1;
    	for (int i = 1; i < (1 << n); i++) {
    		int pos = Integer.bitCount(i);
    		for (int j = 0; j < n; j++) {
    			if ((i & (1 << j)) != 0 && ((j+1) % pos == 0 || pos % (j+1) == 0)) {
    				dp[i] += dp[i ^ (i << j)];
    			}
    		}
    	}
    	return dp[(1<<n) - 1];
    }
}