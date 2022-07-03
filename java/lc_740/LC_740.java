package lc_740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��5��5��
 *@todo:740. ɾ������õ���
����һ���������� nums ������Զ�������һЩ������

ÿ�β����У�ѡ������һ�� nums[i] ��ɾ��������� nums[i] �ĵ�����֮�������ɾ��ÿ������ nums[i] - 1 �� nums[i] + 1 ��Ԫ�ء�

��ʼ��ӵ�� 0 ����������������ͨ����Щ������õ���������
*/
public class LC_740 {

}
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                ++size;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
}
//����̬�滮
class Solution1 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                ++size;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public int rob(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
}