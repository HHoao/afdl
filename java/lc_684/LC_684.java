package lc_684;

/*
 *@author: �ƺ�
 *@date : 2021��12��13��
 *@todo:684. ��������
�����Կ�����һ����ͨ�� �޻� �� ���� ͼ��

������һ�� n ���ڵ� (�ڵ�ֵ 1��n) ���������һ���ߺ��ͼ����ӵıߵ�������������� 1 �� n �м䣬���������ӵı߲����������Ѵ��ڵıߡ�ͼ����Ϣ��¼�ڳ���Ϊ n �Ķ�ά���� edges ��edges[i] = [ai, bi] ��ʾͼ���� ai �� bi ֮�����һ���ߡ�

���ҳ�һ������ɾȥ�ıߣ�ɾ�����ʹ��ʣ�ಿ����һ������ n ���ڵ����������ж���𰸣��򷵻����� edges �������ֵıߡ�
*/
public class LC_684 {

}
//���鼯
class Solution {
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
            return parent[x] == x ? x : find(parent[x]);
        }
        boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (size[x] >= size[y]){
                size[y] += size[x];
                parent[y] = x;
            }else{
                size[x] += size[y];
                parent[x] = y;
            }
            setCount--;
            return true;
        }
        boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        UnionFind unionFind = new UnionFind(1001);
        for (int i = 0; i < n; i++){
            if (!unionFind.union(edges[i][0], edges[i][1])){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }
        }
        return ans;
    }
}