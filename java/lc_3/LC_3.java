/*
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 */
package lc_3;
import java.util.*;

public class LC_3 {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println(Solution.lengthOfLongestSubstring(s1.next()));
		s1.close();
		
	}
}
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // ��ָ�룬��ʼֵΪ -1���൱���������ַ�������߽����࣬��û�п�ʼ�ƶ�
        int rk = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // ��ָ�������ƶ�һ���Ƴ�һ���ַ�
                occ.remove(s.charAt(i - 1));
            }
            while (rk < n && !occ.contains(s.charAt(rk))) {
                // ���ϵ��ƶ���ָ��
                occ.add(s.charAt(rk));
                ++rk;
            }
            // �� i �� rk ���ַ���һ�����������ظ��ַ��Ӵ�
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }
}