package lc_316;

/*
 *@author: �ƺ�
 *@date : 2021��12��13��
 *@todo:316. ȥ���ظ���ĸ
����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ��豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���

ע�⣺������ 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters ��ͬ
*/
public class LC_316 {

}
//����ջ + ̰��
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] nums = new int[26];
        boolean[] vis = new boolean[26];
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++){
            nums[arr[i] - 'a']++;
        }
        for (int i = 0; i < n; i++){
            if (!vis[arr[i] - 'a']){
                if (sb.length() > 0 && arr[i] < sb.charAt(sb.length() - 1)){
                    while (sb.length() > 0 && arr[i] < sb.charAt(sb.length() - 1)
                    && nums[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                sb.append(arr[i]);
                vis[arr[i] - 'a'] = true;
            }
            nums[arr[i] - 'a']--;
        }
        return sb.toString();
    }
}