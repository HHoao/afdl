package lc_1332;

/*
 *@author: �ƺ�
 *@date : 2022��1��22��
 *@todo:1332. ɾ������������
����һ���ַ��� s����������ĸ 'a' �� 'b' ��ɡ�ÿһ��ɾ�����������Դ� s ��ɾ��һ������ �����С�

����ɾ�������ַ����������ַ����ַ���Ϊ�գ�����Сɾ��������

�������С����壺���һ���ַ�������ͨ��ɾ��ԭ�ַ���ĳЩ�ַ������ı�ԭ�ַ�˳��õ�����ô����ַ�������ԭ�ַ�����һ�������С�

�����ġ����壺���һ���ַ���������ǰ����һ�µģ���ô����ַ�������һ�����ġ�

 

ʾ�� 1��

���룺s = "ababa"
�����1
���ͣ��ַ���������ǻ������У�ֻ��Ҫɾ��һ�Ρ�
ʾ�� 2��

���룺s = "abb"
�����2
���ͣ�"abb" -> "bb" -> "". 
��ɾ������������ "a"��Ȼ����ɾ�� "bb"��
*/
public class LC_1332 {

}
//���
class Solution {
    public int removePalindromeSub(String s) {
        return new StringBuilder(s).reverse().toString().equals(s)?1:2;
    }
}
//������Ŀ
/*
 * ���Ӧ����
 * 1332. ɾ������������
����һ���ַ��� s��ɡ�ÿһ��ɾ�����������Դ� s ��ɾ��һ������ �����С�

����ɾ�������ַ����������ַ����ַ���Ϊ�գ�����Сɾ��������

������������]

�����ġ����壺���һ���ַ���������ǰ����һ�µģ���ô����ַ�������һ�����ġ�
 */
class Solution1 {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] param = new boolean[n][n];
        for (int i = 0; i < n; i++){
            param[i][i] = true;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            for (int j = n - i - 1; j >= 0; j--){
                param[j][j + i] = s.charAt(j) == s.charAt(j + i);
                param[j+i][j] = param[j][j + i];
                if (param[j][j+i]){
                    param[j][j + i] = param[j + 1][j + i - 1];
                    param[j+i][j] = param[j][j + i];
                }
                if (param[j][j + i]){
                    dp[j][j + i] = 1;
                }else{
                    for (int k = 0; k < i; k++){
                        dp[j][j + i] = Math.min(dp[j][j+i], dp[j][j+k] + dp[j+k+1][j+i]);
                    }
                }
                if (i == n - 1){
                    ans = Math.min(dp[j][j+i], ans);
                }
            }
        }
        return ans;
    }
}
