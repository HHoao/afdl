package lc_466;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��9��30��
 *@todo:466. ͳ���ظ�����
���� str = [s, n] ��ʾ str �� n ���ַ��� s ���ӹ��ɡ�

���磬str == ["abc", 3] =="abcabcabc" ��
������Դ� s2 ��ɾ��ĳЩ�ַ�ʹ���Ϊ s1������ַ��� s1 ���Դ��ַ��� s2 ��á�

���磬���ݶ��壬s1 = "abc" ���Դ� s2 = "abdbec" ��ã�����Ҫɾ���Ӵ�����б���ʶ���ַ���
���ڸ��������ַ��� s1 �� s2 ���������� n1 �� n2 ���ɴ˹���õ������ַ��������� str1 = [s1, n1]��str2 = [s2, n2] ��

�����ҳ�һ��������� m �������� str = [str2, m] ���Դ� str1 ��á�
*/
public class LC_466 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.getMaxRepetitions("baba", 11, "baab", 1));
	}
}
//��̬�滮
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] dp = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            int j = i;
            for (int p = 0; p < s1.length(); p++) {
                if (s1.charAt(p) == s2.charAt(j)) {
                    j = (j + 1) % s2.length();
                    dp[i]++;
                }
            }
        }
        int cnt = 0, p = 0;
        for (int i = 0; i < n1; i++) {
            int add = dp[p];
            p = (p + add) % s2.length();
            cnt += add;
        }
        return cnt / s2.length() / n2;
    }
}
//��ѭ����
class Solution1 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int s1cnt = 0, index = 0, s2cnt = 0;
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        int[] preLoop = new int[2];
        int[] inLoop = new int[2];
        while (true) {
            ++s1cnt;
            for (int i = 0; i < s1.length(); ++i) {
                char ch = s1.charAt(i);
                if (ch == s2.charAt(index)) {
                    index += 1;
                    if (index == s2.length()) {
                        ++s2cnt;
                        index = 0;
                    }
                }
            }
            if (s1cnt == n1) {
                return s2cnt / n2;
            }
            if (recall.containsKey(index)) {
                int[] value = recall.get(index);
                int s1cntPrime = value[0];
                int s2cntPrime = value[1];
                preLoop = new int[]{s1cntPrime, s2cntPrime};
                inLoop = new int[]{s1cnt - s1cntPrime, s2cnt - s2cntPrime};
                break;
            } else {
                recall.put(index, new int[]{s1cnt, s2cnt});
            }
        }
        int ans = preLoop[1] + (n1 - preLoop[0]) / inLoop[0] * inLoop[1];
        int rest = (n1 - preLoop[0]) % inLoop[0];
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }
}