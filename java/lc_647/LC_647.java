package lc_647;

/*
 *@author: �ƺ�
 *@date : 2021��9��28��
 *@todo:647. �����Ӵ�
����һ���ַ��� s ������ͳ�Ʋ���������ַ����� �����Ӵ� ����Ŀ��

�����ַ��� �����Ŷ��͵�������һ�����ַ�����

���ַ��� ���ַ����е��������ַ���ɵ�һ�����С�

���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
*/
public class LC_647 {

}
//�ҵ�dp
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (s.charAt(i) == s.charAt(j) && i !=  j && !dp[i][j]){
                    if ((i < n - 1 && j > 1 && dp[i + 1][j - 1]) || (i > 1 && j < n - 1) && dp[i - 1][j + 1]|| Math.abs(i - j) == 1){
                        count++;
                        dp[i][j] = true;
                        dp[j][i] = true;
                    }
                }
            }
        }
        return count;
    }
}
//������չ
class Solution1 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
//Manacher
class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // ��ʼ�� f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // ������չ
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // ��̬ά�� iMax �� rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // ͳ�ƴ�, ��ǰ����Ϊ (f[i] - 1) / 2 ��ȡ��
            ans += f[i] / 2;
        }

        return ans;
    }
}