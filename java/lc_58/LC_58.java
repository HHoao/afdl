package lc_58;

/**
 * @author �ƺ�
 *58. ���һ�����ʵĳ���
����һ���ַ��� s�������ɵ�����ɣ�����֮���ÿո�����������ַ��������һ�����ʵĳ��ȡ�������������һ�����ʣ��뷵�� 0 ��

���� ��ָ������ĸ��ɡ��������κοո��ַ���������ַ�����
 */
public class LC_58 {

}
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}