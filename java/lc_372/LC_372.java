package lc_372;

/*
 *@author: �ƺ�
 *@date : 2021��12��24��
 *@todo:
*/
public class LC_372 {

}
//�������
class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}
//�ؾ����㷨
class Solution1 {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow(ans, 10) * pow(a, e) % MOD);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}
