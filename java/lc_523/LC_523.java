package lc_523;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��28��
 *@todo:523. �������������
����һ���������� nums ��һ������ k ����дһ���������жϸ������Ƿ���ͬʱ�����������������������飺

�������С ����Ϊ 2 ����
������Ԫ���ܺ�Ϊ k �ı�����
������ڣ����� true �����򣬷��� false ��

�������һ������ n �������� x ���� x = n * k ����� x �� k ��һ��������0 ʼ����Ϊ k ��һ��������
*/
public class LC_523 {

}
//����
class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n+1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1] + nums[i - 1];
            for (int j = 0; j < i - 1; j++){
                if ((f[i] - f[j]) %k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
//ǰ׺��+��ϣ��
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int remainder = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++){
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)){
                if (i - map.get(remainder) >= 2){
                    return true;
                }
            }else{
                map.put(remainder, i);
            }
        }
        return false;
    }
}