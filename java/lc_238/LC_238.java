package lc_238;

/**
 * @author �ƺ�
 *238. ��������������ĳ˻�
����һ������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
 */
public class LC_238 {

}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++){
            ans[i] = ans[i - 1] * nums[i-1];
        }
        int R = 1;
        for (int i = n - 1; i >= 1; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        ans[0] = R;
        return ans;
    }
}