package lc_354;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��27��
 *@todo:354. ����˹�����ŷ�����
����һ����ά�������� envelopes ������ envelopes[i] = [wi, hi] ����ʾ�� i ���ŷ�Ŀ�Ⱥ͸߶ȡ�

����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ������ŷ�Ϳ��ԷŽ���һ���ŷ����ͬ����˹����һ����

����� ������ж��ٸ� �ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ����棩��

ע�⣺��������ת�ŷ⡣
*/
public class LC_354 {

}
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] f = new int[n];
        Arrays.sort(envelopes, (a, b)->a[0]-b[0]);
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    f[i] = Math.max(f[i], f[j]+1);
                    ans = Math.max(ans, f[i]);
                }
            }
        }
        return ans;
    }
}