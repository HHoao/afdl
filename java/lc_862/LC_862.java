package lc_862;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2021��12��31��
 *@todo:862. ������Ϊ K �����������
����һ���������� nums ��һ������ k ���ҳ� nums �к�����Ϊ k �� ��̷ǿ������� �������ظ�������ĳ��ȡ���������������� ������ ������ -1 ��

������ �������� ���� ��һ���֡�
*/
public class LC_862 {

}
//ǰ׺��+��������
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[n + 1];
        Deque<Integer> monotoQueue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            f[i] = (long)nums[i - 1] + f[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++){
            while (!monotoQueue.isEmpty() && f[i] <= f[monotoQueue.getLast()]){
                monotoQueue.removeLast();
            }
            while (!monotoQueue.isEmpty() && f[i] - k >= f[monotoQueue.getFirst()]){
                ans = Math.min(i - monotoQueue.removeFirst(), ans);
            }
            monotoQueue.offer(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}