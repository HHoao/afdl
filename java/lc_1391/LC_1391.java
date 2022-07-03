package lc_1391;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *@author: �ƺ�
 *@date : 2021��12��19��
 *@todo:1391. ����������Ƿ������Ч·��
����һ�� m x n ������ grid���������ÿ����Ԫ������һ���ֵ���grid[i][j] �Ľֵ������ǣ�

1 ��ʾ������Ԫ����ҵ�Ԫ��Ľֵ���
2 ��ʾ�����ϵ�Ԫ����µ�Ԫ��Ľֵ���
3 ��ʾ������Ԫ����µ�Ԫ��Ľֵ���
4 ��ʾ�����ҵ�Ԫ����µ�Ԫ��Ľֵ���
5 ��ʾ������Ԫ����ϵ�Ԫ��Ľֵ���
6 ��ʾ�����ҵ�Ԫ����ϵ�Ԫ��Ľֵ���
*/
public class LC_1391 {
	public static void main(String[] args) {
		System.out.println(new Solution().hasValidPath(new int[][]{{2,4,3},{6,5,2}}));
	}
}
//����
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int l = 0, r = 0;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{0, 0, grid[0][0]});
        while(!queue.isEmpty()){
            Integer[] inf = queue.poll();
            int x = inf[0], y = inf[1], type= inf[2];
            vis[x][y] = true;
            if (x == n -1 && y == m - 1) return true;
            if (type == 1){
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//����
                if (y < m - 1 && !vis[x][y + 1] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }//����
            }
            else if (type == 2){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//����
                if (x < n - 1 && !vis[x+1][y] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x+1, y, grid[x+1][y]});
                }//����
            }
            else if (type == 3){
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//����
                if (x < n - 1 && !vis[x+1][y] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x+1, y, grid[x+1][y]});
                }//����
            }
            else if (type == 4){
                if (x < n - 1 && !vis[x + 1][y] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x+1, y, grid[x + 1][y]});
                }
                if (y < m - 1 && !vis[x][y + 1] && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }
            }
            else if (type == 5){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//����
                if (y > 0 && !vis[x][y - 1] && (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)){
                    queue.offer(new Integer[]{x, y - 1, grid[x][y - 1]});
                }//����
            }
            else if (type == 6){
                if (x > 0 && !vis[x - 1][y] && (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)){
                    queue.offer(new Integer[]{x - 1, y, grid[x - 1][y]});
                }//����
                if (y < m - 1 && !vis[x][y + 1] && (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)){
                    queue.offer(new Integer[]{x, y + 1, grid[x][y + 1]});
                }
            }
        }
        return false;
    }
}