package lc_324;

/*
 *@author: �ƺ�
 *@date : 2021��12��23��
 *@todo:324. �ڶ����� II
����һ���������� nums�������������г� nums[0] < nums[1] > nums[2] < nums[3]... ��˳��

����Լ��������������鶼���Եõ�������ĿҪ��Ľ����
*/
public class LC_324 {

}
class Solution {
    public  void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] buckets = new int[5001];
        for (int num : nums){
            buckets[num]++;
        }
        int j = 5000;
        for (int i = 1; i < n; i += 2){
            while (buckets[j] == 0) j--;
            nums[i] = j;
            buckets[j]--;
        }
        for (int i = 0; i < n; i += 2){
            while (buckets[j] == 0) j--;
            nums[i] = j;
            buckets[j]--;
        }
    }
}