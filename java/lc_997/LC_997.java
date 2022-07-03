package lc_997;

/*
 *@author: �ƺ�
 *@date : 2021��12��19��
 *@todo:997. �ҵ�С��ķ���
��һ��С������� 1 �� n Ϊ n ���˽��б�š����Գƣ���Щ������һ����С���ϵ����ܷ��١�

���С��ķ�����Ĵ��ڣ���ô��

С��ķ��ٲ������κ��ˡ�
ÿ���ˣ�����С�򷨹��⣩������С��ķ��١�
ֻ��һ����ͬʱ�������� 1 ������ 2 ��
�������� trust�������������ζ� trust[i] = [a, b] ��ɣ���ʾ���Ϊ a �������α��Ϊ b ���ˡ�

���С��������ܷ��ٲ��ҿ���ȷ��������ݣ��뷵�ظ÷��ٵı�š����򣬷��� -1��
*/
public class LC_997 {

}
//���
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] targets = new int[n+1];
        boolean[] vis = new boolean[n+1];
        int m = trust.length;
        for (int i = 0; i < m; i++){
            targets[trust[i][1]]++;
            vis[trust[i][0]] = true;
            if (targets[trust[i][1]] == n) 
                return -1;
        }
        for (int i = 1; i <= n; i++){
            if (targets[i] == n - 1 && !vis[i])
                return i;
        }
        return -1;
    }
}