package lc_1808;

/*
 *@author: �ƺ�
 *@date : 2021��12��25��
 *@todo:1808. �����ӵ������Ŀ
����һ�������� primeFactors ������Ҫ����һ�������� n ������������������

n ����������������Ҫ�����ظ������������Ŀ ������ primeFactors ����
n �����ӵ���Ŀ��󻯡���� n ��һ�����ӿ��Ա� n ��ÿһ�����������������ǳ���������� ������ ���ȷ�˵����� n = 12 ����ô����������Ϊ [2,2,3] ����ô 6 �� 12 �Ǻ����ӣ��� 3 �� 4 ���ǡ�
���㷵�� n �ĺ����ӵ���Ŀ�����ڴ𰸿��ܻ�ܴ��뷵�ش𰸶� 109 + 7 ȡ�� �Ľ����

��ע�⣬һ�������Ķ����Ǵ��� 1 ���Ҳ��ܱ��ֽ�Ϊ����С�ڸ�������Ȼ����ˡ�һ���� n ���������ǽ� n �ֽ�Ϊ���ɸ������ӣ������ǵĳ˻�Ϊ n ��
*/
public class LC_1808 {

}
class Solution {
	static final int MOD = (int)Math.pow(10, 9) + 7;
	private int quickMul(int a, int n) {
		int res = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				res = (int)((long)res * a % MOD);
			}
			a = (int)((long)a * a% MOD);
			n /= 2;
		}
		return res;
	}
	public int integerBreak(int n) {
	    if (n <= 3) {
	        return n - 1;
	    }
	    int quotient = n / 3;
	    int remainder = n % 3;
	    if (remainder == 0) {
	        return (int) quickMul(3, quotient);
	    } else if (remainder == 1) {
	        return (int) ((long)quickMul(3, quotient - 1) * 4 % MOD);
	    } else {
	        return (int) ((long)quickMul(3, quotient) * 2 % MOD);
	    }
	}
	public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) return 1;
        if (primeFactors == 2) return 2;
        if (primeFactors == 3) return 3;
        return integerBreak(primeFactors);
    }
}