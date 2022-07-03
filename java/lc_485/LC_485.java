package lc_485;

/*
 *@author: �ƺ�
 *@date : 2021��12��2��
 *@todo:485. ������� 1 �ĸ���
����һ�����������飬 ��������������� 1 �ĸ�����
*/
public class LC_485 {

}
//����
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int cur= 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                cur++;
                ans = Math.max(cur, ans);
            }else{
                cur = 0;
            }
        }
        return ans;
    }
}