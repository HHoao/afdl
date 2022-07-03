package lc_205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author �ƺ�
 *205. ͬ���ַ���
���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�

��� s �е��ַ����԰�ĳ��ӳ���ϵ�滻�õ� t ����ô�������ַ�����ͬ���ġ�

ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���ͬʱ���ı��ַ���˳�򡣲�ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
 */
public class LC_205 {

}
//�ҵĴ���
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smapper = new int[256];
        boolean[] tmapper = new boolean[256];
        Arrays.fill(smapper, -1);
        int n = s.length();
        for (int i = 0; i < n; i++){
            int j = smapper[s.charAt(i)];
            
            if (j == -1 ){
                if (tmapper[t.charAt(i)] == true){
                    return false;
                }
                tmapper[t.charAt(i)] = true;
                smapper[s.charAt(i)] = t.charAt(i);
            }else{
                if (j != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
//�ٷ���ϣ��
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
