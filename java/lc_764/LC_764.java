package lc_764;

/*
 *@author: �ƺ�
 *@date : 2021��9��17��
 *@todo:764. ���Ӻű�־
��һ����С�� (0, 0) �� (N-1, N-1) ��2D���� grid �У������� mines �и����ĵ�ԪΪ 0������ÿ����Ԫ���� 1�������а��� 1 �����������Ӻű�־�Ƕ��ٽף����ؼӺű�־�Ľ��������δ�ҵ��Ӻű�־���򷵻� 0��

һ�� k" ���� 1 ��ɵġ���Գơ��Ӻű�־������������  grid[x][y] = 1 ���Լ�4�����������ϡ����¡������������죬����Ϊ k-1���� 1 ��ɵıۡ�������� k" �ס���Գơ��Ӻű�־��ʾ����ע�⣬ֻ�мӺű�־����������Ҫ��Ϊ 1������������Ϊ 0 Ҳ����Ϊ 1��

 
*/
public class LC_764 {

}
//�ҵĶ�̬�滮
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dp[i][j][0] = 1;
                dp[i][j][1] = 1;
            }
        }
        for (int[] mine : mines){
            dp[mine[0]][mine[1]][0] = 0;
            dp[mine[0]][mine[1]][1] = 0;
        }
        for (int i = 1; i < n - 1; i++){
            for (int j = 1; j < n - 1; j++){
                if (dp[i][j][0] != 0){
                    dp[i][j][0] += dp[i - 1][j][0];
                    dp[i][j][1] += dp[i][j - 1][1];
                }
            }
        }
        int ans = mines.length == n*n ? 0 : 1;
        for (int i = n - 2; i > 0; i--){
            for (int j = n - 2; j > 0; j--){
                if (dp[i][j][0] != 0){
                    dp[i][j][0] = Math.min(dp[i + 1][j][0] + 1, dp[i][j][0]);
                    dp[i][j][1] = Math.min(dp[i][j+1][1] + 1, dp[i][j][1]);
                }
                ans = Math.max(Math.min(dp[i][j][0], dp[i][j][1]), ans);
            }
        }
        return ans;
    }
}