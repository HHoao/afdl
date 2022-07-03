package lc_778;

import java.util.PriorityQueue;

/*
 *@author: �ƺ�
 *@date : 2021��12��19��
 *@todo:778. ˮλ������Ӿ������Ӿ
��һ�� N x N �����귽�� grid �У�ÿһ�������ֵ grid[i][j] ��ʾ��λ�� (i,j) ��ƽ̨�߶ȡ�

���ڿ�ʼ�����ˡ���ʱ��Ϊ t ʱ����ʱ��ˮ����ˮ��������λ�õ�ˮλΪ t ������Դ�һ��ƽ̨�����������ڵ�����һ��ƽ̨������ǰ���Ǵ�ʱˮλ����ͬʱ��û������ƽ̨���ٶ������˲���ƶ����޾��룬Ҳ����Ĭ���ڷ����ڲ��ζ��ǲ���ʱ�ġ���Ȼ��������Ӿ��ʱ�������������귽�����档

������귽�������ƽ̨ (0��0) ���������ٺ�ʱ�������ܵ������귽�������ƽ̨ (N-1, N-1)��
*/
public class LC_778 {
	public static void main(String[] args) {
		System.out.println(new Solution().swimInWater(new int[][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
	}
}
//Dijkstra
class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b)->a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];
        int curHorizon = grid[0][0], r = 0, c = 0;
        heap.offer(new Integer[]{grid[r][c], r, c});
        while(r != n - 1 || c != m - 1){
            Integer[] g = heap.poll();
            vis[g[1]][g[2]] = true;
            curHorizon = Math.max(curHorizon, g[0]);
            r = g[1];
            c = g[2];
            for (int[] dir : dirs){
                int dr = g[1] + dir[0];
                int dc = g[2] + dir[1];
                if (dr >= 0 && dc >= 0 && dr < n && dc < m && !vis[dr][dc]){
                    heap.offer(new Integer[]{grid[dr][dc], dr, dc});
                }
            }
        }
        return curHorizon;
    }
}
//���鼯
class Solution1 {
    class UnionFind{
        int[] parent;
        UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        public void merge(int x, int y){
            x = find(x);
            y = find(y);
            parent[x] = y;
        }
    }
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = grid.length;;
        int size = n * n;
        int[] horizons = new int[size];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                horizons[grid[i][j]] = i * n + j;
            }
        }
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < size; i++){
            int r = horizons[i] / n;
            int c = horizons[i] % n;
            for(int[] dir : dirs){
                int dr = r + dir[0];
                int dc = c + dir[1];
                if (dr >= 0 && dc >= 0 && dr < n && dc < n && grid[dr][dc] <= i){
                    uf.merge(horizons[i], dr * n + dc);
                }
                if (uf.find(0) == uf.find(size - 1)){
                    return i;
                }
            }
        }
        return -1;
    }
}