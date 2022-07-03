package lc_516;

/*
 *@author: �ƺ�
 *@date : 2021��10��28��
 *@todo:516. �����������
����һ���ַ��� s ���ҳ�������Ļ��������У������ظ����еĳ��ȡ�

�����ж���Ϊ�����ı�ʣ���ַ�˳�������£�ɾ��ĳЩ�ַ����߲�ɾ���κ��ַ��γɵ�һ�����С�
*/
public class LC_516 {

}
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--){
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len - 1][0];
    }
}