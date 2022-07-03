package lc_2029;

/*
 *@author: �ƺ�
 *@date : 2022��1��20��
 *@todo:2029. ʯ����Ϸ IX
Alice �� Bob �ٴ������һ���µ�ʯ����Ϸ������һ�� n ��ʯ�ӣ�ÿ��ʯ�Ӷ���һ�����������ֱ�ʾ���ļ�ֵ������һ���������� stones ������ stones[i] �ǵ� i ��ʯ�ӵļ�ֵ��

Alice �� Bob ���������Լ��Ļغϣ�Alice ���֡�ÿһ�غϣ������Ҫ�� stones ���Ƴ���һʯ�ӡ�

�������Ƴ�ʯ�Ӻ󣬵��� �������Ƴ�ʯ�� �ļ�ֵ �ܺ� ���Ա� 3 ��������ô����Ҿ� �����Ϸ ��
�����������һ�������Ƴ���û���κ�ʣ���ʯ�ӣ���ô Bob ����ֱ�ӻ�ʤ���������� Alice �Ļغϣ���
������λ��Ҿ����� ��� ���ߡ���� Alice ��ʤ������ true ����� Bob ��ʤ������ false ��

 

ʾ�� 1��

���룺stones = [2,1]
�����true
���ͣ���Ϸ�������£�
- �غ� 1��Alice �����Ƴ�����һ��ʯ�ӡ�
- �غ� 2��Bob �Ƴ�ʣ�µ�ʯ�ӡ� 
���Ƴ���ʯ�ӵ�ֵ�ܺ�Ϊ 1 + 2 = 3 �ҿ��Ա� 3 ��������ˣ�Bob �䣬Alice ��ʤ��
ʾ�� 2��

���룺stones = [2]
�����false
���ͣ�Alice ���Ƴ�Ψһһ��ʯ�ӣ����Ƴ�ʯ�ӵ�ֵ�ܺ�Ϊ 2 �� 
��������ʯ�Ӷ����Ƴ�����ֵ�ܺ��޷��� 3 ������Bob ��ʤ��
*/
public class LC_2029 {
	public static void main(String[] args) {
		System.out.println(new Solution().stoneGameIX(new int[] {15,20,10,13,14,15,5,2,3}));
	}
}
//�������Ѳ���(��ʱ)
class Solution {
    private boolean dfs(int sum, int[] stones, int k, boolean[] vis){
        int n = stones.length;
        for (int i = 0; i < n; i++){
            if (!vis[i]){
                if ((sum+stones[i]) % 3 == 0) continue;
                if (k+1 == n) return n % 2 == 0 ? true : false;
                vis[i] = true;
                if (!dfs(sum+stones[i], stones, k+1, vis)){
                    vis[i] = false;
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
         
        return dfs(0, stones, 0, vis);
    }
}
//����
class Solution1 {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }
}
