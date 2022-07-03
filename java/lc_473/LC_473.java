package lc_473;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��10��30��
 *@todo:473. ���ƴ������
���ǵ�ͯ����������СŮ���������ڣ���֪��СŮ���ж��ٸ�������ҳ�һ����ʹ�����л��ƴ��һ�������εķ����������۶ϻ�񣬿��԰ѻ����������������ÿ�����Ҫ�õ���

����ΪСŮ��ӵ�л�����Ŀ��ÿ��������䳤�ȱ�ʾ�������Ϊ�Ƿ��������еĻ��ƴ�������Ρ�
*/
public class LC_473 {
	public static void main(String[] args) {
		System.out.println(new Solution().canPartitionKSubsets(new int[] {3,3,3,3,4}, 4));
	}
}

class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (nums[len - 1] > target) {
            return false;
        }

        int size = 1 << len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            // ���ǻ��� dp[i] = true ��ǰ���½���״̬ת��
            if (!dp[i]) {
                continue;
            }

            // ���ڵ�ǰ״̬�����һ�����Ժ�
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else {
                    // ���������Ѿ��ź������ (currentSum[i] % target) + nums[j] > target��ʣ�µ�����û�б�Ҫö��
                    break;
                }
            }
        }
        return dp[size - 1];
    }
}