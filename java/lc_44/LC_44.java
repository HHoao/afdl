package lc_44;

/**
 * @author �ƺ�
 *44. ͨ���ƥ��
����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣

'?' ����ƥ���κε����ַ���
'*' ����ƥ�������ַ������������ַ�������
�����ַ�����ȫƥ�����ƥ��ɹ���

˵��:
s = "acdcb"
p = "a*c?b"
���: false
����:
s = "adceb"
p = "*a*b"
���: true
s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
 */
public class LC_44 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.print(s.isMatch("ab", "a*"));
	}
}
//��̬�滮
class Solution{
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
//̰���㷨
class Solution1{
    public boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;
        
        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        return allStars(p, pIndex, pRight);
    }

    public boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }
}
