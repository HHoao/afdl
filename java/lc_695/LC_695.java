package lc_695;

/*
 *@author: �ƺ�
 *@date : 2021��12��14��
 *@todo:695. �����������
����һ����СΪ m x n �Ķ����ƾ��� grid ��

���� ����һЩ���ڵ� 1 (��������) ���ɵ���ϣ�����ġ����ڡ�Ҫ������ 1 ������ ˮƽ������ֱ���ĸ������� ���ڡ�����Լ��� grid ���ĸ���Ե���� 0������ˮ����Χ�š�

���������ǵ���ֵΪ 1 �ĵ�Ԫ�����Ŀ��

���㲢���� grid �����ĵ�����������û�е��죬�򷵻����Ϊ 0 ��
*/
public class LC_695 {

}
//�����������
class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    boolean[][] vis;
    private int dfs(int[][] grid, int r, int c){
        vis[r][c] = true;
        int count = 1;
        for (int[] dir : dirs){
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length &&
                !vis[dr][dc] && grid[dr][dc] == 1){
                    count += dfs(grid, dr, dc);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        vis = new boolean[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (!vis[i][j] && grid[i][j] == 1)
                    ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}
//���鼯
class Solution1 {
    class UnionFind{
        int[] parent;
        int[] size;
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            return x == parent[x] ? x : find(parent[x]);
        }
        public int union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y){
                return 0;
            }
            if (size[x] >= size[y]){
                parent[y] = x;
                size[x] += size[y];
                return size[x];
            }else{
                parent[x] = y;
                size[y] += size[x];
                return size[y];
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        UnionFind uf = new UnionFind(r * c);
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1){
                    int id = i * c + j;
                    if (i > 0 && grid[i - 1][j] == 1){
                        uf.union(id - c, id);
                    }
                    if (j > 0 && grid[i][j - 1] == 1){
                        uf.union(id - 1, id);
                    }
                    ans = Math.max(ans, uf.size[uf.find(id)]);
                }
            }
        }
        return ans;
    }
}