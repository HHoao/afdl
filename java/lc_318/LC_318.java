package lc_318;

/*
 *@author: �ƺ�
 *@date : 2021��12��14��
 *@todo:318. ��󵥴ʳ��ȳ˻�
����һ���ַ������� words ���ҳ������� length(words[i]) * length(words[j]) �����ֵ���������������ʲ����й�����ĸ������������������������ʣ����� 0 ��
*/
public class LC_318 {

}
//λ����
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitMap = new int[n];
        for (int i = 0; i < n; i++){
            int b = 0;
            char[] s = words[i].toCharArray();
            for (char ch : s){
                b |= 1 << (ch - 'a'); 
            }
            bitMap[i] = b;
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if ((bitMap[i] & bitMap[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}