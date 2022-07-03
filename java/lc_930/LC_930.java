package lc_930;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��1��
 *@todo:930. ����ͬ�Ķ�Ԫ������
����һ����Ԫ���� nums ����һ������ goal ������ͳ�Ʋ������ж��ٸ���Ϊ goal �� �ǿ� �����顣

������ �������һ���������֡�
*/
public class LC_930 {

}
//ǰ׺��+��ϣ��
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (map.containsKey(sum -goal)){
                ans += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
//��������
class Solution1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, ans = 0;
        int l1 = 0, l2 = 0;
        int sum1 = 0, sum2 = 0;
        for (int i  = 0; i < n; i++){
            sum1 += nums[i];
            while (l1 <= i && sum1 > goal){
                sum1 -= nums[l1];
                l1++;
            }
            sum2 += nums[i];
            while (l2 <= i && sum2 >= goal){
                sum2 -= nums[l2];
                l2++;
            }
            ans += l2 - l1;
        }
        return ans;
    }
}