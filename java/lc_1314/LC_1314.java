package lc_1314;

/*
 *@author: �ƺ�
 *@date : 2022��1��17��
 *@todo:1314. ���������
����һ�� m x n �ľ��� mat ��һ������ k �����㷵��һ������ answer ������ÿ�� answer[i][j] ��������������������Ԫ�� mat[r][c] �ĺͣ� 

i - k <= r <= i + k,
j - k <= c <= j + k ��
(r, c) �ھ����ڡ�
 

ʾ�� 1��

���룺mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
�����[[12,21,16],[27,45,33],[24,39,28]]
ʾ�� 2��

���룺mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
�����[[45,45,45],[45,45,45],[45,45,45]]
*/
public class LC_1314 {

}
//һάǰ׺��
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] pre = new int[n][m];
        for (int i = 0; i < n; i++){
            pre[i][0] = mat[i][0];
            for (int j = 1; j < m; j++){
                pre[i][j] = pre[i][j - 1] + mat[i][j];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int t = Math.max(i - k, 0); t < Math.min(i + k + 1, n); t++){
                    if (j + k < m)
                        ans[i][j] += j - k - 1 >= 0 ? pre[t][j + k] - pre[t][j - k - 1] : pre[t][j + k];
                    else
                        ans[i][j] += j - k - 1 >= 0 ? pre[t][m - 1] - pre[t][j - k - 1] : pre[t][m - 1];
                }
            }
        }
        return ans;
    }
}
//��άǰ׺��
class Solution1 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] pre = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + mat[i-1][j-1];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int r_min = (i - k < 0 ? 0 : i - k) + 1;
                int r_max = (i + k >= n ? n - 1 : i + k) + 1;
                int c_min = (j - k < 0 ? 0 : j - k) + 1;
                int c_max = (j + k >= m ? m - 1 : j + k) + 1;
                if (r_min == 1){
                    if (c_min == 1){
                        ans[i][j] = pre[r_max][c_max];
                    }else{
                        ans[i][j] = pre[r_max][c_max] - pre[r_max][c_min - 1];
                    }
                }else{
                    if (c_min == 1){
                        ans[i][j] = pre[r_max][c_max] - pre[r_min - 1][c_max];
                    }else{
                        ans[i][j] = pre[r_max][c_max] - pre[r_min - 1][c_max] - pre[r_max][c_min - 1] + pre[r_min - 1][c_min - 1];
                    }
                }
            }
        }
        return ans;
    }
}