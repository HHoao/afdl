package lc_306;

/*
 *@author: �ƺ�
 *@date : 2021��9��14��
 *@todo:306. �ۼ���
�ۼ�����һ���ַ���������������ֿ����γ��ۼ����С�

һ����Ч���ۼ����б������ٰ��� 3 �����������ʼ�����������⣬�ַ����е���������������֮ǰ��������ӵĺ͡�

����һ��ֻ�������� '0'-'9' ���ַ�������дһ���㷨���жϸ��������Ƿ����ۼ�����

˵��: �ۼ���������������� 0 ��ͷ�����Բ������ 1, 2, 03 ���� 1, 02, 3 �������
*/
public class LC_306 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isAdditiveNumber("199100199"));
	}
}
class Solution {
	public String addString(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		StringBuilder sb = new StringBuilder("");
		int extra = 0;
		for (int i = 0; i <= Math.max(n, m) - 1; i++) {
			int num1 = i >= n ? 0 : s1.charAt(n - i - 1) - '0';
			int num2 = i >= m ? 0 : s2.charAt(m - i - 1) - '0';
			int sum = num1 + num2 + extra;
			extra = sum / 10;
			sb.append(sum % 10);
		}
		if (extra > 0) {
			sb.append(extra);
		}
		sb.reverse();
		return sb.toString();
	}
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3){
            return false;
        }
        for (int i = 1; i <= n - i - 1; i++){
            for (int j = i+1; j <= n - Math.max(i, j - i); j++){
                String fNum = num.substring(0, i);
                String sNum = num.substring(i, j);
                String s = addString(fNum, sNum);
                int k = j;
                while (num.startsWith(s, k)){
                    k += s.length();
                    fNum = sNum;
                    sNum = s;
                    s = addString(fNum, sNum);
                }
                if (k == n){
                    return true;
                }
                if (num.charAt(i) == '0'){
                    break;   
                }
            }
            if (num.charAt(0) == '0'){
                break;   
            }
        }
        return false;
    }
}
//�ٷ����
class Solution1 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }
}