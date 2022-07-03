package lc_55;

/**
 * @author �ƺ�
 *
 *55. ��Ծ��Ϸ
����һ���Ǹ��������� nums �������λ������� ��һ���±� ��

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

�ж����Ƿ��ܹ��������һ���±�
 */
public class LC_55 {

}
//̰��
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
