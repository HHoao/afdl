package lc_392;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��29��
 *@todo:392. �ж�������
�����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�

�ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���

���ף�

����д�������� S������ S1, S2, ... , Sk ���� k >= 10�ڣ�����Ҫ���μ�������Ƿ�Ϊ T �������С�����������£���������ı���룿

��л��

�ر��л @pbrother ��Ӵ����Ⲣ�Ҵ������в���������
*/
public class LC_392 {

}
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n+1][m+1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } 
            }
        }
        return dp[n][m] ;
    }
}
//�Ż�
class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int start = 0;
        for (int i = 1; i <= n; i++){
            boolean b = false;
            while (start < m){
                if (s.charAt(i - 1) == t.charAt(start)){
                    b = true;
                    start++;
                    break;
                }
                start++;
            }
            if ((start >= m && i < n) || !b) return false; 
        }
        return true;
    }
}
class Solution2 {
    public boolean isSubsequence(String s, String t) {
         int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
}