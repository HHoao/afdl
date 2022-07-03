package lc_91;

/**
 * @author �ƺ�
 *91. ���뷽��
һ��������ĸ A-Z ����Ϣͨ������ӳ������� ���� ��

'A' -> 1
'B' -> 2
...
'Z' -> 26
Ҫ ���� �ѱ������Ϣ���������ֱ����������ӳ��ķ���������ӳ�����ĸ�������ж��ַ����������磬"111" ���Խ� "1" �е�ÿ�� "1" ӳ��Ϊ "A" ���Ӷ��õ� "AAA" �����߿��Խ� "11" �� "1"���ֱ�Ϊ "K" �� "A" ��ӳ��Ϊ "KA" ��ע�⣬"06" ����ӳ��Ϊ "F" ����Ϊ "6" �� "06" ��ͬ��

����һ��ֻ�����ֵ� �ǿ� �ַ��� num ������㲢���� ���� ������ ���� ��

��Ŀ���ݱ�֤�𰸿϶���һ�� 32 λ ��������
 */
public class LC_91 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numDecodings("27"));//22626
	}
}
//��̬�滮
//����������ô����
class Solution{
	public int numDecodings(String s) {
		if (s == null || s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 1;
		if (n > 1) {
			if (s.charAt(1) - 48 == 0) {
				if (s.charAt(0) - 48> 2) {
					return 0;
				}else {
					dp[1] = 1;
				}
			}else {
				if (s.charAt(0) - 48 > 2) {
					dp[1] = 1;
				} else {
					if (s.charAt(0) - 48 == 2) {
						if (s.charAt(1) - 48 <= 6) {
							dp[1] = 2;
						}else {
							dp[1] = 1;
						}
					}else {
						dp[1] = 2;
					}
				}
				
			}
		}
		
		for (int i = 2; i < n; i++) {
			if (s.charAt(i) - 48 == 0) {
				if (s.charAt(i - 1) - 48 > 2) {
					return 0;
				}else if (s.charAt(i - 1) - 48 == 0){
					return 0;
				}else{
					dp[i] = dp[i - 2];
					dp[i-1] = 0;
				}
			}else if(s.charAt(i - 1) - 48 > 2) {
				dp[i] = dp[i - 1];
			}else {
				if (s.charAt(i - 1) - 48 == 2) {
					if (s.charAt(i) - 48 <= 6) {
						dp[i] = dp[i - 1] + dp[i - 2];
					}else {
						dp[i] = dp[i - 1];
					}
				}else if (s.charAt(i - 1) - 48== 0){
					dp[i] = dp[i - 1];
				}else{
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
		}
		return dp[n - 1];
    }
}

//������
class Solution1 {
    public int numDecodings(String s) {
        if(s.charAt(0) =='0') return 0;
        int pre = 1,curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            if (s.charAt(i) == '0') {
                if(s.charAt(i-1) =='1' || s.charAt(i-1)=='2') curr =pre;
                else return 0;
            } else if (s.charAt(i-1)=='1' ||(s.charAt(i-1) =='2' &&s.charAt(i)>='1'&&s.charAt(i)<='6')) {
                curr = curr+pre;
            }
            pre =temp;
        }
        return curr;
    }
}