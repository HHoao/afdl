package lc_787;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��9��17��
 *@todo:787. K վ��ת������˵ĺ���
�� n ������ͨ��һЩ�������ӡ�����һ������ flights ������ flights[i] = [fromi, toi, pricei] ����ʾ�ú��඼�ӳ��� fromi ��ʼ���Լ۸� pricei �ִ� toi��

���ڸ������еĳ��кͺ��࣬�Լ��������� src ��Ŀ�ĵ� dst������������ҵ���һ����ྭ�� k վ��ת��·�ߣ�ʹ�ô� src �� dst �� �۸������ �������ظü۸� ���������������·�ߣ������ -1��

 *
*/
public class LC_787 {
}
//dp + dfs + ��֦
class Solution {
    int[][] dp;
    Map<Integer, List<Integer[]>> mappers;
    public void dfs(int src, int dst, int i, int price, int k){
        if (i == k + 2 || (i > 0 && price > Arrays.stream(dp[src]).min().getAsInt())){
            return;
        }
        dp[src][i] = Math.min(dp[src][i], price);
        if (src == dst){
            return;
        }
        List<Integer[]> mapper = mappers.get(src);
        if (mapper != null)
            for (Integer[] toCity : mapper){
                dfs(toCity[0], dst, i+1, dp[src][i] + toCity[1], k);
            }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        mappers = new HashMap<>();
        for (int[] flight : flights){
            List<Integer[]> mapper = mappers.getOrDefault(flight[0], new ArrayList<>());
            mapper.add(new Integer[]{flight[1], flight[2]});
            mappers.put(flight[0], mapper);
        }
        dp = new int[n][k + 2];
        for (int[] ini : dp){
            Arrays.fill(ini, 2147483647);
        }
        dfs(src, dst, 0, 0, k);
        int ans = Arrays.stream(dp[dst]).min().getAsInt();
        return  ans == 2147483647 ? -1 : ans;
    }
}
//dp
class Solution1 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k+2][n];
        for (int i = 0; i <= k + 1; i++){
            for (int j = 0; j < n; j++){
                if (j != src)
                    dp[i][j] = 100000;
            }
        }
        List<List<int[]>> toInfs = new ArrayList<>();
        for (int i = 0; i < n; i++){
            toInfs.add(new ArrayList<>());
        }
        for (int[] flight : flights){
            toInfs.get(flight[1]).add(new int[]{flight[0], flight[2]});
        }
        for (int i = 1; i <= k + 1; i++){
            for (int j = 0; j < n; j++){
                List<int[]> toInf = toInfs.get(j);
                for (int[] info : toInf){
                    dp[i][j] =  Math.min(dp[i][j], dp[i - 1][info[0]] + info[1]);
                }
            }
        }
        int ans = 100000;
        for (int i = 0; i <= k + 1; i++){
            ans = Math.min(dp[i][dst], ans);
        }
        return ans == 100000 ? -1 : ans;
    }
}
//��ά����dp
class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k+2][n];
        for (int i = 0; i <= k + 1; i++){
            for (int j = 0; j < n; j++){
                if (j != src)
                    dp[i][j] = 100000;
            }
        }
        
        for (int i = 1; i <= k + 1; i++){
            for (int[] flight : flights){
                dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
            }
        }
        int ans = 100000;
        for (int i = 0; i <= k + 1; i++){
            ans = Math.min(dp[i][dst], ans);
        }
        return ans == 100000 ? -1 : ans;
    }
}
//�ٷ�dp (һά����)
class Solution3 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }
}