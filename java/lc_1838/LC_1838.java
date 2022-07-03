package lc_1838;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��12��28��
 *@todo:1838. ���ƵԪ�ص�Ƶ��
Ԫ�ص� Ƶ�� �Ǹ�Ԫ����һ�������г��ֵĴ�����

����һ���������� nums ��һ������ k ����һ�������У������ѡ�� nums ��һ���±꣬�������±��ӦԪ�ص�ֵ���� 1 ��

ִ����� k �β����󣬷������������ƵԪ�ص� ������Ƶ�� ��
*/
public class LC_1838 {
	public static void main(String[] args) {
		new Solution().maxFrequency(new int[]{3,9,6,7,1,5,2} ,2);
	}
}
//�ҵ����(���򻬶�)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 1;
        int res = 0;
        int r = n - 1;
        int total = 0;
        Arrays.sort(nums);
        for (int l = n - 2; l >= 0; l--){
        	total += (long)(nums[r] - nums[l]);
            while (total > k) {
            	total -= ((nums[r] - nums[r - 1]) * (r - l));
            	r--;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
//�ٷ���������
class Solution1 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
