package lc_383;

/*
 *@author: �ƺ�
 *@date : 2021��12��17��
 *@todo:383. �����
���������ַ�����ransomNote �� magazine ���ж� ransomNote �ܲ����� magazine ������ַ����ɡ�

������ԣ����� true �����򷵻� false ��

magazine �е�ÿ���ַ�ֻ���� ransomNote ��ʹ��һ�Ρ�
*/
public class LC_383 {

}
//����
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words1 = new int[26];
        int[] words2 = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        for (int i = 0; i < n; i++){
            words1[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++){
            words2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (words1[i] > words2[i]) return false;
        }
        return true;
    }
}
class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words1 = new int[26];
        int[] words2 = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        
        for (int i = 0; i < m; i++){
            words2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++){
            int k = ransomNote.charAt(i) - 'a';
            words1[k]++;
            if (words1[k] > words2[k]) return false;
        }
        return true;
    }
}