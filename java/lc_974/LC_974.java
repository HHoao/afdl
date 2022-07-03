package lc_974;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��1��
 *@todo:974. �Ϳɱ� K ������������
����һ���������� A����������Ԫ��֮�Ϳɱ� K �����ģ��������ǿգ����������Ŀ��
*/
public class LC_974 {

}
//��ϣ��+ǰ׺��
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum = (sum + nums[i]) % k;
            if (sum < 0){
                ans += map.getOrDefault(sum +k, 0);
            }else{
                ans += map.getOrDefault(sum - k, 0);
            }
            ans += map.getOrDefault(sum, 0);
        }
        return ans;
    }
}
//�����ϣ + ǰ׺��
class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[2 * k];
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            f[k+sum]++;
            sum = (sum + nums[i]) % k;
            if (sum < 0){
                ans += f[2 * k+sum];
            }else{
                ans += f[sum];
            }
            ans += f[k + sum];
        }
        return ans;
    }
}
//�������
class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[k];
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            f[sum]++;
            sum = ((sum + nums[i]) % k + k) % k;
            ans += f[sum];
        }
        return ans;
    }
}