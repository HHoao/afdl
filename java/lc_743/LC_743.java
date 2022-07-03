package lc_743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 *@author: �ƺ�
 *@date : 2021��8��15��
 *@todo:743. �����ӳ�ʱ��
�� n ������ڵ㣬���Ϊ 1 �� n��

����һ���б� times����ʾ�źž��� ���� �ߵĴ���ʱ�䡣 times[i] = (ui, vi, wi)������ ui ��Դ�ڵ㣬vi ��Ŀ��ڵ㣬 wi ��һ���źŴ�Դ�ڵ㴫�ݵ�Ŀ��ڵ��ʱ�䡣

���ڣ���ĳ���ڵ� K ����һ���źš���Ҫ��ò���ʹ���нڵ㶼�յ��źţ��������ʹ���нڵ��յ��źţ����� -1 ��
*/
public class LC_743 {
	public static void main(String[] args) {
		int[][] arr = {{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},
					   {3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},
					   {1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
		Solution so = new Solution();
		System.out.println(so.networkDelayTime(arr, 5, 3));
		
	}
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] mat = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(mat,  2147483647);
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge: times){
            List<int[]> edgeSet = adj.getOrDefault(edge[0], new ArrayList<>());
            edgeSet.add(new int[]{edge[1], edge[2]});
            adj.put(edge[0], edgeSet);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{k, 0});
        mat[k] = 0;
        int count = 0;
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            if (!visited[point[0]]){
                count++;
                visited[point[0]] = true;
                
                List<int[]> edges = adj.get(point[0]);
                if (edges != null){
                    for (int[] edge: edges){
                        if (mat[edge[0]] > point[1] + edge[1]){
                            mat[edge[0]] = point[1] + edge[1];
                            queue.offer(new int[]{edge[0], mat[edge[0]]});
                        }
                    }
                }
            }
        }
        mat[0] = 0;
        return count == n ? Arrays.stream(mat).max().getAsInt() : -1;
    }
}
//�ٷ�
class Solution1 {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}