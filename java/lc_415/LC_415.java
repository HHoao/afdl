package lc_415;

/**
 * @author �ƺ�
 *415. �ַ������
���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺ͡�

 

��ʾ��

num1 ��num2 �ĳ��ȶ�С�� 5100
num1 ��num2 ��ֻ�������� 0-9
num1 ��num2 ���������κ�ǰ����
�㲻��ʹ���κ΃Ƚ� BigInteger �⣬ Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ
 */
public class LC_415 {

}
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // �������Ժ�Ĵ���Ҫ��ת����
        ans.reverse();
        return ans.toString();
    }
}