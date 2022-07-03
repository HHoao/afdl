package lc_140;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �ƺ�
 *140. ���ʲ�� II
����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�

˵����

�ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
����Լ����ֵ���û���ظ��ĵ��ʡ�
 */
public class LC_140 {

}
//�ҵĴ���
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        getList(s, wordDict, ans, new StringBuffer());
        return ans;
    }
    public void getList(String s, List<String> wordDict, List<String> ans, StringBuffer sublist){
        if (s.length() == 0) {
            StringBuffer temp = new StringBuffer(sublist);
            temp.delete(sublist.length() - 1, sublist.length());
            ans.add(temp.toString());
            return;
        }
        int n = wordDict.size();
        for (int i =0; i < n; i++){
            String word = wordDict.get(i);
            if (s.startsWith(word)){
                String addWord = word + " ";
                sublist.append(addWord);
                getList(s.substring(word.length()), wordDict, ans, sublist); 
                sublist.delete(sublist.length()- addWord.length(), sublist.length());
            }
        }
    }
}