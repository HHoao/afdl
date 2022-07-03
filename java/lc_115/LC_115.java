package lc_115;

/**
 * @author �ƺ�
 *115. ��ͬ��������
����һ���ַ��� s ��һ���ַ��� t �������� s ���������� t ���ֵĸ�����

�ַ�����һ�� ������ ��ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ������ɵ����ַ����������磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�

��Ŀ���ݱ�֤�𰸷��� 32 λ������������Χ��
 */
public class LC_115 {

}
//��̬�滮
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}