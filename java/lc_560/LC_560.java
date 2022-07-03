package lc_560;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��30��
 *@todo:560. ��Ϊ K ��������
����һ���������� nums ��һ������ k ������ͳ�Ʋ����ظ������к�Ϊ k ������������ĸ�����
*/
public class LC_560 {

}
//ǰ׺��+��ϣ��
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}