package lc_376;

/*
 *@author: �ƺ�
 *@date : 2021��10��29��
 *@todo:376. �ڶ�����
�����������֮��Ĳ��ϸ���������͸���֮�佻�棬���������г�Ϊ �ڶ����� ����һ���������ڵĻ�����������������������һ��Ԫ�ػ��ߺ���������Ԫ�ص�����Ҳ�����ڶ����С�

���磬 [1, 7, 4, 9, 2, 5] ��һ�� �ڶ����� ����Ϊ��ֵ (6, -3, 5, -7, 3) ������������ֵġ�

�෴��[1, 4, 7, 2, 5] �� [1, 7, 4, 5, 5] ���ǰڶ����У���һ����������Ϊ����ǰ������ֵ�����������ڶ�����������Ϊ�������һ����ֵΪ�㡣
������ ����ͨ����ԭʼ������ɾ��һЩ��Ҳ���Բ�ɾ����Ԫ������ã�ʣ�µ�Ԫ�ر�����ԭʼ˳��

����һ���������� nums ������ nums ����Ϊ �ڶ����� �� ������еĳ��� ��
*/
public class LC_376 {
	public static void main(String[] args) {
		System.out.println(new Solution().wiggleMaxLength(new int[] {3,3,3,2,5}));
	}
}
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1, n = nums.length;
        int[] seq = new int[n - 1];
        int zeros = 0;
        int k = 0;
        for (int i = 1; i < n; i++){
            seq[i - 1] = nums[i] - nums[i - 1];
            zeros += seq[i - 1] == 0 ? 1 : 0;
            k = (seq[i - 1] != 0 && k == 0) ? seq[i - 1] : k;
        }
        
        if (n == 1 || zeros == n - 1) return 1;
        for (int i = 1; i < n - 1; i++){
            if ((seq[i] > 0 && k < 0) || (seq[i] < 0 && k > 0)){
                ans++;
                k = -k;
            }
        }
        return ans+1;
    }
}
//�Ż�(̰��)
class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}