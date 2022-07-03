package lc_219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author �ƺ�
 *219. �����ظ�Ԫ�� II
����һ�����������һ������ k���ж��������Ƿ����������ͬ������ i �� j��ʹ�� nums [i] = nums [j]������ i �� j �Ĳ�� ����ֵ ����Ϊ k��
 */
public class LC_219 {

}


//�ҵĴ���
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int len  = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (indexMap.containsKey(nums[i])){
                int index = indexMap.get(num);
                len = i - index;
                if (len <= k) return true;
            }
            indexMap.put(num, i);
        }
        return false;
    }
}