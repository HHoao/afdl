package lc_547;

/*
 *@author: �ƺ�
 *@date : 2021��12��13��
 *@todo:547. ʡ������
�� n �����У�����һЩ�˴���������һЩû��������������� a ����� b ֱ���������ҳ��� b ����� c ֱ����������ô���� a ����� c ���������

ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�

����һ�� n x n �ľ��� isConnected ������ isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ���������� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������

���ؾ����� ʡ�� ��������
*/
public class LC_547 {

}
//�����������
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (visited[i]) continue;
            visited[i] = true;
            for (int j = i+1; j < isConnected[i].length; j++){
                if (!visited[j] && isConnected[i][j] == 1){
                    visited[j] = true;
                    dfs(isConnected, j);
                }
            }
            ans++;
        }
        return ans;
    }
    public void dfs(int[][] isConnected, int city){
        int[] co = isConnected[city];
        for (int i = 0; i < co.length; i++){
            if (!visited[i] && co[i] == 1){
                visited[i] = true;
                dfs(isConnected, i);
            }
        }
    }
}
//���鼯
class Solution1 {
    class UnionFind{
        int[] parent;
        int[] size;
        int n;
        int setCount;
        UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            this.n = n;
            this.setCount = n;
            for (int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            return x == parent[x] ? x : find(parent[x]);
        }
        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y){
                return;
            }
            if (size[x] >= size[y]){
                size[x] += size[y];
                parent[y] = x;
            }else{
                size[y] += size[x];
                parent[x] = y;
            }
            setCount--;
        }
        boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < isConnected[i].length; j++){
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.setCount;
    }
}