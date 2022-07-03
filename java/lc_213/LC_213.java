package lc_213;

/**
 * @author �ƺ�
 *213. ��ҽ��� II
����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��

����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ ���ܹ�͵�Ե�����߽�
 */
public class LC_213 {

}
//�ҵĴ���
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int firstSum = 0, secondSum  = 0;
        int post = 0;
        for (int i = 1, pre = 0, cur = 0; i < n; i++){
            post = Math.max(pre + nums[i - 1], cur);
            pre = cur;
            cur = post;
        }
        firstSum = post;
        post = 0;
       
        for (int i = 2, pre = 0, cur = 0; i <= n; i++){
            post = Math.max(pre + nums[i - 1], cur);
            pre = cur;
            cur = post;
        }
        secondSum = post;
        
        return Math.max(firstSum, secondSum);
    }
}