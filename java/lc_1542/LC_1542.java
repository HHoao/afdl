package lc_1542;

import java.util.Arrays;
import java.util.HashMap;

/*
 *@author: �ƺ�
 *@date : 2021��12��19��
 *@todo:1542. �ҳ���ĳ������ַ���
����һ���ַ��� s ���뷵�� s ����� �������ַ��� �ĳ��ȡ�

���������ַ�����������������������������

���ַ����� s ��һ���ǿ����ַ���
��������������ַ������󣬸��ַ������Ա��һ�������ַ���
*/
public class LC_1542 {

}
//����(��ʱ)
class Solution {
    private boolean isPalindromic(String str, int l, int r){
        int[] cs = new int[10];
        for (int i = l; i <= r; i++){
            cs[str.charAt(i) - '0']++;
        }
        boolean vis = false;
        for (int j = 0; j < 10; j++){
            if (cs[j] % 2 == 1){
                if (!vis){
                    vis = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public int longestAwesome(String s) {
        int n = s.length();
        for (int i = n - 1; i > 0; i--){
            for (int j = 0; j+i < n; j++){
                if (isPalindromic(s, j, j+i)){
                    return i+1;
                }
            }
        }
        return s == "" ? 0 : 1;
    }
}
//ǰ׺��+״̬ѹ��
class Solution1 {
    public int longestAwesome(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cur=0;  //״̬
        int ans=1;  //��¼��
        map.put(cur,-1); 
        for(int c=0;c<s.length();c++){
            int ch=s.charAt(c)-'0';
            //����
            cur=cur^(1<<ch);
            //һ�����ֳ��������Σ��������ż����
            for(int i=0;i<10;i++){
                int next=cur^(1<<i);
                if(map.containsKey(next)){
                    ans=Math.max(ans,c-map.get(next));
                }
            }
            //���ж�������ż����
            if(!map.containsKey(cur)){
                map.put(cur,c);
            }else{
                ans=Math.max(ans,c-map.get(cur));
            }
        }
        return ans;
    }
}
//��̬�滮
class Solution2 {
    public int longestAwesome(String s) {
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int pre = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = pre ^ (1 << (s.charAt(i) - '0'));
            dp[pre] = Math.min(dp[pre], i);
            for (int j = 0; j < 10; j++) {
                int target = 1 << j;
                res = Math.max(res, i - dp[pre ^ target]);
            }
            res = Math.max(res, i - dp[pre]);
        }
        return res;
    }
}