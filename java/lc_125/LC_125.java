package lc_125;

/**
 * @author �ƺ�
 *125. ��֤���Ĵ�
����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 */
public class LC_125 {

}
//�ҵĴ���
class Solution {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int pre = 0, post = n - 1;
        while (pre < n){
            if (!Character.isLetterOrDigit(s.charAt(pre))){ 
                pre++;
                continue;
            }else if(!Character.isLetterOrDigit(s.charAt(post))){
                post--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(pre)) != Character.toLowerCase(s.charAt(post))){
                return false;
            }
            pre++;
            post--;
        }
        return true;
    }
}