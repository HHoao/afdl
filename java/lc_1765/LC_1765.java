package lc_1765;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 *@author: �ƺ�
 *@date : 2022��1��29��
 *@todo:1765. ��ͼ�е���ߵ�
����һ����СΪ m x n ���������� isWater ����������һ���� ½�� �� ˮ�� ��Ԫ����ɵĵ�ͼ��

��� isWater[i][j] == 0 ������ (i, j) ��һ�� ½�� ���ӡ�
��� isWater[i][j] == 1 ������ (i, j) ��һ�� ˮ�� ���ӡ�
����Ҫ�������¹����ÿ����Ԫ���Ÿ߶ȣ�

ÿ�����ӵĸ߶ȶ������ǷǸ��ġ�
���һ���������� ˮ�� ����ô���ĸ߶ȱ���Ϊ 0 ��
�������ڵĸ��Ӹ߶Ȳ� ���� Ϊ 1 ���������������������ϡ��������������໥�����ţ��ͳ�����Ϊ���ڵĸ��ӡ���Ҳ����˵������һ�������ߣ�
�ҵ�һ�ְ��Ÿ߶ȵķ�����ʹ�þ����е���߸߶�ֵ ��� ��

���㷵��һ����СΪ m x n ���������� height ������ height[i][j] �Ǹ��� (i, j) �ĸ߶ȡ�����ж��ֽⷨ���뷵�� ����һ�� ��

 

ʾ�� 1��



���룺isWater = [[0,1],[0,0]]
�����[[1,0],[2,1]]
���ͣ���ͼչʾ�˸��������Ӱ��ŵĸ߶ȡ�
��ɫ������ˮ�����ɫ������½�ظ�
ʾ�� 2��



���룺isWater = [[0,0,1],[1,0,0],[0,0,0]]
�����[[1,1,0],[0,1,1],[1,2,2]]
���ͣ����а��ŷ����У���߿��и߶�Ϊ 2 ��
���ⰲ�ŷ����У�ֻҪ��߸߶�Ϊ 2 �ҷ�����������ģ���Ϊ���з�����
*/
public class LC_1765 {

}
//��Դ�����������
class Solution {
    private static final int[][] dirs = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        Queue<int[]> queue= new ArrayDeque<>();
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(ans[i], -1);
        }
        for (int i = 0; i <n; i++){
            for (int j = 0; j < m; j++){
                if (isWater[i][j] == 1){
                    queue.offer(new int[]{i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] src = queue.poll();
            
            for (int[] dir : dirs){
                int x = src[0] + dir[0];
                int y = src[1] + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < m && ans[x][y] == -1){
                    ans[x][y] = src[2]+1;
                    queue.offer(new int[]{x, y, ans[x][y]});
                }
            }
        }
        return ans;
    }
}
//��̬�滮
class Solution1 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(f[i], 100000);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (isWater[i][j] == 0){
                    if (i > 0){
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                    }
                    if (j > 0){
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                    }
                }else{
                    f[i][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--){
            for (int j = m - 1; j >= 0; j--){
                if (isWater[i][j] == 0){
                    if (i < n - 1){
                        f[i][j] = Math.min(f[i][j], f[i+1][j] + 1);
                    }
                    if (j < m - 1){
                        f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
                    }
                }else{
                    f[i][j] = 0;
                }
            }
        }
        return f;
    }
}