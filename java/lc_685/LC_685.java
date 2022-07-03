package lc_685;

import com.sun.tools.javac.Main;

/*
 *@author: �ƺ�
 *@date : 2021��12��14��
 *@todo:685. �������� II
�ڱ������У��и���ָ�������������� ���� ͼ������ֻ��һ�����ڵ㣬���������ڵ㶼�Ǹø��ڵ�ĺ�̡��������˸��ڵ�֮���ÿһ���ڵ㶼����ֻ��һ�����ڵ㣬�����ڵ�û�и��ڵ㡣

����һ������ͼ����ͼ��һ������ n ���ڵ㣨�ڵ�ֵ���ظ����� 1 �� n��������һ�����ӵ�����߹��ɡ����ӵı߰����� 1 �� n �е�������ͬ����䣬�������ӵı߲����������Ѵ��ڵıߡ�

���ͼ��һ���Ա���ɵĶ�ά���� edges �� ÿ��Ԫ����һ�� [ui, vi]�����Ա�ʾ ���� ͼ�����Ӷ��� ui �Ͷ��� vi �ıߣ����� ui �� vi ��һ�����ڵ㡣

����һ����ɾ���ıߣ�ʹ��ʣ�µ�ͼ���� n ���ڵ���и��������ж���𰸣������������ڸ�����ά����Ĵ𰸡�

 
*/
public class LC_685 {
	public static void main(String[] args) {
		new Solution().findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
	}
}
//���鼯(˼·����+ÿһ�����ߵ���)
class Solution {
    class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            return x == parent[x] ? x : find(parent[x]);
        }
        public void union(int x, int y){
            parent[find(x)] = parent[find(y)];
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        int[] parent = new int[n + 2];
        int cycle = - 1;
        int conflict = -1;
        for (int i = 0; i < n; i++){
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (uf.find(node2) != node2){
                conflict = i;
            }else{
                parent[node2] = node1;
                if (uf.find(node2) == uf.find(node1)){
                    cycle = i;
                }else{
                    uf.union(node2, node1);
                }
            }
        }
        if (conflict != -1){
            if (cycle == -1){
            	return new int[] {edges[conflict][0], edges[conflict][1]};
            }else{
            	return new int[] {parent[edges[conflict][1]], edges[conflict][1]};
            }
        }else{
        	return new int[] {edges[cycle][0], edges[cycle][1]};
        }
    }
}