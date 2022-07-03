package lc_1177;

import java.util.ArrayList;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2022��1��12��
 *@todo:1177. �������Ĵ����
����һ���ַ��� s������� s ���Ӵ����м�⡣

ÿ�μ�⣬�����Ӵ������Ա�ʾΪ queries[i] = [left, right, k]�����ǿ��� �������� �Ӵ� s[left], ..., s[right]��������ѡ�� ��� k ���滻���κ�СдӢ����ĸ�� 

����������������У��Ӵ����Ա�ɻ�����ʽ���ַ�������ô�����Ϊ true��������Ϊ false��

���ش����� answer[]������ answer[i] �ǵ� i �������Ӵ� queries[i] �ļ������

ע�⣺���滻ʱ���Ӵ��е�ÿ����ĸ��������Ϊ ������ ����м�����Ҳ����˵����� s[left..right] = "aaa" �� k = 2������ֻ���滻���е�������ĸ�������⣬�κμ�ⶼ�����޸�ԭʼ�ַ��� s��������Ϊÿ�μ�ⶼ�Ƕ����ģ�

 

ʾ����

���룺s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
�����[true,false,false,true,true]
���ͣ�
queries[0] : �Ӵ� = "d"�����ġ�
queries[1] : �Ӵ� = "bc"�����ǻ��ġ�
queries[2] : �Ӵ� = "abcd"��ֻ�滻 1 ���ַ��Ǳ䲻�ɻ��Ĵ��ġ�
queries[3] : �Ӵ� = "abcd"�����Ա�ɻ��ĵ� "abba"�� Ҳ���Ա�� "baab"�������������� "bacd"��Ȼ��� "cd" �滻Ϊ "ab"��
queries[4] : �Ӵ� = "abcda"�����Ա�ɻ��ĵ� "abcba"��
*/
public class LC_1177 {
	public static void main(String[] args) {
		System.out.println(new Solution().canMakePaliQueries("abcda", new int[][] {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
	}
}

//ǰ׺��
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[][] f = new int[n+1][26];
        List<Boolean> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            f[i][s.charAt(i-1) - 'a']++;
            for (int j = 0; j < 26; j++) {
            	f[i][j] += f[i-1][j];
            }
        }
        
        for (int i = 0; i < m; i++){
            int orr = 0;
            for (int j = 0; j < 26; j++){
                if ((f[queries[i][1]+1][j] - f[queries[i][0]][j]) % 2 == 1){
                    orr++;
                }
            }
            ans.add((orr /2) <= queries[i][2]);
        }
        return ans;
    }
}
//״̬ѹ��
class Solution1 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] f = new int[n+1];
        List<Boolean> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            f[i] = f[i -1] ^ (1 << (s.charAt(i-1) - 'a'));
        }
        
        for (int i = 0; i < m; i++){
            int orr = 0;
            int state = f[queries[i][1] + 1] ^ f[queries[i][0]];
            while (state > 0){
                orr += ((state ^ 1) % 2 == 0) ? 1 : 0;
                state >>= 1;
            }
            
            ans.add((orr /2) <= queries[i][2]);
        }
        return ans;
    }
}