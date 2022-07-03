package lc_525;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��28��
 *@todo:525. ��������
����һ������������ nums , �ҵ�������ͬ������ 0 �� 1 ������������飬�����ظ�������ĳ��ȡ�
*/
public class LC_525 {

}
//ǰ׺��+��ϣ��
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        for (int i = 0; i <n; i++){
            if (nums[i] == 0){
                zeros++;
            }else{
                ones++;
            }
            int ext = zeros - ones;
            if (map.containsKey(ext)){
                int ind =  map.get(ext);
                ans = Math.max(ans, i - ind);
            }else{
                map.put(ext, i);
            }
        }
        return ans;
    }
}
//�ٷ�
class Solution1 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int ans = 0;
        for (int i = 0; i <n; i++){
            if (nums[i] == 0){
                count++;   
            }else{
                count--;
            }
            if (map.containsKey(count)){
                int ind =  map.get(count);
                ans = Math.max(ans, i - ind);
            }else{
                map.put(count, i);
            }
        }
        return ans;
    }
}