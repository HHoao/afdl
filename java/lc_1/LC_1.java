package lc_1;
/*
ʱ�䣺2020��10��8��12:07:01
��Ŀ��������ӡ���1
����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ

����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣

?
*/

public class LC_1 {
	public static void main(String[] args) {
		int[] i1 = new int[] {1, 2, 3, 4, 5, 6, 8};
		for (int i : Solution.twoSum(i1, 10)) {
			System.out.println(i);
		}
	}
}

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

