package lc_474;

/*
 *@author: �ƺ�
 *@date : 2021��10��28��
 *@todo:474. һ����
����һ���������ַ������� strs ���������� m �� n ��

�����ҳ������� strs ������Ӽ��ĳ��ȣ����Ӽ��� ��� �� m �� 0 �� n �� 1 ��

��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
*/
public class LC_474 {

}
//���䱳������
class Solution {
    public int[] getNumArr(String str){
        int n = str.length();
        int[] numArr = new int[2];
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == '0')
                numArr[0]++;
            else
                numArr[1]++;
        }
        return numArr;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] arr = new int[l][2];
        int[][][] dp = new int[l+1][m+1][n+1];
        for (int i = 0; i < l; i++){
            arr[i] = getNumArr(strs[i]);
        }
        
        for (int i = 1; i <= l; i++){
            int zeros = arr[i-1][0], ones = arr[i-1][1];
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (zeros <= j && ones <= k){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones]+1);
                    }
                }
            }
        }
        return dp[l][m][n];
    }
}
//�Ż�
class Solution1 {
    public int[] getNumArr(String str){
        int n = str.length();
        int[] numArr = new int[2];
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == '0')
                numArr[0]++;
            else
                numArr[1]++;
        }
        return numArr;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] arr = new int[l][2];
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < l; i++){
            arr[i] = getNumArr(strs[i]);
        }
        
        for (int i = 1; i <= l; i++){
            int zeros = arr[i-1][0], ones = arr[i-1][1];
            for (int j = m; j >= 0; j--){
                for (int k = n; k >= 0; k--){
                    if (zeros <= j && ones <= k){
                        dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}