package lc_60;

import java.util.Arrays;

/**
 * @author �ƺ�
 *60. ��������
�������� [1,2,3,...,n]��������Ԫ�ع��� n! �����С�

����С˳���г����������������һһ��ǣ��� n = 3 ʱ, �����������£�

"123"
"132"
"213"
"231"
"312"
"321"
���� n �� k�����ص� k �����С�
 */
public class LC_60 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.getPermutation(3, 3));
	}
}
//��ѧ + ��С�����ģ
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}