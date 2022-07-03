package lc_851;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��12��15��
 *@todo:851. ���ֺ͸���
��һ�� n ������Ϊʵ����󣬴� 0 �� n - 1 ��ţ�����ÿ���˶��в�ͬ��Ŀ��Ǯ���Լ���ͬ�̶ȵİ���ֵ��quietness����Ϊ�˷�����������ǽ����Ϊ x ���˼��Ϊ "person x "��

����һ������ richer ������ richer[i] = [ai, bi] ��ʾ person ai �� person bi ����Ǯ�������һ���������� quiet ������ quiet[i] �� person i �İ���ֵ��richer �������������� �߼���ǡ��Ҳ����˵���� person x �� person y ����Ǯ��ͬʱ��������� person y �� person x ����Ǯ����� ����

���ڣ�����һ���������� answer ��Ϊ�𰸣����� answer[x] = y ��ǰ���ǣ�������ӵ�е�Ǯ�϶������� person x �����У�person y ��������ˣ�Ҳ���ǰ���ֵ quiet[y] ��С���ˣ���
*/
public class LC_851 {
	public static void main(String[] args) {
		new Solution().loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[] {3,2,5,4,6,1,7,0});
	}
}
//��������
class Solution1 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int m = richer.length;
        int[] ret = new int[n];
        int[] map = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer>[] lists = new List[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
        	lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++){
            map[richer[i][1]]++;
            lists[richer[i][0]].add(richer[i][1]);
        }
        for (int i = 0; i < n; i++){
            if (map[i] == 0){
                queue.offer(i);
            }
            parent[i] = i;
        }
        while(!queue.isEmpty()){
            int person = queue.poll();
            List<Integer> ps = lists[person];
            for (Integer k : ps){
                if (quiet[k] > quiet[person]){
                    quiet[k] = Math.min(quiet[k], quiet[person]);
                    parent[k] = parent[person];
                }
                map[k]--;
                if (map[k] == 0){
                    queue.offer(k);
                }
            }
            ret[person] = parent[person];
        }
        return ret;
    }
}
//�����������
class Solution {
    int[] vis;
    int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = richer.length, m = quiet.length;
        List<Integer>[] g = new List[m];
        this.quiet = quiet;
        vis = new int[m];
        Arrays.fill(vis, -1);
        for (int i = 0; i < m; i++){
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++){
            g[richer[i][1]].add(richer[i][0]);
        }
        int[] ret = new int[m];
        for (int i = 0; i < m; i++){
            ret[i] = dfs(i, g)[0];
        }
        return ret;
    }
    public int[] dfs(Integer person, List<Integer>[] g){
        if (vis[person] != -1){
            return new int[]{vis[person], quiet[person]};
        }
        int parent = person;
        int q = quiet[parent];
        for (Integer k : g[person]){
            int[] p =  dfs(k, g);
            if (p[1] < q){
                parent = p[0];
                q = p[1];
            }
        }
        quiet[person] = q;
        vis[person] = parent;
        return new int[]{parent, q};
    }
}