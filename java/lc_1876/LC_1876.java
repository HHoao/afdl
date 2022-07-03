package lc_1876;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��2��
 *@todo:
 *1876. ����Ϊ���Ҹ��ַ���ͬ�����ַ���
���һ���ַ����������κ��ظ��ַ������ǳ�����ַ���Ϊ �� �ַ�����

����һ���ַ��� s �����㷵�� s �г���Ϊ 3 �� �����ַ��� ��������

ע�⣬�����ͬ�ĺ����ַ������ֶ�Σ�ÿһ�ζ�Ӧ�ñ������֮�С�

���ַ��� ��һ���ַ������������ַ����С�
*/
public class LC_1876 {

}
//�ҵĴ���
class Solution {
    public int countGoodSubstrings(String s) {
        int k = 3;
        int[] charSets = new int[27];
        Arrays.fill(charSets, -10);
        int l = 0, n = s.length();
        int ans = 0;
        charSets[s.charAt(0) - 97] = 0;
        for (int i = 1; i < n; i++){
            int dis = i - charSets[s.charAt(i) - 97];
            if (dis < k) l = charSets[s.charAt(i) - 97] + 1;
            if (i - l == k) l++;
            if (i - l + 1 == k) ans++;
            charSets[s.charAt(i) - 97] = i;
        }
        return ans;
    }
}