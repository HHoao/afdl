package lc_698;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��11��3��
 *@todo:698. ����Ϊk����ȵ��Ӽ�
����һ����������  nums ��һ�������� k���ҳ��Ƿ��п��ܰ��������ֳ� k ���ǿ��Ӽ������ܺͶ���ȡ�
*/
public class LC_698 {

}
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) return false;
        Arrays.sort(nums);
        int target = total / k;
        int size = 1 << len;
        boolean[] valid = new boolean[size];
        int[] curSum = new int[size];
        valid[0] = true;
        for (int i = 0; i < size; i++){
            if (!valid[i]) continue;
            for (int j = 0; j < len; j++){
                if ((i & 1 << j) != 0) continue;
                int next = i | 1 << j;
                if (valid[next]) continue;
                if ((curSum[i] % target) + nums[j] <= target){
                    valid[next] = true;
                    curSum[next] = curSum[i] + nums[j];
                }else{
                    break;
                }
            }
        }
        return valid[size - 1];
    }
}