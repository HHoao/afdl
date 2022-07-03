package lc_482;

/*
 *@author: �ƺ�
 *@date : 2021��12��20��
 *@todo:482. ��Կ��ʽ��
��һ����Կ�ַ��� S ��ֻ������ĸ�������Լ� '-'�����ۺţ������У� N �� '-' ���ַ����ֳ��� N+1 �顣

����һ������ K���������¸�ʽ���ַ�����ʹÿ������ǡ�ð��� K ���ַ����ر�أ���һ������������ַ���������С�ڵ��� K��������Ҫ���� 1 ���ַ�����������֮����Ҫ�� '-'�����ۺţ����������ҽ����е�Сд��ĸת��Ϊ��д��ĸ��

�����ǿ��ַ��� S ������ K���������������Ĺ�����и�ʽ����

 
*/
public class LC_482 {

}
//ģ��
class Solution {
}
//�Ӻ���ǰ����
class Solution1 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }
        
        return ans.reverse().toString();
    }
}