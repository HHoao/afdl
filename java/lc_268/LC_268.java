package lc_268;

/*
 *@author: �ƺ�
 *@date : 2021��5��2��
 *TODO:268. ��ʧ������
����һ������ [0, n] �� n ���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����

 

���ף�

���ܷ�ʵ������ʱ�临�Ӷȡ���ʹ�ö��ⳣ���ռ���㷨���������?
*/
public class LC_268 {

}
//�ҵĴ���
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++){
            sum += i;
            k += nums[i];
        }
        sum += n;
        return sum - k;
    }
}
//λ����
class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; i++){
            ans ^= nums[i] ^ i; 
        }
        return ans;
    }
}