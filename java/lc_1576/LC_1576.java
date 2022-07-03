package lc_1576;

/*
 *@author: �ƺ�
 *@date : 2022��1��5��
 *@todo:1576. �滻���е��ʺ�
����һ��������СдӢ����ĸ�� '?' �ַ����ַ��� s�����㽫���е� '?' ת��Ϊ����Сд��ĸ��ʹ���յ��ַ����������κ� �����ظ� ���ַ���

ע�⣺�� ���� �޸ķ� '?' �ַ���

��Ŀ����������֤ �� '?' �ַ� ֮�⣬�����������ظ����ַ���

���������ת������������ת�����󷵻����յ��ַ���������ж������������뷵�������κ�һ��������֤�����ڸ�����Լ�������£������Ǵ��ڵġ�
*/
public class LC_1576 {

}
//�ҵĴ���
class Solution {
    public String modifyString(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        char preChar = '?';
        for (int  i = 0; i < n; i++){
            if (s.charAt(i) == '?'){
                char postChar = i < n - 1 ? s.charAt(i + 1) : '?';
                for (int j = 0; j < 26; j++){
                    char c = (char)(j + 'a');
                    if (c != preChar && c != postChar){
                        sb.append(c);
                        break;
                    }
                }
            }else{
                sb.append(s.charAt(i));
            }
            preChar = sb.charAt(i);
        }
        return sb.toString();
    }  
}
//�ٷ�
class Solution1 {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}